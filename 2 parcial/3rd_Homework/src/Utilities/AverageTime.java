package Utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class AverageTime {
	
	public static void main(String[] args) {
		long startTime,
				endTime=0;
		int timeSumAdd=0,
				timeSumRemove=0;
		ArrayLinearList<Integer> array = new ArrayLinearList();
		ChainLinearList<Integer> chain = new ChainLinearList();
		int[] testing=new int[10];
		for(int i=0;i<testing.length;i++){
			testing[i]=new Random().nextInt(123456789)+1;
		}
		
		try {
			BufferedWriter write=new BufferedWriter(new FileWriter("AverageTimeChainArray.txt"));
			//________________________________________________________
			for(int times=0;times<20;times++){	
				startTime=System.nanoTime();
				for(int i=0;i<testing.length;i++){
					array.add(0,testing[i]);
				}
				endTime=System.nanoTime()-startTime;
				timeSumAdd+=endTime;
				
				startTime=System.nanoTime();
				for(int i=0;i<array.size;i++){
					array.remove(0);
				}
				endTime=System.nanoTime()-startTime;
				timeSumRemove+=endTime;
			}
			System.out.println("average nanoTime in array add: "+timeSumAdd/20);
			write.write("average nanoTime in array add: "+timeSumAdd/20);	write.newLine();
			
			System.out.println("average nanoTime in array remove: "+timeSumRemove/20);
			write.write("average nanoTime in array remove: "+timeSumRemove/20); write.newLine();
			
			timeSumAdd=0;timeSumRemove=0;
			//////////////////////////////////////////////////////////
			for(int times=0;times<20;times++){
				startTime=System.nanoTime();
				for(int i=0;i<testing.length;i++){
					chain.add(0,testing[i]);
				}
				endTime=System.nanoTime()-startTime;
				timeSumAdd+=endTime;
				
				startTime=System.nanoTime();
				for(int i=0;i<chain.size;i++){
					chain.remove(0);
				}
				endTime=System.nanoTime()-startTime;
				timeSumRemove+=endTime;
			}
			System.out.println("average nanoTime in chain add: "+timeSumAdd/20);
			write.write("average nanoTime in chain add: "+timeSumAdd/20); write.newLine();
			
			System.out.println("average nanoTime in chain remove: "+timeSumRemove/20);
			write.write("average nanoTime in chain remove: "+timeSumRemove/20); write.newLine();
			//________________________________________________________
			write.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}
}
