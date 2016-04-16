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
	//For Plantes code
	private int myCounter;
	private ServiceQueue myServiceQueue;

	public Cashier(int MaxTimeOfService, ServiceQueue serviceQueue)
	{
		this.myMaxTimeOfService = MaxTimeOfService;
		myThread = new Thread(this);
		myServiceQueue = serviceQueue;
		mySuspended = false;
		//Plantes code
		myCounter = 0;
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

	public int serveCustomer() throws InterruptedException
	{
		if (myServiceQueue.getNumberCustomersInLine() > 0)
		{
			this.waitWhileSuspended();
			myServiceQueue.setNumberCustomersInLine(myServiceQueue.getNumberCustomersInLine() - 1);
			myServiceQueue.setNumberCustomersServedSoFar(myServiceQueue.getNumberCustomersServedSoFar() + 1);
			System.out.println(myServiceQueue.getNumberCustomersServedSoFar());

			try
			{
				Thread.sleep(generateServiceTime());
			}

			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			return myServiceQueue.getNumberCustomersServedSoFar();
		}
		else
			return 0;
	}

	public int generateServiceTime()
	{
		Random random = new Random();
		return random.nextInt(myMaxTimeOfService) + 1;
	}

	public void run()
	{
		try
		{
			synchronized (this)
			{
				this.serveCustomer();
			}
		}
		catch (InterruptedException e)
		{
			System.out.println("Thread " + myThread.getName() + " suspended.");
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
