package week3.day2;

import java.util.Arrays;

public class Assignment02FindingMissingElementOnArray {

	public static void main(String[] args) {
		
		int[] a = {1,4,3,2,8,6,7};
		Arrays.sort(a);
		//iterated the array values using for loop
		for (int i = 0; i <= a.length -1; i++) {
			//comparing the value of a+1 not equals index of a+1.
			//not equals value is the missing number from array.
			if (a[i]+1!=a[i+1]) {
				System.out.println(a[i]+1);
				break;
			}
			
			
		}
		

	}

	
}
