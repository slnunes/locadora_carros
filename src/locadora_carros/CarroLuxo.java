package locadora_carros;

/**
 * Classe para cadastro de carros da categoria Luxo.
 */

public class CarroLuxo extends Carro{

	public CarroLuxo(String nome, String marca, double preço,
			double valorAluguel, boolean alugado) {
		super(nome, marca, preço, valorAluguel, alugado);
		super.setCategoria("Luxo");
	}

}
