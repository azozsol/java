package g52445.alt.bmr_v3.view;

import g52445.alt.bmr_v3.model.LifeStyle;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * Represent the the data of the person
 *
 * @author soliman
 */
public class Data extends GridPane {

    /**
     * The attributes of the class.
     */
    private final TextField heigthText;
    private final TextField weigthText;
    private final TextField ageText;
    private final ToggleGroup genderRadio;
    private final ChoiceBox<LifeStyle> lifeStyleChoice;

    /**
     * The constructor for initialise all the nodes.
     */
    public Data() {

        setHgap(10);
        setVgap(10);
        Text dataBMR = new Text("Données");
        dataBMR.setUnderline(true);
        add(dataBMR, 0, 0);
        //The heigth
        Label heigthLab = new Label("Taille(cm)");
        add(heigthLab, 0, 1);
        heigthText = new TextField();
        heigthText.setPromptText("Taille en cm");
        add(heigthText, 1, 1);
        //The weigth
        Label weigthLab = new Label("Poids(kg)");
        add(weigthLab, 0, 2);
        weigthText = new TextField();
        weigthText.setPromptText("Poids en kg");
        add(weigthText, 1, 2);
        //The age
        Label ageLab = new Label("Age (années)");
        add(ageLab, 0, 3);
        ageText = new TextField();
        ageText.setPromptText("Age en années");
        add(ageText, 1, 3);
        //The gender
        Label genderLab = new Label("Sexe");
        add(genderLab, 0, 4);
        genderRadio = new ToggleGroup();
        RadioButton sexeRadioF = new RadioButton("Femme");
        sexeRadioF.setToggleGroup(genderRadio);
        sexeRadioF.setSelected(true);

        RadioButton sexeRadioH = new RadioButton("Homme");
        sexeRadioH.setToggleGroup(genderRadio);

        add(new HBox(5, sexeRadioF, sexeRadioH), 1, 4);
        //The lifeStyle
        Label lifeStyleLab = new Label("Style de vie");
        add(lifeStyleLab, 0, 5);
        lifeStyleChoice = new ChoiceBox();
        lifeStyleChoice.getItems().setAll(LifeStyle.values());
        lifeStyleChoice.setValue(LifeStyle.SEDENTARY);
        add(lifeStyleChoice, 1, 5);

    }

    /**
     * The getter for heigth.
     *
     * @return the heigth in type double.
     */
    public double getHeigthText() {
        return Double.parseDouble(heigthText.getText());
    }

    /**
     * The getter for weigth.
     *
     * @return the wiegth in type double.
     */
    public double getWeigthText() {
        return Double.parseDouble(weigthText.getText());
    }

    /**
     * The getter for age.
     *
     * @return the age in type integer.
     */
    public int getAgeText() {
        return Integer.parseInt(ageText.getText());
    }

    /**
     * The getter for genderRadio.
     *
     * @return the genderRadio.
     */
    public ToggleGroup getGenderRadio() {
        return genderRadio;
    }

    /**
     * The getter for lifeStyleChoice.
     *
     * @return the lifeStyleChoice.
     */
    public LifeStyle getLifeStyleChoice() {
        return lifeStyleChoice.getValue();
    }

    /**
     * Allow us to reset the person's data.
     */
    public void restData() {
        heigthText.clear();
        weigthText.clear();
        ageText.clear();
        genderRadio.getToggles().get(0).setSelected(true);
        lifeStyleChoice.setValue(LifeStyle.SEDENTARY);
    }

    /**
     * Allow us to check if any of person's data are zero.
     *
     * @return true if thtere is zero , otherwise fales.
     */
    public boolean isZero() {
        return getHeigthText() <= 0
                || getWeigthText() <= 0
                || getAgeText() <= 0;
    }

}
