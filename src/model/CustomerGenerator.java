package model;

/**
 * Created by chadbaily on 4/12/16.
 */
public class CustomerGenerator implements Runnable
{
	private int myMaxTimeBetweenCustomers;

	public CustomerGenerator(int maxTimeBetweenCustomers, ServiceQueueManager serviceQueueManager)
	{

	}

	public int generateTimeBetweenCustomers()
	{
		return 0;
	}

	public Customer generateCustomer()
	{
		return null;
	}

	public void run()
	{

	}

	public void start()
	{

	}

	public int getMyMaxTimeBetweenCustomers()
	{
		return myMaxTimeBetweenCustomers;
	}
}
