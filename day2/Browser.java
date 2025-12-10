package week1.day2;

public class Browser {

	void launchBrowser(String browserName) {
		System.out.println(browserName);

	}

	public String loadUrl() {

		return "Url loaded successfully";
	}

	public static void main(String[] args) {
		Browser br = new Browser();

		br.launchBrowser("Chrome");
		System.out.println(br.loadUrl());

	}

}
