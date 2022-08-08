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
			
			for(int j = 0; j < 20; j++) {
				System.out.println(brasileirao.getTimes().get(j));
			}
		
	}
}
