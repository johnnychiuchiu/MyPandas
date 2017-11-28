package project2;

import java.util.ArrayList;

public class WriteLine {
	String state, gender, name, rowname;
	int year, count;
 
    // Constructor
    public WriteLine(String state, String gender, int year, String name, int count)
    {    		
        this.state = state;
        this.gender = gender;
        this.year = year;
        this.name = name;
        this.count = count;
    }
 
    public String getState() {
    		return this.state;
    }
    
    public String getGender() {
		return this.gender;
    }
    
    public String getYear() {    	
		return String.valueOf(this.year);
    }
    
    public String getName() {
		return this.name;
    }
    
    public String getCount() {
		return String.valueOf(this.count);
    }
    
    // Used to print student details in main()
    public String toString()
    {
        return this.state + "," + this.gender + "," + this.year + "," + this.name + "," + this.count;
    }
}
