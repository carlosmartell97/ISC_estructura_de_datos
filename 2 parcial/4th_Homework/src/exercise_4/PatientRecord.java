package exercise_4;

public class PatientRecord {
	public String name;
	public String date;
	public String reasonForVisit;
	public String treatment;
	
	public PatientRecord(String name,String date, String reason, String treatment){
		this.name = name;
		this.date = date;
		this.reasonForVisit = reason;
		this.treatment = treatment;
	}
	public String toString(){
		return "-name: "+this.name+" -date: "+this.date+" -reasonForVisit: "+this.reasonForVisit+" -treatment: "+this.treatment;
	}
}