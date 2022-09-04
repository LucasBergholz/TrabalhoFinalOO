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
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import bancoDeDados.Listas;
import controlador.ControlePartidas;
import modelo.Estadios;
import modelo.Partida;
import modelo.Time;

public class PartidasEditar extends JFrame {

	private Listas brasileirao = new Listas();
	private JPanel painelConteudo, painelPartidas, painelGoleadores;
	private JScrollPane painelPartidasScroll, painelScrollGoleadores;
	private JSpinner spnRodada = new JSpinner(new SpinnerNumberModel(0, 0, 38, 1));
	private int golsCasa, golsFora;
	private Time timeCasa, timeFora;
	public Estadios estadio;
	private int valorRodada, index;
	

	//ArrayList com botoes, os quais cada um representara uma partida
	private ArrayList<JButton> botoesDeletar = new ArrayList<JButton>();
	
	//Inteiro que sera usado para a confirmacao final de deletar a partida
	private Integer result;
	
	private JButton botaoProximo = new JButton("Proximo");
	private JButton botaoCriar = new JButton("Criar");
	private JSpinner spnGolsCasa = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
	private JSpinner spnGolsFora = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
	private JSpinner spinnerRodada = new JSpinner(new SpinnerNumberModel(1, 1, 38, 1));
	
	
	//Listas
	private DefaultListModel listaJogadores1 = new DefaultListModel();
	private DefaultListModel listaJogadores2 = new DefaultListModel();
	private DefaultListModel<Estadios> listaDefaultEstadios;
	private JList<Estadios> jListEstadios;
	//Lista de JList dos goleadores
	private ArrayList<JList> listaDeListas1 = new ArrayList<JList>();
	private ArrayList<JList> listaDeListas2 = new ArrayList<JList>();
	
	//Lista de JScrollPane, onde cada JScrollPane terá um JList
	private ArrayList<JScrollPane> listaDePaineis1 = new ArrayList<JScrollPane>();
	private ArrayList<JScrollPane> listaDePaineis2 = new ArrayList<JScrollPane>();


