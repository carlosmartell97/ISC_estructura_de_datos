package exercise_4;

public class PatientDataBase extends MyHashTable<String,PatientRecord>{
	
	public PatientDataBase(){
		super();
	}
	
	public void add(String key, PatientRecord record, String date){
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
}
