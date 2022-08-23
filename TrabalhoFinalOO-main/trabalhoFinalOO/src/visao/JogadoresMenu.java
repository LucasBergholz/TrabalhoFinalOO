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

public class JogadoresMenu extends JFrame {

	private JPanel painelConteudo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JogadoresMenu frame = new JogadoresMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JogadoresMenu() {
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
		JLabel titulo = new JLabel("JOGADORES");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		titulo.setBounds(0, 0, 751, 100);
		painelConteudo.add(titulo);
		
		//Criando botoes
		JToggleButton botaoCriar = new JToggleButton("Cadastrar Jogador");
		getContentPane().add(botaoCriar);
		botaoCriar.setBounds(280, 145, 200, 33);
		botaoCriar.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoCriar.addActionListener((event) -> {
			this.dispose();
			//PartidasCriar.main(null);
		});
		
		JToggleButton botaoEditar = new JToggleButton("Editar Jogador");
		getContentPane().add(botaoEditar);
		botaoEditar.setBounds(280, 245, 200, 33);
		botaoEditar.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JToggleButton botaoVer = new JToggleButton("Ver Jogadores");
		getContentPane().add(botaoVer);
		botaoVer.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoVer.setBounds(280, 345, 200, 33);
		botaoVer.addActionListener((event) -> {
			this.dispose();
			//PartidasTabelaRodadas.main(null);
		});
		
		JButton botaoVoltar = new JButton("Voltar");
		getContentPane().add(botaoVoltar);
		botaoVoltar.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoVoltar.setBounds(280, 445, 200, 33);
		botaoVoltar.addActionListener((event) -> {
			this.dispose();
			Menu.main(null);
		});
	}
}
