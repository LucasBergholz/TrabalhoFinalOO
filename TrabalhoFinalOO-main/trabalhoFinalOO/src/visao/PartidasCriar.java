package visao;

import modelo.*;
import bancoDeDados.*;
import controlador.ControlePartidas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Tela responsável por criar uma partida no banco de dados
 * @author Lucas Bergholz
 * @author Guilherme Rodrigues
 * @see Listas
 * @see Partida
 * @see Jogador
 * @see Time
 */
public class PartidasCriar extends JFrame {

	//Atributos
	private Listas brasileirao = new Listas();
	private int golsCasa, golsFora;
	private Time timeCasa, timeFora;
	private Estadios estadio;
	private int valorRodada, index;

	//Componentes Visuais 
	private JPanel painelConteudo, painelGoleadores;
	private JScrollPane painelScrollGoleadores;
	private JButton botaoProximo = new JButton("Proximo");
	private JButton botaoCriar = new JButton("Criar");
	private JSpinner spnGolsCasa = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
	private JSpinner spnGolsFora = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
	private JSpinner spinnerRodada = new JSpinner(new SpinnerNumberModel(1, 1, 38, 1));
	
	//Listas
	private DefaultListModel listaTimes = new DefaultListModel();
	private DefaultListModel listaTimes2 = new DefaultListModel();
	private DefaultListModel listaJogadores1 = new DefaultListModel();
	private DefaultListModel listaJogadores2 = new DefaultListModel();
	private DefaultListModel<Estadios> listaDefaultEstadios;
	private JList timesCasa;
	private JList timesFora;
	private JList<Estadios> jListEstadios;
	//Lista de JList dos goleadores
	private ArrayList<JList> listaDeListas1 = new ArrayList<JList>();
	private ArrayList<JList> listaDeListas2 = new ArrayList<JList>();
	
	//Lista de JScrollPane, onde cada JScrollPane terá um JList
	private ArrayList<JScrollPane> listaDePaineis1 = new ArrayList<JScrollPane>();
	private ArrayList<JScrollPane> listaDePaineis2 = new ArrayList<JScrollPane>();
	
	/**
	 * Método de inicializacao da tela de criar partida.
	 */
	public static void main(String[] args) {
		PartidasCriar frame = new PartidasCriar();
		frame.setVisible(true);
	}


