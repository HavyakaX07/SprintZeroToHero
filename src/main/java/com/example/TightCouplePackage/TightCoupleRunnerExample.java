package com.example.TightCouplePackage;

/*
 * This class will demonstrate TightCoupling of Object.
 * 
 * Example : GameRunner is the playbox that accept the game and it will run the game.
 */
public class TightCoupleRunnerExample {

	public static void main(String[] args) {
		// Create super-mario game
		SuperMario superMarioGame = new SuperMario();

		// Give it to gameRunner
		GameRunner gameRunner = new GameRunner(superMarioGame);

		// Play it
		gameRunner.runGame("superMario");

		// Similarly you can do it for pokeman. So if this is being followed this way of
		// doing and injecting things will lead to class explosion.
		// In order to avoid more changes in maintainance and to incorporate the new
		// changes we will go for Loosely-couple design.
	}

}
