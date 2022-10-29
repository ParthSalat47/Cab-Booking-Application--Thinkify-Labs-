package com.thinkifylabs.cabbookingapp.drivers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkifylabs.cabbookingapp.UtilityMethods;

@Service
public class DriverService {
    
    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public boolean add_driver_service()
    {
        System.out.println("\nEnter your name:");
        String driverName = UtilityMethods.stringInput();
        
        System.out.println("\nEnter your gender:");
        String driverGender = UtilityMethods.stringInput();

        System.out.println("\nEnter your age:");
        long driverAge = UtilityMethods.longInput();

        System.out.println("\nEnter your phone number:");
        long driverPhoneNumber = UtilityMethods.longInput();
        
        System.out.println("\nEnter your vehicle name and number:");
        String vehicleDetails = UtilityMethods.stringInput();

        System.out.println("\nEnter the x-coordinate of your current location:");
        long xCoordinate = UtilityMethods.longInput();

        System.out.println("\nEnter the y-coordinate of your current location:");
        long yCoordinate = UtilityMethods.longInput();

        DriverClass newDriver = new DriverClass(driverName, driverPhoneNumber, driverGender, driverAge, vehicleDetails, xCoordinate, yCoordinate);
        
        return driverRepository.add_driver_repository(newDriver);
    }


}
