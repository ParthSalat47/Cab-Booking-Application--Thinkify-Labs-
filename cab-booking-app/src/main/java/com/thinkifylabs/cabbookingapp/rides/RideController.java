package com.thinkifylabs.cabbookingapp.rides;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkifylabs.cabbookingapp.drivers.DriverClass;

@RestController
@RequestMapping(path = "rides")
public class RideController {

    private final RideService ridesService;

    @Autowired
    public RideController(RideService ridesService) {
        this.ridesService = ridesService;
    }

    @GetMapping(path = "find_ride")
    public ArrayList<DriverClass> find_ride(@RequestParam long userPhoneNumber, @RequestParam long sourceXCoordinate, @RequestParam long sourceYCoordinate, @RequestParam long destXCoordinate, @RequestParam long destYCoordinate)
    {
        RideClass newRide = new RideClass(userPhoneNumber, 0, sourceXCoordinate, sourceYCoordinate, destXCoordinate, destYCoordinate, 0);

        return ridesService.find_ride_service(newRide);
    }

    

}
