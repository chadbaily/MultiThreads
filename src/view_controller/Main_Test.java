package view_controller;

import model.*;

import java.util.Scanner;
import java.util.Vector;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * Created by Chad Baily on 4/14/2016.
 */
public class Main_Test
{
	public static void main(String[] args)
	{
		ServiceQueueManager myServiceQueueManager;
		UniformCustomerGenerator myCustomerGenerator;
		UniformCashier[] myUniformCashiers;

		myServiceQueueManager = new ServiceQueueManager();
		myCustomerGenerator = new UniformCustomerGenerator(500, myServiceQueueManager, 500);
		myCustomerGenerator.run();
		myUniformCashiers = new UniformCashier[3];

		for(int i =0; i < myServiceQueueManager.getNumberOfServiceQueues(); i++)
		{
			ServiceQueue temp = myServiceQueueManager.getServiceQueues()[i];
			myUniformCashiers[i] = new UniformCashier(500, temp);
			myUniformCashiers[i].start();

		}






	}
}