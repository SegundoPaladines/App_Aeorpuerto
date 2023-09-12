
package Objetos;

public class Vuelo<Public> {
	
	int id;
	String fecha;
	Avion avion;
	int cantidadpasajeros;
	String horasalida;
	
	public Vuelo (int id, String fecha, Avion avion, int cantidadpasajeros, String horasalida) {
		
		this.id=id;
		this.fecha=fecha;
		this.avion=avion;
		this.cantidadpasajeros=cantidadpasajeros;
		this.horasalida=horasalida;
		
	}
}
