package operador;

public class Partida {
	private Time timeCasa;
	private Time timeFora;
	private Estadios estadio;
	private int rodada;
	
	//Precisamos saber de quem é o gol
	private int golsCasa; 
	private int golsFora;
	private boolean emAndamento;
	
	//Partida Precisa ter um resultado
	private boolean finalizado;
	private Time ganhador;
	
	//Constructor
	public Partida(Time timeCasa, Time timeFora, Estadios estadio, int rodada) {
		super();
		this.timeCasa = timeCasa;
		this.timeFora = timeFora;
		this.estadio = estadio;
		this.rodada = rodada;
		this.golsCasa = 0;
		this.golsFora = 0;
		this.setFinalizado(false);
	}

	//Boolean para retornar falso caso não adcione o gol
	public boolean addGol(Time marcador){
		if(!this.isFinalizado()) {
			if(this.getTimeCasa() == marcador) {
				this.setGolsCasa(this.getGolsCasa()+1);
				this.timeCasa.setSaldoGols(this.timeCasa.getSaldoGols()+1);
				return true;
			}else if(this.getTimeFora() == marcador) {
				this.setGolsFora(this.getGolsFora()+1);
				this.timeFora.setSaldoGols(this.timeFora.getSaldoGols()+1);
				return true;
			}else
				return false;
		}else {
			return false;
		}
	}
	
	public void imprimePartida() {
		
	}
	
	//Analiza se tudo está correto para finalizar a partida
	public boolean finalizarPartida(Time ganhador) {
		if(!this.isFinalizado()) {
			if(this.getTimeCasa() == ganhador) {
				this.setEmAndamento(false);
				this.setGanhador(ganhador);
				this.getTimeCasa().addVitoria();
				this.getTimeFora().addDerrota();
				this.setFinalizado(true);
				return true;
			}else if(this.getTimeFora() == ganhador) {
				this.setEmAndamento(false);
				this.setGanhador(this.getTimeFora());
				this.getTimeFora().addVitoria();
				this.getTimeCasa().addDerrota();
				this.setFinalizado(true);
				return true;
			}else {
				return false;
			}	
		}else {
			return false;
		}
	}
	
	//Finalizar partida como empate
	public boolean finalizarPartida(boolean empate) {
		if(!this.isFinalizado() && empate) {
			
			this.getTimeCasa().addEmpate();
			this.getTimeFora().addEmpate();
			this.setFinalizado(true);
			
			return empate;
		}
		return false;
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

	public boolean isEmAndamento() {
		return emAndamento;
	}

	public void setEmAndamento(boolean emAndamento) {
		this.emAndamento = emAndamento;
	}

	public Time getGanhador() {
		return ganhador;
	}

	public void setGanhador(Time ganhador) {
		this.ganhador = ganhador;
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

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	
	
	
}
