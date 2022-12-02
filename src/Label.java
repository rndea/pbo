import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Label extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JLabel lblSize,lblBev,lblGlass,lblReport;
	private JComboBox<String> size;
	private JRadioButton rdRegular,rdParty,rdVIP,rdFamily;
	private ButtonGroup btnGroup;
	private JTextField txtGlass;
	private JButton btnAdd,btnOrder;
	int amount_of;
	ArrayList<Pemesanan> list_of_mnm = new ArrayList<Pemesanan>();
	
	public Label() {
		setLayout(null);
		setSize(600,400);
		setLocationRelativeTo(null);
		setTitle("Pesan");
		init();
		btnAdd.addActionListener(this); 
		btnOrder.addActionListener(this);
		setVisible(true);
	}
	
	public void init() {
		lblSize = new JLabel("Pilih Ukuran:");// a JLabel that labels the comboBox
		lblSize.setSize(250, 50);
		lblSize.setLocation(100, 10);
		add(lblSize);
		
		String[] sizes = {"Kecil","Sedang","Besar"};
		size = new JComboBox<String>(sizes);//
		size.setSelectedIndex(0);//Ukuran Standar adalah Ukuran Kecil
		size.setSize(100, 25);
		size.setLocation(100, 50);
		add(size);
		
		lblBev = new JLabel("Theater Yang Ingin Dipesan:");//a JLabel that labels the radioButtons
		lblBev.setSize(500, 50);
		lblBev.setLocation(100, 75);
		add(lblBev);
		
		btnGroup = new ButtonGroup();
		
		rdRegular = new JRadioButton("Regular");
		rdRegular.setSize(75, 50);
		rdRegular.setLocation(100, 110);
		add(rdRegular);
		
		rdParty = new JRadioButton("Party Size");
		rdParty.setSize(100, 50);
		rdParty.setLocation(175, 110);
		add(rdParty);
		
		rdVIP = new JRadioButton("VIP");
		rdVIP.setSize(50, 50);
		rdVIP.setLocation(275, 110);
		add(rdVIP);
		
		rdFamily = new JRadioButton("Family");
		rdFamily.setSize(75, 50);
		rdFamily.setLocation(325, 110);
		add(rdFamily);
		
		btnGroup.add(rdRegular);
		btnGroup.add(rdParty);
		btnGroup.add(rdVIP);
		btnGroup.add(rdFamily);
		
		lblGlass = new JLabel("Berapa Banyak Yang Ingin Dipesan:");//a JLabel that labels the Text Field
		lblGlass.setSize(500, 50);
		lblGlass.setLocation(100, 145);
		add(lblGlass);
		
		txtGlass = new JTextField();//a JTextField to get how many glasses of Pemesanan is the user want
		txtGlass.setSize(300, 25);
		txtGlass.setLocation(100, 185);
		add(txtGlass);
		
		btnAdd = new JButton("Tambah");
		btnAdd.setSize(120, 40);
		btnAdd.setLocation(100, 230);
		add(btnAdd);
		
		btnOrder = new JButton("Pesan");
		btnOrder.setSize(120, 40);
		btnOrder.setLocation(280, 230);
		btnOrder.setEnabled(false);
		add(btnOrder);
		
		lblReport = new JLabel();//will be showing report of the Minumans that added.
		lblReport.setSize(500, 50);
		lblReport.setLocation(100, 270);
		add(lblReport);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String size_of = (String)size.getSelectedItem();
		if(e.getSource().equals(btnAdd)) {
			if( rdRegular.isSelected() || rdVIP.isSelected() || rdFamily.isSelected() || rdParty.isSelected() && !(txtGlass.getText().isEmpty())) {
				try {
					amount_of  = Integer.parseInt(txtGlass.getText().trim());
					Pemesanan bvg;
					if(rdRegular.isSelected())  { bvg = new Regular(size_of,amount_of,this); }
					else if(rdParty.isSelected())  { bvg = new partySize(size_of,amount_of,this); }
					else if(rdVIP.isSelected())    { bvg = new VIP(size_of,amount_of,this); }
					else { bvg = new Family(size_of,amount_of,this); }
					txtGlass.setText(null);
					list_of_mnm.add(bvg);
					lblReport.setText(bvg.toString()+" Telah Berhasil Dipesan");
					btnGroup.clearSelection();
					btnOrder.setEnabled(true);
				}
				catch(NumberFormatException e1) {//jika data tertulis di TextField tidak dapat dikonversi ke integer[String,char,double etc...]
					JOptionPane.showMessageDialog(this, "Masukan Jumlah Pesanan Minimal 1 ");
				}
			}	
			else { JOptionPane.showMessageDialog(this, "Pilih Jenis Pemesanan Dan Silahkan Pesan");
			//jika tidak ada tombol radio yang dipilih atau textField kosong
			}
		}
		if(e.getSource().equals(btnOrder)) {
			String report = "";
			double pay=0.0;
			for(int i=0;i<list_of_mnm.size();i++) {
				Pemesanan bvgi = list_of_mnm.get(i);
				report += bvgi.toString();
				double totalprice_of_bvg = bvgi.getAmount() * bvgi.getPrice();
				pay += totalprice_of_bvg;
				report = report + " - "+totalprice_of_bvg+" Rupiah\n";
			}
			JOptionPane.showMessageDialog(this, report);
			JOptionPane.showMessageDialog(this,	 "Anda Diperkenankan Membayar Sebesar "+pay+" Rupiah");
			lblReport.setText(null);
			btnOrder.setEnabled(false);
			list_of_mnm.clear();
		}	
	}

	public static void main(String[] args) {
		new Label();
	}
}
