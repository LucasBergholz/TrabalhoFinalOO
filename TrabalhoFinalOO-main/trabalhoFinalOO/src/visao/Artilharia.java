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
import controlador.ControleArtilharia;
import modelo.*;

public class Artilharia extends JFrame {

	private ArrayList<Time> times = new ArrayList<Time>();
	private JTable tabelaArtilharia;

	public static void main(String[] args) {
		Artilharia frame = new Artilharia();
		frame.setVisible(true);
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
		//Adicionando a tabela no painelScroll e o painelScroll no painel principal
		painelScroll.setViewportView(tabelaArtilharia);
		painelConteudo.add(painelScroll);
		
		//Adicionando legenda a tabela
		tabelaArtilharia.setValueAt("Jogador",0,0);
		tabelaArtilharia.setValueAt("Time",0,1);
		tabelaArtilharia.setValueAt("Gols",0,2);
		
		//Inicializando a tabela
		ControleArtilharia.inicializarTabela(times, tabelaArtilharia);
		
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
}
