package ma.zs.alc.unit.service.impl.admin.course;

import ma.zs.alc.bean.core.course.Section;
import ma.zs.alc.dao.facade.core.course.SectionDao;
import ma.zs.alc.service.impl.admin.course.SectionAdminServiceImpl;

import ma.zs.alc.bean.core.courseref.CategorieSection ;
import ma.zs.alc.bean.core.course.Section ;
import ma.zs.alc.bean.core.course.Cours ;
import ma.zs.alc.bean.core.course.SectionItem ;
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
class SectionAdminServiceImplTest {

    @Mock
    private SectionDao repository;
    private AutoCloseable autoCloseable;
    private SectionAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new SectionAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllSection() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveSection() {
        // Given
        Section toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteSection() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetSectionById() {
        // Given
        Long idToRetrieve = 1L; // Example Section ID to retrieve
        Section expected = new Section(); // You need to replace Section with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Section result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Section constructSample(int i) {
		Section given = new Section();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        given.setUrlImage("urlImage-"+i);
        given.setUrlImage2("urlImage2-"+i);
        given.setUrlImage3("urlImage3-"+i);
        given.setUrlVideo("urlVideo-"+i);
        given.setContenu("contenu-"+i);
        given.setQuestions("questions-"+i);
        given.setIndicationProf("indicationProf-"+i);
        given.setNumeroOrder(i);
        given.setCategorieSection(new CategorieSection(1L));
        given.setCours(new Cours(1L));
        given.setUrl(i);
        given.setContent(i);
        List<SectionItem> sectionItems = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                SectionItem element = new SectionItem();
                                                element.setId((long)id);
                                                element.setImageUrl("imageUrl"+id);
                                                element.setResponse("response"+id);
                                                element.setTranscription("transcription"+id);
                                                element.setTranslation("translation"+id);
                                                element.setExplanation("explanation"+id);
                                                element.setExample("example"+id);
                                                element.setSynonyms("synonyms"+id);
                                                element.setSection(new Section(Long.valueOf(8)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setSectionItems(sectionItems);
        return given;
    }

}
