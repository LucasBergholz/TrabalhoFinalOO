package controlador;

import operador.*;
import bancoDeDados.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Listas brasileirao = new Listas();
		brasileirao.inicializarTimes();
		brasileirao.inicializarJogadores();
			
			for(int j = 0; j < 20; j++) {
				System.out.println(brasileirao.getTimes().get(j).getNome() + "\n");
				for(int i = 0; i < 3; i++) {
					System.out.println(brasileirao.getTimes().get(j).getJogadores(i));
				}
				System.out.println("\n");
				//System.out.println(brasileirao.getTimes().get(j));
			}
		
	}
}
