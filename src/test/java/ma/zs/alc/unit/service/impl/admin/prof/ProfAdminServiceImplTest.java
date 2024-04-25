package ma.zs.alc.unit.service.impl.admin.prof;

import ma.zs.alc.bean.core.prof.Prof;
import ma.zs.alc.dao.facade.core.prof.ProfDao;
import ma.zs.alc.service.impl.admin.prof.ProfAdminServiceImpl;

import ma.zs.alc.bean.core.course.Parcours ;
import ma.zs.alc.bean.core.prof.TypeTeacher ;
import ma.zs.alc.bean.core.recomrecla.RecommendTeacher ;
import ma.zs.alc.bean.core.prof.CategorieProf ;
import ma.zs.alc.bean.core.prof.TrancheHoraireProf ;
import ma.zs.alc.bean.core.prof.Prof ;
import ma.zs.alc.bean.core.classroom.ClassRoom ;
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
class ProfAdminServiceImplTest {

    @Mock
    private ProfDao repository;
    private AutoCloseable autoCloseable;
    private ProfAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ProfAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllProf() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveProf() {
        // Given
        Prof toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteProf() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetProfById() {
        // Given
        Long idToRetrieve = 1L; // Example Prof ID to retrieve
        Prof expected = new Prof(); // You need to replace Prof with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Prof result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Prof constructSample(int i) {
		Prof given = new Prof();
        given.setRef("ref-"+i);
        given.setAbout("about-"+i);
        given.setParcours(new Parcours(1L));
        List<TrancheHoraireProf> trancheHoraireProfs = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                TrancheHoraireProf element = new TrancheHoraireProf();
                                                element.setId((long)id);
                                                element.setProf(new Prof(Long.valueOf(1)));
                                                element.setStartHour("startHour"+id);
                                                element.setEndHour("endHour"+id);
                                                element.setDay(4);
                                                element.setGroupIndex(5);
                                                element.setProfsId(6L);
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setTrancheHoraireProfs(trancheHoraireProfs);
        given.setCategorieProf(new CategorieProf(1L));
        List<ClassRoom> classRooms = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                ClassRoom element = new ClassRoom();
                                                element.setId((long)id);
                                                element.setLibelle("libelle"+id);
                                                element.setDescription("description"+id);
                                                element.setProf(new Prof(Long.valueOf(3)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setClassRooms(classRooms);
        List<RecommendTeacher> recommendTeachers = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                RecommendTeacher element = new RecommendTeacher();
                                                element.setId((long)id);
                                                element.setRef("ref"+id);
                                                element.setNombrevote(2);
                                                element.setNom("nom"+id);
                                                element.setPrenom("prenom"+id);
                                                element.setCommentaire("commentaire"+id);
                                                element.setTelephone("telephone"+id);
                                                element.setLogin("login"+id);
                                                element.setDateRecommamdation(LocalDateTime.now());
                                                element.setProf(new Prof(Long.valueOf(9)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setRecommendTeachers(recommendTeachers);
        given.setTypeTeacher(new TypeTeacher(1L));
        given.setCredentialsNonExpired(false);
        given.setEnabled(false);
        given.setAccountNonExpired(false);
        given.setAccountNonLocked(false);
        given.setPasswordChanged(false);
        given.setUsername("username-"+i);
        given.setPassword("password-"+i);
        return given;
    }

}
