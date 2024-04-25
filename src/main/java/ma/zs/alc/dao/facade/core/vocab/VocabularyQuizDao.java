package ma.zs.alc.dao.facade.core.vocab;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.vocab.VocabularyQuiz;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface VocabularyQuizDao extends AbstractRepository<VocabularyQuiz,Long>  {

    List<VocabularyQuiz> findBySectionId(Long id);
    int deleteBySectionId(Long id);
    long countBySectionCode(String code);

    @Query("SELECT NEW VocabularyQuiz(item.id,item.libelle) FROM VocabularyQuiz item")
    List<VocabularyQuiz> findAllOptimized();

}
