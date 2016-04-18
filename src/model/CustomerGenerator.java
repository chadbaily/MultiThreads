package model;

/**
 * Created by chadbaily on 4/12/16.
 */
public class CustomerGenerator implements Runnable
{
	private int myMaxTimeBetweenCustomers;
	private int myMaxNumberOfCustomers;
	private ServiceQueueManager myServiceQueueManager;
	private Customer myCustomer;

	public CustomerGenerator(int maxTimeBetweenCustomers, ServiceQueueManager serviceQueueManager,
			int maxNumberOfCustomers)
	{
		myMaxTimeBetweenCustomers = maxTimeBetweenCustomers;
		myMaxNumberOfCustomers = maxNumberOfCustomers;
		myServiceQueueManager = serviceQueueManager;

	}

	public int generateTimeBetweenCustomers()
	{
		return 0;
	}

	public Customer generateCustomer()
	{
		myCustomer = new Customer();
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

	public int getMyMaxNumberOfCustomers()
	{
		return myMaxNumberOfCustomers;
	}

	public ServiceQueueManager getMyServiceQueueManager()
	{
		return myServiceQueueManager;
	}
}
