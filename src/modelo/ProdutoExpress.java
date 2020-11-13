package modelo;

public class PedidoExpress extends Pedido{
	private double taxaentrega;

	public PedidoExpress(int id, LocalDateTime datahora, double valortotal, String entregador, boolean pago,
			Cliente cliente, double taxaentrega) {
		super(id, datahora, valortotal, entregador, pago, cliente);
		this.taxaentrega = taxaentrega;
	}

	public double getTaxaentrega() {
		return taxaentrega;
	}

	public void setTaxaentrega(double taxaentrega) {
		this.taxaentrega = taxaentrega;
	}

	@Override
	public String toString() {
		return "ProdutoExpress [taxaentrega=" + taxaentrega + "]";
	}
}
