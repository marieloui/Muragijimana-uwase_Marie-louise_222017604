package patient_tracker_forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import patient_tracker_entities.appointment;
import patient_tracker_entities.billing;

public class billing_form implements ActionListener  {
	
	JFrame frame;//PatientID;BillingID;DoctorID;Amount;BillingtDate;
	JLabel BillingID_lb=new JLabel("BillingID");
	JLabel PatientID_lb=new JLabel("PatientID");
	JLabel DoctorID_lb=new JLabel("DoctorID");
	JLabel BillingDate_lb=new JLabel("BillingDate");
	JLabel Amount_lb=new JLabel("Amount");
	
	JTextField BillingID_txf=new JTextField();

	JTextField PatientID_txf=new JTextField();
		JTextField DoctorID_txf=new JTextField();
				JTextField BillingDate_txf=new JTextField();
JTextField Amount_txf=new JTextField();
	
	
	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_tbtn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	JTable table=new JTable();
	JScrollPane scrollPane = new JScrollPane(table);

	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();


	public billing_form() {
		createForm();

	}
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_tbtn.addActionListener(this);
		delete_btn.addActionListener(this);
		
		//EmailBox.addActionListener(this);
	}
	private void createForm() {
		frame=new JFrame();
		 JLabel titleLabel = new JLabel(" welcome to Login Form");
	        titleLabel.setForeground(Color.blue);
	        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
	        titleLabel.setHorizontalAlignment(JLabel.CENTER);

	    
		frame.setBounds(2, 4, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(2, 0, 2,0));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();
		
	}
	
	   
	private void setLocationandSize() {
		BillingID_lb.setBounds(10, 10, 300, 30);
		PatientID_lb.setBounds(10, 50, 300, 30);
		DoctorID_lb.setBounds(10, 90, 300, 30);
		BillingDate_lb.setBounds(10, 130, 300, 30);
		Amount_lb.setBounds(10, 170, 300, 30);
		
		BillingID_txf.setBounds(160, 10, 300, 30);
		PatientID_txf.setBounds(160, 50, 300, 30);
		DoctorID_txf.setBounds(160, 90, 300, 30);
		BillingDate_txf.setBounds(160, 130, 300, 30);
		Amount_txf.setBounds(160, 170, 300, 30);
		
		//Buttons CRUD
		insert_btn.setBounds(150,250, 85, 30);
		Read_btn.setBounds(250,250, 85, 30);
		update_tbtn.setBounds(350,250, 85, 30);
		delete_btn.setBounds(450,250, 85, 30);
		table.setBounds(500, 10, 500, 300);
		setFontforall();
		addcomponentforFrame();

	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		PatientID_lb.setFont(font);
		BillingID_lb.setFont(font);
		DoctorID_lb.setFont(font);
		Amount_lb.setFont(font);
		BillingDate_lb.setFont(font);

		PatientID_txf.setFont(font);
		BillingID_txf.setFont(font);
		DoctorID_txf.setFont(font);
		Amount_txf.setFont(font);
	    BillingDate_txf.setFont(font);
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		insert_btn.setFont(fonti);
		insert_btn.setBackground(Color.ORANGE);
		Read_btn.setFont(fonti);
		Read_btn.setBackground(Color.WHITE);
		update_tbtn.setFont(fonti);
		update_tbtn.setBackground(Color.CYAN);
		delete_btn.setFont(fonti);
		delete_btn.setBackground(Color.RED);
	}
	private void addcomponentforFrame() {
		frame.add(PatientID_lb);
		frame.add(BillingID_lb);
		frame.add(DoctorID_lb);
		frame.add(Amount_lb);
		frame.add(BillingDate_lb);
		
		frame.add(PatientID_txf);
		frame.add(BillingID_txf);
		frame.add(DoctorID_txf);
		frame.add(Amount_txf);
		frame.add(BillingDate_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add( table);
		

		
		ActionEvent();
	}

      	
	
	/*billing b=new billing ();
	
	if (e.getSource()==insert_btn) {
		
	}
	b.setBillingID(BillingID_txf.getText());
	
	b.setPatientID(PatientID_txf.getText());
	
	b.setDoctorID(DoctorID_txf.getText());
	
	b.setBillingDate(BillingDate_txf.getText());
	
	b.setAmount(Amount_txf.getText());

	
	b.insertData();

	
}
	
    else if ((e.getSource()==Read_btn)) {
	int PatientID=Integer.parseInt(PatientID_txf.getText());
	b.readwithid(PatientID);
	
	
	PatientID_txf.setText(String.valueOf(b.getPatientID()));
	BillingID_txt.setText(b.getBillingID());
	DoctorID_txf.setText(b.getDoctorID());
	BillingDate_txf.setText(b.getBillingDate());
	
	Amount_txf.setText(ap.getAmount());

}

else if (e.getSource()==update_btn) {
	int PatientID=Integer.parseInt(PatientID_txf.getText());
	b.setBillingID(BillingID_txf.getText());
	b.setDoctorID(DoctorID_txf.getText());
	
	b.setBillingDate(BillingDate_txf.getText());
	b.setAmount(Amount_txf.getText());
	
	b.update(PatientID);
	
}else {
	int PatientID=Integer.parseInt(PatientID_txf.getText());
	b.delete(PatientID);
}*/


public static void main(String[] args) {
	// TODO Auto-generated method stub

	
	billing_form b=new billing_form();
	
}


	


	

		@Override
		public void actionPerformed(java.awt.event.ActionEvent e) {
			billing b=new billing ();
			
			if (e.getSource()==insert_btn) {
				
				
				b.setPatientID(PatientID_txf.getText());
				
				b.setDoctorID(DoctorID_txf.getText());
				
				b.setBillDate(BillingID_txf.getText());
				
				b.setAmount(Amount_txf.getText());

				
				b.insertData();
			
			

			
			
		}
			else if ((e.getSource()==Read_btn)) {
				DefaultTableModel tableModel=b.populateTable();
				table.setModel(tableModel);	
		
			}
			else if (e.getSource()==update_tbtn) {
				int BillID=Integer.parseInt(BillingDate_txf.getText());
				b.setPatientID(PatientID_txf.getText());
				b.setDoctorID(DoctorID_txf.getText());
				
				b.setBillDate(BillingDate_txf.getText());
				b.setAmount(Amount_txf.getText());
				
				b.update(BillID);
				
			}else {
				int BillID=Integer.parseInt(BillingID_txf.getText());
				b.delete(BillID);
	}
}
}
