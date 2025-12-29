package week4.day1assignment;

public class JavaConnection extends MySqlConnection implements DatabaseConnection {

	/* Assignment 3A and 3B
	 * concrete class implements the interface 
	 * interface methods implemented in class with @override
	 * creating object in class to call the methods in main method
	 * */
	@Override
	public void connect() {
		System.out.println("connect abstract method from interface");		
	}

	@Override
	public void disconnect() {
		System.out.println("disconnect abstract method from interface");		
	}

	@Override
	public void executeUpdate() {
		System.out.println("execute update abstract method from interface");		
	}
		
	public static void main(String[] args) {
		JavaConnection java = new JavaConnection();
		
		java.connect();
		java.disconnect();
		java.executeUpdate();
		//non abstract method called from inheriting abstract class using object
		java.executeQuery();
	}

}
