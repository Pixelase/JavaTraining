package javase02.t03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javase02.t02.lib.core.Item;
import javase02.t02.lib.core.Paper;
import javase02.t02.lib.core.Pen;
import javase02.t02.lib.core.Pencil;
import javase02.t02.lib.core.Ruler;

public class BeginersPack {
	public static List<Item> generateItems(int maxItemsPrice) {
		List<Item> items = new ArrayList<>(4);
		Random rand = new Random();
		int itemsWeight = 15;

		items.add(new Paper("Paper", "Belarus paper", rand.nextInt(maxItemsPrice), itemsWeight, 1000, 0.5));
		items.add(new Pen("RedPen", "Parker", rand.nextInt(maxItemsPrice), itemsWeight, "Red", "Metal"));
		items.add(new Pen("BluePen", "Parker", rand.nextInt(maxItemsPrice), itemsWeight, "Blue", "Metal"));
		items.add(new Pencil("HardPencil", "Pencils corp", rand.nextInt(maxItemsPrice), itemsWeight, "Gray", "Hard"));
		items.add(new Pencil("LightPencil", "Pencils corp", rand.nextInt(maxItemsPrice), itemsWeight, "Gray", "Light"));
		items.add(new Ruler("Ruler", "Ruler corp", rand.nextInt(maxItemsPrice), itemsWeight, 30, "Wood"));

		return items;
	}
}
