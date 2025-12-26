package week3.day1;

public class ReverseOddWordInString {

	public static void main(String[] args) {
		String text = "I am an software tester in testleaf";

		// storing a string into string array to split each word.
		String[] strArray = text.split(" ");

		for (int i = 0; i < strArray.length; i++) {
			if (i % 2 == 1) {
				char[] charArray = strArray[i].toCharArray();
				for (int j = charArray.length - 1; j >= 0; j--) {

					System.out.print(charArray[j]);
				}
			}
			else { 

				System.out.print(strArray[i]);
			}
			System.out.print(" ");
		}

	}

}
