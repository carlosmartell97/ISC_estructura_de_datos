// resuelto. Estoy usando el stack de la recursión de mi método test(int,String)
public class practice4_4 {
	private String s="";
	
	public boolean test(String word){
		this.s="";
		word=word.replace(" ", "");
		word=word.replace(",", "");
		word=word.replace(".", "");
		word=word.toLowerCase();
		test(0,word);
		return s.equals(word.substring(word.length()/2+1));
	}
	public void test(int i,String word){
		if(i<word.length()/2){
			test(i+1,word);
			s+=word.charAt(i);
		}
	}
	
	public static void main(String[] args) {
		practice4_4 o = new practice4_4();
		System.out.println(o.test("amo la pacifica paloma"));
	}
}
