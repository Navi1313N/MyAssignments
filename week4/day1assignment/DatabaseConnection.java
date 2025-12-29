package week4.day1assignment;

public interface DatabaseConnection {
	
	//created interface and 3 abstract methods.
	//cannot create object in interface so created a concrete class to implement the below methods.
	public void connect();
	public void disconnect();
	public void executeUpdate();
	

}
