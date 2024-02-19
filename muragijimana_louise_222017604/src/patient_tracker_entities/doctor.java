package patient_tracker_entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class doctor {

	private  String DoctorID;
	private String FirstName;
	private String LastName;
	private String Speciality;
	private String PhoneNumber;
	private String Email;
	public doctor() {}
	public doctor( String DoctorID, String FirstName, String LastName, String Speciality, String PhoneNumber,String Email) {
		super();
		this.DoctorID =DoctorID;
		this.FirstName =FirstName;
		this.LastName = LastName;
		this.Speciality = Speciality;
		this.PhoneNumber = PhoneNumber;
		this.Email=Email;
	}
	public String getDoctorID() {
		return DoctorID;
	}
	public void setDoctorID(String doctorID) {
		DoctorID = doctorID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getSpeciality() {
		return Speciality;
	}
	public void setSpeciality(String speciality) {
		Speciality = speciality;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	 
	public void makeconnection() {
		 String host = "jdbc:mysql://localhost/patient_tracker";
		    String user = "root";
		    String password = "";
		    }
	public void insertData() {
		String host = "jdbc:mysql://localhost/patient_tracker";
	    String user = "root";
	    String password = "";
	    String sql = "INSERT INTO doctor (DoctorID, FirstName,LastName,Specialty,PhoneNumber,Email) VALUES (?, ?, ?, ?, ?,?)";
	    String sqlQuery="SELECT*From doctor";
	    try {
	    	Connection con = DriverManager.getConnection(host, user, password);
	    	 PreparedStatement stm= con.prepareStatement(sql);
	    	 PreparedStatement qSstm=con.prepareStatement(sqlQuery);
	    	stm.setString(1, DoctorID);
	    	stm.setString(2,FirstName);
	    	stm.setString(3, LastName);
	    	stm.setString(4,Speciality );
	    	stm.setString(5, PhoneNumber);
	    	stm.setString(6, Email);
	    	int rowsAffected = stm.executeUpdate();
	         if (rowsAffected > 0) {
	        	 System.out.println("data inserted succeccful");
	        	 JOptionPane.showMessageDialog(null, "data inserted successful","After insert",JOptionPane.INFORMATION_MESSAGE);
	         }
	        	 else {
	        		 System.out.println("Failed to insert data!!!");
	                 JOptionPane.showMessageDialog(null, "Failed to insert data!!!","After insert",JOptionPane.ERROR_MESSAGE);
	                 }
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public DefaultTableModel populateTable() {
		String host = "jdbc:mysql://localhost/patient_tracker";
	     String user = "root";
	     String password = "";
	     String query= "SELECT * FROM doctor";
	     DefaultTableModel tableModel = null;

	     try {
	         Connection con = DriverManager.getConnection(host, user, password);
	         PreparedStatement stm = con.prepareStatement(query);
	         ResultSet resultSet = stm.executeQuery();

	         int columnCount = resultSet.getMetaData().getColumnCount();
	         Vector<String> columnNames = new Vector<>();
	         for (int i = 1; i <= columnCount; i++) {
	             columnNames.add(resultSet.getMetaData().getColumnName(i));
	         }

	         Vector<Vector<Object>> data = new Vector<>();
	         while (resultSet.next()) {
	             Vector<Object> row = new Vector<>();
	             for (int i = 1; i <= columnCount; i++) {
	                 row.add(resultSet.getObject(i));
	             }
	             data.add(row);
	         }

	         tableModel = new DefaultTableModel(data, columnNames);
	         con.close(); // Close the connection when done to release resources
	     } catch (Exception e) {
	         e.printStackTrace(); // Print the exception details for debugging purposes
	     }
	     return tableModel;

	}
	public void update(int doctorID2) {
		String url = "jdbc:mysql://localhost/patient_tracker";
	    String user = "root";
	    String password = "";
	    String sql = "UPDATE doctor SET FirstName = ?, LastName = ?,Specialty = ?,PhoneNumber = ?,	Email=?  WHERE DoctorID  = ?";
		try {
			
			Connection con = DriverManager.getConnection(url, user, password);
			 PreparedStatement stm = con.prepareStatement(sql);
			 stm.setString(1, this.getFirstName());
		     stm.setString(2, this.getLastName());
		     stm.setString(3, this.getSpeciality()); 
		     stm.setString(4, this.getPhoneNumber());
		     stm.setString(5, this.getEmail());
		     
		     
		     stm.setInt(6, doctorID2);
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
	public void delete(int doctorID2) {
		String url = "jdbc:mysql://localhost/patient_tracker";
	    String user = "root";
	    String password = "";
	    String sql = "DELETE FROM doctor WHERE DoctorID = ?";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, doctorID2);
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
