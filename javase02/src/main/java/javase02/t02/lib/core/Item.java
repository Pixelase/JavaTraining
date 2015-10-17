package javase02.t02.lib.core;

public abstract class Item implements Comparable<Item> {
	private String productName;
	private String producerName;
	private int price;
	private int weight;

	public Item() {
		super();
		productName = "Product Name";
		producerName = "Producer Name";
		price = 0;
		weight = 0;
	}

	public Item(String productName, String producerName, int price, int weight) {
		super();
		this.productName = productName;
		this.producerName = producerName;
		this.price = price;
		this.weight = weight;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + price;
		result = prime * result + ((producerName == null) ? 0 : producerName.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (price != other.price)
			return false;
		if (producerName == null) {
			if (other.producerName != null)
				return false;
		} else if (!producerName.equals(other.producerName))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [price=" + price + ", weight=" + weight + ", productName=" + productName + ", producerName="
				+ producerName + "]";
	}

	public int compareTo(Item o) {
		return (price < o.getPrice()) ? -1 : ((price == o.getPrice()) ? 0 : 1);
	}
}
