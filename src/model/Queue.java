package model;

/**
 * Created by chadbaily on 4/12/16.
 */

import java.util.LinkedList;

public class Queue<T>
{
	private LinkedList<T> myData;

	public Queue()
	{
		myData = new LinkedList<T>();
	}

	public boolean empty()
	{
		return myData.isEmpty();
	}

	public void enqueue(T o)
	{
		myData.addLast(o);
	}

	public T peek()
	{
		return myData.peekFirst();
	}

	public T dequeue()
	{
		if (myData.isEmpty())
		{
			return null;
		}
		return myData.removeFirst();
	}

	public int size()
	{
		return myData.size();
	}

}