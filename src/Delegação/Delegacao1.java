package Delegação;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Delegacao1 {
	private ArrayList<Atleta> atletas;

	public Delegacao1() {
		this.atletas = new ArrayList<Atleta>();
	}

	public void adicionaAtleta(Atleta atleta) {
		this.atletas.add(atleta);
	}

	public void listarAtletas() {
		for(Atleta atleta : atletas) {
			System.out.println(atleta.toString());
		}
		System.out.println("Total = "+this.atletas.size()+" atletas listados com sucesso!\n");
	}
	
	public void excluirAtleta(Atleta atleta) {
		if (this.atletas.contains(atleta)) {
			this.atletas.remove(atleta);
			System.out.println("Atleta " + atleta.toString() + "Excluido com sucesso!\n");
		}
		else
			System.out.println("Atleta inexistente!\n");
	}

	public void excluirAtletas() {
		atletas.clear();
		System.out.println("Atletas excluidos com sucesso!\n");
	}
	
	public void gravarAtletas()  {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream (new FileOutputStream("atletas.dat"));
			for(Atleta atleta : atletas) {
				outputStream.writeObject(atleta);
			}
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			try {
				if (outputStream != null ) {
					outputStream.flush();
					outputStream.close();
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	public void recuperarAtletas() {
		ObjectInputStream inputStream = null;
		try {
			inputStream	= new ObjectInputStream (new FileInputStream ("atletas.dat"));
			Object obj = null;
			while((obj = inputStream.readObject ()) != null) {
				if (obj instanceof Corredor)  
					this.atletas.add((Corredor)obj);
				else if (obj instanceof Nadador)  
					this.atletas.add((Nadador)obj);
				else if (obj instanceof Saltador)
					this.atletas.add((Saltador)obj);
			}
		}catch (EOFException ex) {     // when EOF is reached
			System.out.println ("End of file reached");
		}catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			try {
				if (inputStream != null ) {
					inputStream.close();
					System.out.println("Atletas recuperados com sucesso!\n");
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}


	public static void main(String[] args) {
		Delegacao1 delegacao  = new Delegacao1();
		
		Corredor thiago = new Corredor("Thiago", 16, 15.7, 20.1);
		Nadador luiz = new Nadador("Luiz Fellipe", 20, "Livre", 10.5);
		Saltador igor = new Saltador("Igor", 39, 1.75, 2.3);
		Saltador fulano = new Saltador("Fulano", 99, 1.8, 3.1);
		
		delegacao.adicionaAtleta(thiago);
		delegacao.adicionaAtleta(luiz);
		delegacao.adicionaAtleta(igor);
		delegacao.adicionaAtleta(fulano);
		delegacao.listarAtletas();
		delegacao.gravarAtletas();
		delegacao.excluirAtleta(fulano);
		delegacao.listarAtletas();
		delegacao.excluirAtletas();
		delegacao.listarAtletas();
		delegacao.recuperarAtletas();
		delegacao.listarAtletas();
	}
}
