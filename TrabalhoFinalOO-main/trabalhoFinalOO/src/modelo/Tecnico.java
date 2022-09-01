package modelo;

/**
 * 
 * Classe Reponsavel por guardar os dados do Tecnicos dos Times do Brasileirão.  Utiliza como Base a SuperClasse Pessoa
 * 
 * @author Lucas Gobbi
 * @author Guilherme Rodrigues
 * 
 * @see Pessoa
 * @see Time
 */
public class Tecnico extends Pessoa {
	private int vitorias;
	private int derrotas;
	
	/**
	 * Construtor da Classe Tecnico
	 * @param nome do Tecninco: String
	 * @param nome do Time: String
	 * @see Pessoa
	 */
	public Tecnico(String nome, String time) {
		super();
		this.vitorias = 0;
		this.derrotas = 0;
		this.setNome(nome);
		this.setTime(time);
	}
	
	/**
	 * Metodo que Calcula o aproveitamento de vitórias do Tecnico em função do número de Partidadas que ele comandou
	 * 
	 * @return aproveitamento em formato de porcentagem
	 */
	public String visualizarAproveitamento(){
		double aproveitamento = (double) this.getVitorias()/this.getNumeroPartidas();
		
		return String.format("%s %%", aproveitamento*100);
	}
	
	//GEtters & Setters
	public void ganharPartida(){
		this.setVitorias(this.getVitorias() + 1);
	}
	
	public void perderPartida(){
		
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.setNumeroPartidas(this.getNumeroPartidas() + vitorias);
		this.vitorias = vitorias;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.setNumeroPartidas(this.getNumeroPartidas() + derrotas);
		this.derrotas = derrotas;
	}
	
}
