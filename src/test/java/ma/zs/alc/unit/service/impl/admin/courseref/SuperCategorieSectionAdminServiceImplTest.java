package ma.zs.alc.unit.service.impl.admin.courseref;

import ma.zs.alc.bean.core.courseref.SuperCategorieSection;
import ma.zs.alc.dao.facade.core.courseref.SuperCategorieSectionDao;
import ma.zs.alc.service.impl.admin.courseref.SuperCategorieSectionAdminServiceImpl;

import ma.zs.alc.bean.core.courseref.CategorieSection ;
import ma.zs.alc.bean.core.courseref.SuperCategorieSection ;
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
class SuperCategorieSectionAdminServiceImplTest {

    @Mock
    private SuperCategorieSectionDao repository;
    private AutoCloseable autoCloseable;
    private SuperCategorieSectionAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new SuperCategorieSectionAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllSuperCategorieSection() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveSuperCategorieSection() {
        // Given
        SuperCategorieSection toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteSuperCategorieSection() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetSuperCategorieSectionById() {
        // Given
        Long idToRetrieve = 1L; // Example SuperCategorieSection ID to retrieve
        SuperCategorieSection expected = new SuperCategorieSection(); // You need to replace SuperCategorieSection with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        SuperCategorieSection result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private SuperCategorieSection constructSample(int i) {
		SuperCategorieSection given = new SuperCategorieSection();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        List<CategorieSection> categorieSections = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                CategorieSection element = new CategorieSection();
                                                element.setId((long)id);
                                                element.setCode("code"+id);
                                                element.setLibelle("libelle"+id);
                                                element.setNumeroOrder(3);
                                                element.setSuperCategorieSection(new SuperCategorieSection(Long.valueOf(4)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setCategorieSections(categorieSections);
        return given;
    }

}
