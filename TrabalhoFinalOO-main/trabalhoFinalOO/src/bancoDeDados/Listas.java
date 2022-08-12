package bancoDeDados;

import java.util.ArrayList;

import modelo.*;

public class Listas {
	//Criando ArrayList dos times;
		private static final ArrayList<Time> times = new ArrayList<>();
		private static final ArrayList<Partida> partidas = new ArrayList<>();
		
		public void inicializarTimes() {
			times.add(new Time("AMERICA-MG", "#00FF00", "#FFFFFF", Estadios.INDEPENDENCIA)); //0
			times.add(new Time("ATHLETICO-PR", "#FF0000", "#000000", Estadios.ARENA_DA_BAIXADA));//1
			times.add(new Time("ATLETICO-GO", "#FFFFFF", "#000000", Estadios.ANTONIO_ACCIOLY));//2
			times.add(new Time("ATLETICO-MG", "#000000", "#FFFFFF", Estadios.MINEIRAO));//3
			times.add(new Time("AVAI", "#0000FF", "#FFFFFF", Estadios.RESSACADA));//4
			times.add(new Time("BOTAFOGO", "#000000", "#FFFFFF", Estadios.NILTON_SANTOS));//5
			times.add(new Time("CEARA", "#000000", "#FFFFFF", Estadios.CASTELAO));//6
			times.add(new Time("CORINTHIANS", "#FFFFFF", "#000000", Estadios.NEO_QUIMICA_ARENA));//7
			times.add(new Time("CORITIBA", "#008000", "#FFFFFF", Estadios.COUTO_PEREIRA));//8
			times.add(new Time("CUIABA", "#008000", "#FFEE05", Estadios.ARENA_PANTANAL));//9
			times.add(new Time("FLAMENGO", "#FF0000", "#000000", Estadios.MARACANA));//10
			times.add(new Time("FLUMINENSE", "#831D1C", "#146b02", Estadios.MARACANA));//11
			times.add(new Time("FORTALEZA", "#0000FF", "#FF0000", Estadios.CASTELAO));//12
			times.add(new Time("GOIAS", "#008000", "#FFFFFF", Estadios.SERRINHA));//13
			times.add(new Time("INTERNACIONAL", "#FF0000", "#FFFFFF", Estadios.BEIRA_RIO));//14
			times.add(new Time("JUVENTUDE", "#008000", "#FFFFFF", Estadios.ALFREDO_JACONI));//15
			times.add(new Time("PALMEIRAS", "#008000", "#FFFFFF", Estadios.ALLIANZ_PARQUE));//16
			times.add(new Time("RED BULL BRAGANTINO", "#FFFFFF", "#FF0000", Estadios.NABI_ABI_CHEDID));//17
			times.add(new Time("SANTOS", "#0000000", "#FFFFFF", Estadios.VILA_BELMIRO));//18
			times.add(new Time("SAO PAULO", "#FF0000", "#FFFFFF", Estadios.MORUMBI));//19
		}

