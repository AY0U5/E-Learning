package ma.zs.alc.service.impl.admin.quiz;


import ma.zs.alc.bean.core.quiz.Quiz;
import ma.zs.alc.dao.criteria.core.quiz.QuizCriteria;
import ma.zs.alc.dao.facade.core.quiz.QuizDao;
import ma.zs.alc.dao.specification.core.quiz.QuizSpecification;
import ma.zs.alc.service.facade.admin.quiz.QuizAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.alc.service.facade.admin.quizetudiant.QuizEtudiantAdminService ;
import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant ;
import ma.zs.alc.service.facade.admin.quiz.QuestionAdminService ;
import ma.zs.alc.bean.core.quiz.Question ;
import ma.zs.alc.service.facade.admin.course.SectionAdminService ;
import ma.zs.alc.bean.core.course.Section ;

import java.util.List;
@Service
public class QuizAdminServiceImpl extends AbstractServiceImpl<Quiz, QuizCriteria, QuizDao> implements QuizAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Quiz create(Quiz t) {
        Quiz saved= super.create(t);
        if (saved != null && t.getQuestions() != null) {
                t.getQuestions().forEach(element-> {
                    element.setQuiz(saved);
                    questionService.create(element);
            });
        }
        if (saved != null && t.getQuizEtudiants() != null) {
                t.getQuizEtudiants().forEach(element-> {
                    element.setQuiz(saved);
                    quizEtudiantService.create(element);
            });
        }
        return saved;

    }

    public Quiz findWithAssociatedLists(Long id){
        Quiz result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setQuestions(questionService.findByQuizId(id));
            result.setQuizEtudiants(quizEtudiantService.findByQuizId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        questionService.deleteByQuizId(id);
        quizEtudiantService.deleteByQuizId(id);
    }


    public void updateWithAssociatedLists(Quiz quiz){
    if(quiz !=null && quiz.getId() != null){
            List<List<Question>> resultQuestions= questionService.getToBeSavedAndToBeDeleted(questionService.findByQuizId(quiz.getId()),quiz.getQuestions());
            questionService.delete(resultQuestions.get(1));
            ListUtil.emptyIfNull(resultQuestions.get(0)).forEach(e -> e.setQuiz(quiz));
            questionService.update(resultQuestions.get(0),true);
            List<List<QuizEtudiant>> resultQuizEtudiants= quizEtudiantService.getToBeSavedAndToBeDeleted(quizEtudiantService.findByQuizId(quiz.getId()),quiz.getQuizEtudiants());
            quizEtudiantService.delete(resultQuizEtudiants.get(1));
            ListUtil.emptyIfNull(resultQuizEtudiants.get(0)).forEach(e -> e.setQuiz(quiz));
            quizEtudiantService.update(resultQuizEtudiants.get(0),true);
        }
    }




    public Quiz findByReferenceEntity(Quiz t){
        return t==null? null : dao.findByRef(t.getRef());
    }
    public void findOrSaveAssociatedObject(Quiz t){
        if( t != null) {
            t.setSection(sectionService.findOrSave(t.getSection()));
        }
    }

    public List<Quiz> findBySectionId(Long id){
        return dao.findBySectionId(id);
    }
    public int deleteBySectionId(Long id){
        return dao.deleteBySectionId(id);
    }
    public long countBySectionCode(String code){
        return dao.countBySectionCode(code);
    }

    public List<Quiz> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Quiz.class, QuizSpecification.class);
    }


    @Autowired
    private QuizEtudiantAdminService quizEtudiantService ;
    @Autowired
    private QuestionAdminService questionService ;
    @Autowired
    private SectionAdminService sectionService ;

    public QuizAdminServiceImpl(QuizDao dao) {
        super(dao);
    }

}
