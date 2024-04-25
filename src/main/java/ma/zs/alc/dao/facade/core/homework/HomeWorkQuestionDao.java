package ma.zs.alc.dao.facade.core.homework;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.homework.HomeWorkQuestion;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.homework.HomeWorkQuestion;
import java.util.List;


@Repository
public interface HomeWorkQuestionDao extends AbstractRepository<HomeWorkQuestion,Long>  {
    HomeWorkQuestion findByRef(String ref);
    int deleteByRef(String ref);

    List<HomeWorkQuestion> findByTypeDeQuestionId(Long id);
    int deleteByTypeDeQuestionId(Long id);
    long countByTypeDeQuestionRef(String ref);
    List<HomeWorkQuestion> findByHomeWorkId(Long id);
    int deleteByHomeWorkId(Long id);
    long countByHomeWorkId(Long id);

    @Query("SELECT NEW HomeWorkQuestion(item.id,item.libelle) FROM HomeWorkQuestion item")
    List<HomeWorkQuestion> findAllOptimized();

}
