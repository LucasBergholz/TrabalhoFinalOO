package modelo;

public class Tecnico extends Pessoa {
	private int vitorias;
	private int derrotas;
	
	public Tecnico() {
		super();
		this.vitorias = 0;
		this.derrotas = 0;
		// TODO Auto-generated constructor stub
	}
	
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
