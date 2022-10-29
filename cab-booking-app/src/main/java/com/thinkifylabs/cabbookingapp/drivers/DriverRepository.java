package com.thinkifylabs.cabbookingapp.drivers;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class DriverRepository {
    
    private ArrayList<DriverClass> driversList = new ArrayList<DriverClass>();

    //Getters and Setters
    public ArrayList<DriverClass> getDriversList() {
        return driversList;
    }

    public void setDriversList(ArrayList<DriverClass> driversList) {
        this.driversList = driversList;
    }
    //--------------------

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
        //System.out.println(newDriver);
        return driversList.add(newDriver);
    }

    public boolean update_driverLocation_repository(DriverClass newDriver)
    {
        for(DriverClass driver : driversList)
        {
            if(driver.getDriverPhoneNumber() == newDriver.getDriverPhoneNumber())
            {
                driver.setxCoordinate(newDriver.getxCoordinate());
                driver.setyCoordinate(newDriver.getyCoordinate());
                //System.out.println(driversList);
                return true;
            }
        }

        //In case of updation failure,
        return false;
    }

    public boolean change_driver_status_repository(DriverClass newDriver)
    {
        for(DriverClass driver : driversList)
        {
            if(driver.getDriverPhoneNumber() == newDriver.getDriverPhoneNumber())
            {
                driver.setavailable(newDriver.getavailable());
                //System.out.println(driversList);
                return true;
            }
        }

        //In case of updation failure,
        return false;
    }

    

    


}   
