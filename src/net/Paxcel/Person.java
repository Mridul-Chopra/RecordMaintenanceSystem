package net.Paxcel;


/**
 * @author Mridul
 *
 *	This class represents record from the file as object	
 */
public  class Person  {
	
	Integer id;
	String name;
	String gender;
	String address;
	
	
	/**
	 * @param values   // get values in form of array and sets them
	 */
	public  void setValues(String[] values)
	{
			this.id = Integer.parseInt(values[0]);
			this.name = values[1];
			this.gender = values[2];
			this.address = values[3];
	}
	
	/**
	 * @return   returns id
	 */
	public Integer getId() // getter method for id 
	{
		return id;
	}


	
	/**
	 * 
	 */
	public void Print()  // Function for printing the fields of object
	{
		System.out.println("id : "+ this.id);
		System.out.println("name : "+ this.name);
		System.out.println("gender : "+ this.gender);
		System.out.println("address : "+ this.address);
		System.out.println("------------------------------");
	}
	
	
	/**
	 * @return  returns a string of CSV form
	 */
	public String getCSV() // Provide record in csv format
	{
		String  csv = id+","+name+","+gender+","+address+"\n";
		return csv;
		
	}
}












