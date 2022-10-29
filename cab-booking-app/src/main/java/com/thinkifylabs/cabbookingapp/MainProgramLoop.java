package com.thinkifylabs.cabbookingapp;

public class MainProgramLoop {
    
    public static void homescreen()
	{
		while(true)
		{	
			System.out.println("\nPress appropriate key: "
					+ "\n1. User related"
					+ "\n2. Driver related"
					+ "\n3. Ride related"
					+ "\n4. Total driver earnings"
					+ "\n\nPress Ctrl+C to exit the program.");
			
			int option = UtilityMethods.integerInput(); 
			
			switch(option)
			{
				case 1: 
				{
					userRelatedLoop();
					break;
				}
				case 2: 
				{
					driverRelatedLoop();
					break;
				}
				case 3: 
				{
					rideRelatedLoop();
                    break;
				}
                case 4: 
				{
					//driver earnings
                    break;
				}
				default:	
				{
					System.out.println("Please enter a number between 1 and 4.");
				}
			}
			
			
		}
	}

    public static void userRelatedLoop()
    {
        while(true)
		{	
			System.out.println("\nPress appropriate key: "
					+ "\n1. Add User"
					+ "\n2. Update User Details"
					+ "\n3. Update User Location"
					+ "\n4. Return to main menu"
					+ "\n\nPress Ctrl+C to exit the program.");
			
			int option = UtilityMethods.integerInput(); 
			
			switch(option)
			{
				case 1: 
				{
					UtilityMethods.curl("curl http://127.0.0.1:8080/users/add_user");
					break;
				}
				case 2: 
				{
					UtilityMethods.curl("curl http://127.0.0.1:8080/users/update_user");
					break;
				}
				case 3: 
				{
					rideRelatedLoop();
                    break;
				}
                case 4: 
				{
					return;
				}
				default:	
				{
					System.out.println("Please enter a number between 1 and 4.");
				}
			}
			
			
		}
    }

    public static void driverRelatedLoop()
    {

    }

    public static void rideRelatedLoop()
    {

    }

    //Calculate earnings!
}
