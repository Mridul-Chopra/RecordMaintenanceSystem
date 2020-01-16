

package net.Paxcel;



/**
 * @author Mridul
 *
 *	This class contains all the necessary logic for running the program	
 */
public class Driver {
	
	public static void main(String[] args)
	{
		
		/*
			PRINTING MESSAGE TO THE USER
		*/
		System.out.println();
		System.out.println("Welcome to Record Maintainance System");
		System.out.println("----------------------------------------------------");
		System.out.println();
		/*
			PRINTING MESSAGES ENDS
		*/
		
		try
		{
			Resources.loadResources();			// loading the necessary resources
			FileOperations.performAction();		// Performing the operations
		} 
		catch (Exception e)
		{
		System.out.println("Some Error occured. Try again");	// Printing feedback to user on error encountered
		}
		
	}

}
