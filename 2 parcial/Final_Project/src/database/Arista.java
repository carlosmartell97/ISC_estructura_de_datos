/**
 *	Carlos Emmanuel Martell Avi�a A01225920
 *	Jes�s Alberto Alvarez Gomez A01039332
 */
package database;

public class Arista {
	protected Vertice destino;
	protected double costo;
	
	public Vertice destino(){
		return this.destino;
	}
	
	public double costo(){
		return this.costo;
	}
	
	public Arista(Vertice destino,double costo){
		this.destino=destino;
		this.costo=costo;
	}
}
