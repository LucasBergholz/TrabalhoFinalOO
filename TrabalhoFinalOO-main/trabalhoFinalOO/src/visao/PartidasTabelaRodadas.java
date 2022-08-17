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

public class PartidasTabelaRodadas extends JFrame {

	private JPanel painelConteudo;
	private Listas brasileirao = new Listas();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartidasTabelaRodadas frame = new PartidasTabelaRodadas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PartidasTabelaRodadas() {
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
		
		//Criando ScrollBar para ver o restante da tabela
		JScrollBar scrollBar = new JScrollBar();
		painelConteudo.add(scrollBar);
		scrollBar.setMaximum(1340);
		scrollBar.setBounds(719, 0, 17, 1900);
		
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
		Menu menu = new Menu();
		//Recebendo o dados necessarios para instanciar os componentes
		int numPartidas = brasileirao.getPartidas().size();
		int rod =(int) Math.round((double) spnRodada.getValue());
		int partRod = 1;
		
		for (int i = 0; i < numPartidas-1; i++) {
			if(brasileirao.getPartidas().get(i).getRodada() == rod) {
				partRod++;
			}	
		}
		
		
		List<JPanel> listaPainelPartidas = new ArrayList<>();
		List<JSeparator> separadores = new ArrayList<>();
		List<JLabel> labels = new ArrayList<>();
		Box caixaVertical = Box.createVerticalBox();
		caixaVertical.setSize(2000, 150*partRod);
		painelConteudo.add(caixaVertical);
		caixaVertical.setLocation(20, 179);
		
		for (int i = 0; i < numPartidas-1; i++) {
			if(menu.getBrasileirao().getPartidas().get(i).getRodada() == rod) {
				Box caixaHorizontal = Box.createHorizontalBox();
				caixaHorizontal.setMaximumSize(new Dimension(2000, 3000));
				Border blackline = BorderFactory.createLineBorder(Color.black, 3, true);
				
				JPanel painelPartidas = new JPanel();
				painelPartidas.setMaximumSize(new Dimension(2000, 2000));
				painelPartidas.setBackground(new Color(255,255,255));
				painelPartidas.setBorder(blackline);
				painelPartidas.setLayout(null);
				
				JLabel lblTimeCasa = new JLabel(brasileirao.getPartidas().get(i).getTimeCasa().getNome());
				lblTimeCasa.setBounds(115, 69, 103, 13);
				painelPartidas.add(lblTimeCasa);
				
				JLabel lblTimeFora = new JLabel(brasileirao.getPartidas().get(i).getTimeFora().getNome());
				lblTimeFora.setBounds(545, 69, 103, 13);
				painelPartidas.add(lblTimeFora);
				
				JLabel lblEstadio = new JLabel(brasileirao.getPartidas().get(i).getEstadio().toString());
				lblEstadio.setBounds(305, 121, 150, 13);
				painelPartidas.add(lblEstadio);
				
				JLabel lblX = new JLabel("X");
				lblX.setFont(new Font("Tahoma", Font.PLAIN, 31));
				lblX.setBounds(342, 69, 45, 13);
				painelPartidas.add(lblX);
				
				JLabel lblGolsCasa = new JLabel(Integer.toString(brasileirao.getPartidas().get(i).getGolsCasa()));
				lblGolsCasa.setBounds(275, 69, 45, 13);
				painelPartidas.add(lblGolsCasa);
				
				JLabel lblGolsFora = new JLabel(Integer.toString(brasileirao.getPartidas().get(i).getGolsFora()));
				lblGolsFora.setBounds(428, 69, 45, 13);
				painelPartidas.add(lblGolsFora);
				
				JSeparator separator = new JSeparator();
				separator.setMaximumSize(new Dimension(3000, 200));
				separator.setBackground(new Color(0x483D8B));
				separator.setBounds(0, 130, 736, 12);
				
				//Adcionando as Listas
				labels.add(lblTimeCasa);
				labels.add(lblTimeFora);
				labels.add(lblEstadio);
				labels.add(lblEstadio);
				labels.add(lblGolsCasa);
				labels.add(lblGolsFora);
				labels.add(lblX);
				listaPainelPartidas.add(painelPartidas);
				caixaHorizontal.add(painelPartidas);
				caixaVertical.add(caixaHorizontal);
				separadores.add(separator);
				caixaHorizontal.add(separator);
				caixaVertical.add(separator);
			}	
		}
		
		//Metodos
		//Funcao que muda a posicao vertical dos elementos durante o scroll
		scrollBar.addAdjustmentListener(new AdjustmentListener() {  
			public void adjustmentValueChanged(AdjustmentEvent e) {  
				painelConteudo.setBounds(0, 0-scrollBar.getValue(), 750, 1900);
			}
		}); 
		spnRodada.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int partRod =1;
				int rodada =(int) Math.round((double) spnRodada.getValue());
				caixaVertical.removeAll();
				for (int i = 0; i < numPartidas-1; i++) {
					if(brasileirao.getPartidas().get(i).getRodada() == rodada) {
						partRod++;
					}	
				}
				caixaVertical.setSize(736, 150*partRod);
				 for (int i = 0; i < numPartidas-1; i++) {
						if(brasileirao.getPartidas().get(i).getRodada() == rodada) {
							Box caixaHorizontal = Box.createHorizontalBox();
							caixaHorizontal.setMaximumSize(new Dimension(2000, 3000));
							Border blackline = BorderFactory.createLineBorder(Color.black, 3, true);
							
							JPanel painelPartidas = new JPanel();
							painelPartidas.setMaximumSize(new Dimension(2000, 800));
							painelPartidas.setBackground(new Color(255,255,255));
							painelPartidas.setBorder(blackline);
							painelPartidas.setLayout(null);
							
							JLabel lblTimeCasa = new JLabel(brasileirao.getPartidas().get(i).getTimeCasa().getNome());
							lblTimeCasa.setBounds(115, 69, 103, 13);
							painelPartidas.add(lblTimeCasa);
							
							JLabel lblTimeFora = new JLabel(brasileirao.getPartidas().get(i).getTimeFora().getNome());
							lblTimeFora.setBounds(545, 69, 103, 13);
							painelPartidas.add(lblTimeFora);
							
							JLabel lblEstadio = new JLabel(brasileirao.getPartidas().get(i).getEstadio().toString());
							lblEstadio.setBounds(305, 121, 150, 13);
							painelPartidas.add(lblEstadio);
							
							JLabel lblX = new JLabel("X");
							lblX.setFont(new Font("Tahoma", Font.PLAIN, 31));
							lblX.setBounds(342, 69, 45, 13);
							painelPartidas.add(lblX);
							
							JLabel lblGolsCasa = new JLabel(Integer.toString(brasileirao.getPartidas().get(i).getGolsCasa()));
							lblGolsCasa.setBounds(275, 69, 45, 13);
							painelPartidas.add(lblGolsCasa);
							
							JLabel lblGolsFora = new JLabel(Integer.toString(brasileirao.getPartidas().get(i).getGolsFora()));
							lblGolsFora.setBounds(428, 69, 45, 13);
							painelPartidas.add(lblGolsFora);
							
							JSeparator separator = new JSeparator();
							separator.setMaximumSize(new Dimension(3000, 200));
							separator.setBackground(new Color(0x483D8B));
							separator.setBounds(0, 130, 736, 12);
							
							//Adcionando as Listas
							labels.add(lblTimeCasa);
							labels.add(lblTimeFora);
							labels.add(lblEstadio);
							labels.add(lblEstadio);
							labels.add(lblGolsCasa);
							labels.add(lblGolsFora);
							labels.add(lblX);
							listaPainelPartidas.add(painelPartidas);
							caixaHorizontal.add(painelPartidas);
							caixaVertical.add(caixaHorizontal);
							separadores.add(separator);
							caixaHorizontal.add(separator);
							caixaVertical.add(separator);
						

						}	
					}
				 	caixaVertical.setVisible(false);
				 	caixaVertical.setVisible(true);
			}
		});
		
		
	}
}
