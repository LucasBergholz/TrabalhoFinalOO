package visao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import bancoDeDados.Listas;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.ButtonGroup;
import java.awt.Rectangle;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import java.awt.SystemColor;

public class Menu extends JFrame {	
	private Listas brasileirao = new Listas();
	
	public Listas getBrasileirao() {
		return brasileirao;
	}
	
	public Menu() {
		
		brasileirao.inicializarTimes();
		brasileirao.inicializarJogadores();
		brasileirao.inicializarPartidas();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(new Rectangle(0, 0, 750, 600));
		getContentPane().setBackground(new Color(0, 0, 128));
		setTitle("BRASILEIRAO 2022");
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel titulo = new JLabel("BRASILEIRAO 2022");
		getContentPane().add(titulo);
		titulo.setForeground(Color.WHITE);
		titulo.setBackground(new Color(0, 0, 128));
		titulo.setBounds(0, 0, 750, 101);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		
		JToggleButton botaoClassificacao = new JToggleButton("Classificacao");
		//Mudar a pagina para a de classificacao
		botaoClassificacao.addActionListener((event) -> {
			this.dispose();
			Classificacao.main(null);
		});
		
		getContentPane().add(botaoClassificacao);
		botaoClassificacao.setBounds(286, 145, 175, 33);
		botaoClassificacao.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoClassificacao.addActionListener(null);
		
		JToggleButton botaoPartidas = new JToggleButton("Partidas");
		getContentPane().add(botaoPartidas);
		botaoPartidas.setBounds(286, 245, 175, 33);
		botaoPartidas.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoPartidas.addActionListener((event) -> {
			this.dispose();
			MenuPartidas.main(null);
		});
		
		JToggleButton botaoArtilharia = new JToggleButton("Artilharia");
		getContentPane().add(botaoArtilharia);
		botaoArtilharia.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoArtilharia.setBounds(286, 345, 175, 33);
		
		JButton botaoSair = new JButton("Sair");
		getContentPane().add(botaoSair);
		botaoSair.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoSair.setBounds(286, 445, 175, 33);
		botaoSair.addActionListener((event) -> System.exit(0));
		
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.setVisible(true);
	}

	
	
}
