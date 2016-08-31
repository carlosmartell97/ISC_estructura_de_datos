public class Recursion {
	
	public void enAscendente(int n){
		if(n>=0){
			enAscendente(n-1);
			System.out.println(n);
		}
	}
	
	public void enDescendente(int n){
		if(n>=0){
			System.out.println(n);
			enDescendente(n-1);
		}
	}
	
	private double SumaHarmonica(double n){
		if(n<=0){
			return 0;
		}
		else{
			return Double.sum(1/n, SumaHarmonica(n-1));
		}
	}
	
	public int cuentaCuantas(String string, char a){
		int length = string.length();
		if(length==0){
			return 0;
		}
		String left = string.substring(1);
		if(string.charAt(0)==a){
			return 1+cuentaCuantas(left,a);
		}
		else{
			return cuentaCuantas(left,a);
		}
	}
	
	public int cuantosDigitos(int num){
		int length=String.valueOf(num).length();
		if(length==1){
			return 1;
		}
		else{
			return 1+cuantosDigitos(Integer.parseInt(String.valueOf(num).substring(1)));
		}
	}
	
	public int divisionporRestas(int num, int den){
		int resta=num-den;
		if(resta<0){
			return num;
		}
		else{
			return divisionporRestas(resta,den);
		}
	}
	
	public int sumaDigitos(int num){
		/*while (num> 0){
            int digit = num%10;
            num = num/10;
            System.out.println(digit);
        }*/
		return 0;
	}
	
	public static void main(String[] args){
		Recursion o = new Recursion();
		//o.enAscendente(5); 
		o.enDescendente(5);
		//System.out.println(o.cuentaCuantas("a la",'a'));
		//System.out.println(o.SumaHarmonica(5)); System.out.println(o.SumaHarmonica(3));
		//System.out.println(o.cuantosDigitos(123456789));
		//System.out.println(o.divisionporRestas(5,4));
		System.out.println(o.sumaDigitos(123));
	}
}
