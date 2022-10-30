package com.thinkifylabs.cabbookingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.thinkifylabs.cabbookingapp.exceptionHandling.CustomException;
import com.thinkifylabs.cabbookingapp.model.UserClass;
import com.thinkifylabs.cabbookingapp.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean add_user_service(UserClass newUser) throws Exception
    {   
        if(userRepository.check_phone_number(newUser.getUserPhoneNumber()))
            throw new CustomException(HttpStatus.BAD_REQUEST, "A user already exists with the given phone number.");

        //Else, add this user.
        return userRepository.add_user_repository(newUser);
    }

    public boolean update_user_service(long userPhoneNumber, UserClass newUser) throws Exception
    {
        //If phone number isn't in database
        if(userRepository.check_phone_number(userPhoneNumber) == false)
            return false;

        //Check if the new phone number has already been taken up
        if(userRepository.check_phone_number(newUser.getUserPhoneNumber()))
            throw new CustomException(HttpStatus.BAD_REQUEST, "A user already exists with the phone number: " + newUser.getUserPhoneNumber());

        //Else, update the phone number
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
