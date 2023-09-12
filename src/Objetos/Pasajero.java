package Objetos;

import javax.swing.JOptionPane;

public class Pasajero {
	
	public int cedula;
	public String nombre;
	public VueloLlegada vuelos1[];
	public VueloSalida vuelos2[];
	public int cantidadv1;
	public int cantidadv2;
	
	public Pasajero(int cedula, String nombre) {
		
		this.cedula=cedula;
		this.nombre=nombre;
		this.vuelos1=new VueloLlegada[10];
		this.vuelos2=new VueloSalida[10];
		this.cantidadv1=0;
		this.cantidadv2=0;
		
		for(int i=0; i<10; i++) {
			
			vuelos1[i]=null;
			vuelos2[i]=null;
		}
		
	}
	
	public void AgregarVueloLlegada(VueloLlegada vuelo) 
	{
		
		if(this.cantidadv1<10) {
			vuelos1[this.cantidadv1]=vuelo;
			this.cantidadv1=this.cantidadv1+1;
		}
		else { JOptionPane.showMessageDialog(null, "Registro fallido, Maximo vuelos alcanzado");}
		
	}
	public void AgregarVueloSalida(VueloSalida vuelo) 
	{
		
		if(this.cantidadv2<10) {
			vuelos2[this.cantidadv2]=vuelo;
			this.cantidadv2=this.cantidadv2+1;
		}
		else {JOptionPane.showMessageDialog(null, "registro fallido, Maximo vuelos alcanzado");}
		
	}
	public void EliminarVuelo(int id) {
		
		boolean bandera1=false;
		for(int i=0; i<this.cantidadv1; i++) {
			
			if(this.vuelos1[i]!=null){
				if(this.vuelos1[i].id==id) { 
					JOptionPane.showMessageDialog(null, "elemento eliminado"); 
					this.vuelos1[i]=null; 
					bandera1=true;
					this.cantidadv1=this.cantidadv1-1;
				}
			}
			
		}
		for(int i=0; i<this.cantidadv2; i++) {
			
			if(this.vuelos2[i]!=null) {
				
				if(this.vuelos2[i].id==id) { 
					JOptionPane.showMessageDialog(null, "elemento eliminado"); 
					this.vuelos2[i]=null; 
					bandera1=true;
					this.cantidadv2=this.cantidadv2-1;
				
				}
				
			}
			
		}
		
		if (bandera1=false) {JOptionPane.showMessageDialog(null, "Elemento no encontrado");}
		
	}
	
	public String ListarVuelos() {
		
		String lista="Vuelos: "+ " \n";
		
		if(this.cantidadv1>0) {
			for(int i=0; i<10; i++) {
				
				if(this.vuelos1[i]!=null){
					
					lista=lista+" id: "+this.vuelos1[i].id+ " fecha: "+this.vuelos1[i].fecha+" Hora: "+this.vuelos1[i].horasalida+" Origen: "+this.vuelos1[i].origen+ " \n";
					System.out.println(lista);
				}
			}
		}
		if(this.cantidadv2>0) {
			for(int i=0; i<10; i++) {
				
				if(this.vuelos2[i]!=null) {
					
					lista=lista+" id: "+this.vuelos2[i].id+ " fecha: "+this.vuelos2[i].fecha+" Hora: "+this.vuelos2[i].horasalida+" Origen: "+this.vuelos2[i].destino+ " \n";
				
				}
			}
		}
		
		return lista;
		
	}
}
