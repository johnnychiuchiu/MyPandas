package project2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class test {

	public static void main(String[] args) {
		ArrayList<Integer> mylist = new ArrayList<Integer>();
		
		mylist.add(1);
		mylist.add(4);
		mylist.add(10);
		
		for(int i = 0; i < mylist.size(); i++) {   
            System.out.print(mylist.get(i)+"\n");
        }  
		
		
		ArrayList<Double> nfit = new ArrayList<Double>();
		nfit.add(2.0);
		nfit.add(1.0);
		nfit.add(1.0);
		nfit.add(8.0);
		nfit.add(3.0);
		ArrayList<Double> nstore = new ArrayList<Double>(nfit); // may need to be new ArrayList(nfit)
		System.out.println(nfit);
		Collections.sort(nfit);
		System.out.println(nfit);
		int[] indexes = new int[nfit.size()];
		for (int n = 0; n < nfit.size(); n++){
		    indexes[n] = nstore.indexOf(nfit.get(n));
		}
		System.out.println(Arrays.toString(indexes));
		
		
		ArrayList<Integer> nfit2 = new ArrayList<Integer>();
		nfit2.add(1);
		nfit2.add(2);
		nfit2.add(3);
		nfit2.add(2);
		nfit2.add(4);
		nfit2.add(5);
		System.out.println(nfit2);
		ArrayList<Integer> sorted_nfit2 = new ArrayList<Integer>();
		int tempInt=0;
		for(int n = 0; n < nfit.size(); n++) {
			System.out.println(indexes[n]);
			tempInt=indexes[n];
			sorted_nfit2.add(nfit2.get(tempInt));
		}
		System.out.println(sorted_nfit2);
		
		
	}
	
}
