package javase01.t02;

import java.util.Random;

public class WithWhileLoop {
	public static void main(String[] args) {
		int size = 10;
		int[] intArray = new int[10];
		Random rand = new Random();
		int bound = 50;
		int i = 0, temp = 0;

		System.out.println("Original array:");
		while (i < size) {
			do {
				temp = rand.nextInt(bound);
			} while (temp % 2 != 0);

			intArray[i] = temp;

			System.out.println(intArray[i]);
			i++;
		}

		i = 0;
		System.out.println("\nModified array:");
		while (i < size) {
			if (i % 2 != 0) {
				System.out.print(intArray[i] + "*" + intArray[i - 1] + " = ");
				intArray[i] *= intArray[i - 1];
			}
			System.out.println(intArray[i]);
			i++;
		}
	}
}
