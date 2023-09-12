package Objetos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Main.MyIcon;

public class Aeropuerto {

	int id;
	public ArrayList<VueloLlegada> ventrada ;
	public ArrayList<VueloSalida> vsalida;
	public ArrayList<Avion> aviones;
	public ArrayList<Pasajero> pasajeros;
	public ArrayList<VueloLlegada> agendaentrada;
	public ArrayList<VueloSalida> agendasalida;
	
	
	public Aeropuerto(int id) {
		
		this.id=id;
		this.ventrada= new ArrayList<VueloLlegada>();
		this.vsalida= new ArrayList<VueloSalida>();
		this.aviones= new ArrayList<Avion>();
		this.pasajeros= new ArrayList<Pasajero>();
		this.agendaentrada= new ArrayList<VueloLlegada>();
		this.agendasalida= new ArrayList<VueloSalida>();
	}
	
	public Avion BuscarAvion(int idavion) {
		
		int bandera=-1;
		for(int i=0; i<aviones.size(); i++) {
			
			Avion aux=aviones.get(i);
			if(aux.id==idavion) {bandera=i;}
			
		}
		if (bandera==-1) {return null;}
		else {return aviones.get(bandera);}
		
	}
	public void AgendarLlegada(VueloLlegada vuelo) {
		
		agendaentrada.add(vuelo);
		vuelo.avion.estado=false;
		
	}
	public void AgendarSalida(VueloSalida vuelo) {
		
		agendasalida.add(vuelo);
		vuelo.avion.estado=false;
		
	}
	
	public Pasajero BuscarPasajero(int cedula) {
		
		int bandera=-1;
		for(int i=0; i<pasajeros.size(); i++) {
			
			Pasajero aux=pasajeros.get(i);
			if(aux.cedula==cedula) { bandera=i;}
			
		}
		if(bandera==-1) {return null;}
		else {return pasajeros.get(bandera);}
		
	}
	public int BuscarPosPasajero(int cedula) {
		
		int pos=-1;
		for(int i=0; i<pasajeros.size(); i++) {
			
			Pasajero aux=pasajeros.get(i);
			if(aux.cedula==cedula) { pos=i;}
			
		}
		return pos;
		
	}
	public boolean QuitarPsaVuelo(int idvuelo) {
		
		boolean bandera= false;
		
		for(int i=0; i<this.ventrada.size();i++){
			
			if(this.ventrada.get(i).id==idvuelo) {
				
				this.ventrada.get(i).cantidadpasajeros=this.ventrada.get(i).cantidadpasajeros-1;
				bandera=true;
				
			}
			
		}
		
		for(int i=0; i<this.vsalida.size();i++){
			
			if(this.vsalida.get(i).id==idvuelo) {
				
				this.vsalida.get(i).cantidadpasajeros=this.vsalida.get(i).cantidadpasajeros-1;
				bandera=true;
				
			}
			
		}
		
		for(int i=0; i<this.agendaentrada.size();i++){
			
			if(this.agendaentrada.get(i).id==idvuelo) {
				
				this.agendaentrada.get(i).cantidadpasajeros=this.agendaentrada.get(i).cantidadpasajeros-1;
				bandera=true;
				
			}
			
		}
		for(int i=0; i<this.agendasalida.size();i++){
			
			if(this.agendasalida.get(i).id==idvuelo) {
				
				this.agendasalida.get(i).cantidadpasajeros=this.agendasalida.get(i).cantidadpasajeros-1;
				bandera=true;
				
			}
			
		}
		
		
		return bandera;
		
	}

