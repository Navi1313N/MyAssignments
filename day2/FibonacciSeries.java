package week1.day2;

public class FibonacciSeries {

	public static void main(String[] args) {

		int range = 8;
		int a = 0;
		int b = 1;

		System.out.println("Fibonacci series till range: " + range);

		for (int i = 1; i <= range; i++) {

			System.out.println(a);

			int nextNum = a + b;
			a = b;
			b = nextNum;

		}

	}

}
