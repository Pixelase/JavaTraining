package javase02.t01;

public class Pen {
	private int price;
	private String productName;
	private String producerName;
	private String color;
	private String materials;

	public Pen(int price, String productName, String producerName, String color, String materials) {
		super();
		this.price = price;
		this.productName = productName;
		this.producerName = producerName;
		this.color = color;
		this.materials = materials;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((materials == null) ? 0 : materials.hashCode());
		result = prime * result + price;
		result = prime * result + ((producerName == null) ? 0 : producerName.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
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
		return true;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " [price=" + price + ", productName=" + productName + ", producerName="
				+ producerName + ", color=" + color + ", materials=" + materials + "]";
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
}
