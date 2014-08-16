package locadora_carros;

/** Classe para listagem dos clientes.
 * 
 * @author Samuel Leão Nunes
 * 
 * @version 1.10
 */

import java.io.Serializable;

public class ListaDeClientes implements Serializable{
	private Cliente[] clientes;
	private int qtdClientes = 0, capacidade=0;
	
	public ListaDeClientes(int capacidade) 
	{
		this.clientes = new Cliente[capacidade];
		this.capacidade = capacidade;
	}

	 /** 
     * método para inserir novos clientes na lista.
     */
	public void inserirCliente(Cliente oCliente) throws ExcecaoDeListaCheia
	{
		if (qtdClientes == capacidade)
		{
			throw new ExcecaoDeListaCheia();
		}
		oCliente.setCodCliente(qtdClientes);
		clientes[qtdClientes] = oCliente;
		qtdClientes++;
	}
	
	/** 
     * Métodos gets e sets.
     */
	public Cliente get(int identificador)
	{
		return clientes[identificador];
	}

	public Cliente[] getClientes()
	{
		return clientes;
	}
	
	public int getQtdClientes()
	{
		return qtdClientes;
	}
	
}