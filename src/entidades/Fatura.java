package entidades;

public class Fatura {
	
	private Double pagamento;
	private Double taxa;
	
	public Fatura() {
		
	}

	public Fatura(Double pagamento, Double taxa) {
		this.pagamento = pagamento;
		this.taxa = taxa;
	}

	public Double getPagamento() {
		return pagamento;
	}

	public void setPagamento(Double pagamento) {
		this.pagamento = pagamento;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}
	
	public Double getTotalPagamento() {
		return getPagamento() + getTaxa();
	}

}
