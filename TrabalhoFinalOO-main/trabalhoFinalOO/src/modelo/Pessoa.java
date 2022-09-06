package modelo;

/**
 * Classe Abstrata reprensentando uma Pessoa Generica
 * 
 * @author Guilherme Rodrigues
 * @author Lucas Gobbi
 * 
 * @see Jogador
 * @see Tecnico
 */
public abstract class Pessoa {
	
	private String nome;
	private String time;
	private int idade;
	private int numeroPartidas;
	
	/**
	 * Construtor da Classe Pessoa usado como base para suas SubClasses
	 * 
	 * @see Jogador
	 * @see Tecnico
	 */
	public Pessoa() {
		super();
		this.setNumeroPartidas(0);
		this.setIdade(18);
	}
	
	/**
	 * Metodo que adciona em +1 a quantidade de partidas que a Pessoa Jogou/Participou
	 */
	public void jogarPartida() {
		this.setNumeroPartidas(this.getNumeroPartidas() + 1);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getNumeroPartidas() {
		return numeroPartidas;
	}

	public void setNumeroPartidas(int numeroPartidas) {
		this.numeroPartidas = numeroPartidas;
	}
	

}
