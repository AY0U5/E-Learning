package ma.zs.alc.unit.service.impl.admin.prof;

import ma.zs.alc.bean.core.prof.CategorieProf;
import ma.zs.alc.dao.facade.core.prof.CategorieProfDao;
import ma.zs.alc.service.impl.admin.prof.CategorieProfAdminServiceImpl;

import ma.zs.alc.bean.core.course.Parcours ;
import ma.zs.alc.bean.core.prof.TypeTeacher ;
import ma.zs.alc.bean.core.prof.CategorieProf ;
import ma.zs.alc.bean.core.prof.Prof ;
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
class CategorieProfAdminServiceImplTest {

    @Mock
    private CategorieProfDao repository;
    private AutoCloseable autoCloseable;
    private CategorieProfAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CategorieProfAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllCategorieProf() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveCategorieProf() {
        // Given
        CategorieProf toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteCategorieProf() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetCategorieProfById() {
        // Given
        Long idToRetrieve = 1L; // Example CategorieProf ID to retrieve
        CategorieProf expected = new CategorieProf(); // You need to replace CategorieProf with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        CategorieProf result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private CategorieProf constructSample(int i) {
		CategorieProf given = new CategorieProf();
        given.setCode("code-"+i);
        given.setLevel("level-"+i);
        given.setLessonRate(BigDecimal.TEN);
        List<Prof> profs = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                Prof element = new Prof();
                                                element.setId((long)id);
                                                element.setRef("ref"+id);
                                                element.setAbout("about"+id);
                                                element.setParcours(new Parcours(Long.valueOf(3)));
                                                element.setCategorieProf(new CategorieProf(Long.valueOf(5)));
                                                element.setTypeTeacher(new TypeTeacher(Long.valueOf(8)));
                                                element.setCredentialsNonExpired(true);
                                                element.setEnabled(true);
                                                element.setAccountNonExpired(true);
                                                element.setAccountNonLocked(true);
                                                element.setPasswordChanged(true);
                                                element.setUsername("username"+id);
                                                element.setPassword("password"+id);
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setProfs(profs);
        return given;
    }

}
