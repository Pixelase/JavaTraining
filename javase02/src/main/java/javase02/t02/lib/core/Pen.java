package javase02.t02.lib.core;

public class Pen extends Item {
	private String color;
	private String materials;

	public Pen() {
		super();
		this.color = "Color";
		this.materials = "Materials";
	}

	public Pen(String productName, String producerName, int price, int weight, String color, String materials) {
		super(productName, producerName, price, weight);
		this.color = color;
		this.materials = materials;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaterials() {
		return materials;
	}

	public void setMaterials(String materials) {
		this.materials = materials;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((materials == null) ? 0 : materials.hashCode());
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
		Pen other = (Pen) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (materials == null) {
			if (other.materials != null)
				return false;
		} else if (!materials.equals(other.materials))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pen [producName=" + productName + ", color=" + color + ", materials=" + materials + ", price=" + price
				+ "]";
	}
}
