public class RecString {
	public static int StrLen(String string){
		int length=string.length();
		if(length==0){
			return 0;
		}
		else{
			return 1+StrLen(string.substring(1));
		}
	}
	public static void main(String[] a){
		//System.out.println(StrLen("holaa"));
	}
}
