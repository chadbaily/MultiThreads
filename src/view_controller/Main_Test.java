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

		myServiceQueueManager = new ServiceQueueManager();
		myCustomerGenerator = new UniformCustomerGenerator(500, myServiceQueueManager, 500);

		myCustomerGenerator.run();


	}
}