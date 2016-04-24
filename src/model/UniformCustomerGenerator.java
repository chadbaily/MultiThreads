package model;

import java.util.Random;

/**
 * Created by chadbaily on 4/12/16.
 */
public class UniformCustomerGenerator extends CustomerGenerator
{
	private Random myRandom;
	private int myMaxTimeBeteenCustomers;
	private ServiceQueueManager myServiceQueueManager;
	private int myMaxNumberOfCustomers;

	public UniformCustomerGenerator(int maxTimeBetweenCustomers, ServiceQueueManager serviceQueueManager,
			int maxNumberOfCustomers)
	{
		super(maxTimeBetweenCustomers, serviceQueueManager, maxNumberOfCustomers);

		myMaxTimeBeteenCustomers = maxTimeBetweenCustomers;
		myServiceQueueManager = serviceQueueManager;
		myMaxNumberOfCustomers = maxNumberOfCustomers;
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
