package net.Paxcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author Mridul
 *
 *	This class contains all the necessary logic for loading required resources	
 */
public class Resources {
	
	public static Logger log ;			// Getting the logger
	public static Properties filepaths;		// getting the properties file that contains file paths
	
	
	/*
		Initializing the Logger and its properties
	*/
	static
	{
			try 
			{
			log = Logger.getLogger("GLOBAL");							// getting the logger			
			Properties props = new Properties();							// properties object for log4j
			props.load(new FileInputStream("src\\resources\\log4j.properties"));			// loading the properties file
			PropertyConfigurator.configure(props);							// setting the configuration
			log.setLevel(Level.ERROR);								// setting logging level
			
			}
			
			catch(Exception e)
			{
				System.out.print("Fatal Error occoured");	// Printing feedback on error encountered
				System.exit(0);					// exiting the system
			}
	}
	
	/*
		Initializing filepaths for getting file paths
	*/
	static 
	{
		try 
		{
			filepaths= new Properties();							// Instantiating
			filepaths.load(new FileInputStream("src\\resources\\FilePaths.properties"));	// Giving the path of properties file
			PropertyConfigurator.configure(filepaths);					// setting the configuration
		}
		
		catch (FileNotFoundException e) 
		{
			log.error(e);										// logging the error
			System.out.print("Fatal Error occoured.Cannot load file properties");			// Printing feedback on error encountered
			System.exit(0);										// Exiting the system
		}
		
		
		catch (IOException e) 
		{
			log.error(e);										// logging the error
			System.out.print("Fatal Error occoured.Cannot load file properties");			// Printing feedback on error encountered
			System.exit(0);										// Exiting the system
		}
	}
	
	
	
	/**
	 * 
	 */
	public static void loadResources() // this is an empty function called by main to load all the resources before proceeding any furthur
	{}

}
