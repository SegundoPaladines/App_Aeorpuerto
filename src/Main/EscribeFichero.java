package Main;

import java.io.*;

public class EscribeFichero
{
    public static void main(String[] args)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("C:\\Users\\Asus-PC\\Desktop\\Archivos\\fichero.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 10; i++) {
            	pw.println("Linea " + i);
             System.out.println("Escribiendo"+"Linea"+i);
        }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           //Nuevamente aprovechamos el finally para 
           //asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
}
