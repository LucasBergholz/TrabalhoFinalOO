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

import controlador.Listas;
import modelo.Jogador;
import modelo.Partida;
import modelo.Time;
import javax.swing.border.LineBorder;

/**
 * Tela responsável por ser um menu das possiveis acoes com partidas
 * @author Lucas Bergholz
 * @author Guilherme Rodrigues
 * @see Listas
 * @see Partida
 */
public class PartidasMenu extends JFrame {

	private JPanel painelConteudo;

	/**
	 * Método de inicializacao da tela de menu das partidas.
	 */
	public static void main(String[] args) {
		PartidasMenu frame = new PartidasMenu();
		frame.setVisible(true);
	}

	/**
	 * Construtor da tela de menu das partidas, responsavel por instanciar os componentes visuais e seus valores internos.
	 * @see PartidasMenu
	 */
	public PartidasMenu() {
		//Painel e titulo instanciados
		setTitle("Brasileirao 2022");
		painelConteudo = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 750, 600);
		setResizable(false);
		painelConteudo.setBackground(new Color(34, 139, 34));
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
		botaoCriar.setBorder(new LineBorder(new Color(255, 255, 255)));
		botaoCriar.setForeground(new Color(255, 255, 255));
		botaoCriar.setBackground(new Color(0, 0, 255));
		getContentPane().add(botaoCriar);
		botaoCriar.setBounds(286, 145, 175, 33);
		botaoCriar.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoCriar.addActionListener((event) -> {
			this.dispose();
			PartidasCriar.main(null);
		});
		
		//Botao de editar partidas
		JToggleButton botaoEditar = new JToggleButton("Editar Partida");
		botaoEditar.setForeground(new Color(255, 255, 255));
		botaoEditar.setBorder(new LineBorder(new Color(255, 255, 255)));
		botaoEditar.setBackground(new Color(0, 0, 255));
		getContentPane().add(botaoEditar);
		botaoEditar.setBounds(286, 213, 175, 33);
		botaoEditar.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoEditar.addActionListener((event) -> {
			this.dispose();
			PartidasEditar.main(null);
		});
		
		//Botao de ver partidas
		JToggleButton botaoVer = new JToggleButton("Ver Partidas");
		botaoVer.setForeground(new Color(255, 255, 255));
		botaoVer.setBorder(new LineBorder(new Color(255, 255, 255)));
		botaoVer.setBackground(new Color(0, 0, 255));
		getContentPane().add(botaoVer);
		botaoVer.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoVer.setBounds(286, 341, 175, 33);
		botaoVer.addActionListener((event) -> {
			this.dispose();
			PartidasTabelaRodadasJTables.main(null);
		});
		
		//Botao de voltar para o menu
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBorder(new LineBorder(new Color(255, 255, 255)));
		botaoVoltar.setBackground(new Color(0, 0, 255));
		botaoVoltar.setForeground(new Color(255, 255, 255));
		getContentPane().add(botaoVoltar);
		botaoVoltar.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoVoltar.setBounds(286, 419, 175, 33);
		botaoVoltar.addActionListener((event) -> {
			this.dispose();
			Menu.main(null);
		});
		
		//Botao de deletar uma partida
		JToggleButton botaoDeletar = new JToggleButton("Deletar Partida");
		botaoDeletar.setBackground(new Color(0, 0, 255));
		botaoDeletar.setBorder(new LineBorder(new Color(255, 255, 255)));
		botaoDeletar.setForeground(new Color(255, 255, 255));
		botaoDeletar.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoDeletar.setBounds(286, 276, 175, 33);
		painelConteudo.add(botaoDeletar);
		botaoDeletar.addActionListener((event) -> {
			this.dispose();
			PartidasDeletar.main(null);
		});
		
	}

}
