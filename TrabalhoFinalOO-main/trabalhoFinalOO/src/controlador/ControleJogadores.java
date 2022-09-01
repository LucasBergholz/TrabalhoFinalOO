package controlador;

import java.awt.Font;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

import bancoDeDados.Listas;
import visao.JogadoresCriar;

public class ControleJogadores {
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
				frame.getTimeJog().getJogadores(index).setIdade((Integer) spnIdade.getValue());
				
			}
		}
	}
	
	public static void verJogadores(JList<String> listaDeTimes, JScrollPane painelScroll) {
		for(int i = 0; i < 20; i++) {
			if(listaDeTimes.getSelectedValue() == Listas.times.get(i).getNome()) {
				JTable tabelaJogadores = new JTable(Listas.times.get(i).getJogadoresSize()+1, 3);
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
				
				for(int j = 0; j < Listas.times.get(i).getJogadoresSize(); j++) {
					tabelaJogadores.setValueAt(Listas.times.get(i).getJogadores(j).getNome(), j+1, 0);
					tabelaJogadores.setValueAt(Listas.times.get(i).getJogadores(j).getPosicao(), j+1, 1);
					tabelaJogadores.setValueAt(Listas.times.get(i).getJogadores(j).getTotalGols(), j+1, 2);
				}
				painelScroll.setViewportView(tabelaJogadores);
			}
			
		}
	}
}
