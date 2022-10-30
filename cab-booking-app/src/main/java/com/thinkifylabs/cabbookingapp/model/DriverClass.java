package com.thinkifylabs.cabbookingapp.model;

import org.springframework.data.annotation.Id;

public class DriverClass 
{
    private String driverName;
    @Id //Every user should have a unique phone number
    private long driverPhoneNumber;   
    private String driverGender;
    private long driverAge;
    private String vehicleDetails;
    private long xCoordinate;
    private long yCoordinate;
    private boolean available;
    private long driverEarning;

    //Constructors
    public DriverClass() {
    }

    public DriverClass(String driverName, long driverPhoneNumber, String driverGender, long driverAge,
            String vehicleDetails, long xCoordinate, long yCoordinate, boolean available, long driverEarning) {
        this.driverName = driverName;
        this.driverPhoneNumber = driverPhoneNumber;
        this.driverGender = driverGender;
        this.driverAge = driverAge;
        this.vehicleDetails = vehicleDetails;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.available = available;
        this.driverEarning = driverEarning;
    }

    //Getters
    public String getDriverName() {
        return driverName;
    }

    public long getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public String getDriverGender() {
        return driverGender;
    }

    public long getDriverAge() {
        return driverAge;
    }

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public long getxCoordinate() {
        return xCoordinate;
    }

    public long getyCoordinate() {
        return yCoordinate;
    }

    public boolean getavailable() {
        return available;
    }

    public long getDriverEarning() {
        return driverEarning;
    }

    //Setters
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setDriverPhoneNumber(long driverPhoneNumber) {
        this.driverPhoneNumber = driverPhoneNumber;
    }

    public void setDriverGender(String driverGender) {
        this.driverGender = driverGender;
    }

    public void setDriverAge(long driverAge) {
        this.driverAge = driverAge;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public void setxCoordinate(long xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(long yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public void setavailable(boolean available) {
        this.available = available;
    }

    public void setDriverEarning(long driverEarning) {
        this.driverEarning = driverEarning;
    }

    //toString()
    @Override
    public String toString() {
        return "DriverClass [driverName=" + driverName + ", driverPhoneNumber=" + driverPhoneNumber + ", driverGender="
                + driverGender + ", driverAge=" + driverAge + ", vehicleDetails=" + vehicleDetails + ", xCoordinate="
                + xCoordinate + ", yCoordinate=" + yCoordinate + ", available=" + available + ", driverEarning="
                + driverEarning + "]";
    }

    
    

    
    

    
}
