package LinearList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.omg.Messaging.SyncScopeHelper;

public class AverageTimeArray {
	
	public static void main(String[] args) {
		long startTime,
				endTime;
		ArrayLinearList<Integer> array = new ArrayLinearList();
		ChainLinearList<Integer> chain = new ChainLinearList();
		int[] testing={1,20,300,4000,50000,600000};
		
		try {
			BufferedWriter write=new BufferedWriter(new FileWriter("AverageTimeChainArray.txt"));
			
			startTime=System.nanoTime();
			for(int i=0;i<testing.length;i++){
				array.add(0,testing[i]);
			}
			endTime=System.nanoTime()-startTime;
			System.out.println("add in array: "+endTime);
			write.write("add in array: "+endTime);	write.newLine();
			//////////////////////////////////////////////////////////
			startTime=System.nanoTime();
			for(int i=0;i<testing.length;i++){
				chain.add(0,testing[i]);
			}
			endTime=System.nanoTime()-startTime;
			System.out.println("add in chain: "+endTime);
			write.write("add in chain: "+endTime); write.newLine();
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			startTime=System.nanoTime();
			for(int i=0;i<array.size;i++){
				array.remove(0);
			}
			endTime=System.nanoTime()-startTime;
			System.out.println("remove in array: "+endTime);
			write.write("remove in array: "+endTime); write.newLine();
			//////////////////////////////////////////////////////////
			startTime=System.nanoTime();
			for(int i=0;i<chain.size;i++){
				chain.remove(0);
			}
			endTime=System.nanoTime()-startTime;
			System.out.println("remove in chain: "+endTime);
			write.write("remove in chain: "+endTime); write.newLine();
			
			write.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}
}
