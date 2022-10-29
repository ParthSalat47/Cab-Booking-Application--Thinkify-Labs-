package com.thinkifylabs.cabbookingapp.users;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class UserRepository{
    
    private ArrayList<UserClass> usersList = new ArrayList<UserClass>();

    public boolean add_user_repository(UserClass newUser)
    {
        return usersList.add(newUser);
        //System.out.println(usersList);
        //return true;
    }

    public boolean update_user_repository(long userPhoneNumber, UserClass newUser)
    {
        for(UserClass user : usersList)
        {
            if(user.getUserPhoneNumber() == userPhoneNumber)
            {
                user.setUserName(newUser.getUserName());
                user.setUserPhoneNumber(newUser.getUserPhoneNumber());
                return true;
            }
        }

        //Debug
        //System.out.println(usersList);

        //In case of updation failure,
        return false;
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

    public boolean update_userLocation_repository(long userPhoneNumber, long xCoordinate, long yCoordinate)
    {
        for(UserClass user : usersList)
        {
            if(user.getUserPhoneNumber() == userPhoneNumber)
            {
                user.setxCoordinate(xCoordinate);
                user.setyCoordinate(yCoordinate);
                return true;
            }
        }

        //Debug
        //System.out.println(usersList);

        //In case of updation failure,
        return false;
    }
}
