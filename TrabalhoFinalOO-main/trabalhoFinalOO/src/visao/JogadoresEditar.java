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

import bancoDeDados.Listas;
import controlador.ControleJogadores;
import modelo.Jogador;
import modelo.Posicao;
import modelo.Time;
/**
 * Frame Responsavel pela Edição dos dados dos Jogadores
 * @author Colemar
 *
 */
public class JogadoresEditar extends JFrame {

	private Listas brasileirao = new Listas();
	private Time timeJog;
	private Posicao posicaoJogador;
	
	//Componentes Visuais
	private JPanel painelConteudo, painelPartidas, painelEdicao;
	private JScrollPane painelPartidasScroll;
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
	private JButton botaoCriar = new JButton("Atualizar");
	private DefaultListModel listaPosicao = new DefaultListModel();
	private JList listagemPosicao ;
	private JList listagemTime;

	//Metodos
	public static void main(String[] args) {
		JogadoresEditar frame = new JogadoresEditar();
		frame.setVisible(true);
	}
	
	/**
	 * Construtor da Tela de Editar Jogadores cuja a função é inicialmente instanciar os componentes visiais do Painel de Escolha de Jogadores para a edição
	 */
	public JogadoresEditar() {
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
		panel.setBackground(new Color(0x274360));
		panel.setBounds(0, 98, 736, 64);
		painelConteudo.add(panel);
		panel.setLayout(null);

		//Criando JList com times que aparecerão para o usuário
		JScrollPane painelTimes = new JScrollPane();
		
		for(int i = 0; i < 20; i++) {
			listaDeTimesModelo.addElement(brasileirao.getTimes().get(i).getNome());
		}
		
		painelPartidasScroll = new JScrollPane();
		painelPartidas = new JPanel();
		painelPartidas.setBackground(new Color(0, 0, 128));
		painelPartidasScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		painelPartidasScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		painelPartidasScroll.setVisible(true);
		painelPartidasScroll.setViewportView(painelPartidas);
		painelPartidasScroll.setBounds(170,200,400, 300);
		painelConteudo.add(painelPartidasScroll);
		painelPartidas.setLayout(null);
		
		painelTimes.setBounds(267, 0, 197, 64);
		listaDeTimes = new JList<String>(listaDeTimesModelo);
		//Atualizar o que a tela mostra de acordo com a escolha do time
		listaDeTimes.addListSelectionListener((event)->{
			painelPartidas.removeAll();
			botoesEditar.clear();
			int contador = 0;
			for(int i = 0; i < 20; i++) {
				if(listaDeTimes.getSelectedValue() == brasileirao.getTimes().get(i).getNome()) {
					for(int j = 0; j < brasileirao.getTimes().get(i).getJogadoresSize(); j++) {
						int index = i;
						int index2 = j;
						botoesEditar.add(new JButton(brasileirao.getTimes().get(i).getJogadores(j).getNome()));
						botoesEditar.get(contador).setBounds(new Rectangle(0, contador*70, 400, 60));
						botoesEditar.get(contador).setFont(new Font("Arial Black", Font.PLAIN, 11));
						painelPartidas.add(botoesEditar.get(contador));
						botoesEditar.get(contador).addActionListener( new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								//Colocando o Painel como invisivel
								painelPartidas.setVisible(false);
								painelPartidasScroll.setVisible(false);
								botaoVoltar.setVisible(false);
								panel.setVisible(false);
								
								editarJogador(brasileirao.getTimes().get(index).getJogadores(index2));
								
							}
						});
						contador++;
					}
					painelPartidas.setPreferredSize(new Dimension(600, contador*70));
				}
			}
			
			painelPartidasScroll.setVisible(false);
			painelPartidasScroll.setVisible(true);
		});
		painelTimes.setViewportView(listaDeTimes);
		panel.add(painelTimes);
		
	}
	
	/**
	 *  metodo que puxa o painel de Criar Jogadores com as informações do jogador já inseridas nos imputs
	 * 
	 * @param jogadorEscolhido no painel inicial
	 */
	private void editarJogador(Jogador jogadorEscolhido) {
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
		
		listagemTime = new JList(listaTimes);
		listagemTime.setFont(new Font("Arial Black", Font.PLAIN, 11));
		listagemTime.setBounds(136, 256, 197, 112);
		painelCadastro.add(listagemTime);
		
		JScrollPane listaTimesScroll = new JScrollPane(listagemTime);
		painelCadastro.add(listaTimesScroll);
		listaTimesScroll.setSize(197, 112);
		listaTimesScroll.setLocation(136, 256);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTime.setBounds(25, 260, 101, 24);
		painelCadastro.add(lblTime);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Arial", Font.PLAIN, 20));
		lblIdade.setBounds(25, 106, 101, 24);
		painelCadastro.add(lblIdade);
		
	
		spnIdade.setBounds(136, 106, 49, 26);
		spnIdade.setModel(new SpinnerNumberModel((double)jogadorEscolhido.getIdade(), 18.0, 100.0, 1.0));
		painelCadastro.add(spnIdade);
		
		JLabel lblPosicao = new JLabel("Posição");
		lblPosicao.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPosicao.setBounds(25, 166, 101, 24);
		painelCadastro.add(lblPosicao);
		
		//Instanciando a Lista de posicões
		listaPosicao.addElement(Posicao.ATACANTE);
		listaPosicao.addElement(Posicao.GOLEIRO);
		listaPosicao.addElement(Posicao.LATERAL);
		listaPosicao.addElement(Posicao.MEIA);
		listaPosicao.addElement(Posicao.PONTA);
		listaPosicao.addElement(Posicao.VOLANTE);
		listaPosicao.addElement(Posicao.ZAGUEIRO);
		

		listagemPosicao = new JList(listaPosicao);
		listagemPosicao.setFont(new Font("Arial Black", Font.PLAIN, 11));
		listagemPosicao.setBounds(136, 166, 358, 80);
		painelCadastro.add(listagemPosicao);
		
		JScrollPane srclPosicao = new JScrollPane(listagemPosicao);
		painelCadastro.add(srclPosicao);
		srclPosicao.setSize(197, 80);
		srclPosicao.setLocation(136, 166);
		
		
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
		
		//Botao de criar O Jogador
		botaoCriar.setBounds(551, 520, 175, 33);
		botaoCriar.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoCriar.setVisible(true);
		painelConteudo.add(botaoCriar);
		
		botaoCriar.addActionListener((event) -> {
			//Conferindo se os dados do Jogador foram adcionados
			if(!listagemPosicao.isSelectionEmpty() && !listagemTime.isSelectionEmpty() && !txtNome.getText().isBlank()) {			
				setPosicaoJogador( (Posicao) listagemPosicao.getSelectedValue());
				
				//Funcao que cria o jogador
				ControleJogadores.atualizandoJogador(listagemTime, txtNome, brasileirao, this, spnIdade);
				this.dispose();
				JogadoresVer.main(null);
			}
		});
	}
	
	
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
		return painelPartidas;
	}

	public void setPainelPartidas(JPanel painelPartidas) {
		this.painelPartidas = painelPartidas;
	}

	public JScrollPane getPainelPartidasScroll() {
		return painelPartidasScroll;
	}

	public void setPainelPartidasScroll(JScrollPane painelPartidasScroll) {
		this.painelPartidasScroll = painelPartidasScroll;
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
}
