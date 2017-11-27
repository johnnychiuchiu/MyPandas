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
		ArrayList<String> rowname = new ArrayList<String>();
		ArrayList<String> state = new ArrayList<String>();
		ArrayList<String> gender = new ArrayList<String>();
		ArrayList<Integer> year = new ArrayList<Integer>();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		
		String line = null; 
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {	
			bufferedReader.readLine(); 
			while ((line = bufferedReader.readLine()) != null) {	
				rowname.add(line.split(",")[0]);
				state.add(line.split(",")[1]);
				gender.add(line.split(",")[2]);
				year.add(Integer.valueOf(line.split(",")[3]));
				name.add(line.split(",")[4]);
				count.add(Integer.valueOf(line.split(",")[5]));
					    									
			}
		}
		
		MyDataFrame mydf = new MyDataFrame(rowname, state, gender, year, name, count);
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
		ArrayList<String> rownameConcat = new ArrayList<String>(df1.rowname);
		ArrayList<String> stateConcat = new ArrayList<String>(df1.state);
		ArrayList<String> genderConcat = new ArrayList<String>(df1.gender);
		ArrayList<Integer> yearConcat = new ArrayList<Integer>(df1.year);
		ArrayList<String> nameConcat = new ArrayList<String>(df1.name);
		ArrayList<Integer> countConcat = new ArrayList<Integer>(df1.count);		
		
		rownameConcat.addAll(df2.rowname);
		stateConcat.addAll(df2.state);
		genderConcat.addAll(df2.gender);
		yearConcat.addAll(df2.year);
		nameConcat.addAll(df2.name);
		countConcat.addAll(df2.count);
		
		mydf = new MyDataFrame(rownameConcat, stateConcat, genderConcat, yearConcat, nameConcat, countConcat);
		return mydf;
		
	}
	
}
