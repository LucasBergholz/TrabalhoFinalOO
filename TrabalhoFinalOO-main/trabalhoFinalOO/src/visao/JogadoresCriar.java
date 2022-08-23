package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import bancoDeDados.Listas;

import javax.swing.JTextField;
import javax.swing.JSpinner;

public class JogadoresCriar extends JFrame {

	private JPanel painelConteudo;
	private JTextField textField;
	private Listas brasileirao = new Listas();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JogadoresCriar frame = new JogadoresCriar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JogadoresCriar() {
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
		JLabel titulo = new JLabel("Cadastrar Jogador");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		titulo.setBounds(0, 0, 751, 100);
		painelConteudo.add(titulo);
		
		//Criando o painel onde vai ser cadastrado o jogador
		JPanel painelCadastro = new JPanel();
		painelCadastro.setBounds(49, 110, 635, 422);
		painelCadastro.setLayout(null);
		painelConteudo.add(painelCadastro);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		textField.setBounds(136, 49, 358, 24);
		painelCadastro.add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNome.setBounds(25, 49, 101, 24);
		painelCadastro.add(lblNome);
		
		//Criando a lista de times
		brasileirao.inicializarTimes();
		DefaultListModel listaTimes = new DefaultListModel();
		DefaultListModel listaTimes2 = new DefaultListModel();
		for(int i = 0; i < 19; i++) {
			listaTimes.addElement(brasileirao.getTimes().get(i).getNome());
			
		}
		
		JList listagemTime = new JList(listaTimes);
		listagemTime.setFont(new Font("Arial Black", Font.PLAIN, 11));
		listagemTime.setBounds(136, 256, 197, 112);
		painelCadastro.add(listagemTime);
		
		JScrollPane listaTimesScroll = new JScrollPane(listagemTime);
		painelCadastro.add(listaTimesScroll);
		listaTimesScroll.setSize(197, 112);
		listaTimesScroll.setLocation(136, 256);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTime.setBounds(25, 260, 101, 24);
		painelCadastro.add(lblTime);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Arial", Font.PLAIN, 20));
		lblIdade.setBounds(25, 106, 101, 24);
		painelCadastro.add(lblIdade);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(136, 106, 49, 26);
		painelCadastro.add(spinner);
		
		
		
	}
}
