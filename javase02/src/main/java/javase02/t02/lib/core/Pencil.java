package javase02.t02.lib.core;

public class Pencil extends Item {
	private String color;
	private String hardness;

	public Pencil() {
		super();
		color = "Color";
		hardness = "Hardness";
	}

	public Pencil(String productName, String producerName, int price, int weight, String color, String hardness) {
		super(productName, producerName, price, weight);
		this.color = color;
		this.hardness = hardness;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getHardness() {
		return hardness;
	}

	public void setHardness(String hardness) {
		this.hardness = hardness;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((hardness == null) ? 0 : hardness.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pencil other = (Pencil) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (hardness == null) {
			if (other.hardness != null)
				return false;
		} else if (!hardness.equals(other.hardness))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Penсil [producName=" + productName + ", color=" + color + ", hardness=" + hardness + ", price=" + price
				+ "]";
	}
}
