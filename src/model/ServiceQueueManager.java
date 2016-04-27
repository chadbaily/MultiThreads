package model;

/**
 * Created by chadbaily on 4/12/16.
 */
public class ServiceQueueManager
{
	private final int MAX_NUMBER_OF_QUEUES = 5;
	private int myNumberOfServiceQueues;
	private ServiceQueue[] myServiceQueues;
	private long myTotalWaitTime;
	private long myTotalServiceTime;
	private long myTotalIdleTime;
	private int myTotalServed;
	private float myAverageWaitTime;
	private float myAverageServiceTime;
	private long myAverageIdleTime;
	private long myPresentTime;
	private long myStartTime;

	public ServiceQueueManager()
	{
		myNumberOfServiceQueues =3;
		myServiceQueues = new ServiceQueue[3];
		for (int i = 0; i < myNumberOfServiceQueues; i++)
		{
			myServiceQueues[i] = new ServiceQueue();
		}
		myTotalWaitTime = 0;
		myAverageIdleTime = 0;
		myAverageServiceTime = 0;
		myAverageWaitTime = 0;
		myPresentTime = System.currentTimeMillis();
		myStartTime = System.currentTimeMillis();
		myTotalServiceTime = 0;
		myTotalIdleTime = 0;
	}

	/**
	 * Loops through the service queue, getting each total served, then adding it to myTotalServed
	 *
	 * @return The total customers served in all service queues
	 */
	public int totalServedSoFar()
	{
		for (int i = 0; i < myServiceQueues.length; i++)
		{
			myTotalServed = myTotalServed + myServiceQueues[i].getNumberCustomersServedSoFar();
		}
		return myTotalServed;
	}

	/**
	 * Loops through the service queue, getting each total wait time, then adds it to myTotalWaitTime
	 *
	 * @return The total wait time for all the service queues
	 */
	public long getTotalWaitTime()
	{
		for (int i = 0; i < myServiceQueues.length; i++)
		{
			myTotalWaitTime = myTotalWaitTime + myServiceQueues[i].getTotalWaitTime();
		}
		return myTotalServed;
	}
	
	/**
	 * Method that gets the total amount of customers in a service queue
	 */
	public int getNumCustomers(int queueNum)
	{
		int i =myServiceQueues[queueNum].getNumberCustomersInLine();
		return i;
	}

	/**
	 * Loops through the service queue, getting each total service time, then adds it to myTotalServiceTime
	 *
	 * @return The total service time for all the service queues
	 */
	public long getTotalServiceTime()
	{
		for (int i = 0; i < myServiceQueues.length; i++)
		{
			myTotalServiceTime = myTotalServiceTime + myServiceQueues[i].getTotalServiceTime();
		}
		return myTotalServiceTime;
	}

	/**
	 * Loops through the service queue, getting each total idle time, then adds it to myTotalIdleTime
	 *
	 * @return The total idle time for all the service queues
	 */
	public long getTotalIdleTime()
	{
		for (int i = 0; i < myServiceQueues.length; i++)
		{
			myTotalIdleTime = myTotalIdleTime + myServiceQueues[i].getTotalIdleTime();
		}
		return myTotalIdleTime;
	}

	/**
	 * Loops through all the service queues, getting each length, and compares them. Sets the shortest to a temp
	 * variable
	 *
	 * @return The shortest service queue in the service queue manager
	 */
	public int determineShortestQueue()
	{
		int queueIndex = 0;
		ServiceQueue queue = myServiceQueues[0];
		for (int i = 0; i < myServiceQueues.length; i++)
		{
			if (queue.getNumberCustomersInLine() > myServiceQueues[i].getNumberCustomersInLine() || myServiceQueues[i] == queue)
			{
				queue = myServiceQueues[i];
				queueIndex = i;
				//Delete me later
				System.out.println("Shortest Queue: " + i + " with " + myServiceQueues[i].getNumberCustomersInLine()
						+ " customers");
			}
		}
		return queueIndex;
	}

	/**
	 * Method to add the customer to the shortest service queue
	 *
	 * @return
	 */
	public void addToShortestQueue(Customer customer, int index)
	{

		myServiceQueues[index].enqueue(customer);
	}

	public float getAverageWaitTime()
	{
		return myAverageWaitTime;
	}

	public float getAverageServiceTime()
	{
		return myAverageServiceTime;
	}

	public long getAverageIdleTime()
	{
		return myAverageIdleTime;
	}

	public int getNumberOfServiceQueues()
	{
		return myNumberOfServiceQueues;
	}

	public ServiceQueue[] getServiceQueues()
	{
		return myServiceQueues;
	}
}