	public boolean AgrPsaVuelo(Pasajero pasajero, int idvuelo) {
		
		boolean bandera= false;
		
		for(int i=0; i<this.ventrada.size();i++){
			
			if(this.ventrada.get(i).id==idvuelo) {
				
				
				bandera=true;
				Pasajero aux=BuscarPasajero(pasajero.cedula);
				this.ventrada.get(i).cantidadpasajeros=this.ventrada.get(i).cantidadpasajeros+1;
				if (aux==null) {
					
					pasajero.cantidadv1=1;
					pasajero.vuelos1[0]=this.ventrada.get(i);
					pasajeros.add(pasajero);
				
				}
				
				else {
					MyIcon icon = new MyIcon();
					
					int k=this.BuscarPosPasajero(pasajero.cedula);
					aux.vuelos1[aux.cantidadv1]=ventrada.get(i);
					aux.cantidadv1=aux.cantidadv1+1;
					this.pasajeros.set(k, aux);
					
					
					JOptionPane.showMessageDialog(null, "El Pasajerotiene otros vuelos", "Avertencia", JOptionPane.DEFAULT_OPTION, icon);
					
				}
				
			}
			
		}
		for(int i=0; i<this.vsalida.size();i++){
			
			if(this.vsalida.get(i).id==idvuelo) {
				
				bandera=true;
				Pasajero aux=BuscarPasajero(pasajero.cedula);
				this.vsalida.get(i).cantidadpasajeros=this.vsalida.get(i).cantidadpasajeros+1;
				if (aux==null) {
					
					pasajero.cantidadv2=1;
					pasajero.vuelos2[0]=this.vsalida.get(i);
					pasajeros.add(pasajero);
				
				}
				
				else {
					
					int k=this.BuscarPosPasajero(pasajero.cedula);
					this.pasajeros.get(k).cantidadv2=this.pasajeros.get(k).cantidadv2+1;
					this.pasajeros.get(k).vuelos2[this.pasajeros.get(k).cantidadv2-1]=this.vsalida.get(i);
					
					MyIcon icon = new MyIcon();
					JOptionPane.showMessageDialog(null, "El Pasajerotiene otros vuelos", "Avertencia", JOptionPane.DEFAULT_OPTION, icon);
					
				}
				
			}
			
		}
		for(int i=0; i<this.agendaentrada.size();i++){
			
			if(this.agendaentrada.get(i).id==idvuelo) {
				
				bandera=true;
				Pasajero aux=BuscarPasajero(pasajero.cedula);
				this.agendaentrada.get(i).cantidadpasajeros=this.agendaentrada.get(i).cantidadpasajeros+1;
				if (aux==null) {
					
					pasajero.cantidadv1=1;
					pasajero.vuelos1[0]=this.agendaentrada.get(i);
					pasajeros.add(pasajero);
				
				}
				
				else {
					
					int k=this.BuscarPosPasajero(pasajero.cedula);
					this.pasajeros.get(k).cantidadv1=this.pasajeros.get(k).cantidadv1+1;
					this.pasajeros.get(k).vuelos1[this.pasajeros.get(k).cantidadv1-1]=this.agendaentrada.get(i);
					
					MyIcon icon = new MyIcon();
					JOptionPane.showMessageDialog(null, "El Pasajerotiene otros vuelos", "Avertencia", JOptionPane.DEFAULT_OPTION, icon);
					
				}
				
			}
			
		}
		for(int i=0; i<this.agendasalida.size();i++){
			
			if(this.agendasalida.get(i).id==idvuelo) {
				
				bandera=true;
				Pasajero aux=BuscarPasajero(pasajero.cedula);
				this.agendasalida.get(i).cantidadpasajeros=this.agendasalida.get(i).cantidadpasajeros+1;
				if (aux==null) {
					
					pasajero.cantidadv2=1;
					pasajero.vuelos2[0]=this.agendasalida.get(i);
					pasajeros.add(pasajero);
				
				}
				
				else {
					
					int k=this.BuscarPosPasajero(pasajero.cedula);
					this.pasajeros.get(k).cantidadv2=this.pasajeros.get(k).cantidadv2+1;
					this.pasajeros.get(k).vuelos2[this.pasajeros.get(k).cantidadv2-1]=this.agendasalida.get(i);
					
					MyIcon icon = new MyIcon();
					JOptionPane.showMessageDialog(null, "El Pasajerotiene otros vuelos", "Avertencia", JOptionPane.DEFAULT_OPTION, icon);
					
				}
				
			}
			
		}
		
		return bandera;
		
	}
	public void AgregarPasajero(Pasajero pasajero) {
		
		Pasajero aux=BuscarPasajero(pasajero.cedula);
		if (aux==null) {pasajeros.add(pasajero);}
		
		else {
			MyIcon icon = new MyIcon();
			JOptionPane.showMessageDialog(null, "El Pasajerotiene otros vuelos", "Avertencia", JOptionPane.DEFAULT_OPTION, icon);
			
		}
		
	}

	public void AgregarAvion(Avion avion) {
		
		MyIcon icon = new MyIcon();
		Avion aux=BuscarAvion(avion.id);
		if (aux==null) {
			
			aviones.add(avion);
			JOptionPane.showMessageDialog(null, "Resgitro exitoso, cada avion tien una capacidad de 100 pasajeros como maximo", "Registrado", JOptionPane.DEFAULT_OPTION, icon);

			
		}
		
		else {
			
			JOptionPane.showMessageDialog(null, "El avion ya esta registrado", "Error", JOptionPane.DEFAULT_OPTION, icon);
			
		}
		
	}
	public void ResgitrarVueloLlegada(VueloLlegada vuelo) {
		
		ventrada.add(vuelo);
		vuelo.avion.estado=false;
		
	}
	public void RegistrarVueloSalida(VueloSalida vuelo) {
		
		vsalida.add(vuelo);
		vuelo.avion.estado=false;
		
	}
	

