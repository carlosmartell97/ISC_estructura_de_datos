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
		System.out.println("lista: "+lista);
		
		ChainLinearList<Character> chain=new ChainLinearList<Character>();
		chain.add(0, '1');
		chain.add(0, '2');
		chain.add(0, '3');
		chain.add(0, '-');
		chain.add(0, '+');
		System.out.println("chain: "+chain);
		
		try {
			BufferedWriter write=new BufferedWriter(new FileWriter("Readme1.txt"));
			
			System.out.println("for the class Conversion...");
			int average;
			for(int i=0;i<20;i++){
				startTime=System.nanoTime();
				Conversion.Recursive(lista);
				totalTime=(int) (System.nanoTime()-startTime);
				average=+totalTime;
			}
			System.out.println("avrg nanoTime Recursive: "+totalTime/20);
			write.write("avrg nanoTime Recursive: "+totalTime/20);
			write.newLine();
			
			average=0;
			for(int i=0;i<20;i++){
				startTime=System.nanoTime();
				Conversion.Iterative(lista);
				totalTime=(int) (System.nanoTime()-startTime);
				average=+totalTime;
			}
			System.out.println("avrg nanoTime Iterative: "+totalTime/20);
			write.write("avrg nanoTime Iterative: "+totalTime/20);
			
			////////////////////////////////////////////////////////////////////////////////////
			System.out.println("for the class Evaluation...");
			average=0;
			for(int i=0;i<20;i++){
				startTime=System.nanoTime();
				Evaluation.Recursive(chain);
				totalTime=(int) (System.nanoTime()-startTime);
				average=+totalTime;
			}
			System.out.println("avrg nanoTime Recursive: "+totalTime/20);
			write.write("avrg nanoTime Recursive: "+totalTime/20);
			write.newLine();
			
			average=0;
			for(int i=0;i<20;i++){
				startTime=System.nanoTime();
				Evaluation.Iterative(chain);
				totalTime=(int) (System.nanoTime()-startTime);
				average=+totalTime;
			}
			System.out.println("avrg nanoTime Iterative: "+totalTime/20);
			write.write("avrg nanoTime Iterative: "+totalTime/20);
			
			write.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}
}
