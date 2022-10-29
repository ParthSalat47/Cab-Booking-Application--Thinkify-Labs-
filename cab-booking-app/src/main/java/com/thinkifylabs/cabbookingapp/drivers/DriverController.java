package com.thinkifylabs.cabbookingapp.drivers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String add_driver_controller(@RequestParam String driverName, @RequestParam String driverGender, 
        @RequestParam long driverAge, @RequestParam long driverPhoneNumber, 
        @RequestParam String vehicleDetails, @RequestParam long xCoordinate, 
        @RequestParam long yCoordinate, @RequestParam boolean available)
    {
        DriverClass newDriver = new DriverClass(driverName, driverPhoneNumber, driverGender, driverAge, vehicleDetails, xCoordinate, yCoordinate, available);

        if(driverService.add_driver_service(newDriver))
            return "\nDriver added successfully!";
        else
            return "\nFailed to add driver! Please try again later.";        
    }

    @GetMapping(path = "update_driverLocation")
    public void update_driverLocation_controller()
    {
        if(driverService.update_driverLocation_service())
            System.out.println("\nDriver location updated successfully!");
        else
            System.out.println("\nThis driver doesn't exist. Please add the driver first.");        
    }

    @GetMapping(path = "change_driver_status")
    public void change_driver_status_controller()
    {
        if(driverService.change_driver_status_service())
            System.out.println("\nDriver status changed successfully!");
        else
            System.out.println("\nThis driver doesn't exist. Please add the driver first.");        
    }



}
