package g52445.stib.model;

import g52445.stib.dto.StationDto;
import g52445.stib.presenter.Observer;

import java.util.List;

public interface Facade {

    List<StationDto> getStations();

    void searchPath(String sourceName, String destinationName);

    void initGraph();

    void registerObserver(Observer observer);

    List<Node> getResult();
}
