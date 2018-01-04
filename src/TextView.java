import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Arrays;

public class TextView extends VBox {
    private ArrayList<Label> labels;
    private ArrayList<String> stockNames;
    
    public TextView(String[] stockNames) {

        this.stockNames = new ArrayList<>(Arrays.asList(stockNames) );
        labels = new ArrayList<>();

        for (String stockName: stockNames) {
            labels.add(new Label(stockName + ": Not available"));
        }
        this.getChildren().addAll(labels);
    }

    public void update(double stockPrice, String stockName) {
        labels.get(stockNames.indexOf(stockName)).setText(stockName + ": " + stockPrice);
    }
}
