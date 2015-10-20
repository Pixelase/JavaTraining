package javase02.t03;

import javase02.t02.lib.core.Item;

public class Main {

	public static void main(String[] args) {
		int maxItemsPrice = 600;

		for (Item item : BeginersPack.generateItems(maxItemsPrice)) {
			System.out.println(item);
		}
	}

}
