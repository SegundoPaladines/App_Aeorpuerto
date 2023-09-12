package Objetos;

public class VueloLlegada extends Vuelo<Object>{
	
	String origen;
	
	public VueloLlegada (int id, String fecha, Avion avion, int cantidadpasajeros, String horasalida, String origen) {
		
		super(id, fecha, avion, cantidadpasajeros, horasalida);
		this.origen=origen;
		
	}

}
