package week3.day2;

public class LoginPage extends BasePage{
	
	//method overriding created an method with same name and arguments in subclass.
	//arguments inside method are overridden
	public void performCommonTasks(int c) {
		int a = 5;
		int b = 7;
		
		System.out.println(a+b+c);
	}

	public static void main(String[] args) {
		LoginPage lg = new LoginPage();
		//overriding method and prints the override data
		lg.performCommonTasks(7);
		//other methods from superclass
		lg.findElement();
		lg.clickElement();
		lg.enterText();
		

	}

}
