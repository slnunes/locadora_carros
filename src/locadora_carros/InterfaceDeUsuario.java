package locadora_carros;

/** Classe para interação do usuário com o sistema.
 * @author Samuel Leão Nunes
 * @version 1.10
 */

public class InterfaceDeUsuario
{
	//Caminho de onde será gerado arquivo que persistirá os dados dos clientes cadastrados;
	private String caminho = "/home/slnunes/locadora_carros/arqobjetos.obj"; 

	private int qtdCarros;
	private Persistencia persiste = new Persistencia();
    private ListaDeCarros listaCarros = new ListaDeCarros(50);
    private ListaDeClientes listaClientes;
    private int i, qtdCat = 0;
    private Carro[] listaDosCarros = listaCarros.getCarros();

    /** 
     * método para mostrar na tela menu principal para escolha das opções do sistema.
     * @throws ExcecaoDeListaCheia para tratamento de lista cheia.
     */
    void mostrarMenuPrincipal() throws ExcecaoDeListaCheia
    {
    	listaClientes = persiste.lerLista(caminho) ;
        if(listaClientes == null)
        {
            listaClientes = new ListaDeClientes(50);
        }
        
        Leitor entrada = new Leitor() ;
        PrintOpcoes();      
        int opcao = entrada.leiaInt();

        while(opcao != 0)
        {
            if(opcao == 1)
            {
                System.out.println("Informe o nome do modelo do carro: ");
                String nome = entrada.leiaString();
                System.out.println("Informe a marca/fabricante do carro: ");
                String marca = entrada.leiaString();
                PrintPedeCategoria("cadastrar");
                String categoria = DefineCategoria(entrada.leiaInt());
                if (ValidaCategoria(categoria) == true)
                {
	                System.out.println("Informe o preço do carro: ");
	                double preco = entrada.leiaDouble();
	                System.out.println("Informe o valor para aluguel do Carro: ");
	                double valorAluguel = entrada.leiaDouble();
	                Carro novoCarro = defineClasseCarro(nome, marca, preco, valorAluguel, false, categoria);
	                listaCarros.inserirCarro(novoCarro);
	                qtdCarros++;
	                System.out.print(" Carro cadastrado com sucesso! \n");
                }
                else
                {
            		System.out.println(categoria);
            	}
            }          
           	if(opcao == 2)
          	{
           			try
           			{
		            	System.out.print("Informe o nome do Cliente: ");
		                String nome = entrada.leiaString();
		                System.out.print("Informe o e-mail do Cliente: ");
		                String email = entrada.leiaString();
		            	System.out.print("Informe o cpf do Cliente: ");
		            	int cpf =entrada.leiaInt();
		            	System.out.print("Informe o telefone do Cliente: ");
		            	int telefone =entrada.leiaInt();
		            	Cliente novoCliente = new Cliente(nome, email, cpf, telefone);
		            	listaClientes.inserirCliente(novoCliente);
		            	System.out.print("Cliente cadastrado com sucesso! \n");
           			}
           			catch(ExcecaoDeListaCheia e)
           			{
           				System.out.println("Lista Cheia");
           			}
            }
           	if (opcao == 3)
       		{
				if (qtdCarros>0){
					qtdCat = 0;
					PrintPedeCategoria("listar");
					String categoria = DefineCategoria(entrada.leiaInt());
					if (ValidaCategoria(categoria) == true)
					{
		    			ListarCarros(categoria, "Disponível");
					}
					else 
					{
						System.out.println(categoria);
					}
				}
				else
				{
					System.out.print("Nenhum carro registrado. \n");
				}
			}
            if (opcao == 4)
            {
				System.out.print("Informe a data que deseja listar os carros disponíveis:(ex.:'13/07/14')");
				String data = entrada.leiaDate();
				if (!data.equals("Data inválida!"))
				{
					if (qtdCarros>0){
						qtdCat = 0;
						PrintPedeCategoria("listar");
						String categoria = DefineCategoria(entrada.leiaInt());
						if (ValidaCategoria(categoria) == true)
						{
							System.out.println("Os carros disponíveis para aluguel na data " + data + " são: " );
			    			ListarCarros(categoria, "Disponível");
						}
						else 
						{
							System.out.println(categoria);
						}
					}
					else
					{
						System.out.print("Nenhum carro registrado. \n");
					}
				}
				else
				{
					System.out.println(data);
				}
						
            }
            if (opcao == 5)
            {
            	qtdCat = 0;
            	PrintPedeCategoria("alugar");
            	String categoria = DefineCategoria(entrada.leiaInt());
            	if (ValidaCategoria(categoria) == true)
            	{
            		if (qtdCarros > 0)
            		{
            			System.out.print("\n Carros dessa categoria disponíveis para aluguel: \n");
            			if (ListarCarros(categoria, "Disponível") == 0) 
            			{
	            			System.out.println("Digite o código do carro que deseja alugar: ");
	            			int codCarro = entrada.leiaInt();
	            			if (ValidaCodCarro(codCarro)== true)
	            			{
	                			System.out.print("Digite o nome do cliente: \n");
	                    		String nomeCliente = entrada.leiaString();
	                    		if (ValidarExistenciaNome(nomeCliente) == true)
	                    		{
	                        		System.out.print("Digite a data que deseja alugar: \n");
	                        		String data  = entrada.leiaDate();
	                        		if (data != "Data inválida!")
	                        		{
		                        		Carro carroAlugado = listaCarros.get(codCarro);
		                        		carroAlugado.setAlugado(true);
		                        		carroAlugado.setDataAlugada(data);
		                        		System.out.println(" \n Carro alugado com sucesso!");
	                        		}
	                        		else
	                        		{
	                        			System.out.println(data);
	                        		}
	                    		}
	                    		else
	                    		{
	                    			System.out.println(" Cliente não encontrado!");
	                    		}
	            			}
	            			else
                   			{
                   				System.out.print("\n O código digitado é inválido ou não está vínculado a nenhum carro cadastrado. \n");
                   			}
            			}            				
            		}
            		else
            		{
            			System.out.print("Nenhum carro disponível para aluguel.");
            		}
            	}
            	else
            	{
            		System.out.println(categoria);

            	}
            }
            if (opcao == 6)
            {
            	if (qtdCarros>0){
            		qtdCat = 0;
					PrintPedeCategoria("listar");
					String categoria = DefineCategoria(entrada.leiaInt());
					if (ValidaCategoria(categoria) == true)
					{
		    			ListarCarros(categoria, "Alugados");
					}
					else 
					{
						System.out.println(categoria);
					}
				}
				else
				{
					System.out.print("Nenhum carro registrado. \n");
				}
            }
        	if (opcao == 7)
        	{
				if (listaClientes.getQtdClientes()>0){
					ListarClientes();
				}
				else
				{
					System.out.print("Nenhum Cliente registrado. \n");
				}        		
        	}
            PrintOpcoes();
            
            opcao = entrada.leiaInt();

        }
        persiste.escreverLista(listaClientes, caminho);
        System.out.println("\n Obrigado, volte sempre!");
    }
    
    
    /**
     * Método para criar novo carro de acordo com sua especificação de categoria.
     * @param nome: String que indica o nome do carro
     * @param marca: String que indica a marca fabricante do carro
     * @param preco: double que indica o preço do carro;
     * @param valorAluguel: double que indica o valor para aluguel do carro
     * @param isAlugado: boolean que indica a situação true se está alugado ou false se não estiver alugado
     * @return retorna o Objeto Carro criado
     */
    Carro defineClasseCarro(String nome, String marca, double preco, double valorAluguel,
    		boolean isAlugado, String categoria)
    {
        if (categoria.equals("Luxo"))
        {
        	CarroLuxo novoCarro = new CarroLuxo(nome, marca, preco, valorAluguel, false);
        	return novoCarro;
        }
        else
        {
        	if (categoria.equals("Médio"))
        	{
        		CarroMedio novoCarro = new CarroMedio(nome, marca, preco, valorAluguel, false);
        		return novoCarro;
        	}
        	else
        	{
        		CarroCompacto novoCarro = new CarroCompacto(nome, marca, preco, valorAluguel, false);
        		return novoCarro;
        	}
        }
    }


