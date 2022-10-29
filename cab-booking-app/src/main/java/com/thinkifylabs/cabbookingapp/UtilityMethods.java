package com.thinkifylabs.cabbookingapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UtilityMethods {
    
    public static int integerInput()
	{
		/*
		 * Returns zero in case of an exception.
		 */
		
		int value=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
			value = Integer.parseInt(br.readLine());
		}
		catch (IOException e)
		{
			System.out.println("Encountered an IO exception while taking integer input.");
			return 0;
		}
		catch(NumberFormatException e)
		{
			System.out.println("The key you pressed doesn't qualify as a 'Number'. ");
		}
        
        return value;
    }

    public static long longInput()
	{
		/*
		 * Returns zero in case of an exception.
		 */
		
		long value=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
			value = Long.parseLong(br.readLine());
		}
		catch (IOException e)
		{
			System.out.println("Encountered an IO exception while taking number input.");
			//return 0;
		}
		catch(NumberFormatException e)
		{
			System.out.println("The key you pressed doesn't qualify as a 'Number'.");
		}
        
        return value;
    }

	public static boolean booleanInput()
	{
		/*
		 * Returns false in case of an exception.
		 */

	    String s = stringInput();
	    boolean value = false;
  
        // create a new scanner
        Scanner scanner = new Scanner(s);
  
            // if the input is a Boolean,
            if (scanner.hasNextBoolean()) 
            {
                value = scanner.nextBoolean();
            }
  
            // if no Boolean is found,
            else {
                System.out.println("Please enter either true or false. The current value is set to false.");
            }

        scanner.close();
        
        return value;
	}

    public static String stringInput()
	{
		/*
		 * Returns null in case of an exception.
		 */
		
		String value=null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
			value = br.readLine();		
			
		}
		catch (IOException e)
		{
			System.out.println("Encountered an IO exception while taking a string input.");
			return null;
		}

		return value;
	}

    public static void curl(String command) 
    {
        ProcessBuilder processBuilder = new ProcessBuilder();

        // -- Linux --

        // Run a shell command
        processBuilder.command("bash", "-c", command);

        // Run a shell script
        //processBuilder.command("path/to/hello.sh");

        // -- Windows --

        // Run a command
        //processBuilder.command("cmd.exe", "/c", "dir C:\\Users\\mkyong");

        // Run a bat file
        //processBuilder.command("C:\\Users\\mkyong\\hello.bat");

        try {

            Process process = processBuilder.start();

            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                //System.out.println("Success!");
                System.out.println(output);
                //System.exit(0);
            } else {
                //abnormal...
            }

        } catch (IOException eq) {
            eq.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
