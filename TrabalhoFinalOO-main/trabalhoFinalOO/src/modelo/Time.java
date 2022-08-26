package modelo;

import java.util.Scanner;

public class Time {
	//Atributos
	private String nome;
	private Tecnico tecnico;
	private Jogador[] jogadores = new Jogador[11];
	private Partida[] partidas = new Partida[18];
	private Estadios estadio;
	private String cor1;
	private String cor2;
	private int numJogos;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int saldoGols;
	private int pontosTotais;
	
	//Construtores
	
	public Time(String nome, String cor1, String cor2,String nomeTecnico ,Estadios estadio) {
		
		this.nome = nome;
		this.cor1 = cor1;
		this.cor2 = cor2;
		this.estadio = estadio;
		this.numJogos = 0;
		this.vitorias = 0;
		this.empates = 0;
		this.derrotas = 0;
		this.saldoGols = 0;
		this.pontosTotais = 0;
		this.setTecnico(new Tecnico(nome, this.getNome()));
	}
	public Time(String nome, String cor1, String cor2, Estadios estadio) {
			
			this.nome = nome;
			this.cor1 = cor1;
			this.cor2 = cor2;
			this.estadio = estadio;
			this.numJogos = 0;
			this.vitorias = 0;
			this.empates = 0;
			this.derrotas = 0;
			this.saldoGols = 0;
			this.pontosTotais = 0;
	}
	public Time(String nome, String cor1, String cor2, Estadios estadio, Jogador jogador, Jogador jogador2, Jogador jogador3, String nomeTecnico) {
		
		this.nome = nome;
		this.cor1 = cor1;
		this.cor2 = cor2;
		this.estadio = estadio;
		this.numJogos = 0;
		this.vitorias = 0;
		this.empates = 0;
		this.derrotas = 0;
		this.saldoGols = 0;
		this.pontosTotais = 0;
		this.jogadores[0] = jogador;
		this.jogadores[1] = jogador2;
		this.jogadores[2] = jogador3;
		this.setTecnico(new Tecnico(nome, this.getNome()));
	}

	//Metodos Concretos
	
	//Criar jogador para o time
	public void addJogador(String nome, Posicao posicao) {
		int  j;
		//Checar se o time ja possui 11 jogadores
		for(j = 0; j< 11; j++) {
			if(this.jogadores[j] == null) {
				this.jogadores[j] = new Jogador(nome, posicao);
				this.jogadores[j].setTime(this.getNome());
				break;
			}	
		}	
	}
	
	//Permitindo um usuario criar o jogador
	/*public void addJogador() {
		int j;
		Scanner in = new Scanner(System.in);
		for(j = 0; j< 11; j++) {
			if(this.jogadores[j] == null) {
				this.jogadores[j] = new Jogador();
				System.out.println("Escreva o nome do jogador: ");
				String name = in.nextLine();
				this.jogadores[j].setNome(name);
				System.out.println("Escreva a posicao do jogador: ");
				String posicao = in.nextLine();
				this.jogadores[j].setPosicao(posicao);
				break;
			}	
		}
		System.out.println("Escreva o nome do jogador: ");
	}*/
	
	//Metodos usados na criacao de uma partida
	private void addJogo() {
		this.setNumJogos(this.getNumJogos() + 1);
	}
	
	public void addVitoria() {
		this.addJogo();
		this.setVitorias(this.getVitorias()+1);;
		this.setPontosTotais(this.getPontosTotais()+3);
	}
	
	public void addEmpate() {
		this.addJogo();
		this.setEmpates(this.getEmpates()+1);
		this.setPontosTotais(this.getPontosTotais()+1);
	}
	
	public void addDerrota() {
		this.addJogo();
		this.setDerrotas(this.getDerrotas()+1);
	}
	
	public void addSaldoGol(int gols) {
		this.saldoGols = this.saldoGols + gols;
	}
	
	//Getters & Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Jogador getJogadores(int i) {
		return jogadores[i];
	}
	
	public Jogador[] getJogadores() {
		return jogadores;
	}
	
	//Caso passe apenas um jogador
	public void setJogadores(Jogador jogador) {
		int n = this.getJogadores().length;
		this.jogadores[n] = jogador;
	}
	//Caso passe o time completo
	public void setJogadores(Jogador[] time) {
		if (time.length == 11)
			this.jogadores = time;
	}

	public Partida[] getPartidas() {
		return partidas;
	}
	
	public Partida getPartidas(int i) {
		return partidas[i];
	}

	public void setPartidas(Partida[] partidas) {
		this.partidas = partidas;
	}

	public Estadios getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadios estadio) {
		this.estadio = estadio;
	}

	public String getCor1() {
		return cor1;
	}

	public void setCor1(String cor1) {
		this.cor1 = cor1;
	}

	public String getCor2() {
		return cor2;
	}

	public void setCor2(String cor2) {
		this.cor2 = cor2;
	}

	public int getNumJogos() {
		return numJogos;
	}

	public void setNumJogos(int numJogos) {
		this.numJogos = numJogos;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getSaldoGols() {
		return saldoGols;
	}

	public void setSaldoGols(int saldoGols) {
		this.saldoGols = saldoGols;
	}

	public int getPontosTotais() {
		return pontosTotais;
	}

	public void setPontosTotais(int pontosTotais) {
		this.pontosTotais = pontosTotais;
	}

	@Override
	public String toString() {
		return "Time [nome=" + nome + ", estadio=" + estadio + ", cor1=" + cor1 + ", cor2=" + cor2 + ", numJogos="
				+ numJogos + ", vitorias=" + vitorias + ", empates=" + empates + ", derrotas=" + derrotas
				+ ", saldoGols=" + saldoGols + ", pontosTotais=" + pontosTotais + "]\n";
	}
	
	
	
	
}
