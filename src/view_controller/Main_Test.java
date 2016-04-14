package view_controller;

import model.ServiceQueueManager;

import java.util.Random;

/**
 * Created by Chad Baily on 4/14/2016.
 */
public class Main_Test
{
	public static void main(String[] args)
	{
		ServiceQueueManager test = new ServiceQueueManager();
		Random myRandom = new Random();
		System.out.println(myRandom.nextInt(1000 - 1 + 1) + 1);
	}
}
