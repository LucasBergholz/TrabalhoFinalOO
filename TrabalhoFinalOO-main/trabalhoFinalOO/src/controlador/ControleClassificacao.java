package controlador;

import java.util.ArrayList;

import javax.swing.JTable;

import bancoDeDados.Listas;
import modelo.Estadios;
import modelo.Jogador;
import modelo.Partida;
import modelo.Tecnico;
import modelo.Time;

/**
 * Classe responsavel por reunir os metodos presentes na tela de classificacao.
 * @author Lucas Bergholz
 * @author Guilherme Rodrigues
 * @see Time
 * @see Partida
 * @see Tecnico
 */
public class ControleClassificacao {
	private static Listas brasileirao = new Listas();
	
	/**
	 * Metodo responsavel por instanciar os dados da tabela e imprimi-los na tabela
	 * @see Time
	 * @see Tecnico
	 * @see Estadios
	 */
	public static void inicializarTabela(ArrayList<Time> times, JTable tabelaClassificacao) {
		times.clear();
		//Adicionando os dados a tabela
		
		//Tirando os dados do banco de dados
		for(int i = 0; i < 20; i++) {
			times.add(brasileirao.getTimes().get(i));		
		}
		
		//Fazendo a distribuicao dos times por numero de pontos e posteriormente por saldo de gol
		for(int i = 0; i < 20; i++) {
			//Arraylist para ajudar na elencagem
			ArrayList<Time> auxiliar = new ArrayList<Time>();
			for(int j = 0; j < 19; j++) {
				auxiliar.clear();
				//Se o time j tiver menos pontos que o seguinte time, troca a posicao
				if(times.get(j).getPontosTotais() < times.get(j+1).getPontosTotais()) {
					auxiliar.add(times.get(j));
					times.set(j, times.get(j+1));
					times.set(j+1, auxiliar.get(0));
				} else if((times.get(j).getPontosTotais() == times.get(j+1).getPontosTotais()) &&
						  (times.get(j).getSaldoGols() < times.get(j+1).getSaldoGols())) {
					auxiliar.add(times.get(j));
					times.set(j, times.get(j+1));
					times.set(j+1, auxiliar.get(0));
				}
				
			}
		}
		
		//Passando os valores para a tabela
		for(int i = 1; i < 21; i++) {
			tabelaClassificacao.setValueAt(i + " - " + times.get(i-1).getNome(),i,0);
			tabelaClassificacao.setValueAt(times.get(i-1).getNumJogos(),i,1);
			tabelaClassificacao.setValueAt(times.get(i-1).getPontosTotais(),i,2);
			tabelaClassificacao.setValueAt(times.get(i-1).getVitorias(),i,3);
			tabelaClassificacao.setValueAt(times.get(i-1).getEmpates(),i,4);
			tabelaClassificacao.setValueAt(times.get(i-1).getDerrotas(),i,5);
			tabelaClassificacao.setValueAt(times.get(i-1).getSaldoGols(),i,6);
			tabelaClassificacao.setValueAt(times.get(i-1).getTecnico().getNome(), i, 7);
		}
	 }
}
