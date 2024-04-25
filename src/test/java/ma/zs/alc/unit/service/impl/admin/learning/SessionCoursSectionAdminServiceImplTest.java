package ma.zs.alc.unit.service.impl.admin.learning;

import ma.zs.alc.bean.core.learning.SessionCoursSection;
import ma.zs.alc.dao.facade.core.learning.SessionCoursSectionDao;
import ma.zs.alc.service.impl.admin.learning.SessionCoursSectionAdminServiceImpl;

import ma.zs.alc.bean.core.learning.SessionCours ;
import ma.zs.alc.bean.core.course.Section ;
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
class SessionCoursSectionAdminServiceImplTest {

    @Mock
    private SessionCoursSectionDao repository;
    private AutoCloseable autoCloseable;
    private SessionCoursSectionAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new SessionCoursSectionAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllSessionCoursSection() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveSessionCoursSection() {
        // Given
        SessionCoursSection toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteSessionCoursSection() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetSessionCoursSectionById() {
        // Given
        Long idToRetrieve = 1L; // Example SessionCoursSection ID to retrieve
        SessionCoursSection expected = new SessionCoursSection(); // You need to replace SessionCoursSection with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        SessionCoursSection result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private SessionCoursSection constructSample(int i) {
		SessionCoursSection given = new SessionCoursSection();
        given.setSessionCours(new SessionCours(1L));
        given.setSection(new Section(1L));
        return given;
    }

}
