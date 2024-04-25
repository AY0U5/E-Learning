package ma.zs.alc.unit.service.impl.admin.prof;

import ma.zs.alc.bean.core.prof.TrancheHoraireProf;
import ma.zs.alc.dao.facade.core.prof.TrancheHoraireProfDao;
import ma.zs.alc.service.impl.admin.prof.TrancheHoraireProfAdminServiceImpl;

import ma.zs.alc.bean.core.prof.Prof ;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDateTime;



import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class TrancheHoraireProfAdminServiceImplTest {

    @Mock
    private TrancheHoraireProfDao repository;
    private AutoCloseable autoCloseable;
    private TrancheHoraireProfAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new TrancheHoraireProfAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllTrancheHoraireProf() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveTrancheHoraireProf() {
        // Given
        TrancheHoraireProf toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteTrancheHoraireProf() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetTrancheHoraireProfById() {
        // Given
        Long idToRetrieve = 1L; // Example TrancheHoraireProf ID to retrieve
        TrancheHoraireProf expected = new TrancheHoraireProf(); // You need to replace TrancheHoraireProf with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        TrancheHoraireProf result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private TrancheHoraireProf constructSample(int i) {
		TrancheHoraireProf given = new TrancheHoraireProf();
        given.setProf(new Prof(1L));
        given.setStartHour("startHour-"+i);
        given.setEndHour("endHour-"+i);
        given.setDay(i);
        given.setGroupIndex(i);
        given.setProfsId(i*1L);
        return given;
    }

}
