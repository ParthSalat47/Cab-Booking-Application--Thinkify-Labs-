package com.thinkifylabs.cabbookingapp.users;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

//import com.thinkifylabs.cabbookingapp.users.UserClass;

@Component
public class UserRepository{
    
    private ArrayList<UserClass> usersList = new ArrayList<UserClass>();

    public boolean add_user_repository(UserClass newUser)
    {
        return usersList.add(newUser);
    }

}
