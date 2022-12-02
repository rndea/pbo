public class Pemesanan {
	private String size;
	private double price;
	private int amount;
	
	public Pemesanan(String size, int amount) {
		super();
		this.size = size;
		this.amount = amount;
		price = 0.0;	
	}

	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return String.format("Pemesanan ");
	}
}