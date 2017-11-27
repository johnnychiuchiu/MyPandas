package project2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Student {

	 public static void main(String[] args) {

	   List<Integer> idList = new ArrayList<Integer>();
	   idList.add(5);
	   idList.add(2);
	   idList.add(4);
	   idList.add(1);
	   idList.add(3);

	   List<String> nameList = new ArrayList<String>();
	   nameList.add("Priya");
	   nameList.add("Pooja");
	   nameList.add("Sneha");
	   nameList.add("Ritesh");
	   nameList.add("Nikita");

	   Map<Integer, String> map = new HashMap<Integer, String>();
	   for(int i = 0; i < idList.size(); i++) {
	      map.put(idList.get(i), nameList.get(i));   
	   }

	   List<Integer> list = new ArrayList<Integer>(map.keySet());
//	   Collection.sort(list);
	   idList.clear();
	   nameList.clear();

	   for(int i = 0; i < map.size(); i++) {
	      idList.add(list.get(i));
	      nameList.add(map.get(list.get(i)));
	   }


	 }
}
