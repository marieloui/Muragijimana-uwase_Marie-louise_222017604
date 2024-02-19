package patient_tracker_entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import javax.swing.JOptionPane;

public class medical_record {

	private String   RecordID;
   private  String PatientID;
	private String  DoctorID;
		private String Diagnosis;
	private String Prescription;
	
	
	
	public medical_record() {}



	public medical_record(String recordID, String patientID, String doctorID, String diagnosis, String prescription) {
		super();
		RecordID = recordID;
		PatientID = patientID;
		DoctorID = doctorID;
		Diagnosis = diagnosis;
		Prescription = prescription;
	}



	public String getRecordID() {
		return RecordID;
	}



	public void setRecordID(String recordID) {
		RecordID = recordID;
	}



	public String getPatientID() {
		return PatientID;
	}



	public void setPatientID(String patientID) {
		PatientID = patientID;
	}



	public String getDoctorID() {
		return DoctorID;
	}



	public void setDoctorID(String doctorID) {
		DoctorID = doctorID;
	}



	public String getDiagnosis() {
		return Diagnosis;
	}



	public void setDiagnosis(String diagnosis) {
		Diagnosis = diagnosis;
	}



	public String getPrescription() {
		return Prescription;
	}



	public void setPrescription(String prescription) {
		Prescription = prescription;
	}
	
	

	
	/*public void makeconnection() {
		 String host = "jdbc:mysql://localhost/patient_tracker";
		    String user = "root";
		    String password = "";
		    }
	
	 public void insertData() {
		// TODO Auto-generated method stub
		
		
		 String host = "jdbc:mysql://localhost/patient_tracker";
		    String user = "root";
		    String password = "";
		    String sql = "INSERT INTO patient (PatientID,DoctorID,Diagnosis,Prescription,RecordDate) VALUES ( ?, ?, ?, ,?,?)";
		
		try {
			
			 Connection con = DriverManager.getConnection(host, user, password);
	    	 PreparedStatement stm= con.prepareStatement(sql);
	    	 stm.setString(1, PatientID);
	         stm.setString(2, DoctorID);
	         stm.setString(3, Diagnosis);
	         stm.setString(4, Prescription);
	         
	         
	         int rowsAffected = stm.executeUpdate();
	         if (rowsAffected > 0) {
	         	System.out.println("Data inserted successfully!");
	             JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	         } else {
	             System.out.println("Failed to insert data.");
	             JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);
	             }
		    		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/
	
}
	
	