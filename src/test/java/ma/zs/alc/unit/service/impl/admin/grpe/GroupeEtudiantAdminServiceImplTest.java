package ma.zs.alc.unit.service.impl.admin.grpe;

import ma.zs.alc.bean.core.grpe.GroupeEtudiant;
import ma.zs.alc.dao.facade.core.grpe.GroupeEtudiantDao;
import ma.zs.alc.service.impl.admin.grpe.GroupeEtudiantAdminServiceImpl;

import ma.zs.alc.bean.core.course.Parcours ;
import ma.zs.alc.bean.core.grpe.GroupeEtat ;
import ma.zs.alc.bean.core.grpe.GroupeEtudiantDetail ;
import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.bean.core.grpe.GroupeType ;
import ma.zs.alc.bean.core.grpe.GroupeEtudiant ;
import ma.zs.alc.bean.core.grpe.GroupeEtude ;
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
class GroupeEtudiantAdminServiceImplTest {

    @Mock
    private GroupeEtudiantDao repository;
    private AutoCloseable autoCloseable;
    private GroupeEtudiantAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new GroupeEtudiantAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllGroupeEtudiant() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveGroupeEtudiant() {
        // Given
        GroupeEtudiant toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteGroupeEtudiant() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetGroupeEtudiantById() {
        // Given
        Long idToRetrieve = 1L; // Example GroupeEtudiant ID to retrieve
        GroupeEtudiant expected = new GroupeEtudiant(); // You need to replace GroupeEtudiant with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        GroupeEtudiant result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private GroupeEtudiant constructSample(int i) {
		GroupeEtudiant given = new GroupeEtudiant();
        given.setLibelle("libelle-"+i);
        given.setDateDebut(LocalDateTime.now());
        given.setDateFin(LocalDateTime.now());
        given.setNombrePlace(i*1L);
        given.setNombrePlacevide(i*1L);
        given.setNombrePlaceNonVide(i*1L);
        List<GroupeEtudiantDetail> groupeEtudiantDetails = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                GroupeEtudiantDetail element = new GroupeEtudiantDetail();
                                                element.setId((long)id);
                                                element.setGroupeEtudiant(new GroupeEtudiant(Long.valueOf(1)));
                                                element.setEtudiant(new Etudiant(Long.valueOf(2)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setGroupeEtudiantDetails(groupeEtudiantDetails);
        given.setGroupeEtude(new GroupeEtude(1L));
        given.setGroupeType(new GroupeType(1L));
        given.setGroupeEtat(new GroupeEtat(1L));
        given.setParcours(new Parcours(1L));
        given.setProf(new Prof(1L));
        return given;
    }

}
