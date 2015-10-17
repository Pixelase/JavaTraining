package javase02.t02.lib.core;

public class Paper extends Item {
	private int numberOfPages;
	private double thickness;

	public Paper() {
		super();
		this.numberOfPages = 0;
		this.thickness = 0.0;
	}

	public Paper(String productName, String producerName, int price, int weight, int numberOfPages, double thickness) {
		super(productName, producerName, price, weight);
		this.numberOfPages = numberOfPages;
		this.thickness = thickness;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public double getThickness() {
		return thickness;
	}

	public void setThickness(double thickness) {
		this.thickness = thickness;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + numberOfPages;
		long temp;
		temp = Double.doubleToLongBits(thickness);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Paper other = (Paper) obj;
		if (numberOfPages != other.numberOfPages)
			return false;
		if (Double.doubleToLongBits(thickness) != Double.doubleToLongBits(other.thickness))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Paper [numberOfPages=" + numberOfPages + ", thickness=" + thickness + "]";
	}
}
