package Delegação;

import java.io.Serializable;

public class Nadador extends Atleta implements Serializable{
	private static final long serialVersionUID = 1L;
	private String estilo;
	private double velocidadeMaxima;

	// Getters e setters possíveis, porém não utilizados no programa
	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public double getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public void setVelocidadeMaxima(double velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}

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
