package ma.zs.alc.service.facade.admin.quizetudiant;

import java.util.List;
import ma.zs.alc.bean.core.quizetudiant.ReponseEtudiant;
import ma.zs.alc.dao.criteria.core.quizetudiant.ReponseEtudiantCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface ReponseEtudiantAdminService extends  IService<ReponseEtudiant,ReponseEtudiantCriteria>  {

    List<ReponseEtudiant> findByReponseId(Long id);
    int deleteByReponseId(Long id);
    long countByReponseRef(String ref);
    List<ReponseEtudiant> findByQuizEtudiantId(Long id);
    int deleteByQuizEtudiantId(Long id);
    long countByQuizEtudiantRef(String ref);
    List<ReponseEtudiant> findByQuestionId(Long id);
    int deleteByQuestionId(Long id);
    long countByQuestionLibelle(String libelle);




}
