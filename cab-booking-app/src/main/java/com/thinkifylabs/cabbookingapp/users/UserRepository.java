package com.thinkifylabs.cabbookingapp.users;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class UserRepository{
    
    private ArrayList<UserClass> usersList = new ArrayList<UserClass>();

    public boolean add_user_repository(UserClass newUser)
    {
        return usersList.add(newUser);
    }

    public boolean update_user_repository(long userPhoneNumber, String userNewName, 
        long userNewPhoneNumber)
    {
        for(UserClass user : usersList)
        {
            if(user.getUserPhoneNumber() == userPhoneNumber)
            {
                user.setUserName(userNewName);
                user.setUserPhoneNumber(userNewPhoneNumber);
            }
        }

        System.out.println(usersList);

        return true;
    }

    public boolean check_phone_number(long userPhoneNumber)
    {
        for(UserClass user : usersList)
        {
            if(user.getUserPhoneNumber() == userPhoneNumber)
                return true;
        }
        //If phone number doesn't exist in database
        return false;
    }

}
