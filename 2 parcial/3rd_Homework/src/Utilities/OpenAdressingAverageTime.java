package Utilities;

public class OpenAdressingAverageTime {
	public static void main(String[] args) {
		HashTableOpenAdressing<Integer,Integer> table=new HashTableOpenAdressing<Integer,Integer>();
		long startTime;
		int totalTime=0;
		
		for(int i=0;i<1000;i++){
			startTime=System.nanoTime();
			table.add(i, 0);
			totalTime+=(int)System.nanoTime()-startTime;
		}
		System.out.println("avrg time add() in Open Adressing: "+totalTime/1000);
		
		for(int i=0;i<1000;i++){
			startTime=System.nanoTime();
			table.remove(i);
			totalTime+=(int)System.nanoTime()-startTime;
		}
		System.out.println("avrg time remove() in Open Adressing: "+totalTime/1000);
	}
}
