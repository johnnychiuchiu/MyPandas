package project2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class MyDataFrame {	
	
	public ArrayList<String> rowname = new ArrayList<String>();
	public ArrayList<String> state = new ArrayList<String>();
	public ArrayList<String> gender = new ArrayList<String>();
	public ArrayList<Integer> year = new ArrayList<Integer>();
	public ArrayList<String> name = new ArrayList<String>();
	public ArrayList<Integer> count = new ArrayList<Integer>();
	int dim = 0;
	
	// constructor
	public MyDataFrame(ArrayList<String> rowname, ArrayList<String> state, ArrayList<String> gender, ArrayList<Integer> year, ArrayList<String> name, ArrayList<Integer> count) {		
		this.rowname = rowname;
		this.state = state;
		this.gender = gender;
		this.year = year;
		this.name = name;
		this.count = count;
		this.dim = this.state.size();
	}
	public MyDataFrame() {	
		this.rowname = rowname;
		this.state = state;
		this.gender = gender;
		this.year = year;
		this.name = name;
		this.count = count;
		this.dim = 0;
	}
//	public MyDataFrame(ArrayList<String> state) {		
//		this.state = state;
//		this.gender = gender;
//		this.year = year;
//		this.name = name;
//		this.count = count;
//		this.dim = this.state.size();
//	}

	public String toString(){
		/*
		 * print out each row of the data frame using for loop
		 */	
		
		String str="state,gender,year,name,count\n";
		for(int i = 0; i < this.dim; i++) {
//			if(this.state.size()>0) {str +=this.state.get(i)+",";}
//			if(this.gender.size()>0) {str +=this.gender.get(i)+",";}
//			if(this.year.size()>0) {str +=this.year.get(i)+",";}
//			if(this.name.size()>0) {str +=this.name.get(i)+",";}
//			if(this.count.size()>0) {str +=this.count.get(i)+",";}
//			str+="\n";						
			str += this.state.get(i) + "," + this.gender.get(i) + "," + this.year.get(i) + "," + this.name.get(i) + "," + this.count.get(i) + "\n";
		}
       return str;
    }
	
	// 1. Head and Tail.
	public MyDataFrame head(int n) {
		/*
		 * Returns the first n rows of the data.
		 */		
		ArrayList<String> rownameLocal = new ArrayList<String>(this.rowname.subList(0, n));
		ArrayList<String> stateLocal = new ArrayList<String>(this.state.subList(0, n));
		ArrayList<String> genderLocal = new ArrayList<String>(this.gender.subList(0, n));
		ArrayList<Integer> yearLocal = new ArrayList<Integer>(this.year.subList(0, n));
		ArrayList<String> nameLocal = new ArrayList<String>(this.name.subList(0, n));
		ArrayList<Integer> countLocal = new ArrayList<Integer>(this.count.subList(0, n));			
		
		MyDataFrame mydf = new MyDataFrame(rownameLocal, stateLocal, genderLocal, yearLocal, nameLocal, countLocal);

		return mydf;
	}
	
	public MyDataFrame tail(int n) {
		/*
		 * Returns the first n rows of the data.
		 */		
		ArrayList<String> rownameLocal = new ArrayList<String>(this.rowname.subList(this.dim-n, this.dim));
		ArrayList<String> stateLocal = new ArrayList<String>(this.state.subList(this.dim-n, this.dim));
		ArrayList<String> genderLocal = new ArrayList<String>(this.gender.subList(this.dim-n, this.dim));
		ArrayList<Integer> yearLocal = new ArrayList<Integer>(this.year.subList(this.dim-n, this.dim));
		ArrayList<String> nameLocal = new ArrayList<String>(this.name.subList(this.dim-n, this.dim));
		ArrayList<Integer> countLocal = new ArrayList<Integer>(this.count.subList(this.dim-n, this.dim));			
		
		MyDataFrame mydf = new MyDataFrame(rownameLocal, stateLocal, genderLocal, yearLocal, nameLocal, countLocal);

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
	
//	// 3. Slicing
//	public MyDataFrame slice(int index) {
//		/*
//		 * Returns the column specified by index.
//		 */
//		MyDataFrame mydf = new MyDataFrame();
//		if (index==0) {
//			mydf = new MyDataFrame(this.state);
//		}		
//		return mydf;
//	}	
//	
//	public MyDataFrame slice(int[] indexList) {
//		/*
//		 * Returns the column specified by index.
//		 */
//		MyDataFrame mydf = new MyDataFrame();
//		for (int i=0; i<indexList.length; i++) {
//			if (indexList[i]) {
//				
//			}
//			
//			
//		} 
//		return mydf;
//	}	

	// 4. Filtering MyDataFrame filter(String col, String op, Object o) Returns data filtered by applying “col op o” on MyDataFrame object, e.g. “count > 10”, “state = ‘IL’”.
	public MyDataFrame filter(String col, String op, Object o) {
		/*
		 * Returns data filtered by applying “col op o” on MyDataFrame object, e.g. “count > 10”, “state = ‘IL’”.
		 */
		MyDataFrame mydf = new MyDataFrame();
		ArrayList<String> rownameFilter = new ArrayList<String>();
		ArrayList<String> stateFilter = new ArrayList<String>();
		ArrayList<String> genderFilter = new ArrayList<String>();
		ArrayList<Integer> yearFilter = new ArrayList<Integer>();
		ArrayList<String> nameFilter = new ArrayList<String>();
		ArrayList<Integer> countFilter = new ArrayList<Integer>();		
		
		if (col=="state") {			
			if(op==">") {
				for(int i = 0; i<this.dim; i++) {
					if(state.get(i).compareTo((String) o)>0) {
						rownameFilter.add(rowname.get(i));
						stateFilter.add(state.get(i));
						genderFilter.add(gender.get(i));
						yearFilter.add(year.get(i));
						nameFilter.add(name.get(i));
						countFilter.add(count.get(i));						
					}
				}
			}else if(op=="=") {
				for(int i = 0; i<this.dim; i++) {
					if(state.get(i).equals((String) o)) {
						rownameFilter.add(rowname.get(i));
						stateFilter.add(state.get(i));
						genderFilter.add(gender.get(i));
						yearFilter.add(year.get(i));
						nameFilter.add(name.get(i));
						countFilter.add(count.get(i));						
					}
				}
			}else if(op=="<") {
				for(int i = 0; i<this.dim; i++) {
					if(state.get(i).compareTo((String) o)<0) {
						rownameFilter.add(rowname.get(i));
						stateFilter.add(state.get(i));
						genderFilter.add(gender.get(i));
						yearFilter.add(year.get(i));
						nameFilter.add(name.get(i));
						countFilter.add(count.get(i));						
					}
				}
			}	
		}else if (col=="gender") {
			if(op==">") {
				for(int i = 0; i<this.dim; i++) {
					if(gender.get(i).compareTo((String) o)>0) {
						rownameFilter.add(rowname.get(i));
						stateFilter.add(state.get(i));
						genderFilter.add(gender.get(i));
						yearFilter.add(year.get(i));
						nameFilter.add(name.get(i));
						countFilter.add(count.get(i));						
					}
				}
			}else if(op=="=") {
				for(int i = 0; i<this.dim; i++) {
					if(gender.get(i).equals((String) o)) {
						rownameFilter.add(rowname.get(i));
						stateFilter.add(state.get(i));
						genderFilter.add(gender.get(i));
						yearFilter.add(year.get(i));
						nameFilter.add(name.get(i));
						countFilter.add(count.get(i));						
					}
				}
			}else if(op=="<") {
				for(int i = 0; i<this.dim; i++) {
					if(gender.get(i).compareTo((String) o)<0) {
						rownameFilter.add(rowname.get(i));
						stateFilter.add(state.get(i));
						genderFilter.add(gender.get(i));
						yearFilter.add(year.get(i));
						nameFilter.add(name.get(i));
						countFilter.add(count.get(i));						
					}
				}
			}
		}else if (col=="year") {
			if(op==">") {
				for(int i = 0; i<this.dim; i++) {
					if(year.get(i) > Integer.valueOf((String) o)) {
						rownameFilter.add(rowname.get(i));
						stateFilter.add(state.get(i));
						genderFilter.add(gender.get(i));
						yearFilter.add(year.get(i));
						nameFilter.add(name.get(i));
						countFilter.add(count.get(i));						
					}
				}
			}else if(op=="=") {
				for(int i = 0; i<this.dim; i++) {
					if(year.get(i) == Integer.valueOf((String) o)) {
						rownameFilter.add(rowname.get(i));
						stateFilter.add(state.get(i));
						genderFilter.add(gender.get(i));
						yearFilter.add(year.get(i));
						nameFilter.add(name.get(i));
						countFilter.add(count.get(i));						
					}
				}
			}else if(op=="<") {
				for(int i = 0; i<this.dim; i++) {
					if(year.get(i) < Integer.valueOf((String) o)) {
						rownameFilter.add(rowname.get(i));
						stateFilter.add(state.get(i));
						genderFilter.add(gender.get(i));
						yearFilter.add(year.get(i));
						nameFilter.add(name.get(i));
						countFilter.add(count.get(i));						
					}
				}
			}
		}else if (col=="name") {
			if(op==">") {
				for(int i = 0; i<this.dim; i++) {
					if(name.get(i).compareTo((String) o)>0) {
						rownameFilter.add(rowname.get(i));
						stateFilter.add(state.get(i));
						genderFilter.add(gender.get(i));
						yearFilter.add(year.get(i));
						nameFilter.add(name.get(i));
						countFilter.add(count.get(i));						
					}
				}
			}else if(op=="=") {
				for(int i = 0; i<this.dim; i++) {
					if(name.get(i).equals((String) o)) {
						rownameFilter.add(rowname.get(i));
						stateFilter.add(state.get(i));
						genderFilter.add(gender.get(i));
						yearFilter.add(year.get(i));
						nameFilter.add(name.get(i));
						countFilter.add(count.get(i));						
					}
				}
			}else if(op=="<") {
				for(int i = 0; i<this.dim; i++) {
					if(name.get(i).compareTo((String) o)<0) {
						rownameFilter.add(rowname.get(i));
						stateFilter.add(state.get(i));
						genderFilter.add(gender.get(i));
						yearFilter.add(year.get(i));
						nameFilter.add(name.get(i));
						countFilter.add(count.get(i));						
					}
				}
			}	
		}else if (col=="count") {
			if(op==">") {
				for(int i = 0; i<this.dim; i++) {
					if(count.get(i) > Integer.valueOf((String) o)) {
						rownameFilter.add(rowname.get(i));
						stateFilter.add(state.get(i));
						genderFilter.add(gender.get(i));
						yearFilter.add(year.get(i));
						nameFilter.add(name.get(i));
						countFilter.add(count.get(i));						
					}
				}
			}else if(op=="=") {
				for(int i = 0; i<this.dim; i++) {
					if(count.get(i) == Integer.valueOf((String) o)) {
						rownameFilter.add(rowname.get(i));
						stateFilter.add(state.get(i));
						genderFilter.add(gender.get(i));
						yearFilter.add(year.get(i));
						nameFilter.add(name.get(i));
						countFilter.add(count.get(i));						
					}
				}
			}else if(op=="<") {
				for(int i = 0; i<this.dim; i++) {
					if(count.get(i) < Integer.valueOf((String) o)) {
						rownameFilter.add(rowname.get(i));
						stateFilter.add(state.get(i));
						genderFilter.add(gender.get(i));
						yearFilter.add(year.get(i));
						nameFilter.add(name.get(i));
						countFilter.add(count.get(i));						
					}
				}
			}
		}
		
		mydf = new MyDataFrame(rownameFilter, stateFilter, genderFilter, yearFilter, nameFilter, countFilter);		
		
		return mydf;
	}
	
	
	// 5. Indexing 
	public MyDataFrame loc(int index) {
		/*
		 * Returns the rows starting from index.
		 */
		
		MyDataFrame mydf = new MyDataFrame();
		ArrayList<String> rownameFilter = new ArrayList<String>();
		ArrayList<String> stateFilter = new ArrayList<String>();
		ArrayList<String> genderFilter = new ArrayList<String>();
		ArrayList<Integer> yearFilter = new ArrayList<Integer>();
		ArrayList<String> nameFilter = new ArrayList<String>();
		ArrayList<Integer> countFilter = new ArrayList<Integer>();		
		
		for(int i = index; i<this.dim; i++) {
			rownameFilter.add(rowname.get(i));
			stateFilter.add(state.get(i));
			genderFilter.add(gender.get(i));
			yearFilter.add(year.get(i));
			nameFilter.add(name.get(i));
			countFilter.add(count.get(i));									
		}
				
		mydf = new MyDataFrame(rownameFilter, stateFilter, genderFilter, yearFilter, nameFilter, countFilter);
		return mydf;
		
		
	}
	
	public MyDataFrame loc(int from, int to) {
		/*
		 * Returns the rows between from and to (including from and to).
		 */
		
		MyDataFrame mydf = new MyDataFrame();
		ArrayList<String> rownameFilter = new ArrayList<String>();
		ArrayList<String> stateFilter = new ArrayList<String>();
		ArrayList<String> genderFilter = new ArrayList<String>();
		ArrayList<Integer> yearFilter = new ArrayList<Integer>();
		ArrayList<String> nameFilter = new ArrayList<String>();
		ArrayList<Integer> countFilter = new ArrayList<Integer>();		
		
		for(int i = from; i<=to; i++) {	
			rownameFilter.add(rowname.get(i));
			stateFilter.add(state.get(i));
			genderFilter.add(gender.get(i));
			yearFilter.add(year.get(i));
			nameFilter.add(name.get(i));
			countFilter.add(count.get(i));									
		}
				
		mydf = new MyDataFrame(rownameFilter, stateFilter, genderFilter, yearFilter, nameFilter, countFilter);
		return mydf;
		
		
	}
	
	public MyDataFrame loc(String label) {
		/*
		 * Returns the rows starting from label. 
		 */
		MyDataFrame mydf = new MyDataFrame();
		ArrayList<String> rownameFilter = new ArrayList<String>();
		ArrayList<String> stateFilter = new ArrayList<String>();
		ArrayList<String> genderFilter = new ArrayList<String>();
		ArrayList<Integer> yearFilter = new ArrayList<Integer>();
		ArrayList<String> nameFilter = new ArrayList<String>();
		ArrayList<Integer> countFilter = new ArrayList<Integer>();	
		
		int start=0;	
		for(int i = 0; i<this.dim; i++) {
			if (rowname.get(i).equals(label)) {
				start=i;
				break;
			}
		}			
		
		for(int i = start; i<this.dim; i++) {				
			rownameFilter.add(rowname.get(i));
			stateFilter.add(state.get(i));
			genderFilter.add(gender.get(i));
			yearFilter.add(year.get(i));
			nameFilter.add(name.get(i));
			countFilter.add(count.get(i));									
		}
				
		mydf = new MyDataFrame(rownameFilter, stateFilter, genderFilter, yearFilter, nameFilter, countFilter);
		return mydf;
		
		
	}
	
	public MyDataFrame loc(String from, String to) {
		/*
		 * Returns the rows between from and to (including from and to).  
		 */
		MyDataFrame mydf = new MyDataFrame();
		ArrayList<String> rownameFilter = new ArrayList<String>();
		ArrayList<String> stateFilter = new ArrayList<String>();
		ArrayList<String> genderFilter = new ArrayList<String>();
		ArrayList<Integer> yearFilter = new ArrayList<Integer>();
		ArrayList<String> nameFilter = new ArrayList<String>();
		ArrayList<Integer> countFilter = new ArrayList<Integer>();	
		
		int start=0;	
		int end=0;	
		for(int i = 0; i<this.dim; i++) {
			if (rowname.get(i).equals(from)) {
				start=i;
				break;
			}
		}			
		for(int i = start; i<this.dim; i++) {
			if (rowname.get(i).equals(to)) {
				end=i;
				break;
			}
		}
		
		
		for(int i = start; i<=end; i++) {				
			rownameFilter.add(rowname.get(i));
			stateFilter.add(state.get(i));
			genderFilter.add(gender.get(i));
			yearFilter.add(year.get(i));
			nameFilter.add(name.get(i));
			countFilter.add(count.get(i));									
		}
				
		mydf = new MyDataFrame(rownameFilter, stateFilter, genderFilter, yearFilter, nameFilter, countFilter);
		return mydf;
		
		
	}
	
	
	// 6. Sorting
	public MyDataFrame sort(int index) {
		/*
		 * Returns the data sorted by the column specified by index.
		 */				
		WriteLine [] sorted = new WriteLine[this.dim];
		MyDataFrame mydf = new MyDataFrame();
		ArrayList<String> rownameSorted = new ArrayList<String>();
		ArrayList<String> stateSorted = new ArrayList<String>();
		ArrayList<String> genderSorted = new ArrayList<String>();
		ArrayList<Integer> yearSorted = new ArrayList<Integer>();
		ArrayList<String> nameSorted = new ArrayList<String>();
		ArrayList<Integer> countSorted = new ArrayList<Integer>();		
		
		// create a writeLine object for each row in the dataframe, and put all the objects into a list called sorted 
		for (int i=0; i < this.dim; i++) {
			sorted[i]=new WriteLine(rowname.get(i) ,state.get(i), gender.get(i), year.get(i), name.get(i), count.get(i));
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
			rownameSorted.add(sorted[i].getRowname());
			stateSorted.add(sorted[i].getState());
			genderSorted.add(sorted[i].getGender());
			yearSorted.add(sorted[i].getYear());
			nameSorted.add(sorted[i].getName());
			countSorted.add(sorted[i].getCount());
		}					
		mydf = new MyDataFrame(rownameSorted, stateSorted, genderSorted, yearSorted, nameSorted, countSorted);		
		
		return mydf;
		
	} 

	public MyDataFrame sort(String colname) {
		/*
		 * Returns the data sorted by the column specified by name.
		 */
		WriteLine [] sorted = new WriteLine[this.dim];
		MyDataFrame mydf = new MyDataFrame();
		ArrayList<String> rownameSorted = new ArrayList<String>();
		ArrayList<String> stateSorted = new ArrayList<String>();
		ArrayList<String> genderSorted = new ArrayList<String>();
		ArrayList<Integer> yearSorted = new ArrayList<Integer>();
		ArrayList<String> nameSorted = new ArrayList<String>();
		ArrayList<Integer> countSorted = new ArrayList<Integer>();		
		
		// create a writeLine object for each row in the dataframe, and put all the objects into a list called sorted 
		for (int i=0; i < this.dim; i++) {
			sorted[i]=new WriteLine(rowname.get(i) ,state.get(i), gender.get(i), year.get(i), name.get(i), count.get(i));
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
			rownameSorted.add(sorted[i].getRowname());
			stateSorted.add(sorted[i].getState());
			genderSorted.add(sorted[i].getGender());
			yearSorted.add(sorted[i].getYear());
			nameSorted.add(sorted[i].getName());
			countSorted.add(sorted[i].getCount());
		}					
		mydf = new MyDataFrame(rownameSorted,  stateSorted, genderSorted, yearSorted, nameSorted, countSorted);		
		
		return mydf;
	}

	// 7. Aggregation
	public String getMin(int index) {
		/*
		 * Returns the minimum element of the column specified by index.	
		 */
		String minString= "z";
		int minInt = 100000;		
		
		if (index==0) {				
			for (int i = 0; i < this.dim; i++) {
			    if (this.state.get(i).compareTo(minString)<0) {
			    		minString = this.state.get(i);			    	
			    }
			}	
			
		}else if (index==1) {
			for (int i = 0; i < this.dim; i++) {
			    if (this.gender.get(i).compareTo(minString)<0) {
			    		minString = this.gender.get(i);			    		
			    }
			}						
		}else if (index==2) {
			for (int i = 0; i < this.dim; i++) {
			    if (this.year.get(i) < minInt) {
			    		minInt = this.year.get(i);			    	
			    }
			}	
			
			minString = Integer.toString(minInt);
		}else if (index==3) {
			for (int i = 0; i < this.dim; i++) {
			    if (this.name.get(i).compareTo(minString)<0) {
			    		minString = this.name.get(i);			    		
			    }
			}	
		}else {
			for (int i = 0; i < this.dim; i++) {
			    if (this.count.get(i) < minInt) {
			    		minInt = this.count.get(i);			    	
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
		
		if (label=="state") {				
			for (int i = 0; i < this.dim; i++) {
			    if (this.state.get(i).compareTo(minString)<0) {
			    		minString = this.state.get(i);			    	
			    }
			}	
			
		}else if (label=="gender") {
			for (int i = 0; i < this.dim; i++) {
			    if (this.gender.get(i).compareTo(minString)<0) {
			    		minString = this.gender.get(i);			    		
			    }
			}						
		}else if (label=="year") {
			for (int i = 0; i < this.dim; i++) {
			    if (this.year.get(i) < minInt) {
			    		minInt = this.year.get(i);			    	
			    }
			}	
			
			minString = Integer.toString(minInt);
		}else if (label=="name") {
			for (int i = 0; i < this.dim; i++) {
			    if (this.name.get(i).compareTo(minString)<0) {
			    		minString = this.name.get(i);			    		
			    }
			}	
		}else {
			for (int i = 0; i < this.dim; i++) {
			    if (this.count.get(i) < minInt) {
			    		minInt = this.count.get(i);			    	
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
		String maxString= "a";
		int maxInt = 0;		
		
		if (index==0) {				
			for (int i = 0; i < this.dim; i++) {
			    if (this.state.get(i).compareTo(maxString)>0) {
			    	maxString = this.state.get(i);			    	
			    }
			}	
			
		}else if (index==1) {
			for (int i = 0; i < this.dim; i++) {
			    if (this.gender.get(i).compareTo(maxString)>0) {
			    	maxString = this.gender.get(i);			    		
			    }
			}						
		}else if (index==2) {
			for (int i = 0; i < this.dim; i++) {
			    if (this.year.get(i) > maxInt) {
			    	maxInt = this.year.get(i);			    	
			    }
			}	
			
			maxString = Integer.toString(maxInt);
		}else if (index==3) {
			for (int i = 0; i < this.dim; i++) {
			    if (this.name.get(i).compareTo(maxString)>0) {
			    	maxString = this.name.get(i);			    		
			    }
			}	
		}else {
			for (int i = 0; i < this.dim; i++) {
			    if (this.count.get(i) > maxInt) {
			    	maxInt = this.count.get(i);			    	
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
		
		if (label=="state") {				
			for (int i = 0; i < this.dim; i++) {
			    if (this.state.get(i).compareTo(maxString)>0) {
			    	maxString = this.state.get(i);			    	
			    }
			}	
			
		}else if (label=="gender") {
			for (int i = 0; i < this.dim; i++) {
			    if (this.gender.get(i).compareTo(maxString)>0) {
			    	maxString = this.gender.get(i);			    		
			    }
			}						
		}else if (label=="year") {
			for (int i = 0; i < this.dim; i++) {
			    if (this.year.get(i) > maxInt) {
			    	maxInt = this.year.get(i);			    	
			    }
			}	
			
			maxString = Integer.toString(maxInt);
		}else if (label=="name") {
			for (int i = 0; i < this.dim; i++) {
			    if (this.name.get(i).compareTo(maxString)>0) {
			    	maxString = this.name.get(i);			    		
			    }
			}	
		}else {
			for (int i = 0; i < this.dim; i++) {
			    if (this.count.get(i) > maxInt) {
			    	maxInt = this.count.get(i);			    	
			    }
			}	
			
			maxString = Integer.toString(maxInt);
		}
		
		return maxString;
	}
	
	
}
