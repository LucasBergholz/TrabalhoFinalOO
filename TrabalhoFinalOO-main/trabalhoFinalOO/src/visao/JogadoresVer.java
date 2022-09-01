package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import bancoDeDados.Listas;
import controlador.ControleJogadores;
import modelo.Time;

public class JogadoresVer extends JFrame {
	
	private static Listas brasileirao = new Listas();
	private JPanel painelConteudo;
	private Time timeEscolhido;

	public static void main(String[] args) {
		JogadoresVer frame = new JogadoresVer();
		frame.setVisible(true);
	}

	public JogadoresVer() {
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
		
		JButton botaoVoltar = new JButton("Voltar");
		getContentPane().add(botaoVoltar);
		botaoVoltar.setFont(new Font("Arial", Font.PLAIN, 16));
		botaoVoltar.setBounds(24, 35, 85, 28);
		botaoVoltar.addActionListener((event) -> {
			this.dispose();
			JogadoresMenu.main(null);
		});
		
		//Titulo para a pagina
		JLabel titulo = new JLabel("VER JOGADORES");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		titulo.setBounds(0, 0, 751, 100);
		painelConteudo.add(titulo);
		
		//Criando os blocos das partidas
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0x274360));
		panel.setBounds(0, 98, 736, 64);
		painelConteudo.add(panel);
		panel.setLayout(null);

		//Criando JList com times que aparecerão para o usuário
		JScrollPane painelTimes = new JScrollPane();
		DefaultListModel<String> listaDeTimesModelo = new DefaultListModel<String>();
		for(int i = 0; i < 20; i++) {
			listaDeTimesModelo.addElement(brasileirao.getTimes().get(i).getNome());
		}
		JList<String> listaDeTimes = new JList<String>(listaDeTimesModelo);
		painelTimes.setBounds(267, 0, 197, 64);
		
		painelTimes.setViewportView(listaDeTimes);
		panel.add(painelTimes);
		
		JScrollPane painelScroll = new JScrollPane();
		painelScroll.setBounds(127, 194, 500, 300);
		painelScroll.setBackground(new Color(0, 0, 128));
		painelConteudo.add(painelScroll);
		
		
		//Atualizar o que a tela mostra de acordo com a escolha do time
		listaDeTimes.addListSelectionListener((event)->{
			ControleJogadores.verJogadores(listaDeTimes, painelScroll);
		});
				
	}

}
