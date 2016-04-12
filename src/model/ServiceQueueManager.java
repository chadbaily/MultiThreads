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
		return 0;
	}

	public float getMyAverageServiceTime()
	{
		return 0;
	}

	public int getMyAverageIdleTime()
	{
		return 0;
	}

}
