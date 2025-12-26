package week3.day2;

public class BasePage {
	
	//created different methods to call in subclass for method overriding.
	
	public void findElement() {
		System.out.println("find element method");
	}

	public void clickElement() {
		System.out.println("click element method");
	}
	
	public void enterText() {
		System.out.println("enter text method");
	}
	//method to override in subclass
	public void performCommonTasks(int c) {
		String a = "Hello ";
		String b = "Testing";
		System.out.println(a+b+c);
		
		
	}
}
