package model;

/**
 * Created by chadbaily on 4/12/16.
 */
public class Customer
{
	private long myServiceTime;
	private long myEntryTime;
	private long myWaitTime;
	private long myStart;

	/**
	 * Constructor that creates a customer and sets appropriate times
	 */
	public Customer()
	{
		myServiceTime = 0;
		myEntryTime = 0;
		myWaitTime = 0;
		System.gc();
		myStart = System.currentTimeMillis();
	}

	/*
	 * Getters and setters
	 */

	public long getWaitTime()
	{
		return myWaitTime;
	}

	public long getEntryTime()
	{
		return myEntryTime;
	}

	public long getServiceTime()
	{

		return myServiceTime;
	}

	public void setServiceTime(long serviceTime)
	{
		myServiceTime = serviceTime;
	}

	public void setEntryTime(long entryTime)
	{
		myEntryTime = entryTime;
	}

	public void setWaitTime(long waitTime)
	{
		myWaitTime = waitTime;
	}

	public void setStart(long start)
	{
		myStart = start;
	}
}
