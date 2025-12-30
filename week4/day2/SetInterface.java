package week4.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetInterface {

	public static void main(String[] args) {
		
		String companyName = "google";
		char[] charArray = companyName.toCharArray();
		Set<Character> name = new LinkedHashSet<Character>();

		for (int i = 0; i < charArray.length; i++) {
			
			name.add(charArray[i]);
			
		}
		System.out.println("Uique char in the given string are: "+ name);

	}

} 
