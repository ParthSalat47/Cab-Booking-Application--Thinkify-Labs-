package com.thinkifylabs.cabbookingapp.model;

import org.springframework.data.annotation.Id;

public class UserClass {
    private String userName;
    @Id //Every user should have a unique phone number
    private long userPhoneNumber;   
    private long xCoordinate;
    private long yCoordinate;
    private long userBillDue;

    //Constructors
    public UserClass() {
    }

    public UserClass(String userName, long userPhoneNumber, long xCoordinate, long yCoordinate) {
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.userBillDue = userBillDue;
    }

    //Getters
    public String getUserName() {
        return userName;
    }

    public long getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public long getxCoordinate() {
        return xCoordinate;
    }

    public long getyCoordinate() {
        return yCoordinate;
    }

    public long getUserBillDue() {
        return userBillDue;
    }

    //Setters
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPhoneNumber(long userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public void setxCoordinate(long xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(long yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public void setUserBillDue(long userBillDue) {
        this.userBillDue = userBillDue;
    }
    //toString() method
    @Override
    public String toString() {
        return "UserClass [userName=" + userName + ", userPhoneNumber=" + userPhoneNumber + ", xCoordinate="
                + xCoordinate + ", yCoordinate=" + yCoordinate + ", userBillDue=" + userBillDue + "]";
    }


}
