package g52445.stib.model;

import g52445.stib.dto.StationDto;

import java.util.*;

public class Neighbors {

    private StationDto origin;
    private StationDto neighbor;
    private List<Integer> linesOrg;
    private List<Integer> linesNeig;

    public Neighbors(StationDto origin, StationDto neighbor, List<Integer> linesOrg, List<Integer> linesNeig) {
        this.origin = origin;
        this.neighbor = neighbor;
        this.linesOrg = linesOrg;
        this.linesNeig = linesNeig;
    }

    public StationDto getOrigin() {
        return origin;
    }

    public StationDto getNeighbor() {
        return neighbor;
    }

    public List<Integer> getLinesOrg() {
        return linesOrg;
    }

    public List<Integer> getLinesNeig() {
        return linesNeig;
    }
}
