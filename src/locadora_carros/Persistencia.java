package locadora_carros;

/**  Classe para persistencia de dados.
 * @author Samuel Leão Nunes
 * @version 1.10
 */

import java.io.*;

public class Persistencia
{
    public void escreverLista(ListaDeClientes clientes, String caminho)
    {
        try
        {
            FileOutputStream fluxoSaida = new FileOutputStream(caminho);
            ObjectOutputStream escritor = new ObjectOutputStream(fluxoSaida);
            escritor.writeObject(clientes) ;
            escritor.close() ;      
        }
        catch(IOException e)
        {
        }
    }

    public ListaDeClientes lerLista(String caminho)
    {
        ListaDeClientes resultado = null ;
        try
        {
            FileInputStream fluxoEntrada = new FileInputStream(caminho);
            ObjectInputStream leitor = new ObjectInputStream(fluxoEntrada);
            resultado = (ListaDeClientes) leitor.readObject() ;
            leitor.close() ;      
        }
        catch(IOException e)
        {
        }
        catch(ClassNotFoundException e)
        {
        }
        return resultado ;
    }
}