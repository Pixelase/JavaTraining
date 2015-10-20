package javase02.t02.lib.core;

public class Ruler extends Item {
	private int length;
	private String material;

	public Ruler() {
		super();
		this.length = 0;
		this.material = "Material";
	}

	public Ruler(String productName, String producerName, int price, int weight, int length, String material) {
		super(productName, producerName, price, weight);
		this.length = length;
		this.material = material;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + length;
		result = prime * result + ((material == null) ? 0 : material.hashCode());
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
		Ruler other = (Ruler) obj;
		if (length != other.length)
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ruler [producName=" + productName + ", length=" + length + ", material=" + material + ", price=" + price
				+ "]";
	}
}
