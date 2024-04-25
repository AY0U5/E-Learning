package ma.zs.alc.unit.service.impl.admin.prof;

import ma.zs.alc.bean.core.prof.ScheduleProf;
import ma.zs.alc.dao.facade.core.prof.ScheduleProfDao;
import ma.zs.alc.service.impl.admin.prof.ScheduleProfAdminServiceImpl;

import ma.zs.alc.bean.core.grpe.GroupeEtudiant ;
import ma.zs.alc.bean.core.course.Cours ;
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
class ScheduleProfAdminServiceImplTest {

    @Mock
    private ScheduleProfDao repository;
    private AutoCloseable autoCloseable;
    private ScheduleProfAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ScheduleProfAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllScheduleProf() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveScheduleProf() {
        // Given
        ScheduleProf toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteScheduleProf() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetScheduleProfById() {
        // Given
        Long idToRetrieve = 1L; // Example ScheduleProf ID to retrieve
        ScheduleProf expected = new ScheduleProf(); // You need to replace ScheduleProf with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        ScheduleProf result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private ScheduleProf constructSample(int i) {
		ScheduleProf given = new ScheduleProf();
        given.setSubject("subject-"+i);
        given.setStartTime(LocalDateTime.now());
        given.setEndTime(LocalDateTime.now());
        given.setRef("ref-"+i);
        given.setGroupeEtudiant(new GroupeEtudiant(1L));
        given.setProf(new Prof(1L));
        given.setCours(new Cours(1L));
        given.setGrpName("grpName-"+i);
        given.setProfName("profName-"+i);
        given.setProfsId(i*1L);
        return given;
    }

}
