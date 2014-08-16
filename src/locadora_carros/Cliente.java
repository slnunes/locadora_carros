package locadora_carros;

/** Classe para cadastro dos clientes.
 * 
 * @author Samuel Leão Nunes
 * 
 * @version 1.10
 */


import java.io.Serializable;

public class Cliente implements Serializable{

	String nome;
	String email;
	String endereco;
	int cpf, telefone, codCliente;
	
	
	public Cliente(String nome, String email, int cpf, int telefone) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
	}
	
	/** 
     * métodos gets e sets.
     */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	public void setCodCliente(int codCliente) {   
	    this.codCliente = codCliente;  
	}
}