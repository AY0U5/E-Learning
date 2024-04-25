package ma.zs.alc.unit.service.impl.admin.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.EtudiantClassRoom;
import ma.zs.alc.dao.facade.core.inscriptionref.EtudiantClassRoomDao;
import ma.zs.alc.service.impl.admin.inscriptionref.EtudiantClassRoomAdminServiceImpl;

import ma.zs.alc.bean.core.inscription.Etudiant ;
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
class EtudiantClassRoomAdminServiceImplTest {

    @Mock
    private EtudiantClassRoomDao repository;
    private AutoCloseable autoCloseable;
    private EtudiantClassRoomAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new EtudiantClassRoomAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllEtudiantClassRoom() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveEtudiantClassRoom() {
        // Given
        EtudiantClassRoom toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteEtudiantClassRoom() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetEtudiantClassRoomById() {
        // Given
        Long idToRetrieve = 1L; // Example EtudiantClassRoom ID to retrieve
        EtudiantClassRoom expected = new EtudiantClassRoom(); // You need to replace EtudiantClassRoom with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        EtudiantClassRoom result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private EtudiantClassRoom constructSample(int i) {
		EtudiantClassRoom given = new EtudiantClassRoom();
        given.setClassRoom(new ClassRoom(1L));
        given.setEtudiant(new Etudiant(1L));
        return given;
    }

}
