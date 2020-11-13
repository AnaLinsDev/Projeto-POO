package aplicacao;

import java.util.ArrayList;

import fachada.Fachada;
import modelo.Produto;
import modelo.Cliente;
import modelo.Pedido;

public class Programa {
		public static void main(String[] args) throws Exception {
			String texto;
			
			Fachada.cadastrarProduto("TV", 2000.0);
			Fachada.cadastrarProduto("BONECA", 3000.0);
			Fachada.cadastrarProduto("CARRO", 2000.0);
			Fachada.cadastrarProduto("BOLA", 3000.0);
			Fachada.cadastrarProduto("CELULAR", 2000.0);
			
			Fachada.cadastrarCliente("982828282", "Ana Julia", "Brasil");
			Fachada.cadastrarCliente("982845454", "Yohanna", "Jap�o");
			Fachada.cadastrarCliente("982867762", "Amanda", "Canad�");
			Fachada.cadastrarCliente("982989898", "Maria", "Noruega");
			Fachada.cadastrarCliente("983434343", "Fatima", "Alemanha"); //express
			
			Fachada.criarPedido("982828282");
			Fachada.criarPedido("982845454");
			Fachada.criarPedido("982867762");
			Fachada.criarPedido("982989898");
			
			// Pagando entregadores para pedido 1 e 2 + cancelando o 3

			Fachada.getPedidoById(1).setEntregador("Joao");
			Fachada.getPedidoById(1).setPago(true);
			Fachada.getPedidoById(2).setEntregador("Jose");
			Fachada.getPedidoById(2).setPago(true);
			Fachada.cancelarPedido(3);
			
			// Listar Produtos
			texto = "\nListagem de "+ Fachada.listarProdutos("").size() + " produtos:\n";
			if (Fachada.listarProdutos("").isEmpty())
				texto += "n�o tem produto cadastrado\n";
			else 	
				for(Produto p: Fachada.listarProdutos("")) 
					texto +=  p + "\n"; 
			
			// Listar Clientes
			texto += "\nListagem "+ Fachada.listarClientes().size() +" de clientes: \n";
			if (Fachada.listarClientes().isEmpty())
				texto += "n�o tem cliente cadastrado\n";
			else 	
				for(Cliente c: Fachada.listarClientes()) 
					texto +=  c + "\n"; 
			
			// Listar Pedidos
			texto += "\nListagem "+ Fachada.listarPedidos().size() +" de pedidos: \n";
			if (Fachada.listarPedidos().isEmpty())
				texto += "n�o tem cliente cadastrado\n";
			else 	
				for(Pedido p: Fachada.listarPedidos()) 
					texto +=  p + "\n"; 
			
			System.out.println(texto);

		}
}
