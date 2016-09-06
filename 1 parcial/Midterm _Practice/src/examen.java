// resuelto. Estoy usando el stack de la recursión de mi método test(int,String)
public class examen {
	private String s="";
	public boolean isReverse(String word,String word2){
		s="";
		/*word=word.replace(" ", "");
		word=word.replace(",", "");
		word=word.replace(".", "");
		word=word.toLowerCase();
		
		word2=word2.replace(" ", "");
		word2=word2.replace(",", "");
		word2=word2.replace(".", "");
		word2=word2.toLowerCase();*/
		test(0,word);
		System.out.println(word);
		System.out.println(word2);
		return s.equals(word2);
	}
	public void test(int i,String word){
		if(i<word.length()){
			test(i+1,word);
			s+=word.charAt(i);
		}
	}
	
	public static void main(String[] args) {
		examen o = new examen();
		System.out.println(o.isReverse("hola","aloh"));
	}
}