	public boolean CancelarVuelo(int id) {
		
		boolean bandera=false;
		for(int i=0; i<ventrada.size(); i++) {
			
			VueloLlegada aux=ventrada.get(i);
			if(aux.id==id) {
				ventrada.get(i).avion.estado=true;
				ventrada.remove(i); bandera=true;}
		}
		
		for(int i=0; i<vsalida.size(); i++) {
			
			VueloSalida aux=vsalida.get(i);
			if(aux.id==id) {
				vsalida.get(i).avion.estado=true;
				vsalida.remove(i); bandera=true;}
		}
		
		for(int i=0; i<agendaentrada.size(); i++) {
			
			VueloLlegada aux=agendaentrada.get(i);
			if(aux.id==id) {
				agendaentrada.get(i).avion.estado=true;
				agendaentrada.remove(i); bandera=true;}
		}
		
		for(int i=0; i<agendasalida.size(); i++) {
			
			VueloSalida aux=agendasalida.get(i);
			if(aux.id==id) {
				agendasalida.get(i).avion.estado=true;
				agendasalida.remove(i); bandera=true;}
		}
		
		return bandera;
		
	}
	public void ModificarVuelo() {
		
		MyIcon icon = new MyIcon();
		boolean bandera=false;
		String[] vuelo = {
   				
    			"Vuelos",
    			"Agenda",
    			"Salir"
   	        };
    	   String tipo= (String) JOptionPane.showInputDialog(null, "Tipo de vuelo", "Menu", JOptionPane.DEFAULT_OPTION, icon, vuelo, vuelo[0]);
		
    	   while(tipo!="Salir") {
    		   
    	    	 if(tipo.equals("Vuelos")) {
    	    		 
    	    		 String[] vuelo1 = {
    	    	   				
    	    	    			"Entrada",
    	    	    			"Salida",
    	    	    			"Salir"
    	    	   	        };
    	    	    	   String tipo1= (String) JOptionPane.showInputDialog(null, "Tipo de vuelo", "Menu", JOptionPane.DEFAULT_OPTION, icon, vuelo1, vuelo1[0]);
    	    	    	   
    	    	    	   while(tipo1!="Salir"){
    	    	    		   
    	    	    		   if(tipo1.equals("Entrada")) {
    	    	    			   
    	    	    			   int id=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del vuelo-numero \n "+this.ListaVuelos()));
        	    	    		   for(int i=0; i<ventrada.size(); i++) {
        	    	    	   			
        	    	    	   			VueloLlegada aux=ventrada.get(i);
        	    	    	   			if(aux.id==id) {
        	    	    	   				
        	    	    	   			 bandera=true;
        	    	    	   			 String[] cambiar = {
        	    	    	    	   				
        	    	    	    	    			"Fecha",
        	    	    	    	    			"Avion",
        	    	    	    	    			"Hora de salida",
        	    	    	    	    			"Cantidad Pasajeros",
        	    	    	    	    			"Origen",
        	    	    	    	    			"Finalizar"
        	    	    	    	   	        };
        	    	    	    	    	String opcion1= (String) JOptionPane.showInputDialog(null, "Tipo de vuelo", "Menu", JOptionPane.DEFAULT_OPTION, icon, cambiar, cambiar[0]);
        	    	    	   				while(opcion1!="Finalizar") {
        	    	    	   					
        	    	    	   					if(opcion1.equals("Fecha")) {
        	    	    	   						
        	    	    	   						ventrada.get(i).fecha=JOptionPane.showInputDialog("Ingrese la nueva fecha - dd/mm/aa");
        	    	    	   						JOptionPane.showMessageDialog(null, "Fecha cambiada", "Exito", JOptionPane.DEFAULT_OPTION, icon);
        	    	    	   						
        	    	    	   					}
        	    	    	   					if(opcion1.equals("Avion")) {
        	    	    	   						
        	    	    	   						int idav=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo id de avion- numero"));
        	    	    	   						Avion av1=BuscarAvion(idav);
        	    	    	   						if(av1==null || av1.estado==false) {JOptionPane.showMessageDialog(null, "Avion no existe o esta ocupado", "ERROR", JOptionPane.DEFAULT_OPTION, icon);}
        	    	    	   						else {ventrada.get(i).avion=av1; JOptionPane.showMessageDialog(null, "Avion Cmbiado", "Exito", JOptionPane.DEFAULT_OPTION, icon);}
        	    	    	   						
        	    	    	   					}
        	    	    	   					if(opcion1.equals("Hora de salida")) {
        	    	    	   						
        	    	    	   						ventrada.get(i).horasalida=JOptionPane.showInputDialog("Ingrese la nueva hora de partida-hh:mm");
        	    	    	   						JOptionPane.showMessageDialog(null, "Hora cambiada", "Exito", JOptionPane.DEFAULT_OPTION, icon);
        	    	    	   						
        	    	    	   					}
        	    	    	   					if(opcion1.equals("Cantidad Pasajeros")) {
        	    	    	   						
        	    	    	   						int pass=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de pasajeros"));
        	    	    	   						if(pass<=100) {ventrada.get(i).cantidadpasajeros=pass; JOptionPane.showMessageDialog(null, "Cantidad de pasajeros cambiada con exito", "Exito", JOptionPane.DEFAULT_OPTION, icon);}
        	    	    	   						else {JOptionPane.showMessageDialog(null, "El maximo de pasajeros es 100", "ERRO", JOptionPane.DEFAULT_OPTION, icon);}
        	    	    	   						
        	    	    	   						
        	    	    	   					}
        	        	    	   				if(opcion1.equals("Origen")) {
        	        	    	   						
        	        	    	   					ventrada.get(i).origen=JOptionPane.showInputDialog("Ingrese el nuevo origen");
        	        	    	   						JOptionPane.showMessageDialog(null, "Origen cambiado", "Exito", JOptionPane.DEFAULT_OPTION, icon);
        	        	    	   						
        	        	    	   				}
        	        	    	   				opcion1= (String) JOptionPane.showInputDialog(null, "Tipo de vuelo", "Menu", JOptionPane.DEFAULT_OPTION, icon, cambiar, cambiar[0]);
        	    	    	   					
        	    	    	   				}
        	    	    	   			 
        	    	    	   			}
        	    	    		   
        	    	    		   }
        	    	    	   }
        	    	    	   if(tipo1.equals("Salida")) {
        	    	    		   
        	    	    		   for(int i=0; i<vsalida.size(); i++) {
        	    	    	   			
        	    	    	   			VueloSalida aux=vsalida.get(i);
        	    	    	   			int id=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del vuelo-numero \n "+this.ListaVuelos()));
        	    	    	   			if(aux.id==id) {
        	    	    	   				
        	    	    	   			 bandera=true;
        	    	    	   			 String[] cambiar = {
        	    	    	    	   				
        	    	    	    	    			"Fecha",
        	    	    	    	    			"Avion",
        	    	    	    	    			"Hora de salida",
        	    	    	    	    			"Cantidad Pasajeros",
        	    	    	    	    			"Destino",
        	    	    	    	    			"Finalizar"
        	    	    	    	   	        };
        	    	    	    	    	String opcion1= (String) JOptionPane.showInputDialog(null, "Tipo de vuelo", "Menu", JOptionPane.DEFAULT_OPTION, icon, cambiar, cambiar[0]);
        	    	    	   				while(opcion1!="Finalizar") {
        	    	    	   					
        	    	    	   					if(opcion1.equals("Fecha")) {
        	    	    	   						
        	    	    	   						vsalida.get(i).fecha=JOptionPane.showInputDialog("Ingrese la nueva fecha - dd/mm/aa");
        	    	    	   						JOptionPane.showMessageDialog(null, "Fecha cambiada", "Exito", JOptionPane.DEFAULT_OPTION, icon);
        	    	    	   						
        	    	    	   					}
        	    	    	   					if(opcion1.equals("Avion")) {
        	    	    	   						
        	    	    	   						int idav=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo id de avion- numero"));
        	    	    	   						Avion av1=BuscarAvion(idav);
        	    	    	   						if(av1==null || av1.estado==false) {JOptionPane.showMessageDialog(null, "Avion no existe o esta ocupado", "ERROR", JOptionPane.DEFAULT_OPTION, icon);}
        	    	    	   						else {vsalida.get(i).avion=av1; JOptionPane.showMessageDialog(null, "Avion Cmbiado", "Exito", JOptionPane.DEFAULT_OPTION, icon);}
        	    	    	   						
        	    	    	   					}
        	    	    	   					if(opcion1.equals("Hora de salida")) {
        	    	    	   						
        	    	    	   						vsalida.get(i).horasalida=JOptionPane.showInputDialog("Ingrese la nueva hora de partida-hh:mm");
        	    	    	   						JOptionPane.showMessageDialog(null, "Hora cambiada", "Exito", JOptionPane.DEFAULT_OPTION, icon);
        	    	    	   						
        	    	    	   					}
        	    	    	   					if(opcion1.equals("Cantidad Pasajeros")) {
        	    	    	   						
        	    	    	   						int pass=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de pasajeros"));
        	    	    	   						if(pass<=100) {vsalida.get(i).cantidadpasajeros=pass; JOptionPane.showMessageDialog(null, "Cantidad de pasajeros cambiada con exito", "Exito", JOptionPane.DEFAULT_OPTION, icon);}
        	    	    	   						else {JOptionPane.showMessageDialog(null, "El maximo de pasajeros es 100", "ERRO", JOptionPane.DEFAULT_OPTION, icon);}
        	    	    	   						
        	    	    	   						
        	    	    	   					}
        	        	    	   				if(opcion1.equals("Destino")) {
        	        	    	   						
        	        	    	   						vsalida.get(i).destino=JOptionPane.showInputDialog("Ingrese el nuevo origen");
        	        	    	   						JOptionPane.showMessageDialog(null, "Origen cambiado", "Exito", JOptionPane.DEFAULT_OPTION, icon);
        	        	    	   						
        	        	    	   				}
        	        	    	   				opcion1= (String) JOptionPane.showInputDialog(null, "Tipo de vuelo", "Menu", JOptionPane.DEFAULT_OPTION, icon, cambiar, cambiar[0]);
        	    	    	   					
        	    	    	   				}
        	    	    	   			}
        	    	    		   
        	    	    		   }
        	    	 		}
        	    	    	
        	    	        tipo1= (String) JOptionPane.showInputDialog(null, "Tipo de vuelo", "Menu", JOptionPane.DEFAULT_OPTION, icon, vuelo1, vuelo1[0]);
    	    	    		   
    	    	    	} 
    	    	 }
    	    	 if(tipo.equals("Agenda")) {
    	    	      		 
    	    	      	 String[] vuelo2 = {
    	    	      	   				
    	    	      	    		"Entrada",
    	    	      	    		"Salida",
    	    	      	    		"Salir"
    	    	      	   	       };
    	    	      	    String tipo2= (String) JOptionPane.showInputDialog(null, "Tipo de vuelo", "Menu", JOptionPane.DEFAULT_OPTION, icon, vuelo2, vuelo2[0]);
    	    	      	   while(tipo2!="Salir") {
    	    	      		   
    	    	      		 if(tipo2.equals("Entrada")) {
	    	      	    		   
        	    	      	     for(int i=0; i<agendaentrada.size(); i++) {
        	    	      	    	   		
        	    	      	    	   VueloLlegada aux=agendaentrada.get(i);
        	    	      	    	   	int id=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del vuelo-numero"));
        	    	      	    	   	if(aux.id==id) {
        	    	      	    	   				
        	    	      	    	   			 bandera=true;
        	    	      	    	   			 String[] cambiar = {
        	    	      	    	    	   				
        	    	      	    	    	    			"Fecha",
        	    	      	    	    	    			"Avion",
        	    	      	    	    	    			"Hora de salida",
        	    	      	    	    	    			"Cantidad Pasajeros",
        	    	      	    	    	    			"Origen",
        	    	      	    	    	    			"Finalizar"
        	    	      	    	    	   	        };
        	    	      	    	    	    	   String opcion1= (String) JOptionPane.showInputDialog(null, "Tipo de vuelo", "Menu", JOptionPane.DEFAULT_OPTION, icon, cambiar, cambiar[0]);
        	    	      	    	   				while(opcion1!="Finalizar") {
        	    	      	    	   					
        	    	      	    	   					if(opcion1.equals("Fecha")) {
        	    	      	    	   						
        	    	      	    	   					agendaentrada.get(i).fecha=JOptionPane.showInputDialog("Ingrese la nueva fecha - dd/mm/aa");
        	    	      	    	   						JOptionPane.showMessageDialog(null, "Fecha cambiada", "Exito", JOptionPane.DEFAULT_OPTION, icon);
        	    	      	    	   						
        	    	      	    	   					}
        	    	      	    	   					if(opcion1.equals("Avion")) {
        	    	      	    	   						
        	    	      	    	   						int idav=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo id de avion- numero"));
        	    	      	    	   						Avion av1=BuscarAvion(idav);
        	    	      	    	   						if(av1==null || av1.estado==false) {JOptionPane.showMessageDialog(null, "Avion no existe o esta ocupado", "ERROR", JOptionPane.DEFAULT_OPTION, icon);}
        	    	      	    	   						else {agendaentrada.get(i).avion=av1; JOptionPane.showMessageDialog(null, "Avion Cmbiado", "Exito", JOptionPane.DEFAULT_OPTION, icon);}
        	    	      	    	   						
        	    	      	    	   					}
        	    	      	    	   					if(opcion1.equals("Hora de salida")) {
        	    	      	    	   						
        	    	      	    	   					agendaentrada.get(i).horasalida=JOptionPane.showInputDialog("Ingrese la nueva hora de salia-hh:mm");
        	    	      	    	   						JOptionPane.showMessageDialog(null, "Hora cambiada", "Exito", JOptionPane.DEFAULT_OPTION, icon);
        	    	      	    	   						
        	    	      	    	   					}
        	    	      	    	   					if(opcion1.equals("Cantidad Pasajeros")) {
        	    	      	    	   						
        	    	      	    	   						int pass=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de pasajeros"));
        	    	      	    	   						if(pass<=100) {agendaentrada.get(i).cantidadpasajeros=pass; JOptionPane.showMessageDialog(null, "Cantidad de pasajeros cambiada con exito", "Exito", JOptionPane.DEFAULT_OPTION, icon);}
        	    	      	    	   						else {JOptionPane.showMessageDialog(null, "El maximo de pasajeros es 100", "ERRO", JOptionPane.DEFAULT_OPTION, icon);}
        	    	      	    	   						
        	    	      	    	   						
        	    	      	    	   					}
        	    	          	    	   				if(opcion1.equals("Origen")) {
        	    	          	    	   						
        	    	          	    	   						agendaentrada.get(i).origen=JOptionPane.showInputDialog("Ingrese el nuevo origen");
        	    	          	    	   						JOptionPane.showMessageDialog(null, "Origen cambiado", "Exito", JOptionPane.DEFAULT_OPTION, icon);
        	    	          	    	   						
        	    	          	    	   				}
        	    	          	    	   				
        	    	          	    	   			opcion1= (String) JOptionPane.showInputDialog(null, "Tipo de vuelo", "Menu", JOptionPane.DEFAULT_OPTION, icon, cambiar, cambiar[0]);
        	    	      	    	   					
        	    	      	    	   				}
        	    	      	    	   			}
        	    	      	    		   
        	    	      	    		   }
        	    	      	    	   }
        	    	      	    	   if(tipo2.equals("Salida")) {
        	    	      	    		   
        	    	      	    		   for(int i=0; i<agendasalida.size(); i++) {
        	    	      	    	   			
        	    	      	    	   			VueloSalida aux=agendasalida.get(i);
        	    	      	    	   			int id=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del vuelo-numero"));
        	    	      	    	   			if(aux.id==id) {
        	    	      	    	   				
        	    	      	    	   			 bandera=true;
        	    	      	    	   			 String[] cambiar = {
        	    	      	    	    	   				
        	    	      	    	    	    			"Fecha",
        	    	      	    	    	    			"Avion",
        	    	      	    	    	    			"Hora de salida",
        	    	      	    	    	    			"Cantidad Pasajeros",
        	    	      	    	    	    			"Destino",
        	    	      	    	    	    			"Finalizar"
        	    	      	    	    	   	        };
        	    	      	    	    	    	String opcion1= (String) JOptionPane.showInputDialog(null, "Tipo de vuelo", "Menu", JOptionPane.DEFAULT_OPTION, icon, cambiar, cambiar[0]);
        	    	      	    	   				while(opcion1!="Finalizar") {
        	    	      	    	   					
        	    	      	    	   					if(opcion1.equals("Fecha")) {
        	    	      	    	   						
        	    	      	    	   						agendasalida.get(i).fecha=JOptionPane.showInputDialog("Ingrese la nueva fecha - dd/mm/aa");
        	    	      	    	   						JOptionPane.showMessageDialog(null, "Fecha cambiada", "Exito", JOptionPane.DEFAULT_OPTION, icon);
        	    	      	    	   						
        	    	      	    	   					}
        	    	      	    	   					if(opcion1.equals("Avion")) {
        	    	      	    	   						
        	    	      	    	   						int idav=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo id de avion- numero"));
        	    	      	    	   						Avion av1=BuscarAvion(idav);
        	    	      	    	   						if(av1==null || av1.estado==false) {JOptionPane.showMessageDialog(null, "Avion no existe o esta ocupado", "ERROR", JOptionPane.DEFAULT_OPTION, icon);}
        	    	      	    	   						else {agendasalida.get(i).avion=av1; JOptionPane.showMessageDialog(null, "Avion Cmbiado", "Exito", JOptionPane.DEFAULT_OPTION, icon);}
        	    	      	    	   						
        	    	      	    	   					}
        	    	      	    	   					if(opcion1.equals("Hora de salida")) {
        	    	      	    	   						
        	    	      	    	   						agendasalida.get(i).horasalida=JOptionPane.showInputDialog("Ingrese la nueva hora de partida-hh:mm");
        	    	      	    	   						JOptionPane.showMessageDialog(null, "Hora cambiada", "Exito", JOptionPane.DEFAULT_OPTION, icon);
        	    	      	    	   						
        	    	      	    	   					}
        	    	      	    	   					if(opcion1.equals("Cantidad Pasajeros")) {
        	    	      	    	   						
        	    	      	    	   						int pass=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de pasajeros"));
        	    	      	    	   						if(pass<=100) {agendasalida.get(i).cantidadpasajeros=pass; JOptionPane.showMessageDialog(null, "Cantidad de pasajeros cambiada con exito", "Exito", JOptionPane.DEFAULT_OPTION, icon);}
        	    	      	    	   						else {JOptionPane.showMessageDialog(null, "El maximo de pasajeros es 100", "ERRO", JOptionPane.DEFAULT_OPTION, icon);}
        	    	      	    	   						
        	    	      	    	   						
        	    	      	    	   					}
        	    	          	    	   				if(opcion1.equals("Destino")) {
        	    	          	    	   						
        	    	          	    	   						agendasalida.get(i).destino=JOptionPane.showInputDialog("Ingrese el nuevo origen");
        	    	          	    	   						JOptionPane.showMessageDialog(null, "Origen cambiado", "Exito", JOptionPane.DEFAULT_OPTION, icon);
        	    	          	    	   						
        	    	          	    	   				}
        	    	      	    	   					
        	    	      	    	   				}
        	    	      	    	   				opcion1= (String) JOptionPane.showInputDialog(null, "Tipo de vuelo", "Menu", JOptionPane.DEFAULT_OPTION, icon, cambiar, cambiar[0]);
        	    	      	    	   			}
        	    	      	    		   
        	    	      	    		   }
        	    	      	 		
        	    	    }
        	    	   
        	    	  tipo2= (String) JOptionPane.showInputDialog(null, "Tipo de vuelo", "Menu", JOptionPane.DEFAULT_OPTION, icon, vuelo2, vuelo2[0]);
    	    	      		   
    	    	  }
    	   	}
    	  tipo= (String) JOptionPane.showInputDialog(null, "Tipo de vuelo", "Menu", JOptionPane.DEFAULT_OPTION, icon, vuelo, vuelo[0]);
    		   
    }
    	   
   if(bandera==false) {JOptionPane.showMessageDialog(null, "No se econtro el vuelo", "NOT FOUND", JOptionPane.DEFAULT_OPTION, icon);}
		
}
	
