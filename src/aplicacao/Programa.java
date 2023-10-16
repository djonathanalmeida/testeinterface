package aplicacao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entidades.Locacao;
import entidades.Veiculo;
import servicos.ImpostoBrasil;
import servicos.ServicoLocacao;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		System.out.println("Informe os dados da locação");
		System.out.print("Modelo do carro: ");
		String modeloCarro = sc.nextLine();
		System.out.print("Retirada (dd/MM/yyyy HH:mm): ");
		LocalDateTime inicio = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.print("Retorno (dd/MM/yyyy HH:mm): ");
		LocalDateTime fim = LocalDateTime.parse(sc.nextLine(), fmt);
		
		Locacao l = new Locacao(inicio, fim, new Veiculo(modeloCarro));
		
		System.out.println("Entre com o preço por hora");
		double precoPorHora = sc.nextDouble();
		System.out.println("Entre com o preço por dia");
		double precoPorDia = sc.nextDouble();
		
		ServicoLocacao servicoLocacao = new ServicoLocacao(precoPorHora, precoPorDia, new ImpostoBrasil());
		
		servicoLocacao.processarFatura(l);
		
		System.out.println("FATURA=");
		System.out.println("Pagamento básico: " + String.format("%.2f", l.getFatura().getPagamento()));
		System.out.println("Imposto: " + String.format("%.2f", l.getFatura().getTaxa()));
		System.out.println("Pagamento total: " + String.format("%.2f", l.getFatura().getTotalPagamento()));
		
		sc.close();

	}

}