		public void inicializarJogadores() {
			times.get(0).addJogador("WELLINGTON PAULISTA", Posicao.ATACANTE);
			times.get(0).addJogador("MARTIN BENITEZ", Posicao.MEIA);
			times.get(0).addJogador("IAGO MAIDANA", Posicao.ZAGUEIRO);
			times.get(1).addJogador("VITOR ROQUE", Posicao.PONTA);
			times.get(1).addJogador("PABLO FELIPE", Posicao.ATACANTE);
			times.get(1).addJogador("FERNANDINHO 7X1", Posicao.VOLANTE);
			times.get(2).addJogador("WELLINGTON RATO", Posicao.PONTA);
			times.get(2).addJogador("SHAYLON CARDOZO", Posicao.MEIA);
			times.get(2).addJogador("LUIZ FERNANDO", Posicao.PONTA);
			times.get(3).addJogador("HULK PARAIBA", Posicao.ATACANTE);
			times.get(3).addJogador("NACHO FERNANDEZ", Posicao.MEIA);
			times.get(3).addJogador("JUNIOR ALONSO", Posicao.ZAGUEIRO);
			times.get(4).addJogador("BRUNO SILVA", Posicao.VOLANTE);
			times.get(4).addJogador("KEVIN LATERAL", Posicao.LATERAL);
			times.get(4).addJogador("PAOLO GUERRERO", Posicao.ATACANTE);
			times.get(5).addJogador("ERISON DANILO", Posicao.ATACANTE);
			times.get(5).addJogador("MATHEUS NASCIMENTO", Posicao.ATACANTE);
			times.get(5).addJogador("JOEL CARLI", Posicao.ZAGUEIRO);
			times.get(6).addJogador("STIVEN MENDOZA", Posicao.PONTA);
			times.get(6).addJogador("LEANDRO CACHACA", Posicao.PONTA);
			times.get(6).addJogador("GUIZAO COSTA", Posicao.ZAGUEIRO);
			times.get(7).addJogador("CASSIO RAMOS", Posicao.GOLEIRO);
			times.get(7).addJogador("ROGER GUEDES", Posicao.ATACANTE);
			times.get(7).addJogador("WILLIAN BORGES", Posicao.PONTA);
			times.get(8).addJogador("IGOR PAIXAO", Posicao.PONTA);
			times.get(8).addJogador("LEO GAMALHO", Posicao.ATACANTE);
			times.get(8).addJogador("ALEF MANGA", Posicao.PONTA);
			times.get(9).addJogador("RODRIGUINHO COSTA", Posicao.MEIA);
			times.get(9).addJogador("ANDRE BALADA", Posicao.ATACANTE);
			times.get(9).addJogador("DEYVERSON BRUM", Posicao.ATACANTE);
			times.get(10).addJogador("GIORGIAN DE ARRASCAETA", Posicao.MEIA);
			times.get(10).addJogador("GABRIEL BARBOSA", Posicao.ATACANTE);
			times.get(10).addJogador("PEDRO QUEIXADA", Posicao.ATACANTE);
			times.get(11).addJogador("PH GANSO", Posicao.MEIA);
			times.get(11).addJogador("GERMAN CANO", Posicao.ATACANTE);
			times.get(11).addJogador("JHON ARIAS", Posicao.PONTA);
			times.get(12).addJogador("MARCELO BENEVENUTO", Posicao.ZAGUEIRO);
			times.get(12).addJogador("LUCAS CRISPIM", Posicao.MEIA);
			times.get(12).addJogador("LUCAS LIMA", Posicao.MEIA);
			times.get(13).addJogador("PEDRO RAUL", Posicao.ATACANTE);
			times.get(13).addJogador("APODI ALVES", Posicao.LATERAL);
			times.get(13).addJogador("TADEU ANTONIO", Posicao.GOLEIRO);
			times.get(14).addJogador("ALAN PATRICK", Posicao.MEIA);
			times.get(14).addJogador("TAISON BARCELOS", Posicao.MEIA);
			times.get(14).addJogador("WANDERSON MACIEL", Posicao.ATACANTE);
			times.get(15).addJogador("CHICO KIM", Posicao.MEIA);
			times.get(15).addJogador("ISIDRO PITTA", Posicao.ATACANTE);
			times.get(15).addJogador("RAFAEL FORSTER", Posicao.ZAGUEIRO);
			times.get(16).addJogador("RONY RUSTICO", Posicao.ATACANTE);
			times.get(16).addJogador("RAPHAEL VEIGA", Posicao.MEIA);
			times.get(16).addJogador("GUSTAVO SCARPA", Posicao.MEIA);
			times.get(17).addJogador("ARTUR VICTOR", Posicao.PONTA);
			times.get(17).addJogador("LEO ORTIZ", Posicao.ZAGUEIRO);
			times.get(17).addJogador("HELINHO MEGAMENTE", Posicao.PONTA);
			times.get(18).addJogador("MARCOS LEONARDO", Posicao.ATACANTE);
			times.get(18).addJogador("ANGELO GABRIEL", Posicao.PONTA);
			times.get(18).addJogador("LEO BAPTISTAO", Posicao.ATACANTE);
			times.get(19).addJogador("JONATHAN CALLERI", Posicao.ATACANTE);
			times.get(19).addJogador("RODRIGO NESTOR", Posicao.VOLANTE);
			times.get(19).addJogador("MARCOS GUILHERME", Posicao.PONTA);
		}
		
		public void inicializarPartidas() {
			//Flu VS Santos
			partidas.add(new Partida(times.get(11), times.get(19), Estadios.MARACANA));
			partidas.get(0).finalizarPartida(0, 0, 01);
			
			//Atletico VS 
		}
		public ArrayList<Time> getTimes() {
			return times;
		}


}
