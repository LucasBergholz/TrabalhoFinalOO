package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.border.Border;

import bancoDeDados.Listas;
import modelo.Partida;
import visao.PartidasCriar;
import visao.PartidasDeletar;
import visao.PartidasEditar;
import visao.PartidasMenu;
import visao.PartidasTabelaRodadasJTables;

public class ControlePartidas {
	static Listas brasileirao = new Listas();
	
	public static void partidasVer(JSpinner spnRodada, JScrollPane caixaVertical, JPanel caixaDentroCaixa, int numPartidas, Listas brasileirao) {
		caixaDentroCaixa.removeAll();
		int rodada =(int) Math.round((double) spnRodada.getValue());
		int posicaoPainel = 0;
		for (int i = 0; i < numPartidas; i++) {
			if(brasileirao.getPartidas().get(i).getRodada() == rodada) {
				Border blackline = BorderFactory.createLineBorder(Color.black, 3, true);
				
				JPanel painelPartidas = new JPanel();
				painelPartidas.setBounds(0, posicaoPainel*110, 570, 100);
				painelPartidas.setBackground(new Color(255,255,255));
				painelPartidas.setBorder(blackline);
				painelPartidas.setLayout(null);
				
				JLabel lblTimeCasa = new JLabel(brasileirao.getPartidas().get(i).getTimeCasa().getNome());
				lblTimeCasa.setBounds(15, 40, 103, 13);
				painelPartidas.add(lblTimeCasa);
				
				JLabel lblTimeFora = new JLabel(brasileirao.getPartidas().get(i).getTimeFora().getNome());
				lblTimeFora.setBounds(445, 40, 103, 13);
				painelPartidas.add(lblTimeFora);
				
				JLabel lblEstadio = new JLabel(brasileirao.getPartidas().get(i).getEstadio().toString());
				lblEstadio.setBounds(205, 70, 150, 13);
				painelPartidas.add(lblEstadio);
				
				JLabel lblX = new JLabel("X");
				lblX.setFont(new Font("Tahoma", Font.PLAIN, 31));
				lblX.setBounds(242, 40, 45, 13);
				painelPartidas.add(lblX);
				
				JLabel lblGolsCasa = new JLabel(Integer.toString(brasileirao.getPartidas().get(i).getGolsCasa()));
				lblGolsCasa.setBounds(175, 40, 45, 13);
				painelPartidas.add(lblGolsCasa);
				
				JLabel lblGolsFora = new JLabel(Integer.toString(brasileirao.getPartidas().get(i).getGolsFora()));
				lblGolsFora.setBounds(328, 40, 45, 13);
				painelPartidas.add(lblGolsFora);
				
				//Adcionando as Listas
				caixaDentroCaixa.add(painelPartidas);
				caixaVertical.setViewportView(caixaDentroCaixa);
				posicaoPainel++;
			}	
			caixaVertical.setVisible(false);
			caixaVertical.setVisible(true);
		}
	}

	public static void partidasDeletar(Integer result, ArrayList<JButton> botoesDeletar, JScrollPane painelPartidasScroll, JPanel painelPartidas, JSpinner spnRodada, PartidasDeletar frame) {
		
		painelPartidas.removeAll();
		botoesDeletar.clear();
		int rodada = (Integer)spnRodada.getValue();
		int contador = 0;
		for(int i = 0; i < brasileirao.getPartidas().size(); i++) {
			if(brasileirao.getPartidas().get(i).getRodada() == rodada) {
				int posicaoLista = i;
				botoesDeletar.add(new JButton(brasileirao.getPartidas().get(i).toString()));
				botoesDeletar.get(contador).setBounds(new Rectangle(0, (contador*70), 400, 60));
				botoesDeletar.get(contador).setFont(new Font("Arial Black", Font.PLAIN, 11));
				painelPartidas.add(botoesDeletar.get(contador));
				botoesDeletar.get(contador).addActionListener( new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {				
						JFrame jFrame = new JFrame();
						int resultado = 0;
						
						if(result == null) {
							resultado = JOptionPane.showConfirmDialog(jFrame, "Voce realmente quer deletar " + brasileirao.getPartidas().get(posicaoLista));	
						}
						
						if (resultado == 0) {
							brasileirao.getPartidas().get(posicaoLista).deletarPartida();
							brasileirao.getPartidas().remove(posicaoLista);
							frame.dispose();
							PartidasTabelaRodadasJTables.main(null);
						}
						else {
							frame.dispose();
							PartidasMenu.main(null);
						}
					}
				});
				contador++;
			}
			
		}
		
