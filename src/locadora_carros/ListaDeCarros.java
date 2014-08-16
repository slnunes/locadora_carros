package locadora_carros;

/** Classe para ter a listagem dos carros cadastrados.
 * @author Samuel Leão Nunes
 * @version 1.10
 */

public class ListaDeCarros 
{
	private Carro[] carros;
	private int qtdCarros = 0;	

	public ListaDeCarros(int capacidade) {
		this.carros = new Carro[capacidade];
	}
	
	/** 
     * Método para inserir novos carros na listagem.
     */
	public void inserirCarro(Carro oCarro)	{
		oCarro.setCodCarro(qtdCarros);
		carros[qtdCarros] = oCarro;
		qtdCarros++;
	}
	/** 
     * Métodos gets e sets.
     */
	public Carro get(int indice){
		return carros[indice];
	}
	
	public Carro[] getCarros() {
		return carros;
	}

	public void setCarros(Carro[] carros) {
		this.carros = carros;
	}



}