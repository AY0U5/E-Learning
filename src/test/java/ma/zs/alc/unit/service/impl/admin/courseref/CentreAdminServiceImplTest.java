package ma.zs.alc.unit.service.impl.admin.courseref;

import ma.zs.alc.bean.core.courseref.Centre;
import ma.zs.alc.dao.facade.core.courseref.CentreDao;
import ma.zs.alc.service.impl.admin.courseref.CentreAdminServiceImpl;

import ma.zs.alc.bean.core.course.Parcours ;
import ma.zs.alc.bean.core.courseref.Centre ;
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
class CentreAdminServiceImplTest {

    @Mock
    private CentreDao repository;
    private AutoCloseable autoCloseable;
    private CentreAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CentreAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllCentre() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveCentre() {
        // Given
        Centre toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteCentre() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetCentreById() {
        // Given
        Long idToRetrieve = 1L; // Example Centre ID to retrieve
        Centre expected = new Centre(); // You need to replace Centre with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Centre result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Centre constructSample(int i) {
		Centre given = new Centre();
        given.setRef("ref-"+i);
        given.setLibelle("libelle-"+i);
        given.setDescription("description-"+i);
        given.setLog("log-"+i);
        given.setPassword("password-"+i);
        List<Parcours> parcourss = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                Parcours element = new Parcours();
                                                element.setId((long)id);
                                                element.setDatePublication(LocalDateTime.now());
                                                element.setDateCreation(LocalDateTime.now());
                                                element.setDescription("description"+id);
                                                element.setCode("code"+id);
                                                element.setLibelle("libelle"+id);
                                                element.setNumeroOrder(6);
                                                element.setNombreCours(7);
                                                element.setCentre(new Centre(Long.valueOf(8)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setParcourss(parcourss);
        return given;
    }

}
