package ma.zs.alc.unit.service.impl.admin.course;

import ma.zs.alc.bean.core.course.SectionItem;
import ma.zs.alc.dao.facade.core.course.SectionItemDao;
import ma.zs.alc.service.impl.admin.course.SectionItemAdminServiceImpl;

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
class SectionItemAdminServiceImplTest {

    @Mock
    private SectionItemDao repository;
    private AutoCloseable autoCloseable;
    private SectionItemAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new SectionItemAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllSectionItem() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveSectionItem() {
        // Given
        SectionItem toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteSectionItem() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetSectionItemById() {
        // Given
        Long idToRetrieve = 1L; // Example SectionItem ID to retrieve
        SectionItem expected = new SectionItem(); // You need to replace SectionItem with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        SectionItem result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private SectionItem constructSample(int i) {
		SectionItem given = new SectionItem();
        given.setImageUrl("imageUrl-"+i);
        given.setResponse("response-"+i);
        given.setTranscription("transcription-"+i);
        given.setTranslation("translation-"+i);
        given.setExplanation("explanation-"+i);
        given.setExample("example-"+i);
        given.setSynonyms("synonyms-"+i);
        given.setSection(new Section(1L));
        return given;
    }

}
