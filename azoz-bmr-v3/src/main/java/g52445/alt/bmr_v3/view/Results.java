package g52445.alt.bmr_v3.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Represent the results
 *
 * @author soliman
 */
public class Results extends GridPane {

    /**
     * The attrbutes of the class.
     */
    private final TextField bmr;
    private final TextField calories;

    /**
     * The constructor for initialise all the nodes.
     */
    public Results() {
        setHgap(10);
        setVgap(10);

        Label resultes = new Label("resultes");
        resultes.setUnderline(true);
        add(resultes, 0, 0);
        // the BMR results
        Label bmrText = new Label("BMR");
        add(bmrText, 0, 1);
        bmr = new TextField();
        bmr.setPromptText("Résultats du BMR");
        bmr.setEditable(false);
        add(bmr, 1, 1);
        //The calories results    
        Label caloriesText = new Label("Calories");
        add(caloriesText, 0, 2);
        calories = new TextField();
        calories.setPromptText("Dépense en calories");
        calories.setEditable(false);
        add(calories, 1, 2);
    }

    /**
     * The setter for bmr.
     *
     * @param newBmr the new bmr.
     */
    public void setBmr(double newBmr) {
        this.bmr.setText(newBmr + "");
    }

    /**
     * The setter for calories.
     *
     * @param newCalories the new calories.
     */
    public void setCalories(double newCalories) {
        this.calories.setText(newCalories + "");
    }

    /**
     * To display faild in the bmr and calories field in case the data not complet.
     */
    public void faild() {
        bmr.setStyle("-fx-text-fill: red");
        bmr.setText("Faild");
        calories.setStyle("-fx-text-fill: red");
        calories.setText("Faild!");
    }

    /**
     *To display the results text in black.
     */
    public void def() {
        bmr.setStyle("-fx-text-fill: black");
        calories.setStyle("-fx-text-fill: black");
    }
    
    /**
     * Alow us to reset the bmr and calories results.
     */
    public void restResult(){
        bmr.clear();
        calories.clear();
    }
}
