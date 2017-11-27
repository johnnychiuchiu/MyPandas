package project2;

import java.util.ArrayList;

public class WriteLine {
	String state, gender, name, rowname;
    int year, count;
 
    // Constructor
    public WriteLine(String rowname, String state, String gender, int year, String name, int count)
    {
    		this.rowname = rowname;
        this.state = state;
        this.gender = gender;
        this.year = year;
        this.name = name;
        this.count = count;
    }
 
    public String getRowname() {
		return this.rowname;
}
    public String getState() {
    		return this.state;
    }
    
    public String getGender() {
		return this.gender;
    }
    
    public int getYear() {
		return this.year;
    }
    
    public String getName() {
		return this.name;
    }
    
    public int getCount() {
		return this.count;
    }
    
    // Used to print student details in main()
    public String toString()
    {
        return this.state + "," + this.gender + "," + this.year + "," + this.name + "," + this.count;
    }
}
