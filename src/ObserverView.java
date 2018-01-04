import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ObserverView {

    private TextView textView;
    private GraphView graphView;
    private String[] stockNames;

    public ObserverView(ArrayList<Subject> subjects) {

        stockNames = new String[subjects.size()];
        int counter = 0;

        for(Subject subject: subjects) {
            new GenericObserver(subject, this);
            stockNames[counter] = subject.getStockName();
            counter++;
        }

        newWindow();
    }

    public void newWindow() {
        Stage stage = new Stage();
        stage.setTitle("Stock exchange");

        textView = new TextView(this.stockNames);
        graphView = new GraphView(this.stockNames);


        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        Tab textViewTab = new Tab("Current stocks in text");
        Tab graphViewTab = new Tab("Linechart");
        textViewTab.setContent(textView);
        graphViewTab.setContent(graphView);

        tabPane.getTabs().addAll(textViewTab, graphViewTab);

        Scene scene = new Scene(tabPane, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void update(double stockPrice, String stockName, int amountOfUpdates) {
        Platform.runLater( new Runnable() {
            @Override
            public void run() {
                textView.update(stockPrice, stockName);
                graphView.update(stockPrice, stockName, amountOfUpdates);
            }
        });


    }
}
