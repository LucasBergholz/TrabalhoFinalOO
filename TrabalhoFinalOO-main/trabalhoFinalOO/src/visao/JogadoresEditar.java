package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.ControleJogadores;
import controlador.Listas;
import modelo.Jogador;
import modelo.Posicao;
import modelo.Time;
/**
 * Frame Responsavel pela Edição dos dados dos Jogadores
 * @author Guilherme Rodrigues Costa
 * @author Lucas Gobbit
 *
 *@see JogadoresMenu
 */
public class JogadoresEditar extends JFrame {

	private Listas brasileirao = new Listas();
	private Time timeJog;
	private Posicao posicaoJogador;
	private Jogador jogador;
	
	//Componentes Visuais
	private JPanel painelConteudo, painelJogadores, painelEdicao;
	private JScrollPane painelJogadoresScroll;
	private DefaultListModel<String> listaDeTimesModelo = new DefaultListModel<String>();
	private JList<String> listaDeTimes ;
	private ArrayList<JButton> botoesEditar = new ArrayList<JButton>();
	private JFrame frameOpcao = new JFrame();
	private Integer result;
	private static JOptionPane painelOpcao;
	protected JLabel titulo;
	private JTextField txtNome;
	private JSpinner spnIdade = new JSpinner();
	private JButton botaoVoltar = new JButton("Voltar");
	private JButton botaoCriar;
	private DefaultListModel listaPosicao = new DefaultListModel();
	private JList listagemPosicao ;
	private JList listagemTime;

	/**
	 * Método de inicializacao da tela de editar jogadores.
	 */
	public static void main(String[] args) {
		JogadoresEditar frame = new JogadoresEditar();
		frame.setVisible(true);
	}
	
