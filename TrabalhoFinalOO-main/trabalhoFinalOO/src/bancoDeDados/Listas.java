package bancoDeDados;

import java.util.ArrayList;

import modelo.*;

/**
 * Classe responsavel por guardar os dados iniciais da aplicacao.
 * @author Lucas Bergholz
 * @author Guilherme Rodrigues
 * @see Time
 * @see Jogador
 * @see Partida
 * @see Tecnico
 * @see Estadios
 */
public class Listas {
	//Criando ArrayList dos times;
	private static final  ArrayList<Time> times = new ArrayList<>();
	private static final ArrayList<Partida> partidas = new ArrayList<>();
	
	/**
	 * Metodo responsavel por instanciar os times participantes do campeonato
	 * @see Time
	 * @see Tecnico
	 * @see Estadios
	 */
	public void inicializarTimes() {
		times.add(new Time("AMERICA-MG", "#00FF00", "#FFFFFF","VAGNER MANCINI", Estadios.INDEPENDENCIA)); //0
		times.add(new Time("ATHLETICO-PR", "#FF0000", "#000000","FELIPAO", Estadios.ARENA_DA_BAIXADA));//1
		times.add(new Time("ATLETICO-GO", "#FFFFFF", "#000000","JORGUINHO", Estadios.ANTONIO_ACCIOLY));//2
		times.add(new Time("ATLETICO-MG", "#000000", "#FFFFFF","CUCA", Estadios.MINEIRAO));//3
		times.add(new Time("AVAI", "#0000FF", "#FFFFFF","EDUARDO BARROCA", Estadios.RESSACADA));//4
		times.add(new Time("BOTAFOGO", "#000000", "#FFFFFF","LUIS CASTRO", Estadios.NILTON_SANTOS));//5
		times.add(new Time("CEARA", "#000000", "#FFFFFF","MARQUINHOS SANTOS", Estadios.CASTELAO));//6
		times.add(new Time("CORINTHIANS", "#FFFFFF", "#000000","VITOR PEREIRA", Estadios.NEO_QUIMICA_ARENA));//7
		times.add(new Time("CORITIBA", "#008000", "#FFFFFF","GUTO FERREIRA", Estadios.COUTO_PEREIRA));//8
		times.add(new Time("CUIABA", "#008000", "#FFEE05","ANTONIO OLIVEIRA", Estadios.ARENA_PANTANAL));//9
		times.add(new Time("FLAMENGO", "#FF0000", "#000000","DORVAL JUNIOR", Estadios.MARACANA));//10
		times.add(new Time("FLUMINENSE", "#831D1C", "#146b02","FERNANDO DINIZ", Estadios.MARACANA));//11
		times.add(new Time("FORTALEZA", "#0000FF", "#FF0000","JUAN VOJVODA", Estadios.CASTELAO));//12
		times.add(new Time("GOIAS", "#008000", "#FFFFFF","JAIR VENTURA", Estadios.SERRINHA));//13
		times.add(new Time("INTERNACIONAL", "#FF0000", "#FFFFFF","MANO MENEZES", Estadios.BEIRA_RIO));//14
		times.add(new Time("JUVENTUDE", "#008000", "#FFFFFF","UMBERTO LOUZER", Estadios.ALFREDO_JACONI));//15
		times.add(new Time("PALMEIRAS", "#008000", "#FFFFFF","ABEL FERREIRA", Estadios.ALLIANZ_PARQUE));//16
		times.add(new Time("RB BRAGANTINO", "#FFFFFF", "#FF0000","MAURICIO BARBIERI", Estadios.NABI_ABI_CHEDID));//17
		times.add(new Time("SANTOS", "#0000000", "#FFFFFF","FABIAN BUSTOS", Estadios.VILA_BELMIRO));//18
		times.add(new Time("SAO PAULO", "#FF0000", "#FFFFFF","ROGERIO CENI", Estadios.MORUMBI));//19
	}

