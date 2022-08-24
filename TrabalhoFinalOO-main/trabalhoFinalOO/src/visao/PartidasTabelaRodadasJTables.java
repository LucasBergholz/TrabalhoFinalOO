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

public class PartidasTabelaRodadasJTables extends JFrame {

	private JPanel painelConteudo;
	private Listas brasileirao = new Listas();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartidasTabelaRodadasJTables frame = new PartidasTabelaRodadasJTables();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PartidasTabelaRodadasJTables() {
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0x274360));
		panel.setBounds(0, 78, 736, 64);
		painelConteudo.add(panel);
		panel.setLayout(null);
		
		JLabel lblSpinner = new JLabel("RODADA");
		lblSpinner.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSpinner.setBounds(304, 10, 100, 40);
		panel.add(lblSpinner);
		
		JSpinner spnRodada = new JSpinner();
		spnRodada.setFont(new Font("Arial", Font.PLAIN, 20));
		spnRodada.setBounds(304, 10, 126, 40);
		spnRodada.setModel(new SpinnerNumberModel(1.0, 1.0, 38.0, 1.0));
		panel.add(spnRodada);
		
		JLabel titulo = new JLabel("PARTIDAS");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		titulo.setBounds(0, 0, 736, 83);
		painelConteudo.add(titulo);
		//Recebendo o dados necessarios para instanciar os componentes
		int numPartidas = brasileirao.getPartidas().size();
		int rod =(int) Math.round((double) spnRodada.getValue());
		int partRod = 1;
		
		for (int i = 0; i < numPartidas; i++) {
			if(brasileirao.getPartidas().get(i).getRodada() == rod) {
				partRod++;
			}	
		}
		
		
		List<JPanel> listaPainelPartidas = new ArrayList<>();
		List<JLabel> labels = new ArrayList<>();
		JScrollPane caixaVertical = new JScrollPane();
		caixaVertical.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPanel caixaDentroCaixa = new JPanel();
		caixaDentroCaixa.setBackground(new Color(0, 0, 128));
		caixaDentroCaixa.setLayout(null);
		caixaDentroCaixa.setPreferredSize(new Dimension(600, 1100));
		caixaVertical.setSize(587, 350);
		painelConteudo.add(caixaVertical);
		caixaVertical.setLocation(70, 179);
		
		for (int i = 0; i < numPartidas; i++) {
			if(brasileirao.getPartidas().get(i).getRodada() == rod) {
				Border blackline = BorderFactory.createLineBorder(Color.black, 3, true);
				
				JPanel painelPartidas = new JPanel();
				painelPartidas.setBounds(0, i*110, 570, 100);
				painelPartidas.setBackground(new Color(255,255,255));
				painelPartidas.setBorder(blackline);
				painelPartidas.setLayout(null);
				
				JLabel lblTimeCasa = new JLabel(brasileirao.getPartidas().get(i).getTimeCasa().getNome());
				lblTimeCasa.setBounds(15, 40, 103, 13);
				painelPartidas.add(lblTimeCasa);
				
				JLabel lblTimeFora = new JLabel(brasileirao.getPartidas().get(i).getTimeFora().getNome());
				lblTimeFora.setBounds(445, 40, 103, 13);
				painelPartidas.add(lblTimeFora);
				
				JLabel lblEstadio = new JLabel(brasileirao.getPartidas().get(i).getEstadio().toString());
				lblEstadio.setBounds(205, 70, 150, 13);
				painelPartidas.add(lblEstadio);
				
				JLabel lblX = new JLabel("X");
				lblX.setFont(new Font("Tahoma", Font.PLAIN, 31));
				lblX.setBounds(242, 40, 45, 13);
				painelPartidas.add(lblX);
				
				JLabel lblGolsCasa = new JLabel(Integer.toString(brasileirao.getPartidas().get(i).getGolsCasa()));
				lblGolsCasa.setBounds(175, 40, 45, 13);
				painelPartidas.add(lblGolsCasa);
				
				JLabel lblGolsFora = new JLabel(Integer.toString(brasileirao.getPartidas().get(i).getGolsFora()));
				lblGolsFora.setBounds(328, 40, 45, 13);
				painelPartidas.add(lblGolsFora);
				
				//Adcionando as Listas
				caixaDentroCaixa.add(painelPartidas);
				caixaVertical.setViewportView(caixaDentroCaixa);
			}	
		}
		
		//Metodos
		//Funcao que muda a posicao vertical dos elementos durante o scroll
		spnRodada.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int rodada =(int) Math.round((double) spnRodada.getValue());
				caixaDentroCaixa.removeAll();
				caixaDentroCaixa.setLayout(null);
				int posicaoPainel = 0;
				for (int i = 0; i < numPartidas; i++) {
					if(brasileirao.getPartidas().get(i).getRodada() == rodada) {
						Border blackline = BorderFactory.createLineBorder(Color.black, 3, true);
						
						JPanel painelPartidas = new JPanel();
						painelPartidas.setBounds(0, posicaoPainel*110, 570, 100);
						painelPartidas.setBackground(new Color(255,255,255));
						painelPartidas.setBorder(blackline);
						painelPartidas.setLayout(null);
						
						JLabel lblTimeCasa = new JLabel(brasileirao.getPartidas().get(i).getTimeCasa().getNome());
						lblTimeCasa.setBounds(15, 40, 103, 13);
						painelPartidas.add(lblTimeCasa);
						
						JLabel lblTimeFora = new JLabel(brasileirao.getPartidas().get(i).getTimeFora().getNome());
						lblTimeFora.setBounds(445, 40, 103, 13);
						painelPartidas.add(lblTimeFora);
						
						JLabel lblEstadio = new JLabel(brasileirao.getPartidas().get(i).getEstadio().toString());
						lblEstadio.setBounds(205, 70, 150, 13);
						painelPartidas.add(lblEstadio);
						
						JLabel lblX = new JLabel("X");
						lblX.setFont(new Font("Tahoma", Font.PLAIN, 31));
						lblX.setBounds(242, 40, 45, 13);
						painelPartidas.add(lblX);
						
						JLabel lblGolsCasa = new JLabel(Integer.toString(brasileirao.getPartidas().get(i).getGolsCasa()));
						lblGolsCasa.setBounds(175, 40, 45, 13);
						painelPartidas.add(lblGolsCasa);
						
						JLabel lblGolsFora = new JLabel(Integer.toString(brasileirao.getPartidas().get(i).getGolsFora()));
						lblGolsFora.setBounds(328, 40, 45, 13);
						painelPartidas.add(lblGolsFora);
						
						//Adcionando as Listas
						caixaDentroCaixa.add(painelPartidas);
						caixaVertical.setVisible(false);
						caixaVertical.setVisible(true);
						caixaVertical.setViewportView(caixaDentroCaixa);
						posicaoPainel++;
					}	
				}
			}
		
		
		});
	}
}
