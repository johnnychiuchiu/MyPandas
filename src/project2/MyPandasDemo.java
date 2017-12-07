package project2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MyPandasDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		MyPandas mypanda = new MyPandas();		
		MyPandasDemo mypandaDemo = new MyPandasDemo();
				
		// Test case of MyDataFrame readCSV(String path) 
		mypandaDemo.separateLine("Test case of MyDataFrame readCSV(String path)");
		MyDataFrame mydf = new MyDataFrame();
		mydf = mypanda.readCSV("state_all.csv");		
//		System.out.println(mydf);	
		mydf = mydf.head(100);
		
		// Test case of writeCSV(MyDataFrame data, String path) Write a MyDataFrame object to file specified by path.
		mypandaDemo.separateLine("Test case of writeCSV(MyDataFrame data, String path)");
		mypanda.writeCSV(mydf.head(5), "head.csv");

		// Test case of MyDataFrame concat(MyDataFrame df1, MyDataFrame df2) Concatenate two MyDataFrame object along rows. Returns the concatenated MyDataFrame.
		mypandaDemo.separateLine("Test case of concat(MyDataFrame df1, MyDataFrame df2)");
		System.out.println(mypanda.concat(mydf.head(5), mydf.tail(1)));
		
		
		//// 1. Head and Tail.
		// Test case of MyDataFrame head(int n) Returns the first n rows of the data.
		mypandaDemo.separateLine("Test case of MyDataFrame head(int 3) Returns the first n rows of the data.");
		System.out.println(mydf.head(3));
		
		// Test case of MyDataFrame tail(int n) Returns the last n rows of the data.
		mypandaDemo.separateLine("Test case of MyDataFrame tail(int 3) Returns the last n rows of the data.");			
		System.out.println(mydf.tail(3));
		
		
		//// 2. dType
		// Test case of String dType(int index) Returns the type of the column specified by index. If the type is not uniform, return ‘String’.
		mypandaDemo.separateLine("Test case of dType(3) Returns the type of the column specified by index.");	
		System.out.println(mydf.dtypes(3));
		
		// Test case of String dType(String name) Returns the type of the column specified by name. If the type is not uniform, return ‘String’.
		mypandaDemo.separateLine("Test case of dType(name) Returns the type of the column specified by name.");	
		System.out.println(mydf.dtypes("name"));
		
		
		//// 3. Slicing
		// Test case of MyDataFrame slice(int index) Returns the column specified by index.
		mypandaDemo.separateLine("Test case of MyDataFrame slice(1) Returns the column specified by index.");	
		System.out.println(mydf.slice(1));
		
		// Test case of MyDataFrame slice(int[] indexArr) Returns the columns specified by an index array.
		mypandaDemo.separateLine("Test case of MyDataFrame slice(int[] indexArr) Returns the columns specified by an index array.");	
		int[] myIntArray = {1,2,4};
		System.out.println(mydf.slice(myIntArray));

		// Test case of MyDataFrame slice(String name) Returns the column specified by name.
		mypandaDemo.separateLine("Test case of MyDataFrame slice(String name) Returns the column specified by name.");
		System.out.println(mydf.slice("name"));
		
		// Test case of MyDataFrame slice(String[] nameArr) Returns the columns specified by a name array.
		mypandaDemo.separateLine("Test case of MyDataFrame slice(String[] nameArr) Returns the columns specified by a name array.");
		String[] myStrArray = {"name","state"};
		System.out.println(mydf.slice(myStrArray));
		
		
		//// 4. Filtering
		// Test case of MyDataFrame filter(String col, String op, Object o) Returns data filtered by applying “col op o” on MyDataFrame object.
		mypandaDemo.separateLine("Test case of filter(String col, String op, Object o) Returns data filtered by applying “col op o” on MyDataFrame object.");
		System.out.println(mydf.filter("name", "=", "Helen"));
		System.out.println(mydf.filter("year", "=", "1911"));		
		System.out.println(mydf.filter("count", ">", "8"));

		
		//// 5. Indexing
		// Test case of MyDataFrame loc(int index) Returns the rows starting from index.
		mypandaDemo.separateLine("Test case of MyDataFrame loc(int index) Returns the rows starting from index.");
		System.out.println(mydf.loc(3));
		System.out.println(mydf.loc(3,6));
		
		
		//// 6. Sorting
		//  Test case of MyDataFrame sort(int index) Returns the data sorted by the column specified by index.
		mypandaDemo.separateLine("Test case of MyDataFrame sort(int 4) Returns the data sorted by the column specified by index.");		
		System.out.println(mydf.sort(4));
		System.out.println(mydf.sort(3));
		
		//  Test case of MyDataFrame sort(String name) Returns the data sorted by the column specified by name.
		mypandaDemo.separateLine("Test case of MyDataFrame sort(String name) Returns the data sorted by the column specified by name.");		
		System.out.println(mydf.sort("count"));
		System.out.println(mydf.sort("name"));
		
		
		//// 7. Aggregation
		// Test case of Object getMin(int index) Returns the minimum element of the column specified by index.
		mypandaDemo.separateLine("Test case of getMin(4) Returns the minimum element of the column specified by index");
		System.out.println(mydf.getMin(3));
		System.out.println(mydf.getMin(2));
		System.out.println(mydf.getMin(4));

		// Test case of Object getMin(String label) Returns the minimum element of the column specified by label.
		mypandaDemo.separateLine("Test case of Object getMin(\"name\") Returns the minimum element of the column specified by label.");
		System.out.println(mydf.getMin("name"));
		System.out.println(mydf.getMin("count"));

		// Test case of Object getMax(int index) Returns the maximum element of the column specified by index.
		mypandaDemo.separateLine("Test case of Object getMax(4) Returns the maximum element of the column specified by index");
		System.out.println(mydf.getMax(3));
		System.out.println(mydf.getMax(4));		
		
		// Test case of Object getMax(String label) Returns the maximum element of the column specified by label.
		mypandaDemo.separateLine("Test case of Object getMax(\"name\") Returns the maximum element of the column specified by index");
		System.out.println(mydf.getMax("name"));
		System.out.println(mydf.getMax("count"));						
	}
	
	private void separateLine(String title) {
		System.out.println("==========================================");
		System.out.println(title+"\n");
	}
}
