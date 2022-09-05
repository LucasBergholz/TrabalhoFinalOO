package visao;

import bancoDeDados.*;
import controlador.ControleArtilharia;
import modelo.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principal do projeto, responsavel por instanciar os dados iniciais do projeto e a tela de menu
 * @author Lucas Bergholz
 * @author Guilherme Rodrigues
 * @see Listas
 * @see Menu
 */
public class Main {

	public static Listas brasileirao = new Listas();
	
	public static void main(String[] args) {
		brasileirao.inicializarTimes();
		brasileirao.inicializarJogadores();
		brasileirao.inicializarPartidas();
		Menu.main(args);
	}
}