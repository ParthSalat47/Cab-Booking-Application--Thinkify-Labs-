package com.thinkifylabs.cabbookingapp.service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.thinkifylabs.cabbookingapp.exceptionHandling.CustomException;
import com.thinkifylabs.cabbookingapp.model.DriverClass;
import com.thinkifylabs.cabbookingapp.model.RideClass;
import com.thinkifylabs.cabbookingapp.model.UserClass;
import com.thinkifylabs.cabbookingapp.repository.DriverRepository;
import com.thinkifylabs.cabbookingapp.repository.UserRepository;

@Service
public class RideService {
 
    private final UserRepository userRepository;
    private final DriverRepository driverRepository;
    
    private ArrayList<DriverClass> nearbyDriversList = new ArrayList<DriverClass>();
    private long travelDistance = Long.MIN_VALUE;
    private long destXCoordinate;
    private long destYCoordinate;

    @Autowired
    public RideService(UserRepository userRepository, DriverRepository driverRepository) throws NoSuchElementException{
        this.userRepository = userRepository;
        this.driverRepository = driverRepository;
    }

    //Returns list of drivers within 5 units distance and who are available
    public ArrayList<DriverClass> find_ride_service(RideClass newRide) throws Exception
    {
        //If phone number isn't in database
        if(userRepository.check_phone_number(newRide.getUserPhoneNumber()) == false)
            throw new CustomException(HttpStatus.NOT_FOUND, "User not registered. Please add user before starting a ride.");

        //User's current location will be this ride's source coordinates (acc. to requirements)
        for(UserClass user : userRepository.getUsersList())
        {
            if(user.getUserPhoneNumber() == newRide.getUserPhoneNumber())
            {
                newRide.setSourceXCoordinate(user.getxCoordinate());
                newRide.setSourceYCoordinate(user.getyCoordinate());
            }
        }

        //Save travelDistance to calculate bill in choose_ride_service later
        travelDistance = calculateDistance(newRide.getSourceXCoordinate(), newRide.getSourceYCoordinate(), 
            newRide.getDestXCoordinate(), newRide.getDestYCoordinate());

        //Save destination coordinates for use in choose_ride_service later 
        destXCoordinate = newRide.getDestXCoordinate();
        destYCoordinate = newRide.getDestYCoordinate();

        ArrayList<DriverClass> driversList = driverRepository.getDriversList();
        
        //Clear the existing nearbyDriversList, because a new find_ride request was made
        nearbyDriversList.clear();

        for(DriverClass driver : driversList)
        {
            long driverDistance = calculateDistance(driver.getxCoordinate(), driver.getyCoordinate(), newRide.getSourceXCoordinate(), newRide.getSourceYCoordinate());

            if(driver.getavailable() && driverDistance <= 5)
            {
                nearbyDriversList.add(driver);
            }
        }

        return nearbyDriversList;
    }

    //Calculates distance between 2 points in 2 dimensions
    public long calculateDistance(long sourceXCoordinate, long sourceYCoordinate, 
        long destXCoordinate, long destYCoordinate)
    {
        long xDistance = (long) Math.pow(sourceXCoordinate - destXCoordinate, 2);
        long yDistance = (long) Math.pow(sourceYCoordinate - destYCoordinate, 2);
        
        return (long) Math.sqrt(xDistance + yDistance);
    }

    //Begins the ride
    public void choose_ride_service(RideClass newRide) throws Exception
    {
        //If user is choose_ride before find_ride, throw exception
        if(travelDistance == Long.MIN_VALUE)
        {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Please use find_ride functionality before choose_ride.");
        }
        
        boolean driverPhoneNumberFound = false;
        boolean userPhoneNumberFound = false;

        //Pay the driver and update his current location
        for(DriverClass driver : nearbyDriversList)
        {
            if(driver.getDriverPhoneNumber() == newRide.getDriverPhoneNumber())
            {
                //Money will be 'added' to the driver's earnings
                driver.setDriverEarning(driver.getDriverEarning() + travelDistance);
                driver.setxCoordinate(destXCoordinate);
                driver.setyCoordinate(destYCoordinate);
                driverPhoneNumberFound = true;
            }
        }

        //Bill the user and update his current location
        for(UserClass user : userRepository.getUsersList())
        {
            if(user.getUserPhoneNumber() == newRide.getUserPhoneNumber())
            {
                //The user is expected to have cleared his past due bills.
                user.setUserBillDue(travelDistance);
                user.setxCoordinate(destXCoordinate);
                user.setyCoordinate(destYCoordinate);
                userPhoneNumberFound = true;
            }
        }

        //reset travelDistance so that user will HAVE to find_ride before choose_ride (because nearbyDriversList would only then be populated)
        travelDistance = Long.MIN_VALUE;

        //Possible exceptions 
        if(driverPhoneNumberFound == false)
        {
            //He may also not be registered
            throw new CustomException(HttpStatus.NOT_FOUND, "This driver is either not in the available state or is more than 5 units away.");
        }
        if(userPhoneNumberFound == false)
        {
            throw new CustomException(HttpStatus.NOT_FOUND, "This user is not registered. Please add user before choosing a ride.");
        }
        
    }

    //Calculates bill and ends the ride
    public long calculateBill_service(long userPhoneNumber) throws Exception
    {
        for(UserClass user : userRepository.getUsersList())
        {
            if(user.getUserPhoneNumber() == userPhoneNumber)
            {
                return user.getUserBillDue();
            }
        }

        //If user was not found in repository, throw exception
        throw new CustomException(HttpStatus.NOT_FOUND, "This user is not registered. Please add user before calculating bill.");
    }

}
