package g52445.stib.view;

import g52445.stib.model.Facade;
import g52445.stib.model.StibRide;
import g52445.stib.presenter.Presenter;
import javafx.application.Application;

import javafx.stage.Stage;
/**
 *
 * @author soliman
 */
public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        View view = new View(stage);
        Facade model = new StibRide();
        Presenter presenter = new Presenter(view,model);
        model.registerObserver(presenter);
        presenter.initialize();
        view.addHandleButton(presenter);
    }
}
