package patient_tracker_entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class appointment {
	private String   AppointmentID;
	private  String PatientID;
	private String  DoctorID;
	private String AppointmentDate;
    private String Reason;
		
	public appointment() {}
	
	

	
	public appointment(String appointmentID, String patientID, String doctorID, String appointmentDate, String reason) {
		super();
		AppointmentID = appointmentID;
		PatientID = patientID;
		DoctorID = doctorID;
		AppointmentDate = appointmentDate;
		Reason = reason;
	}




	public String getAppointmentID() {
		return AppointmentID;
	}




	public void setAppointmentID(String appointmentID) {
		AppointmentID = appointmentID;
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




	public String getAppointmentDate() {
		return AppointmentDate;
	}




	public void setAppointmentDate(String appointmentDate) {
		AppointmentDate = appointmentDate;
	}




	public String getReason() {
		return Reason;
	}




	public void setReason(String reason) {
		Reason = reason;
	}

	public void makeconnection() {
		    }




	public void insertData() {
		String host = "jdbc:mysql://localhost/patient_tracker";
	    String user = "root";
	    String password = "";
	    String sql = "INSERT INTO appointment (PatientID, DoctorID, AppointmentDate,Reason) VALUES ( ?, ?, ?, ?)";
	    try {
			
	   	 Connection con = DriverManager.getConnection(host, user, password);
    	 PreparedStatement stm= con.prepareStatement(sql);
    	 stm.setString(1, PatientID);
         stm.setString(2, DoctorID);
         stm.setString(3, AppointmentDate);
         stm.setString(4, Reason);
         
         
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
		
	}




	public void readwithid(int AppointmentID) {
		 String url = "jdbc:mysql://localhost/patient_tracker";
		    String user = "root";
		    String password = "";
		    String sql = "SELECT * FROM patient WHERE AppointmentID = ?";
	
	try {
		 
		Connection connection = DriverManager.getConnection(url, user, password);
    	PreparedStatement preparedStatement = connection.prepareStatement(sql);
    	preparedStatement.setInt(1, AppointmentID);
    	ResultSet resultSet = preparedStatement.executeQuery();
    	  while (resultSet.next()) {
    		     this.setPatientID(resultSet.getString("PatientID"));
    		     this.setDoctorID(resultSet.getString("DoctorID"));
	             this.setAppointmentDate(resultSet.getString("AppointmentDate"));
	             
	             this.setReason(resultSet.getString("Reason"));
	             
		
    	  }	
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	}
	
	
	public void update(int AppointmentID2) {
		String url = "jdbc:mysql://localhost/patiient_tracker";
	    String user = "root";
	    String password = "";
	    String sql = "UPDATE appointment SET AppointmentID = ?, Reason = ?,  WHERE AppointmentID = ?";
	
	try {
		
		
		Connection con = DriverManager.getConnection(url, user, password);
		 PreparedStatement stm = con.prepareStatement(sql);
		 
	     stm.setString(2, this.getAppointmentID());
	     stm.setString(3, this.getReason()); 
	     stm.setString(4, this.getAppointmentDate());
	     
	     
	     stm.setInt(7, AppointmentID2);
	     int rowsAffected = stm.executeUpdate();
	     if (rowsAffected > 0) {
	          System.out.println("Data updated successfully!");
	     } else {
	         System.out.println("Failed to update data. No matching record found.");
	     }
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
	
	public void delete(int AppointmentID2) {
		String url = "jdbc:mysql://localhost/patiient_tracker";
	    String user = "root";
	    String password = "";
	    String sql = "DELETE FROM appointment WHERE AppointmentID = ?";
	
	try {
		
		Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, AppointmentID2);
        int rowsAffected = stm.executeUpdate();

         if (rowsAffected > 0) {
             System.out.println("Data deleted successfully!");
         } else {
             System.out.println("Failed to delete data. No matching record found.");
         }
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	}
}
	
