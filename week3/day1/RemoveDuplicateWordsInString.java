package week3.day1;

public class RemoveDuplicateWordsInString {

	public static void main(String[] args) {
		String text = "We learn Java basics as part as of java sessions in java week1";
		int count = 0;

		// storing a string into string array to split each word.
		String[] strArray = text.split(" ");

		// nested for loop to iterate with same string in array
		for (int i = 0; i < strArray.length; i++) {
			for (int j = i + 1; j < strArray.length; j++) {
				// if statement to compare equals string from main for with string in nested for
				// if it equals replace word with empty string
				if (strArray[i].equalsIgnoreCase(strArray[j])) {
					strArray[j] = "";
					count++;
				}
			}
		}
		if (count >= 1) {
			// getting each string inside the strArray and storing it in word variable using':'
			for (String word : strArray) {
				// comparing the stored word with empty string replaced for duplicate
				if (!word.equals("")) {
					// if the word not equal to empty print the word
					// for loop moves to next word in the strArray
					System.out.print(word + " ");
				}
			}

		}
	}
}
