package visao;

import modelo.*;
import bancoDeDados.*;

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

public class PartidasCriar extends JFrame {

	private JPanel painelConteudo, painelGoleadores;
	private JScrollPane painelScrollGoleadores;
	private Listas brasileirao = new Listas();
	private int golsCasa, golsFora;
	private Time timeCasa, timeFora;
	private Estadios estadio;
	private int golasd, index;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartidasCriar frame = new PartidasCriar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
			brasileirao.inicializarTimes();
			DefaultListModel listaTimes = new DefaultListModel();
			DefaultListModel listaTimes2 = new DefaultListModel();
			DefaultListModel listaJogadores1 = new DefaultListModel();
			DefaultListModel listaJogadores2 = new DefaultListModel();
			
			for(int i = 0; i < 20; i++) {
				listaTimes.addElement(brasileirao.getTimes().get(i).getNome());
				
			}
			
			JList timeCasa = new JList(listaTimes);
			timeCasa.setFont(new Font("Arial Black", Font.PLAIN, 11));
			timeCasa.setBounds(52, 183, 197, 45);
			painelConteudo.add(timeCasa);
			
			
			timeCasa.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent evt) {
					listaTimes2.clear();
					for(int j = 0; j < 20; j++) {
						if(timeCasa.getSelectedValue() != brasileirao.getTimes().get(j).getNome()) {
							listaTimes2.addElement(brasileirao.getTimes().get(j).getNome());
						}
					}
					painelConteudo.setVisible(false);
					painelConteudo.setVisible(true);
				}
			});
			
			JList timeFora = new JList(listaTimes2);
			timeFora.setFont(new Font("Arial Black", Font.PLAIN, 11));
			timeFora.setBounds(490, 183, 197, 45);
			painelConteudo.add(timeFora);
			
			//Lista de times com scroll
			JScrollPane listaTimesScroll1 = new JScrollPane(timeCasa);
			JScrollPane listaTimesScroll2 = new JScrollPane(timeFora);
			painelConteudo.add(listaTimesScroll1);
			listaTimesScroll1.setSize(197, 45);
			listaTimesScroll1.setLocation(52, 183);
			painelConteudo.add(listaTimesScroll2);
			listaTimesScroll2.setSize(197, 45);
			listaTimesScroll2.setLocation(490, 183);
			
			SpinnerNumberModel modeloGolsCasa = new SpinnerNumberModel(0, 0, 100, 1);
			JSpinner golsCasa = new JSpinner(modeloGolsCasa);
			golsCasa.setBounds(248, 183, 47, 45);
			painelConteudo.add(golsCasa);
			
			SpinnerNumberModel modeloGolsFora = new SpinnerNumberModel(0, 0, 100, 1);
			JSpinner golsFora = new JSpinner(modeloGolsFora);
			golsFora.setBounds(445, 183, 47, 45);
			painelConteudo.add(golsFora);
			
			JButton botaoProximo = new JButton("Proximo");
			painelConteudo.add(botaoProximo);
			botaoProximo.setBounds(512, 492, 175, 33);
			botaoProximo.setFont(new Font("Arial", Font.PLAIN, 20));
			
			//Adicionando itens para a escolha do estadio
			DefaultListModel<Estadios> demoList = new DefaultListModel<Estadios>();
			for(int i = 0; i < 19; i++) {
				demoList.addElement(Estadios.values()[i]);
				
			}
			
			JList<Estadios> estadios = new JList<Estadios>(demoList);
			estadios.setFont(new Font("Arial Black", Font.PLAIN, 11));
			estadios.setBounds(266, 196, 197, 158);
			
			//Lista de estadios com scroll
			JScrollPane listaEstadios = new JScrollPane(estadios);
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
			
			SpinnerNumberModel modelo = new SpinnerNumberModel(1, 1, 38.0, 1.0);
			JSpinner spinnerRodada = new JSpinner(modelo);
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
			JButton botaoCriar = new JButton("Criar");
			painelConteudo.add(botaoCriar);
			botaoCriar.setBounds(512, 492, 175, 33);
			botaoCriar.setFont(new Font("Arial", Font.PLAIN, 20));
			botaoCriar.setVisible(false);
			
			//Lista de JList dos goleadores
			ArrayList<JList> listaDeListas1 = new ArrayList<JList>();
			ArrayList<JList> listaDeListas2 = new ArrayList<JList>();
			
			//Lista de JScrollPane, onde cada JScrollPane terá um JList
			ArrayList<JScrollPane> listaDePaineis1 = new ArrayList<JScrollPane>();
			ArrayList<JScrollPane> listaDePaineis2 = new ArrayList<JScrollPane>();
			
			//Botao para mudar a tela do placar para a tela dos goleadores da partida
			botaoProximo.addActionListener((event) -> {
				if((timeCasa.isSelectionEmpty() == false) && (timeFora.isSelectionEmpty() == false) && (estadios.isSelectionEmpty() == false)) {
					listaTimesScroll1.setVisible(false);
					listaTimesScroll2.setVisible(false);
					textoTimeCasa.setVisible(false);
					golsCasa.setVisible(false);
					this.setGolsCasa((Integer) golsCasa.getValue());
					textoTimeFora.setVisible(false);
					golsFora.setVisible(false);
					this.setGolsFora((Integer) golsFora.getValue());
					textoX.setVisible(false);
					textoRodada.setVisible(false);
					spinnerRodada.setVisible(false);
					listaEstadios.setVisible(false);
					botaoProximo.setVisible(false);
					this.jogadoresParaGols(timeCasa, listaJogadores1);
					
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
					
					this.jogadoresParaGols(timeFora, listaJogadores2);
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
					String timeCasaString, timeForaString;
					estadio = estadios.getSelectedValue();
					golasd = (int) Math.round((double) spinnerRodada.getValue());
					timeCasaString = (String) timeCasa.getSelectedValue();
					timeForaString = (String) timeFora.getSelectedValue();
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
			botaoCriar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Listas.partidas.add(new Partida(getTimeCasa(), getTimeFora(), estadio));
					index = Listas.partidas.size()-1;
					for(int i = 0; i < getGolsCasa(); i ++) {
						for(int j = 0; j < getTimeCasa().getJogadoresSize(); j++) {
							if(getTimeCasa().getJogadores(j) != null && listaDeListas1.get(i).getSelectedValue() == getTimeCasa().getJogadores(j).getNome()) {
								for(int k = 0; k < 20; k++) {
									if(Listas.times.get(k) == getTimeCasa()) {
										Listas.times.get(k).getJogadores(j).fazerGol();
										Listas.partidas.get(index).addGolCasa(getTimeCasa().getJogadores(j));
									}
								}
							}
						}		
					}
					for(int i = 0; i < getGolsFora(); i ++) {
						for(int j = 0; j < 11; j++) {
							if(getTimeFora().getJogadores(j) != null && listaDeListas2.get(i).getSelectedValue() == getTimeFora().getJogadores(j).getNome()) {
								for(int k = 0; k < 20; k++) {
									if(Listas.times.get(k) == getTimeFora()) {
										Listas.times.get(k).getJogadores(j).fazerGol();
										Listas.partidas.get(index).addGolFora(getTimeFora().getJogadores(j));
									}
								}
							}
						}		
					}
					Listas.partidas.get(index).finalizarPartida2(getGolsCasa(), getGolsFora(), golasd);
					
					dispose();
					Menu.main(null);
				}
			});
			
		}
	
	//Funcao que tira os jogadores do time e coloca ele na JList dos goleadores
	 public void jogadoresParaGols(JList listaTime, DefaultListModel listaJogadores) {
		String time = listaTime.getSelectedValue().toString();
		
		for(int i = 0; i < 20; i++) {
			if(brasileirao.getTimes().get(i).getNome() == time) {
				for(int j = 0; j < brasileirao.getTimes().get(i).getJogadoresSize(); j++) {
					if(brasileirao.getTimes().get(i).getJogadores(j) != null) {
						listaJogadores.addElement(brasileirao.getTimes().get(i).getJogadores(j).getNome());
					}
				}
			}
		}
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
