package com.thinkifylabs.cabbookingapp.drivers;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class DriverRepository {
    
    private ArrayList<DriverClass> driversList = new ArrayList<DriverClass>();

    public boolean add_driver_repository(DriverClass newDriver)
    {
        return driversList.add(newDriver);
    }


}
