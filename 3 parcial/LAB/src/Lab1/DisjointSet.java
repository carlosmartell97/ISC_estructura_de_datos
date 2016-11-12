package Lab1;

public class DisjointSet {
	int[] p;	// para los padres
	int[] rank;	// para los rangos de cada nodo
	int[] size;	// para los tamaños de cada nodo
	int numSets;
	
	public void makeSet(int n){
		this.p=new int[n];
		this.rank=new int[n];
		this.size=new int[n];
		
		for(int i=0;i<n;i++){
			p[i]=i;
			rank[i]=0;
			size[i]=1;
		}
		numSets=n;
	}
	
	public int Find(int x){	// con "path compression", devuelve en qué conjunto está
		if(this.p[x]!=x) this.p[x]=Find(p[x]);
		return this.p[x];
	}
	
	public boolean isSameSet(int i,int j){
		return Find(i)==Find(j);
	}
	
	public void Union(int i,int j){	// también deberá actualizar numSets y el tamaño en su size[] correspondiente
		int iSet=Find(i);
		int jSet=Find(j);
		if(this.rank[iSet]>this.rank[jSet]){
			this.p[jSet]=this.p[iSet];
			this.size[iSet]+=this.size[jSet];
		}
		else{
			this.p[iSet]=this.p[jSet];
			this.size[jSet]+=this.size[iSet];
			if(rank[iSet]==rank[jSet]){
				rank[jSet]=rank[iSet]+1;
			}
		}
		this.numSets--;
	}
	
	public int numDisjointSets(){
		return this.numSets;
	}
	
	public int sizeOfSet(int i){	// cuántos elementos donde está i
		return this.size[Find(i)];
	}
	
	public static void main(String[] args) {
		DisjointSet s = new DisjointSet();
		  int n = 5;
		  s.makeSet(n);
		  
		  System.out.println("sets: "+s.numDisjointSets());
		  
		  s.Union(0, 1);
		  s.Union(1, 2);
		  s.Union(3, 4);
		  
		  System.out.println("sets: "+s.numDisjointSets());
		  
		  System.out.print("Parents: ");
		  for(int i =0; i < n;i++){
		   System.out.print("["+s.p[i]+"]");
		  }
		  System.out.println();
		  
		  System.out.print("Size: ");
		  for(int i =0; i < n;i++){
		   System.out.print("["+s.size[i]+"]");
		  }
		  System.out.println();
		  System.out.print("Rank: ");
		  for(int i =0; i < n;i++){
		   System.out.print("["+s.rank[i]+"]");
		  }
		  System.out.println();
		  System.out.println("set1: "+s.sizeOfSet(1));
		 }
}
