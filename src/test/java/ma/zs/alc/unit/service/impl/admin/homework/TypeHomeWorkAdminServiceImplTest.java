package ma.zs.alc.unit.service.impl.admin.homework;

import ma.zs.alc.bean.core.homework.TypeHomeWork;
import ma.zs.alc.dao.facade.core.homework.TypeHomeWorkDao;
import ma.zs.alc.service.impl.admin.homework.TypeHomeWorkAdminServiceImpl;

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
class TypeHomeWorkAdminServiceImplTest {

    @Mock
    private TypeHomeWorkDao repository;
    private AutoCloseable autoCloseable;
    private TypeHomeWorkAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new TypeHomeWorkAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllTypeHomeWork() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveTypeHomeWork() {
        // Given
        TypeHomeWork toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteTypeHomeWork() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetTypeHomeWorkById() {
        // Given
        Long idToRetrieve = 1L; // Example TypeHomeWork ID to retrieve
        TypeHomeWork expected = new TypeHomeWork(); // You need to replace TypeHomeWork with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        TypeHomeWork result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private TypeHomeWork constructSample(int i) {
		TypeHomeWork given = new TypeHomeWork();
        given.setCode("code-"+i);
        given.setLib("lib-"+i);
        return given;
    }

}
