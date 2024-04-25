package ma.zs.alc.dao.facade.core.quizref;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.quizref.TypeDeQuestion;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.quizref.TypeDeQuestion;
import java.util.List;


@Repository
public interface TypeDeQuestionDao extends AbstractRepository<TypeDeQuestion,Long>  {
    TypeDeQuestion findByRef(String ref);
    int deleteByRef(String ref);


    @Query("SELECT NEW TypeDeQuestion(item.id,item.lib) FROM TypeDeQuestion item")
    List<TypeDeQuestion> findAllOptimized();

}