	/**
	 * Construtor da Tela de Editar Jogadores cuja a função é inicialmente instanciar os componentes visiais do Painel de Escolha de Jogadores para a edição
	 * @see JogadoresEditar
	 */
	public JogadoresEditar() {
		//Padronizando o frame
		setTitle("Brasileirao 2022");
		painelConteudo = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 750, 600);
		setResizable(false);
		painelConteudo.setBackground(new Color(34, 139, 34));
		painelConteudo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelConteudo);
		painelConteudo.setLayout(null);
		
		//Botao de voltar para o menu de jogadores
		botaoVoltar = new JButton("Voltar");
		getContentPane().add(botaoVoltar);
		botaoVoltar.setFont(new Font("Arial", Font.PLAIN, 16));
		botaoVoltar.setBounds(24, 35, 85, 28);
		botaoVoltar.addActionListener((event) -> {
			this.dispose();
			JogadoresMenu.main(null);
		});
		
		//Titulo para a pagina
		titulo = new JLabel("EDITAR JOGADOR");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		titulo.setBounds(0, 0, 751, 100);
		painelConteudo.add(titulo);
		
		//Criando os blocos das partidas
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 98, 736, 64);
		painelConteudo.add(panel);
		panel.setLayout(null);

		//Criando JList com times que aparecerão para o usuário
		JScrollPane painelTimes = new JScrollPane();
		
		//Loop que retira os dados do banco de dados e adiciona os times em uma lista
		for(int i = 0; i < 20; i++) {
			listaDeTimesModelo.addElement(brasileirao.getTimes().get(i).getNome());
		}
		//Instanciando JList usando a lista de times
		listaDeTimes = new JList<String>(listaDeTimesModelo);
		painelTimes.setBounds(267, 0, 197, 64);
		
		//Painel de jogadores onde o usuario escolhera qual editar
		painelJogadoresScroll = new JScrollPane();
		painelJogadores = new JPanel();
		painelJogadores.setBackground(new Color(34, 139, 34));
		painelJogadoresScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		painelJogadoresScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		painelJogadoresScroll.setVisible(true);
		painelJogadoresScroll.setViewportView(painelJogadores);
		painelJogadoresScroll.setBounds(170,200,400, 300);
		painelConteudo.add(painelJogadoresScroll);
		painelJogadores.setLayout(null);
		
		//Instanciando botao de criar o jogador
		botaoCriar = new JButton("Atualizar");
		botaoCriar.setBounds(551, 520, 175, 33);
		botaoCriar.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoCriar.setVisible(false);
		painelConteudo.add(botaoCriar);
		
		//Atualizar o que a tela mostra de acordo com a escolha do time
		listaDeTimes.addListSelectionListener((event)->{
			//Limpando painel de jogadores e a arraylist de botoes
			painelJogadores.removeAll();
			botoesEditar.clear();
			int contador = 0;
			//Loop que ira parar quando o time "i" for igual ao time selecionado pelo usuario
			for(int i = 0; i < 20; i++) {
				if(listaDeTimes.getSelectedValue() == brasileirao.getTimes().get(i).getNome()) {
					//Loop que adicionara um botao por jogador existente no time
					for(int j = 0; j < brasileirao.getTimes().get(i).getJogadoresSize(); j++) {
						int index = i;
						int index2 = j;
						//Adicionando botao na arraylist de botoes
						//Cada botao representa um jogador
						botoesEditar.add(new JButton(brasileirao.getTimes().get(i).getJogadores(j).getNome()));
						botoesEditar.get(contador).setBounds(new Rectangle(0, contador*70, 400, 60));
						botoesEditar.get(contador).setFont(new Font("Arial Black", Font.PLAIN, 11));
						painelJogadores.add(botoesEditar.get(contador));
						//Funcao que executa a edicao do jogador
						botoesEditar.get(contador).addActionListener( new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								//Colocando o Painel como invisivel
								painelJogadores.setVisible(false);
								painelJogadoresScroll.setVisible(false);
								botaoVoltar.setVisible(false);
								botaoCriar.setVisible(true);
								panel.setVisible(false);
								//Salvando o jogador escolhido
								setJogador(brasileirao.getTimes().get(index).getJogadores(index2));
								editarJogador(brasileirao.getTimes().get(index).getJogadores(index2), index, index2);
								
							}
						});
						contador++;
					}
					painelJogadores.setPreferredSize(new Dimension(600, contador*70));
				}
			}
			
			//Mudando visibilidade do painel de jogadores para atualizar os dados da pagina
			painelJogadoresScroll.setVisible(false);
			painelJogadoresScroll.setVisible(true);
		});
		painelTimes.setViewportView(listaDeTimes);
		panel.add(painelTimes);
		
	}
	
	/**
	 *  metodo que puxa o painel de Criar Jogadores com as informações do jogador já inseridas nos imputs
	 * 
	 * @param jogadorEscolhido no painel inicial
	 */
	private void editarJogador(Jogador jogadorEscolhido, int index, int index2) {
		//Painel com as opcoes de dados do jogador
		JPanel painelCadastro = new JPanel();
		painelCadastro.setBounds(49, 110, 635, 400);
		painelCadastro.setLayout(null);
		painelConteudo.add(painelCadastro);
		
		//Input de texto que o usuario coloca o nome do jogador
		txtNome = new JTextField(jogadorEscolhido.getNome());
		txtNome.setFont(new Font("Arial", Font.PLAIN, 20));
		txtNome.setBounds(136, 49, 358, 24);
		painelCadastro.add(txtNome);
		txtNome.setColumns(10);
		
		//Texto para auxilio do usuario entender o programa
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNome.setBounds(25, 49, 101, 24);
		painelCadastro.add(lblNome);
		
		//Criando a lista de times
		DefaultListModel listaTimes = new DefaultListModel();
		for(int i = 0; i < 20; i++) {
			listaTimes.addElement(brasileirao.getTimes().get(i).getNome());
		}
		
		//Instanciando a JList com a lista de times
		listagemTime = new JList(listaTimes);
		listagemTime.setFont(new Font("Arial Black", Font.PLAIN, 11));
		listagemTime.setBounds(136, 256, 197, 112);
		painelCadastro.add(listagemTime);
		
		//Painel scroll com a JList de times
		JScrollPane listaTimesScroll = new JScrollPane(listagemTime);
		painelCadastro.add(listaTimesScroll);
		listaTimesScroll.setSize(197, 112);
		listaTimesScroll.setLocation(136, 256);
		
		//Texto auxiliar do usuario indicando a funcao de cada input
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTime.setBounds(25, 260, 101, 24);
		painelCadastro.add(lblTime);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Arial", Font.PLAIN, 20));
		lblIdade.setBounds(25, 106, 101, 24);
		painelCadastro.add(lblIdade);
		
		JLabel lblPosicao = new JLabel("Posição");
		lblPosicao.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPosicao.setBounds(25, 166, 101, 24);
		painelCadastro.add(lblPosicao);

		//Indicando tamanho e dados do spinner de rodada
		spnIdade.setBounds(136, 106, 49, 26);
		spnIdade.setModel(new SpinnerNumberModel((double)jogadorEscolhido.getIdade(), 18.0, 100.0, 1.0));
		painelCadastro.add(spnIdade);
		
		
		//Instanciando a Lista de posicões
		listaPosicao.addElement(Posicao.ATACANTE);
		listaPosicao.addElement(Posicao.GOLEIRO);
		listaPosicao.addElement(Posicao.LATERAL);
		listaPosicao.addElement(Posicao.MEIA);
		listaPosicao.addElement(Posicao.PONTA);
		listaPosicao.addElement(Posicao.VOLANTE);
		listaPosicao.addElement(Posicao.ZAGUEIRO);
		
		//Criando JList com a lista de posicoes
		listagemPosicao = new JList(listaPosicao);
		listagemPosicao.setFont(new Font("Arial Black", Font.PLAIN, 11));
		listagemPosicao.setBounds(136, 166, 358, 80);
		painelCadastro.add(listagemPosicao);
		
		//Painel scroll que contem a JList de posioes
		JScrollPane srclPosicao = new JScrollPane(listagemPosicao);
		painelCadastro.add(srclPosicao);
		srclPosicao.setSize(197, 80);
		srclPosicao.setLocation(136, 166);
		
		//Segundo botao voltar, mas agora do painel de edicao dos jogadores
		JButton botaoVoltar2 = new JButton("Voltar");
		botaoVoltar2.setFont(new Font("Arial", Font.PLAIN, 16));
		botaoVoltar2.setBounds(24, 35, 85, 28);
		painelConteudo.add(botaoVoltar2);
		botaoVoltar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JogadoresEditar.main(null);
			}
		});
		
		//Botao de criar o Jogador
		botaoCriar.addActionListener((event) -> {
			//Conferindo se os dados do Jogador foram adcionados
			if(!listagemPosicao.isSelectionEmpty() && !listagemTime.isSelectionEmpty() && !txtNome.getText().isBlank()) {			
				setPosicaoJogador( (Posicao) listagemPosicao.getSelectedValue());
				
				//Funcao que cria o jogador
				int gols = getJogador().getTotalGols();
				ControleJogadores.atualizandoJogador(listagemTime, txtNome, brasileirao, this, spnIdade, gols);
				brasileirao.getTimes().get(index).deletarJogador(brasileirao.getTimes().get(index).getJogadores(index2));
				this.dispose();
				JogadoresVer.main(null);
			}
		});
	}
	
	
	//Getters e Setters
	public Time getTimeJog() {
		return timeJog;
	}

	public void setTimeJog(Time timeJog) {
		this.timeJog = timeJog;
	}

	public Posicao getPosicaoJogador() {
		return posicaoJogador;
	}

	public void setPosicaoJogador(Posicao posicaoJogador) {
		this.posicaoJogador = posicaoJogador;
	}

	public JPanel getPainelEdicao() {
		return painelEdicao;
	}

	public void setPainelEdicao(JPanel painelEdicao) {
		this.painelEdicao = painelEdicao;
	}

	public static JOptionPane getPainelOpcao() {
		return painelOpcao;
	}

	public static void setPainelOpcao(JOptionPane painelOpcao) {
		JogadoresEditar.painelOpcao = painelOpcao;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JSpinner getSpnIdade() {
		return spnIdade;
	}

	public void setSpnIdade(JSpinner spnIdade) {
		this.spnIdade = spnIdade;
	}

	public JButton getBotaoVoltar() {
		return botaoVoltar;
	}

	public void setBotaoVoltar(JButton botaoVoltar) {
		this.botaoVoltar = botaoVoltar;
	}

	public JButton getBotaoCriar() {
		return botaoCriar;
	}

	public void setBotaoCriar(JButton botaoCriar) {
		this.botaoCriar = botaoCriar;
	}

	public DefaultListModel getListaPosicao() {
		return listaPosicao;
	}

	public void setListaPosicao(DefaultListModel listaPosicao) {
		this.listaPosicao = listaPosicao;
	}

	public JList getListagemPosicao() {
		return listagemPosicao;
	}

	public void setListagemPosicao(JList listagemPosicao) {
		this.listagemPosicao = listagemPosicao;
	}

	public JList getListagemTime() {
		return listagemTime;
	}

	public void setListagemTime(JList listagemTime) {
		this.listagemTime = listagemTime;
	}

	public void setResult(Integer result) {
		this.result = result;
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
		return botoesEditar;
	}

	public void setBotoesDeletar(ArrayList<JButton> botoesDeletar) {
		this.botoesEditar = botoesDeletar;
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
	
	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
}
