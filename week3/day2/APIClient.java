package week3.day2;

public class APIClient {
	
	//Method Overloading concept 
	//creating 2 methods with same signature and different arguments
	
	public void sendRequest(String endpoint) {
		
		System.out.println("endpoint: "+ endpoint);
	}
	public void sendRequest(String endpoint, String requestBody, Boolean  requestStatus) {
		System.out.println("\nsame method name with different parameter called");
		System.out.println("EndPoint: "+endpoint);
		System.out.println("Request Body: "+requestBody);
		System.out.println("Request Status: "+requestStatus);	
	}
	//main method to call the methods to run
	public static void main(String[] args) {
		
		//creating object for main class
		APIClient api = new APIClient();
		
		//method call for method overloading with different arguments
		api.sendRequest("IPV06");
		api.sendRequest("IPV04", "request", true);
		
	}

}

