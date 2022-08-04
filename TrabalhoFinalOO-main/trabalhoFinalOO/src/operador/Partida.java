package operador;

public class Partida {
	private Time timeCasa;
	private Time timeFora;
	private Estadios estadio;
	private int rodada;
	
	//Partida Precisa ter um resultado
	private boolean finalizado;
	
	//Constructor
	public Partida(Time timeCasa, Time timeFora, Estadios estadio, int rodada) {
		super();
		this.timeCasa = timeCasa;
		this.timeFora = timeFora;
		this.estadio = estadio;
		this.rodada = rodada;
	}
	
	//Analiza se tudo está correto para finalizar a partida
	public boolean finalizarPartida(int golsCasa, int golsFora) {
			if(golsCasa > golsFora) {
				this.getTimeCasa().addVitoria();
				this.getTimeFora().addDerrota();
				this.timeCasa.setSaldoGols(this.timeCasa.getSaldoGols() + (golsCasa - golsFora));
				this.timeFora.setSaldoGols(this.timeFora.getSaldoGols() + (golsFora - golsCasa));
				this.setFinalizado(true);
				return true;
			}else if(golsCasa < golsFora) {
				this.getTimeFora().addVitoria();
				this.getTimeCasa().addDerrota();
				this.timeCasa.setSaldoGols(this.timeCasa.getSaldoGols() + (golsCasa - golsFora));
				this.timeFora.setSaldoGols(this.timeFora.getSaldoGols() + (golsFora - golsCasa));
				this.setFinalizado(true);
				return true;
			}else if(golsCasa == golsFora){
				this.getTimeCasa().addEmpate();
				this.getTimeFora().addEmpate();
				this.setFinalizado(true);
				return true;
			}else {
				return false;
			}	
	}

	public Time getTimeCasa() {
		return timeCasa;
	}

	public void setTimeCasa(Time timeCasa) {
		this.timeCasa = timeCasa;
	}

	public Time getTimeFora() {
		return timeFora;
	}

	public void setTimeFora(Time timeFora) {
		this.timeFora = timeFora;
	}

	public Estadios getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadios estadio) {
		this.estadio = estadio;
	}

	public int getRodada() {
		return rodada;
	}

	public void setRodada(int rodada) {
		this.rodada = rodada;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	
	
	
}
