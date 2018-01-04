import java.util.ArrayList;

public class GenericGrabber implements Subject {
    private ArrayList<Observer> observers;
    private double stockPrice;
    private String stockName;


    public GenericGrabber(String stockName){
        // a list to hold all observers
        observers = new ArrayList<Observer>();
        this.stockName = stockName;
    }

    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    public void unregister(Observer observerToRemove) {
        observers.remove(observerToRemove);
    }

    public void notifyObserver() {

        for(Observer observer : observers){
            observer.update(stockPrice, stockName);
        }
    }

    public void setStockPrice(double newStockPrice) {
        stockPrice = newStockPrice;
        notifyObserver();

    }

    public double getStockPrice() {
        return stockPrice;
    }

    public String getStockName() {
        return stockName;
    }
}
