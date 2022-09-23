package Delegação;

import java.io.Serializable;

public class Corredor extends Atleta implements Serializable{
	private static final long serialVersionUID = 1L;
	private double velocidade;
	private double velocidadeMaxima;
	
	// Getters e setters possíveis, porém não utilizados no programa
	public double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(double velocidade) {
		this.velocidade = velocidade;
	}

	public double getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public void setVelocidadeMaxima(double velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}

	public Corredor(String nome, int numero, double velocidade, double velocidadeMaxima) {
		super(nome, numero);
		this.velocidade = velocidade;
		this.velocidadeMaxima = velocidadeMaxima;
	}

	@Override
	public String atividade() {
		return "Corre";
	}

	@Override
	public String toString() {
		String retorno = super.toString();
		retorno += "Velocidade: "+velocidade+"\n";
		retorno += "Velocidade Maxima: "+velocidadeMaxima+"\n";
		return retorno;
	}
}