	public void ReservarVuelo(int idvuelo, int cedula, String nombre) {
		
		boolean bandera=false;
		if(bandera==false && ventrada.size()>0) {
			
			for(int i=0; i<ventrada.size(); i++) {
				
				if(ventrada.get(i).id==idvuelo) {
					
					Pasajero p1=new Pasajero(cedula, nombre);
					ventrada.get(i).avion.cantidadpasajeros=ventrada.get(i).avion.cantidadpasajeros+1;
					p1.AgregarVueloLlegada(ventrada.get(i));
					ventrada.get(i).avion.AgregarPasajero(p1);
					this.AgregarPasajero(p1);
					ventrada.get(i).cantidadpasajeros=ventrada.get(i).cantidadpasajeros+1;
					MyIcon icon = new MyIcon();
					JOptionPane.showMessageDialog(null, "Vuelo reservado con exito", "Reservado", JOptionPane.DEFAULT_OPTION, icon);
					bandera=true;
				}
				
			}
		}
		if(bandera==false && vsalida.size()>0) {
			
			for(int i=0; i<vsalida.size(); i++) {
				
				if(vsalida.get(i).id==idvuelo) {
					
					Pasajero p1=new Pasajero(cedula, nombre);
					vsalida.get(i).avion.cantidadpasajeros=vsalida.get(i).avion.cantidadpasajeros+1;
					p1.AgregarVueloSalida(vsalida.get(i));
					vsalida.get(i).avion.AgregarPasajero(p1);
					vsalida.get(i).cantidadpasajeros=vsalida.get(i).cantidadpasajeros+1;
					this.AgregarPasajero(p1);
					MyIcon icon = new MyIcon();
					JOptionPane.showMessageDialog(null, "Vuelo reservado con exito", "Reservado", JOptionPane.DEFAULT_OPTION, icon);
					bandera=true;
				}
				
			}
		}
		if(bandera==false && agendaentrada.size()>0) {
			
			for(int i=0; i<agendaentrada.size(); i++) {
				
				if(agendaentrada.get(i).id==idvuelo) {
					
					Pasajero p1=new Pasajero(cedula, nombre);
					agendaentrada.get(i).avion.cantidadpasajeros=agendaentrada.get(i).avion.cantidadpasajeros+1;
					p1.AgregarVueloLlegada(agendaentrada.get(i));
					agendaentrada.get(i).avion.AgregarPasajero(p1);
					this.AgregarPasajero(p1);
					agendaentrada.get(i).cantidadpasajeros=agendaentrada.get(i).cantidadpasajeros+1;
					MyIcon icon = new MyIcon();
					JOptionPane.showMessageDialog(null, "Vuelo reservado con exito", "Reservado", JOptionPane.DEFAULT_OPTION, icon);
					bandera=true;
				}
				
			}
		}
		if(bandera==false && agendasalida.size()>0) {
			
			for(int i=0; i<agendasalida.size(); i++) {
				
				if(agendasalida.get(i).id==idvuelo) {
					
					Pasajero p1=new Pasajero(cedula, nombre);
					agendasalida.get(i).avion.cantidadpasajeros=agendasalida.get(i).avion.cantidadpasajeros+1;
					p1.AgregarVueloSalida(agendasalida.get(i));
					agendasalida.get(i).avion.AgregarPasajero(p1);
					this.AgregarPasajero(p1);
					agendasalida.get(i).cantidadpasajeros=agendasalida.get(i).cantidadpasajeros+1;
					MyIcon icon = new MyIcon();
					JOptionPane.showMessageDialog(null, "Vuelo reservado con exito", "Reservado", JOptionPane.DEFAULT_OPTION, icon);
					bandera=true;
				}
				
			}
		}
		if(bandera==false) {MyIcon icon = new MyIcon();
			JOptionPane.showMessageDialog(null, "No se encontro el vuelo", "Error", JOptionPane.DEFAULT_OPTION, icon);}	
	}
	
