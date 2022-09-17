package Delegação;

import java.io.Serializable;

public class Nadador extends Atleta implements Serializable{
	private static final long serialVersionUID = 1L;
	private String estilo;
	private double velocidadeMaxima;

	public Nadador(String nome, int numero, String estilo, double velocidadeMaxima) {
		super(nome, numero);
		this.estilo = estilo;
		this.velocidadeMaxima = velocidadeMaxima;
	}

	@Override
	public String atividade() {
		return "Nada";
	}

	@Override
	public String toString() {
		String retorno = super.toString();
		retorno += "Estilo: "+estilo+"\n";
		retorno += "Velocidade Maxima: "+velocidadeMaxima+"\n";
		return retorno;
	}
}
