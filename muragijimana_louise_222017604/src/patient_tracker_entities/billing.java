package patient_tracker_entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class billing {
	private String   BillID;
	private  String PatientID;
	private String  DoctorID;
	private String BillDate;
	private String Amount;
	
	
	public billing() {}


	public billing(String billID, String patientID, String doctorID, String billDate, String amount) {
		super();
		BillID = billID;
		PatientID = patientID;
		DoctorID = doctorID;
		BillDate = billDate;
		Amount = amount;
	}


	public String getBillID() {
		return BillID;
	}


	public void setBillID(String billID) {
		BillID = billID;
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


	public String getBillDate() {
		return BillDate;
	}


	public void setBillDate(String billDate) {
		BillDate = billDate;
	}


	public String getAmount() {
		return Amount;
	}


	public void setAmount(String amount) {
		Amount = amount;
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
	    String sql = "INSERT INTO billing (PatientID, DoctorID, BillDate,Amount) VALUES ( ?, ?, ?, ?)";
	    try {
			
	   	 Connection con = DriverManager.getConnection(host, user, password);
    	 PreparedStatement stm= con.prepareStatement(sql);
    	 stm.setString(1, PatientID);
         stm.setString(2, DoctorID);
         stm.setString(3, BillDate);
         stm.setString(4, Amount);
         
         
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


	public DefaultTableModel populateTable() {
		String host = "jdbc:mysql://localhost/patient_tracker";
	     String user = "root";
	     String password = "";
	     String query= "SELECT * FROM billing";
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


	public void update(int billID2) {
		String url = "jdbc:mysql://localhost/patient_tracker";
	    String user = "root";
	    String password = "";
	    String sql = "UPDATE billing SET PatientID = ?, DoctorID = ?,BillDate = ?,Amount = ?  WHERE BillID = ?";
		try {
			
			Connection con = DriverManager.getConnection(url, user, password);
			 PreparedStatement stm = con.prepareStatement(sql);
			 stm.setString(1, this.getPatientID());
		     stm.setString(2, this.getDoctorID());
		     stm.setString(3, this.getBillDate()); 
		     stm.setString(4, this.getAmount());
		     
		     
		     stm.setInt(5, billID2);
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


	public void delete(int billID2) {
		String url = "jdbc:mysql://localhost/patient_tracker";
	    String user = "root";
	    String password = "";
	    String sql = "DELETE FROM billing WHERE BillID = ?";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, billID2);
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

	

		
		
/*	public void makeconnection() {
		 String host = "jdbc:mysql://localhost/patient_tracker";
		    String user = "root";
		    String password = "";
		    }
	
	public void insertData() {
		// TODO Auto-generated method stub
	
	String host = "jdbc:mysql://localhost/patient_tracker";
   String user = "root";
   String password = "";
   String sql = "INSERT INTO billing (PatientID, DoctorID, BillID,Amount,BillDate) VALUES (?, ?, ?, ?, ?)";
	   try
      
        }*/
        
	}
		 
		
	 
   
   
