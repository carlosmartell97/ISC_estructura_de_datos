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
			throw new IllegalArgumentException("there should be at least 2 players");
		}
		players=a;
		tree=new int[n];
		//	initialize instance variables. We'll use these
		//	to determine the lowest level
		int i,s;
		for(s=1;s*2<=n-1;s+=s);
		lowExt=2*(n-s);
		offset=(2*s)-1;
		//	we use play() so we can form the tree from the external
		//	nodes upwards.
		for(i=2;i<=lowExt;i+=2){
			play((i+offset)/2,i-1,i);
		}
		//	Fabiola dice: qué caso atiendo aquí?
		if(n%2==1){	//	Fabiola dice: qué hace aquí?
			play(n/2,tree[n-1],offset++);
			i=lowExt+3;	//	Fabiola dice: para qué hago esto?
		}
		else{	//	Fabiola dice: ¿Para qué, y en qué caso hago esto?
			i=lowExt+2;
		}
		//	Fabiola dice: ¿Qué hace aquí?
		for(;i<=n;i+=2){
			play((i-lowExt+n-1)/2,i-1,i);
		}
	}
	
	public void replay(int thePlayer){
		//	falta documentar qué pasa en cada paso
		int n=players.length-1;
		if(thePlayer<=0 || thePlayer>n){
			throw new IndexOutOfBoundsException(thePlayer+": invalid player");
		}
		int matchNode, leftChild, rightChild;
		if(thePlayer<=lowExt){
			matchNode=(offset+thePlayer)/2;
			leftChild=2*(matchNode-offset);
			rightChild=leftChild+1;
		}
		else{
			matchNode=(thePlayer-lowExt+n-1)/2;
			if(2*matchNode==n-1){
				leftChild=tree[2*matchNode];
				rightChild=thePlayer;
			}
			else{
				leftChild=2*matchNode-n+1+lowExt;
				rightChild=leftChild+1;
			}
		}
		tree[matchNode]=(players[leftChild]<players[rightChild])?leftChild:rightChild;
		if(matchNode==n-1 && n%2==1){
			matchNode/=2;
			tree[matchNode]=(players[tree[n-1]]<players[lowExt+1])?tree[n-1]:lowExt+1;
		}
		matchNode/=2;
		for(; matchNode>=1; matchNode/=2){	
			tree[matchNode]=players[tree[2*matchNode]]<players[tree[(2*matchNode)+1]]?
					tree[2*matchNode]:tree[2*matchNode+1];
		}
	}
	
	public void change(int thePlayer,int value){
		//	...
	}
	
	public void display(){
		System.out.println("offset:"+this.offset+" lowExt:"+this.lowExt);
		for(int i=0;i<this.tree.length;i++){
			System.out.print("["+this.tree[i]+"]");
		}
	}
}

