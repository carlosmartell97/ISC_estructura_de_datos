package LinearList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.omg.Messaging.SyncScopeHelper;

public class AverageTimeArray {
	
	public static void main(String[] args) {
		long startTime,
				endTime;
		ArrayLinearList<Integer> array = new ArrayLinearList();
		ChainLinearList<Integer> chain = new ChainLinearList();
		int[] testing=new int[10];
		for(int i=0;i<testing.length;i++){
			testing[i]=new Random().nextInt(123456789)+1;
		}
		
		try {
			BufferedWriter write=new BufferedWriter(new FileWriter("AverageTimeChainArray.txt"));
			
			startTime=System.nanoTime();
			for(int i=0;i<testing.length;i++){
				array.add(0,testing[i]);
			}
			endTime=System.nanoTime()-startTime;
			System.out.println("nanoTime in array add: "+endTime);
			write.write("nanoTime in array add: "+endTime);	write.newLine();
			//////////////////////////////////////////////////////////
			startTime=System.nanoTime();
			for(int i=0;i<testing.length;i++){
				chain.add(0,testing[i]);
			}
			endTime=System.nanoTime()-startTime;
			System.out.println("nanoTime in chain add: "+endTime);
			write.write("nanoTime in chain add: "+endTime); write.newLine();
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			startTime=System.nanoTime();
			for(int i=0;i<array.size;i++){
				array.remove(0);
			}
			endTime=System.nanoTime()-startTime;
			System.out.println("nanoTime in array remove: "+endTime);
			write.write("nanoTime in array remove: "+endTime); write.newLine();
			//////////////////////////////////////////////////////////
			startTime=System.nanoTime();
			for(int i=0;i<chain.size;i++){
				chain.remove(0);
			}
			endTime=System.nanoTime()-startTime;
			System.out.println("nanoTime in chain remove: "+endTime);
			write.write("nanoTime in chain remove: "+endTime); write.newLine();
			
			write.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}
}
