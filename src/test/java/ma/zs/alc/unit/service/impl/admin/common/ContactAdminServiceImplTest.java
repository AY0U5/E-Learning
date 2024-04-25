package ma.zs.alc.unit.service.impl.admin.common;

import ma.zs.alc.bean.core.common.Contact;
import ma.zs.alc.dao.facade.core.common.ContactDao;
import ma.zs.alc.service.impl.admin.common.ContactAdminServiceImpl;

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
class ContactAdminServiceImplTest {

    @Mock
    private ContactDao repository;
    private AutoCloseable autoCloseable;
    private ContactAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ContactAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllContact() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveContact() {
        // Given
        Contact toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteContact() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetContactById() {
        // Given
        Long idToRetrieve = 1L; // Example Contact ID to retrieve
        Contact expected = new Contact(); // You need to replace Contact with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Contact result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Contact constructSample(int i) {
		Contact given = new Contact();
        given.setName("name-"+i);
        given.setEmail("email-"+i);
        given.setPhone("phone-"+i);
        given.setSetFrom("setFrom-"+i);
        given.setDateContact(LocalDateTime.now());
        given.setReplied(false);
        given.setMessage("message-"+i);
        return given;
    }

}
