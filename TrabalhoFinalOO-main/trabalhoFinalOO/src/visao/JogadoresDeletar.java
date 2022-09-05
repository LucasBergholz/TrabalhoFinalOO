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
import javax.swing.JSpinner;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import bancoDeDados.Listas;

/**
 * Tela responsável por deletar os jogadores do banco de dados
 * @author Lucas Bergholz
 * @author Guilherme Rodrigues
 * @see Listas
 * @see Jogador
 * @see Time
 */
public class JogadoresDeletar extends JFrame {

	private Listas brasileirao = new Listas();

	//Componentes Visuais
	private JPanel painelConteudo, painelJogadores;
	private JScrollPane painelJogadoresScroll;
	private DefaultListModel<String> listaDeTimesModelo = new DefaultListModel<String>();
	private JList<String> listaDeTimes ;
	private ArrayList<JButton> botoesDeletar = new ArrayList<JButton>();
	private JFrame frameOpcao = new JFrame();
	private Integer result;
	private static JOptionPane painelOpcao;
	
	/**
	 * Método de inicializacao da tela de deletar jogador.
	 */
	public static void main(String[] args) {
		JogadoresDeletar frame = new JogadoresDeletar();
		frame.setVisible(true);
	}

	/**
	 * Construtor da tela de deletar jogador, responsavel por instanciar os componentes visuais e seus valores internos.
	 * @see JogadoresDeletar
	 */
	public JogadoresDeletar() {
		//Padronizando o frame
		setTitle("Brasileirao 2022");
		painelConteudo = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 750, 600);
		setResizable(false);
		painelConteudo.setBackground(new Color(0, 0, 128));
		painelConteudo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelConteudo);
		painelConteudo.setLayout(null);
		
		//Botao para voltar para o menu de jogadores
		JButton botaoVoltar = new JButton("Voltar");
		getContentPane().add(botaoVoltar);
		botaoVoltar.setFont(new Font("Arial", Font.PLAIN, 16));
		botaoVoltar.setBounds(24, 35, 85, 28);
		botaoVoltar.addActionListener((event) -> {
			this.dispose();
			JogadoresMenu.main(null);
		});
		
		//Titulo para a pagina
		JLabel titulo = new JLabel("DELETAR JOGADOR");
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
		painelTimes.setBounds(267, 0, 197, 64);
		
		//Loop que retira o nome dos times do banco de dados
		for(int i = 0; i < 20; i++) {
			listaDeTimesModelo.addElement(brasileirao.getTimes().get(i).getNome());
		}
		//JList com os times do banco de dados
		listaDeTimes = new JList<String>(listaDeTimesModelo);
		
		//Painel de jogadores onde o usuario escolhera qual deletar
		painelJogadoresScroll = new JScrollPane();
		painelJogadores = new JPanel();
		painelJogadores.setBackground(new Color(0, 0, 128));
		painelJogadoresScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		painelJogadoresScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		painelJogadoresScroll.setVisible(true);
		painelJogadoresScroll.setViewportView(painelJogadores);
		painelJogadoresScroll.setBounds(170,200,400, 300);
		painelConteudo.add(painelJogadoresScroll);
		painelJogadores.setLayout(null);
		
		//Atualizar o que a tela mostra de acordo com a escolha do time
		listaDeTimes.addListSelectionListener((event)->{
			//Limpar o painel de jogadores e a arraylist de botoes
			painelJogadores.removeAll();
			botoesDeletar.clear();
			int contador = 0;
			//Loop realizado ate o time "i" do banco de dados ser igual ao time selecionado na JList
			for(int i = 0; i < 20; i++) {
				if(listaDeTimes.getSelectedValue() == brasileirao.getTimes().get(i).getNome()) {
					//Loop que adicionara um botao por jogador existente no time
					for(int j = 0; j < brasileirao.getTimes().get(i).getJogadoresSize(); j++) {
						int index = i;
						int index2 = j;
						//Adicionando botao na arraylist de botoes
						//Cada botao representa um jogador
						botoesDeletar.add(new JButton(brasileirao.getTimes().get(i).getJogadores(j).getNome()));
						botoesDeletar.get(contador).setBounds(new Rectangle(0, contador*70, 400, 60));
						botoesDeletar.get(contador).setFont(new Font("Arial Black", Font.PLAIN, 11));
						painelJogadores.add(botoesDeletar.get(contador));
						//Funcao que executa a delecao do jogador
						botoesDeletar.get(contador).addActionListener( new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								//Criacao de um painel popup para confirmacao final do usuario sobre a delecao do jogador
								if(result == null) {
									result = JOptionPane.showConfirmDialog(frameOpcao, "Voce realmente quer deletar " + brasileirao.getTimes().get(index).getJogadores(index2).getNome());
								}
								
								if (result == 0) {
									brasileirao.getTimes().get(index).deletarJogador(brasileirao.getTimes().get(index).getJogadores(index2));
									dispose();
									JogadoresVer.main(null);
								}
								else{
									dispose();
									JogadoresMenu.main(null);
								}
							}
						});
						contador++;
					}
					painelJogadores.setPreferredSize(new Dimension(600, contador*70));
				}
			}
			
			//Mudando a visibilidade do painel de scroll dos jogadores para atualizar os dados
			painelJogadoresScroll.setVisible(false);
			painelJogadoresScroll.setVisible(true);
		});
		painelTimes.setViewportView(listaDeTimes);
		panel.add(painelTimes);
		
	}
	
	
	//Getters & Setters
	public Listas getBrasileirao() {
		return brasileirao;
	}

	public void setBrasileirao(Listas brasileirao) {
		this.brasileirao = brasileirao;
	}

	public JPanel getPainelConteudo() {
		return painelConteudo;
	}

	public void setPainelConteudo(JPanel painelConteudo) {
		this.painelConteudo = painelConteudo;
	}

	public JPanel getPainelPartidas() {
		return painelJogadores;
	}

	public void setPainelPartidas(JPanel painelPartidas) {
		this.painelJogadores = painelPartidas;
	}

	public JScrollPane getPainelPartidasScroll() {
		return painelJogadoresScroll;
	}

	public void setPainelPartidasScroll(JScrollPane painelPartidasScroll) {
		this.painelJogadoresScroll = painelPartidasScroll;
	}

	public DefaultListModel<String> getListaDeTimesModelo() {
		return listaDeTimesModelo;
	}

	public void setListaDeTimesModelo(DefaultListModel<String> listaDeTimesModelo) {
		this.listaDeTimesModelo = listaDeTimesModelo;
	}

	public JList<String> getListaDeTimes() {
		return listaDeTimes;
	}

	public void setListaDeTimes(JList<String> listaDeTimes) {
		this.listaDeTimes = listaDeTimes;
	}

	public ArrayList<JButton> getBotoesDeletar() {
		return botoesDeletar;
	}

	public void setBotoesDeletar(ArrayList<JButton> botoesDeletar) {
		this.botoesDeletar = botoesDeletar;
	}

	public JFrame getFrameOpcao() {
		return frameOpcao;
	}

	public void setFrameOpcao(JFrame frameOpcao) {
		this.frameOpcao = frameOpcao;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
}
