package patient_tracker_forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Patient_tracker_menu implements ActionListener {
	

	JFrame frame;
	JMenu home,  Patient, Doctor, Billing,Appointment ,Medical__records, more;
	JMenuItem i1, i2, i3, i4, i5, i6, item1, item2,PatientRead;
	JMenuItem DoctorRead;
	JMenuItem BillingRead;
	JMenuItem AppointmentRead;
	JMenuItem medicalrecordsRead;
	public Patient_tracker_menu() {
		createWindow();
	}

	private void createWindow() {
		
		frame = new JFrame("Menu form with main Menu");
		frame.setSize(400, 400);

		JMenuBar mb = new JMenuBar(); // Create a new menu bar
		home = new JMenu("Home");
		Patient = new JMenu("Patient");
		Doctor= new JMenu("Doctor");
		Billing = new JMenu("Billing");
		Appointment=new JMenu("Appointment");
		Medical__records=new JMenu("Medical records");
		

		more = new JMenu("More");
		i1 = new JMenuItem("Insert");
		i2 = new JMenuItem("Read");
		i3 = new JMenuItem("Update");
		i4 = new JMenuItem("Delete");
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		more.add(i5);
		more.add(i6);

		home.add(i1);
		home.add(more); // Add the 'more' submenu to the 'home' menu
		
		PatientRead = new JMenuItem("Read");
		Patient.add(PatientRead);
		

		DoctorRead =new JMenuItem("Read");
		
		
		Doctor.add(DoctorRead);
		
		
		BillingRead =new JMenuItem("Read");
		Billing.add(BillingRead);
		
		
		AppointmentRead=new JMenuItem("Read");
	
		Appointment.add(AppointmentRead);
		
		
		medicalrecordsRead =new JMenuItem("Read");
		
		Medical__records.add(medicalrecordsRead);;
		
		
		
		
		

		

		mb.add(home);
		mb.add(Patient);
		mb.add(Doctor);
		mb.add(Billing);
		mb.add(Appointment);
		mb.add(Medical__records);
		
		frame.setJMenuBar(mb);// Set the menu bar to the frame

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		componentsOnFrame();

	}

	private void componentsOnFrame() {
		home = new JMenu("Home");
		Patient = new JMenu("Patient");
		Doctor = new JMenu("Doctor");
		Billing =new JMenu("Billing");
		Appointment=new JMenu("Appointment");
		Medical__records =new JMenu("Medical record");
		
		
		more = new JMenu("More");
		i1 = new JMenuItem("Create");
		i2 = new JMenuItem("Read");
		i3 = new JMenuItem("Update");
		i4 = new JMenuItem("Delete");
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		more.add(i5);
		more.add(i6);

		home.add(i1);
		home.add(more);
		Patient.add(i2);
		Doctor.add(i2);
		Billing.add(i2);
		Appointment.add(i2);
		Medical__records.add(i2);
		addactionEvent();

		
	}

	private void addactionEvent() {
		PatientRead.addActionListener(this);
		DoctorRead.addActionListener(this);
		BillingRead.addActionListener(this);
		AppointmentRead.addActionListener(this);
		medicalrecordsRead.addActionListener(this);
		
	}

	public static void main(String[] args) {
		new Patient_tracker_menu();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==PatientRead) {
			new patient_form();
			frame.dispose();
		}else if (e.getSource()==DoctorRead) {
			new doctor_form();
			frame.dispose();
		}else if (e.getSource()==BillingRead) {
			new billing_form();
			frame.dispose();
	
			}else if (e.getSource()==AppointmentRead) {
				new appointment_form();
				frame.dispose();
				}else if (e.getSource()==medicalrecordsRead) {
					new medical_record_form();
					frame.dispose();
	}
		
	}

}
