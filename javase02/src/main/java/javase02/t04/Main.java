package javase02.t04;

//import javase02.t03.BeginersPack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javase02.t02.lib.core.Item;
import javase02.t02.lib.core.Paper;
import javase02.t02.lib.core.Pen;
import javase02.t02.lib.core.Pencil;
import javase02.t02.lib.core.Ruler;

public class Main {

	public static <T> void printList(List<T> list) {
		for (T element : list) {
			System.out.println(element);
		}
	}

	public static void main(String[] args) {
		int maxItemsPrice = 600;

		// List<Item> items = BeginersPack.generateItems(maxItemsPrice);
		List<Item> items = new ArrayList<>();
		Random rand = new Random();
		int itemsWeight = 15;

		items.add(new Paper("Paper", "Belarus paper", rand.nextInt(maxItemsPrice), itemsWeight, 1000, 0.5));
		items.add(new Pen("BluePen", "Parker", 16, itemsWeight, "Blue", "Metal"));
		items.add(new Pencil("BPencil", "Pencils corp", 6, itemsWeight, "Gray", "Hard"));
		items.add(new Pencil("APencil", "Pencils corp", 6, itemsWeight, "Gray", "Light"));
		items.add(new Ruler("Ruler", "Ruler corp", rand.nextInt(maxItemsPrice), itemsWeight, 30, "Wood"));
		items.add(new Pen("RedPen", "Parker", 16, itemsWeight, "Red", "Metal"));
		items.add(new Paper("Paper", "Belarus paper", 6, itemsWeight, 1000, 0.5));

		/*
		 * Sort by price, because Comparable<? super T> interface had been
		 * implemented in Item abstract class for price comparison.
		 */
		System.out.println("> Items sorted by price: ");
		items.sort(null);
		printList(items);
		System.out.println();

		/*
		 * Sort by name of item by overriding method compare(T o1, T o2) in
		 * anonymous class that implements Comparator<T> interface.
		 */
		System.out.println("> Items sorted by name: ");
		items.sort(new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				return o1.getProductName().compareToIgnoreCase(o2.getProductName());
			}
		});
		printList(items);
		System.out.println();

		/*
		 * Sort by price and name of item by overriding method compare(T o1, T
		 * o2) in anonymous class that implements Comparator<T> interface.
		 */
		System.out.println("> Items sorted by price and name: ");
		items.sort(new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				return (o1.getPrice() < o2.getPrice()) ? -1
						: o1.getProductName().compareToIgnoreCase(o2.getProductName());
			}
		});
		printList(items);
		System.out.println();
	}

}
