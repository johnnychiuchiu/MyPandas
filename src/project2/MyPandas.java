package project2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MyPandas {

	
	public MyDataFrame readCSV(String path) throws FileNotFoundException, IOException {
		/*
		 * Read a file and store it into a MyDataFrame object. Possible data types: Integer and String. You can assume that the first row of the .csv file is a header.
		 */
		File file = new File(path);		
		ArrayList<ArrayList<String>> columnList = new ArrayList<ArrayList<String>>();
		ArrayList<String> nameList = new ArrayList<String>();
		
		ArrayList<String> state = new ArrayList<String>();
		ArrayList<String> gender = new ArrayList<String>();
		ArrayList<String> year = new ArrayList<String>();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> count = new ArrayList<String>();
		
		String line = null; 
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {	
			bufferedReader.readLine(); 
			while ((line = bufferedReader.readLine()) != null) {					
				state.add(line.split(",")[1]);
				gender.add(line.split(",")[2]);
				year.add(line.split(",")[3]);
				name.add(line.split(",")[4]);
				count.add(line.split(",")[5]);					    								
			}
		}
		columnList.add(state);
		columnList.add(gender);
		columnList.add(year);
		columnList.add(name);
		columnList.add(count);
		
		nameList.add("state");
		nameList.add("gender");
		nameList.add("year");
		nameList.add("name");
		nameList.add("count");
		
		MyDataFrame mydf = new MyDataFrame(columnList, nameList);
		return mydf;
	}
	
	public void writeCSV(MyDataFrame data, String path) throws IOException {	
		/*
		 * Write a MyDataFrame object to file specified by path.
		 */
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
		bufferedWriter.write(data.toString());
		bufferedWriter.close();		
	}
	
	public MyDataFrame concat(MyDataFrame df1, MyDataFrame df2) {
		/*
		 * Concatenate two MyDataFrame object along rows. Returns the concatenated MyDataFrame.
		 */
		MyDataFrame mydf = new MyDataFrame();
		ArrayList<ArrayList<String>> columnList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> nameList = new ArrayList<String>(df1.nameList);

		
		ArrayList<String> stateConcat = new ArrayList<String>(df1.columnList.get(0));
		ArrayList<String> genderConcat = new ArrayList<String>(df1.columnList.get(1));
		ArrayList<String> yearConcat = new ArrayList<String>(df1.columnList.get(2));
		ArrayList<String> nameConcat = new ArrayList<String>(df1.columnList.get(3));
		ArrayList<String> countConcat = new ArrayList<String>(df1.columnList.get(4));		
				
		stateConcat.addAll(df2.columnList.get(0));
		genderConcat.addAll(df2.columnList.get(1));
		yearConcat.addAll(df2.columnList.get(2));
		nameConcat.addAll(df2.columnList.get(3));
		countConcat.addAll(df2.columnList.get(4));
		
		columnList.add(stateConcat);
		columnList.add(genderConcat);
		columnList.add(yearConcat);
		columnList.add(nameConcat);
		columnList.add(countConcat);
		
		mydf = new MyDataFrame(columnList, nameList);
		return mydf;
		
	}
	
}