    /** 
     * Método para imprimir na tela as opções do usuário.
     */
    public void PrintOpcoes(){
    	 System.out.println("0.Sair");
         System.out.println("1.Cadastrar carro");
         System.out.println("2.Cadastrar cliente");
         System.out.println("3.Listar carros disponiveis");
         System.out.println("4.Listar carros disponiveis para aluguel em uma determinada data");
         System.out.println("5.Alugar um carro");
         System.out.println("6.Listar carros alugados");
         System.out.println("7.Listar clientes");
    }

    /**
     *  Método para retornar se existe nome do cliente cadastrado ou não.
     *
     *  @return boolean
     */
    public boolean ValidarExistenciaNome(String nome)
    {
    	boolean retorno = false;
    	for (i=0; i<listaClientes.getQtdClientes(); i++)
    	{
    		Cliente clienteAtual = listaClientes.get(i);
    		String nomeCliente = clienteAtual.getNome(); 
    		if (nome.equals(nomeCliente))  
    		{
    			retorno = true;
    		}
    	}
    	return retorno;
    }
    
    /** 
     * Método para retornar se código do carro digitado é válido ou não.
     *   @return boolean
     *   */
    public boolean ValidaCodCarro(int codCarro)
    {
    	
    	for (i=0; i<qtdCarros; i++)
    	{
    		Carro carroAtual = listaDosCarros[i];
    		if (carroAtual.getCodCarro() == codCarro)
    		{
    			return true;
    		}
    	}
    	return false;
    }
    
