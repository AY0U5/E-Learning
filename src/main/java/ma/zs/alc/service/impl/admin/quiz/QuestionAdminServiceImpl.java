package ma.zs.alc.service.impl.admin.quiz;


import ma.zs.alc.bean.core.quiz.Question;
import ma.zs.alc.dao.criteria.core.quiz.QuestionCriteria;
import ma.zs.alc.dao.facade.core.quiz.QuestionDao;
import ma.zs.alc.dao.specification.core.quiz.QuestionSpecification;
import ma.zs.alc.service.facade.admin.quiz.QuestionAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.alc.service.facade.admin.quiz.QuizAdminService ;
import ma.zs.alc.bean.core.quiz.Quiz ;
import ma.zs.alc.service.facade.admin.quizref.TypeDeQuestionAdminService ;
import ma.zs.alc.bean.core.quizref.TypeDeQuestion ;
import ma.zs.alc.service.facade.admin.quiz.ReponseAdminService ;
import ma.zs.alc.bean.core.quiz.Reponse ;
import ma.zs.alc.service.facade.admin.homework.HomeWorkAdminService ;
import ma.zs.alc.bean.core.homework.HomeWork ;

import java.util.List;
@Service
public class QuestionAdminServiceImpl extends AbstractServiceImpl<Question, QuestionCriteria, QuestionDao> implements QuestionAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Question create(Question t) {
        Question saved= super.create(t);
        if (saved != null && t.getReponses() != null) {
                t.getReponses().forEach(element-> {
                    element.setQuestion(saved);
                    reponseService.create(element);
            });
        }
        return saved;

    }

    public Question findWithAssociatedLists(Long id){
        Question result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setReponses(reponseService.findByQuestionId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        reponseService.deleteByQuestionId(id);
    }


    public void updateWithAssociatedLists(Question question){
    if(question !=null && question.getId() != null){
            List<List<Reponse>> resultReponses= reponseService.getToBeSavedAndToBeDeleted(reponseService.findByQuestionId(question.getId()),question.getReponses());
            reponseService.delete(resultReponses.get(1));
            ListUtil.emptyIfNull(resultReponses.get(0)).forEach(e -> e.setQuestion(question));
            reponseService.update(resultReponses.get(0),true);
        }
    }




    public Question findByReferenceEntity(Question t){
        return t==null? null : dao.findByLibelle(t.getLibelle());
    }
    public void findOrSaveAssociatedObject(Question t){
        if( t != null) {
            t.setTypeDeQuestion(typeDeQuestionService.findOrSave(t.getTypeDeQuestion()));
            t.setQuiz(quizService.findOrSave(t.getQuiz()));
            t.setHomeWork(homeWorkService.findOrSave(t.getHomeWork()));
        }
    }

    public List<Question> findByTypeDeQuestionId(Long id){
        return dao.findByTypeDeQuestionId(id);
    }
    public int deleteByTypeDeQuestionId(Long id){
        return dao.deleteByTypeDeQuestionId(id);
    }
    public long countByTypeDeQuestionRef(String ref){
        return dao.countByTypeDeQuestionRef(ref);
    }
    public List<Question> findByQuizId(Long id){
        return dao.findByQuizId(id);
    }
    public int deleteByQuizId(Long id){
        return dao.deleteByQuizId(id);
    }
    public long countByQuizRef(String ref){
        return dao.countByQuizRef(ref);
    }
    public List<Question> findByHomeWorkId(Long id){
        return dao.findByHomeWorkId(id);
    }
    public int deleteByHomeWorkId(Long id){
        return dao.deleteByHomeWorkId(id);
    }
    public long countByHomeWorkId(Long id){
        return dao.countByHomeWorkId(id);
    }

    public List<Question> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Question.class, QuestionSpecification.class);
    }


    @Autowired
    private QuizAdminService quizService ;
    @Autowired
    private TypeDeQuestionAdminService typeDeQuestionService ;
    @Autowired
    private ReponseAdminService reponseService ;
    @Autowired
    private HomeWorkAdminService homeWorkService ;

    public QuestionAdminServiceImpl(QuestionDao dao) {
        super(dao);
    }

}
