package project2;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * class SortBySalary define the way to sort WriteLine object
 * @author johnnychiu
 *
 */

class SortByState implements Comparator<WriteLine>
{
    // Used for sorting in ascending order of
    // roll number
	
    public int compare(WriteLine a, WriteLine b)
    {
    		return a.state.compareTo(b.state);
//        return a.name - b.name;
    }
}