package week3.day1;

public class ChangeOddIndexToUppercase {

	public static void main(String[] args) {
		String name = "change index";
		//converted string into char array
		char[] charArray = name.toCharArray();
		//iterated the vales in char array and found the odd index using condition
		//using toUpperCase method odd index char are changed to upper case
		for (int i = 0; i <= charArray.length-1; i++) {			
			if (i % 2 == 1) {
				charArray[i] = Character.toUpperCase(charArray[i]);								
			}			
		}
		//outside the loop printing the values for char array
		System.out.println(charArray);
	}

}
