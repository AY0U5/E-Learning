package ma.zs.alc.service.impl.admin.quizetudiant;


import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant;
import ma.zs.alc.dao.criteria.core.quizetudiant.QuizEtudiantCriteria;
import ma.zs.alc.dao.facade.core.quizetudiant.QuizEtudiantDao;
import ma.zs.alc.dao.specification.core.quizetudiant.QuizEtudiantSpecification;
import ma.zs.alc.service.facade.admin.quizetudiant.QuizEtudiantAdminService;
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
import ma.zs.alc.service.facade.admin.inscription.EtudiantAdminService ;
import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.service.facade.admin.quizetudiant.ReponseEtudiantAdminService ;
import ma.zs.alc.bean.core.quizetudiant.ReponseEtudiant ;

import java.util.List;
@Service
public class QuizEtudiantAdminServiceImpl extends AbstractServiceImpl<QuizEtudiant, QuizEtudiantCriteria, QuizEtudiantDao> implements QuizEtudiantAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public QuizEtudiant create(QuizEtudiant t) {
        QuizEtudiant saved= super.create(t);
        if (saved != null && t.getReponseEtudiants() != null) {
                t.getReponseEtudiants().forEach(element-> {
                    element.setQuizEtudiant(saved);
                    reponseEtudiantService.create(element);
            });
        }
        return saved;

    }

    public QuizEtudiant findWithAssociatedLists(Long id){
        QuizEtudiant result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setReponseEtudiants(reponseEtudiantService.findByQuizEtudiantId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        reponseEtudiantService.deleteByQuizEtudiantId(id);
    }


    public void updateWithAssociatedLists(QuizEtudiant quizEtudiant){
    if(quizEtudiant !=null && quizEtudiant.getId() != null){
            List<List<ReponseEtudiant>> resultReponseEtudiants= reponseEtudiantService.getToBeSavedAndToBeDeleted(reponseEtudiantService.findByQuizEtudiantId(quizEtudiant.getId()),quizEtudiant.getReponseEtudiants());
            reponseEtudiantService.delete(resultReponseEtudiants.get(1));
            ListUtil.emptyIfNull(resultReponseEtudiants.get(0)).forEach(e -> e.setQuizEtudiant(quizEtudiant));
            reponseEtudiantService.update(resultReponseEtudiants.get(0),true);
        }
    }




    public QuizEtudiant findByReferenceEntity(QuizEtudiant t){
        return t==null? null : dao.findByRef(t.getRef());
    }
    public void findOrSaveAssociatedObject(QuizEtudiant t){
        if( t != null) {
            t.setEtudiant(etudiantService.findOrSave(t.getEtudiant()));
            t.setQuiz(quizService.findOrSave(t.getQuiz()));
        }
    }

    public List<QuizEtudiant> findByEtudiantId(Long id){
        return dao.findByEtudiantId(id);
    }
    public int deleteByEtudiantId(Long id){
        return dao.deleteByEtudiantId(id);
    }
    public long countByEtudiantRef(String ref){
        return dao.countByEtudiantRef(ref);
    }
    public List<QuizEtudiant> findByQuizId(Long id){
        return dao.findByQuizId(id);
    }
    public int deleteByQuizId(Long id){
        return dao.deleteByQuizId(id);
    }
    public long countByQuizRef(String ref){
        return dao.countByQuizRef(ref);
    }

    public List<QuizEtudiant> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(QuizEtudiant.class, QuizEtudiantSpecification.class);
    }


    @Autowired
    private QuizAdminService quizService ;
    @Autowired
    private EtudiantAdminService etudiantService ;
    @Autowired
    private ReponseEtudiantAdminService reponseEtudiantService ;

    public QuizEtudiantAdminServiceImpl(QuizEtudiantDao dao) {
        super(dao);
    }

}
