/*
 * Clase encargada de modelar un sector del Disco. 
 */
package sistemaOperativo;

/**
 *
 * @author Matías
 */
public class Sector
{

    private int id;
    private char[] contenido;

    public Sector(int tamSector)
    {
        //creando sectores del disco
        this.id = -1;//identificador para localizar último elemento.
        this.contenido = new char[tamSector];
        for (int i = 0; i < tamSector; i++)
        {
            contenido[i] = ' ';
        }
    }

    public Sector(int tamSector, char[] contenido)
    {
        this.id = id;
        this.contenido = new char[tamSector];

        for (int i = 0; i < contenido.length; i++)
        {
            this.contenido[i] = contenido[i];
        }

        for (int i = contenido.length; i < tamSector; i++)
        {
            this.contenido[i] = ' ';
        }
    }

    public Sector(int id, int tamSector)
    {
        this.id = id;
        this.contenido = new char[tamSector];

        for (int i = 0; i < tamSector; i++)
        {
            this.contenido[i] = '*';
        }
    }

    public Sector(int id, int tamSector, int numBytes)
    {
        this.id = id;
        this.contenido = new char[tamSector];

        for (int i = 0; i < numBytes; i++)
        {
            this.contenido[i] = '*';
        }
        for (int i = numBytes; i < tamSector; i++)
        {
            this.contenido[i] = ' ';
        }

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public char[] getContenido()
    {
        return contenido;
    }

    public void setContenido(char[] contenido)
    {
        this.contenido = contenido;
    }

}
