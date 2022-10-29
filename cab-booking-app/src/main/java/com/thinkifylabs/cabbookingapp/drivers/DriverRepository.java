package com.thinkifylabs.cabbookingapp.drivers;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class DriverRepository {
    
    private ArrayList<DriverClass> driversList = new ArrayList<DriverClass>();

    public boolean check_phone_number(long driverPhoneNumber)
    {
        for(DriverClass driver : driversList)
        {
            if(driver.getDriverPhoneNumber() == driverPhoneNumber)
                return true;
        }
        //If phone number doesn't exist in database
        return false;
    }

    public boolean add_driver_repository(DriverClass newDriver)
    {
        return driversList.add(newDriver);
    }

    public boolean update_driverLocation_repository(long driverPhoneNumber, long xCoordinate, long yCoordinate)
    {
        for(DriverClass driver : driversList)
        {
            if(driver.getDriverPhoneNumber() == driverPhoneNumber)
            {
                driver.setxCoordinate(xCoordinate);
                driver.setyCoordinate(yCoordinate);
                return true;
            }
        }

        //Debug
        //System.out.println(driversList);

        //In case of updation failure,
        return false;
    }

    public boolean change_driver_status_repository(long driverPhoneNumber, boolean available)
    {
        for(DriverClass driver : driversList)
        {
            if(driver.getDriverPhoneNumber() == driverPhoneNumber)
            {
                driver.setavailable(available);
                return true;
            }
        }

        //Debug
        //System.out.println(driversList);

        //In case of updation failure,
        return false;
    }


}   
