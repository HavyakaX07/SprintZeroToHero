package com.example.TightCouplePackage;

public class GameRunner {
	private SuperMario superMario;
	private Pokeman pokemangame;

	/*
	 * Now instead of Each Game type let go with Interface Game so that individual game should implement game 
	 * and adhere to the contract that is ex
	 */
 GameRunner(SuperMario game) {
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
