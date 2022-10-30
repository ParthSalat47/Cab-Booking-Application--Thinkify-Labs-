package com.thinkifylabs.cabbookingapp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkifylabs.cabbookingapp.model.DriverClass;
import com.thinkifylabs.cabbookingapp.model.RideClass;
import com.thinkifylabs.cabbookingapp.model.UserClass;
import com.thinkifylabs.cabbookingapp.repository.DriverRepository;
import com.thinkifylabs.cabbookingapp.repository.UserRepository;

@Service
public class RideService {
 
    private final UserRepository userRepository;
    private final DriverRepository driverRepository;
    
    private long travelDistance;
    private long destXCoordinate;
    private long destYCoordinate;

    @Autowired
    public RideService(UserRepository userRepository, DriverRepository driverRepository) {
        this.userRepository = userRepository;
        this.driverRepository = driverRepository;
    }

    //Returns list of drivers within 5 units distance and who are available
    public ArrayList<DriverClass> find_ride_service(RideClass newRide)
    {
        //If phone number isn't in database
        if(userRepository.check_phone_number(newRide.getUserPhoneNumber()) == false)
            return null;

        //User's current location will be this ride's source coordinates
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
        ArrayList<DriverClass> nearbyDriversList = new ArrayList<DriverClass>();

        for(DriverClass driver : driversList)
        {
            long driverDistance = calculateDistance(driver.getxCoordinate(), driver.getyCoordinate(), newRide.getSourceXCoordinate(), newRide.getSourceYCoordinate());

            if(driver.getavailable() && driverDistance <= 5)
            {
                nearbyDriversList.add(driver);
            }
        }

        // System.out.println(driverRepository.getDriversList());
        // System.out.println(userRepository.getUsersList());

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
    public boolean choose_ride_service(RideClass newRide)
    {
        //Pay the driver and update his current location
        for(DriverClass driver : driverRepository.getDriversList())
        {
            if(driver.getDriverPhoneNumber() == newRide.getDriverPhoneNumber())
            {
                driver.setDriverEarning(driver.getDriverEarning() + travelDistance);
                driver.setxCoordinate(destXCoordinate);
                driver.setyCoordinate(destYCoordinate);
            }
        }

        //Bill the user and update his current location
        for(UserClass user : userRepository.getUsersList())
        {
            if(user.getUserPhoneNumber() == newRide.getUserPhoneNumber())
            {
                user.setUserBillDue(travelDistance);
                user.setxCoordinate(destXCoordinate);
                user.setyCoordinate(destYCoordinate);
            }
        }
        
        // System.out.println(driverRepository.getDriversList());
        // System.out.println(userRepository.getUsersList());

        return true;
    }

    //Calculates bill and ends the ride
    public long calculateBill_service(long userPhoneNumber)
    {
        for(UserClass user : userRepository.getUsersList())
        {
            if(user.getUserPhoneNumber() == userPhoneNumber)
            {
                return user.getUserBillDue();
            }
        }

        return 0;
    }

}
