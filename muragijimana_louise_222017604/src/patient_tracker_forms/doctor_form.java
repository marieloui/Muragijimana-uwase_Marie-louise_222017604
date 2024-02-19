

	package patient_tracker_forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import patient_tracker_entities.appointment;
import patient_tracker_entities.doctor;
import patient_tracker_entities.patient;

public class doctor_form implements ActionListener {

	JFrame frame;//DoctorID;FirstName;LastName;Speciality;PhoneNumber;
	JLabel DoctorID_lb=new JLabel("DoctorID");
	JLabel FirstName_lb=new JLabel("FirstName");
	JLabel LastName_lb=new JLabel("LastName");
	JLabel Speciality_lb=new JLabel("Speciality");
	JLabel PhoneNumber_lb=new JLabel("PhoneNumber");
	JLabel Email_lb=new JLabel("Email");

	JTextField DoctorID_txf=new JTextField();
	JTextField FirstName_txf=new JTextField();
	JTextField LastName_txf=new JTextField();
	JTextField Speciality_txf=new JTextField();
	JTextField PhoneNumber_txf=new JTextField();

	JTextField Email_txf = new JTextField();

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


	public doctor_form() {
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
		DoctorID_lb.setBounds(10, 10, 300, 30);
		FirstName_lb.setBounds(10, 50, 300, 30);
		LastName_lb.setBounds(10, 90, 300, 30);
		Speciality_lb.setBounds(10, 130, 300, 30);
		PhoneNumber_lb.setBounds(10, 170, 300, 30);
		Email_lb.setBounds(10, 210, 300, 30);
		DoctorID_txf.setBounds(160, 10, 300, 30);
		FirstName_txf.setBounds(160, 50, 300, 30);
		LastName_txf.setBounds(160, 90, 300, 30);
		Speciality_txf.setBounds(160, 130, 300, 30);
		PhoneNumber_txf.setBounds(160, 170, 300, 30);
		Email_txf.setBounds(160, 210, 300, 30);
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

		DoctorID_lb.setFont(font);
		FirstName_lb.setFont(font);
		LastName_lb.setFont(font);
		Speciality_lb.setFont(font);
		PhoneNumber_lb.setFont(font);

		DoctorID_txf.setFont(font);
		FirstName_txf.setFont(font);
		LastName_txf.setFont(font);
		Speciality_txf.setFont(font);
		PhoneNumber_txf.setFont(font);
		Email_lb.setFont(font);
		Email_txf.setFont(font);
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
		frame.add(DoctorID_lb);
		frame.add(FirstName_lb);
		frame.add(LastName_lb);
		frame.add(Speciality_lb);
		frame.add(PhoneNumber_lb);
		frame.add(Email_lb);
		frame.add(DoctorID_txf);
		frame.add(FirstName_txf);
		frame.add(LastName_txf);
		frame.add(Speciality_txf);
		frame.add(PhoneNumber_txf);
		frame.add(Email_txf);

		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
		
		ActionEvent();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		doctor d=new doctor ();
		if (e.getSource()==insert_btn) {

		d.setDoctorID(DoctorID_txf.getText());
		d.setFirstName(FirstName_txf.getText());
		d.setLastName(LastName_txf.getText());

		d.setSpeciality(Speciality_txf.getText());
		d.setPhoneNumber(PhoneNumber_txf.getText());
		d.setEmail(Email_txf.getText());
		
		d.insertData();

		}else if ((e.getSource()==Read_btn)) {
			DefaultTableModel tableModel=d.populateTable();
			table.setModel(tableModel);
		}else if (e.getSource()==update_tbtn) {
			int DoctorID=Integer.parseInt(DoctorID_txf.getText());
			d.setFirstName(FirstName_txf.getText());
			d.setLastName(LastName_txf.getText());
			
			d.setSpeciality(Speciality_txf.getText());
			
			d.setPhoneNumber(PhoneNumber_txf.getText());
			d.setEmail(Email_txf.getText());
			d.update(DoctorID);
		}else {
			int DoctorID=Integer.parseInt(DoctorID_txf.getText());
			d.delete(DoctorID);
	}
				
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
		doctor_form ptf=new doctor_form();

	}
}
