package ma.zs.alc.unit.service.impl.admin.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.TeacherLocality;
import ma.zs.alc.dao.facade.core.inscriptionref.TeacherLocalityDao;
import ma.zs.alc.service.impl.admin.inscriptionref.TeacherLocalityAdminServiceImpl;

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
class TeacherLocalityAdminServiceImplTest {

    @Mock
    private TeacherLocalityDao repository;
    private AutoCloseable autoCloseable;
    private TeacherLocalityAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new TeacherLocalityAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllTeacherLocality() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveTeacherLocality() {
        // Given
        TeacherLocality toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteTeacherLocality() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetTeacherLocalityById() {
        // Given
        Long idToRetrieve = 1L; // Example TeacherLocality ID to retrieve
        TeacherLocality expected = new TeacherLocality(); // You need to replace TeacherLocality with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        TeacherLocality result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private TeacherLocality constructSample(int i) {
		TeacherLocality given = new TeacherLocality();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
