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
import javax.swing.border.LineBorder;
/**
 * Frame Responsavel por mostrar as opções de ações que o usúrio pode tomar em relação aos Jogadores
 * 
 * @author Guilherme Rodrigues 
 * @author Lucas Gobbi
 * @see JogadoresCriar
 * @see JogadoresDeletar
 * @see JogadoresEditar
 * @see JogadoresVer
 *
 */
public class JogadoresMenu extends JFrame {

	private JPanel painelConteudo;
	
	/**
	 * Função do Menu de Jogadores que instancia o Frame e o torna visivel pro usuário
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JogadoresMenu frame = new JogadoresMenu();
		frame.setVisible(true);
	}
	
	/**
	 * Construtor do Frame Menu que instancia os componentes visiais do Menu de Jogadores
	 */
	public JogadoresMenu() {
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
		JLabel titulo = new JLabel("JOGADORES");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		titulo.setBounds(0, 0, 751, 100);
		painelConteudo.add(titulo);
		
		//Criando botoes
		//Leva pra pagina de criar jogador
		JToggleButton botaoCriar = new JToggleButton("Cadastrar Jogador");
		botaoCriar.setBorder(new LineBorder(new Color(255, 255, 255)));
		botaoCriar.setForeground(new Color(255, 255, 255));
		botaoCriar.setBackground(new Color(0, 0, 255));
		getContentPane().add(botaoCriar);
		botaoCriar.setBounds(280, 145, 200, 33);
		botaoCriar.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoCriar.addActionListener((event) -> {
			this.dispose();
			JogadoresCriar.main(null);
		});
		
		//Leva pra pagina de deletar jogador
		JToggleButton botaoDeletar = new JToggleButton("Deletar Jogador");
		botaoDeletar.setBorder(new LineBorder(new Color(255, 255, 255)));
		botaoDeletar.setForeground(new Color(255, 255, 255));
		botaoDeletar.setBackground(new Color(0, 0, 255));
		botaoDeletar.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoDeletar.setBounds(280, 276, 200, 33);
		painelConteudo.add(botaoDeletar);
		botaoDeletar.addActionListener((event) -> {
			this.dispose();
			JogadoresDeletar.main(null);
		});
		//Leva pra pagina de Editar Jogador
		JToggleButton botaoEditar = new JToggleButton("Editar Jogador");
		botaoEditar.setBorder(new LineBorder(new Color(255, 255, 255)));
		botaoEditar.setBackground(new Color(0, 0, 255));
		botaoEditar.setForeground(new Color(255, 255, 255));
		getContentPane().add(botaoEditar);
		botaoEditar.setBounds(280, 210, 200, 33);
		botaoEditar.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoEditar.addActionListener((event) -> {
			this.dispose();
			JogadoresEditar.main(null);
		});
		
		//Leva pra pagina de ver jogador
		JToggleButton botaoVer = new JToggleButton("Ver Jogadores");
		botaoVer.setBorder(new LineBorder(new Color(255, 255, 255)));
		botaoVer.setForeground(new Color(255, 255, 255));
		botaoVer.setBackground(new Color(0, 0, 255));
		getContentPane().add(botaoVer);
		botaoVer.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoVer.setBounds(280, 345, 200, 33);
		botaoVer.addActionListener((event) -> {
			this.dispose();
			JogadoresVer.main(null);
		});
		
		//Leva pra pagina anterior
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBorder(new LineBorder(new Color(255, 255, 255)));
		botaoVoltar.setBackground(new Color(0, 0, 255));
		botaoVoltar.setForeground(new Color(255, 255, 255));
		getContentPane().add(botaoVoltar);
		botaoVoltar.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoVoltar.setBounds(280, 421, 200, 33);
		botaoVoltar.addActionListener((event) -> {
			this.dispose();
			Menu.main(null);
		});
		
		
		
	}
}
