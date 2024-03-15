package com.example.LooslyCoupledRunnerExample;
import com.example.LooslyCoupledRunnerExample.GameRunner;

/*
 * This class will demonstrate TightCoupling of Object.
 * 
 * Example : GameRunner is the playbox that accept the game and it will run the game.
 */
public class LooslyCoupledRunnerExample {

	public static void main(String[] args) {
		// Create super-mario game
		SuperMario superMarioGame = new SuperMario();

		// Give it to gameRunner
		GameRunner gameRunner = new GameRunner(superMarioGame);

		// Play it
		gameRunner.runGame("superMario");

		// Similarly you can do it for pokeman.
		/*
		 * So in this way we can achive Loosly coupled software design that is easy to
		 * maintain and handle new changes.
		 */
	}

}
