package project2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class MyDataFrame {
	public ArrayList<ArrayList<String>> columnList = new ArrayList<ArrayList<String>>();
	public ArrayList<String> nameList = new ArrayList<String>();
		
	public ArrayList<String> state = new ArrayList<String>();
	public ArrayList<String> gender = new ArrayList<String>();
	public ArrayList<Integer> year = new ArrayList<Integer>();
	public ArrayList<String> name = new ArrayList<String>();
	public ArrayList<Integer> count = new ArrayList<Integer>();
	int dim = 0;

	// Constructor
	public MyDataFrame(ArrayList<ArrayList<String>> columnList, ArrayList<String> nameList) {	
		this.columnList=columnList;
		this.nameList=nameList;
		this.dim = columnList.get(0).size();
	}
	public MyDataFrame() {	
		this.columnList=columnList;
		this.nameList=nameList;
		this.dim = 0;
	}

	public String toString(){
		/*
		 * print out each row of the data frame using for loop
		 */					
		String str="";
		for (int i = 0; i< this.nameList.size(); i++) {
			str +=	this.nameList.get(i)+",";
		}
		str = str.substring(0, str.length() - 1);
		str+="\n";
		
		for(int i = 0; i < this.dim; i++) {		
			for (int j=0; j<this.nameList.size(); j++) {
				str += this.columnList.get(j).get(i)+",";
			}
			str = str.substring(0, str.length() - 1);
			str +="\n";
		}
       return str;
    }
	
	// 1. Head and Tail.
	public MyDataFrame head(int n) {
		/*
		 * Returns the first n rows of the data.
		 */		
		ArrayList<ArrayList<String>> columnList = new ArrayList<ArrayList<String>>();
		ArrayList<String> nameList = new ArrayList<String>(this.nameList);
		
		for (int i=0; i<this.nameList.size();i++){
			ArrayList<String> headLocal = new ArrayList<String>(this.columnList.get(i).subList(0, n));
			columnList.add(headLocal);
		}	
		
		MyDataFrame mydf = new MyDataFrame(columnList, nameList);

		return mydf;
	}
	
	public MyDataFrame tail(int n) {
		/*
		 * Returns the first n rows of the data.
		 */			
		ArrayList<ArrayList<String>> columnList = new ArrayList<ArrayList<String>>();
		ArrayList<String> nameList = new ArrayList<String>(this.nameList);
		
		for (int i=0; i<this.nameList.size();i++){
			ArrayList<String> headLocal = new ArrayList<String>(this.columnList.get(i).subList(this.dim-n, this.dim));
			columnList.add(headLocal);
		}
		
		MyDataFrame mydf = new MyDataFrame(columnList, nameList);
		return mydf;
	}
	
	// 2. dType	
	public String dtypes(int index) {
		String type="";
		if (index == 0 || index ==1 || index ==3) {
			type="String";
		}else if (index ==2 || index ==4) {
			type="int";
		}
		return type;
	}
	
	public String dtypes(String colname) {
		String type="";
		if (colname == "state" || colname =="gender" || colname =="name") {
			type="String";
		}else if (colname =="year" || colname =="count") {
			type="int";
		}
		return type;
	}
	
	// 3. Slicing
	public MyDataFrame slice(int index) {
		/*
		 * Returns the column specified by index.
		 */
		MyDataFrame mydf = new MyDataFrame();
		ArrayList<ArrayList<String>> columnList = new ArrayList<ArrayList<String>>();
		ArrayList<String> nameList = new ArrayList<String>();
		
		columnList.add(this.columnList.get(index));
		nameList.add(this.nameList.get(index));
		mydf = new MyDataFrame(columnList, nameList);
			
		return mydf;
	}	
	
	public MyDataFrame slice(int[] indexList) {
		/*
		 * Returns the column specified by index.
		 */
		MyDataFrame mydf = new MyDataFrame();
		ArrayList<ArrayList<String>> columnList = new ArrayList<ArrayList<String>>();
		ArrayList<String> nameList = new ArrayList<String>();									
		
		for (int i=0; i<indexList.length; i++) {
			columnList.add(this.columnList.get(indexList[i]));
			nameList.add(this.nameList.get(indexList[i]));							
		} 
		mydf = new MyDataFrame(columnList, nameList);
		return mydf;
	}	

	public MyDataFrame slice(String name) {		
		/*
		 * Returns the column specified by name.
		 */
		MyDataFrame mydf = new MyDataFrame();
		ArrayList<ArrayList<String>> columnList = new ArrayList<ArrayList<String>>();
		ArrayList<String> nameList = new ArrayList<String>();
		int targetIndex = 0;
		
		targetIndex = this.nameList.indexOf(name);
		
		columnList.add(this.columnList.get(targetIndex));
		nameList.add(name);
		mydf = new MyDataFrame(columnList, nameList);
			
		return mydf;
	}	
	
	public MyDataFrame slice(String[] nameArr) {		
		/*
		 * Returns the columns specified by a name array.
		 */
		MyDataFrame mydf = new MyDataFrame();
		ArrayList<ArrayList<String>> columnList = new ArrayList<ArrayList<String>>();
		ArrayList<String> nameList = new ArrayList<String>();		
		int targetIndex = 0;
		
		for (int i=0; i<nameArr.length; i++) {
			targetIndex = this.nameList.indexOf(nameArr[i]);
			columnList.add(this.columnList.get(targetIndex));
			nameList.add(nameArr[i]);							
		} 
		mydf = new MyDataFrame(columnList, nameList);
		return mydf;
	}
	
	
	// 4. Filtering MyDataFrame filter(String col, String op, Object o) Returns data filtered by applying “col op o” on MyDataFrame object, e.g. “count > 10”, “state = ‘IL’”.
	public MyDataFrame filter(String col, String op, Object o) {
		/*
		 * Returns data filtered by applying “col op o” on MyDataFrame object, e.g. “count > 10”, “state = ‘IL’”.
		 */
		MyDataFrame mydf = new MyDataFrame();	
		ArrayList<ArrayList<String>> columnList = new ArrayList<ArrayList<String>>();
		ArrayList<String> nameList = new ArrayList<String>(this.nameList);
		ArrayList<String> stateFilter = new ArrayList<String>();
		ArrayList<String> genderFilter = new ArrayList<String>();
		ArrayList<String> yearFilter = new ArrayList<String>();
		ArrayList<String> nameFilter = new ArrayList<String>();
		ArrayList<String> countFilter = new ArrayList<String>();	
		int targetIndex = 0;
				
		targetIndex = this.nameList.indexOf(col);
		
		if(op==">") {
			for(int i = 0; i<this.dim; i++) {
				if(this.columnList.get(targetIndex).get(i).compareTo((String) o)>0) {		
					stateFilter.add(this.columnList.get(0).get(i));
					genderFilter.add(this.columnList.get(1).get(i));
					yearFilter.add(this.columnList.get(2).get(i));
					nameFilter.add(this.columnList.get(3).get(i));
					countFilter.add(this.columnList.get(4).get(i));					
				}
			}
		}else if(op=="<"){
			for(int i = 0; i<this.dim; i++) {
				if(this.columnList.get(targetIndex).get(i).compareTo((String) o)<0) {		
					stateFilter.add(this.columnList.get(0).get(i));
					genderFilter.add(this.columnList.get(1).get(i));
					yearFilter.add(this.columnList.get(2).get(i));
					nameFilter.add(this.columnList.get(3).get(i));
					countFilter.add(this.columnList.get(4).get(i));					
				}
			}
		}else if(op=="=") {
			for(int i = 0; i<this.dim; i++) {
				if(this.columnList.get(targetIndex).get(i).compareTo((String) o)==0) {		
					stateFilter.add(this.columnList.get(0).get(i));
					genderFilter.add(this.columnList.get(1).get(i));
					yearFilter.add(this.columnList.get(2).get(i));
					nameFilter.add(this.columnList.get(3).get(i));
					countFilter.add(this.columnList.get(4).get(i));					
				}
			}
		}
		
		columnList.add(stateFilter);
		columnList.add(genderFilter);
		columnList.add(yearFilter);
		columnList.add(nameFilter);
		columnList.add(countFilter);
		
		mydf = new MyDataFrame(columnList, nameList);		
		
		return mydf;
	}
	
	
	// 5. Indexing 
	public MyDataFrame loc(int index) {
		/*
		 * Returns the rows starting from index.
		 */
		
		MyDataFrame mydf = new MyDataFrame();	
		ArrayList<ArrayList<String>> columnList = new ArrayList<ArrayList<String>>();
		ArrayList<String> nameList = new ArrayList<String>(this.nameList);
		ArrayList<String> stateFilter = new ArrayList<String>();
		ArrayList<String> genderFilter = new ArrayList<String>();
		ArrayList<String> yearFilter = new ArrayList<String>();
		ArrayList<String> nameFilter = new ArrayList<String>();
		ArrayList<String> countFilter = new ArrayList<String>();		
		
		for(int i = index; i<this.dim; i++) {			
			stateFilter.add(this.columnList.get(0).get(i));
			genderFilter.add(this.columnList.get(1).get(i));
			yearFilter.add(this.columnList.get(2).get(i));
			nameFilter.add(this.columnList.get(3).get(i));
			countFilter.add(this.columnList.get(4).get(i));									
		}
		columnList.add(stateFilter);
		columnList.add(genderFilter);
		columnList.add(yearFilter);
		columnList.add(nameFilter);
		columnList.add(countFilter);
		
		mydf = new MyDataFrame(columnList, nameList);		
		
		return mydf;
		
		
	}
	
	public MyDataFrame loc(int from, int to) {
		/*
		 * Returns the rows between from and to (including from and to).
		 */
		
		MyDataFrame mydf = new MyDataFrame();	
		ArrayList<ArrayList<String>> columnList = new ArrayList<ArrayList<String>>();
		ArrayList<String> nameList = new ArrayList<String>(this.nameList);
		ArrayList<String> stateFilter = new ArrayList<String>();
		ArrayList<String> genderFilter = new ArrayList<String>();
		ArrayList<String> yearFilter = new ArrayList<String>();
		ArrayList<String> nameFilter = new ArrayList<String>();
		ArrayList<String> countFilter = new ArrayList<String>();		
		
		for(int i = from; i<=to; i++) {				
			stateFilter.add(this.columnList.get(0).get(i));
			genderFilter.add(this.columnList.get(1).get(i));
			yearFilter.add(this.columnList.get(2).get(i));
			nameFilter.add(this.columnList.get(3).get(i));
			countFilter.add(this.columnList.get(4).get(i));									
		}
		columnList.add(stateFilter);
		columnList.add(genderFilter);
		columnList.add(yearFilter);
		columnList.add(nameFilter);
		columnList.add(countFilter);	
		
		mydf = new MyDataFrame(columnList, nameList);		
		
		return mydf;
		
		
	}
			
	
	// 6. Sorting
	public MyDataFrame sort(int index) {
		/*
		 * Returns the data sorted by the column specified by index.
		 */				
		WriteLine [] sorted = new WriteLine[this.dim];
		MyDataFrame mydf = new MyDataFrame();		
		ArrayList<ArrayList<String>> columnList = new ArrayList<ArrayList<String>>();
		ArrayList<String> nameList = new ArrayList<String>(this.nameList);
		ArrayList<String> stateSorted = new ArrayList<String>();
		ArrayList<String> genderSorted = new ArrayList<String>();
		ArrayList<String> yearSorted = new ArrayList<String>();
		ArrayList<String> nameSorted = new ArrayList<String>();
		ArrayList<String> countSorted = new ArrayList<String>();		
		
		// create a writeLine object for each row in the dataframe, and put all the objects into a list called sorted 
		for (int i=0; i < this.dim; i++) {
			sorted[i]=new WriteLine(this.columnList.get(0).get(i), 
					this.columnList.get(1).get(i), 
					Integer.valueOf(this.columnList.get(2).get(i)), 
					this.columnList.get(3).get(i), 
					Integer.valueOf(this.columnList.get(4).get(i)));
		}
		
		// sort the created list by different condition. Must be a better to write this!
		if (index == 0) {						
			Arrays.sort(sorted, new SortByState());
		}else if (index == 1) {
			Arrays.sort(sorted, new SortByGender());
		}else if (index == 2) {
			Arrays.sort(sorted, new SortByYear());
		}else if (index == 3) {			
			Arrays.sort(sorted, new SortByName());			
		}else {
			Arrays.sort(sorted, new SortByCount());
		}
		
		// append the sorted output to arraylist and return the sorted dataframe
		for (int i=0; i<sorted.length; i++) {			
			stateSorted.add(sorted[i].getState());
			genderSorted.add(sorted[i].getGender());
			yearSorted.add(sorted[i].getYear());
			nameSorted.add(sorted[i].getName());
			countSorted.add(sorted[i].getCount());
		}			
		columnList.add(stateSorted);
		columnList.add(genderSorted);
		columnList.add(yearSorted);
		columnList.add(nameSorted);
		columnList.add(countSorted);
		
		mydf = new MyDataFrame(columnList, nameList);		
		
		return mydf;
		
	} 

	public MyDataFrame sort(String colname) {
		/*
		 * Returns the data sorted by the column specified by name.
		 */
		WriteLine [] sorted = new WriteLine[this.dim];
		ArrayList<ArrayList<String>> columnList = new ArrayList<ArrayList<String>>();
		ArrayList<String> nameList = new ArrayList<String>(this.nameList);
		MyDataFrame mydf = new MyDataFrame();		
		ArrayList<String> stateSorted = new ArrayList<String>();
		ArrayList<String> genderSorted = new ArrayList<String>();
		ArrayList<String> yearSorted = new ArrayList<String>();
		ArrayList<String> nameSorted = new ArrayList<String>();
		ArrayList<String> countSorted = new ArrayList<String>();		
		
		// create a writeLine object for each row in the dataframe, and put all the objects into a list called sorted 
		for (int i=0; i < this.dim; i++) {
			sorted[i]=new WriteLine(this.columnList.get(0).get(i), 
					this.columnList.get(1).get(i), 
					Integer.valueOf(this.columnList.get(2).get(i)), 
					this.columnList.get(3).get(i), 
					Integer.valueOf(this.columnList.get(4).get(i)));
		}		
		
		// sort the created list by different condition. Must be a better to write this!
		if (colname == "state") {						
			Arrays.sort(sorted, new SortByState());
		}else if (colname == "gender") {
			Arrays.sort(sorted, new SortByGender());
		}else if (colname == "year") {
			Arrays.sort(sorted, new SortByYear());
		}else if (colname == "name") {			
			Arrays.sort(sorted, new SortByName());			
		}else {
			Arrays.sort(sorted, new SortByCount());
		}
		
		// append the sorted output to arraylist and return the sorted dataframe
		for (int i=0; i<sorted.length; i++) {				
			stateSorted.add(sorted[i].getState());
			genderSorted.add(sorted[i].getGender());
			yearSorted.add(sorted[i].getYear());
			nameSorted.add(sorted[i].getName());
			countSorted.add(sorted[i].getCount());
		}	
		columnList.add(stateSorted);
		columnList.add(genderSorted);
		columnList.add(yearSorted);
		columnList.add(nameSorted);
		columnList.add(countSorted);
		
		
		mydf = new MyDataFrame(columnList, nameList);		
		
		return mydf;
	}

	// 7. Aggregation
	public String getMin(int index) {
		/*
		 * Returns the minimum element of the column specified by index.	
		 */
		String minString= "zzz";
		int minInt = 100000;	
		int tempInt = 0;
		
		ArrayList<ArrayList<String>> columnList = new ArrayList<ArrayList<String>>();
		ArrayList<String> nameList = new ArrayList<String>(this.nameList);
		String colname=nameList.get(index);
		
		if(colname=="state"||colname=="sex"||colname=="name") {
			for (int i = 0; i < this.dim; i++) {					
				if (this.columnList.get(index).get(i).compareTo(minString)<0) {
		    			minString = this.columnList.get(index).get(i);	
				}
			}
		}else {
			for (int i = 0; i < this.dim; i++) {					
				tempInt= Integer.valueOf(this.columnList.get(index).get(i));				
		    		if (tempInt < minInt) {
		    			minInt = tempInt;	
				}	
			}
			minString = Integer.toString(minInt);    
		}
			
		return minString;		
	}
	
	public String getMin(String label) {
		/*
		 * Returns the minimum element of the column specified by label.	
		 */
		String minString= "z";
		int minInt = 100000;						
		int tempInt = 0;
		
		ArrayList<ArrayList<String>> columnList = new ArrayList<ArrayList<String>>();
		ArrayList<String> nameList = new ArrayList<String>(this.nameList);		
		int index=nameList.indexOf(label);
		
		if(label=="state"||label=="sex"||label=="name") {
			for (int i = 0; i < this.dim; i++) {					
				if (this.columnList.get(index).get(i).compareTo(minString)<0) {
		    			minString = this.columnList.get(index).get(i);	
				}
			}
		}else {
			for (int i = 0; i < this.dim; i++) {					
				tempInt= Integer.valueOf(this.columnList.get(index).get(i));				
		    		if (tempInt < minInt) {
		    			minInt = tempInt;	
				}	
			}
			minString = Integer.toString(minInt);    
		}
			
		return minString;
	}
	
	public String getMax(int index) {
		/*
		 * Returns the maximum element of the column specified by index.	
		 */		
		String maxString= "";
		int maxInt = 0;	
		int tempInt = 0;
		
		ArrayList<ArrayList<String>> columnList = new ArrayList<ArrayList<String>>();
		ArrayList<String> nameList = new ArrayList<String>(this.nameList);
		String colname=nameList.get(index);
		
		if(colname=="state"||colname=="sex"||colname=="name") {
			for (int i = 0; i < this.dim; i++) {					
				if (this.columnList.get(index).get(i).compareTo(maxString)>0) {
					maxString = this.columnList.get(index).get(i);	
				}
			}
		}else {
			for (int i = 0; i < this.dim; i++) {					
				tempInt= Integer.valueOf(this.columnList.get(index).get(i));				
		    		if (tempInt > maxInt) {
		    			maxInt = tempInt;	
				}	
			}
			maxString = Integer.toString(maxInt);    
		}
			
		return maxString;	
	}
	
	public String getMax(String label) {
		/*
		 * Returns the maximum element of the column specified by label.	
		 */
		String maxString= "";
		int maxInt = 0;									
		int tempInt = 0;
		
		ArrayList<ArrayList<String>> columnList = new ArrayList<ArrayList<String>>();
		ArrayList<String> nameList = new ArrayList<String>(this.nameList);		
		int index=nameList.indexOf(label);
		
		if(label=="state"||label=="sex"||label=="name") {
			for (int i = 0; i < this.dim; i++) {					
				if (this.columnList.get(index).get(i).compareTo(maxString)>0) {
					maxString = this.columnList.get(index).get(i);	
				}
			}
		}else {
			for (int i = 0; i < this.dim; i++) {					
				tempInt= Integer.valueOf(this.columnList.get(index).get(i));				
		    		if (tempInt > maxInt) {
		    			maxInt = tempInt;	
				}	
			}
			maxString = Integer.toString(maxInt);    
		}
			
		return maxString;		
	}		
}
