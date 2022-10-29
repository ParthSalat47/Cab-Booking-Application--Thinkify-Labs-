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
        System.out.println("\nEnter your name:");
        String userName = UtilityMethods.stringInput();
        
        System.out.println("\nEnter your phone number:");
        long userPhoneNumber = UtilityMethods.longInput();
        
        System.out.println("\nEnter the x-coordinate of your address:");
        long xCoordinate = UtilityMethods.longInput();

        System.out.println("\nEnter the y-coordinate of your address:");
        long yCoordinate = UtilityMethods.longInput();

        UserClass newUser = new UserClass(userName, userPhoneNumber, xCoordinate, yCoordinate);
        
        return userRepository.add_user_repository(newUser);
    }

    public boolean update_user_service()
    {
        System.out.println("\nEnter your phone number:");
        long userPhoneNumber = UtilityMethods.longInput();
        
        //If phone number isn't in database
        if(userRepository.check_phone_number(userPhoneNumber) == false)
            return false;

        System.out.println("\nEnter your new name:");
        String userNewName = UtilityMethods.stringInput();

        System.out.println("\nEnter your new phone number:"); 
        long userNewPhoneNumber = UtilityMethods.longInput();
        
        return userRepository.update_user_repository(userPhoneNumber, userNewName, userNewPhoneNumber);
    }


}
