package week3.day2;

public class Assignment01FindIntersection {

	public static void main(String[] args) {
		
		int[] a = {3,2,11,4,6,7};
		int[] b = {1,2,8,4,9,7};
		//Finding intersection using nested loop
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				//comparing values from i and j iteration
				if (a[i] == b[j]) {
					System.out.print(a[i]);		
				}
				 
			}
			
		}

	}

}
