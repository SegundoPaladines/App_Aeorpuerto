package Objetos;

public class VueloSalida extends Vuelo<Object>{
	
	String destino;
	
	public VueloSalida (int id, String fecha, Avion avion, int cantidadpasajeros, String horasalida, String destino) {
		
		super(id, fecha, avion, cantidadpasajeros, horasalida);
		this.destino = destino;
		
	}

}
