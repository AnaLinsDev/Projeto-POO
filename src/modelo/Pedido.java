package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;



public class Pedido {
	private int id;
	private LocalDateTime datahora;
	private double valortotal;
	private String entregador;
	private boolean pago;
	private ArrayList<Produto> produtos;
	private Cliente cliente;

	public Pedido(int id, LocalDateTime datahora, double valortotal, String entregador, boolean pago, Cliente cliente) {
		this.id = id;
		this.datahora = datahora;
		this.valortotal = valortotal;
		this.entregador = entregador;
		this.pago = pago;
		this.cliente = cliente;
		this.produtos = produtos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDatahora() {
		return datahora;
	}

	public void setDatahora(LocalDateTime datahora) {
		this.datahora = datahora;
	}

	public double getValortotal() {
		return valortotal;
	}

	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}

	public String getEntregador() {
		return entregador;
	}

	public void setEntregador(String entregador) {
		this.entregador = entregador;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ArrayList<Produto> getProduto() {
		return produtos;
	}

	public void setProduto(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void addProduto(Produto p ) {
		this.getProduto().add(p);

	}
	public void remProduto(Produto p ) {
		this.getProduto().remove(p);

	}


	

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", datahora=" + datahora + ", valortotal=" + valortotal + ", entregador="
				+ entregador + ", pago=" + pago + ", produtos=" + produtos + ", cliente=" + cliente + "]";
	}
	
	
}
