package g52445.stib.model;

import g52445.stib.dto.StationDto;
import g52445.stib.repository.RepositoryException;
import g52445.stib.repository.StationRepository;

import java.util.*;
import java.util.List;

public class StibRide extends Observable implements Facade {

    private StationRepository stationRepository;
    private List<Node> allNodes;
    private List<StationDto> allStations;

    // private List<Node> pathResult;
    private Graph graph;

    private List<Node> result;

    public StibRide() {
        this.allNodes = new ArrayList<>();
        //this.pathResult = new ArrayList<>();
        this.result = new ArrayList<>();
        try {
            this.stationRepository = new StationRepository();
            this.allStations = this.stationRepository.getAll();
        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }
    }

    public List<StationDto> getStations() {
        try {
            return this.stationRepository.getAll();
        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }
    }

    public void initGraph() {
        this.allNodes = new ArrayList<>();
        this.graph = new Graph();
        fillNodes();
        this.allStations.forEach((station) -> {
            try {
                List<Neighbors> neighbors = this.stationRepository.getNeighborsOfNode(station);
                Node origin = findNode(neighbors.get(0).getOrigin().getName());
                origin.setLines(neighbors.get(0).getLinesOrg());
                neighbors.forEach((neig) -> {
                    Node neigNode = findNode(neig.getNeighbor().getName());
                    origin.addDestination(neigNode); // It is not a good way, it is java not c++
                });
                this.graph.addNode(origin);
            } catch (RepositoryException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private Node findNode(String name) {
        for (Node node : this.allNodes) {
            if (node.getStationName().equals(name)) {
                return node;
            }
        }
        return null;
    }

    private void fillNodes() {
        this.allStations.forEach((station) -> {
            Node node = new Node(station);
            this.allNodes.add(node);
        });
    }

    @Override
    public void searchPath(String sourceName, String destinationName) {
        Node source = findNode(sourceName);
        Node destination = findNode(destinationName);
        this.graph = Dijkstra.calculateShortestPathFromSource(this.graph, source);
        result = destination.getShortestPath();
        result.add(destination);// Adding last station
        super.notifyPathObservers();
    }

    public List<Node> getResult() {
        return result;
    }

    public static void main(String[] args) {
        StibRide stip = new StibRide();
        stip.fillNodes();
        try {
            List<Neighbors> neighbors = stip.stationRepository.getNeighborsOfNode(new StationDto(8042, "ARTS-LOI"));

            Node  no = stip.findNode(neighbors.get(0).getOrigin().getName());
            no.getLines().forEach( e ->
                    System.out.println(e));



        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }
    }
}