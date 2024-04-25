package ma.zs.alc.unit.dao.facade.core.common;

import ma.zs.alc.bean.core.common.Contact;
import ma.zs.alc.dao.facade.core.common.ContactDao;

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
public class ContactDaoTest {

@Autowired
    private ContactDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        Contact entity = new Contact();
        entity.setId(id);
        underTest.save(entity);
        Contact loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Contact entity = new Contact();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Contact loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Contact> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Contact> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Contact given = constructSample(1);
        Contact saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
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
