package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Event;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bancoDeDados.Listas;
import controlador.ControlePartidas;
import visao.PartidasCriar;
import visao.PartidasDeletar;

class TesteCRUDPartida {

	@Test
	void testeCriarPartida() {
		//Inicializando os dados do programa
		Listas brasileirao = new Listas();
		brasileirao.inicializarTimes();
		brasileirao.inicializarJogadores();
		
		//Criando o frame de criar partida
		PartidasCriar framePartidasCriar = new PartidasCriar();
		
		//Inicializando os valores da partida
		framePartidasCriar.getTimesCasa().setSelectedIndex(1);
		framePartidasCriar.getSpnGolsCasa().setValue(2);
		framePartidasCriar.getTimesFora().setSelectedIndex(1);
		framePartidasCriar.getSpnGolsFora().setValue(1);
		framePartidasCriar.getSpinnerRodada().setValue(2);
		framePartidasCriar.getjListEstadios().setSelectedIndex(0);
		framePartidasCriar.getBotaoProximo().doClick();
		
		//Escolhendo os goleadores
		framePartidasCriar.getListaDeListas1().get(0).setSelectedIndex(0);
		framePartidasCriar.getListaDeListas1().get(1).setSelectedIndex(0);
		framePartidasCriar.getListaDeListas2().get(0).setSelectedIndex(0);
		framePartidasCriar.getBotaoCriar().doClick();
		
		//Checando se todos os dados foram salvos corretamente
		assertTrue(brasileirao.getTimes().get(1).getPontosTotais() == 3);
		assertTrue(brasileirao.getTimes().get(2).getPontosTotais() == 0);
		assertTrue(brasileirao.getTimes().get(1).getJogadores(0).getTotalGols() == 2);
		assertTrue(brasileirao.getTimes().get(2).getJogadores(0).getTotalGols() == 1);
	}
	
	@Test
	void testeDeletarPartida() {
		//Inicializando os dados do programa
		Listas brasileirao = new Listas();
		brasileirao.inicializarTimes();
		brasileirao.inicializarJogadores();
		brasileirao.inicializarPartidas();
		int numPartidas = brasileirao.getPartidas().size();
		
		//Criando o frame de criar partida
		PartidasDeletar framePartidasDeletar = new PartidasDeletar();
		
		//Inicializando os dados do frame;
		framePartidasDeletar.setResult(0);
		framePartidasDeletar.getSpnRodada().setValue(1);
		framePartidasDeletar.getBotoesDeletar().get(3).doClick();
		
		assertTrue(numPartidas > brasileirao.getPartidas().size());

	}

}
