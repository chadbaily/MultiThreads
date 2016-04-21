package model;

/**
 * Created by chadbaily on 4/12/16.
 */
public abstract class CustomerGenerator implements Runnable
{
	private int myMaxTimeBetweenCustomers;
	private int myMaxNumberOfCustomers;
	private ServiceQueueManager myServiceQueueManager;
	private Customer myCustomer;
	private Thread myThread;

	public CustomerGenerator(int maxTimeBetweenCustomers, ServiceQueueManager serviceQueueManager,
			int maxNumberOfCustomers)
	{
		myMaxTimeBetweenCustomers = maxTimeBetweenCustomers;
		myMaxNumberOfCustomers = maxNumberOfCustomers;
		myServiceQueueManager = serviceQueueManager;

	}

	public abstract int generateTimeBetweenCustomers();

	public Customer generateCustomer()
	{
		myCustomer = new Customer();
		return myCustomer;
	}

	private void makeAllCustomers()
	{
		int o = 0;
		for (int i = 0; i < myMaxNumberOfCustomers; i++)
		{
			int time = this.generateTimeBetweenCustomers();
			Customer customer = generateCustomer();
			o = myServiceQueueManager.determineShortestQueue();
			myServiceQueueManager.addToShortestQueue(customer, o);
		}
	}

	public void run()
	{
		synchronized (this)
		{
			this.makeAllCustomers();
		}
	}

	/**
	 * Starts the thread for the customer generator, catches an exception if the thread is already started
	 */

	public void start()
	{
		try
		{
			myThread.start();
		}
		catch (IllegalThreadStateException e)
		{
			System.out.println("Thread already started");
		}
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
