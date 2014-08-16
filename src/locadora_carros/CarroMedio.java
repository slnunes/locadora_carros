package locadora_carros;

/**
 * Classe para cadastro de carros da categoria Médio.
 */

public class CarroMedio extends Carro{

	public CarroMedio(String nome, String marca, double preço,
			double valorAluguel, boolean alugado) {
		super(nome, marca, preço, valorAluguel, alugado);
		super.setCategoria("Médio");
	}

}
