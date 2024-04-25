package ma.zs.alc.unit.dao.facade.core.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.InviteStudent;
import ma.zs.alc.dao.facade.core.inscriptionref.InviteStudentDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.inscription.Etudiant ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class InviteStudentDaoTest {

@Autowired
    private InviteStudentDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        InviteStudent entity = new InviteStudent();
        entity.setCode(code);
        underTest.save(entity);
        InviteStudent loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        InviteStudent entity = new InviteStudent();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        InviteStudent loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        InviteStudent entity = new InviteStudent();
        entity.setId(id);
        underTest.save(entity);
        InviteStudent loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        InviteStudent entity = new InviteStudent();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        InviteStudent loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<InviteStudent> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<InviteStudent> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        InviteStudent given = constructSample(1);
        InviteStudent saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
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
