package controlador;

import visao.Menu;
import bancoDeDados.*;
import modelo.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	Listas brasileirao = new Listas();
		brasileirao.inicializarTimes();
		brasileirao.inicializarJogadores();
		brasileirao.inicializarPartidas();
		Menu.main(args);
	}
}
