package controlador;

import operador.Estadios;
import operador.Tecnico;
import operador.Time;

public class Main {

	public static void main(String[] args) {
		Tecnico t = new Tecnico();
		
		//Criando ArrayList dos times;
		Time[] times = new Time[20];
		
		//Criando os times;
		times[0] = new Time("AMERICA-MG", "#00FF00", "#FFFFFF", Estadios.INDEPENDENCIA);
		times[1] = new Time("ATHLETICO-PR", "#FF0000", "#000000", Estadios.ARENA_DA_BAIXADA);
		times[2] = new Time("ATLETICO-GO", "#FFFFFF", "#000000", Estadios.ANTONIO_ACCIOLY);
		times[3] = new Time("AVAI", "#0000FF", "#FFFFFF", Estadios.RESSACADA);
		times[4] = new Time("BOTAFOGO", "#000000", "#FFFFFF", Estadios.NILTON_SANTOS);
		times[5] = new Time("CEARA", "#000000", "#FFFFFF", Estadios.CASTELAO);
		times[6] = new Time("CORINTHIANS", "#FFFFFF", "#000000", Estadios.NEO_QUIMICA_ARENA);
		times[7] = new Time("CORITIBA", "#008000", "#FFFFFF", Estadios.COUTO_PEREIRA);
		times[8] = new Time("CUIABA", "#008000", "#FFEE05", Estadios.ARENA_PANTANAL);
		times[9] = new Time("FLAMENGO", "#FF0000", "#000000", Estadios.MARACANA);
		times[10] = new Time("FLUMINENSE", "#831D1C", "#146b02", Estadios.MARACANA);
		times[11] = new Time("FORTALEZA", "#0000FF", "#FF0000", Estadios.CASTELAO);
		times[12] = new Time("GOIAS", "#008000", "#FFFFFF", Estadios.SERRINHA);
		times[13] = new Time("INTERNACIONAL", "#FF0000", "#FFFFFF", Estadios.BEIRA_RIO);
		times[14] = new Time("JUVENTUDE", "#008000", "#FFFFFF", Estadios.ALFREDO_JACONI);
		times[15] = new Time("PALMEIRAS", "#008000", "#FFFFFF", Estadios.ALLIANZ_PARQUE);
		times[16] = new Time("RED BULL BRAGANTINO", "#FFFFFF", "#FF0000", Estadios.NABI_ABI_CHEDID);
		times[17] = new Time("SANTOS", "#0000000", "#FFFFFF", Estadios.VILA_BELMIRO);
		times[18] = new Time("SAO PAULO", "#FF0000", "#FFFFFF", Estadios.MORUMBI);
		times[19] = new Time("ATLETICO-MG", "#000000", "#FFFFFF", Estadios.MINEIRAO);
		
		
		for(int i = 0; i < 20; i++) {
			System.out.println(times[i]);
		}
		//System.out.println(times[4].getJogadores(0));
	}
}
