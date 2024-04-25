package ma.zs.alc.service.impl.admin.quizetudiant;


import ma.zs.alc.bean.core.quizetudiant.ReponseEtudiant;
import ma.zs.alc.dao.criteria.core.quizetudiant.ReponseEtudiantCriteria;
import ma.zs.alc.dao.facade.core.quizetudiant.ReponseEtudiantDao;
import ma.zs.alc.dao.specification.core.quizetudiant.ReponseEtudiantSpecification;
import ma.zs.alc.service.facade.admin.quizetudiant.ReponseEtudiantAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.alc.service.facade.admin.quizetudiant.QuizEtudiantAdminService ;
import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant ;
import ma.zs.alc.service.facade.admin.quiz.QuestionAdminService ;
import ma.zs.alc.bean.core.quiz.Question ;
import ma.zs.alc.service.facade.admin.quiz.ReponseAdminService ;
import ma.zs.alc.bean.core.quiz.Reponse ;

import java.util.List;
@Service
public class ReponseEtudiantAdminServiceImpl extends AbstractServiceImpl<ReponseEtudiant, ReponseEtudiantCriteria, ReponseEtudiantDao> implements ReponseEtudiantAdminService {






    public ReponseEtudiant findByReferenceEntity(ReponseEtudiant t){
        return t==null? null : dao.findByRef(t.getRef());
    }
    public void findOrSaveAssociatedObject(ReponseEtudiant t){
        if( t != null) {
            t.setReponse(reponseService.findOrSave(t.getReponse()));
            t.setQuizEtudiant(quizEtudiantService.findOrSave(t.getQuizEtudiant()));
            t.setQuestion(questionService.findOrSave(t.getQuestion()));
        }
    }

    public List<ReponseEtudiant> findByReponseId(Long id){
        return dao.findByReponseId(id);
    }
    public int deleteByReponseId(Long id){
        return dao.deleteByReponseId(id);
    }
    public long countByReponseRef(String ref){
        return dao.countByReponseRef(ref);
    }
    public List<ReponseEtudiant> findByQuizEtudiantId(Long id){
        return dao.findByQuizEtudiantId(id);
    }
    public int deleteByQuizEtudiantId(Long id){
        return dao.deleteByQuizEtudiantId(id);
    }
    public long countByQuizEtudiantRef(String ref){
        return dao.countByQuizEtudiantRef(ref);
    }
    public List<ReponseEtudiant> findByQuestionId(Long id){
        return dao.findByQuestionId(id);
    }
    public int deleteByQuestionId(Long id){
        return dao.deleteByQuestionId(id);
    }
    public long countByQuestionLibelle(String libelle){
        return dao.countByQuestionLibelle(libelle);
    }

    public List<ReponseEtudiant> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(ReponseEtudiant.class, ReponseEtudiantSpecification.class);
    }


    @Autowired
    private QuizEtudiantAdminService quizEtudiantService ;
    @Autowired
    private QuestionAdminService questionService ;
    @Autowired
    private ReponseAdminService reponseService ;

    public ReponseEtudiantAdminServiceImpl(ReponseEtudiantDao dao) {
        super(dao);
    }

}
