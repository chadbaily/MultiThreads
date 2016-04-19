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

	public int totalServedSoFar()
	{
		for (int i = 0; i < myServiceQueues.length; i++)
		{
			myTotalServed = myTotalServed + myServiceQueues[i].getNumberCustomersServedSoFar();
		}
		return myTotalServed;
	}

	public long getTotalWaitTime()
	{
		for (int i = 0; i < myServiceQueues.length; i++)
		{
			myTotalWaitTime = myTotalWaitTime + myServiceQueues[i].getTotalWaitTime();
		}
		return myTotalServed;
	}

	public long getTotalServiceTime()
	{
		for (int i = 0; i < myServiceQueues.length; i++)
		{
			myTotalServiceTime = myTotalServiceTime + myServiceQueues[i].getTotalServiceTime();
		}
		return myTotalServiceTime;
	}

	public long getTotalIdleTime()
	{
		for (int i = 0; i < myServiceQueues.length; i++)
		{
			myTotalIdleTime = myTotalIdleTime + myServiceQueues[i].getTotalIdleTime();
		}
		return myTotalIdleTime;
	}

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
