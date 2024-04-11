package g52445.atl.project2048.handler;

import g52445.atl.project2048.controller.ControllerFX;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
/**
 *
 * @author soliman
 */
public class ButtonHandler implements EventHandler<ActionEvent>{
    
    private ControllerFX controller;

    public ButtonHandler(ControllerFX controller) {
        this.controller = controller;
    }
    
    @Override
    public void handle(ActionEvent t) {
        controller.ResetButton();
    }
    
}
