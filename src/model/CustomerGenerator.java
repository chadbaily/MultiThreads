package model;

/**
 * Class that creates x amount of customers and sends them to the service queue
 * manager
 * 
 * Created by chadbaily on 4/12/16.
 */
public abstract class CustomerGenerator implements Runnable
{
	private int myMaxTimeBetweenCustomers;
	private int myMaxNumberOfCustomers;
	private ServiceQueueManager myServiceQueueManager;
	private Customer myCustomer;
	private Thread myThread;

	/**
	 * Constructor for Customer generator, sets the correct variables
	 * 
	 * @param maxTimeBetweenCustomers
	 * @param serviceQueueManager
	 * @param maxNumberOfCustomers
	 */
	public CustomerGenerator(int maxTimeBetweenCustomers, ServiceQueueManager serviceQueueManager,
			int maxNumberOfCustomers)
	{
		myMaxTimeBetweenCustomers = maxTimeBetweenCustomers;
		myMaxNumberOfCustomers = maxNumberOfCustomers;
		myServiceQueueManager = serviceQueueManager;

	}

	/**
	 * Abstract method for generating time between customers
	 * 
	 * @return
	 */
	public abstract int generateTimeBetweenCustomers();

	/**
	 * Method that creates and returns a customer
	 * 
	 * @return
	 */
	public Customer generateCustomer()
	{
		myCustomer = new Customer();
		return myCustomer;
	}

	/**
	 * Method that loops through and creates the max amount of customers
	 */
	private void makeAllCustomers()
	{
		int o = 0;
		for (int i = 0; i < myMaxNumberOfCustomers; i++)
		{
			int time = this.generateTimeBetweenCustomers();
			Customer customer = generateCustomer();
			o = myServiceQueueManager.determineShortestQueue();
			System.out.println(i);
			myServiceQueueManager.addToShortestQueue(customer, o);
		}
	}

	public void run()
	{
		try
		{

			synchronized (this)
			{
				this.makeAllCustomers();
			}
		}
		catch (NullPointerException e)
		{
			System.exit(0);
			System.out.println("No More Customers: " + e);
		}

	}

	/**
	 * Starts the thread for the customer generator, catches an exception if the
	 * thread is already started
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
		catch (NullPointerException e)
		{
			System.out.println("Null Pointer");
			System.out.println(e);
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
