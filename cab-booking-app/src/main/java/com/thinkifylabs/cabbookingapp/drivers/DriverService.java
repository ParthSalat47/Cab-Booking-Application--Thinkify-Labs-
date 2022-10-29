package com.thinkifylabs.cabbookingapp.drivers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
    
    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public boolean add_driver_service(DriverClass newDriver)
    {
        return driverRepository.add_driver_repository(newDriver);
    }

    public boolean update_driverLocation_service(DriverClass newDriver)
    {
        //If phone number isn't in database
        if(driverRepository.check_phone_number(newDriver.getDriverPhoneNumber()) == false)
            return false;
        
        return driverRepository.update_driverLocation_repository(newDriver);
    }

    public boolean change_driver_status_service(DriverClass newDriver)
    {
        //If phone number isn't in database
        if(driverRepository.check_phone_number(newDriver.getDriverPhoneNumber()) == false)
            return false;

        return driverRepository.change_driver_status_repository(newDriver);
    }

    public ArrayList<String> find_total_earning_service()
    {
        ArrayList<String> totalEarnings = new ArrayList<String>();

        for(DriverClass driver : driverRepository.getDriversList())
        {
            String earning = driver.getDriverName() + " earned " + driver.getDriverEarning();

            totalEarnings.add(earning);
        }

        return totalEarnings;
    }
}
