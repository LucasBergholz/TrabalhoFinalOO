package controlador;

import bancoDeDados.*;
import modelo.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Listas brasileirao = new Listas();
		brasileirao.inicializarTimes();
		brasileirao.inicializarJogadores();
		brasileirao.inicializarPartidas();
	}
}
