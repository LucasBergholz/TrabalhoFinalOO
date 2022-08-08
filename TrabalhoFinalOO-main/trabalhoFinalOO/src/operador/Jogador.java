package operador;

public class Jogador extends Pessoa {
	private int totalGols;
	private Posicao posicao;
	
	//Metodos concretos
	public void fazerGol() {
		this.setTotalGols(this.getTotalGols() + 1);;
	}
	

	//Construtores
	public Jogador(Time time, String nome, Posicao posicao) {
		super();
		setTime(time);
		this.setTotalGols(0);
		this.posicao = posicao;
		setNome(nome);
	}
	
	public Jogador(String nome, Posicao posicao) {
		super();
		this.setTotalGols(0);
		this.posicao = posicao;
		setNome(nome);
	}
	
	public Jogador() {
		super();
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
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "nome: " + this.getNome() +"\nposicao: " + this.getPosicao();
	}
}

