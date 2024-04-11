package g52445.alt.bmr_v3.model;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * Represnt the object person.
 *
 * @author soliman
 */
public class Person {

    /**
     * Attributes of the class.
     */
    private int age;
    private double heigth;
    private double weigth;
    private LifeStyle lifeStyle;
    private ToggleGroup gender;

    /**
     * Constructor for the class.
     */
    public Person() {
        this.age = 0;
        this.heigth = 0;
        this.weigth = 0;
        this.lifeStyle = LifeStyle.ACTIVE;

        gender = new ToggleGroup();
        RadioButton radioHomme = new RadioButton("Homme");
        radioHomme.setToggleGroup(gender);
        radioHomme.setSelected(true);

        RadioButton radioFemme = new RadioButton("Femme");
        radioFemme.setToggleGroup(gender);

    }

    /**
     * simple setter for age.
     *
     * @param age the age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Simple setter for the heigth.
     *
     * @param heigth the heigth.
     */
    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    /**
     * Simple setter for the weigth.
     *
     * @param weigth the weigth.
     */
    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

    /**
     * Simple setter for the lifeStyle.
     *
     * @param lifeStyle the lifeStyle.
     */
    public void setLifeStyle(LifeStyle lifeStyle) {
        this.lifeStyle = lifeStyle;
    }

    /**
     * Simple setter for the gender.
     *
     * @param gender the gender.
     */
    public void setGender(ToggleGroup gender) {
        this.gender = gender;
    }

    /**
     * Simple getter for the age.
     *
     * @return the age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Simple getter for the heigth.
     *
     * @return the heigth.
     */
    public double getHeigth() {
        return heigth;
    }

    /**
     * Simple getter for the weigth.
     *
     * @return the weight.
     */
    public double getWeigth() {
        return weigth;
    }

    /**
     * Simple getter for lifeStye.
     *
     * @return the lifeStyle.
     */
    public LifeStyle getLifeStyle() {
        return lifeStyle;
    }

    /**
     * Simple getter for the gender.
     *
     * @return the gender.
     */
    public ToggleGroup getGender() {
        return gender;
    }
}
