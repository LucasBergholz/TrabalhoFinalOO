package modelo;

public class Partida {
	private Time timeCasa;
	private Time timeFora;
	private Estadios estadio;
	private int rodada;
	private int golsCasa, golsFora;
	
	//Constructor
	public Partida(Time timeCasa, Time timeFora, Estadios estadio) {
		super();
		this.timeCasa = timeCasa;
		this.timeFora = timeFora;
		this.estadio = estadio;
		this.golsCasa = 0;
		this.golsFora = 0;
	}
	

	//Analiza se tudo está correto para finalizar a partida
	public boolean finalizarPartida(int golsCasa, int golsFora, int rodada) {
		this.golsCasa = golsCasa;
		this.golsFora = golsFora;
		this.rodada = rodada;
		for(int i = 0; i < golsCasa; i++) {
			int j = 0;
			this.getTimeCasa().getJogadores(j).fazerGol();
			if(j == 3) {
				j = 0;
			} else {
				j++;
			}
		}
		
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
	public int getGolsCasa() {
		return golsCasa;
	}
	
	public void setGolsCasa(int golsCasa) {
		this.golsCasa = golsCasa;
	}
	
	public int getGolsFora() {
		return golsFora;
	}
	
	public void setGolsFora(int golsFora) {
		this.golsFora = golsFora;
	}

	@Override
	public String toString() {
		return "Partida [timeCasa=" + timeCasa.getNome() + ", timeFora=" + timeFora.getNome() + ", estadio=" + estadio + ", rodada="
				+ rodada + "]";
	}
	
	
	
}
