package Lab4;

/**
 * implementation of MIN winner tree
 * @author dell
 *
 */
public class WinnerTree {
	private int players[];
	private int tree[];
	private int lowExt;
	private int offset;
	
	public int getWinner(){
		if(this.tree==null){
			return 0;
		}
		return tree[0];
	}
	
	private void play(int parent, int left, int right){
		tree[parent] = (players[left]<players[right])?left:right;
		while(parent%2==1){
			tree[parent/2] = (players[tree[parent-1]]<players[tree[parent]])?parent-1:parent;
		}
	}
	
	public void initiate(int[] a){
		int n=a.length-1;
		if(n<2){
			throw new IllegalArgumentException();
		}
		players=a;
		tree=new int[n];
		int i,s;
		for(s=1;s*2<=n-1;s+=s);
		lowExt=2*(n-s);
		offset=(2*s)-1;
		for(i=2;i<=lowExt;i+=2){
			play((i+offset)/2,i-1,i);
		}
		if(n%2==1){
			play(n/2,tree[n-1],offset++);
			i=lowExt+3;
		}
		else{
			i=lowExt+2;
		}
		for(;i<=n;i+=2){
			play((i-lowExt+n-1)/2,i-1,i);
		}
	}
	
	public void display(){
		System.out.println("offset:"+this.offset+" lowExt:"+this.lowExt);
		for(int i=0;i<this.tree.length;i++){
			System.out.print("["+this.tree[i]+"]");
		}
	}
}

