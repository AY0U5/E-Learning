package ma.zs.alc.service.facade.admin.vocab;

import java.util.List;
import ma.zs.alc.bean.core.vocab.VocabularyQuiz;
import ma.zs.alc.dao.criteria.core.vocab.VocabularyQuizCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface VocabularyQuizAdminService extends  IService<VocabularyQuiz,VocabularyQuizCriteria>  {

    List<VocabularyQuiz> findBySectionId(Long id);
    int deleteBySectionId(Long id);
    long countBySectionCode(String code);




}
