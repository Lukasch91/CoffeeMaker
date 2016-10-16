package com.lukas;

import com.lukas.exceptions.BeansException;
import com.lukas.exceptions.IsNotCleanException;
import com.lukas.exceptions.MilkException;
import com.lukas.exceptions.ResourcesExceptions;
import com.lukas.exceptions.TurnOffException;
import com.lukas.exceptions.WaterException;

public class CoffeMaker {
	private final static int FULL_WATER_CONTAINER = 15;
	private final static int FULL_COFFE_BEANS_CONTAINER = 5;
	private final static int FULL_MILK_CONTAINER = 10;
	private final static int NEED_TO_CLEAN_AFTER_SERVINGS_OF_CAPPUCCINO = 7;
	private int waterLeft;
	private int coffeBeansLeft;
	private int milkLeft;
	private int totalMadeCappucino;
	boolean turnOn = false;

	public void makeCoffe() throws ResourcesExceptions, TurnOffException {
		checkStatusForCoffe();
		waterLeft--;
		coffeBeansLeft--;
	}

	public void makeCappuccino() throws ResourcesExceptions, TurnOffException, IsNotCleanException {
		checkStatusForCappuccino();
		waterLeft--;
		coffeBeansLeft--;
		milkLeft--;
		totalMadeCappucino++;
	}

	public void turnOn() {
		if (!turnOn) {
			turnOn = true;
		} else if (turnOn) {
			turnOn = false;
		}

	}

	public void fillWaterContainer() {
		waterLeft = FULL_WATER_CONTAINER;
	}

	public void fillCoffeBeans() {
		coffeBeansLeft = FULL_COFFE_BEANS_CONTAINER;
	}

	public void fillMilk() {
		milkLeft = FULL_MILK_CONTAINER;

	}

	public boolean isWaterContainerEmpty() {
		if (waterLeft <= 0)
			return true;
		return false;
	}

	public boolean isBeansContainerEmpty() {
		if (coffeBeansLeft <= 0)
			return true;
		return false;
	}

	public boolean isMilkContainerEmpty() {
		if (milkLeft <= 0)
			return true;
		return false;
	}

	public void clean() {
		totalMadeCappucino = 0;
	}

	public void checkStatusForCoffe() throws ResourcesExceptions, TurnOffException {
		if (isBeansContainerEmpty())
			throw new BeansException("fill beans");
		if (isWaterContainerEmpty())
			throw new WaterException("fill water");
		if (turnOn == false)
			throw new TurnOffException("please, turn on coffee maker");
	}

	public void checkStatusForCappuccino() throws ResourcesExceptions, TurnOffException, IsNotCleanException {
		if (isBeansContainerEmpty())
			throw new BeansException("fill beans");
		if (isMilkContainerEmpty())
			throw new MilkException("fill milk");
		if (isWaterContainerEmpty())
			throw new WaterException("fill water");
		if (totalMadeCappucino > NEED_TO_CLEAN_AFTER_SERVINGS_OF_CAPPUCCINO)
			throw new IsNotCleanException("need to clean coffee maker");
		if (turnOn == false)
			throw new TurnOffException("please, turn on coffee maker");
	}
}
