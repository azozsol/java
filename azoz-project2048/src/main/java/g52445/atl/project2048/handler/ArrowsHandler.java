package g52445.atl.project2048.handler;

import g52445.atl.project2048.controller.ControllerFX;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author soliman
 */
public class ArrowsHandler implements EventHandler<KeyEvent> {

    private ControllerFX controller;

    public ArrowsHandler(ControllerFX controller) {
        this.controller = controller;
    }

    @Override
    public void handle(KeyEvent t) {
        this.controller.start(t);
    }

}
