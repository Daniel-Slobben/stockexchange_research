import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphView extends VBox {

    private LineChart<Number,Number> lineChart;
    private ArrayList<XYChart.Series> series;
    private ArrayList<String> stockNames;

    public GraphView(String[] stockNames) {

        this.stockNames = new ArrayList<>(Arrays.asList(stockNames) );
        series = new ArrayList<>();

        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("seconds");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Price per stock in euros");

        //creating the chart
        LineChart<Number,Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Stock exchange");

        for (String stockName: stockNames) {

            //defining a series
            XYChart.Series series = new XYChart.Series();
            series.setName(stockName);

            lineChart.getData().add(series);

            this.series.add(series);
        }
        this.getChildren().addAll(lineChart);
    }

    public void update(double stockPrice, String stockName, int amountOfUpdates) {

        series.get(stockNames.indexOf(stockName)).getData().add(new XYChart.Data(amountOfUpdates, stockPrice));

    }
}