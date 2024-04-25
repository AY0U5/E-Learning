package ma.zs.alc.unit.service.impl.admin.grpe;

import ma.zs.alc.bean.core.grpe.GroupeType;
import ma.zs.alc.dao.facade.core.grpe.GroupeTypeDao;
import ma.zs.alc.service.impl.admin.grpe.GroupeTypeAdminServiceImpl;

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
class GroupeTypeAdminServiceImplTest {

    @Mock
    private GroupeTypeDao repository;
    private AutoCloseable autoCloseable;
    private GroupeTypeAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new GroupeTypeAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllGroupeType() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveGroupeType() {
        // Given
        GroupeType toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteGroupeType() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetGroupeTypeById() {
        // Given
        Long idToRetrieve = 1L; // Example GroupeType ID to retrieve
        GroupeType expected = new GroupeType(); // You need to replace GroupeType with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        GroupeType result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private GroupeType constructSample(int i) {
		GroupeType given = new GroupeType();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
