package exercise_4;

public class PatientDataBase extends MyHashTable<String,PatientRecord>{
	
	public PatientDataBase(){
		super();
	}
	
	public void addRecord(PatientRecord record){
		this.add(record.name,record,record.date);
	}
	
	private void add(String key, PatientRecord record, String date){
		if(this.size >= this.m-1 || (this.size+0.0)/(this.m) >= DEFAULT_CHARGE)
			this.rehash();
		int pos = this.hash(key);
		for(Node<String,PatientRecord> x=this.table[pos]; x!=null; x=x.next){
			if(x.key.equals(key) && x.value.date.equals(date)){
				x.value = record;
				return;
			}
		}
		Node<String,PatientRecord> newRecord = new Node<String,PatientRecord>(key,record,this.table[pos]);
		this.table[pos] = newRecord;
		this.size++;
	}
	
	public PatientRecord remove(String name,String date){
		int pos=this.hash(name);
		Node<String,PatientRecord> first = this.table[pos];
		if(first.key.equals(name) && first.value.date.equals(date)){
			PatientRecord willReturn = first.value;
			this.table[pos] = first.next;
			this.size--;
			return willReturn;
		}
		for(Node<String,PatientRecord> x=first; x.next!=null; x=x.next){
			if(x.next.key.equals(name) && x.next.value.date.equals(date)){
				PatientRecord willReturn = x.next.value;
				x.next = x.next.next;
				this.size--;
				return willReturn;
			}
		}
		return null;
	}
	
	public String reasonForVisit(String name, String date){
		PatientRecord record = this.getValue(name,date);
		if(this.getValue(name,date)==null){
			return null;
		}
		return record.reasonForVisit;
	}
	
	public String treatment(String name, String date){
		PatientRecord record = this.getValue(name,date);
		if(record==null){
			return null;
		}
		return record.treatment;
	}
	
	private PatientRecord getValue(String key, String date){
		int pos=this.hash(key);
		for(Node<String,PatientRecord> x=this.table[pos]; x!=null; x=x.next){
			if(x.key.equals(key) && x.value.date.equals(date)){
				return x.value;
			}
		}
		return null;
	}
	
	public ArrayLinearList<String> visits(String name){
		int pos = this.hash(name);
		ArrayLinearList<String> visits = new ArrayLinearList<String>();
		for(Node<String,PatientRecord> x=this.table[pos]; x!=null; x=x.next){
			if(x.key.equals(name)){
				visits.add(visits.size(),x.value.date);
			}
		}
		return visits;
	}
}
