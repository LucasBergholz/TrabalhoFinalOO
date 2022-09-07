package modelo;

/**
 * Classe Responsavel por armazenar os dados e ações dos Jogadores do brasileirão 2022; Utiliza como Base a SuperClasse Pessoa
 * @author Guilherme Rodrigues
 * @author Lucas Gobbi
 * @see Pessoa
 * @see Time
 */
public class Jogador extends Pessoa {
	
	//Atributos
	private int totalGols;
	private Posicao posicao;
	
	
	//Construtores
	
	/**
	 * Construtor da Classe Jogador
	 * 
	 * @param time pelo qual o Jogador irá Jogar: Time
	 * @param nome do Jogador: String
	 * @param posicao na qual o Jogador joga
	 * @see Pessoa
	 * @see Time
	 * @see Posicao
	 */
	public Jogador(Time time, String nome, Posicao posicao) {
		super();
		setTime(time.getNome());
		this.setTotalGols(0);
		this.posicao = posicao;
		setNome(nome);
	}
	
	/**
	 * Construtor da Classe Jogador
	 * 
	 * @param nome do Jogador: String
	 * @param posicao na qual o Jogador Joga
	 * 
	 * @see Pessoa
	 * @see Posicao
	 */
	public Jogador(String nome, Posicao posicao) {
		super();
		this.setTotalGols(0);
		this.posicao = posicao;
		setNome(nome);
	}
	
	/**
	 * Construtor da Classe Jogador utilizando como Base o Construtor da SuperClasse Pessoa
	 * @see Pessoa
	 */
	public Jogador() {
		super();
	}
	//Metodos concretos
	
	/**
	 * Metodo que adiona em +1 o número de gols do Jogador
	 */
	public void fazerGol() {
		this.setTotalGols(this.getTotalGols() + 1);;
	}
	
	
	//Getters & Setters
	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}


	public int getTotalGols() {
		return totalGols;
	}

	public void setTotalGols(int totalGols) {
		this.totalGols = totalGols;
	}
	
	/**
	 * Sobrescrita do metodo toString retornando apenas o Nome e Posição do Jogador
	 * 
	 * @return nome: "nome Jogador" ; posicao: "PosicaoJogador"
	 * @see Posicao
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "nome: " + this.getNome() +"\nposicao: " + this.getPosicao();
	}
}

