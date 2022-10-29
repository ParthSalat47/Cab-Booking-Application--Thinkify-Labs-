package com.thinkifylabs.cabbookingapp.rides;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "rides")
public class RidesController {

    private final RidesService ridesService;

    @Autowired
    public RidesController(RidesService ridesService) {
        this.ridesService = ridesService;
    }

    @GetMapping(path = "find_ride")
    public String find_ride()
    {
        return "postman donkey";

        // if(ridesService.find_ride_service())
        //     System.out.println("\nDriver status changed successfully!");
        // else
        //     System.out.println("\nThis user doesn't exist. Please add the user first.");        
    }

    

}
