package ma.zs.alc.service.impl.admin.vocab;


import ma.zs.alc.bean.core.vocab.VocabularyQuiz;
import ma.zs.alc.dao.criteria.core.vocab.VocabularyQuizCriteria;
import ma.zs.alc.dao.facade.core.vocab.VocabularyQuizDao;
import ma.zs.alc.dao.specification.core.vocab.VocabularyQuizSpecification;
import ma.zs.alc.service.facade.admin.vocab.VocabularyQuizAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.alc.service.facade.admin.vocab.VocabularyAdminService ;
import ma.zs.alc.bean.core.vocab.Vocabulary ;
import ma.zs.alc.service.facade.admin.course.SectionAdminService ;
import ma.zs.alc.bean.core.course.Section ;

import java.util.List;
@Service
public class VocabularyQuizAdminServiceImpl extends AbstractServiceImpl<VocabularyQuiz, VocabularyQuizCriteria, VocabularyQuizDao> implements VocabularyQuizAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public VocabularyQuiz create(VocabularyQuiz t) {
        VocabularyQuiz saved= super.create(t);
        if (saved != null && t.getVocabularys() != null) {
                t.getVocabularys().forEach(element-> {
                    element.setVocabularyQuiz(saved);
                    vocabularyService.create(element);
            });
        }
        return saved;

    }

    public VocabularyQuiz findWithAssociatedLists(Long id){
        VocabularyQuiz result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setVocabularys(vocabularyService.findByVocabularyQuizId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        vocabularyService.deleteByVocabularyQuizId(id);
    }


    public void updateWithAssociatedLists(VocabularyQuiz vocabularyQuiz){
    if(vocabularyQuiz !=null && vocabularyQuiz.getId() != null){
            List<List<Vocabulary>> resultVocabularys= vocabularyService.getToBeSavedAndToBeDeleted(vocabularyService.findByVocabularyQuizId(vocabularyQuiz.getId()),vocabularyQuiz.getVocabularys());
            vocabularyService.delete(resultVocabularys.get(1));
            ListUtil.emptyIfNull(resultVocabularys.get(0)).forEach(e -> e.setVocabularyQuiz(vocabularyQuiz));
            vocabularyService.update(resultVocabularys.get(0),true);
        }
    }




    public void findOrSaveAssociatedObject(VocabularyQuiz t){
        if( t != null) {
            t.setSection(sectionService.findOrSave(t.getSection()));
        }
    }

    public List<VocabularyQuiz> findBySectionId(Long id){
        return dao.findBySectionId(id);
    }
    public int deleteBySectionId(Long id){
        return dao.deleteBySectionId(id);
    }
    public long countBySectionCode(String code){
        return dao.countBySectionCode(code);
    }

    public List<VocabularyQuiz> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(VocabularyQuiz.class, VocabularyQuizSpecification.class);
    }


    @Autowired
    private VocabularyAdminService vocabularyService ;
    @Autowired
    private SectionAdminService sectionService ;

    public VocabularyQuizAdminServiceImpl(VocabularyQuizDao dao) {
        super(dao);
    }

}
