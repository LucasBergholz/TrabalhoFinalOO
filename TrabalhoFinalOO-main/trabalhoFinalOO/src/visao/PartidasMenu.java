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

public class PartidasMenu extends JFrame {

	private JPanel painelConteudo;

	public static void main(String[] args) {
		PartidasMenu frame = new PartidasMenu();
		frame.setVisible(true);
	}

	
	public PartidasMenu() {
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
			PartidasCriar.main(null);
		});
		
		JToggleButton botaoEditar = new JToggleButton("Editar Partida");
		getContentPane().add(botaoEditar);
		botaoEditar.setBounds(286, 213, 175, 33);
		botaoEditar.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoEditar.addActionListener((event) -> {
			this.dispose();
			PartidasEditar.main(null);
		});
		
		JToggleButton botaoVer = new JToggleButton("Ver Partidas");
		getContentPane().add(botaoVer);
		botaoVer.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoVer.setBounds(286, 341, 175, 33);
		botaoVer.addActionListener((event) -> {
			this.dispose();
			PartidasTabelaRodadasJTables.main(null);
		});
		
		JButton botaoVoltar = new JButton("Voltar");
		getContentPane().add(botaoVoltar);
		botaoVoltar.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoVoltar.setBounds(286, 419, 175, 33);
		
		JToggleButton botaoDeletar = new JToggleButton("Deletar Partida");
		botaoDeletar.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoDeletar.setBounds(286, 276, 175, 33);
		painelConteudo.add(botaoDeletar);
		botaoVoltar.addActionListener((event) -> {
			this.dispose();
			JogadoresDeletar.main(null);
		});
		
		
	}

}
