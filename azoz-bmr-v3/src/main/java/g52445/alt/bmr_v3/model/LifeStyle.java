package g52445.alt.bmr_v3.model;

import java.util.logging.Logger;

/**
 * Reprsent the life style of person
 *
 * @author soliman
 */
public enum LifeStyle {
    SEDENTARY("Sédentaire", 1.2),
    INACTIVE("Peu actif", 1.375),
    ACTIVE("Actif", 1.55),
    VERYACTIVE("Fort Actif", 1.725),
    EXTREMACTIVE("Extremement Actif", 1.9);

    private final String label;
    private final double level;

    /**
     * Simple constructor
     *
     * @param label the label
     * @param level the level of activity
     */
    private LifeStyle(String label, double level) {
        this.label = label;
        this.level = level;
    }

    /**
     * To display the label
     *
     * @return the label
     */
    @Override
    public String toString() {
        return label;
    }

    /**
     * Simple getter for the level
     *
     * @return the level
     */
    public double getLevel() {
        return level;
    }

}
