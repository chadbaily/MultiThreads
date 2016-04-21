package model;

import java.util.Random;

/**
 * Created by chadbaily on 4/12/16.
 */
public class UniformCustomerGenerator
{
	private Random myRandom;
	private int myMaxTimeBeteenCustomers;
	private ServiceQueueManager myServiceQueueManager;

	public UniformCustomerGenerator(int maxTimeBetweenCustomers, ServiceQueueManager serviceQueueManager)
	{
		myMaxTimeBeteenCustomers = maxTimeBetweenCustomers;
		myServiceQueueManager = serviceQueueManager;
	}

	/**
	 * Method to generate the time between customers that are created?
	 * @return
	 */
	public int generateTimeBetweenCustomers()
	{
		myRandom = new Random();
		return myRandom.nextInt(myMaxTimeBeteenCustomers) + 1;
	}
}
