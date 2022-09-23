package Delegação;

import java.io.Serializable;

public class Saltador extends Atleta implements Serializable{
	private static final long serialVersionUID = 1L;
	private double altura;
	private double alturaPulo;

	// Getters e setters possíveis, porém não utilizados no programa
	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getAlturaPulo() {
		return alturaPulo;
	}

	public void setAlturaPulo(double alturaPulo) {
		this.alturaPulo = alturaPulo;
	}

	public Saltador(String nome, int numero, double altura, double alturaPulo) {
		super(nome, numero);
		this.altura = altura;
		this.alturaPulo = alturaPulo;
	}
	
	@Override
	public String atividade() {
		return "Salta";
	}
	
	@Override
	public String toString() {
		String retorno = super.toString();
		retorno += "Altura: "+altura+"\n";
		retorno += "Altura do pulo: "+alturaPulo+"\n";
		return retorno;
	}	
}
