package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import bancoDeDados.Listas;
import controlador.ControlePartidas;
import modelo.Jogador;
import modelo.Partida;
import modelo.Time;

import javax.swing.JSpinner;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.Dimension;
/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;*/

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import java.awt.Cursor;
import java.awt.Dimension;

/**
 * Tela responsável por verr uma partida do banco de dados
 * @author Lucas Bergholz
 * @author Guilherme Rodrigues
 * @see Listas
 * @see Partida
 * @see Jogador
 * @see Time
 */
public class PartidasTabelaRodadasJTables extends JFrame {

	private JPanel painelConteudo;
	private Listas brasileirao = new Listas();

	/**
	 * Método de inicializacao da tela de ver partida.
	 */
	public static void main(String[] args) {
		PartidasTabelaRodadasJTables frame = new PartidasTabelaRodadasJTables();
		frame.setVisible(true);
	}

	/**
	 * Construtor da tela de ver partida, responsavel por instanciar os componentes visuais e seus valores internos.
	 * @see PartidasTabelaRodadasJTables
	 */
	public PartidasTabelaRodadasJTables() {
		//Padronizando o frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 750, 600);
		setTitle("BRASILEIRAO 2022");
		setResizable(false);
		painelConteudo = new JPanel();
		painelConteudo.setBounds(0, 0, 750, 1200);
		painelConteudo.setBackground(new Color(0, 0, 128));
		painelConteudo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelConteudo);
		painelConteudo.setLayout(null);
		
		//Voltar pro menu
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBounds(10, 35, 85, 21);
		painelConteudo.add(botaoVoltar);
		botaoVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				PartidasMenu.main(null);
			}
		});
		
		//Criando os blocos das partidas
		
		JPanel painelRodadas = new JPanel();
		painelRodadas.setBackground(new Color(0x274360));
		painelRodadas.setBounds(0, 78, 736, 64);
		painelConteudo.add(painelRodadas);
		painelRodadas.setLayout(null);
		
		//Label que indica a utilidade do Spinner
		JLabel lblSpinner = new JLabel("RODADA");
		lblSpinner.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSpinner.setBounds(304, 10, 100, 40);
		painelRodadas.add(lblSpinner);
		
		//Criando o Spinner que controla a Rodada que será mostrada no Frame
		JSpinner spnRodada = new JSpinner();
		spnRodada.setFont(new Font("Arial", Font.PLAIN, 20));
		spnRodada.setBounds(304, 10, 126, 40);
		spnRodada.setModel(new SpinnerNumberModel(0.0, 0.0, 38.0, 1.0));
		painelRodadas.add(spnRodada);
		
		//Texto auxiliar
		JLabel titulo = new JLabel("PARTIDAS");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		titulo.setBounds(0, 0, 736, 83);
		painelConteudo.add(titulo);
		
		//Recebendo o dados necessarios para instanciar os componentes
		int numPartidas = brasileirao.getPartidas().size();
		int rod =(int) Math.round((double) spnRodada.getValue());
		
		//Instanciando listas de JPanels que serao adicionados paineis de acordo com o numero de partidas da rodada correspondente
		List<JPanel> listaPainelPartidas = new ArrayList<>();
		List<JLabel> labels = new ArrayList<>();
		//Painel scroll das partidas
		JScrollPane caixaVertical = new JScrollPane();
		caixaVertical.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPanel caixaDentroCaixa = new JPanel();
		caixaDentroCaixa.setBackground(new Color(0, 0, 128));
		caixaDentroCaixa.setLayout(null);
		caixaDentroCaixa.setPreferredSize(new Dimension(600, numPartidas*110));
		caixaVertical.setSize(587, 350);
		painelConteudo.add(caixaVertical);
		caixaVertical.setLocation(70, 179);
		caixaVertical.setViewportView(caixaDentroCaixa);
		
		//Metodos
		//Funcao que muda a posicao vertical dos elementos durante o scroll
		spnRodada.addChangeListener((event) -> {
			ControlePartidas.partidasVer(spnRodada, caixaVertical, caixaDentroCaixa, numPartidas, brasileirao);
		});
		
		
		//Realocando o valor do spinner para Rodada 01
		spnRodada.setValue(1.0);
		//Definindo o Novo minimo para a Primeira Rodada
		spnRodada.setModel(new SpinnerNumberModel(1.0, 1.0, 38.0, 1.0));
	}
}
