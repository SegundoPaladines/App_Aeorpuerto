package Objetos;
import javax.swing.JOptionPane;
public class Avion {
	
	int id;
	Pasajero pasajeros[];
	int cantidadpasajeros;
	public boolean estado;
	
	public Avion (int id) {
		this.id=id;
		this.cantidadpasajeros=0;
		this.pasajeros=new Pasajero[100];
		this.estado=true;
	}
	
	public void AgregarPasajero(Pasajero pasajero) {
		
		if(cantidadpasajeros<99) {
			
			this.pasajeros[this.cantidadpasajeros]=pasajero;
			this.cantidadpasajeros=this.cantidadpasajeros+1;
			JOptionPane.showMessageDialog(null, "Pasajero registrado con exito");
		}else {JOptionPane.showMessageDialog(null, "No hay sillas libres en el avion", "Error!", JOptionPane.ERROR_MESSAGE);}
		
		
	}
}
