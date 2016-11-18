package Lab4;

/**
 * implementation of MIN winner tree
 * @author dell
 *
 */
public class WinnerTree implements TournamentTree<Integer>{
	private Integer[] players;
	private int[] tree;
	private int lowExt;
	private int offset;
	
	public Integer getWinner(){
		return (this.tree!=null)?
				players[tree[1]] : null;
	}
	
	public int winnerIndex(){
		return (tree != null)?
				tree[1]:null;
	}
	
	public void initialize(Integer[] a){
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
		offset=2*s-1;
		//	we use play() so we can form the tree from the external
		//	nodes upwards.
		for(i=2;i<=lowExt;i+=2)
			play((i+offset)/2,i-1,i);
		if(n%2==1){	//	este caso es cuando voy a tener una match con solo un jugador
			play(n/2,tree[n-1],lowExt+1);
			i=lowExt+3;	//	tengo que avanar 3 lugares
		}
		else	//	lal cantidad de jugadores es par, y sí podré 2 lugares
			i=lowExt+2;
		
		for(;i<=n;i+=2) //	vas jugando de 2 en 2
			play((i-lowExt+n-1)/2,i-1,i);
	}
	
	public void play(int parent, int left, int right){
		tree[parent] = (players[left].compareTo(players[right])<0)?left:right; //	que el padre sea el ganador, el más chico
		while(parent%2==1 && parent>1){ //	seguir jugando
			tree[parent/2] = (players[tree[parent-1]].compareTo(players[tree[parent]])<0)?tree[parent-1]:tree[parent];
			parent/=2;
		}
	}
	
	public void replay(int thePlayer){
		//	falta documentar qué pasa en cada paso
		int n=players.length-1;
		if(thePlayer<=0 || thePlayer>n)
			throw new IndexOutOfBoundsException(thePlayer+": invalid player");
		int matchNode, leftChild, rightChild;
		if(thePlayer<=lowExt){ //	potencia de 2
			matchNode=(offset+thePlayer)/2;	// lugar donde irá ganador de leftChild y rightChild
			leftChild=2*matchNode-offset;
			rightChild=leftChild+1;
		}
		else{ //	no es potencia de 2
			matchNode=(thePlayer-lowExt+n-1)/2;	// lugar donde irá ganador de leftChild y rightChild
			if(2*matchNode==n-1){	// this is the last node of the tree
				leftChild=tree[2*matchNode];
				rightChild=thePlayer;
			}
			else{	// even, not last node of the tree
				leftChild=2*matchNode-n+1+lowExt;
				rightChild=leftChild+1;
			}
		}
		//	all set up for first match
		tree[matchNode]=(players[leftChild].compareTo(players[rightChild])<0)?leftChild:rightChild;	// que gane el más chico
		if(matchNode==n-1 && n%2==1){	// if match will take place in last position of tree
			matchNode/=2;
			tree[matchNode]=(players[tree[n-1]].compareTo(players[lowExt+1])<0)?tree[n-1]:lowExt+1;
		}
		matchNode/=2;	// you continue moving up, from match to match
		for(; matchNode>=1; matchNode/=2){	
			tree[matchNode]=players[tree[2*matchNode]].compareTo(players[tree[(2*matchNode)+1]])<0?
					tree[2*matchNode]:tree[2*matchNode+1];
		}
	}
	
	public void change(int thePlayer,Integer value){
		this.players[thePlayer]=value;	// asignar valor
		//replay(thePlayer);	// acomodar todo
	}
	
	public Integer[] sort(Integer[] a){
		this.initialize(a);
		Integer[] order=(Integer[]) new Integer[players.length];
		order[0]=null;
		for(int i=1;i<players.length;i++){
			order[i]=this.players[tree[i]];
			//this.change(tree[1],999999999); second argument should be of 'Item' type
		}
		return order;
	}
	
	public String toString(){
		System.out.println("Offset: "+this.offset+" LowExt: "+this.lowExt);
		String output = "";
		int n = this.tree.length;
		for(int i = 1; i < n; i++)
			output += ("["+this.players[this.tree[i]]+"]");
		return output;
	}
	
	public static void main(String[] args){
		WinnerTree tree = new WinnerTree();
		Integer[] a = {0,4,9,3,5,1,6};
		tree.initialize(a);
		
		System.out.println("initialized: "+tree);
		System.out.println("wins: "+tree.getWinner());
		System.out.println();
		
		System.out.println("MATCHES:");
		Integer[] b = new Integer[a.length];
		for(int i = 1; i < a.length; i++){
			b[i] = tree.getWinner();
			System.out.println("Winner-> "+tree.getWinner());
			tree.change(tree.winnerIndex(),0x7FFFFFFF); //
			tree.replay(tree.winnerIndex());
		}
		//System.out.println(Arrays.toString(b));
	}
}

