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
		for (int i = 0; i < MAX_NUMBER_OF_QUEUES; i++)
		{
			myServiceQueues = new ServiceQueue[i];
		}
		myTotalWaitTime = 0;
		myAverageIdleTime = 0;
		myAverageServiceTime = 0;
		myAverageWaitTime = 0;
		myNumberOfServiceQueues = 0;
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
	public ServiceQueue determineShortestQueue()
	{
		ServiceQueue queue = myServiceQueues[0];
		for (int i = 0; i < myServiceQueues.length; i++)
		{
			if (queue.getNumberCustomersInLine() > myServiceQueues[i].getNumberCustomersInLine())
			{
				queue = myServiceQueues[i];
				System.out.println("Shortest Queue: " + queue);
			}
		}
		return queue;
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

	public void setNumberOfServiceQueues(int numberOfServiceQueues)
	{
		myNumberOfServiceQueues = numberOfServiceQueues;
	}
}
