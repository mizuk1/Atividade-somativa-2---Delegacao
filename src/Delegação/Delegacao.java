package Delegação;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Delegacao {
	private ArrayList<Atleta> atletas;
	
	public Delegacao() {
		this.atletas = new ArrayList<Atleta>();
	}
	
	public String[] leValores(String[] dadosIn) {
		String[] dadosOut = new String [dadosIn.length];
        for (int i = 0; i < dadosIn.length; i++)
           dadosOut[i] = JOptionPane.showInputDialog("Entre com "+dadosIn[i]+": ");
        return dadosOut;
	}
	
	public Saltador leSaltador() {
		String[] valores = new String[4];
        String[] nomeVal = {"Nome","Numero","Altura","Altura Pulo"};
        valores = leValores(nomeVal);

        int numero = this.retornaInteiro(valores[1]);
        double altura = this.retornaDouble(valores[2]);
        double alturaPulo = this.retornaDouble(valores[3]);
        Saltador saltador = new Saltador(valores[0],numero,altura,alturaPulo);
        return saltador;
	}
	
	public Corredor leCorredor() {
		String[] valores = new String[4];
        String[] nomeVal = {"Nome","Numero","Velocidade","Velocidade Maxima"};
        valores = leValores(nomeVal);

        int numero = this.retornaInteiro(valores[1]);
        double velocidade = this.retornaDouble(valores[2]);
        double velocidadeMaxima = this.retornaDouble(valores[3]);
        Corredor corredor = new Corredor(valores[0],numero,velocidade,velocidadeMaxima);
        return corredor;
	}
	
	public Nadador leNadador() {
		String[] valores = new String[4];
        String[] nomeVal = {"Nome","Numero","Estilo","Velocidade Maxima"};
        valores = leValores(nomeVal);

        int numero = this.retornaInteiro(valores[1]);
        double velocidadeMaxima = this.retornaDouble(valores[3]);
        Nadador nadador = new Nadador(valores[0],numero,valores[2],velocidadeMaxima);
        return nadador;
	}
	
	private boolean intValido(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public int retornaInteiro(String entrada) {
		while(!this.intValido(entrada)) {
			entrada = JOptionPane.showInputDialog(null,"Valor invalido\nDigite um numero inteiro: ");
		}
		return Integer.parseInt(entrada);
	}
	
	private boolean doubleValido(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public double retornaDouble(String entrada) {
		while(!this.doubleValido(entrada)) {
			entrada = JOptionPane.showInputDialog(null,"Valor invalido\nDigite um numero valido: ");
		}
		return Double.parseDouble(entrada);
	}
	
	public void salvaAtletas(ArrayList<Atleta> atletas) {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream("delegacaoAtividadeSomativa.dados"));
			for(int i=0; i<atletas.size(); i++) {
				outputStream.writeObject(atletas.get(i));
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Impossivel criar arquivo!");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Atleta> recuperaAtletas(){
		ArrayList<Atleta> atletasTemp = new ArrayList<Atleta>();
		ObjectInputStream inputStream = null;

		try {    
			inputStream = new ObjectInputStream(new FileInputStream("delegacaoAtividadeSomativa.dados"));
			Object obj = null;
			while ((obj = inputStream.readObject()) != null) {
				if (obj instanceof Atleta) {
					atletasTemp.add((Atleta) obj);
				}   
			}          
		} catch (EOFException e) {
			System.out.println("Fim de arquivo.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Arquivo com atletas NÃO existe!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
		return atletasTemp;
	}
	
	public void menuDelegacao() {
		String menu = "";
		String entrada;
		int opc1, opc2;
		do {
			menu = "Controle Delegacao\n"+
					"Opções:\n"+ 
					"1. Entrar Atleta\n"+
					"2. Exibir Atletas\n"+
					"3. Limpar Atletas\n"+
					"4. Gravar Atletas\n"+
					"5. Recuperar Atletas\n"+
					"9. Sair";
			entrada = JOptionPane.showInputDialog (null,menu+"\n\n");
			opc1 = this.retornaInteiro(entrada);

			switch (opc1) {
			case 1:// Entrar dados
				menu = "Entrada de Atletas\n"+
						"Opções:\n"+ 
						"1. Saltador\n"+
						"2. Corredor\n"+
						"3. Nadador\n";
				entrada = JOptionPane.showInputDialog (menu + "\n\n");
				opc2 = this.retornaInteiro(entrada);
				switch (opc2){
					case 1: atletas.add((Atleta)leSaltador());
					break;
					case 2: atletas.add((Atleta)leCorredor());
					break;
					case 3: atletas.add((Atleta)leNadador());
					break;
					default:
						JOptionPane.showMessageDialog(null, "Entrada NÃO válida!");
				}
				break;
			case 2: // Exibir dados
				if (atletas.size() == 0) {
					JOptionPane.showMessageDialog(null, "Entre com atletas ...");
					break;
				}
				String dados = "";
				for (int i=0; i < atletas.size(); i++) {
					dados += atletas.get(i).toString() + "---------------\n";
				}
				JOptionPane.showMessageDialog(null,dados);
				break;
			case 3: // Limpar Dados
				if (atletas.size() == 0) {
					JOptionPane.showMessageDialog(null, "Entre com atletas ...");
					break;
				}
				atletas.clear();
				JOptionPane.showMessageDialog(null, "Dados LIMPOS com sucesso!");
				break;
			case 4: // Grava Dados
				if (atletas.size() == 0) {
					JOptionPane.showMessageDialog(null, "Entre com atletas ... ");
					break;
				}
				salvaAtletas(atletas);
				JOptionPane.showMessageDialog(null, "Dados SALVOS com sucesso!");
				break;
			case 5: // Recupera Dados
				atletas = recuperaAtletas();
				if (atletas.size() == 0) {
					JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
					break;
				}
				JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Fim do aplicativo DELEGACAO");
				break;
			}
		} while(opc1 != 9);
	}
	
	public static void main(String[] args) { // Main
		Delegacao delegacao = new Delegacao();
        delegacao.menuDelegacao();
	}
}