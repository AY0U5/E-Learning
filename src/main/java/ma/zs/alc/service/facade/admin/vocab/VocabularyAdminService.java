package ma.zs.alc.service.facade.admin.vocab;

import java.util.List;
import ma.zs.alc.bean.core.vocab.Vocabulary;
import ma.zs.alc.dao.criteria.core.vocab.VocabularyCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface VocabularyAdminService extends  IService<Vocabulary,VocabularyCriteria>  {

    List<Vocabulary> findBySectionId(Long id);
    int deleteBySectionId(Long id);
    long countBySectionCode(String code);
    List<Vocabulary> findByVocabularyQuizId(Long id);
    int deleteByVocabularyQuizId(Long id);
    long countByVocabularyQuizId(Long id);




}
