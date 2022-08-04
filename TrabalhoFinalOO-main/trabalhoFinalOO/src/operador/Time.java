package operador;

public class Time {
	//Atributos
	private String nome;
	private Tecnico tecnico;
	private Jogador[] jogadores = new Jogador[11];
	private Estadios estadio;
	private String cor1;
	private String cor2;
	private int numJogos;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int saldoGols;
	private int pontosTotais;
	
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
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//Metodos Concretos 
	public void addJogador(String nome, String posicao) {
		int  j;
		
		for(j = 0; j< 11; j++) {
			if(this.jogadores[j] == null) {
				this.jogadores[j] = new Jogador(nome, posicao);
				break;
			}	
		}	
	}
	
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

	private void setNumJogos(int numJogos) {
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

	private void setPontosTotais(int pontosTotais) {
		this.pontosTotais = pontosTotais;
	}

	@Override
	public String toString() {
		return "Time [nome=" + nome + ", estadio=" + estadio + ", cor1=" + cor1 + ", cor2=" + cor2 + ", numJogos="
				+ numJogos + ", vitorias=" + vitorias + ", empates=" + empates + ", derrotas=" + derrotas
				+ ", saldoGols=" + saldoGols + ", pontosTotais=" + pontosTotais + "]\n";
	}
	
	
	
	
}
