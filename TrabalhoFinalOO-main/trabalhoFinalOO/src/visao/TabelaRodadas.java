package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.Dimension;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Cursor;
import java.awt.Dimension;

public class TabelaRodadas extends JFrame {

	private JPanel painelConteudo;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelaRodadas frame = new TabelaRodadas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TabelaRodadas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 750, 600);
		setResizable(false);
		painelConteudo = new JPanel();
		painelConteudo.setBackground(new Color(0, 0, 128));
		painelConteudo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelConteudo);
		painelConteudo.setLayout(null);
		
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
		int numPartidas = menu.getBrasileirao().getPartidas().size();
		int rod =(int) Math.round((double) spnRodada.getValue());
		
		List<JPanel> painelPartidas = new ArrayList<>();
		List<JSeparator> separadores = new ArrayList<>();
		List<JLabel> labels = new ArrayList<>();
		Box caixaVertical = Box.createVerticalBox();
		caixaVertical.setSize(736, 1690);
		painelConteudo.add(caixaVertical);
		caixaVertical.setLocation(0, 179);
		
		/*JLabel lblNewLabel = new JLabel(Integer.toString(rod));
		lblNewLabel.setBounds(85, 24, 45, 13);
		lblNewLabel.setForeground(Color.WHITE);
		painelConteudo.add(lblNewLabel);*/
		
		for (int i = 0; i < numPartidas-1; i++) {
			if(menu.getBrasileirao().getPartidas().get(i).getRodada() == rod) {
				Box caixaHorizontal = Box.createHorizontalBox();
				
				JPanel panel_1 = new JPanel();
				panel_1.setSize(622, 154);
				panel_1.setBackground(new Color(0x483D8B));
				panel_1.setLayout(null);
				
				JLabel lblTimeCasa = new JLabel(menu.getBrasileirao().getPartidas().get(i).getTimeCasa().getNome());
				lblTimeCasa.setBounds(95, 69, 103, 13);
				panel_1.add(lblTimeCasa);
				
				JLabel lblTimeFora = new JLabel(menu.getBrasileirao().getPartidas().get(i).getTimeFora().getNome());
				lblTimeFora.setBounds(505, 69, 103, 13);
				panel_1.add(lblTimeFora);
				
				JLabel lblEstadio = new JLabel(menu.getBrasileirao().getPartidas().get(i).getEstadio().toString());
				lblEstadio.setBounds(275, 131, 95, 13);
				panel_1.add(lblEstadio);
				
				JLabel lblX = new JLabel("X");
				lblX.setFont(new Font("Tahoma", Font.PLAIN, 31));
				lblX.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
				lblX.setBounds(302, 69, 45, 13);
				panel_1.add(lblX);
				
				JLabel lblGolsCasa = new JLabel(Integer.toString(menu.getBrasileirao().getPartidas().get(i).getGolsCasa()));
				lblGolsCasa.setBounds(204, 69, 45, 13);
				panel_1.add(lblGolsCasa);
				
				JLabel lblGolsFora = new JLabel(Integer.toString(menu.getBrasileirao().getPartidas().get(i).getGolsFora()));
				lblGolsFora.setBounds(388, 69, 45, 13);
				panel_1.add(lblGolsFora);
				
				JSeparator separator = new JSeparator();
				separator.setMaximumSize(new Dimension(3000, 800));
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
				painelPartidas.add(panel_1);
				caixaHorizontal.add(panel_1);
				caixaVertical.add(caixaHorizontal);
				separadores.add(separator);
				caixaHorizontal.add(separator);
				caixaVertical.add(separator);
			}	
		}
		
		/*JScrollBar scrollBar = new JScrollBar();
		painelConteudo.add(scrollBar);
		scrollBar.setBounds(719, 0, 17, 575);
		scrollBar.addAdjustmentListener(new AdjustmentListener() {  
		    public void adjustmentValueChanged(AdjustmentEvent e) {  
		    	titulo.setBounds(0, 0-scrollBar.getValue(), 751, 100);
		    	caixaVertical.setBounds(40, 100-scrollBar.getValue(), 650, 525);
		    	panel.setBounds(10, 35-scrollBar.getValue(), 85, 21);
		    }
		 });*/
		
		
	}
}
