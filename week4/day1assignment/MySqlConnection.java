package week4.day1assignment;

public abstract class MySqlConnection implements DatabaseConnection {
	
	//abstract class implements the interface
	//created a non abstract method in abstract class
	public void executeQuery() {
		System.out.println("Non abtract method created and implemented in abstarct class");
	}

}
