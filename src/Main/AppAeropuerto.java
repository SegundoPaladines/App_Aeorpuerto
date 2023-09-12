package Main;
import javax.swing.JOptionPane;

import Objetos.*;
public class AppAeropuerto {

	public static void main(String[] args) {
		
		MyIcon icon = new MyIcon();
		String[] roles = {
				
	            "Aeropuerto",
	            "Pasajero",
	            "Salir"
	        };
		
		int ida=123;
		Aeropuerto antonionarino=new Aeropuerto(ida);
		
		String rol= (String) JOptionPane.showInputDialog(null, "Seleccione el rol", "Rol", JOptionPane.DEFAULT_OPTION, icon, roles, roles[0]);
		
	       while(rol!="Salir") {
	    	   
	    	   if(rol.equals("Aeropuerto")) {
		    	   
		    	   String[] opciones = {
		   				
		    			"Agendar Vuelo",
		    			"Registar Pasajero",
		   	            "Agregar un avión",
		   	            "Añadir Vuelo",
		   	            "Cancelar Vuelo",
		   	            "Consultar Vuelos",
		   	            "Modificar Vuelos",
		   	            "Salir"
		   	        };
		    	   String opcion= (String) JOptionPane.showInputDialog(null, "Accion a realizar", "Menu", JOptionPane.DEFAULT_OPTION, icon, opciones, opciones[0]);
		    	   
		    	  while (opcion!="Salir") {
		    		  switch(opcion)
			    	   {
			    	   		
			    	   		case "Agendar Vuelo":
			    	   			String[] vuelos = {
			    		   				
			    		    			"Llegada",
			    		    			"Salida"
			    		   	        };
			    		    	   String tipo= (String) JOptionPane.showInputDialog(null, "Tipo de vuelo", "Menu", JOptionPane.DEFAULT_OPTION, icon, vuelos, vuelos[0]);
			    		    	   if(tipo.equals("Llegada")) {
			    		    		   
			    		    		  int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del vuelo"));
			    		    		  String fecha = JOptionPane.showInputDialog("Ingrese la fecha \n dd/mm/aa");
			    		    		  int idavion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del avion"));
			    		    		  Avion avion1=antonionarino.BuscarAvion(idavion);
			    		    		  
			    		    		  if(avion1==null) {
			    		    			  
			    		    			  JOptionPane.showMessageDialog(null, "Avion no existe", "ERROR", JOptionPane.DEFAULT_OPTION, icon);
			    		    		  }else {
			    		    			  
			    		    			  if (avion1.estado==true) {
			    		    				  
			    		    				  int cantidadpasajeros=0;
				    		    			  String horasalida=JOptionPane.showInputDialog("Ingrese la hora de partida hh:mm: am/pm");
				    		    			  String origen=JOptionPane.showInputDialog("Ingrese el origen del avion pais-ciudad");
				    		    			  VueloLlegada aux=new VueloLlegada(id, fecha, avion1, cantidadpasajeros, horasalida, origen);
				    		    			  
				    		    			  antonionarino.AgendarLlegada(aux);
			    		    				  
			    		    			  }else { JOptionPane.showMessageDialog(null, "Avion no disponible", "ERROR", JOptionPane.DEFAULT_OPTION, icon);}
			    		    		  }
			    		    		   
			    		    	   }
			    		    	   
			    		    	   if(tipo.equals("Salida")) {
			    		    		   
				    		    		  int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del vuelo"));
				    		    		  String fecha = JOptionPane.showInputDialog("Ingrese la fecha \n dd/mm/aa");
				    		    		  int idavion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del avion"));
				    		    		  Avion avion1=antonionarino.BuscarAvion(idavion);
				    		    		  
				    		    		  if(avion1==null) {
				    		    			  
				    		    			  JOptionPane.showMessageDialog(null, "Avion no existe", "ERROR", JOptionPane.DEFAULT_OPTION, icon);
				    		    		  }else {
				    		    			  
				    		    			  if (avion1.estado==true) {
				    		    				  int cantidadpasajeros=0;
					    		    			  String horasalida=JOptionPane.showInputDialog("Ingrese la hora de salida hh:mm: am/pm");
					    		    			  String origen=JOptionPane.showInputDialog("Ingrese el destino del avion pais-ciudad");
					    		    			  VueloSalida aux=new VueloSalida(id, fecha, avion1, cantidadpasajeros, horasalida, origen);
					    		    			  
					    		    			  antonionarino.AgendarSalida(aux);
				    		    			  }else { JOptionPane.showMessageDialog(null, "Avion no disponible", "ERROR", JOptionPane.DEFAULT_OPTION, icon);}
				    		    		  }
			    		    	   }
			    	   			break;
			    	   			
			    	   		case "Registar Pasajero":
			    	   			
			    	   			String nombre=JOptionPane.showInputDialog("Ingrese el nombre del pasajero");
			    	   			int cedula=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cedula del pasajero"));
			    	   			Pasajero pasajero1=new Pasajero(cedula, nombre);
			    	   			int idvuelo6=Integer.parseInt(JOptionPane.showInputDialog("el id del vuelo del pasajero"));
			    	   			boolean temp=antonionarino.AgrPsaVuelo(pasajero1, idvuelo6);
			    	   			if(temp==true) { JOptionPane.showMessageDialog(null, "agregado con exito", "Exito", JOptionPane.DEFAULT_OPTION, icon);}
			    	   			else {
			    	   				JOptionPane.showMessageDialog(null, "Registro fallido", "Error", JOptionPane.DEFAULT_OPTION, icon);
			    	   			}
			    	   			
			    	   			JOptionPane.showMessageDialog(null, "Resgitro exitoso", "Registrado", JOptionPane.DEFAULT_OPTION, icon);
			    	   			break;
			    	   		
			    	   		case  "Agregar un avión":
			    	   			
			    	   			int idavion=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del avion"));
			    	   			Avion avion1=new Avion(idavion);
			    	   			antonionarino.AgregarAvion(avion1);
			    	   			break;
			    	   			
			    	   		case "Añadir Vuelo":
			    	   			String[] vuelos1 = {
			    		   				
			    		    			"Llegada",
			    		    			"Salida"
			    		   	        };
			    		    	   String tipo1= (String) JOptionPane.showInputDialog(null, "Tipo de vuelo", "Menu", JOptionPane.DEFAULT_OPTION, icon, vuelos1, vuelos1[0]);
			    		    	   if(tipo1.equals("Llegada")) {
			    		    		   
			    		    		   int idvuelo=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del vuelo-numero"));
			    		    		   String fechavuelo=JOptionPane.showInputDialog("Ingrese la fecha del vuelo");
			    		    		   int idavionv1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del avion que hara el vuelo-numero"));
			    		    		   Avion avv1=antonionarino.BuscarAvion(idavionv1);
			    		    		   if(avv1!=null) {
			    		    			   
			    		    			   if (avv1.estado==true) {
			    		    				   
			    		    				   int cantidadpv1=Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de pasajeros 100 como maximo"));
				    		    			   if(cantidadpv1<=100) {
				    		    				   
				    		    				   String horasalidav1=JOptionPane.showInputDialog("Ingrese la hora de salida-hh:mm");
					    		    			   String origenv1=JOptionPane.showInputDialog("Ingrese el origen del vuelo");
					    		    			   VueloLlegada v11=new VueloLlegada(idvuelo, fechavuelo, avv1, cantidadpv1, horasalidav1, origenv1);
					    		    			   antonionarino.ResgitrarVueloLlegada(v11);
				    		    				   
				    		    			   }else { JOptionPane.showMessageDialog(null, "Cantidad de pasajeros no soportada", "ERROR", JOptionPane.DEFAULT_OPTION, icon);}
			    		    				   
			    		    			   }else { JOptionPane.showMessageDialog(null, "Avion no disponible", "ERROR", JOptionPane.DEFAULT_OPTION, icon);}

			    		    		   }else { JOptionPane.showMessageDialog(null, "Avion no esxiste", "ERROR", JOptionPane.DEFAULT_OPTION, icon);}
			    		    	   }
			    		    	   
			    		    	   if(tipo1.equals("Salida")) {
			    		    		   
			    		    		   int idvuelo2=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del vuelo-numero"));
			    		    		   String fechavuelo2=JOptionPane.showInputDialog("Ingrese el dnombre del pasajero");
			    		    		   int idavionv2=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del avion que hara el vuelo-numero"));
			    		    		   Avion avv2=antonionarino.BuscarAvion(idavionv2);
			    		    		   if(avv2!=null) {
			    		    			   
			    		    			   if (avv2.estado==true) {
			    		    				   
			    		    				   int cantidadpv2=Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de pasajeros 100 como maximo"));
				    		    			   if(cantidadpv2<=100) {
				    		    				   
				    		    				   String horasalidav2=JOptionPane.showInputDialog("Ingrese la hora de partida-hh:mm");
					    		    			   String destinov2=JOptionPane.showInputDialog("Ingrese el destinon del vuelo");
					    		    			   VueloSalida v22=new VueloSalida(idvuelo2, fechavuelo2, avv2, cantidadpv2, horasalidav2, destinov2);
					    		    			   antonionarino.RegistrarVueloSalida(v22);
				    		    				   
				    		    			   }else { JOptionPane.showMessageDialog(null, "Cantidad de pasajeros no soportada", "ERROR", JOptionPane.DEFAULT_OPTION, icon);}
			    		    			   }else { JOptionPane.showMessageDialog(null, "Avion no disponible", "ERROR", JOptionPane.DEFAULT_OPTION, icon);}

			    		    		   }else { JOptionPane.showMessageDialog(null, "Avion no existe", "ERROR", JOptionPane.DEFAULT_OPTION, icon);}
			    		    	   }
			    	   			break;
			    	   		case "Cancelar Vuelo":
			    	   		
			    	   		 int idvuelo3=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del vuelo-numero"));
			    	   		 boolean x=antonionarino.CancelarVuelo(idvuelo3);
			    	   		 for(int i=0; i<antonionarino.pasajeros.size();i++) {
			    	   			 
			    	   			 Pasajero p1= antonionarino.pasajeros.get(i);
			    	   			 p1.EliminarVuelo(idvuelo3);
			    	   		 }
			    	   		 if(x==true) {
			    	   			 
			    	   			JOptionPane.showMessageDialog(null, "Vuelo eliminado", "Eliminado", JOptionPane.DEFAULT_OPTION, icon);
			    	   			 
			    	   		 }else {JOptionPane.showMessageDialog(null, "No se encontro el vuelo", "ERROR", JOptionPane.DEFAULT_OPTION, icon); }
			    	   		 
			    	   		break;
			    	   		
			    	   		case "Consultar Vuelos":
			    	   			
			    	   			String impvuelos=antonionarino.ListaVuelos();
			    	   			JOptionPane.showMessageDialog(null, impvuelos, "Vuelos", JOptionPane.DEFAULT_OPTION, icon);
			    	   			
			    	   			break;
			    	   		case "Modificar Vuelos":
			    	   			
			    	   			antonionarino.ModificarVuelo();
			    	   			
			    	   			break;
			    	   			
			    	   	 default: JOptionPane.showMessageDialog(null, "Ellecion incorrecta", "ERROR", JOptionPane.DEFAULT_OPTION, icon);
			    	   			
			    	   			
			    	   }
		    		  opcion= (String) JOptionPane.showInputDialog(null, "Accion a realizar", "Menu", JOptionPane.DEFAULT_OPTION, icon, opciones, opciones[0]);
		    	  }
		    	   
		       }
	    	   
	    	   if (rol.equals("Pasajero")) {
	    		   
	    		   String[] acciones = {
	    					
	    		            "Reservar Vuelo",
	    		            "Listar Vuelos",
	    		            "Cambiar De Vuelo",
	    		            "Cancelar Vuelo",
	    		            "Salir"
	    		        };
	    		   String accion= (String) JOptionPane.showInputDialog(null, "Seleccione el rol", "Rol", JOptionPane.DEFAULT_OPTION, icon, acciones, acciones[0]);
	    		   while (accion!="Salir") {
	    			   
	    			   if(accion.equals("Reservar Vuelo")) {
	    				   
	    				   String impvuelos=antonionarino.ListaVuelos();
	    				   int idvuelo= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del vuelo que desea reservar- numero \n 0 para salir"+impvuelos));
	    				   if (idvuelo==0) {}
	    				   else { 
	    					   
	    					   int cedula= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su cedula"));
	    					   String nombre= JOptionPane.showInputDialog(null, "ingrese su nombre");
	    					   Pasajero p1=new Pasajero(cedula, nombre);
	    					   boolean temp=antonionarino.AgrPsaVuelo(p1, idvuelo);
			    	   			if(temp==true) { JOptionPane.showMessageDialog(null, "agregado con exito", "Exito", JOptionPane.DEFAULT_OPTION, icon);}
			    	   			else {
			    	   				JOptionPane.showMessageDialog(null, "Registro fallido", "Error", JOptionPane.DEFAULT_OPTION, icon);
			    	   			}
	    					   
	    				   }
	    			   }
	    			   if(accion.equals("Listar Vuelos")) {
	    				   
	    				   int cedula= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su cedula"));
	    				   Pasajero p1=antonionarino.BuscarPasajero(cedula);
	    				   String impresion="";
	    				   if(p1!=null) 
	    				   {
	    					  impresion=p1.ListarVuelos();
	    				   }
	    				   else {impresion= "No hay vuelos reservados o pendientes";}
	    				   
	    				   JOptionPane.showMessageDialog(null, impresion, "VUELOS", JOptionPane.DEFAULT_OPTION, icon);
	    				   
	    				   
	    			   }
	    			   if(accion.equals("Cambiar De Vuelo")) {
	    				   
	    				   String impvuelos=antonionarino.ListaVuelos();
	    				   int idvuelo= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del vuelo al que desea cambiarse- numero \n 0 para salir"+impvuelos));
	    				   if (idvuelo==0) {}
	    				   else { 
	    					   
	    					   int cedula= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su cedula"));
	    					   Pasajero p234= antonionarino.BuscarPasajero(cedula);
	    					   if(p234!=null) {
		    					   int ide=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del vuelo a reemplazar \n"+p234.ListarVuelos()));
		    					   
		    					   if(ide!=-1) {
		    						   
		    						   int pos=antonionarino.BuscarPosPasajero(cedula);
		    						   antonionarino.pasajeros.get(pos).EliminarVuelo(ide);
		    						   boolean b=antonionarino.QuitarPsaVuelo(ide);
		    						   if(b==true) {
		    							   JOptionPane.showMessageDialog(null, "Hecho", "Tramite exitoso", JOptionPane.DEFAULT_OPTION, icon);
		    							   boolean temp=antonionarino.AgrPsaVuelo(p234, idvuelo);
		   			    	   				if(temp==true) { JOptionPane.showMessageDialog(null, "agregado con exito", "Exito", JOptionPane.DEFAULT_OPTION, icon);}
		   			    	   				else {
		   			    	   					JOptionPane.showMessageDialog(null, "Registro fallido", "Error", JOptionPane.DEFAULT_OPTION, icon);
		   			    	   				} 
		    						   }
		    						   else {JOptionPane.showMessageDialog(null, "Usted no esta programado en ese vuelo, pero quedo regisrado en el vuelo ya elegido anteriormente al que queria cambiar", "ERROR", JOptionPane.DEFAULT_OPTION, icon);}
		    					   }
	    					  }
	    					  else {JOptionPane.showMessageDialog(null, "Usted no esta programado para ningun vuelo", "ERROR", JOptionPane.DEFAULT_OPTION, icon);}
	    					   
	    					   
	    				   }
	    			   }
	    			   if(accion.equals("Cancelar Vuelo")) {
	    				   
	    				   int cedula=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su cedula"));
	    				   Pasajero p1=antonionarino.BuscarPasajero(cedula);
	    				   if(p1!=null) {
	    					   
	    					   String lista=p1.ListarVuelos();
	    					   int idv=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del vuelo a reemplazar \n"+lista));
		    				   int pos=antonionarino.BuscarPosPasajero(cedula);
		    				   if(pos!=-1) {
		    					   
		    					   antonionarino.pasajeros.get(pos).EliminarVuelo(idv);
		    					   antonionarino.QuitarPsaVuelo(idv);
		    				   
		    				   }
		    				   
		    				   else {JOptionPane.showMessageDialog(null, "cedula no valida");}
	    					   
	    				   }else {JOptionPane.showMessageDialog(null, "cedula no valida");}
	    				   
	    			   }
	    			   
	    			   accion= (String) JOptionPane.showInputDialog(null, "Seleccione el rol", "Rol", JOptionPane.DEFAULT_OPTION, icon, acciones, acciones[0]);
	    			   
	    		   }
	    	   
	    		   JOptionPane.showMessageDialog(null, "Hasta la proxima", "Salir", JOptionPane.DEFAULT_OPTION, icon);
	    	   }
	    	   
	    	 rol= (String) JOptionPane.showInputDialog(null, "Seleccione el rol", "Rol", JOptionPane.DEFAULT_OPTION, icon, roles, roles[0]);
	   }
	}
}
