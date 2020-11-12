package fachada;
import java.time.LocalDateTime;
import java.util.ArrayList;

import modelo.Produto;
import modelo.Pedido;
import modelo.Cliente;
import repositorio.Repositorio;

public class Fachada {
	private static Repositorio repositorio = new Repositorio();
	
	  public static ArrayList<Produto> listarProdutos(String text){
		  return repositorio.getProdutos(text);
	  }
	  public static ArrayList<Cliente> listarClientes(){
 		  return repositorio.getCliente();
	  }
	  public static ArrayList<Pedido> listarPedidos(){
		  return repositorio.getPedido();
	  }
	
	  public static ArrayList<Pedido> listarPedidos(String tel, int tipo){
		  return repositorio.getPedido(tel, tipo);
	  }
	  
	  public static Produto cadastrarProduto(String nome, double preco){
		  return repositorio.makeProduto(nome, preco);
	  }
	  
	  public static Cliente cadastrarCliente(String telefone, String nome, String endereco){
		  return repositorio.makeCliente(telefone, nome, endereco);
	  }
	  
	  public static Pedido criarPedido(String telefone){
		  return repositorio.makePedido(telefone);
	  }
	  
	  public static void adicionarProdutoPedido(int idpedido, int idproduto){
		  repositorio.addProdPed( idpedido,  idproduto);
	  }
	  
	  public static void removerProdutoPedido(int idpedido, int idproduto){
		  repositorio.remProdPed( idpedido,  idproduto);
	  }
	  
	  public static Pedido consultarPedido(int idpedido){
		  return repositorio.getPedido( idpedido);
	  }
	  
	  public static void pagarPedido(int idpedido, String nomeentregador){
		  repositorio.pagarPed(idpedido, nomeentregador);
	  }
	  
	  public static void cancelarPedido(int idpedido){
		  repositorio.cancPed(idpedido);
	  }
	  
	  public static double consultarArrecadacao(LocalDateTime dia){
		  return repositorio.consArrecad(dia);
	  }

/*	  
	  public static ArrayList<Produto> consultarProdutoTop(){
		  return repositorio.consProdTop();
	  }
*/
}
