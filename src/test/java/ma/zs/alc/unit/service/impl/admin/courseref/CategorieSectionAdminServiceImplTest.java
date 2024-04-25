package ma.zs.alc.unit.service.impl.admin.courseref;

import ma.zs.alc.bean.core.courseref.CategorieSection;
import ma.zs.alc.dao.facade.core.courseref.CategorieSectionDao;
import ma.zs.alc.service.impl.admin.courseref.CategorieSectionAdminServiceImpl;

import ma.zs.alc.bean.core.courseref.CategorieSection ;
import ma.zs.alc.bean.core.course.Section ;
import ma.zs.alc.bean.core.courseref.SuperCategorieSection ;
import ma.zs.alc.bean.core.course.Cours ;
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
class CategorieSectionAdminServiceImplTest {

    @Mock
    private CategorieSectionDao repository;
    private AutoCloseable autoCloseable;
    private CategorieSectionAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CategorieSectionAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllCategorieSection() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveCategorieSection() {
        // Given
        CategorieSection toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteCategorieSection() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetCategorieSectionById() {
        // Given
        Long idToRetrieve = 1L; // Example CategorieSection ID to retrieve
        CategorieSection expected = new CategorieSection(); // You need to replace CategorieSection with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        CategorieSection result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private CategorieSection constructSample(int i) {
		CategorieSection given = new CategorieSection();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        given.setNumeroOrder(i);
        given.setSuperCategorieSection(new SuperCategorieSection(1L));
        List<Section> sections = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                Section element = new Section();
                                                element.setId((long)id);
                                                element.setCode("code"+id);
                                                element.setLibelle("libelle"+id);
                                                element.setUrlImage("urlImage"+id);
                                                element.setUrlImage2("urlImage2"+id);
                                                element.setUrlImage3("urlImage3"+id);
                                                element.setUrlVideo("urlVideo"+id);
                                                element.setContenu("contenu"+id);
                                                element.setQuestions("questions"+id);
                                                element.setIndicationProf("indicationProf"+id);
                                                element.setNumeroOrder(10);
                                                element.setCategorieSection(new CategorieSection(Long.valueOf(11)));
                                                element.setCours(new Cours(Long.valueOf(12)));
                                                element.setUrl(13);
                                                element.setContent(14);
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setSections(sections);
        return given;
    }

}
