package sistemaOperativo;

import java.util.Scanner;

/**
 * La clase implementa métodos para la lectura de datos desde teclado,
 * principalmente numeros enteros, flotantes, y cadenas. Dichos métodos se
 * encargan de la interacción directa con el usuario por medio de impresiones
 * por pantalla. Además, valida las entradas proporcionadas.
 *
 * @author Matías Palominos
 */
public class Lector
{

    private Scanner lector;

    /**
     * Constructor para objetos de la clase Lector
     */
    public Lector()
    {
        lector = new Scanner(System.in);
    }

    /**
     * Este método pide el ingreso de un texto por pantalla y lo recibe desde el
     * teclado.
     *
     * @param mensaje es el texto que se debe imprimir para pedir un el dato.
     * @return linea que es el texto ingresado por el usuario.
     */
    public String leerLinea(String mensaje)
    {
        System.out.printf(mensaje + " ");
        String linea;

        while (true)
        {
            try
            {
                linea = lector.nextLine();
                return linea;
            } catch (Exception e)
            {
                System.out.println("Ha ingresado caracteres inválidos, vuelva a intentarlo");
            }
        }
    }
    
    
}
