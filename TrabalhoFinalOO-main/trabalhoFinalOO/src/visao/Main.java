package visao;

import bancoDeDados.*;
import modelo.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static Listas brasileirao = new Listas();
	
	public static void main(String[] args) {
		brasileirao.inicializarTimes();
		brasileirao.inicializarJogadores();
		brasileirao.inicializarPartidas();
		Menu.main(args);
	}
}