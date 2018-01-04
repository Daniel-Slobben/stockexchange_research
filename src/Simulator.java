import javafx.application.Application;

import java.util.Random;

public class Simulator extends Thread {

    private GenericGrabber stockGrabberAAPL;
    private GenericGrabber stockGrabberGOOG;
    private GenericGrabber stockGrabberIBM;

    private boolean isLock = true;
    private Random r;

    public Simulator(GenericGrabber stockGrabberAAPL, GenericGrabber stockGrabberGOOG, GenericGrabber stockGrabberIBM) {
        this.stockGrabberAAPL = stockGrabberAAPL;
        this.stockGrabberGOOG = stockGrabberGOOG;
        this.stockGrabberIBM = stockGrabberIBM;

        this.stockGrabberAAPL.setStockPrice(677.60);
        this.stockGrabberGOOG.setStockPrice(677.40);
        this.stockGrabberIBM.setStockPrice(197.00);

        r = new Random();

    }

    public void run() {
        simulateStocks();
    }

    public void simulateStocks() {
        while (isLock) {
            simulateAAPL();
            simulateGOOG();
            simulateIBM();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (Thread.currentThread().isInterrupted()) {
                isLock = false;
            }
        }
    }

    private void simulateAAPL() {
        double randomValue = -10.00 + (10.00 - -10.00) * r.nextDouble();
        this.stockGrabberAAPL.setStockPrice(this.stockGrabberAAPL.getStockPrice()+randomValue);
    }
    private void simulateIBM() {
        double randomValue = -10.00 + (10.00 - -10.00) * r.nextDouble();
        this.stockGrabberIBM.setStockPrice(this.stockGrabberIBM.getStockPrice()+randomValue);
}
    private void simulateGOOG() {
        double randomValue = -10.00 + (10.00 - -10.00) * r.nextDouble();
        this.stockGrabberGOOG.setStockPrice(this.stockGrabberGOOG.getStockPrice()+randomValue);
    }
}
