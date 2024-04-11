package g52445.stib.model;

public class StationData{

    private String stationName;
    private String lines;

    public StationData(String stationName, String lines) {
        this.stationName = stationName;
        this.lines = lines;
    }

    public String getStationName() {
        return stationName;
    }

    public String getLines() {
        return lines;
    }
}
