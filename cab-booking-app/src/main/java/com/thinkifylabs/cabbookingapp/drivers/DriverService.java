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

        System.out.println("\nEnter your availability (true or false):");
        boolean available = UtilityMethods.booleanInput();

        DriverClass newDriver = new DriverClass(driverName, driverPhoneNumber, driverGender, driverAge, vehicleDetails, xCoordinate, yCoordinate, available);
        
        return driverRepository.add_driver_repository(newDriver);
    }

    public boolean update_driverLocation_service()
    {
        System.out.println("\nEnter your phone number:");
        long driverPhoneNumber = UtilityMethods.longInput();
        
        //If phone number isn't in database
        if(driverRepository.check_phone_number(driverPhoneNumber) == false)
            return false;

        System.out.println("\nEnter your new xCoordinate:");
        long xCoordinate = UtilityMethods.longInput();

        System.out.println("\nEnter your new yCoordinate:"); 
        long yCoordinate = UtilityMethods.longInput();
        
        return driverRepository.update_driverLocation_repository(driverPhoneNumber, xCoordinate, yCoordinate);
    }

    public boolean change_driver_status_service()
    {
        System.out.println("\nEnter your phone number:");
        long driverPhoneNumber = UtilityMethods.longInput();
        
        //If phone number isn't in database
        if(driverRepository.check_phone_number(driverPhoneNumber) == false)
            return false;

        System.out.println("\nEnter your updated status:");
        boolean available = UtilityMethods.booleanInput();
    
        return driverRepository.change_driver_status_repository(driverPhoneNumber, available);
    }
}
