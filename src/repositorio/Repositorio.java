package repositorio;
import java.time.LocalDateTime;
import java.util.ArrayList;

import modelo.Produto;
import modelo.Pedido;
import modelo.Cliente;

public class Repositorio {
	private ArrayList<Produto> produtos = new ArrayList<>();
	private ArrayList<Produto> produtosByText = new ArrayList<>();
	private ArrayList<Pedido> pedidos = new ArrayList<>();
	private ArrayList<Pedido> pedidosByTipo = new ArrayList<>();
	private ArrayList<Cliente> clientes = new ArrayList<>();
	
	private static int idproduto = 0;
	private static int idpedido  = 0;
	
	public void adicionar(Produto p){
		produtos.add(p);
	}
	public void remover(Produto p){
		produtos.remove(p);
	}
	public void adicionar(Cliente c){
		clientes.add(c);
	}
	public void remover(Cliente c){
		clientes.remove(c);
	}
	public void adicionar(Pedido p){
		pedidos.add(p);
	}
	public void remover(Pedido p){
		pedidos.remove(p);
	}
	public ArrayList<Produto> getProdutos(String text){
		produtosByText.clear();
		for (Produto p : produtos) {
			if (p.getNome().contains(text)) {
				produtosByText.add(p);
			}
		}
		return produtosByText;
	}
	
	public ArrayList<Cliente> getCliente(){
		return clientes;
	}
	
	public ArrayList<Pedido> getPedido(){
		return pedidos;
	}
	public ArrayList<Pedido> getPedido(String tel, int tipo){
		pedidosByTipo.clear();
		for (Pedido p : pedidos) {
			if (p.getCliente().getTelefone() == tel) {
				if (tipo == 1 && p.isPago() == true) {
					pedidosByTipo.add(p);
				}
				else if (tipo == 2 && p.isPago() == false) {
					pedidosByTipo.add(p);
				}
				else if(tipo == 3) {
					return pedidos;
				}
			}
		}
		return pedidosByTipo;
	}
	public Produto makeProduto(String nome, double preco){
		idproduto++;
		Produto produto;
		produto = new Produto(idproduto, nome, preco);
		adicionar(produto);
		return produto;
	}
	
	public Cliente makeCliente(String telefone, String nome, String endereco){
		Cliente cliente;
		cliente = new Cliente(telefone, nome, endereco);
		adicionar(cliente);
		return cliente;
	}
	
	public Pedido makePedido(String telefone){
		idpedido++;
		Cliente cli = null;
		boolean isInClientes = false;
		Pedido pedido;
		for(Cliente c : clientes) {
			if(c.getTelefone() == telefone) {
				cli = c;
				isInClientes = true;
			}
		}
		if (isInClientes) {
			pedido = new Pedido(idpedido,  null,0, null , false, cli );
			adicionar(pedido);
			return pedido;
		}
		return null;
	}
	
	public void addProdPed(int idpedido, int idproduto){
		for(Pedido pe : pedidos) {
			if(pe.getId() == idpedido) {
				for(Produto pr : produtos) {
					if(pr.getId() == idproduto) {
						pe.addProduto(pr);
					}
				}
			}
		}
	}
	public void remProdPed(int idpedido, int idproduto){
		for(Pedido pe : pedidos) {
			if(pe.getId() == idpedido) {
				for(Produto pr : produtos) {
					if(pr.getId() == idproduto) {
						pe.remProduto(pr);
					}
				}
			}
		}
	}
	public Pedido getPedido(int idpedido){
		for(Pedido p : pedidos) {
			if(p.getId() == idpedido) {
				return p;
			}
		}
		return null;
	}
	public void pagarPed(int idpedido, String nomeentregador){
		for(Pedido p : pedidos) {
			if(p.getId() == idpedido) {
				p.setEntregador(nomeentregador);
				p.setPago(true);
			}
		}
	}
	
	public void cancPed(int idpedido){
		for(Pedido p : pedidos) {
			if(p.getId() == idpedido) {
				pedidos.remove(p);
			}
		}
	  }
	public double consArrecad(LocalDateTime dia){
		double total = 0;
		for(Pedido p : pedidos) {
			if(p.isPago() == true & p.getDatahora() == dia) {
				total = total + p.getValortotal();
			}
		}
		return total;
	  }
	public  ArrayList<Produto> consProdTop(){
		ArrayList<Produto> topFim = new ArrayList<>();
		ArrayList<Produto> res = new ArrayList<>();
		for(Pedido pe : pedidos) {
			for(Produto pr : pe.getProduto()) {	
				topFim.add(pr);
			}
		}
		for (Produto p : topFim) {
			//TODO
		}
		return res;
		  
	  }
	 

}
