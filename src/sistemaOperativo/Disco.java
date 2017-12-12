/*
 * Clase encargada de leer y escribir en los sectores físicos del disco.
 */
package sistemaOperativo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Matías
 */
public class Disco
{

    private File disco;
    private final int numSectores;
    private final int tamSectores;

    public Disco(int numSectores, int tamSectores)
    {
        this.numSectores = numSectores;
        this.tamSectores = tamSectores;
        this.disco = new File("Nuevo Disco");
    }

    /**
     * Método encargado de crear un nuevo disco.
     */
    public void crearDisco()
    {
        FileWriter fw = null;
        PrintWriter pw = null;

        try
        {
            fw = new FileWriter(this.disco);
            pw = new PrintWriter(fw);
            Sector sector = new Sector(this.tamSectores);

            for (int i = 0; i < numSectores; i++)
            {
                pw.println(Arrays.toString(sector.getContenido()));
            }

        } catch (Exception e)
        {
            System.out.println("ERROR CREANDO EL DISCO...");
        } finally
        {
            try
            {
                if (fw != null)
                {
                    fw.close();
                }
            } catch (Exception e2)
            {
                System.out.println(e2.getMessage());
            }
        }
    }

    /**
     * Método que se encarga de leer un sector del Disco..
     *
     * @param numSector
     * @return lo que está escrito en un determinado sector del Disco.
     */
    public Sector leerSector(int numSector)
    {
        if (numSector <= this.numSectores && numSector >= 0)
        {
            Sector sector = new Sector(this.tamSectores);
            try
            {
                Scanner lector = new Scanner(this.disco);
                for (int i = 0; i < this.numSectores && lector.hasNextLine(); i++)
                {
                    char[] linea = lector.nextLine().toCharArray();
                    if (i == numSector)
                    {
                        //SI ENCUENTRO EL SECTOR QUE QUIERO REALIZO...
                        sector.setContenido(linea);
                        lector.close();
                        return sector;
                    }
                }
                lector.close();

            } catch (FileNotFoundException ex)
            {
                Logger.getLogger(Disco.class.getName()).log(Level.SEVERE, null, ex);
            }
            return sector;
        }

        return null;
    }

    /**
     * Método que se encarga de escribir en un determinado sector del Disco.
     *
     * @param numSector
     * @param sector
     */
    public void escribirEnSector(int numSector, Sector sector)
    {
        Scanner lector;
        ArrayList<String> lineas = new ArrayList();

        try
        {
            lector = new Scanner(this.disco);
            for (int i = 0; i < this.numSectores && lector.hasNextLine(); i++)
            {
                String linea = lector.nextLine();
                lineas.add(linea);
            }
            lector.close();
        } catch (Exception e)
        {
            System.out.println("ERROR AL LEER EL ARCHIVO...");
        }

        FileWriter fw = null;
        PrintWriter pw = null;

        try
        {
            fw = new FileWriter(this.disco);
            pw = new PrintWriter(fw);

            for (int i = 0; i < this.numSectores; i++)
            {
                //SI EL SECTOR NO ES EL QUE QUIERO, HAGO...
                if (i != numSector)
                {
                    pw.println(lineas.get(i));
                } else
                {
                    pw.println(Arrays.toString(sector.getContenido()));
                }
            }
        } catch (Exception e)
        {
            System.out.println("ERROR EN EL DISCO...");
        } finally
        {
            try
            {
                if (fw != null)
                {
                    fw.close();
                }
            } catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getNumSectores()
    {
        return numSectores;
    }

}
