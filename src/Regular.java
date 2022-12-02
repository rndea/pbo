import javax.swing.JOptionPane;

public class Regular extends Pemesanan {
	private String fruit;
	String[] fruits = {"Ape","Jeruk","Nanas"};

	public Regular(String size, int amount, Label lbl) {
		super(size,amount);
		try {
			fruit = (String) JOptionPane.showInputDialog(lbl,"Pilih Buah.","Pilih Buah",
					JOptionPane.QUESTION_MESSAGE,null,fruits,fruits[0]);
			//Creates a pop up that asks to the user, from which fruit he/she wants his/her juice. Takes lbl as a paramater to display the pop up on the frame
			//If he/she clicks on "OK" following codes will be executed.
			double price;
			if(size.equals("Kecil")) price=15000;
			else if(size.equals("Sedang")) price=17000;
			else price=19000;
			if(fruit.equals("Jeruk")) price*=1.250;
			if(fruit.equals("Pineapple")) price*=1.500;
			setPrice(price);
		}
		catch(NullPointerException e) {
		}
	}
	
	@Override
	public String toString() {
		return super.toString()+fruit+" jus";
	}
}