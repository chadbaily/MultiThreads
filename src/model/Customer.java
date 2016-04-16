package model;

/**
 * Created by chadbaily on 4/12/16.
 */
public class Customer
{
	private int myServiceTime;
	private int myEntryTime;
	private int myWaitTime;
	private long myStart;

	public Customer()
	{
		myServiceTime = 0;
		myEntryTime = 0;
		myWaitTime = 0;
		myStart = System.currentTimeMillis();
	}

	public int getWaitTime()
	{
		return myWaitTime;
	}

	public int getEntryTime()
	{
		return myEntryTime;
	}

	public int getServiceTime()
	{

		return myServiceTime;
	}

	public void setServiceTime(int myServiceTime)
	{
		this.myServiceTime = myServiceTime;
	}

	public void setEntryTime(int myEntryTime)
	{
		this.myEntryTime = myEntryTime;
	}

	public void setWaitTime(int myWaitTime)
	{
		this.myWaitTime = myWaitTime;
	}

	public void setStart(long myStart)
	{
		this.myStart = myStart;
	}
}