	/**
	 * Metodo responsavel por instanciar os jogadores iniciais de cada time
	 * @see Time
	 * @see Jogador
	 * @see Estadios
	 */
	public void inicializarJogadores() {
		times.get(0).addJogador("WELLINGTON PAULISTA", Posicao.ATACANTE, 37);
		times.get(0).addJogador("MARTIN BENITEZ", Posicao.MEIA, 25);
		times.get(0).addJogador("IAGO MAIDANA", Posicao.ZAGUEIRO, 26);
		times.get(1).addJogador("VITOR ROQUE", Posicao.PONTA);
		times.get(1).addJogador("PABLO FELIPE", Posicao.ATACANTE, 27);
		times.get(1).addJogador("FERNANDINHO 7X1", Posicao.VOLANTE,39);
		times.get(2).addJogador("WELLINGTON RATO", Posicao.PONTA, 30);
		times.get(2).addJogador("SHAYLON CARDOZO", Posicao.MEIA,24);
		times.get(2).addJogador("LUIZ FERNANDO", Posicao.PONTA, 25);
		times.get(3).addJogador("HULK PARAIBA", Posicao.ATACANTE,34);
		times.get(3).addJogador("NACHO FERNANDEZ", Posicao.MEIA, 32);
		times.get(3).addJogador("JUNIOR ALONSO", Posicao.ZAGUEIRO, 29);
		times.get(4).addJogador("BRUNO SILVA", Posicao.VOLANTE, 33);
		times.get(4).addJogador("KEVIN LATERAL", Posicao.LATERAL, 27);
		times.get(4).addJogador("PAOLO GUERRERO", Posicao.ATACANTE, 38);
		times.get(5).addJogador("ERISON DANILO", Posicao.ATACANTE, 23);
		times.get(5).addJogador("MATHEUS NASCIMENTO", Posicao.ATACANTE, 18);
		times.get(5).addJogador("JOEL CARLI", Posicao.ZAGUEIRO, 35);
		times.get(6).addJogador("STIVEN MENDOZA", Posicao.PONTA, 31);
		times.get(6).addJogador("LEANDRO CACHACA", Posicao.PONTA, 27);
		times.get(6).addJogador("GUIZAO COSTA", Posicao.ZAGUEIRO, 19);
		times.get(7).addJogador("CASSIO RAMOS", Posicao.GOLEIRO, 35);
		times.get(7).addJogador("ROGER GUEDES", Posicao.ATACANTE,28);
		times.get(7).addJogador("LUCAS GOBBI", Posicao.PONTA, 19);
		times.get(8).addJogador("IGOR PAIXAO", Posicao.PONTA);
		times.get(8).addJogador("LEO GAMALHO", Posicao.ATACANTE, 38);
		times.get(8).addJogador("ALEF MANGA", Posicao.PONTA, 21);
		times.get(9).addJogador("RODRIGUINHO REIDRIGUINHO", Posicao.MEIA, 34);
		times.get(9).addJogador("ANDRE BALADA", Posicao.ATACANTE, 34);
		times.get(9).addJogador("DEYVERSON BRUM", Posicao.ATACANTE,32);
		times.get(10).addJogador("GIORGIAN DE ARRASCAETA", Posicao.MEIA, 29);
		times.get(10).addJogador("GABRIEL BARBOSA", Posicao.ATACANTE, 26);
		times.get(10).addJogador("PEDRO QUEIXADA", Posicao.ATACANTE,24);
		times.get(11).addJogador("PH GANSO", Posicao.MEIA, 37);
		times.get(11).addJogador("GERMAN CANO", Posicao.ATACANTE, 33);
		times.get(11).addJogador("JHON ARIAS", Posicao.PONTA,30);
		times.get(12).addJogador("MARCELO BENEVENUTO", Posicao.ZAGUEIRO,29);
		times.get(12).addJogador("MURILO BALA", Posicao.MEIA, 20);
		times.get(12).addJogador("LUCAS LIMA", Posicao.MEIA, 32);
		times.get(13).addJogador("PEDRO RAUL", Posicao.ATACANTE, 26);
		times.get(13).addJogador("APODI ALVES", Posicao.LATERAL, 37);
		times.get(13).addJogador("TADEU ANTONIO", Posicao.GOLEIRO,30);
		times.get(14).addJogador("ALAN PATRICK", Posicao.MEIA, 33);
		times.get(14).addJogador("TAISON BARCELOS", Posicao.MEIA, 34);
		times.get(14).addJogador("WANDERSON MACIEL", Posicao.ATACANTE, 28);
		times.get(15).addJogador("CHICO KIM", Posicao.MEIA,32);
		times.get(15).addJogador("ISIDRO PITTA", Posicao.ATACANTE,23);
		times.get(15).addJogador("RAFAEL FORSTER", Posicao.ZAGUEIRO,32);
		times.get(16).addJogador("RONY RUSTICO", Posicao.ATACANTE,27);
		times.get(16).addJogador("RAPHAEL VEIGA", Posicao.MEIA,29);
		times.get(16).addJogador("GUSTAVO SCARPA", Posicao.MEIA,28);
		times.get(17).addJogador("ALFREDINHO REI", Posicao.PONTA, 21);
		times.get(17).addJogador("DALTRO CARIOCA", Posicao.ZAGUEIRO, 19);
		times.get(17).addJogador("HELINHO MEGAMENTE", Posicao.PONTA, 23);
		times.get(18).addJogador("MARCOS LEONARDO", Posicao.ATACANTE, 18);
		times.get(18).addJogador("ANGELO GABRIEL", Posicao.PONTA);
		times.get(18).addJogador("LEO KING", Posicao.ATACANTE,19);
		times.get(19).addJogador("JONATHAN CALLERI", Posicao.ATACANTE, 28);
		times.get(19).addJogador("RODRIGO NESTOR", Posicao.VOLANTE,22);
		times.get(19).addJogador("MARCOS GUILHERME", Posicao.PONTA, 27);
	}
	
