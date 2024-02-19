package patient_tracker_entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class patient {

	private  String PatientID;
	private String FirstName;
	private String LastName;
	private String Gender;
	private String PhoneNumber;
	
	public patient() {}
	public patient( String PatientID, String FirstName, String LastName, String Gender, String PhoneNumber) {
		super();
		this.PatientID =PatientID;
		this.FirstName =FirstName;
		this.LastName = LastName;
		this.Gender = Gender;
		this.PhoneNumber = PhoneNumber;
		
	}
	public String getPatientID() {
		return PatientID;
	}
	public void setPatientID(String patientID) {
		PatientID = patientID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastname() {
		return LastName;
	}
	public void setLastname(String lastName) {
		LastName = lastName;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
	
	public void makeconnection() {
		    }
	
	public void insertData() {
		// TODO Auto-generated method stub
		
		String host = "jdbc:mysql://localhost/patient_tracker";
	    String user = "root";
	    String password = "";
	    String sql = "INSERT INTO patient (FirstName, LastName, Gender,PhoneNumber) VALUES ( ?, ?, ?, ?)";
	    try {
			
	   	 Connection con = DriverManager.getConnection(host, user, password);
    	 PreparedStatement stm= con.prepareStatement(sql);
    	 stm.setString(1, FirstName);
         stm.setString(2, LastName);
         stm.setString(3, Gender);
         stm.setString(4, PhoneNumber);
         
         
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
	public void readwithid(String PatientID) {
		 String url = "jdbc:mysql://localhost/patient_tracker";
		    String user = "root";
		    String password = "";
		    String sql = "SELECT * FROM patient WHERE PatientID = ?";	
		try {
			
			Connection connection = DriverManager.getConnection(url, user, password);
	    	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    	preparedStatement.setString(1, PatientID);
	    	ResultSet resultSet = preparedStatement.executeQuery();
	    	  while (resultSet.next()) {
	    		  this.setPatientID(resultSet.getString("PatientID"));
	    		  this.setFirstName(resultSet.getString("FirstName"));
		             this.setLastname(resultSet.getString("LastName"));
		             
		             this.setGender(resultSet.getString("Gender"));
		             this.setPhoneNumber(resultSet.getString("PhoneNumber"));;
		             
		             
	    	  }
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}
	public void update(int patientID2) {
		String url = "jdbc:mysql://localhost/patient_tracker";
	    String user = "root";
	    String password = "";
	    String sql = "UPDATE patient SET FirstName = ?, LastName = ?,Gender = ?,PhoneNumber = ?  WHERE PatientID = ?";
		try {
			
			Connection con = DriverManager.getConnection(url, user, password);
			 PreparedStatement stm = con.prepareStatement(sql);
			 stm.setString(1, this.getFirstName());
		     stm.setString(2, this.getLastname());
		     stm.setString(3, this.getGender()); 
		     stm.setString(4, this.getPhoneNumber());
		     
		     
		     stm.setInt(5, patientID2);
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
	public void delete(int patientID2) {
		String url = "jdbc:mysql://localhost/patient_tracker";
	    String user = "root";
	    String password = "";
	    String sql = "DELETE FROM patient WHERE PatientID = ?";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, patientID2);
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
	public DefaultTableModel populateTable() {
		String host = "jdbc:mysql://localhost/patient_tracker";
	     String user = "root";
	     String password = "";
	     String query= "SELECT * FROM patient";
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
	

		
	
			
		
	
	
	
	
	
	
		
	}
	