	public String ListaVuelos() {
		
		String lista="Vuelos de salida \n";
		
		for(int i=0; i<vsalida.size();i++) {
			
			lista=lista+"Id: "+vsalida.get(i).id+" Fecha: "+vsalida.get(i).fecha+" ID de Avion: "+vsalida.get(i).avion.id+" Cantidad de pasajeros: "+vsalida.get(i).cantidadpasajeros+" HoraSalida: "+vsalida.get(i).horasalida+" Destino: "+vsalida.get(i).destino+"\n";
			
		}
		
		lista=lista+" \n Vuelos de Entrada \n";
		
		for(int i=0; i<ventrada.size();i++) {
			
			lista=lista+"Id: "+ventrada.get(i).id+" Fecha: "+ventrada.get(i).fecha+" ID de Avion: "+ventrada.get(i).avion.id+" Cantidad de pasajeros: "+ventrada.get(i).cantidadpasajeros+" HoraSalida: "+ventrada.get(i).horasalida+" Destino: "+ventrada.get(i).origen+"\n";
			
		}
		
		lista=lista+" \n Agenda de salida \n";
		
		for(int i=0; i<agendasalida.size();i++) {
			
			lista=lista+"Id: "+agendasalida.get(i).id+" Fecha: "+agendasalida.get(i).fecha+" ID de Avion: "+agendasalida.get(i).avion.id+" Cantidad de pasajeros: "+agendasalida.get(i).cantidadpasajeros+" HoraSalida: "+agendasalida.get(i).horasalida+" Destino: "+agendasalida.get(i).destino+"\n";
			
		}
		
		lista=lista+" \n Agenda de Entrada \n";
		
		for(int i=0; i<agendaentrada.size();i++) {
			
			lista=lista+"Id: "+agendaentrada.get(i).id+" Fecha: "+agendaentrada.get(i).fecha+" ID de Avion: "+agendaentrada.get(i).avion.id+" Cantidad de pasajeros: "+agendaentrada.get(i).cantidadpasajeros+" HoraSalida: "+agendaentrada.get(i).horasalida+" Destino: "+agendaentrada.get(i).origen+"\n";
			
		}
		return lista;
	}
	
	
}