		painelPartidasScroll.setVisible(false);
		painelPartidasScroll.setVisible(true);
	}
	
	public static void partidasCriarJogadoresGols(JList listaTime, DefaultListModel listaJogadores, Listas brasileirao) {
		String time = listaTime.getSelectedValue().toString();
		
		for(int i = 0; i < 20; i++) {
			if(brasileirao.getTimes().get(i).getNome() == time) {
				for(int j = 0; j < brasileirao.getTimes().get(i).getJogadoresSize(); j++) {
					if(brasileirao.getTimes().get(i).getJogadores(j) != null) {
						listaJogadores.addElement(brasileirao.getTimes().get(i).getJogadores(j).getNome());
					}
				}
			}
		}
	}
	
	public static void partidasCriar(PartidasCriar frame, ArrayList<JList> listaDeListas1, ArrayList<JList> listaDeListas2) {
		brasileirao.getPartidas().add(new Partida(frame.getTimeCasa(), frame.getTimeFora(), frame.estadio));
		frame.index = brasileirao.getPartidas().size()-1;
		for(int i = 0; i < frame.getGolsCasa(); i ++) {
			for(int j = 0; j < frame.getTimeCasa().getJogadoresSize(); j++) {
				if(frame.getTimeCasa().getJogadores(j) != null && listaDeListas1.get(i).getSelectedValue() == frame.getTimeCasa().getJogadores(j).getNome()) {
					for(int k = 0; k < 20; k++) {
						if(brasileirao.getTimes().get(k) == frame.getTimeCasa()) {
							brasileirao.getTimes().get(k).getJogadores(j).fazerGol();
							brasileirao.getPartidas().get(frame.index).addGolCasa(frame.getTimeCasa().getJogadores(j));
						}
					}
				}
			}		
		}
		for(int i = 0; i < frame.getGolsFora(); i ++) {
			for(int j = 0; j < frame.getTimeFora().getJogadoresSize(); j++) {
				if(frame.getTimeFora().getJogadores(j) != null && listaDeListas2.get(i).getSelectedValue() == frame.getTimeFora().getJogadores(j).getNome()) {
					for(int k = 0; k < 20; k++) {
						if(brasileirao.getTimes().get(k) == frame.getTimeFora()) {
							brasileirao.getTimes().get(k).getJogadores(j).fazerGol();
							brasileirao.getPartidas().get(frame.index).addGolFora(frame.getTimeFora().getJogadores(j));
						}
					}
				}
			}		
		}
		brasileirao.getPartidas().get(frame.index).finalizarPartida2(frame.getGolsCasa(), frame.getGolsFora(), frame.valorRodada);
		
		frame.dispose();
		PartidasTabelaRodadasJTables.main(null);
	}
	
	public static void atualizarPartida(PartidasEditar frame, ArrayList<JList> listaDeListas1, ArrayList<JList> listaDeListas2, Partida partidaEscolhida, int posicaoPartida){
		//Removendo os dados Antigos da Partida
		partidaEscolhida.deletarPartida();
		brasileirao.getPartidas().remove(posicaoPartida);
		
		//Instanciando uma nova partida com os dados da Antiga
		brasileirao.getPartidas().add(new Partida(frame.getTimeCasa(), frame.getTimeFora(), frame.estadio));
		int index = brasileirao.getPartidas().size()-1;
		for(int i = 0; i < frame.getGolsCasa(); i ++) {
			for(int j = 0; j < frame.getTimeCasa().getJogadoresSize(); j++) {
				if(frame.getTimeCasa().getJogadores(j) != null && listaDeListas1.get(i).getSelectedValue() == frame.getTimeCasa().getJogadores(j).getNome()) {
					for(int k = 0; k < 20; k++) {
						if(brasileirao.getTimes().get(k) == frame.getTimeCasa()) {
							brasileirao.getTimes().get(k).getJogadores(j).fazerGol();
							brasileirao.getPartidas().get(index).addGolCasa(frame.getTimeCasa().getJogadores(j));
						}
					}
				}
			}		
		}
		for(int i = 0; i < frame.getGolsFora(); i ++) {
			for(int j = 0; j < frame.getTimeFora().getJogadoresSize(); j++) {
				if(frame.getTimeFora().getJogadores(j) != null && listaDeListas2.get(i).getSelectedValue() == frame.getTimeFora().getJogadores(j).getNome()) {
					for(int k = 0; k < 20; k++) {
						if(brasileirao.getTimes().get(k) == frame.getTimeFora()) {
							brasileirao.getTimes().get(k).getJogadores(j).fazerGol();
							brasileirao.getPartidas().get(index).addGolFora(frame.getTimeFora().getJogadores(j));
						}
					}
				}
			}		
		}
		brasileirao.getPartidas().get( index).finalizarPartida2(frame.getGolsCasa(), frame.getGolsFora(), frame.getValorRodada());
		
		frame.dispose();
		PartidasTabelaRodadasJTables.main(null);
	}
}
