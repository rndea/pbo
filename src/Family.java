import javax.swing.JOptionPane;

public class Family extends Pemesanan {
	private boolean milk; 

	public Family(String size, int amount, Label lbl) {
		super(size,amount);
		if(JOptionPane.showConfirmDialog(lbl, "Ingin Menambahkan Susu?","Milk",JOptionPane.YES_NO_OPTION)==0) milk=true;
		else milk=false;
		double price;
		if(size.equals("Kecil")) price=12500;
		else if(size.equals("Sedang")) price=15000;
		else price=16500;
		if(milk) price*=1.25;
		setPrice(price);
	}

	@Override
	public String toString() {
		if(milk) return super.toString()+" Kopi Dengan Susu";
		else return super.toString()+" Kopi";
	}
}