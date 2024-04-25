package ma.zs.alc.unit.service.impl.admin.grpe;

import ma.zs.alc.bean.core.grpe.GroupeEtude;
import ma.zs.alc.dao.facade.core.grpe.GroupeEtudeDao;
import ma.zs.alc.service.impl.admin.grpe.GroupeEtudeAdminServiceImpl;

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
class GroupeEtudeAdminServiceImplTest {

    @Mock
    private GroupeEtudeDao repository;
    private AutoCloseable autoCloseable;
    private GroupeEtudeAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new GroupeEtudeAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllGroupeEtude() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveGroupeEtude() {
        // Given
        GroupeEtude toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteGroupeEtude() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetGroupeEtudeById() {
        // Given
        Long idToRetrieve = 1L; // Example GroupeEtude ID to retrieve
        GroupeEtude expected = new GroupeEtude(); // You need to replace GroupeEtude with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        GroupeEtude result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private GroupeEtude constructSample(int i) {
		GroupeEtude given = new GroupeEtude();
        given.setLibelle("libelle-"+i);
        given.setDescription("description-"+i);
        given.setNombreEtudiant(i*1L);
        return given;
    }

}
