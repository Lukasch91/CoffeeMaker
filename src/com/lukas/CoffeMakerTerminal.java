package com.lukas;

import java.util.Scanner;

import com.lukas.exceptions.IsNotCleanException;
import com.lukas.exceptions.ResourcesExceptions;
import com.lukas.exceptions.TurnOffException;

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
					coffeMaker.makeCoffe();
					System.out.println("Expresso is done");
				} catch (ResourcesExceptions e) {
					System.out.println("It's not enough resources : " + e.getMessage());
				} catch (TurnOffException e) {
					System.out.println("Coffer maker is switched off : " + e.getMessage());
				}

			} else if (input.equals("2")) {
				try {
					coffeMaker.makeCappuccino();
					System.out.println("Cappuccino is done");
				} catch (ResourcesExceptions e) {
					System.out.println("It's not enough resources : " + e.getMessage());
				} catch (TurnOffException e) {
					System.out.println("Coffer maker is switched off : " + e.getMessage());
				} catch (IsNotCleanException e) {
					System.out.println("Coffee maker is not clean : " + e.getMessage());
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
