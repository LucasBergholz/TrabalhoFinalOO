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
			jogadorCasa.add(getTimeCasa().getJogadores(j));
		}
		
		for(int i = 0; i < golsFora; i++) {
			int j = gerador.nextInt(3);
			this.getTimeFora().getJogadores(j).fazerGol();
			jogadorFora.add(getTimeFora().getJogadores(j));
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

	public boolean finalizarPartida2(int golsCasa, int golsFora, int rodada) {
		this.rodada = rodada;
		this.golsCasa = golsCasa;
		this.golsFora = golsFora;
		
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
	
	//Funcao que dados dos times e dos goleadores
	public void deletarPartida() {
		if(golsCasa > golsFora) {
			//Vitoria do time mandante
			this.getTimeCasa().setVitorias(getTimeCasa().getVitorias()-1);
			this.getTimeCasa().setPontosTotais(getTimeCasa().getPontosTotais()-3);
			this.getTimeFora().setDerrotas(getTimeFora().getDerrotas()-1);
			this.timeCasa.setSaldoGols(this.timeCasa.getSaldoGols() - (golsCasa - golsFora));
			this.timeFora.setSaldoGols(this.timeFora.getSaldoGols() - (golsFora - golsCasa));
		}else if(golsCasa < golsFora) {
			//Vitoria do time visitante
			this.getTimeFora().setVitorias(getTimeFora().getVitorias()-1);
			this.getTimeFora().setPontosTotais(getTimeFora().getPontosTotais()-3);
			this.getTimeCasa().setDerrotas(getTimeCasa().getDerrotas()-1);
			this.timeCasa.setSaldoGols(this.timeCasa.getSaldoGols() - (golsCasa - golsFora));
			this.timeFora.setSaldoGols(this.timeFora.getSaldoGols() - (golsFora - golsCasa));
		}else if(golsCasa == golsFora){
			//Empate entre as equipes
			this.getTimeCasa().setEmpates(getTimeCasa().getEmpates()-1);
			this.getTimeCasa().setPontosTotais(getTimeCasa().getPontosTotais()-1);
			this.getTimeFora().setEmpates(getTimeFora().getEmpates()-1);
			this.getTimeFora().setPontosTotais(getTimeFora().getPontosTotais()-1);
		}
		this.getTimeCasa().setNumJogos(getTimeCasa().getNumJogos()-1);
		this.getTimeFora().setNumJogos(getTimeFora().getNumJogos()-1);
		
		//Retirar o gol do jogador
		for(int i = 0; i < 11; i++){
			for(int j = 0; j < jogadorCasa.size(); j++){
				if(this.getTimeCasa().getJogadores(i) == jogadorCasa.get(j)) {
					this.getTimeCasa().getJogadores(i).setTotalGols(getTimeCasa().getJogadores(i).getTotalGols()-1);
				}
			}
		}
		for(int i = 0; i < 11; i++){
			for(int j = 0; j < jogadorFora.size(); j++){
				if(this.getTimeFora().getJogadores(i) == jogadorFora.get(j)) {
					this.getTimeFora().getJogadores(i).setTotalGols(getTimeFora().getJogadores(i).getTotalGols()-1);
				}
			}
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
		return timeCasa.getNome() + " " + getGolsCasa() + " X " + getGolsFora() + " " + timeFora.getNome();
	}
	
	
	
}
