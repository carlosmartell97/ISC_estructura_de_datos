//	ya debería de funcionar todo.
package MyQueue;

public class MyRadixSort {
	
	public static ChainLinearList<Integer> RadixSort(ChainLinearList<Integer> nums,int k){
		int radix=10;
		int power=1;
		int digit,
			index;
		MyScratchQueue<Integer>[] digitQueue=new MyScratchQueue[10];
		MyScratchQueue<Integer>[] indexQueue=new MyScratchQueue[10];
		ChainLinearList<Integer> chain=new ChainLinearList();
		
		for(int i=0;i<nums.size;i++){
			chain.add(i,i);
		}
		for(int i=0;i<10;i++){
			digitQueue[i]=new MyScratchQueue<Integer>();
			indexQueue[i]=new MyScratchQueue<Integer>();
		}
		for(int i=0;i<k;i++){
			for(int j=0;j<nums.size();j++){
				digit=nums.remove(0);
				index=chain.remove(0);
				digitQueue[(digit/power)%10].enqueue(digit);
				indexQueue[(digit/power)%10].enqueue(index);
			}
			for(int j=0;j<radix;j++){
				while(!digitQueue[j].isEmpty()){
					nums.add(nums.size(), digitQueue[j].dequeue());
					chain.add(chain.size, indexQueue[j].dequeue());
				}
			}
			power*=10;
		}
		return nums;
	}
}
