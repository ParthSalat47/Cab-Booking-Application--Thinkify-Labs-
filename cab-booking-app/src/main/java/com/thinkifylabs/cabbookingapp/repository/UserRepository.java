package com.thinkifylabs.cabbookingapp.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.thinkifylabs.cabbookingapp.model.UserClass;

@Component
public class UserRepository{
    
    private ArrayList<UserClass> usersList = new ArrayList<UserClass>();

    //Getters and Setters
    public ArrayList<UserClass> getUsersList() {
        return usersList;
    }

    public void setUsersList(ArrayList<UserClass> usersList) {
        this.usersList = usersList;
    }

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

    /*
     * Checks if a given phone number is present in the user database
     */
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

    public boolean update_userLocation_repository(UserClass newUser)
    {
        for(UserClass user : usersList)
        {
            if(user.getUserPhoneNumber() == newUser.getUserPhoneNumber())
            {
                user.setxCoordinate(newUser.getxCoordinate());
                user.setyCoordinate(newUser.getyCoordinate());
                return true;
            }
        }

        //Debug
        //System.out.println(usersList);

        //In case of updation failure,
        return false;
    }
}
