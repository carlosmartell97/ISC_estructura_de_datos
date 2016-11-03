package MyQueue;

public class MyRadixSort {
	
	public static void RadixSort(LinearList Element,int k){
		int radix=10;
		int power=1;
		int digit;
		Queue<Integer>[] digitQueue=new Queue[10];
		
		for(int i=0;i<k;i++){
			for(int j=0;j<Element.size();i++){
				digit=Element.remove(0);
				digitQueue[(digit/power)%10].enqueue(digit);
			}
			for(int j=0;j<radix;j++){
				//
			}
			power*=10;
		}
	}
}
