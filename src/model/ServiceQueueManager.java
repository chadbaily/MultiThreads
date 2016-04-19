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
		return 0;
	}

	public long getTotalWaitTime()
	{
		return myTotalWaitTime;
	}

	public long getTotalServiceTime()
	{
		return myTotalServiceTime;
	}

	public long getTotalIdleTime()
	{
		return myTotalIdleTime;
	}

	public ServiceQueue determineShortestQueue()
	{
		return null;
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

	public void setNumberOfServiceQueues(int NumberOfServiceQueues)
	{
		myNumberOfServiceQueues = NumberOfServiceQueues;
	}
}