	public static void main(String[] args) {
		PartidasEditar frame = new PartidasEditar();
		frame.setVisible(true);
	}

	
	public PartidasEditar() {
		setTitle("Brasileirao 2022");
		painelConteudo = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 750, 600);
		setResizable(false);
		painelConteudo.setBackground(new Color(0, 0, 128));
		painelConteudo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelConteudo);
		painelConteudo.setLayout(null);
		
		JButton botaoVoltar = new JButton("Voltar");
		getContentPane().add(botaoVoltar);
		botaoVoltar.setFont(new Font("Arial", Font.PLAIN, 16));
		botaoVoltar.setBounds(24, 35, 85, 28);
		botaoVoltar.addActionListener((event) -> {
			this.dispose();
			PartidasMenu.main(null);
		});
		
		//Titulo para a pagina
		JLabel titulo = new JLabel("EDITAR PARTIDA");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		titulo.setBounds(0, 0, 751, 100);
		painelConteudo.add(titulo);
		
		//Criando os blocos das partidas
		JPanel painelRodadas = new JPanel();
		painelRodadas.setBackground(new Color(0x274360));
		painelRodadas.setBounds(0, 98, 736, 64);
		painelConteudo.add(painelRodadas);
		painelRodadas.setLayout(null);
		
		JLabel lblSpinner = new JLabel("RODADA");
		lblSpinner.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSpinner.setBounds(304, 10, 100, 40);
		painelRodadas.add(lblSpinner);
		
		painelPartidasScroll = new JScrollPane();
		painelPartidas = new JPanel();
		painelPartidas.setBackground(new Color(0, 0, 128));
		painelPartidasScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		painelPartidasScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		painelPartidasScroll.setVisible(true);
		painelPartidasScroll.setViewportView(painelPartidas);
		painelPartidasScroll.setBounds(170,200,400, 300);
		painelPartidas.setPreferredSize(new Dimension(600, 700));
		painelConteudo.add(painelPartidasScroll);
		painelPartidas.setLayout(null);
		
		spnRodada.setFont(new Font("Arial", Font.PLAIN, 20));
		spnRodada.setBounds(304, 10, 126, 40);
		//Atualizar o que a tela mostra de acordo com a rodada do spinner
		spnRodada.addChangeListener((event)->{
			painelPartidas.removeAll();
			botoesDeletar.clear();
			int rodada = (Integer)spnRodada.getValue();
			int contador = 0;
			for(int i = 0; i < brasileirao.getPartidas().size(); i++) {
				if(brasileirao.getPartidas().get(i).getRodada() == rodada) {
					int posicaoPartida = i;
					botoesDeletar.add(new JButton(brasileirao.getPartidas().get(i).toString()));
					botoesDeletar.get(contador).setBounds(new Rectangle(0, (contador*70), 400, 60));
					botoesDeletar.get(contador).setFont(new Font("Arial Black", Font.PLAIN, 11));
					painelPartidas.add(botoesDeletar.get(contador));
					botoesDeletar.get(contador).addActionListener( new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							//Tirando a Visibilidade de Todos os paineis de escolha
							painelRodadas.setVisible(false);
							botaoVoltar.setVisible(false);
							lblSpinner.setVisible(false);
							painelPartidasScroll.setVisible(false);
							editarPartida(brasileirao.getPartidas().get(posicaoPartida), posicaoPartida);
						}
					});
					contador++;
				}
				
			}
			
			painelPartidasScroll.setVisible(false);
			painelPartidasScroll.setVisible(true);
		});
		painelRodadas.add(spnRodada);
	}
	
	public void editarPartida(Partida partidaEscolhida, int posicaoPartida) {
		
		
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
		
		
		
		JLabel labelCasa = new JLabel(partidaEscolhida.getTimeCasa().getNome());
		JLabel labelFora = new JLabel(partidaEscolhida.getTimeFora().getNome());
		painelConteudo.add(labelCasa);
		labelCasa.setSize(197, 45);
		labelCasa.setLocation(52, 183);
		labelCasa.setFont(new Font("Arial", Font.PLAIN, 20));
		labelCasa.setForeground(Color.WHITE);
		painelConteudo.add(labelFora);
		labelFora.setSize(197, 45);
		labelFora.setLocation(523, 183);
		labelFora.setFont(new Font("Arial", Font.PLAIN, 20));
		labelFora.setForeground(Color.WHITE);
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Arial", Font.PLAIN, 16));
		botaoVoltar.setBounds(24, 35, 85, 28);
		painelConteudo.add(botaoVoltar);
		botaoVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				PartidasEditar.main(null);
			}
		});
	
		spnGolsCasa.setBounds(248, 183, 47, 45);
		spnGolsCasa.setModel(new SpinnerNumberModel((double) partidaEscolhida.getGolsCasa(), 0, 100, 1.0));
		painelConteudo.add(spnGolsCasa);
		
		spnGolsFora.setBounds(445, 183, 47, 45);
		spnGolsFora.setModel(new SpinnerNumberModel((double) partidaEscolhida.getGolsFora(), 0, 100, 1.0));
		painelConteudo.add(spnGolsFora);
		
		
		painelConteudo.add(botaoProximo);
		botaoProximo.setBounds(512, 492, 175, 33);
		botaoProximo.setFont(new Font("Arial", Font.PLAIN, 20));
		
		//Adicionando itens para a escolha do estadio
		listaDefaultEstadios = new DefaultListModel<Estadios>();
		for(int i = 0; i < 19; i++) {
			listaDefaultEstadios.addElement(Estadios.values()[i]);
			
		}
		
		jListEstadios = new JList<Estadios>(listaDefaultEstadios);
		jListEstadios.setFont(new Font("Arial Black", Font.PLAIN, 11));
		jListEstadios.setBounds(266, 196, 197, 158);
		
		//Lista de estadios com scroll
		JScrollPane listaEstadios = new JScrollPane(jListEstadios);
		listaEstadios.setLocation(490, 300);
		listaEstadios.setSize(195, 152);
		painelConteudo.add(listaEstadios);
		
		JTextPane textoRodada = new JTextPane();
		textoRodada.setFont(new Font("Arial", Font.PLAIN, 25));
		textoRodada.setForeground(new Color(255, 255, 255));
		textoRodada.setText("Rodada");
		textoRodada.setBackground(new Color(0, 0, 128));
		textoRodada.setBounds(56, 345, 95, 35);
		painelConteudo.add(textoRodada);
		

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
		//painelScrollGoleadores.setLocation(60, 180);
		painelScrollGoleadores.setBounds(60,180,600, 300);
		painelGoleadores.setPreferredSize(new Dimension(600, 1500));
		painelConteudo.add(painelScrollGoleadores);
		painelGoleadores.setLayout(null);
		
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
			if( jListEstadios.isSelectionEmpty() == false) {
				
				golsCasa = Integer.parseInt(String.format("%.0f", spnGolsCasa.getValue()));
				golsFora = Integer.parseInt(String.format("%.0f", spnGolsFora.getValue()));
				labelCasa.setVisible(false);
				labelFora.setVisible(false);
				textoTimeCasa.setVisible(false);
				spnGolsCasa.setVisible(false);
				textoTimeFora.setVisible(false);
				spnGolsFora.setVisible(false);
				textoX.setVisible(false);
				textoRodada.setVisible(false);
				spinnerRodada.setVisible(false);
				listaEstadios.setVisible(false);
				botaoProximo.setVisible(false);
				
				for(int i = 0; i < 20; i++) {
					if(brasileirao.getTimes().get(i).getNome() == partidaEscolhida.getTimeCasa().getNome()) {
						for(int j = 0; j < brasileirao.getTimes().get(i).getJogadoresSize(); j++) {
							if(brasileirao.getTimes().get(i).getJogadores(j) != null) {
								listaJogadores1.addElement(brasileirao.getTimes().get(i).getJogadores(j).getNome());
							}
						}
					}
				}
				
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
				
				for(int i = 0; i < 20; i++) {
					if(brasileirao.getTimes().get(i).getNome() == partidaEscolhida.getTimeFora().getNome()) {
						for(int j = 0; j < brasileirao.getTimes().get(i).getJogadoresSize(); j++) {
							if(brasileirao.getTimes().get(i).getJogadores(j) != null) {
								listaJogadores2.addElement(brasileirao.getTimes().get(i).getJogadores(j).getNome());
							}
						}
					}
				}
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
				estadio = jListEstadios.getSelectedValue();
				valorRodada = (int)spinnerRodada.getValue();
				
				for(int j = 0; j < 20; j++) {
					if(partidaEscolhida.getTimeCasa().getNome() == brasileirao.getTimes().get(j).getNome()) {
						setTimeCasa(brasileirao.getTimes().get(j));
					} else if(partidaEscolhida.getTimeFora().getNome() == brasileirao.getTimes().get(j).getNome()) {
						setTimeFora(brasileirao.getTimes().get(j));
					}
				}
			}
		});
	
		
		
		//Funcao de criar partida
		botaoCriar.addActionListener((event) -> {
			ControlePartidas.atualizarPartida(this, listaDeListas1, listaDeListas2, partidaEscolhida, posicaoPartida);
		});
	}
	//Getter & Setters
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


	public JSpinner getSpnRodada() {
		return spnRodada;
	}


	public void setSpnRodada(JSpinner spnRodada) {
		this.spnRodada = spnRodada;
	}


	public ArrayList<JButton> getBotoesDeletar() {
		return botoesDeletar;
	}


	public void setBotoesDeletar(ArrayList<JButton> botoesDeletar) {
		this.botoesDeletar = botoesDeletar;
	}


	public Integer getResult() {
		return result;
	}


	public void setResult(Integer result) {
		this.result = result;
	}

	public Listas getBrasileirao() {
		return brasileirao;
	}


	public void setBrasileirao(Listas brasileirao) {
		this.brasileirao = brasileirao;
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


	public JSpinner getSpinnerRodada() {
		return spinnerRodada;
	}


	public void setSpinnerRodada(JSpinner spinnerRodada) {
		this.spinnerRodada = spinnerRodada;
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


	public DefaultListModel<Estadios> getListaDefaultEstadios() {
		return listaDefaultEstadios;
	}


	public void setListaDefaultEstadios(DefaultListModel<Estadios> listaDefaultEstadios) {
		this.listaDefaultEstadios = listaDefaultEstadios;
	}


	public JList<Estadios> getjListEstadios() {
		return jListEstadios;
	}


	public void setjListEstadios(JList<Estadios> jListEstadios) {
		this.jListEstadios = jListEstadios;
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

}
