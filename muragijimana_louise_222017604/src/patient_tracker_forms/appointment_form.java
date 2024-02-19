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

import patient_tracker_entities.appointment;

public class appointment_form implements ActionListener   {

	JFrame frame;//PatientID;AppointmentID;DoctorID;Reason;AppointmentDate;
	JLabel AppointmentID_lb=new JLabel("AppointmentID");
	JLabel PatientID_lb=new JLabel("PatientID");
	JLabel DoctorID_lb=new JLabel("DoctorID");
	JLabel AppointmentDate_lb=new JLabel("AppointmentDate");
    JLabel Reason_lb=new JLabel("Reason");
		
    JTextField AppointmentID_txf=new JTextField();
    JTextField PatientID_txf=new JTextField();
	JTextField DoctorID_txf=new JTextField();
	JTextField AppointmentDate_txf=new JTextField();
	JTextField Reason_txf=new JTextField();


	
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


	public appointment_form() {
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
		AppointmentID_lb.setBounds(10, 10, 300, 30);
		PatientID_lb.setBounds(10, 50, 300, 30);
		DoctorID_lb.setBounds(10, 90, 300, 30);
		AppointmentDate_lb.setBounds(10, 130, 300, 30);
		Reason_lb.setBounds(10, 170, 300, 30);
		
		AppointmentID_txf.setBounds(160, 10, 300, 30);
		PatientID_txf.setBounds(160, 50, 300, 30);
		DoctorID_txf.setBounds(160, 90, 300, 30);
		AppointmentDate_txf.setBounds(160, 130, 300, 30);
		Reason_txf.setBounds(160, 170, 300, 30);
		
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
		AppointmentID_lb.setFont(font);
		DoctorID_lb.setFont(font);
		Reason_lb.setFont(font);
		AppointmentDate_lb.setFont(font);

		PatientID_txf.setFont(font);
		AppointmentID_txf.setFont(font);
		DoctorID_txf.setFont(font);
		Reason_txf.setFont(font);
		AppointmentDate_txf.setFont(font);
		
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
		frame.add(AppointmentID_lb);
		frame.add(PatientID_lb);
		frame.add(DoctorID_lb);
		frame.add(AppointmentDate_lb);
		frame.add(Reason_lb);
		
		frame.add(AppointmentID_txf);
		frame.add(PatientID_txf);
		frame.add(DoctorID_txf);
		frame.add(AppointmentDate_txf);
		frame.add(Reason_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add( table);

		
		ActionEvent();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		appointment af=new appointment();
		
		if (e.getSource()==insert_btn) {
	
		af.setAppointmentID(AppointmentID_txf.getText());
		
		af.setPatientID(PatientID_txf.getText());
		
		af.setDoctorID(DoctorID_txf.getText());
		
		af.setAppointmentDate(AppointmentDate_txf.getText());
		
		af.setReason(Reason_txf.getText());

		
		af.insertData();

		
	}else if ((e.getSource()==Read_btn)) {
		int PatientID=Integer.parseInt(PatientID_txf.getText());
		af.readwithid(PatientID);
		
		
		PatientID_txf.setText(String.valueOf(af.getPatientID()));
		AppointmentID_txf.setText(af.getAppointmentID());
		DoctorID_txf.setText(af.getDoctorID());
		AppointmentDate_txf.setText(af.getAppointmentDate());
		
		Reason_txf.setText(af.getReason());
	
	}
	
	else if (e.getSource()==update_tbtn) {
		int PatientID=Integer.parseInt(PatientID_txf.getText());
		af.setAppointmentID(AppointmentID_txf.getText());
		af.setDoctorID(DoctorID_txf.getText());
		
		af.setAppointmentDate(AppointmentDate_txf.getText());
		af.setReason(Reason_txf.getText());
		
		af.update(PatientID);
		
	}else {
		int PatientID=Integer.parseInt(PatientID_txf.getText());
		af.delete(PatientID);
}

	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		@SuppressWarnings("unused")
		appointment_form ptf=new appointment_form();
		
	
}
}
	
