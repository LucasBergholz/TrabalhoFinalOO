package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import bancoDeDados.Listas;

public class PartidasDeletar extends JFrame {

	private JPanel painelConteudo, painelPartidas;
	private JScrollPane painelPartidasScroll;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartidasDeletar frame = new PartidasDeletar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public PartidasDeletar() {
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
		JLabel titulo = new JLabel("DELETAR PARTIDA");
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
		
		JLabel lblSpinner = new JLabel("RODADA");
		lblSpinner.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSpinner.setBounds(304, 10, 100, 40);
		panel.add(lblSpinner);
		
		JSpinner spnRodada = new JSpinner();
		spnRodada.setFont(new Font("Arial", Font.PLAIN, 20));
		spnRodada.setBounds(304, 10, 126, 40);
		spnRodada.setModel(new SpinnerNumberModel(0, 0, 38, 1));
		//Atualizar o que a tela mostra de acordo com a rodada do spinner
		spnRodada.addChangeListener((event)->{
			painelPartidas.removeAll();
			ArrayList<JButton> botoesDeletar = new ArrayList<JButton>();
			botoesDeletar.clear();
			int rodada = (Integer)spnRodada.getValue();
			for(int i = 0; i < Listas.partidas.size(); i++) {
				
				final int posicaoLista;
				if(Listas.partidas.get(i).getRodada() == rodada) {
					botoesDeletar.add(new JButton(Listas.partidas.get(i).toString()));
					botoesDeletar.get(i).setBounds(new Rectangle(0, (i*70), 400, 60));
					botoesDeletar.get(i).setFont(new Font("Arial Black", Font.PLAIN, 11));
					posicaoLista = i;
					painelPartidas.add(botoesDeletar.get(i));
					botoesDeletar.get(i).addActionListener( new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {				
							JFrame jFrame = new JFrame();
							int result = JOptionPane.showConfirmDialog(jFrame, "Voce realmente quer deletar " + Listas.partidas.get(posicaoLista));
							
							if (result == 0) {
								Listas.partidas.get(posicaoLista).deletarPartida();
								Listas.partidas.remove(posicaoLista);
								dispose();
								PartidasMenu.main(null);
							}
							else if (result == 1) {
								dispose();
								PartidasMenu.main(null);
							}
						}
					});
				}
				
			}
			painelPartidasScroll.setVisible(false);
			painelPartidasScroll.setVisible(true);
		});
		panel.add(spnRodada);
		
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
		
	}

}
