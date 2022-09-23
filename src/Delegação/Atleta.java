package Delegação;

import java.io.Serializable;

public abstract class Atleta implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nome;
	private int numero;
	
	public Atleta(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
	}
	
	// Getters e setters possíveis, porém não utilizados no programa
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public abstract String atividade();
	
	public String toString() {
		String retorno = "";
		retorno += "Nome: "+this.nome+"\n";
		retorno += "Numero: "+this.numero+"\n";
		retorno += "Atividade: "+atividade()+"\n";
		return retorno;
	}
}
