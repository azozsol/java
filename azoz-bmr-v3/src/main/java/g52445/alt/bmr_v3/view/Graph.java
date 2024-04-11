package g52445.alt.bmr_v3.view;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.chart.XYChart;

/**
 * Represent the graphe of the BMR.
 *
 * @author soliman
 */
public class Graph extends TabPane {

    private final LineChart<Number, Number> lineChartBmrVsWeigth;
    private final NumberAxis xBmrVsWeigth;
    private final NumberAxis yBmrVsWeigth;

    private final LineChart<Number, Number> lineChartCalorieVsWeigth;
    private final NumberAxis xCalorieVsWeigth;
    private final NumberAxis yCalorieVsWeigth;

    private final LineChart<Number, Number> lineChartBmrVsHeigth;
    private final NumberAxis xBmrVsHeigth;
    private final NumberAxis yBmrVsHeigth;

    public Graph() {
        // BMR Vs. Weigth
        this.xBmrVsWeigth = new NumberAxis();
        this.xBmrVsWeigth.setLabel("Wigth(Kg)");
        this.yBmrVsWeigth = new NumberAxis();
        this.yBmrVsWeigth.setLabel("BMR");
        this.lineChartBmrVsWeigth = new LineChart<>(yBmrVsWeigth, xBmrVsWeigth);
        this.lineChartBmrVsWeigth.setTitle("Weigth(kg) Vs. BMR");
        XYChart.Series sMenBmrVsWeigth = new XYChart.Series<>();
        XYChart.Series sWomenBmrVsWeigth = new XYChart.Series<>();
        sMenBmrVsWeigth.setName("Men");
        sWomenBmrVsWeigth.setName("Women");
        this.lineChartBmrVsWeigth.getData().add(sMenBmrVsWeigth);
        this.lineChartBmrVsWeigth.getData().add(sWomenBmrVsWeigth);

        //Calorie Vs. Weigth
        this.xCalorieVsWeigth = new NumberAxis();
        this.xCalorieVsWeigth.setLabel("Weigth(kg)");
        this.yCalorieVsWeigth = new NumberAxis();
        this.yCalorieVsWeigth.setLabel("Calorie");
        this.lineChartCalorieVsWeigth = new LineChart<>(yCalorieVsWeigth, xCalorieVsWeigth);
        this.lineChartCalorieVsWeigth.setTitle("Weigth Vs. Calorie");
        XYChart.Series sMenCalorieVsWeigth = new XYChart.Series<>();
        XYChart.Series sWomenCalorieVsWeigth = new XYChart.Series<>();
        sMenCalorieVsWeigth.setName("Men");
        sWomenCalorieVsWeigth.setName("Women");
        this.lineChartCalorieVsWeigth.getData().add(sMenCalorieVsWeigth);
        this.lineChartCalorieVsWeigth.getData().add(sWomenCalorieVsWeigth);

        //BMR Vs. Heigth
        this.xBmrVsHeigth = new NumberAxis();
        this.xBmrVsHeigth.setLabel("Heigth(cm)");
        this.yBmrVsHeigth = new NumberAxis();
        this.yBmrVsHeigth.setLabel("BMR");
        this.lineChartBmrVsHeigth = new LineChart<>(yBmrVsHeigth, xBmrVsHeigth);
        this.lineChartBmrVsHeigth.setTitle("Heigth(cm) Vs. BMR");
        XYChart.Series sMenBmrVsHeigth = new XYChart.Series<>();
        XYChart.Series sWomenBmrVsHeigth = new XYChart.Series<>();
        sMenBmrVsHeigth.setName("Men");
        sWomenBmrVsHeigth.setName("Women");
        this.lineChartBmrVsHeigth.getData().add(sMenBmrVsHeigth);
        this.lineChartBmrVsHeigth.getData().add(sWomenBmrVsHeigth);

        Tab tabBmrVsWeigth = new Tab();
        tabBmrVsWeigth.setText("Weigth(kg) Vs. BMR");
        tabBmrVsWeigth.setContent(lineChartBmrVsWeigth);

        Tab tabCalorieVsWeigth = new Tab();
        tabCalorieVsWeigth.setText("Weigth Vs. Calorie");
        tabCalorieVsWeigth.setContent(lineChartCalorieVsWeigth);

        Tab tabBmrVsHeigth = new Tab();
        tabBmrVsHeigth.setText("Heigth(cm) Vs. BMR");
        tabBmrVsHeigth.setContent(lineChartBmrVsHeigth);

        tabBmrVsWeigth.setClosable(false);
        tabCalorieVsWeigth.setClosable(false);
        tabBmrVsHeigth.setClosable(false);

        this.getTabs().addAll(tabBmrVsWeigth, tabCalorieVsWeigth, tabBmrVsHeigth);

    }

    /**
     * Gettre for lineChartBmrVsWeigth.
     *
     * @return lineChartBmrVsWeigth.
     */
    public LineChart<Number, Number> getLineChartBmrVsWeigth() {
        return lineChartBmrVsWeigth;
    }

    /**
     * Getter for lineChartCalorieVsWeigth.
     *
     * @return ineChartCalorieVsWeigth.
     */
    public LineChart<Number, Number> getLineChartCalorieVsWeigth() {
        return lineChartCalorieVsWeigth;
    }

    /**
     * Getter for lineChartBmrVsHeigth.
     *
     * @return lineChartBmrVsHeigth.
     */
    public LineChart<Number, Number> getLineChartBmrVsHeigth() {
        return lineChartBmrVsHeigth;
    }

    /**
     * Allow to reset the graphes.
     */
    public void reset() {
        lineChartBmrVsWeigth.getData().get(0).getData().clear();
        lineChartCalorieVsWeigth.getData().get(0).getData().clear();
        lineChartBmrVsHeigth.getData().get(0).getData().clear();
        lineChartBmrVsWeigth.getData().get(1).getData().clear();
        lineChartCalorieVsWeigth.getData().get(1).getData().clear();
        lineChartBmrVsHeigth.getData().get(1).getData().clear();
    }

}
