package model;

/**
 * Created by chadbaily on 4/12/16.
 */
public class ServiceQueueManager
{
	private final int MAX_NUMBER_OF_QUEUES = 5;
	private int myNumberOfServiceQueues;
	private ServiceQueue[] myServiceQueues;
	private int myTotalWaitTime;
	private int myTotalServiceTime;
	private int myTotalIdleTime;
	private float myAverageWaitTime;
	private float myAverageServiceTime;
	private int myAverageIdleTime;
	private int myPresentTime;
	private int myStartTime;

	public ServiceQueueManager()
	{
		for (int i = 0; i < MAX_NUMBER_OF_QUEUES; i++)
		{
			System.out.println(i);
			myServiceQueues = new ServiceQueue[i];
		}
		myTotalWaitTime = 0;
		myAverageIdleTime = 0;
		myAverageServiceTime = 0;
		myAverageWaitTime = 0;
		myNumberOfServiceQueues = 0;
		myPresentTime = 0;
		myStartTime = 0;
		myTotalServiceTime = 0;
		myTotalIdleTime = 0;
	}

	public int totalServedSoFar()
	{
		return 0;
	}

	public int getMyTotalWaitTime()
	{
		return 0;
	}

	public int getMyTotalServiceTime()
	{
		return 0;
	}

	public int getMyTotalIdleTime()
	{
		return 0;
	}

	public ServiceQueue determineShortestQueue()
	{
		return null;
	}

	public float getMyAverageWaitTime()
	{
		return myAverageWaitTime;
	}

	public float getMyAverageServiceTime()
	{
		return myAverageServiceTime;
	}

	public int getMyAverageIdleTime()
	{
		return myAverageIdleTime;
	}

}
