package g52445.stib.dao;

import g52445.stib.dto.StationDto;
import g52445.stib.repository.RepositoryException;
import g52445.stib.repository.StationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.times;
import static org.junit.Assert.*;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class StationRepositoryTest {

    @Mock
    private StationDao mock;

    private final StationDto Horta;

    private final StationDto Louise;

    private final int KEY = 8322;

    public StationRepositoryTest() {

        Horta = new StationDto(0000, "HORTA");
        Louise = new StationDto(KEY, "LOUISE");

    }

    @BeforeEach
    public void init() throws RepositoryException {
        Mockito.lenient().when(mock.select(Horta.getKey())).thenReturn(null);
        Mockito.lenient().when(mock.select(Louise.getKey())).thenReturn(Louise);
        Mockito.lenient().when(mock.select(null)).thenThrow(RepositoryException.class);
    }

    @Test
    public void testSelectExist() throws Exception {
        StationRepository stationRepository = new StationRepository(mock);

        StationDto epexct = Louise;
        StationDto result = stationRepository.get(KEY);
        assertEquals(result, epexct);
        Mockito.verify(mock, times(1)).select(KEY);
    }

    @Test
    public void testSelectNotExist() throws Exception {
        StationRepository stationRepository = new StationRepository(mock);

        StationDto epexct = null;
        StationDto result = stationRepository.get(0000);
        assertNull(result);
        Mockito.verify(mock, times(1)).select(0000);
    }

}
