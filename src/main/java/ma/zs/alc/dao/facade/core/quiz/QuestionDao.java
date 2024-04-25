package ma.zs.alc.dao.facade.core.quiz;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.quiz.Question;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.quiz.Question;
import java.util.List;


@Repository
public interface QuestionDao extends AbstractRepository<Question,Long>  {
    Question findByLibelle(String libelle);
    int deleteByLibelle(String libelle);

    List<Question> findByTypeDeQuestionId(Long id);
    int deleteByTypeDeQuestionId(Long id);
    long countByTypeDeQuestionRef(String ref);
    List<Question> findByQuizId(Long id);
    int deleteByQuizId(Long id);
    long countByQuizRef(String ref);
    List<Question> findByHomeWorkId(Long id);
    int deleteByHomeWorkId(Long id);
    long countByHomeWorkId(Long id);

    @Query("SELECT NEW Question(item.id,item.libelle) FROM Question item")
    List<Question> findAllOptimized();

}
