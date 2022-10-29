package com.thinkifylabs.cabbookingapp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "users")
public class UserController {

    private final UserService userService;

    //Constructor
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "add_user")
    public void add_user_controller()
    {
        if(userService.add_user_service())
            System.out.println("\nUser added successfully!");
        else
            System.out.println("\nFailed to add user! Please try again later.");        
    }

    @GetMapping(path = "update_user")
    public void update_user_controller()
    {
        if(userService.update_user_service())
            System.out.println("\nUser details updated successfully!");
        else
            System.out.println("\nThis user doesn't exist. Please add the user first.");        
    }

    @GetMapping(path = "update_userLocation")
    public void update_userLocation_controller()
    {
        if(userService.update_userLocation_service())
            System.out.println("\nUser location updated successfully!");
        else
            System.out.println("\nThis user doesn't exist. Please add the user first.");        
    }

    

}
