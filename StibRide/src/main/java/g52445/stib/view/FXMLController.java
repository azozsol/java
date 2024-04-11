package g52445.stib.view;


import g52445.stib.handler.ButtonHandler;
import g52445.stib.model.StationData;
import g52445.stib.presenter.Presenter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.SearchableComboBox;

import java.util.*;

public class FXMLController {

    @FXML
    private SearchableComboBox<String> destination;

    @FXML
    private SearchableComboBox<String> original;

    @FXML
    private Button search;

    @FXML
    private TableView<StationData> tableView;

    @FXML
    private TableColumn<StationData, String> tableViewLine;

    @FXML
    private TableColumn<StationData, String> tableViewStations;

    public void initialize(List<String> stations) {
        ObservableList<String> stationsNa = FXCollections.observableArrayList();
        stationsNa.addAll(stations);
//        stations.forEach((s) -> {
//            stationsNa.add(s);
//        });
        this.original.setItems(stationsNa);
        //this.original.getItems().setAll(stationsNa);
        this.original.getSelectionModel().select(0);

        this.destination.setItems(stationsNa);
        //this.destination.getItems().setAll(stationsNa);
        this.destination.getSelectionModel().select(0); // it is better to select (stationsNumbers - 1)

        this.tableViewStations.setCellValueFactory(new PropertyValueFactory<>("stationName"));
        this.tableViewLine.setCellValueFactory(new PropertyValueFactory<>("lines"));

    }

    public void addHandlerButton(Presenter presenter) {
        ButtonHandler handler = new ButtonHandler(presenter);
        this.search.setOnAction(handler);
    }

    public String getOriginal() {
        return this.original.getSelectionModel().getSelectedItem();
    }

    public String getDestiniation() {
        return this.destination.getSelectionModel().getSelectedItem();
    }

    public void updateTable(List<String> stations, List<String> lines) {
        this.tableView.getItems().clear();
        for (int index = 0; index < stations.size(); index++) {
            this.tableView.getItems().add(new StationData(stations.get(index), lines.get(index)));
        }
    }
}




