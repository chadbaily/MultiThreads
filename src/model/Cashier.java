package model;

import java.util.Random;

/**
 * Created by chadbaily on 4/12/16.
 */
public class Cashier implements Runnable
{
	private int myMaxTimeOfService;
	private Thread myThread;
	private boolean mySuspended;
	private ServiceQueue myServiceQueue;
	private long myServiceTime;

	public Cashier(int MaxTimeOfService, ServiceQueue serviceQueue)
	{
		this.myMaxTimeOfService = MaxTimeOfService;
		myThread = new Thread(this);
		myServiceQueue = serviceQueue;
		mySuspended = false;
	}

	/**
	 * Method that services all customers in the serviceQueue that was passed in. Gets a service time and wait that long
	 * to service the customer. Then the customer is removed from the queue and the service queue is updated to show
	 * this
	 *
	 * @return
	 * @throws InterruptedException
	 */
	public boolean serveCustomer() throws InterruptedException
	{
		while (myServiceQueue.getNumberCustomersInLine() > 0)
		{
			this.waitWhileSuspended();

			try
			{
				myServiceTime = generateServiceTime();
				Thread.sleep(myServiceTime);
				//Delete me later
				System.out.println("Service Time: " + myServiceTime);
			}

			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			((Customer) myServiceQueue.peek()).setServiceTime(myServiceTime);
			myServiceQueue.addToSericeTime(myServiceTime);
			myServiceQueue.serveCustomer();
			//Delete me later
			System.out.println("Customers Served So Far: " + myServiceQueue.getNumberCustomersServedSoFar());
			System.out.println("Customers in Line: " + myServiceQueue.getNumberCustomersInLine() + "\n");

		}
		System.exit(0);
		return myServiceQueue.getNumberCustomersInLine() == 0;
	}

	/**
	 * Method that uses a random generator to create a random number for the cashier to wait before serving a customer
	 *
	 * @return the time the cashier needs to wait before serving a customer
	 */
	public int generateServiceTime()
	{
		Random random = new Random();
		return random.nextInt(myMaxTimeOfService) + 1;
	}

	/**
	 * Is called when start is, calls the serveCustomer()
	 */
	public void run()
	{
		try
		{
			synchronized (this)
			{
				this.serveCustomer();
			}
		}
		catch (NullPointerException e)
		{
			System.out.println("No More Customers: " + e);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * If the thread is suspended then the thread waits until it is changed.
	 *
	 * @throws InterruptedException
	 */
	private void waitWhileSuspended() throws InterruptedException
	{
		while (mySuspended)
		{
			this.wait();
		}
	}

	/**
	 * Starts the thread for the cashier, catches an exception if the thread is already started
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

	public void suspend()
	{
		mySuspended = true;
	}

	public synchronized void resume()
	{
		mySuspended = false;
		this.notify();
	}

	/**
	 * Returns the max time of service that the cashier can have
	 *
	 * @return
	 */
	public int getMyMaxTimeOfService()
	{
		return myMaxTimeOfService;
	}
}