	/**
	 * Metodo responsavel por instanciar partidas iniciais do campeonato
	 * @see Time
	 * @see Jogador
	 * @see Estadios
	 */
	public void inicializarPartidas() {
		//Flu x Santos
		partidas.add(new Partida(times.get(11), times.get(18), Estadios.MARACANA));
		partidas.get(0).finalizarPartida(0, 0, 1);
		
		//AtleticoGO x Flamengo
		partidas.add(new Partida(times.get(2), times.get(10), times.get(2).getEstadio()));
		partidas.get(1).finalizarPartida(1, 1, 1);
		
		//Palmeiras x Ceara
		partidas.add(new Partida(times.get(16), times.get(6), times.get(16).getEstadio()));
		partidas.get(2).finalizarPartida(2, 3, 1);
		
		//Coritiba x Goias
		partidas.add(new Partida(times.get(8), times.get(13), times.get(8).getEstadio()));
		partidas.get(3).finalizarPartida(3, 0, 1);
		
		//Galo x Inter
		partidas.add(new Partida(times.get(3), times.get(14), times.get(3).getEstadio()));
		partidas.get(4).finalizarPartida(2, 0, 1);
		
		//Botafogo x Corinthians
		partidas.add(new Partida(times.get(5), times.get(7), times.get(5).getEstadio()));
		partidas.get(5).finalizarPartida(1, 3, 1);
		
		//Fortaleza x CUiaba
		partidas.add(new Partida(times.get(12), times.get(9), times.get(12).getEstadio()));
		partidas.get(6).finalizarPartida(0, 1, 1);
		
		//SPFC x CAP
		partidas.add(new Partida(times.get(19), times.get(1), times.get(19).getEstadio()));
		partidas.get(7).finalizarPartida(4, 0, 1);
		
		//Avai x AmericaMG
		partidas.add(new Partida(times.get(4), times.get(0), times.get(4).getEstadio()));
		partidas.get(8).finalizarPartida(1, 0, 1);
		
		//Juventude x Bragantino
		partidas.add(new Partida(times.get(15), times.get(17), times.get(15).getEstadio()));
		partidas.get(9).finalizarPartida(2, 2, 1);
	}
	
	//Getters e Setters
	public ArrayList<Time> getTimes() {
		return times;
	}
	
	public ArrayList<Partida> getPartidas(){
		return partidas;
	}


}
