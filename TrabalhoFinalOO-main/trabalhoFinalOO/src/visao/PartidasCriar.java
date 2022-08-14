package visao;

import modelo.*;
import bancoDeDados.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class PartidasCriar extends JFrame {

	private JPanel painelConteudo;
	private Listas brasileirao = new Listas();

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
			
			//Titulo para a pagina
			JLabel titulo = new JLabel("CRIAR PARTIDA");
			titulo.setHorizontalAlignment(SwingConstants.CENTER);
			titulo.setForeground(Color.WHITE);
			titulo.setFont(new Font("Arial", Font.BOLD, 50));
			titulo.setBounds(0, 0, 751, 100);
			painelConteudo.add(titulo);
			
			//Usuario escolher os times e o placar
			
			//Adicionando itens para a escolha do estadio
			brasileirao.inicializarTimes();
			DefaultListModel listaTimes = new DefaultListModel();
			for(int i = 0; i < 19; i++) {
				listaTimes.addElement(brasileirao.getTimes().get(i).getNome());
				
			}
			JList timeCasa = new JList(listaTimes);
			timeCasa.setBounds(52, 183, 197, 45);
			painelConteudo.add(timeCasa);
			
			JList timeFora = new JList(listaTimes);
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
			
			JSpinner golsCasa = new JSpinner();
			golsCasa.setBounds(248, 183, 47, 45);
			painelConteudo.add(golsCasa);
			
			JSpinner golsFora = new JSpinner();
			golsFora.setBounds(445, 183, 47, 45);
			painelConteudo.add(golsFora);
			
			JButton botaoEnviar = new JButton("Proximo");
			painelConteudo.add(botaoEnviar);
			botaoEnviar.setBounds(529, 492, 175, 33);
			botaoEnviar.setFont(new Font("Arial", Font.PLAIN, 20));
			
			//Adicionando itens para a escolha do estadio
			DefaultListModel demoList = new DefaultListModel();
			for(int i = 0; i < 19; i++) {
				demoList.addElement(Estadios.values()[i]);
				
			}
			
			JList estadios = new JList(demoList);
			estadios.setBounds(266, 196, 197, 158);
			
			//Lista de estadios com scroll
			JScrollPane listaEstadios = new JScrollPane(estadios);
			listaEstadios.setLocation(275, 300);
			listaEstadios.setSize(195, 152);
			painelConteudo.add(listaEstadios);
		}
	}
