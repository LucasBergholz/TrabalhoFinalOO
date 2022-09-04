package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import bancoDeDados.Listas;
import controlador.ControleJogadores;
import modelo.Jogador;
import modelo.Posicao;
import modelo.Time;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JogadoresCriar extends JFrame {

	private Listas brasileirao = new Listas();
	private Time timeJog;
	private Posicao posicaoJogador;
	
	//Componentes Visuais
	private JPanel painelConteudo;
	private JTextField txtNome;
	private JSpinner spnIdade = new JSpinner();
	private JButton botaoVoltar = new JButton("Voltar");
	private JButton botaoCriar = new JButton("Criar");
	private DefaultListModel listaPosicao = new DefaultListModel();
	private JList listagemPosicao ;
	private JList listagemTime;

	/**
	 * Função da tela de criar Jogadores que instancia o Frame e o torna visivel pro usuário
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JogadoresCriar frame = new JogadoresCriar();
		frame.setVisible(true);
	}
	/**
	 * Construtor da Tela de Criar Jogadores cuja a função é instanciar os componentes visiais do frame para o usuário
	 */
	public JogadoresCriar() {
		//Adicionando titulo ao frame, tamanho e cor
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
		JLabel titulo = new JLabel("Cadastrar Jogador");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		titulo.setBounds(0, 0, 751, 100);
		painelConteudo.add(titulo);
		
		//Criando o painel onde vai ser cadastrado o jogador
		JPanel painelCadastro = new JPanel();
		painelCadastro.setBounds(49, 110, 635, 400);
		painelCadastro.setLayout(null);
		painelConteudo.add(painelCadastro);
		
		//Input de texto que o usuario coloca o nome do jogador
		txtNome = new JTextField();
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
		spnIdade.setModel(new SpinnerNumberModel(18.0, 18.0, 100.0, 1.0));
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
		
		
		botaoVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JogadoresMenu.main(null);
			}
		});
		
		//Botao de criar O Jogador
		botaoCriar.setBounds(551, 520, 175, 33);
		botaoCriar.setFont(new Font("Arial", Font.PLAIN, 20));
		painelConteudo.add(botaoCriar);
		
		botaoCriar.addActionListener((event) -> {
			//Conferindo se os dados do Jogador foram adcionados
			if(!listagemPosicao.isSelectionEmpty() && !listagemTime.isSelectionEmpty() && !txtNome.getText().isBlank()) {			
				setPosicaoJogador( (Posicao) listagemPosicao.getSelectedValue());
				
				//Funcao que cria o jogador
				ControleJogadores.criandoJogador(listagemTime, txtNome, brasileirao, this, spnIdade);
				this.dispose();
				JogadoresVer.main(null);
			}
		});
		
		
	}

	//Getters & Setters
	public Time getTimeJog() {
		return timeJog;
	}

	public void setTimeJog(Time timeJog) {
		this.timeJog = timeJog;
	}

	public Posicao getPosicaoJogador() {
		return posicaoJogador;
	}

	public void setPosicaoJogador(Posicao posicJog) {
		this.posicaoJogador = posicJog;
	}
	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public Listas getBrasileirao() {
		return brasileirao;
	}

	public void setBrasileirao(Listas brasileirao) {
		this.brasileirao = brasileirao;
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

}
