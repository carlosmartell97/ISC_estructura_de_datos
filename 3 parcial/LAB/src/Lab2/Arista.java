package Lab2;

public class Arista {
	private Vertice destino;
	private double costo;
	
	private Vertice destino(){
		return this.destino;
	}
	
	private double costo(){
		return this.costo;
	}
	
	public Arista(Vertice destino,double costo){
		this.destino=destino;
		this.costo=costo;
	}
}
