package locadora_carros;

/**
 * Classe para exceção de lista cheia 
 */

public class ExcecaoDeListaCheia extends Exception
	{
	private String msg = "A Lista está cheia.";
	
	public String printMensagem()
	{
		return msg;
	}
}