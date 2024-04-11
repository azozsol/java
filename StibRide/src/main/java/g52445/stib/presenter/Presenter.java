package g52445.stib.presenter;

import java.util.ArrayList;
import java.util.List;

import g52445.stib.model.Facade;
import g52445.stib.view.View;

public class Presenter implements Observer {

    private View view;
    private Facade model;

    public Presenter(View view, Facade model) {
        this.view = view;
        this.model = model;
    }

    public void initialize() {
        List<String> stationNames = new ArrayList<>();
        this.model.getStations().forEach((st) -> { // Preventing the view to get access to Model.
            stationNames.add(st.getName());
        });
        this.view.initialize(stationNames);
        // this.model.initGraph();
    }

    public void doSearch() {
        this.model.initGraph();
        this.model.searchPath(view.getSource(), view.getDestiniation());
    }

    @Override
    public void update() {
        List<String> stations = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        this.model.getResult().forEach(res -> {
            stations.add(res.getStationName());
            lines.add(res.getLines().toString());
        });
        this.view.fillTable(stations, lines);
    }
}
