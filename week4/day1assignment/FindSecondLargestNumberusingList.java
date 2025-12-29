package week4.day1assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindSecondLargestNumberusingList {

	public static void main(String[] args) {
		int[] a = {3,2,11,4,6,7};
		//created collection list to store the array values
		List<Integer> num = new ArrayList<Integer>();
		
		//using for each loop iterating each value and savings it in a variable
		//adding the values in integer into list
		for (Integer integer : a) {
			num.add(integer);
		}
		//sorted the list
		Collections.sort(num);
		
		System.out.println("data inside the List after sorting: "+num);
		//to get second last number using size method -2. hence -1 returns the last value.
		Integer lastSecondNumber = num.get(num.size()-2);
		System.out.println("Last second number in Array List: " + lastSecondNumber);
		
	}

}
