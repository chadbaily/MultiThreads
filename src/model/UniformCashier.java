package model;

import java.util.Random;

/**
 * Created by chadbaily on 4/12/16.
 */
public class UniformCashier extends Cashier {
    private Random myRandom;

    public UniformCashier(int maxTimeService, ServiceQueue serviceQueue) {
        super(maxTimeService, serviceQueue);
    }

    public int generateServiceTime() {
        myRandom = new Random();

        return myRandom.nextInt(1000 - 1 + 1) + 1;
    }
}
