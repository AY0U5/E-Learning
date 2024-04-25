package ma.zs.alc.dao.facade.core.vocab;

import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.vocab.Vocabulary;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface VocabularyDao extends AbstractRepository<Vocabulary,Long>  {

    List<Vocabulary> findBySectionId(Long id);
    int deleteBySectionId(Long id);
    long countBySectionCode(String code);
    List<Vocabulary> findByVocabularyQuizId(Long id);
    int deleteByVocabularyQuizId(Long id);
    long countByVocabularyQuizId(Long id);


}
