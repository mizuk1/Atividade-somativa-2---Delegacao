package Delegação;

import java.io.Serializable;

public abstract class Atleta implements Serializable{
	private static final long serialVersionUID = 1L;
	String nome;
	int numero;
	
	public Atleta(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
	}
	
	public abstract String atividade();
	
	public abstract String toString();
}
