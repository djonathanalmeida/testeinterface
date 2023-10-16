package servicos;

import java.time.Duration;

import entidades.Fatura;
import entidades.Locacao;

public class ServicoLocacao {

	private Double precoPorHora;
	private Double precoPorDia;
	
	private Imposto taxa;

	public ServicoLocacao(Double precoPorHora, Double precoPorDia, Imposto taxa) {
		this.precoPorHora = precoPorHora;
		this.precoPorDia = precoPorDia;
		this.taxa = taxa;
	}
	
	public void processarFatura(Locacao locacao) {
		
		double minutos = Duration.between(locacao.getInicio(), locacao.getFim()).toMinutes();
		double horas = minutos / 60.0;
		
		double pagamento;
		
		if (horas <= 12.0) {
			pagamento = precoPorHora * Math.ceil(horas);
		}else {
			pagamento = precoPorDia * Math.ceil(horas / 24.0);
		}
		
		double t = taxa.taxa(pagamento);

		locacao.setFatura(new Fatura(pagamento, t));
		
	}

}
