package ma.zs.alc.unit.service.impl.admin.pack;

import ma.zs.alc.bean.core.pack.PackStudent;
import ma.zs.alc.dao.facade.core.pack.PackStudentDao;
import ma.zs.alc.service.impl.admin.pack.PackStudentAdminServiceImpl;

import ma.zs.alc.bean.core.course.Parcours ;
import ma.zs.alc.bean.core.price.Price ;
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
class PackStudentAdminServiceImplTest {

    @Mock
    private PackStudentDao repository;
    private AutoCloseable autoCloseable;
    private PackStudentAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new PackStudentAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllPackStudent() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSavePackStudent() {
        // Given
        PackStudent toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeletePackStudent() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetPackStudentById() {
        // Given
        Long idToRetrieve = 1L; // Example PackStudent ID to retrieve
        PackStudent expected = new PackStudent(); // You need to replace PackStudent with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        PackStudent result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private PackStudent constructSample(int i) {
		PackStudent given = new PackStudent();
        given.setNombreCours(i);
        given.setForGroupe(false);
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        given.setDescription("description-"+i);
        given.setPreRequisites("preRequisites-"+i);
        given.setWhyTakeThisCourse("whyTakeThisCourse-"+i);
        given.setExpectations("expectations-"+i);
        given.setParcours(new Parcours(1L));
        given.setImgUrl("imgUrl-"+i);
        given.setPrice(new Price(1L));
        given.setTotalStudents(i);
        given.setRating("rating-"+i);
        given.setOldPrice("oldPrice-"+i);
        return given;
    }

}
