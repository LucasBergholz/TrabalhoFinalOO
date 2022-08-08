package bancoDeDados;

import operador.*;
import java.util.ArrayList;

public class Listas {
	//Criando ArrayList dos times;
		private static final ArrayList<Time> times = new ArrayList<>();
		private static final ArrayList<Jogador> jogadores = new ArrayList<>();
		
		public void inicializarTimes() {
			times.add(new Time("AMERICA-MG", "#00FF00", "#FFFFFF", Estadios.INDEPENDENCIA));
			times.add(new Time("ATHLETICO-PR", "#FF0000", "#000000", Estadios.ARENA_DA_BAIXADA));
			times.add(new Time("ATLETICO-GO", "#FFFFFF", "#000000", Estadios.ANTONIO_ACCIOLY));
			times.add(new Time("ATLETICO-MG", "#000000", "#FFFFFF", Estadios.MINEIRAO));
			times.add(new Time("AVAI", "#0000FF", "#FFFFFF", Estadios.RESSACADA));
			times.add(new Time("BOTAFOGO", "#000000", "#FFFFFF", Estadios.NILTON_SANTOS));
			times.add(new Time("CEARA", "#000000", "#FFFFFF", Estadios.CASTELAO));
			times.add(new Time("CORINTHIANS", "#FFFFFF", "#000000", Estadios.NEO_QUIMICA_ARENA));
			times.add(new Time("CORITIBA", "#008000", "#FFFFFF", Estadios.COUTO_PEREIRA));
			times.add(new Time("CUIABA", "#008000", "#FFEE05", Estadios.ARENA_PANTANAL));
			times.add(new Time("FLAMENGO", "#FF0000", "#000000", Estadios.MARACANA));
			times.add(new Time("FLUMINENSE", "#831D1C", "#146b02", Estadios.MARACANA));
			times.add(new Time("FORTALEZA", "#0000FF", "#FF0000", Estadios.CASTELAO));
			times.add(new Time("GOIAS", "#008000", "#FFFFFF", Estadios.SERRINHA));
			times.add(new Time("INTERNACIONAL", "#FF0000", "#FFFFFF", Estadios.BEIRA_RIO));
			times.add(new Time("JUVENTUDE", "#008000", "#FFFFFF", Estadios.ALFREDO_JACONI));
			times.add(new Time("PALMEIRAS", "#008000", "#FFFFFF", Estadios.ALLIANZ_PARQUE));
			times.add(new Time("RED BULL BRAGANTINO", "#FFFFFF", "#FF0000", Estadios.NABI_ABI_CHEDID));
			times.add(new Time("SANTOS", "#0000000", "#FFFFFF", Estadios.VILA_BELMIRO));
			times.add(new Time("SAO PAULO", "#FF0000", "#FFFFFF", Estadios.MORUMBI));
		}

		public ArrayList<Time> getTimes() {
			return times;
		}


}
