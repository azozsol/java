package g52445.stib.handler;

import g52445.stib.presenter.Presenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonHandler implements EventHandler<ActionEvent> {

    private Presenter presenter;

    public ButtonHandler(Presenter presenter) {
        this.presenter  = presenter;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        presenter.doSearch();
    }
}
