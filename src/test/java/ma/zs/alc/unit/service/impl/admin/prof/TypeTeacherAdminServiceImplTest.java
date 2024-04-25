package ma.zs.alc.unit.service.impl.admin.prof;

import ma.zs.alc.bean.core.prof.TypeTeacher;
import ma.zs.alc.dao.facade.core.prof.TypeTeacherDao;
import ma.zs.alc.service.impl.admin.prof.TypeTeacherAdminServiceImpl;

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
class TypeTeacherAdminServiceImplTest {

    @Mock
    private TypeTeacherDao repository;
    private AutoCloseable autoCloseable;
    private TypeTeacherAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new TypeTeacherAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllTypeTeacher() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveTypeTeacher() {
        // Given
        TypeTeacher toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteTypeTeacher() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetTypeTeacherById() {
        // Given
        Long idToRetrieve = 1L; // Example TypeTeacher ID to retrieve
        TypeTeacher expected = new TypeTeacher(); // You need to replace TypeTeacher with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        TypeTeacher result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private TypeTeacher constructSample(int i) {
		TypeTeacher given = new TypeTeacher();
        given.setLibelle("libelle-"+i);
        given.setCode("code-"+i);
        return given;
    }

}
