package com.thinkifylabs.cabbookingapp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkifylabs.cabbookingapp.UtilityMethods;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean add_user_service()
    {
        System.out.println("Enter your name:\n");
        String userName = UtilityMethods.stringInput();
        
        System.out.println("Enter your phone number:\n");
        long userPhoneNumber = UtilityMethods.longInput();
        
        System.out.println("Enter the x-coordinate of your address:\n");
        long xCoordinate = UtilityMethods.longInput();

        System.out.println("Enter the y-coordinate of your address:\n");
        long yCoordinate = UtilityMethods.longInput();

        UserClass newUser = new UserClass(userName, userPhoneNumber, xCoordinate, yCoordinate);
        
        return userRepository.add_user_repository(newUser);
    }

    

}
