package ma.zs.alc.unit.dao.facade.core.alc;

import ma.zs.alc.bean.core.alc.Admin;
import ma.zs.alc.dao.facade.core.alc.AdminDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class AdminDaoTest {

@Autowired
    private AdminDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        Admin entity = new Admin();
        entity.setId(id);
        underTest.save(entity);
        Admin loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Admin entity = new Admin();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Admin loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Admin> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Admin> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Admin given = constructSample(1);
        Admin saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
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
