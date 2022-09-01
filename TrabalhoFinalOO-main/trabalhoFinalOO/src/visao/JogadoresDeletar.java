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

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import bancoDeDados.Listas;

public class JogadoresDeletar extends JFrame {

	private Listas brasileirao = new Listas();

	//Componentes Visuais
	private JPanel painelConteudo, painelPartidas;
	private JScrollPane painelPartidasScroll;
	private DefaultListModel<String> listaDeTimesModelo = new DefaultListModel<String>();
	private JList<String> listaDeTimes ;
	private ArrayList<JButton> botoesDeletar = new ArrayList<JButton>();
	
	
	//Metodos
	public static void main(String[] args) {
		JogadoresDeletar frame = new JogadoresDeletar();
		frame.setVisible(true);
	}

	public JogadoresDeletar() {
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
		
		JButton botaoVoltar = new JButton("Voltar");
		getContentPane().add(botaoVoltar);
		botaoVoltar.setFont(new Font("Arial", Font.PLAIN, 16));
		botaoVoltar.setBounds(24, 35, 85, 28);
		botaoVoltar.addActionListener((event) -> {
			this.dispose();
			JogadoresMenu.main(null);
		});
		
		//Titulo para a pagina
		JLabel titulo = new JLabel("DELETAR JOGADOR");
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
			listaDeTimesModelo.addElement(Listas.times.get(i).getNome());
		}
		
		
		painelTimes.setBounds(267, 0, 197, 64);
		listaDeTimes = new JList<String>(listaDeTimesModelo);
		//Atualizar o que a tela mostra de acordo com a escolha do time
		listaDeTimes.addListSelectionListener((event)->{
			painelPartidas.removeAll();
			botoesDeletar.clear();
			int contador = 0;
			for(int i = 0; i < 20; i++) {
				if(listaDeTimes.getSelectedValue() == Listas.times.get(i).getNome()) {
					for(int j = 0; j < Listas.times.get(i).getJogadoresSize(); j++) {
						int index = i;
						int index2 = j;
						botoesDeletar.add(new JButton(Listas.times.get(i).getJogadores(j).getNome()));
						botoesDeletar.get(contador).setBounds(new Rectangle(0, contador*70, 400, 60));
						botoesDeletar.get(contador).setFont(new Font("Arial Black", Font.PLAIN, 11));
						painelPartidas.add(botoesDeletar.get(contador));
						botoesDeletar.get(contador).addActionListener( new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {				
								JFrame jFrame = new JFrame();
								int result = JOptionPane.showConfirmDialog(jFrame, "Voce realmente quer deletar " + Listas.times.get(index).getJogadores(index2).getNome());
								
								if (result == 0) {
									brasileirao.getTimes().get(index).deletarJogador(brasileirao.getTimes().get(index).getJogadores(index2));
									dispose();
									JogadoresVer.main(null);
								}
								else{
									dispose();
									JogadoresMenu.main(null);
								}
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
		return botoesDeletar;
	}

	public void setBotoesDeletar(ArrayList<JButton> botoesDeletar) {
		this.botoesDeletar = botoesDeletar;
	}
}
