package visao;

import bancoDeDados.*;
import modelo.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.awt.Dimension;

public class Classificacao extends JFrame {

	private JPanel painelConteudo;
	private JTable tabelaClassificacao;
	private Listas brasileirao = new Listas();
	ArrayList<Time> times = new ArrayList<Time>();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Classificacao frame = new Classificacao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Classificacao() {
		//Criando titulo do frame e definindo caracteristicas do painel de conteudo
		painelConteudo = new JPanel();
		setTitle("Brasileirao 2022");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 750, 600);
		setResizable(false);
		painelConteudo.setBackground(new Color(0, 0, 128));
		painelConteudo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelConteudo);
		painelConteudo.setLayout(null);
		
		//Criando a tabela dentro de um painel com scroll
		JScrollPane painelScroll = new JScrollPane();
		painelScroll.setEnabled(false);
		painelScroll.setFocusable(false);
		painelScroll.setBackground(new Color(0, 0, 128));
		painelScroll.setLocation(0, 122);
		painelScroll.setSize(new Dimension(736, 441));
		
		//Estetica da tabela
		tabelaClassificacao = new JTable(21,7);
		tabelaClassificacao.setTableHeader(null);
		tabelaClassificacao.setEnabled(false);
		tabelaClassificacao.setGridColor(new Color(0, 0, 0));
		tabelaClassificacao.setBackground(new Color(255, 255, 255));
		tabelaClassificacao.setForeground(new Color(0, 0, 0));
		tabelaClassificacao.setAutoCreateColumnsFromModel(false);
		tabelaClassificacao.setRowHeight(25);
		tabelaClassificacao.getColumnModel().getColumn(0).setPreferredWidth(200);
		tabelaClassificacao.setFont(new Font("Arial", Font.PLAIN, 20));
		tabelaClassificacao.setBounds(40, 100, 650, 525);
		tabelaClassificacao.setRowSelectionAllowed(false);
		painelScroll.setViewportView(tabelaClassificacao);
		painelConteudo.add(painelScroll);
		
		//Adicionando legenda a tabela
		tabelaClassificacao.setValueAt("Times",0,0);
		tabelaClassificacao.setValueAt("Partidas",0,1);
		tabelaClassificacao.setValueAt("Pontos",0,2);
		tabelaClassificacao.setValueAt("Vitorias",0,3);
		tabelaClassificacao.setValueAt("Empates",0,4);
		tabelaClassificacao.setValueAt("Derrotas",0,5);
		tabelaClassificacao.setValueAt("SG",0,6);
		
		//Inicializando a tabela
		inicializarTabela();
		
		//Titulo para a pagina
		JLabel titulo = new JLabel("CLASSIFICAÇÃO");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		titulo.setBounds(0, 0, 751, 100);
		painelConteudo.add(titulo);
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBounds(10, 35, 85, 21);
		painelConteudo.add(botaoVoltar);
		botaoVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				times.clear();
				Menu.main(null);
			}
		});
	}
		
		public void inicializarTabela() {
			times.clear();
			//Adicionando os dados a tabela
			
			//Tirando os dados do banco de dados
			for(int i = 0; i < 20; i++) {
				times.add(brasileirao.getTimes().get(i));		
			}
			
			//Fazendo bubble sort para elencar eles por numero de pontos e posteriormente por saldo de gol
			for(int i = 0; i < 20; i++) {
				ArrayList<Time> auxiliar = new ArrayList<Time>();
				auxiliar.clear();
				int auxCounter = 0;
				for(int j = 0; j < 19; j++) {
					if(times.get(j).getPontosTotais() < times.get(j+1).getPontosTotais()) {
						auxiliar.add(times.get(j));
						times.set(j, times.get(j+1));
						times.set(j+1, auxiliar.get(auxCounter));
						auxCounter++;
					} else if((times.get(j).getPontosTotais() == times.get(j+1).getPontosTotais()) &&
							  (times.get(j).getSaldoGols() < times.get(j+1).getSaldoGols())) {
						auxiliar.add(times.get(j));
						times.set(j, times.get(j+1));
						times.set(j+1, auxiliar.get(auxCounter));
						auxCounter++;
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
			}
		 }

}
