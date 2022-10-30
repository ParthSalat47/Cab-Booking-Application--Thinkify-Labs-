package com.thinkifylabs.cabbookingapp.model;

public class RideClass {

    private long userPhoneNumber;
    private long driverPhoneNumber;
    private long sourceXCoordinate;
    private long sourceYCoordinate;
    private long destXCoordinate;
    private long destYCoordinate;
    private long rideCost;

    //Constructors
    public RideClass() {
    }

    public RideClass(long userPhoneNumber, long driverPhoneNumber, long sourceXCoordinate, long sourceYCoordinate,
            long destXCoordinate, long destYCoordinate, long rideCost) {
        this.userPhoneNumber = userPhoneNumber;
        this.driverPhoneNumber = driverPhoneNumber;
        this.sourceXCoordinate = sourceXCoordinate;
        this.sourceYCoordinate = sourceYCoordinate;
        this.destXCoordinate = destXCoordinate;
        this.destYCoordinate = destYCoordinate;
        this.rideCost = rideCost;
    }
    
    //Getters
    public long getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public long getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public long getSourceXCoordinate() {
        return sourceXCoordinate;
    }

    public long getSourceYCoordinate() {
        return sourceYCoordinate;
    }

    public long getDestXCoordinate() {
        return destXCoordinate;
    }

    public long getDestYCoordinate() {
        return destYCoordinate;
    }

    public long getRideCost() {
        return rideCost;
    }

    //Setters
    public void setUserPhoneNumber(long userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public void setDriverPhoneNumber(long driverPhoneNumber) {
        this.driverPhoneNumber = driverPhoneNumber;
    }

    public void setSourceXCoordinate(long sourceXCoordinate) {
        this.sourceXCoordinate = sourceXCoordinate;
    }

    public void setSourceYCoordinate(long sourceYCoordinate) {
        this.sourceYCoordinate = sourceYCoordinate;
    }

    public void setDestXCoordinate(long destXCoordinate) {
        this.destXCoordinate = destXCoordinate;
    }

    public void setDestYCoordinate(long destYCoordinate) {
        this.destYCoordinate = destYCoordinate;
    }

    public void setRideCost(long rideCost) {
        this.rideCost = rideCost;
    }

    //toString()
    @Override
    public String toString() {
        return "RideClass [userPhoneNumber=" + userPhoneNumber + ", driverPhoneNumber=" + driverPhoneNumber
                + ", sourceXCoordinate=" + sourceXCoordinate + ", sourceYCoordinate=" + sourceYCoordinate
                + ", destXCoordinate=" + destXCoordinate + ", destYCoordinate=" + destYCoordinate + ", rideCost="
                + rideCost + "]";
    }

    
    
    
}
