package controlador;

import java.awt.Font;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

import bancoDeDados.Listas;
import visao.JogadoresCriar;
import visao.JogadoresEditar;

public class ControleJogadores {
	
	private static Listas brasileirao = new Listas();
	
	
	/**
	 * Metodo que realiza a ação de Criar o Jogador com os dados inseridos e instancia-lo ao banco de Dados
	 * @param listagemTime JList
	 * @param txtNome JTextFiled
	 * @param brasileirao Listas
	 * @param frame JogadoresCriar
	 * @param spnIdade Jspinner
	 */
	public static void criandoJogador(JList listagemTime, JTextField txtNome, Listas brasileirao, JogadoresCriar frame, JSpinner spnIdade) {
		//Atribuindo o nome do time a uma variavel auxiliar
		String nomeTime = (String) listagemTime.getSelectedValue();	
		for(int i =0; i<20; i++) {
			if(brasileirao.getTimes().get(i).getNome().equals(nomeTime)) {
				frame.setTimeJog(brasileirao.getTimes().get(i));
				frame.getTimeJog().addJogador(txtNome.getText().toUpperCase(), frame.getPosicaoJogador());
				
				//Pegando a posição do Jogador recem Criado no vetor
				int index = frame.getTimeJog().getJogadoresSize() - 1;
				
				//Colocando adicionando a Idade escolhida no Jogador 
				frame.getTimeJog().getJogadores(index).setIdade((int) Math.round((double)spnIdade.getValue()));
				
			}
		}
	}
	
	/**
	 * Metodo que realiza a ação de resgatar os dados de Todos os jogadores do Banco de Dados e mostralos na Tela
	 * @param listaDeTimes ArrayList de Strings
	 * @param painelScroll JScrollPane
	 */
	public static void verJogadores(JList<String> listaDeTimes, JScrollPane painelScroll) {
		for(int i = 0; i < 20; i++) {
			if(listaDeTimes.getSelectedValue() == brasileirao.getTimes().get(i).getNome()) {
				JTable tabelaJogadores = new JTable(brasileirao.getTimes().get(i).getJogadoresSize()+1, 3);
				tabelaJogadores.setBounds(40, 100, 550, 200);
				tabelaJogadores.getColumnModel().getColumn(0).setPreferredWidth(300);
				tabelaJogadores.getColumnModel().getColumn(1).setPreferredWidth(180);
				tabelaJogadores.setRowHeight(25);
				tabelaJogadores.setValueAt("NOME", 0, 0);
				tabelaJogadores.setValueAt("POSICAO", 0, 1);
				tabelaJogadores.setValueAt("GOLS", 0, 2);
				tabelaJogadores.setFont(new Font("Arial", Font.PLAIN, 20));
				tabelaJogadores.setTableHeader(null);
				tabelaJogadores.setEnabled(false);
				
				for(int j = 0; j < brasileirao.getTimes().get(i).getJogadoresSize(); j++) {
					tabelaJogadores.setValueAt(brasileirao.getTimes().get(i).getJogadores(j).getNome(), j+1, 0);
					tabelaJogadores.setValueAt(brasileirao.getTimes().get(i).getJogadores(j).getPosicao(), j+1, 1);
					tabelaJogadores.setValueAt(brasileirao.getTimes().get(i).getJogadores(j).getTotalGols(), j+1, 2);
				}
				painelScroll.setViewportView(tabelaJogadores);
			}
			
		}
	}
	/**
	 * Metodo que realiza a ação de Criar o Jogador com os dados inseridos e instancia-lo ao banco de Dados
	 * @param listagemTime JList
	 * @param txtNome JTextFiled
	 * @param brasileirao Listas
	 * @param frame JogadoresEditar
	 * @param spnIdade Jspinner
	 */
	public static void atualizandoJogador(JList listagemTime, JTextField txtNome, Listas brasileirao, JogadoresEditar frame, JSpinner spnIdade) {
		
		//Atribuindo o nome do time a uma variavel auxiliar
		String nomeTime = (String) listagemTime.getSelectedValue();	
		for(int i =0; i<20; i++) {
			if(brasileirao.getTimes().get(i).getNome().equals(nomeTime)) {
				frame.setTimeJog(brasileirao.getTimes().get(i));
				frame.getTimeJog().addJogador(txtNome.getText().toUpperCase(), frame.getPosicaoJogador());
				
				//Pegando a posição do Jogador recem Criado no vetor
				int index = frame.getTimeJog().getJogadoresSize() - 1;
				
				//Colocando adicionando a Idade escolhida no Jogador 
				frame.getTimeJog().getJogadores(index).setIdade((int) Math.round((double)spnIdade.getValue()));
				
			}
		}
	}
}

