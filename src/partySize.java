import javax.swing.JOptionPane;

public class partySize extends Pemesanan {//penerapan pewarisan
	//variable (Private)
	private boolean iced;

	public partySize(String size, int amount, Label lbl) {
		super(size,amount);
		if(JOptionPane.showConfirmDialog(lbl, "Apakah Ingin Menambahkan Es?","Ice",JOptionPane.YES_NO_OPTION)==0) iced=true;
		else iced=false;
		double price;
		if(size.equals("Kecil")) price=2000;
		else if(size.equals("Sedang")) price=4000;
		else price=7000;
		if(iced) price*=1.250; 
		setPrice(price);
	}

	@Override
	public String toString() {//
		if(iced) return super.toString()+"Air Dengan Es";
		else return super.toString()+"Air";
	}
}