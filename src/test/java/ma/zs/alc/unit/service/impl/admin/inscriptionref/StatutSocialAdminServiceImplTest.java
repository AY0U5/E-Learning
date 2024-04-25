package ma.zs.alc.unit.service.impl.admin.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.StatutSocial;
import ma.zs.alc.dao.facade.core.inscriptionref.StatutSocialDao;
import ma.zs.alc.service.impl.admin.inscriptionref.StatutSocialAdminServiceImpl;

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
class StatutSocialAdminServiceImplTest {

    @Mock
    private StatutSocialDao repository;
    private AutoCloseable autoCloseable;
    private StatutSocialAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new StatutSocialAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllStatutSocial() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveStatutSocial() {
        // Given
        StatutSocial toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteStatutSocial() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetStatutSocialById() {
        // Given
        Long idToRetrieve = 1L; // Example StatutSocial ID to retrieve
        StatutSocial expected = new StatutSocial(); // You need to replace StatutSocial with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        StatutSocial result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private StatutSocial constructSample(int i) {
		StatutSocial given = new StatutSocial();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
