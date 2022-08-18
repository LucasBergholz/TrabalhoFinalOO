package modelo;

import java.util.ArrayList;
import java.util.Random;

public class Partida {
	private Time timeCasa;
	private Time timeFora;
	private Estadios estadio;
	private ArrayList<Jogador> jogadorCasa = new ArrayList<Jogador>();
	private ArrayList<Jogador> jogadorFora = new ArrayList<Jogador>();
	private int rodada;
	private int golsCasa, golsFora;
	
	//Constructor
	public Partida(Time timeCasa, Time timeFora, Estadios estadio) {
		super();
		this.timeCasa = timeCasa;
		this.timeFora = timeFora;
		this.estadio = estadio;
		this.setGolsCasa(0);
		this.setGolsFora(0);
	}
	
	//Analiza se tudo está correto para finalizar a partida
	public boolean finalizarPartida(int golsCasa, int golsFora, int rodada) {
		
		this.rodada = rodada;
		this.golsCasa = golsCasa;
		this.golsFora = golsFora;
		
		Random gerador = new Random();
		this.rodada = rodada;
		for(int i = 0; i < golsCasa; i++) {
			int j = gerador.nextInt(3);
			this.getTimeCasa().getJogadores(j).fazerGol();
		}
		
		for(int i = 0; i < golsFora; i++) {
			int j = gerador.nextInt(3);
			this.getTimeFora().getJogadores(j).fazerGol();
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

	
	//Adicionar quem fez o gol de cada time
	public void addGolCasa(Jogador jogador) {
		jogadorCasa.add(jogador);
	}
	
	public void addGolFora(Jogador jogador) {
		jogadorFora.add(jogador);
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
