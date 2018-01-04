import java.util.ArrayList;

public class GenericObserver implements Observer {
    private double stockPrice;
    private String stockName;
    private ObserverView observerView;
    private int amountOfUpdates;

    // static used as a counter
    private static int observerIDTracker = 0;

    // to track the observers
    private int observerID;

    // a reference to concrete subject
    private Subject stockGrabber;

    public GenericObserver(Subject stockGrabber, ObserverView observerView){

        this.amountOfUpdates = 0;
        this.stockGrabber = stockGrabber;
        this.stockName = stockGrabber.getStockName();
        this.observerView = observerView;
        this.observerID = ++observerIDTracker;
        stockGrabber.register(this);

        System.out.println("New Observer " + this.observerID);
    }

    // update all observers
    public void update(double stockPrice, String stockName) {

        amountOfUpdates++;
        this.stockPrice = stockPrice;
        printThePrices();
        updateGUI();
    }

    private void updateGUI() {
        observerView.update(stockPrice, stockName, amountOfUpdates);
    }

    public void printThePrices(){

//        System.out.println(observerID + "\n"+stockName+": " + stockPrice + "\n");
    }
}
