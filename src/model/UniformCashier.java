package model;

import java.util.Random;

/**
 * Created by chadbaily on 4/12/16.
 */
public class UniformCashier extends Cashier
{
	private Random myRandom;
	private int myMaxTimeOfService;

	public UniformCashier(int maxTimeService, ServiceQueue serviceQueue)
	{
		super(maxTimeService, serviceQueue);
	}

	/**
	 * Generates a random time for the cashier
	 */
	public int generateServiceTime()
	{
		myRandom = new Random();
		return myRandom.nextInt(myMaxTimeOfService) + 1;
	}
}
