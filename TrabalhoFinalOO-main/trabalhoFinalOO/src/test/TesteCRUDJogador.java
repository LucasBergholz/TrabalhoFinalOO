package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bancoDeDados.Listas;
import visao.JogadoresCriar;
import visao.JogadoresDeletar;

public class TesteCRUDJogador {
	
	@Test
	void testeCriarJogador() {
		int indexTime = 4;
		Listas brasileirao = new Listas();
		brasileirao.inicializarTimes();
		JogadoresCriar frameJogadores = new JogadoresCriar();
		
		//Iniciando os Valores
		frameJogadores.getTxtNome().setText("Leo King");
		frameJogadores.getSpnIdade().setValue(20.0);
		frameJogadores.getListagemPosicao().setSelectedIndex(1);
		frameJogadores.getListagemTime().setSelectedIndex(indexTime);
			
		frameJogadores.getBotaoCriar().doClick();
		
		assertEquals(1, brasileirao.getTimes().get(indexTime).getJogadoresSize());
	}
	
	@Test
	void testeDeletarJogador() {
		int indexTime = 4;
		Listas brasileirao = new Listas();
		brasileirao.inicializarTimes();
		brasileirao.inicializarJogadores();
		//Salvando a quantidade de jogadores do time anterior a deletar um deles
		int numJogadores = brasileirao.getTimes().get(indexTime).getJogadoresSize();
		JogadoresDeletar frameJogadoresDeletar = new JogadoresDeletar();
		
		//Performando as acoes necessarias para deletar o jogador
		frameJogadoresDeletar.getListaDeTimes().setSelectedIndex(indexTime);
		frameJogadoresDeletar.setResult(0);
		frameJogadoresDeletar.getBotoesDeletar().get(numJogadores-1).doClick();
		
		assertEquals(numJogadores-1, brasileirao.getTimes().get(indexTime).getJogadoresSize());
	}

}
