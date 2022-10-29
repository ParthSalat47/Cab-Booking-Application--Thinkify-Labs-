package com.thinkifylabs.cabbookingapp.rides;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkifylabs.cabbookingapp.UtilityMethods;
import com.thinkifylabs.cabbookingapp.drivers.DriverRepository;
import com.thinkifylabs.cabbookingapp.users.UserRepository;

@Service
public class RidesService {

    // private final RidesRepository ridesRepository;

    // @Autowired
    // public RidesService(RidesRepository ridesRepository) {
    //     this.ridesRepository = ridesRepository;
    // }
 
    private final UserRepository userRepository;
    private final DriverRepository driverRepository;

    @Autowired
    public RidesService(UserRepository userRepository, DriverRepository driverRepository) {
        this.userRepository = userRepository;
        this.driverRepository = driverRepository;
    }

    public boolean find_ride_service()
    {
        System.out.println("\nEnter your phone number:");
        long userPhoneNumber = UtilityMethods.longInput();

        //If phone number isn't in database
        if(userRepository.check_phone_number(userPhoneNumber) == false)
            return false;

        System.out.println(driverRepository.getDriversList());
        return true;
    }

}
