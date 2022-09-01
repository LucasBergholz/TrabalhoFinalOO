package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bancoDeDados.Listas;
import visao.JogadoresCriar;
import visao.Main;

class TesteCRUDJogador {
	
	@Test
	void testeCriarJogador() {
		Main.main(null);
		
		int indexTime = 4;
		Main.brasileirao.getTimes().get(indexTime).getJogadores().clear();
		JogadoresCriar frameJogadores = new JogadoresCriar();
		
		//Inciando os Valores
		frameJogadores.getSpnIdade().setValue(20.0);
		frameJogadores.getTxtNome().setText("LeoK");
		frameJogadores.getListagemPosicao().setSelectedIndex(1);
		frameJogadores.getListagemTime().setSelectedIndex(indexTime);
			
		frameJogadores.getBotaoCriar().doClick();
		
		assertEquals(1, Main.brasileirao.getTimes().get(indexTime).getJogadoresSize());
	}

}
