package visao;

import bancoDeDados.*;
import controlador.ControleClassificacao;
import modelo.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

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

/**
 * Tela de inicializacao da classificacao dos times
 * @author Lucas Bergholz
 * @author Guilherme Rodrigues
 * @see Time
 * @see Tecnico
 */
public class Classificacao extends JFrame {

	private JPanel painelConteudo;
	private JTable tabelaClassificacao;
	private ArrayList<Time> times = new ArrayList<Time>();

	/**
	 * Método de inicializacao da tela de classificacao.
	 */
	public static void main(String[] args) {
		Classificacao frame = new Classificacao();
		frame.setVisible(true);
	}

	/**
	 * Construtor da tela de classificao, responsavel por instanciar os componentes como JTable e seus valores internos.
	 * @see Classificacao
	 */
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
		painelScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		//Estetica da tabela
		tabelaClassificacao = new JTable(21,8);
		tabelaClassificacao.setTableHeader(null);
		tabelaClassificacao.setEnabled(false);
		tabelaClassificacao.setGridColor(new Color(0, 0, 0));
		tabelaClassificacao.setBackground(new Color(255, 255, 255));
		tabelaClassificacao.setForeground(new Color(0, 0, 0));
		tabelaClassificacao.setAutoCreateColumnsFromModel(false);
		tabelaClassificacao.setFont(new Font("Arial", Font.PLAIN, 20));
		tabelaClassificacao.setBounds(40, 100, 0, 525);
		
		//Definindo tamanho das celulas da tabela
		tabelaClassificacao.setRowHeight(25);
		tabelaClassificacao.getColumnModel().getColumn(0).setPreferredWidth(250);
		tabelaClassificacao.getColumnModel().getColumn(1).setPreferredWidth(90);
		tabelaClassificacao.getColumnModel().getColumn(2).setPreferredWidth(80);
		tabelaClassificacao.getColumnModel().getColumn(3).setPreferredWidth(90);
		tabelaClassificacao.getColumnModel().getColumn(4).setPreferredWidth(90);
		tabelaClassificacao.getColumnModel().getColumn(5).setPreferredWidth(90);
		tabelaClassificacao.getColumnModel().getColumn(7).setPreferredWidth(200);
		tabelaClassificacao.setRowSelectionAllowed(false);
		//Tamanho da tabela nao se atualiza automaticamente
		tabelaClassificacao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//Adicionando tabela no painelScroll e o pianelScroll no painel principal
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
		tabelaClassificacao.setValueAt("Tecnico", 0, 7);
		
		//Inicializando a tabela
		ControleClassificacao.inicializarTabela(times, tabelaClassificacao);
		
		//Titulo para a pagina
		JLabel titulo = new JLabel("CLASSIFICAÇÃO");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		titulo.setBounds(0, 0, 751, 100);
		painelConteudo.add(titulo);
		
		//Botao para voltar
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

}
