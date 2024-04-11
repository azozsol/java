package g52445.stib.dao;

import g52445.stib.dto.StationDto;
import g52445.stib.repository.RepositoryException;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class StationDaoTest {
    private final StationDto Horta; // Not exist.
    private final StationDto Louise; // Exist.
    private final List<StationDto> all;
    private final Connection connection;

    public StationDaoTest() throws RepositoryException {
        Horta = new StationDto(0000, "HORTA");
        Louise = new StationDto(8322, "LOUISE");
        all = new ArrayList<>();

        try {
            connection = DBManager.getInstance().getConnection();
            String query = "SELECT * FROM STATIONS";
            Statement stmt = null;
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                StationDto sDto = new StationDto(result.getInt(1), result.getString(2));
                all.add(sDto);
            }
        } catch (SQLException | RepositoryException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSelectAllTrue() throws RepositoryException {
        StationDao stationDao = StationDao.getInstance();
        List<StationDto> result = all;
        List<StationDto> expect = stationDao.selectAll();
        assertEquals(result,expect);
    }

    @Test
    public void testSelectAllFalse() throws RepositoryException {
        StationDao stationDao = StationDao.getInstance();
        List<StationDto> result = all;
        result.add(Horta);
        List<StationDto> expect = stationDao.selectAll();
        assertNotEquals(result,expect);
    }

    @Test
    public void testgetStationNumberTrue() throws RepositoryException{
        int result = StationDao.getInstance().getStationNumber();
        int expect = 60;
        assertEquals(result, expect);
    }

    @Test
    public void testgetStationNumberfalse() throws RepositoryException{
        int result = StationDao.getInstance().getStationNumber();
        int expect = 65;
        assertNotEquals(result, expect);
    }
}