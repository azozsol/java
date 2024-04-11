package g52445.atl.project2048.main;

import g52445.atl.project2048.controller.ControllerFX;
import g52445.atl.project2048.model.FacadeModel;
import g52445.atl.project2048.model.Game;
import g52445.atl.project2048.view.ViewFX;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author soliman
 */
public class MainFX extends Application {

    /**
     * the main method of the application.
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
    public MainFX(){
        
    }

    /**
     * the start method of the application.
     *
     * @param primaryStage sets the primary stage.
     * @throws java.lang.Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("HE2B ESI - 2048");
        FacadeModel model = new Game();
        ViewFX view = new ViewFX(primaryStage);
        ControllerFX controllerFX = new ControllerFX(model, view);
        controllerFX.initialize();
        controllerFX.addObserver();
        view.initializeButtonRest(controllerFX);
        view.initMovement(controllerFX);
    }

}
