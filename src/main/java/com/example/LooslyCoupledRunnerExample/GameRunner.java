package com.example.LooslyCoupledRunnerExample;

public class GameRunner {
	
	/*
	 * As game type increased constructor overloading also increases. 
	 * Or in other way we can maintain only one constructor as game changes developer needs to change game type
	 * in constructor.
	 */
	private SuperMario superMario;
	private Pokeman pokemangame;
	
	public GameRunner(SuperMario game) {
		superMario = game;
	}
	
	public GameRunner(Pokeman game) {
		pokemangame = game;
	}
	
	public void runGame(String gameName) {
		if(gameName.equalsIgnoreCase("superMario") && superMario !=null) {
			superMario.playGame();
		}
		else if(gameName.equalsIgnoreCase("pokeman") && pokemangame !=null) {
			pokemangame.playGame();
		}
		else {
			System.out.println("Invalid game");
		}
	}

}
