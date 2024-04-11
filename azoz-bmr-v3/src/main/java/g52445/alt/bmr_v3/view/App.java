package g52445.alt.bmr_v3.view;

import g52445.alt.bmr_v3.model.Facade;
import g52445.alt.bmr_v3.model.LifeStyle;
import g52445.atl.bmr_v3.util.Observer;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*        
 * The main of the application
 *
 * @author soliman
 */
public class App extends Application implements Observer {

    /**
     * The two essential attributes
     */
    private Results results;
    private Facade facade;
    private Data data;
    private Graph bmrGraph;

    /**
     * The main method.
     *
     * @param args the arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The start method
     *
     * @param primaryStage represent the stage (The windows) of the application.
     * @throws Exception NumberFormatException if the input are not numbers.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Calcul du BMR");

        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        // The menu
        MyMenu menuBar = new MyMenu();

        HBox container = new HBox(15);

        container.setAlignment(Pos.CENTER);

        data = new Data();
        results = new Results();
        facade = new Facade();
        bmrGraph = new Graph();

        //L'encodage de chiffres
        data.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent t) {
                if (!t.getCharacter().matches("[0-9]|[.]")) {
                    t.consume();
                }
            }
        });

        //button calculate 
        Button calculBut = new Button("Calcul du BMR");
        calculBut.setPrefWidth(600);
        calculBut.setOnAction(t -> {
            computeValues();
        });
        //button clear
        Button clearBut = new Button("Clear");
        clearBut.setPrefWidth(600);
        clearBut.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                data.restData();
                results.restResult();
                bmrGraph.reset();
            }
        });
        // gridPane for data    
        GridPane gridData = new GridPane();
        gridData.setPadding(new Insets(10));
        gridData.add(data, 0, 0);
        //gridPane for Results
        GridPane gridResutls = new GridPane();
        gridResutls.setPadding(new Insets(10));
        gridResutls.add(results, 1, 0);
        //gridPane for graph
        GridPane dataGraph = new GridPane();
        dataGraph.getChildren().addAll(bmrGraph);
        //the container include on the left (data) and on the rigth (results)    
        container.getChildren().addAll(gridData, gridResutls, dataGraph);
        root.getChildren().addAll(menuBar, container, calculBut, clearBut);
        Scene scene = new Scene(root, 1200, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        facade.register(this);

    }

    /**
     * Allow us to set the values and update for model facade.
     */
    public void computeValues() {
        results.def();
        try {
            double heigth = data.getHeigthText();
            double weigth = data.getWeigthText();
            int age = data.getAgeText();
            ToggleGroup gender = data.getGenderRadio();
            LifeStyle lifeStyle = data.getLifeStyleChoice();
            facade.updateData(age, heigth, weigth,
                    lifeStyle, gender);
            update();
            if (data.isZero()) {
                displayAlert();
                results.faild();
            }
        } catch (NumberFormatException e) {
            results.faild();
        }
    }

    /**
     * Allow us to update the bmr result and showing the graph
     */
    @Override
    public void update() {
        results.setBmr(facade.getBMR());
        results.setCalories(facade.getCalorie());
        if (data.getGenderRadio().getToggles().get(1).isSelected()) {
            bmrGraph.getLineChartBmrVsWeigth().getData().get(0).getData().
                    add(new XYChart.Data<>(data.getWeigthText(), facade.getBMR()));
            bmrGraph.getLineChartCalorieVsWeigth().getData().get(0).getData().
                    add(new XYChart.Data<>(data.getWeigthText(), facade.getCalorie()));
            bmrGraph.getLineChartBmrVsHeigth().getData().get(0).getData().
                    add(new XYChart.Data<>(data.getHeigthText(), facade.getBMR()));
        } else {
            bmrGraph.getLineChartBmrVsWeigth().getData().get(1).getData().
                    add(new XYChart.Data<>(data.getWeigthText(), facade.getBMR()));
            bmrGraph.getLineChartCalorieVsWeigth().getData().get(1).getData().
                    add(new XYChart.Data<>(data.getWeigthText(), facade.getCalorie()));
            bmrGraph.getLineChartBmrVsHeigth().getData().get(1).getData().
                    add(new XYChart.Data<>(data.getHeigthText(), facade.getBMR()));
        }
    }

    /**
     *Allow us to show an alert window in case if one data is zero.
     */
    private void displayAlert() {
        Alert dataInvalid = new Alert(Alert.AlertType.ERROR);
        dataInvalid.setTitle("Alert!");
        dataInvalid.setHeaderText("Something went worng!, Your data include a zero or less");
        dataInvalid.showAndWait();
    }
}
