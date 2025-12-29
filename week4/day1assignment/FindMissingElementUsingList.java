package week4.day1assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMissingElementUsingList {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 10, 6, 8 };
		List<Integer> num = new ArrayList<Integer>();
		List<Integer> missing = new ArrayList<Integer>();
		// using for each loop iterating each value and savings it in a variable
		// adding the values in integer into list
		for (Integer integer : a) {
			num.add(integer);
		}
		Collections.sort(num);
		System.out.println(num);
		// iterating the values inside the arraylist
		for (int i = 0; i < num.size() - 1; i++) {
			// getting value of i from for loop and save it in variable
			int b = num.get(i);
			// again get the value of i and add 1 and save it in variable
			int c = num.get(i + 1);
			/*
			 * using for loop finding the missing number by iterating and adding 1 to the value
			 * of b and it should be less than value of c
			 */
			for (int j = b + 1; j < c; j++) {
				//missing numbers added to empty arraylist to print
				missing.add(j);
			}
		}
		System.out.println(missing);
	}
}
