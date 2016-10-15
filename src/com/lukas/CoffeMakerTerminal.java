package com.lukas;

import java.util.Scanner;

public class CoffeMakerTerminal {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		CoffeMaker coffeMaker = new CoffeMaker();

		boolean keepRunning = true;
		while (keepRunning) {

			System.out.println("Insert number: \n1 - Make expresso;\n2 - Make cappuccino;\n3 - Fill beans;\n4 - "
					+ "Fill water;\n5 - Fill milk; \n6 - Clean; \n0 - Turn On/Off");
			String input = reader.next();

			if (input.equals("1")) {
				try {
					coffeMaker.checkStatusForCoffe();
					coffeMaker.makeCoffe();
					System.out.println("Expresso is done");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			} else if (input.equals("2")) {
				try {
					coffeMaker.checkStatusForCappuccino();
					coffeMaker.makeCappuccino();
					System.out.println("Cappuccino is done");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			} else if (input.equals("3")) {
				coffeMaker.fillCoffeBeans();

			} else if (input.equals("4")) {
				coffeMaker.fillWaterContainer();

			} else if (input.equals("5")) {
				coffeMaker.fillMilk();

			} else if (input.equals("6")) {
				coffeMaker.clean();

			} else if (input.equals("0")) {
				coffeMaker.turnOn();
				if (coffeMaker.turnOn) {
					System.out.println("is ON");
				} else {
					System.out.println("is OFF");
				}
			}
		}
	}
}
