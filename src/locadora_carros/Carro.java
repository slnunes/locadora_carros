package locadora_carros;

/** Classe para cadastro dos carros.
 * @author Samuel Leão Nunes
 * @version 1.10
 */

public abstract class Carro	
{  
    private String nome;
    private String marca;
    private String categoria; 
    private double preço, valorAluguel;
    private int codCarro;  
    private boolean alugado = false;
    private String dataAlugada = "00/00/00";

	public Carro(String nome,String marca,double preço, double valorAluguel, boolean alugado){
	    this.nome = nome;  
	    this.marca = marca;  
	    this.preço = preço;
	    this.valorAluguel = valorAluguel;
	    this.alugado = alugado;
	}
    
    /** 
     * métodos gets e sets.
     */
    public void setValorAluguel(double valor)
    {
    	this.valorAluguel = valor;
    }
    
    public double getValorAluguel()
    {
    	return valorAluguel;
    }
       
	public boolean isAlugado() {  
	    return alugado;  
	}  
	
	public void setAlugado(boolean alugado) {  
	    this.alugado = alugado;
	}  
		
	public String getNome() {  
	    return nome;  
	}  
	public void setNome(String nome) {  
	    this.nome = nome;  
	}  
	
	public String getCategoria() {
		return categoria;
	}
	
	public String getDataAlugada()
	{
		return dataAlugada;
	}
	
	public void setDataAlugada(String data)
	{
		this.dataAlugada = data;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getMarca() {  
	    return marca;  
	}  
	
	public void setMarca(String marca) {  
	    this.marca = marca;  
	}  
	public double getPreço() {  
	    return preço;  
	}  
	
	public void setPreço(double preço) {    
	    this.preço = preço;  
	}  
	  
	public int getCodCarro() {  
	    return codCarro;  
	}  
	
	public void setCodCarro(int codCarro) {   
	    this.codCarro = codCarro;  
	}
}