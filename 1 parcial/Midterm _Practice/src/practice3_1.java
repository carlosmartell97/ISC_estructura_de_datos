import java.util.Iterator;

public class practice3_1 {
	
	public void clear(){
		
	}
	
	public void append(Object newObject){
		
	}
	
	public Iterator iterator(){
		return new inner();
	}
	
	public static void split(practice3_1 a,practice3_1 b,practice3_1 c){
		b.clear();
		c.clear();
		//	y aquí va algo muy parecido a lo que hice en practice2_2
	}
	
	private static class inner implements Iterator{
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}
		public Object next() {
			// TODO Auto-generated method stub
			return null;
		}
		/*public practice3_1 remove(){
			
		}*/
	}
}
