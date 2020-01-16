package net.Paxcel;
import java.io.*;
import java.util.*;

/**
 * @author Mridul
 *
 *	This class contains all the necessary logic for performing file operations
 */

public class FileOperations {
	
	private static Map<Integer,Person> sortRecords_ = new TreeMap<Integer,Person>(); 	// TreeMap used for convenient sorting
	private static List<Person> sortedRecords_ = new ArrayList<Person>();			//	contains sorted records
	private static List<Person> originalRecords_= new ArrayList<Person>(); 			// contains original records for a while
	private static List<Person> duplicateRecords_;						// contains duplicate records 
	
	
	
	/**
	 * @throws Exception
	 */
	private static void read() throws Exception
	{
		try(BufferedReader reader = new BufferedReader( new FileReader(Resources.filepaths.getProperty("file.input") )  )  ) // BuferedReader used to read a line at once
		{
				String line; 		//line read from input file 
				Person record;		//Record that we got from input file
				
				while( (line=reader.readLine())!=null )
				{
					record = new Person(); 					// making instance of the person
					record.setValues(line.split(","));			// setting values to attributes after splitting commas
					sortRecords_.put(record.getId(),record);		//putting records in the TreeMap
					originalRecords_.add(record);				//storing records in the ArrayList
				}
				
				 
				
				//Copying the records to ArrayList sortRecords_
				sortRecords_.entrySet()
										.forEach(entry->
													{
											    	sortedRecords_.add(entry.getValue());
												 
													}
												);
				
				
				 originalRecords_.removeAll(sortedRecords_);  	// remove duplicate entries from the original records
				 duplicateRecords_ = originalRecords_; 		// pointing duplicateRecords to orignalRecords to represent duplicate records
				 originalRecords_=null;				// originalRecords_ points to null so that cannot be used furthur
				 
				 
		}
		catch(Exception ex)
		{
			Resources.log.error(ex);  // logging the encountered exception
			throw new Exception();	 // Throwing new Exception to be handled by caller
		}
		
	}
	
	
	
	/**
	 * @throws Exception
	 */
	private static  void write() throws Exception
	{
		try(FileWriter uniqueWriter = new FileWriter(Resources.filepaths.getProperty("file.output"));
			FileWriter duplicateWriter = new FileWriter(Resources.filepaths.getProperty("file.duplicates"))	
			)   // Getting two FileWriteres for writing into two files
		{
			writeThis(sortedRecords_,uniqueWriter);   		// writing sorted records to file
			writeThis(duplicateRecords_,duplicateWriter);		// writing duplicate records to file
			
			/*
				DISPLAYING MESSAGES TO THE USER
			*/
			System.out.println("Records Written Successfully");
			System.out.println();
			System.out.println("Paths :: ");
			System.out.println("Sorted Records : " + Resources.filepaths.getProperty("file.output"));
			System.out.println("Duplicate Records : " + Resources.filepaths.getProperty("file.duplicates"));
			System.out.println();
			System.out.println("Number of Duplicates : " + duplicateRecords_.size());
			System.out.println("Number of Sorted  : " + sortedRecords_.size());
			/*
				MESSAGE DISPLAYING ENDS
			*/
			
			}
		catch(Exception ex)
		{
			Resources.log.error(ex); // logging the exception
			throw new Exception();   // Throwing new Exception to be handled by caller
		}
	}
	
	
	
	/**
	 * @param records : An ArrayList that contains records to be written
	 * @param writer  : FileWriter to write into the required file
	 */
	private static void writeThis(List<Person> records , FileWriter writer) 
	{
		records.stream()
						.forEach(i->
										{
											try 
											{
												writer.write(i.getCSV());  // writing after getting CSV format of record
											} 
											catch (Exception e)
											{
												Resources.log.error(e);  // logging the encountered exception
												
											}
										}
										
								);
						
	}
	
	/**
	 * @throws Exception
	 */
	public static void performAction() throws Exception
	{
		FileOperations.read();  	// Performing read on file
		FileOperations.write();		// Writing the output in files
	}

}


