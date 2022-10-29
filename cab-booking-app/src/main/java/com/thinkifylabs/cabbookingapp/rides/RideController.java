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
        //Ignore the source coordinates because the user's current location will be the source of the ride (according to requirements file)
        RideClass newRide = new RideClass(userPhoneNumber, 0, 0, 0, destXCoordinate, destYCoordinate, 0);

        return ridesService.find_ride_service(newRide);
    }

    @GetMapping(path = "choose_ride")
    public String choose_ride(@RequestParam long userPhoneNumber, @RequestParam long driverPhoneNumber)
    {
        RideClass newRide = new RideClass(userPhoneNumber, driverPhoneNumber, 0, 0, 0, 0, 0);

        if(ridesService.choose_ride_service(newRide))
            return "Ride has started.";
        else 
            return "Could not start ride. Please try again later.";
    }

    

}
