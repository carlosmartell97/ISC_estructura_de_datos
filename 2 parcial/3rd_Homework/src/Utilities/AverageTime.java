package Utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AverageTime {
	
	public static void main(String[] args) {
		long startTime;
		int totalTime=0;
		ArrayLinearList<Character> lista=new ArrayLinearList<Character>();
		lista.add(0, 'D');
		lista.add(0, 'Z');
		lista.add(0, 'Y');
		lista.add(0, 'X');
		lista.add(0, '+');
		lista.add(0, '-');
		lista.add(0, '+');
		System.out.println(lista);
		
		try {
			BufferedWriter write=new BufferedWriter(new FileWriter("Readme1.txt"));
			
			int average;
			for(int i=0;i<20;i++){
				startTime=System.nanoTime();
				Conversion.Recursive(lista);
				totalTime=(int) (System.nanoTime()-startTime);
				average=+totalTime;
			}
			System.out.println("avrg nanoTime Recursive: "+totalTime/20);
			
			average=0;
			for(int i=0;i<20;i++){
				startTime=System.nanoTime();
				Conversion.Iterative(lista);
				totalTime=(int) (System.nanoTime()-startTime);
				average=+totalTime;
			}
			System.out.println("avrg nanoTime Iterative: "+totalTime/20);
			//write.write("average nanoTime in chain remove: "+timeSumRemove/20); write.newLine();
			write.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}
}
