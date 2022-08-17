package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import bancoDeDados.Listas;
import modelo.*;

public class Artilharia extends JFrame {

	private Listas brasileirao = new Listas();
	ArrayList<Time> times = new ArrayList<Time>();
	JTable tabelaArtilharia;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Artilharia frame = new Artilharia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Artilharia() {
		//Criando titulo do frame e definindo caracteristicas do painel de conteudo
				JPanel painelConteudo = new JPanel();
				setTitle("Brasileirao 2022");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(0, 0, 750, 600);
				setResizable(false);
				painelConteudo.setBackground(new Color(0, 0, 128));
				painelConteudo.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(painelConteudo);
				painelConteudo.setLayout(null);
				
				//Titulo para a pagina
				JLabel titulo = new JLabel("ARTILHARIA");
				titulo.setHorizontalAlignment(SwingConstants.CENTER);
				titulo.setForeground(Color.WHITE);
				titulo.setFont(new Font("Arial", Font.BOLD, 50));
				titulo.setBounds(0, 0, 751, 100);
				painelConteudo.add(titulo);
				
				//Criando a tabela dentro de um painel com scroll
				JScrollPane painelScroll = new JScrollPane();
				painelScroll.setEnabled(false);
				painelScroll.setFocusable(false);
				painelScroll.setBackground(new Color(0, 0, 128));
				painelScroll.setLocation(130, 122);
				painelScroll.setSize(new Dimension(500, 441));
				
				//Estetica da tabela
				tabelaArtilharia = new JTable(21,3);
				tabelaArtilharia.setTableHeader(null);
				tabelaArtilharia.setEnabled(false);
				tabelaArtilharia.setGridColor(new Color(0, 0, 0));
				tabelaArtilharia.setBackground(new Color(255, 255, 255));
				tabelaArtilharia.setForeground(new Color(0, 0, 0));
				tabelaArtilharia.setAutoCreateColumnsFromModel(false);
				tabelaArtilharia.setRowHeight(25);
				tabelaArtilharia.getColumnModel().getColumn(0).setPreferredWidth(300);
				tabelaArtilharia.getColumnModel().getColumn(1).setPreferredWidth(200);
				tabelaArtilharia.setFont(new Font("Arial", Font.PLAIN, 20));
				tabelaArtilharia.setBounds(40, 100, 400, 525);
				tabelaArtilharia.setRowSelectionAllowed(false);
				painelScroll.setViewportView(tabelaArtilharia);
				painelConteudo.add(painelScroll);
				
				//Adicionando legenda a tabela
				tabelaArtilharia.setValueAt("Jogador",0,0);
				tabelaArtilharia.setValueAt("Time",0,1);
				tabelaArtilharia.setValueAt("Gols",0,2);
				
				//Inicializando a tabela
				inicializarTabela();
				
				//Botao voltar para o menu
				JButton botaoVoltar = new JButton("Voltar");
				botaoVoltar.setBounds(10, 35, 85, 21);
				painelConteudo.add(botaoVoltar);
				botaoVoltar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
						Menu.main(null);
					}
				});
			}
	
	public void inicializarTabela() {
		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
		times.clear();
		jogadores.clear();
		
		//Tirando os dados do banco de dados
		for(int i = 0; i < 20; i++) {
			times.add(brasileirao.getTimes().get(i));		
		}
		
		//Tirando os jogadores dos times
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 11; j++) {
				if(times.get(i).getJogadores(j) != null) {
					jogadores.add(times.get(i).getJogadores(j));
				}
			}
		}
		
		int n = jogadores.size();
		for(int i = 0; i < n-1; i++) {
			ArrayList<Jogador> auxiliar = new ArrayList<Jogador>();
			for(int j = 0; j < n-1; j++) {
				auxiliar.clear();
				int auxCounter = 0;
				//if(jogadores.get(j+1) != null) {
					if(jogadores.get(j).getTotalGols() < jogadores.get(j+1).getTotalGols()) {
						auxiliar.add(jogadores.get(j));
						jogadores.set(j, jogadores.get(j+1));
						jogadores.set(j+1, auxiliar.get(auxCounter));
						auxCounter++;
					}	
				//}
				
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
