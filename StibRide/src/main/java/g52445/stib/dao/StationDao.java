package g52445.stib.dao;

import g52445.stib.dto.StationDto;
import g52445.stib.model.Neighbors;
import g52445.stib.repository.RepositoryException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StationDao implements Dao<Integer, StationDto> {

    private Connection connection;

    private StationDao() throws RepositoryException {
        connection = DBManager.getInstance().getConnection();
    }

    public static StationDao getInstance() throws RepositoryException {
        return StationDaoHolder.getInstance();
    }

    private static class StationDaoHolder {
        private static StationDao getInstance() throws RepositoryException {
            return new StationDao();
        }
    }

    @Override
    public Integer insert(StationDto item) throws RepositoryException {
        if (item.equals(null)) {
            throw new RepositoryException("null item");
        }
        String query = "INSERT INTO STATIONS(id, name) VALUES(?, ?)";
        try {
            PreparedStatement prepStat = connection.prepareStatement(query);
            prepStat.setInt(1, item.getKey());
            prepStat.setString(2, item.getName());
            prepStat.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return item.getKey();
    }

    @Override
    public void delete(Integer key) throws RepositoryException {
        String query = "DELETE FROM STATIONS WHERE id = ?";
        try {
            PreparedStatement prepStat = connection.prepareStatement(query);
            prepStat.setInt(1, key);
            prepStat.executeUpdate();
        }catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public void update(StationDto item) throws RepositoryException {
        String query = "UPDATE STATIONS SET id= ? WHERE name = ?";
        try {
            PreparedStatement prapStat = connection.prepareStatement(query);
            prapStat.setInt(1, item.getKey());
            prapStat.setString(2, item.getName());
            prapStat.executeUpdate();
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public List<StationDto> selectAll() throws RepositoryException {
        String query = "SELECT * FROM STATIONS";
        List<StationDto> dtos = new ArrayList<>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                StationDto sDto = new StationDto(result.getInt(1), result.getString(2));
                dtos.add(sDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dtos;
    }

    @Override
    public StationDto select(Integer key) throws RepositoryException {
        if (key.equals(null)) {
            throw new RepositoryException("null");
        }
        StationDto stationDto = null;
        String query = "SELECT * FROM STATIONS WHERE id= ?";
        Statement stmt = null;
        try {
            PreparedStatement prepStat = connection.prepareStatement(query);
            prepStat.setInt(1, key);
            ResultSet result = prepStat.executeQuery();
            while (result.next()) {
                Integer id = result.getInt(1);
                String name = result.getString(2);
                stationDto = new StationDto(id, name);
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return stationDto;
    }

    public int getStationNumber() throws RepositoryException {
        String query = "SELECT count(*) FROM STATIONS";
        Statement stmt = null;
        ResultSet result = null;
        int count = 0;
        try {
            stmt = connection.createStatement();
            result = stmt.executeQuery(query);
            count = result.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public List<Neighbors> getNeighbors(StationDto station) throws RepositoryException {
        List<Neighbors> neighbors = new ArrayList<>();
        String query = "SELECT DISTINCT origin.id, origin.name, stop2.id_station, neighbor.name" +
                "           FROM STATIONS  origin" +
                "           JOIN STOPS stop1 ON origin.id = stop1.id_station" +
                "           JOIN STOPS stop2 ON stop1.id_order = stop2.id_order-1 OR stop1.id_order = stop2.id_order+1" +
                "           JOIN STATIONS neighbor ON stop2.id_station = neighbor.id" +
                "           WHERE origin.id = ? AND stop2.id_line = stop1.id_line";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, station.getKey());
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                int originId = result.getInt(1);
                String originName = result.getString(2);
                StationDto stationOrigin = new StationDto(originId, originName);

                int neighborId = result.getInt(3);
                String neighborName = result.getString(4);
                StationDto stationNeighbors = new StationDto(neighborId, neighborName);

                List<Integer> linesNeighbors = getLines(stationNeighbors);
                List<Integer> linesOrigin = getLines(stationOrigin);

                neighbors.add(
                        new Neighbors(stationOrigin, stationNeighbors, linesOrigin, linesNeighbors));
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return neighbors;
    }

    private List<Integer> getLines(StationDto stationDto) throws RepositoryException {
        List<Integer> lines = new ArrayList<>();
        String query = "SELECT id_line FROM STOPS WHERE id_station = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, stationDto.getKey());
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                int line = result.getInt(1);
                lines.add(line);
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return lines;
    }

    public static void main(String[] args) {
        try {
            StationDao dao = StationDao.getInstance();
            StationDto dto = dao.select(8012);
            System.out.println(dto.getName());
            System.out.println(dto.getKey());
        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }
    }

}
