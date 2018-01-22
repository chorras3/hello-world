package exampleClasses.primefacesShowcase;

public class Car {
	private String id;
	private String brand;
	private int year;
	private String color;
	private int price;
	private boolean soldState;

	
	public Car() {
	}
	
	public Car(String id, String brand, int year, String color, int price, boolean soldState) {
		super();
		this.id = id;
		this.brand = brand;
		this.year = year;
		this.color = color;
		this.price = price;
		this.soldState = soldState;
	}

	/**
	 * @return the field to get.
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param the field to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the field to get.
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param the field to set.
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the field to get.
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param the field to set.
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the field to get.
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param the field to set.
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the field to get.
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param the field to set.
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the field to get.
	 */
	public boolean getSoldstate() {
		return soldState;
	}

	/**
	 * @param the field to set.
	 */
	public void setSoldstate(boolean soldState) {
		this.soldState = soldState;
	}

}
