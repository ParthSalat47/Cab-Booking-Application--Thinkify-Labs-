package com.thinkifylabs.cabbookingapp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkifylabs.cabbookingapp.model.DriverClass;
import com.thinkifylabs.cabbookingapp.service.DriverService;

@RestController
@RequestMapping(path = "drivers")
public class DriverController {
    
    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping(path = "add_driver")
    public String add_driver_controller(@RequestParam String driverName, @RequestParam String driverGender, 
        @RequestParam long driverAge, @RequestParam long driverPhoneNumber, 
        @RequestParam String vehicleDetails, @RequestParam long xCoordinate, 
        @RequestParam long yCoordinate, @RequestParam boolean available, @RequestParam long driverEarning) throws Exception
    {
        DriverClass newDriver = new DriverClass(driverName, driverPhoneNumber, driverGender, driverAge, vehicleDetails, xCoordinate, yCoordinate, available, driverEarning);

        if(driverService.add_driver_service(newDriver))
            return "\nDriver added successfully!";
        else
            return "\nFailed to add driver! Please try again later.";        
    }

    @GetMapping(path = "update_driverLocation")
    public String update_driverLocation_controller(@RequestParam long driverPhoneNumber, @RequestParam long xCoordinate, 
    @RequestParam long yCoordinate)
    {
        DriverClass newDriver = new DriverClass("", driverPhoneNumber, "", 0, "", xCoordinate, yCoordinate, false, 0);

        if(driverService.update_driverLocation_service(newDriver))
            return "\nDriver location updated successfully!";
        else
            return "\nThis driver doesn't exist. Please add the driver first.";        
    }

    @GetMapping(path = "change_driver_status")
    public String change_driver_status_controller(@RequestParam long driverPhoneNumber, @RequestParam boolean available)
    {
        DriverClass newDriver = new DriverClass("", driverPhoneNumber, "", 0, "", 0, 0, available, 0);

        if(driverService.change_driver_status_service(newDriver))
            return "\nDriver status changed successfully!";
        else
            return "\nThis driver doesn't exist. Please add the driver first.";        
    }

    @GetMapping(path = "find_total_earning")
    public ArrayList<String> find_total_earning_controller()
    {
        return driverService.find_total_earning_service();
    }

}
