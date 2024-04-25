package ma.zs.alc.unit.service.impl.admin.common;

import ma.zs.alc.bean.core.common.News;
import ma.zs.alc.dao.facade.core.common.NewsDao;
import ma.zs.alc.service.impl.admin.common.NewsAdminServiceImpl;

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
class NewsAdminServiceImplTest {

    @Mock
    private NewsDao repository;
    private AutoCloseable autoCloseable;
    private NewsAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new NewsAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllNews() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveNews() {
        // Given
        News toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteNews() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetNewsById() {
        // Given
        Long idToRetrieve = 1L; // Example News ID to retrieve
        News expected = new News(); // You need to replace News with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        News result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private News constructSample(int i) {
		News given = new News();
        given.setRef("ref-"+i);
        given.setLibelle("libelle-"+i);
        given.setImage("image-"+i);
        given.setDescription("description-"+i);
        given.setDateNews(LocalDateTime.now());
        given.setDateDebut(LocalDateTime.now());
        given.setDateFin(LocalDateTime.now());
        given.setNumeroOrdre(i);
        given.setDestinataire("destinataire-"+i);
        return given;
    }

}
