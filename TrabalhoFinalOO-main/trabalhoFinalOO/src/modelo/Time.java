package modelo;

import java.util.ArrayList;
/**
 * Classe que Representa os Times que Participam da Serie A do Brasileirão 2022, tendo como Atributos seu nome, Jogadores, estadio, cores, jogos, etc..
 * 
 * @author Guilherme Rodrigues
 * @author Lucas Gobbi
 * 
 * @see Jogador
 * @see Estadios
 * @see Tecnico
 * @see Partida
 */
public class Time {
	//Atributos
	private String nome;
	private Tecnico tecnico;
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
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
	/**
	 * Construtor da Classe Time
	 * 
	 * @param nome do time
	 * @param Cor principal do time em Hexadecimal
	 * @param cor secundaria  em Hexadecimal
	 * @param nome do Tecnico
	 * @param estadio do Time
	 * 
	 * @see Jogador
	 * @see Estadios
	 * @see Tecnico
	 * @see Partida
	 */
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
	
	/**
	 * Construtor da Classe Time
	 * 
	 * @param nome do time
	 * @param Cor principal do time em Hexadecimal
	 * @param cor secundaria em Hexadecimal
	 * @param estadio do Time
	 * 
	 * @see Jogador
	 * @see Estadios
	 * @see Tecnico
	 * @see Partida
	 */
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
	/**
	 * Construtor da Classe Time
	 * 
	 * @param nome
	 * @param cor1
	 * @param cor2
	 * @param estadio
	 * @param jogador
	 * @param jogador2
	 * @param jogador3
	 * @param nomeTecnico
	 * 
	 * @see Jogador
	 * @see Estadios
	 * @see Tecnico
	 * @see Partida
	 */
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
		jogadores.add(jogador);
		jogadores.add(jogador2);
		jogadores.add(jogador3);
		this.setTecnico(new Tecnico(nome, this.getNome()));
	}

	//Metodos Concretos
	
	/**
	 * Metodo que instancia um jogador no Time
	 * 
	 * @param nome do Jogador
	 * @param posicao do Jogador
	 * 
	 * @see Posicao
	 * @see Jogador
	 */
	public void addJogador(String nome, Posicao posicao) {
		int j = jogadores.size();
		jogadores.add(new Jogador(nome, posicao));
		jogadores.get(j).setTime(this.getNome());
	}	
	
	/**
	 * Metodo que remove o Jogador Passado como Parametro do Time
	 * 
	 * @param jogador
	 */
	public void deletarJogador(Jogador jogador) {
		for(int i = 0; i < jogadores.size(); i++) {
			if(jogador == jogadores.get(i)) {
				jogadores.remove(i);
			}
		}
	}
	
	//Metodos usados na criacao de uma partida
	/**
	 * Metodo que adiciona em +1 o numero de Partidas Jogadas pelo Time no Campeonato
	 */
	private void addJogo() {
		this.setNumJogos(this.getNumJogos() + 1);
	}
	/**
	 * Metodo que Adciona uma vitória ao Historico do time, atualizando tambem sua pontuação e numero de jogos jogados
	 * 
	 */
	public void addVitoria() {
		this.addJogo();
		this.setVitorias(this.getVitorias()+1);;
		this.setPontosTotais(this.getPontosTotais()+3);
	}
	/**
	 * Metodo que Adciona um empate ao Historico do time, atualizando tambem sua pontuação e numero de jogos jogados
	 */
	public void addEmpate() {
		this.addJogo();
		this.setEmpates(this.getEmpates()+1);
		this.setPontosTotais(this.getPontosTotais()+1);
	}
	/**
	 * Metodo que Adciona uma derrota ao Historico do time, atualizando tambem seu número de jogos jogados
	 */
	public void addDerrota() {
		this.addJogo();
		this.setDerrotas(this.getDerrotas()+1);
	}
	/**
	 * Metodo que atualiza o Saldo de Gols do Time no Campeonato
	 * 
	 * @param gols feitos pelo Time
	 */
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
		return jogadores.get(i);
	}
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}
	
	public int getJogadoresSize() {
		return jogadores.size();
	}
	
	//Caso passe apenas um jogador
	public void setJogadores(Jogador jogador) {
		jogadores.add(jogador);
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
