# Cab Booking Application [Thinkify Labs]

## About
This application is a backend API made using Java SpringBoot. The application can onboard users and drivers. It has functionality to find drivers for a user, based on certain conditions. Ride fare calculation is also done in the backend.

## Technologies used
1. Java SpringBoot
  - *To create the entire backend API*
2. Postman
  - *To hit and test all API endpoints*
3. Git 
  - *To maintain different versions of the source code*

## Salient features
1. Robust **Exception Handling** is done for all API endpoints
2. Prevents creation of users or drivers with the same phone number
3. **Separation of concerns** divides the application into different parts: Controllers, Services, Repository.
4. **Loose coupling** is ensured by using Dependency Injection.
5. **Clean code** is written by using proper variable names and comments wherever necessary. **Code reusability** is also taken into account. New features can easily be accomodated.
6. Almost everything is implemented **according to the business requirements** provided. The differences present are only there to make the application more durable and scalable. 
  - For example, phone number is used as a primary key instead of name, because multiple users can have the same name. 

## List of API endpoints
### User related
1. `add_user(String userName, long userPhoneNumber, long xCoordinate, long yCoordinate)`
2. `update_user(long userPhoneNumber, String userNewName, long userNewPhoneNumber)`
3. `update_userLocation(long userPhoneNumber, long xCoordinate, long yCoordinate)`
### Driver related
1. `add_driver(String driverName, String driverGender, 
        long driverAge, long driverPhoneNumber, 
        String vehicleDetails, long xCoordinate, 
        long yCoordinate, boolean available, long driverEarning)`
2. `update_driverLocation(long driverPhoneNumber, long xCoordinate, long yCoordinate)` 
3. `change_driver_status(long driverPhoneNumber, boolean available)`
4. `find_total_earning()`
### Ride related
1. `find_ride(long userPhoneNumber, long sourceXCoordinate, long sourceYCoordinate, long destXCoordinate, long destYCoordinate)`
2. `choose_ride(long userPhoneNumber, long driverPhoneNumber)`
3. `calculateBill(long userPhoneNumber)`
