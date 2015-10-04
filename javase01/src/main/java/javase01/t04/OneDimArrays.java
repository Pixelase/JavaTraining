package javase01.t04;

import java.util.Random;

public class OneDimArrays {

	public static int max(int[] array) {
		int n = array.length / 2;
		int max = array[0] + array[2 * n - 1];

		for (int i = 1; i < n; i++) {
			if (array[i] + array[2 * n - 1 - i] > max) {
				max = array[i] + array[2 * n - 1 - i];
			}
		}

		return max;
	}

	public static void main(String[] args) {
		int n = 3;
		int[] a = new int[2 * n];
		Random rand = new Random();
		int bound = 50;

		System.out.println("Original sequence:");
		for (int i = 0; i < 2 * n; i++) {
			a[i] = rand.nextInt(bound);

			System.out.println(a[i]);
		}

		System.out.println("\nRequired sequence:");
		for (int i = 0; i < n; i++) {
			System.out.println(a[i] + " + " + a[2 * n - 1 - i] + " = " + (a[i] + a[2 * n - 1 - i]));
		}

		System.out.println("\nThe maximum element in the required sequence is " + max(a));

	}

}
