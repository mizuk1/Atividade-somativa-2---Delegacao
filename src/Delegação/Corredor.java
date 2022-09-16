package Delegação;

import java.io.Serializable;

public class Corredor extends Atleta implements Serializable{
	private static final long serialVersionUID = 1L;
	private double velocidade;
	private double velocidadeMaxima;
	
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
		String retorno = "";
		retorno += "Nome: "+this.nome+"\n";
		retorno += "Numero: "+this.numero+"\n";
		retorno += "Atividade: "+atividade()+"\n";
		retorno += "Velocidade: "+velocidade+"\n";
		retorno += "Velocidade Maxima: "+velocidadeMaxima+"\n";
		return retorno;
	}
}
