package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

public class Classificacao extends JFrame {

	private JPanel painelConteudo;
	private JTable tabelaClassificacao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Classificacao frame = new Classificacao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Classificacao() {
		//Criando titulo do frame e definindo caracteristicas do painel de conteudo
		painelConteudo = new JPanel();
		setTitle("Brasileirao 2022");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 750, 600);
		setResizable(false);
		painelConteudo.setBackground(new Color(0, 0, 128));
		painelConteudo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelConteudo);
		painelConteudo.setLayout(null);
		
		//Criando a tabela
		tabelaClassificacao = new JTable(21,7) {
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
		tabelaClassificacao.setAutoCreateColumnsFromModel(false);
		tabelaClassificacao.setRowHeight(25);
		painelConteudo.add(tabelaClassificacao);
		tabelaClassificacao.setFont(new Font("Arial", Font.PLAIN, 20));
		tabelaClassificacao.setBounds(40, 100, 650, 525);
		tabelaClassificacao.setRowSelectionAllowed(false);
		
		//Adicionando legenda a tabela
		tabelaClassificacao.setValueAt("Times",0,0);
		tabelaClassificacao.setValueAt("Partidas",0,1);
		tabelaClassificacao.setValueAt("Pontos",0,2);
		tabelaClassificacao.setValueAt("Vitorias",0,3);
		tabelaClassificacao.setValueAt("Empates",0,4);
		tabelaClassificacao.setValueAt("Derrotas",0,5);
		tabelaClassificacao.setValueAt("SG",0,6);
		
		//Titulo para a pagina
		JLabel titulo = new JLabel("CLASSIFICAÇÃO");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		titulo.setBounds(0, 0, 751, 100);
		painelConteudo.add(titulo);
		
		//Criando ScrollBar para ver o restante da tabela
		JScrollBar scrollBar = new JScrollBar();
		painelConteudo.add(scrollBar);
		scrollBar.setBounds(719, 0, 17, 575);
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBounds(10, 35, 85, 21);
		painelConteudo.add(botaoVoltar);
		botaoVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Menu.main(null);
			}
		});
		
		//Funcao que muda a posicao vertical dos elementos durante o scroll
		scrollBar.addAdjustmentListener(new AdjustmentListener() {  
		    public void adjustmentValueChanged(AdjustmentEvent e) {  
		    	tabelaClassificacao.setBounds(40, 100-scrollBar.getValue(), 650, 525);
		    	titulo.setBounds(0, 0-scrollBar.getValue(), 751, 100);
		    	botaoVoltar.setBounds(10, 35-scrollBar.getValue(), 85, 21);
		    }
		 });  
	}
}
