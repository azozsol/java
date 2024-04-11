package g52445.stib.model;

import g52445.stib.dto.StationDto;

import java.util.*;

public class Node {

    private List<Node> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;
    private Map<Node, Integer> adjacentNodes = new HashMap<>();
    private List<Integer> lines = new ArrayList<>();
    private StationDto station;
    private final int distanceBetweenAdjacent = 1;

    String name;

    public Node(String name) {
        this.name = name;
    }

    public Node(StationDto station) {
        this.station = station;
        //this.shortestPath = new LinkedList<>();
        //this.adjacentNodes = new HashMap<>();
      //  this.lines = new ArrayList<>();
    }

    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public void addDestination(Node destination) {
        adjacentNodes.put(destination, distanceBetweenAdjacent);
    }
    public Integer getDistance() {
        return distance;
    }

    public String getStationName() {
        return station.getName();
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public List<Integer> getLines() {
        return lines;
    }

    public void setLines(List<Integer> lines) {
        this.lines = lines;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

}
