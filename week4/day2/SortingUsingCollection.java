package week4.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortingUsingCollection {

	public static void main(String[] args) {
		
		String[] companies =  {"HCL", "Wipro", "Aspire Systems", "CTS"} ;
		List<String> companyList = new ArrayList<>();
		
		//Adding the data into List using index value in array.
		//another way to add in for each loop
		companyList.add(companies[0]);
		companyList.add(companies[1]);
		companyList.add(companies[2]);
		companyList.add(companies[3]);
		//sorting in accending order
		Collections.sort(companyList);
				
		System.out.println("Company names after sorting: "+companyList);
		
		/*
		 * created empty list to store reversed string. 
		 * iterating the values of list using i and reversing it in for loop .
		 * added the iterated i values in empty list created.
		 */
		List<String> reversedList = new LinkedList<>();					
		for (int i = companyList.size()-1; i >= 0; i--) {
			reversedList.add(companyList.get(i));
			
		}
		System.out.println("Reversing in decending order: "+reversedList); 

	}

}
