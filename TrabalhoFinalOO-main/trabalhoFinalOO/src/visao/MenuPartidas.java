package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import bancoDeDados.Listas;
import modelo.Partida;

public class MenuPartidas extends JFrame {

	private JPanel painelConteudo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPartidas frame = new MenuPartidas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPartidas() {
		//Painel e titulo instanciados
		setTitle("Brasileirao 2022");
		painelConteudo = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 750, 600);
		setResizable(false);
		painelConteudo.setBackground(new Color(0, 0, 128));
		painelConteudo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelConteudo);
		painelConteudo.setLayout(null);
		
		//Titulo para a pagina
		JLabel titulo = new JLabel("PARTIDAS");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		titulo.setBounds(0, 0, 751, 100);
		painelConteudo.add(titulo);
		
		//Criando botoes
		JToggleButton botaoCriar = new JToggleButton("Criar Partida");
		getContentPane().add(botaoCriar);
		botaoCriar.setBounds(286, 145, 175, 33);
		botaoCriar.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoCriar.addActionListener((event) -> {
			this.dispose();
			Menu.main(null);
		});
		
		JToggleButton botaoEditar = new JToggleButton("Editar Partida");
		getContentPane().add(botaoEditar);
		botaoEditar.setBounds(286, 245, 175, 33);
		botaoEditar.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JToggleButton botaoVer = new JToggleButton("Ver Partidas");
		getContentPane().add(botaoVer);
		botaoVer.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoVer.setBounds(286, 345, 175, 33);
		
		JButton botaoVoltar = new JButton("Voltar");
		getContentPane().add(botaoVoltar);
		botaoVoltar.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoVoltar.setBounds(286, 445, 175, 33);
		botaoVoltar.addActionListener((event) -> {
			this.dispose();
			Menu.main(null);
		});
		
		
	}

}
