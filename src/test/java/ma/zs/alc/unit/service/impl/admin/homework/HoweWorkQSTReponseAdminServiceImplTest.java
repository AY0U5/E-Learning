package ma.zs.alc.unit.service.impl.admin.homework;

import ma.zs.alc.bean.core.homework.HoweWorkQSTReponse;
import ma.zs.alc.dao.facade.core.homework.HoweWorkQSTReponseDao;
import ma.zs.alc.service.impl.admin.homework.HoweWorkQSTReponseAdminServiceImpl;

import ma.zs.alc.bean.core.homework.HomeWorkQuestion ;
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
class HoweWorkQSTReponseAdminServiceImplTest {

    @Mock
    private HoweWorkQSTReponseDao repository;
    private AutoCloseable autoCloseable;
    private HoweWorkQSTReponseAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new HoweWorkQSTReponseAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllHoweWorkQSTReponse() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveHoweWorkQSTReponse() {
        // Given
        HoweWorkQSTReponse toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteHoweWorkQSTReponse() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetHoweWorkQSTReponseById() {
        // Given
        Long idToRetrieve = 1L; // Example HoweWorkQSTReponse ID to retrieve
        HoweWorkQSTReponse expected = new HoweWorkQSTReponse(); // You need to replace HoweWorkQSTReponse with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        HoweWorkQSTReponse result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private HoweWorkQSTReponse constructSample(int i) {
		HoweWorkQSTReponse given = new HoweWorkQSTReponse();
        given.setRef("ref-"+i);
        given.setLib("lib-"+i);
        given.setEtatReponse("etatReponse-"+i);
        given.setNumero(i);
        given.setHomeWorkQuestion(new HomeWorkQuestion(1L));
        return given;
    }

}
