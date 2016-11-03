//	ya debería de funcionar todo.
package MyQueue;

public class MyRadixSort {
	
	public static ChainLinearList<Integer> RadixSort(ChainLinearList<Integer> nums,int k){
		int radix=10;
		int power=1;
		int digit;
		MyScratchQueue<Integer>[] digitQueue=new MyScratchQueue[10];
		for(int i=0;i<10;i++){
			digitQueue[i]=new MyScratchQueue<Integer>();
		}
		
		for(int i=0;i<k;i++){
			for(int j=0;j<nums.size();j++){
				digit=nums.remove(0);
				digitQueue[(digit/power)%10].enqueue(digit);
			}
			for(int j=0;j<radix;j++){
				while(!digitQueue[j].isEmpty()){
					nums.add(nums.size(), digitQueue[j].dequeue());
				}
			}
			power*=10;
		}
		return nums;
	}
}
