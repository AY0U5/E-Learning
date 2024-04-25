package ma.zs.alc.unit.service.impl.admin.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.ConfirmationToken;
import ma.zs.alc.dao.facade.core.inscriptionref.ConfirmationTokenDao;
import ma.zs.alc.service.impl.admin.inscriptionref.ConfirmationTokenAdminServiceImpl;

import ma.zs.alc.bean.core.inscription.Etudiant ;
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
class ConfirmationTokenAdminServiceImplTest {

    @Mock
    private ConfirmationTokenDao repository;
    private AutoCloseable autoCloseable;
    private ConfirmationTokenAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ConfirmationTokenAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllConfirmationToken() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveConfirmationToken() {
        // Given
        ConfirmationToken toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteConfirmationToken() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetConfirmationTokenById() {
        // Given
        Long idToRetrieve = 1L; // Example ConfirmationToken ID to retrieve
        ConfirmationToken expected = new ConfirmationToken(); // You need to replace ConfirmationToken with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        ConfirmationToken result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private ConfirmationToken constructSample(int i) {
		ConfirmationToken given = new ConfirmationToken();
        given.setToken("token-"+i);
        given.setExpiresAt(LocalDateTime.now());
        given.setCreatedAt(LocalDateTime.now());
        given.setConfirmedAt(LocalDateTime.now());
        given.setEtudiant(new Etudiant(1L));
        return given;
    }

}
