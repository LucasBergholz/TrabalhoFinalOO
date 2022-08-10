package operador;

public class Partida {
	private Time timeCasa;
	private Time timeFora;
	private Estadios estadio;
	private int rodada;
	
	//Constructor
	public Partida(Time timeCasa, Time timeFora, Estadios estadio) {
		super();
		this.timeCasa = timeCasa;
		this.timeFora = timeFora;
		this.estadio = estadio;
	}
	
	//Analiza se tudo está correto para finalizar a partida
	public boolean finalizarPartida(int golsCasa, int golsFora, int rodada) {
		//Checando se os times ja jogaram na rodada escolhida
		if((this.getTimeCasa().getPartidas((rodada-1)) == null) && (this.getTimeFora().getPartidas((rodada-1)) == null)) {
			if(golsCasa > golsFora) {
				//Vitoria do time mandante
				this.getTimeCasa().addVitoria();
				this.getTimeFora().addDerrota();
				this.timeCasa.setSaldoGols(this.timeCasa.getSaldoGols() + (golsCasa - golsFora));
				this.timeFora.setSaldoGols(this.timeFora.getSaldoGols() + (golsFora - golsCasa));
				return true;
			}else if(golsCasa < golsFora) {
				//Vitoria do time visitante
				this.getTimeFora().addVitoria();
				this.getTimeCasa().addDerrota();
				this.timeCasa.setSaldoGols(this.timeCasa.getSaldoGols() + (golsCasa - golsFora));
				this.timeFora.setSaldoGols(this.timeFora.getSaldoGols() + (golsFora - golsCasa));
				return true;
			}else if(golsCasa == golsFora){
				//Empate entre as equipes
				this.getTimeCasa().addEmpate();
				this.getTimeFora().addEmpate();
				return true;
			}else {
				return false;
			}
			
		}else {
			return false;
		}
	}

	//Getters e Setters
	
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
	
	
}
