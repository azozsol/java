package g52445.stib.view;

import g52445.stib.dto.StationDto;
import g52445.stib.presenter.Presenter;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.*;
import java.io.IOException;

public class View {

    private FXMLController mainPane;

    public View(Stage stage) throws IOException {
        stage.setTitle("StibRide");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/stibmetro.fxml"));
        Parent root = loader.load();
        mainPane = loader.getController();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(List<String> stations) {
        this.mainPane.initialize(stations);
    }

    public void addHandleButton(Presenter presenter){
        this.mainPane.addHandlerButton(presenter);
    }

    public String getSource(){
        return this.mainPane.getOriginal();
    }

    public String getDestiniation(){
        return this.mainPane.getDestiniation();
    }

    public void fillTable(List<String> stations, List<String> lines){
        this.mainPane.updateTable(stations, lines);
    }
}
