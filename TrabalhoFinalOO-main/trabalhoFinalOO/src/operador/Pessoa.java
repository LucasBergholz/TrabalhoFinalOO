package operador;

public abstract class Pessoa {
	
	private String nome;
	private Time time;
	private int idade;
	private int numeroPartidas;
	
	
	public Pessoa() {
		super();
		this.setNumeroPartidas(0);
		this.setIdade(0);
	}

	public void jogarPartida() {
		this.setNumeroPartidas(this.getNumeroPartidas() + 1);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
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
