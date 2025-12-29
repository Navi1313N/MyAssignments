package week4.day1assignment;

import java.util.ArrayList;
import java.util.List;

public class FindIntersectionUsingList {

	public static void main(String[] args) {

		int[] a = {3,2,11,4,6,7};
		int[] b = {1,2,8,4,9,7};
		//created empty list to add the intersection numbers
		List<Integer> intersection = new ArrayList<Integer>();

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				//comparing values from i and j iteration
				if (a[i] == b[j]) {
					//adding the values on a[i] in empty list created above
					intersection.add(a[i]);
				}				 
			}			
		}
		System.out.println("Intersection numbers printed using collection List " + intersection);		
	}

}
