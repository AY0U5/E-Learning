package ma.zs.alc.unit.service.impl.admin.recomrecla;

import ma.zs.alc.bean.core.recomrecla.TypeReclamationProf;
import ma.zs.alc.dao.facade.core.recomrecla.TypeReclamationProfDao;
import ma.zs.alc.service.impl.admin.recomrecla.TypeReclamationProfAdminServiceImpl;

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
class TypeReclamationProfAdminServiceImplTest {

    @Mock
    private TypeReclamationProfDao repository;
    private AutoCloseable autoCloseable;
    private TypeReclamationProfAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new TypeReclamationProfAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllTypeReclamationProf() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveTypeReclamationProf() {
        // Given
        TypeReclamationProf toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteTypeReclamationProf() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetTypeReclamationProfById() {
        // Given
        Long idToRetrieve = 1L; // Example TypeReclamationProf ID to retrieve
        TypeReclamationProf expected = new TypeReclamationProf(); // You need to replace TypeReclamationProf with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        TypeReclamationProf result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private TypeReclamationProf constructSample(int i) {
		TypeReclamationProf given = new TypeReclamationProf();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
