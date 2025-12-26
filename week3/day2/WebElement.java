package week3.day2;

public class WebElement {
	
	//created 2 methods inside WebElement superclass
	public void click() {
		System.out.println("click method is called from super class");
	}

	public void setText(String text) {
		System.out.println("Set text method called from super class. " + "String parameter displayed: "+ text);
		
	}
}
