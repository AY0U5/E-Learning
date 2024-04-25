package ma.zs.alc.unit.service.impl.admin.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.InviteStudent;
import ma.zs.alc.dao.facade.core.inscriptionref.InviteStudentDao;
import ma.zs.alc.service.impl.admin.inscriptionref.InviteStudentAdminServiceImpl;

import ma.zs.alc.bean.core.inscription.Etudiant ;
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
class InviteStudentAdminServiceImplTest {

    @Mock
    private InviteStudentDao repository;
    private AutoCloseable autoCloseable;
    private InviteStudentAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new InviteStudentAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllInviteStudent() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveInviteStudent() {
        // Given
        InviteStudent toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteInviteStudent() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetInviteStudentById() {
        // Given
        Long idToRetrieve = 1L; // Example InviteStudent ID to retrieve
        InviteStudent expected = new InviteStudent(); // You need to replace InviteStudent with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        InviteStudent result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private InviteStudent constructSample(int i) {
		InviteStudent given = new InviteStudent();
        given.setCode("code-"+i);
        given.setEtudiant(new Etudiant(1L));
        given.setIsAccepted(false);
        given.setIsPaidPack(false);
        given.setEmailInvited("emailInvited-"+i);
        given.setDateSentInvitation(LocalDateTime.now());
        given.setDateAcceptInvitation(LocalDateTime.now());
        given.setDatePayPack(LocalDateTime.now());
        return given;
    }

}
