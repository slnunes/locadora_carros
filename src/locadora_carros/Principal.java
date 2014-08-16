package locadora_carros;

/** Classe para chamada do menu do sistema.
 * @author Samuel Leão Nunes
 * @version 1.10 
 */

public class Principal
{
    public static void main(String[] args) throws ExcecaoDeListaCheia
    {
        (new InterfaceDeUsuario()).mostrarMenuPrincipal() ;
    }
}

