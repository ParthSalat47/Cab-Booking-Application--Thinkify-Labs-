package com.thinkifylabs.cabbookingapp.rides;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkifylabs.cabbookingapp.drivers.DriverClass;
import com.thinkifylabs.cabbookingapp.drivers.DriverRepository;
import com.thinkifylabs.cabbookingapp.users.UserRepository;

@Service
public class RideService {

    // private final RidesRepository ridesRepository;

    // @Autowired
    // public RidesService(RidesRepository ridesRepository) {
    //     this.ridesRepository = ridesRepository;
    // }
 
    private final UserRepository userRepository;
    private final DriverRepository driverRepository;

    @Autowired
    public RideService(UserRepository userRepository, DriverRepository driverRepository) {
        this.userRepository = userRepository;
        this.driverRepository = driverRepository;
    }

    public ArrayList<DriverClass> find_ride_service(RideClass newRide)
    {
        //If phone number isn't in database
        if(userRepository.check_phone_number(newRide.getUserPhoneNumber()) == false)
            return null;

        ArrayList<DriverClass> driversList = driverRepository.getDriversList();
        ArrayList<DriverClass> nearbyDriversList = new ArrayList<DriverClass>();

        for(DriverClass driver : driversList)
        {
            long driverDistance = calculateDistance(driver.getxCoordinate(), driver.getyCoordinate(), newRide.getSourceXCoordinate(), newRide.getSourceYCoordinate());

            if(driver.getavailable() && driverDistance < 5)
            {
                nearbyDriversList.add(driver);
            }
        }

        return nearbyDriversList;
    }

    public long calculateDistance(long driverXCoordinate, long driverYCoordinate, 
        long userXCoordinate, long userYCoordinate)
    {
        long xDistance = (long) Math.pow(driverXCoordinate - userXCoordinate, 2);
        long yDistance = (long) Math.pow(driverYCoordinate - userYCoordinate, 2);
        
        return (long) Math.sqrt(xDistance + yDistance);
    }

}
