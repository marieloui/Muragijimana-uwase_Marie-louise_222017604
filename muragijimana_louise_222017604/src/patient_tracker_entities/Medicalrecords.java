package patient_tracker_entities;

public class Medicalrecords {
	private String   RecordID;
	   private  String PatientID;
		private String  DoctorID;
			private String Diagnosis;
		private String Prescription;
		public Medicalrecords(String recordID, String patientID, String doctorID, String diagnosis,
				String prescription) {
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

}
