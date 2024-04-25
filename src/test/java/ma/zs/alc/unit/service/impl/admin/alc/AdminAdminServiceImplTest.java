package ma.zs.alc.unit.service.impl.admin.alc;

import ma.zs.alc.bean.core.alc.Admin;
import ma.zs.alc.dao.facade.core.alc.AdminDao;
import ma.zs.alc.service.impl.admin.alc.AdminAdminServiceImpl;

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
class AdminAdminServiceImplTest {

    @Mock
    private AdminDao repository;
    private AutoCloseable autoCloseable;
    private AdminAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new AdminAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllAdmin() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveAdmin() {
        // Given
        Admin toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteAdmin() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetAdminById() {
        // Given
        Long idToRetrieve = 1L; // Example Admin ID to retrieve
        Admin expected = new Admin(); // You need to replace Admin with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Admin result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Admin constructSample(int i) {
		Admin given = new Admin();
        given.setDescription("description-"+i);
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
