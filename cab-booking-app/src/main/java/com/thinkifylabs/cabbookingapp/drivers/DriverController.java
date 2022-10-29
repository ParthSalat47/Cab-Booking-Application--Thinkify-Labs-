package com.thinkifylabs.cabbookingapp.drivers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "drivers")
public class DriverController {
    
    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping(path = "add_driver")
    public void add_driver_controller()
    {
        if(driverService.add_driver_service())
            System.out.println("\nDriver added successfully!");
        else
            System.out.println("\nFailed to add driver! Please try again later.");        
    }

    @GetMapping(path = "update_driverLocation")
    public void update_driverLocation_controller()
    {
        if(driverService.update_driverLocation_service())
            System.out.println("\nDriver location updated successfully!");
        else
            System.out.println("\nThis driver doesn't exist. Please add the driver first.");        
    }


}
