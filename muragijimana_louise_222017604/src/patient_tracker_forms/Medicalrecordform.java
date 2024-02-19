package patient_tracker_forms;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

public class Medicalrecordform implements ActionListener {
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


	 public Medicalrecordform() {
		 createForm();
	}

	private void createForm() {
	

		
	}

	public static void main(String[] args) {
		medical_record_form mf=new medical_record_form();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
