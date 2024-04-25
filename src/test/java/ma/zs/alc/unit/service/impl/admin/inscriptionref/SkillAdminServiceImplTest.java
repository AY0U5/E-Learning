package ma.zs.alc.unit.service.impl.admin.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.Skill;
import ma.zs.alc.dao.facade.core.inscriptionref.SkillDao;
import ma.zs.alc.service.impl.admin.inscriptionref.SkillAdminServiceImpl;

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
class SkillAdminServiceImplTest {

    @Mock
    private SkillDao repository;
    private AutoCloseable autoCloseable;
    private SkillAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new SkillAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllSkill() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveSkill() {
        // Given
        Skill toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteSkill() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetSkillById() {
        // Given
        Long idToRetrieve = 1L; // Example Skill ID to retrieve
        Skill expected = new Skill(); // You need to replace Skill with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Skill result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Skill constructSample(int i) {
		Skill given = new Skill();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
