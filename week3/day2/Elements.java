package week3.day2;

public class Elements extends Button{

	public static void main(String[] args) {
		/*
		 * Other classes inherited from WebElement and Button class are not called in this class
		 * Only Button class and WebElement class methods are accessible 
		 * Multi - level Inheritance is used 		  
		 */
		
		//created object for Button class superclass of Elements
		Button btn = new Button();
		//created object for sibling class of Button not an inheritance 
		TextField txt = new TextField();
		
		//methods called from super class WebElement using object of sub class Button
		btn.click();
		btn.setText("WebElements");
		//method called from Button class
		btn.submit();
		//method called from TextField class without inheriting
		txt.getText();
		

		

	}

}
