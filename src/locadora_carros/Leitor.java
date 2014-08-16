package locadora_carros;

/** 
 * Esta classe define objetos capazes de realizar entrada de dados. Os objetos desta classe podem ler
 * dados simples fornecidos pelo usuário via linha de comando. Os dados podem ser do tipo "int"
 * (número inteiro), "double" (número decimal), "String" (uma seqüência qualquer de caracteres) e
 * "Data" (Uma sequência de caracteres do tipo String no formato '10/10/2010').
 */

import java.io.*;

public class Leitor
{
    /** 
     * método para leitura de números inteiros.
     * 
     * @return um número do tipo primitivo int.
     */
    public int leiaInt() 
    {
        int numero = 0;
        String linha ;
        BufferedReader entra = new BufferedReader(new InputStreamReader(System.in)) ;
        try
        {
            linha = entra.readLine() ;
            numero = Integer.valueOf(linha).intValue();            
        }
        catch (Exception erro)
        {
            System.out.println("Erro de entrada de dados");
        }
        return numero ;
    }
   
    /** 
     * método para leitura de uma String respeitando o formato de data definido '00/00/0000'.
     * 
     * @return uma seqüência de caracteres do tipo String se estiver no formato válido ou uma mensagem avisando
     * o usuário que a data digitada está inválida .
     */
    public String leiaDate()
    {
    	String data = leiaString();
    	String DatePattern = "^(?:(31)(\\D)(0?[13578]|1[02])\\2|(29|30)(\\D)(0?[13-9]|1[0-2])\\5|(0?[1-9]|1\\d|2[0-8])(\\D)(0?[1-9]|1[0-2])\\8)((?:1[6-9]|[2-9]\\d)?\\d{2})$|^(29)(\\D)(0?2)\\12((?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:16|[2468][048]|[3579][26])00)$";
    	if ( data.matches(DatePattern) )
    	{  
    	    return data;  
    	}
    	else
    	{  
    	    return "Data inválida!";  
    	}   
    }

    /**
     * método para leitura de números decimais.
     * 
     * @return um número do tipo primitivo double.
     */
    public double leiaDouble() 
    {
        double numero = 0 ;
        String linha ;
        BufferedReader entra = new BufferedReader(new InputStreamReader(System.in)) ;
        try
        {
            linha = entra.readLine() ;
            numero = Double.valueOf(linha).doubleValue();            
        }
        catch (Exception erro)
        {
            System.out.println("Erro de entrada de dados");
        }
        return numero ;
    }
    
    /** 
     * método para leitura de uma seqüência de caracteres.
     * 
     * @return uma seqüência de caracteres do tipo String.
     */
    public String leiaString() 
    {
        String linha = "";
        BufferedReader entra = new BufferedReader(new InputStreamReader(System.in)) ;
        try
        {
            linha = entra.readLine() ;
        }
        catch (Exception erro)
        {
            System.out.println("Erro de entrada de dados");
        }
        return linha ;
    }
}