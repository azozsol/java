package g52445.alt.bmr_v3.view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * The Menu Bar represnts the menu in the APP.
 *
 * @author soliman
 */
public class MyMenu extends MenuBar {

    /**
     * Constructor for MyMenu for inistialize the menu(s).
     */
    public MyMenu() {
        Menu myMenu = new Menu("File");
        MenuItem exit = new MenuItem("Exit");
        myMenu.getItems().add(exit);
        getMenus().add(myMenu);
    }

}
