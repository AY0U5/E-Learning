package ma.zs.alc.service.facade.admin.quizetudiant;

import java.util.List;
import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant;
import ma.zs.alc.dao.criteria.core.quizetudiant.QuizEtudiantCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface QuizEtudiantAdminService extends  IService<QuizEtudiant,QuizEtudiantCriteria>  {

    List<QuizEtudiant> findByEtudiantId(Long id);
    int deleteByEtudiantId(Long id);
    long countByEtudiantRef(String ref);
    List<QuizEtudiant> findByQuizId(Long id);
    int deleteByQuizId(Long id);
    long countByQuizRef(String ref);




}
