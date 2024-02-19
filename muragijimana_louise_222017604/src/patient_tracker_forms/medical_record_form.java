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

import patient_tracker_entities.medical_record;
import patient_tracker_entities.patient;

public class medical_record_form implements ActionListener{
	
	
	JFrame frame;//PatientID;RecordID;DoctorID;Diagnosis;RecordDate,Prescription;
	JLabel RecordID_lb=new JLabel("RecordID");
	JLabel PatientID_lb=new JLabel("PatientID");
	JLabel DoctorID_lb=new JLabel("DoctorID");
	JLabel Diagnosis_lb=new JLabel("Diagnosis");
	JLabel Prescription_lb=new JLabel("Gender");
	
	JTextField RecordID_txf=new JTextField();
    JTextField PatientID_txf=new JTextField();
	JTextField DoctorID_txf=new JTextField();
	JTextField Diagnosis_txf=new JTextField();
	JTextField Prescription_txf=new JTextField();
	
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


	public medical_record_form() {
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
		RecordID_lb.setBounds(10, 10, 300, 30);
		PatientID_lb.setBounds(10, 50, 300, 30);
		DoctorID_lb.setBounds(10, 90, 300, 30);
		Diagnosis_lb.setBounds(10, 130, 300, 30);
		Prescription_lb.setBounds( 10,210,300,30);
		
		
		
		RecordID_txf.setBounds(160, 10, 300, 30);
		PatientID_txf.setBounds(160, 50, 300, 30);
		DoctorID_txf.setBounds(160, 90, 300, 30);
		Diagnosis_txf.setBounds(160, 130, 300, 30);
		
		Prescription_txf.setBounds(160,170,300,30);
		
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
		RecordID_lb.setFont(font);
		DoctorID_lb.setFont(font);
		Diagnosis_lb.setFont(font);
		
		Prescription_lb.setFont(font);
		
		
		PatientID_txf.setFont(font);
		RecordID_txf.setFont(font);
		DoctorID_txf.setFont(font);
		Diagnosis_txf.setFont(font);
		
		Prescription_txf.setFont(font);
		
		
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
		frame.add(RecordID_lb);
		frame.add(DoctorID_lb);
		frame.add(Diagnosis_lb);
		
		frame.add(Prescription_lb);
        
		
		frame.add(PatientID_txf);
		frame.add(RecordID_txf);
		frame.add(DoctorID_txf);
		frame.add(Diagnosis_txf);
		
		frame.add(Prescription_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add( table);
		
		ActionEvent();
	}

	

	   
	
	

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		// TODO Auto-generated method stub	
	
		
	
		/*if (e.getSource()==insert_btn) {
		
		
			
			m.setPatientID(PatientID_txf.getText());
			m.setDoctorID(DoctorID_txf.getText());
			m.setRecordID(RecordID_txf.getText());

			m.setDiagnosis(Diagnosis_txf.getText());
			m.setPrescription(Prescription_txf.getText());
		    
			m.insertData();
			
		

		}	else if ((e.getSource()==Read_btn)) {
			int PatientID=Integer.parseInt(PatientID_txf.getText());
			m.readwithid(PatientID);
			
			
			PatientID_txf.setText(String.valueOf(m.getPatientID()));
			RecordID_txt.setText(m.getRecordID());
			DoctorID_txf.setText(m.getDoctorID());
			Diagnosis_txf.setText(m.getDiagnosis());
			
			Prescription_txf.setText(m.getPrescription());
			
		
		}
		else if (e.getSource()==update_btn) {
			int PatientID=Integer.parseInt(PatientID_txf.getText());
			m.setRecordID(RecordID_txf.getText());
			m.setDoctorID(DoctorID_txf.getText());
			
			m.setDiagnosis(Diagnosis_txf.getText());
			m.setPrescription(Prescription_txf.getText());
			
			m.update(PatientID);
			
		}else {
			int PatientID=Integer.parseInt(PatientID_txf.getText());
			m.delete(PatientID);
	}
		
	}*/
	}
	public void main(String[] args) {
		// TODO Auto-generated method stub
 
		medical_record_form mf=new medical_record_form();
		
		
		 
	}

	

	
}

