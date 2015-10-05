package javase01.t05;

public class TwoDimArrays {

	public static int[][] getArray(int size) {
		int a[][] = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				a[i][j] = (i == j || j == size - 1 - i) ? 1 : 0;
			}
		}

		return a;
	}

	public static void printArray(int[][] twoDimArray) {
		for (int[] oneDimArray : twoDimArray) {
			for (int element : oneDimArray) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int size = 6;

		printArray(getArray(size));
	}

}