    /** 
     * Método para retornar se o código da categoria escolhida é válido ou não.
     *   @return boolean
     *   */
    public boolean ValidaCategoria(String categoria){
    	if (categoria != "Luxo" && categoria != "Médio" && categoria!= "Compacto")
    	{
    		return false;
    	}
		else
		{
			return true;
		}
    }
    
    /** 
     * Método para definir a categoria de acordo com o código digitado.
     *   @return String 
     *   */
    public String DefineCategoria(int codCategoria){
    	if (codCategoria == 1){
    		return "Luxo";
    	}
    	else 
    	{
    		if (codCategoria == 2){
    			return "Médio";
    		}
    		else 
    		{
    			if (codCategoria == 3){
    				return "Compacto";
    			}
    			else
    			{
    				return "Código para selecionar categoria inválido!";
    			}
    		}
    	}
    }

    /** 
     * Método para Listar os clientes.
     *
     */
    public void ListarClientes()
    {
    	for (i=0; i<listaClientes.getQtdClientes(); i++)
    	{
    		//Cliente clienteAtual = listaDosClientes[i];
    		Cliente clienteAtual = listaClientes.get(i);
    		System.out.println("\n Nome: " + clienteAtual.getNome());
    	}
    }
    
    /** 
     * Método para listagem dos carros.
     *   */
    public int ListarCarros(String categoria, String situacao)
    {
    	int retorno = 0;
	    for(i=0; i<qtdCarros; i++){
			Carro carroAtual = listaDosCarros[i];
			if (situacao == "Alugados")
			{
				PrintRetornoCarrosAlugados(carroAtual, categoria);
			}
			if (situacao.equals("Disponível"))
			{
				PrintRetorno(carroAtual, categoria);
			}
	   		if ((i+1) == qtdCarros && qtdCat == 0)
	   		{
	   			System.out.print("\n Nenhum carro disponível nessa categoria. \n");
	   			retorno = 1;
	   		}
	    }
		return retorno;
	}
    
    /** 
     * Método para imprimir na tela os carros disponíveis.
     *   
     */
    public void PrintRetorno(Carro carroAtual, String categoria){
    	if (carroAtual.getCategoria() == categoria && carroAtual.isAlugado() == false){
    		PrintCarro(carroAtual);
    	}
	}	
    
    /** 
     * Método para imprimit na tela os carros alugados.
     *   */
    public void PrintRetornoCarrosAlugados(Carro carroAtual, String categoria)
    {
    	if (carroAtual.getCategoria() == categoria && carroAtual.isAlugado() == true)
    	{
    		PrintCarro(carroAtual);
    	}
    }
    
    /** 
     * Método que printa na tela os carros.
     *   */
    public void PrintCarro(Carro carroAtual)
    {
    	System.out.print(" - Código: " + carroAtual.getCodCarro() + " Modelo: " 
				+ carroAtual.getNome() + " Valor do Aluguel: " + carroAtual.getValorAluguel() 
				+ " Preço do Carro: " + carroAtual.getPreço() + " \n");
    	qtdCat++;
    }
   
    /** 
     * Método para printar na tela o pedido para o usuário informar a categoria.
     *   */
    public void PrintPedeCategoria(String acao){
    	System.out.print("Informe a categoria que deseja " + acao 
    		+ ": \n 1 - Luxo \n 2 - Médio \n 3 - Compacto \n");
    }

}