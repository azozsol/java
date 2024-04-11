package g52445.atl.project2048.view;

import java.time.LocalDateTime;
import javafx.scene.control.ListView;

/**
 * Class ListNotification represent the List of notification
 *
 * @author soliman
 */
public class ListNotification extends ListView {

    /**
     * Attribute of the class.
     */
    private final LocalDateTime time;

    /**
     *The constructor
     */
    public ListNotification() {
        this.time = LocalDateTime.now();
    }

    /**
     * For adding text inside the list, preceded by the time.
     * @param message the text.
     */
    public void addToList(String message) {
        getItems().add(this.time.getHour() + ":" + this.time.getMinute() + " - " + message);
    }
}
