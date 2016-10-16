package com.lukas;



import org.junit.Assert;
import org.junit.Test;

import com.lukas.exceptions.ResourcesExceptions;
import com.lukas.exceptions.TurnOffException;


public class CoffeMakerTest {

	@Test
	public void shouldReduceCoffeeBeansByOne() throws ResourcesExceptions, TurnOffException {
		//Given
		CoffeMaker coffeMaker = new CoffeMaker();
		coffeMaker.turnOn = true;
		coffeMaker.waterLeft = 10;
		coffeMaker.coffeBeansLeft = 10;
		
		//When
		coffeMaker.makeCoffe();
		
		//Then
		Assert.assertEquals(9, coffeMaker.coffeBeansLeft);

	}
	
	@Test(expected = ResourcesExceptions.class)
	public void shouldThrowExceptionThenWaterEmpty() throws ResourcesExceptions, TurnOffException {
		//Given
		CoffeMaker coffeMaker = new CoffeMaker();
		coffeMaker.turnOn = true;
		coffeMaker.waterLeft = 0;
		coffeMaker.coffeBeansLeft = 10;
		
		//When
		coffeMaker.makeCoffe();

	}

}
