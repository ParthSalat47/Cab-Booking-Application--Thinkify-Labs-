package com.thinkifylabs.cabbookingapp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean add_user_service(UserClass newUser)
    {   
        return userRepository.add_user_repository(newUser);
    }

    public boolean update_user_service(long userPhoneNumber, UserClass newUser)
    {
        //If phone number isn't in database
        if(userRepository.check_phone_number(userPhoneNumber) == false)
            return false;

        return userRepository.update_user_repository(userPhoneNumber, newUser);
    }

    public boolean update_userLocation_service(UserClass newUser)
    {
        //If phone number isn't in database
        if(userRepository.check_phone_number(newUser.getUserPhoneNumber()) == false)
            return false;

        return userRepository.update_userLocation_repository(newUser);
    }


    
}
