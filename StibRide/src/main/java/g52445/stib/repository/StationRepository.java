package g52445.stib.repository;

import g52445.stib.dao.StationDao;
import g52445.stib.dto.StationDto;
import g52445.stib.model.Neighbors;

import java.util.List;

public class StationRepository implements Repository<Integer, StationDto>{

    private StationDao stationDao;

    public StationRepository() throws RepositoryException {
        this.stationDao = StationDao.getInstance();
    }

    public StationRepository(StationDao stationDao){
        this.stationDao = stationDao;
    }
    public int getStationNumbers() throws RepositoryException{
        return this.stationDao.getStationNumber();
    }

    public List<Neighbors> getNeighborsOfNode(StationDto stationDto) throws RepositoryException{
        return this.stationDao.getNeighbors(stationDto);
    }
    @Override
    public void add(StationDto item) throws RepositoryException {
            this.stationDao.insert(item);
    }

    @Override
    public boolean remove(Integer key) throws RepositoryException {
        return true;
    }

    @Override
    public List<StationDto> getAll() throws RepositoryException {
        return this.stationDao.selectAll();
    }

    @Override
    public StationDto get(Integer key) throws RepositoryException {
        return this.stationDao.select(key);
    }

    @Override
    public boolean contains(Integer key) throws RepositoryException {
        return false;
    }

}
