import javax.swing.JOptionPane;

public class VIP extends Pemesanan {
	// Penerapan encapsulation
	private boolean snack;

	public VIP(String size, int amount, Label lbl) {
		super(size,amount);
		if(JOptionPane.showConfirmDialog(lbl, "Apakah Ingin Menambahkan Paket Combo Snack:\n5 Popcorn & 10 Coca-cola","Snack",JOptionPane.YES_NO_OPTION)==0) snack=true;

		else snack=false;
		double price;
		price = 300000;
		if(snack) price += 100000;
		setPrice(price);
	}
	
	@Override
	public String toString() {
		if(snack) return super.toString()+"Theater VIP Dengan Paket Combo Snack";
		else return super.toString()+"Theater VIP";
	}
}