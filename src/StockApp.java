import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

// the Client
public class StockApp extends Application{

    GenericGrabber stockGrabberAAPL;
    GenericGrabber stockGrabberGOOG;
    GenericGrabber stockGrabberIBM;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        // create concrete subject
        this.stockGrabberAAPL = new GenericGrabber("AAPL");
        this.stockGrabberGOOG = new GenericGrabber("GOOG");
        this.stockGrabberIBM = new GenericGrabber("IBM");
        (new Simulator(stockGrabberAAPL, stockGrabberGOOG, stockGrabberIBM)).start();

        ArrayList<Subject> observerArray1 = new ArrayList<Subject>();
        observerArray1.add(stockGrabberAAPL);
        observerArray1.add(stockGrabberGOOG);

        ArrayList<Subject> observerArray2 = new ArrayList<Subject>();
        observerArray2.add(stockGrabberAAPL);
        observerArray2.add(stockGrabberGOOG);
        observerArray2.add(stockGrabberIBM);

        new ObserverView(observerArray1);
        new ObserverView(observerArray2);

    }
}

