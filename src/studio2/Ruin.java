package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Input start amount:");
		double startAmount = in.nextDouble();

		System.out.println("Input win chance:");
		double winChance = in.nextDouble();

		System.out.println("Input win limit: ");
		double winLimit = in.nextDouble();
		System.out.println("How many days are you simulating?");
		int totalSimulations = in.nextInt();

		int winCount = 0;
		int loseCount = 0;
		// simulate one day
		int dayNumber = 0;
		int numberRuins = 0;
		int numberWins = 0;

		while (totalSimulations > 0) {
			dayNumber++;
			while (startAmount < winLimit && startAmount > 0) {
				double randomNumber = Math.random();

				if (randomNumber <= winChance) {
					startAmount++;
					winCount++;

					if (startAmount == winLimit) {
						System.out.println("Simulation " + dayNumber + ": Winner!");
						numberWins++;
					}

				} else {
					startAmount--;
					loseCount++;

					if (startAmount == 0) {
						System.out.println("Simulation " + dayNumber + ": Ruin");
						numberRuins++;
					}

				}

			}

			totalSimulations--;

		}
		System.out.println("Number of Plays:" + (winCount + loseCount));
		System.out.println("Wins: " + numberWins + " Ruins: " + numberRuins);
		System.out.println("Ruin rate: " + ((double) numberRuins / ((double) winCount + loseCount)));
	}

}
