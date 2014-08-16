package locadora_carros;

/**
 * Classe para cadastro de carros da categoria Compacto.
 */

public class CarroCompacto extends Carro{

	public CarroCompacto(String nome, String marca, double preço,
			double valorAluguel, boolean alugado) {
		super(nome, marca, preço, valorAluguel, alugado);
		super.setCategoria("Compacto");
	}
	
	
	
}