	/**
	 * Construtor da tela de criar partida, responsavel por instanciar os componentes visuais e seus valores internos.
	 * @see PartidasCriar
	 */
	public PartidasCriar() {
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
		
		//Botao para voltar para o menu de partidas
		JButton botaoVoltar = new JButton("Voltar");
		getContentPane().add(botaoVoltar);
		botaoVoltar.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoVoltar.setBounds(34, 35, 101, 33);
		botaoVoltar.addActionListener((event) -> {
			this.dispose();
			PartidasMenu.main(null);
		});
		
		//Titulo para a pagina
		JLabel titulo = new JLabel("CRIAR PARTIDA");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		titulo.setBounds(0, 0, 751, 100);
		painelConteudo.add(titulo);
		
		//Textos para o usuario entender a pagina
		JTextPane textoTimeCasa = new JTextPane();
		textoTimeCasa.setText("Time de Casa");
		textoTimeCasa.setEditable(false);
		textoTimeCasa.setForeground(Color.WHITE);
		textoTimeCasa.setFont(new Font("Arial", Font.PLAIN, 25));
		textoTimeCasa.setBackground(new Color(0, 0, 128));
		textoTimeCasa.setBounds(52, 148, 164, 35);
		painelConteudo.add(textoTimeCasa);
		
		JTextPane textoTimeFora = new JTextPane();
		textoTimeFora.setText("Time de Fora");
		textoTimeFora.setEditable(false);
		textoTimeFora.setForeground(Color.WHITE);
		textoTimeFora.setFont(new Font("Arial", Font.PLAIN, 25));
		textoTimeFora.setBackground(new Color(0, 0, 128));
		textoTimeFora.setBounds(523, 148, 164, 35);
		painelConteudo.add(textoTimeFora);
		
		JTextPane textoX = new JTextPane();
		textoX.setText("X");
		textoX.setEditable(false);
		textoX.setForeground(Color.WHITE);
		textoX.setFont(new Font("Arial", Font.PLAIN, 25));
		textoX.setBackground(new Color(0, 0, 128));
		textoX.setBounds(358, 188, 24, 35);
		painelConteudo.add(textoX);
		
		//Usuario escolher os times e o placar
		
		//Adicionando itens para a escolha do estadio
		
		//Loop que retira o nome dos times do banco de dados
		for(int i = 0; i < 20; i++) {
			listaTimes.addElement(brasileirao.getTimes().get(i).getNome());	
		}
		//JList com os times do banco de dados
		timesCasa = new JList(listaTimes);
		timesCasa.setFont(new Font("Arial Black", Font.PLAIN, 11));
		timesCasa.setBounds(52, 183, 197, 45);
		painelConteudo.add(timesCasa);
		
		//Funcao que evita o usuario escolher o mesmo time duas vezes para a partida
		timesCasa.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				//Limpa a lista do time de fora de casa
				listaTimes2.clear();
				for(int j = 0; j < 20; j++) {
					//Caso o time "i" seja igual ao selecionado pelo usuario, nao sera adicionado na nova lista de times fora de casa
					if(timesCasa.getSelectedValue() != brasileirao.getTimes().get(j).getNome()) {
						listaTimes2.addElement(brasileirao.getTimes().get(j).getNome());
					}
				}
				//Muda visibilidade para atualizar conteudo da pagina
				painelConteudo.setVisible(false);
				painelConteudo.setVisible(true);
			}
		});
		
		//Instanciando JList de times fora de casa
		timesFora  = new JList(listaTimes2);
		timesFora.setFont(new Font("Arial Black", Font.PLAIN, 11));
		timesFora.setBounds(490, 183, 197, 45);
		painelConteudo.add(timesFora);
		
		//Lista de times com scroll
		JScrollPane listaTimesScroll1 = new JScrollPane(timesCasa);
		JScrollPane listaTimesScroll2 = new JScrollPane(timesFora);
		painelConteudo.add(listaTimesScroll1);
		listaTimesScroll1.setSize(197, 45);
		listaTimesScroll1.setLocation(52, 183);
		painelConteudo.add(listaTimesScroll2);
		listaTimesScroll2.setSize(197, 45);
		listaTimesScroll2.setLocation(490, 183);
		
		//Definindo tamanho dos spinners de gols
		spnGolsCasa.setBounds(248, 183, 47, 45);
		painelConteudo.add(spnGolsCasa);
		
		spnGolsFora.setBounds(445, 183, 47, 45);
		painelConteudo.add(spnGolsFora);
		
		//Adicionando estilizacao do botao de proximo
		painelConteudo.add(botaoProximo);
		botaoProximo.setBounds(512, 492, 175, 33);
		botaoProximo.setFont(new Font("Arial", Font.PLAIN, 20));
		
		//Adicionando itens em uma lista para a escolha do estadio
		listaDefaultEstadios = new DefaultListModel<Estadios>();
		for(int i = 0; i < 19; i++) {
			listaDefaultEstadios.addElement(Estadios.values()[i]);
			
		}
		
		//Instanciando JList de estadios
		jListEstadios = new JList<Estadios>(listaDefaultEstadios);
		jListEstadios.setFont(new Font("Arial Black", Font.PLAIN, 11));
		jListEstadios.setBounds(266, 196, 197, 158);
		
		//Lista de estadios com scroll
		JScrollPane listaEstadios = new JScrollPane(jListEstadios);
		listaEstadios.setLocation(490, 300);
		listaEstadios.setSize(195, 152);
		painelConteudo.add(listaEstadios);
		
		//Texto auxiliar ao usuario
		JTextPane textoRodada = new JTextPane();
		textoRodada.setFont(new Font("Arial", Font.PLAIN, 25));
		textoRodada.setForeground(new Color(255, 255, 255));
		textoRodada.setText("Rodada");
		textoRodada.setBackground(new Color(0, 0, 128));
		textoRodada.setBounds(56, 345, 95, 35);
		painelConteudo.add(textoRodada);
		
		//Estilizando spinner da rodada
		spinnerRodada.setBounds(149, 345, 46, 33);
		painelConteudo.add(spinnerRodada);
		
		//Criando painel secundario para os goleadores
		
		//Painel com o conteudo dos goleadores
		painelGoleadores = new JPanel();
		painelGoleadores.setBackground(new Color(0, 0, 128));
		painelGoleadores.setLocation(0, 0);
		painelGoleadores.setSize(600, 500);
		painelGoleadores.setVisible(true);
		
		//Painel com scroll que contera o painel dos goleadores
		painelScrollGoleadores = new JScrollPane();
		painelScrollGoleadores.setBackground(new Color(0, 0, 128));
		painelScrollGoleadores.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		painelScrollGoleadores.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		painelScrollGoleadores.setVisible(false);
		painelScrollGoleadores.setViewportView(painelGoleadores);
		painelScrollGoleadores.setBounds(60,180,600, 300);
		painelGoleadores.setPreferredSize(new Dimension(600, 1500));
		painelConteudo.add(painelScrollGoleadores);
		painelGoleadores.setLayout(null);
		
		//Texto auxiliar ao usuario
		JTextPane textoGoleadoresCasa = new JTextPane();
		textoGoleadoresCasa.setText("Escolha os goleadores do jogo:");
		textoGoleadoresCasa.setForeground(Color.WHITE);
		textoGoleadoresCasa.setFont(new Font("Arial", Font.PLAIN, 25));
		textoGoleadoresCasa.setEditable(false);
		textoGoleadoresCasa.setVisible(false);
		textoGoleadoresCasa.setBackground(new Color(0, 0, 128));
		textoGoleadoresCasa.setBounds(185, 111, 366, 35);
		painelConteudo.add(textoGoleadoresCasa);
		
		
		//Botao de criar a partida
		painelConteudo.add(botaoCriar);
		botaoCriar.setBounds(512, 492, 175, 33);
		botaoCriar.setFont(new Font("Arial", Font.PLAIN, 20));
		botaoCriar.setVisible(false);
		
		
		
		//Botao para mudar a tela do placar para a tela dos goleadores da partida
		botaoProximo.addActionListener((event) -> {
			//Garantindo que todos os dados necessarios foram escolhidos pelo usuario
			if((timesCasa.isSelectionEmpty() == false) && (timesFora.isSelectionEmpty() == false) && (jListEstadios.isSelectionEmpty() == false)) {
				//Trocando visibilidade de todos os componentes da pagina
				listaTimesScroll1.setVisible(false);
				listaTimesScroll2.setVisible(false);
				textoTimeCasa.setVisible(false);
				spnGolsCasa.setVisible(false);
				this.setGolsCasa((Integer) spnGolsCasa.getValue());
				textoTimeFora.setVisible(false);
				spnGolsFora.setVisible(false);
				this.setGolsFora((Integer) spnGolsFora.getValue());
				textoX.setVisible(false);
				textoRodada.setVisible(false);
				spinnerRodada.setVisible(false);
				listaEstadios.setVisible(false);
				botaoProximo.setVisible(false);

				//Funcao de adicionar os gols ao jogador
				ControlePartidas.partidasCriarJogadoresGols(timesCasa, listaJogadores1, brasileirao);
				//De acordo com o valor que o usuario escolheu para os gols, printar na tela "n" JLists com os jogadores do time
				for(int i = 0; i < getGolsCasa(); i++) {
					listaDeListas1.add(i, new JList<String>(listaJogadores1));
					listaDeListas1.get(i).setBounds(new Rectangle(0, (i*60), 200, 60));
					listaDeListas1.get(i).setFont(new Font("Arial Black", Font.PLAIN, 11));
					listaDePaineis1.add(i, new JScrollPane());
					listaDePaineis1.get(i).setBounds(new Rectangle(0, (i*70), 180, 60));
					listaDePaineis1.get(i).setViewportView(listaDeListas1.get(i));
					listaDePaineis1.get(i).setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					painelGoleadores.add(listaDePaineis1.get(i));
				}
				
				//Repetindo o processo anterior mas com o time fora de casa
				ControlePartidas.partidasCriarJogadoresGols(timesFora, listaJogadores2, brasileirao);
				for(int i = 0; i < getGolsFora(); i++) {
					listaDeListas2.add(i, new JList<String>(listaJogadores2));
					listaDeListas2.get(i).setBounds(new Rectangle(0, (i*60), 200, 60));
					listaDeListas2.get(i).setFont(new Font("Arial Black", Font.PLAIN, 11));
					listaDePaineis2.add(i, new JScrollPane());
					listaDePaineis2.get(i).setBounds(new Rectangle(410, (i*70), 180, 60));
					listaDePaineis2.get(i).setViewportView(listaDeListas2.get(i));
					listaDePaineis2.get(i).setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					painelGoleadores.add(listaDePaineis2.get(i));
				}
				
				botaoCriar.setVisible(true);
				painelScrollGoleadores.setVisible(true);
				textoGoleadoresCasa.setVisible(true);	
				//Passando os dados para os atributos do painel
				String timeCasaString, timeForaString;
				estadio = jListEstadios.getSelectedValue();
				valorRodada = (int)spinnerRodada.getValue();
				//String auxiliar no salvamento do dado do time no atributo
				timeCasaString = (String) timesCasa.getSelectedValue();
				timeForaString = (String) timesFora.getSelectedValue();
				for(int j = 0; j < 20; j++) {
					if(timeCasaString == brasileirao.getTimes().get(j).getNome()) {
						setTimeCasa(brasileirao.getTimes().get(j));
					} else if(timeForaString == brasileirao.getTimes().get(j).getNome()) {
						setTimeFora(brasileirao.getTimes().get(j));
					}
				}
			}
		});
			
		
		
		//Funcao de criar partida
		botaoCriar.addActionListener((event) -> {
			ControlePartidas.partidasCriar(this, listaDeListas1, listaDeListas2);
			
		});
		
	}
	
	
	//Getters & Setters
	public JSpinner getSpinnerRodada() {
		return spinnerRodada;
	}

	public void setSpinnerRodada(JSpinner spinnerRodada) {
		this.spinnerRodada = spinnerRodada;
	}

	public JList getTimesFora() {
		return timesFora;
	}

	public void setTimesFora(JList timesFora) {
		this.timesFora = timesFora;
	}

	public ArrayList<JList> getListaDeListas1() {
		return listaDeListas1;
	}

	public void setListaDeListas1(ArrayList<JList> listaDeListas1) {
		this.listaDeListas1 = listaDeListas1;
	}

	public ArrayList<JList> getListaDeListas2() {
		return listaDeListas2;
	}

	public void setListaDeListas2(ArrayList<JList> listaDeListas2) {
		this.listaDeListas2 = listaDeListas2;
	}

	public ArrayList<JScrollPane> getListaDePaineis1() {
		return listaDePaineis1;
	}

	public void setListaDePaineis1(ArrayList<JScrollPane> listaDePaineis1) {
		this.listaDePaineis1 = listaDePaineis1;
	}

	public ArrayList<JScrollPane> getListaDePaineis2() {
		return listaDePaineis2;
	}

	public void setListaDePaineis2(ArrayList<JScrollPane> listaDePaineis2) {
		this.listaDePaineis2 = listaDePaineis2;
	}

	public Listas getBrasileirao() {
		return brasileirao;
	}

	public void setBrasileirao(Listas brasileirao) {
		this.brasileirao = brasileirao;
	}

	public Estadios getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadios estadio) {
		this.estadio = estadio;
	}

	public int getValorRodada() {
		return valorRodada;
	}

	public void setValorRodada(int valorRodada) {
		this.valorRodada = valorRodada;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public JPanel getPainelConteudo() {
		return painelConteudo;
	}

	public void setPainelConteudo(JPanel painelConteudo) {
		this.painelConteudo = painelConteudo;
	}

	public JPanel getPainelGoleadores() {
		return painelGoleadores;
	}

	public void setPainelGoleadores(JPanel painelGoleadores) {
		this.painelGoleadores = painelGoleadores;
	}

	public JScrollPane getPainelScrollGoleadores() {
		return painelScrollGoleadores;
	}

	public void setPainelScrollGoleadores(JScrollPane painelScrollGoleadores) {
		this.painelScrollGoleadores = painelScrollGoleadores;
	}

	public JButton getBotaoProximo() {
		return botaoProximo;
	}

	public void setBotaoProximo(JButton botaoProximo) {
		this.botaoProximo = botaoProximo;
	}

	public JButton getBotaoCriar() {
		return botaoCriar;
	}

	public void setBotaoCriar(JButton botaoCriar) {
		this.botaoCriar = botaoCriar;
	}

	public JSpinner getSpnGolsCasa() {
		return spnGolsCasa;
	}

	public void setSpnGolsCasa(JSpinner spnGolsCasa) {
		this.spnGolsCasa = spnGolsCasa;
	}

	public JSpinner getSpnGolsFora() {
		return spnGolsFora;
	}

	public void setSpnGolsFora(JSpinner spnGolsFora) {
		this.spnGolsFora = spnGolsFora;
	}

	public DefaultListModel getListaTimes() {
		return listaTimes;
	}

	public void setListaTimes(DefaultListModel listaTimes) {
		this.listaTimes = listaTimes;
	}

	public DefaultListModel getListaTimes2() {
		return listaTimes2;
	}

	public void setListaTimes2(DefaultListModel listaTimes2) {
		this.listaTimes2 = listaTimes2;
	}

	public DefaultListModel getListaJogadores1() {
		return listaJogadores1;
	}

	public void setListaJogadores1(DefaultListModel listaJogadores1) {
		this.listaJogadores1 = listaJogadores1;
	}

	public DefaultListModel getListaJogadores2() {
		return listaJogadores2;
	}

	public void setListaJogadores2(DefaultListModel listaJogadores2) {
		this.listaJogadores2 = listaJogadores2;
	}

	public JList<Estadios> getjListEstadios() {
		return jListEstadios;
	}

	public void setjListEstadios(JList<Estadios> jListEstadios) {
		this.jListEstadios = jListEstadios;
	}

	public JList getTimesCasa() {
		return timesCasa;
	}

	public void setTimesCasa(JList timesCasa) {
		this.timesCasa = timesCasa;
	}

	public int getGolsCasa() {
		return golsCasa;
	}

	public void setGolsCasa(int golsCasa) {
		this.golsCasa = golsCasa;
	}

	public int getGolsFora() {
		return golsFora;
	}

	public void setGolsFora(int golsFora) {
		this.golsFora = golsFora;
	}

	public Time getTimeCasa() {
		return timeCasa;
	}

	public void setTimeCasa(Time timeCasa) {
		this.timeCasa = timeCasa;
	}

	public Time getTimeFora() {
		return timeFora;
	}

	public void setTimeFora(Time timeFora) {
		this.timeFora = timeFora;
	}
}
