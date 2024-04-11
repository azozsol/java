package g52445.alt.bmr_v3.model;

import g52445.atl.bmr_v3.util.Subject;
import javafx.scene.control.ToggleGroup;

/**
 * Represent the facade for model.
 *
 * @author soliman
 */
public class Facade extends Subject {

    Person person;

    /**
     * Simpel constructor for facade.
     */
    public Facade() {
        this.person = new Person();
    }

    /**
     * Allow us to initialize the data of person.
     *
     * @param age the age of person.
     * @param heigth the heigth of person.
     * @param weigth the weigth of person.
     * @param lifeStyle the life style of person.
     * @param gender the gender of person.
     */
    public void updateData(int age, double heigth, double weigth,
            LifeStyle lifeStyle, ToggleGroup gender) {
        this.person.setAge(age);
        this.person.setHeigth(heigth);
        this.person.setWeigth(weigth);
        this.person.setLifeStyle(lifeStyle);
        this.person.setGender(gender);
        notifyObserver();
    }

    /**
     * To have the result BMR for the two genders.
     *
     * @return the result of BMR
     */
    public double getBMR() {
        if (person.getGender().getToggles().get(0).isSelected()) {
            return 13.7 * person.getWeigth() + 5 * person.getHeigth() - 6.8 * person.getAge() + 66;
        } else {
            return 9.6 * person.getWeigth() + 1.8 * person.getHeigth() - 4.7 * person.getAge() + 655;
        }
    }

    /**
     * Simple getter for the colorie.
     *
     * @return the colorie.
     */
    public double getCalorie() {
        return getBMR() * person.getLifeStyle().getLevel();
    }
}
