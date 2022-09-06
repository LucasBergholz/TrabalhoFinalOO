package controlador;

import java.util.ArrayList;

import javax.swing.JTable;

import modelo.Estadios;
import modelo.Jogador;
import modelo.Partida;
import modelo.Tecnico;
import modelo.Time;

/**
 * Classe responsavel por reunir metodos utilizados na tela de artilharia.
 * @author Lucas Bergholz
 * @author Guilherme Rodrigues
 * @see Time
 * @see Partida
 * @see Estadios
 */
public class ControleArtilharia {
	
	private static Listas brasileirao = new Listas();
	
	/**
	 * Metodo que puxa os dados do banco de dados e imprime na JTable de artilharia
	 * @see Time
	 * @see Jogador
	 * @see Estadios
	 */
	public static void inicializarTabela(ArrayList<Time> times, JTable tabelaArtilharia) {
		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
		times.clear();
		jogadores.clear();
		
		//Tirando os dados do banco de dados
		for(int i = 0; i < 20; i++) {
			times.add(brasileirao.getTimes().get(i));		
		}
		
		//Tirando os jogadores dos times e colocando na arraylist interna da funcao
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < times.get(i).getJogadoresSize(); j++) {
				if(times.get(i).getJogadores(j) != null) {
					jogadores.add(times.get(i).getJogadores(j));
				}
			}
		}
		
		//Elencando todos os jogadores da arraylist por numero de gols
		int n = jogadores.size(); //n = total de jogadores no sistema
		for(int i = 0; i < n-1; i++) {
			//Arraylist auxiliar para ajudar a fazer a elencagem dos jogadores
			ArrayList<Jogador> auxiliar = new ArrayList<Jogador>();
			for(int j = 0; j < n-1; j++) {
				auxiliar.clear();
				//Se o jogador da posicao j tiver menos gols que o proximo, mudar a posicao de ambos
				if(jogadores.get(j).getTotalGols() < jogadores.get(j+1).getTotalGols()) {
					auxiliar.add(jogadores.get(j));
					jogadores.set(j, jogadores.get(j+1));
					jogadores.set(j+1, auxiliar.get(0));
				}	
				
			}	
		}
		
		//Passando os valores para a tabela
		for(int k = 1; k < 21; k++) {
			if(jogadores.get(k) != null) {
				tabelaArtilharia.setValueAt(k + " - " + jogadores.get(k-1).getNome(),k,0);
				tabelaArtilharia.setValueAt(jogadores.get(k-1).getTime(),k,1);
				tabelaArtilharia.setValueAt(jogadores.get(k-1).getTotalGols(),k,2);
			}
		}
			
		
	 }
}
