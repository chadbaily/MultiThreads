package view_controller;

import model.Cashier;

/**
 * Created by Chad Baily on 4/14/2016.
 */
public class Main_Test
{
	public static void main(String[] args)
	{
		Cashier myCashier = new Cashier(5, null);
		myCashier.run();
		myCashier.suspend();


	}
}