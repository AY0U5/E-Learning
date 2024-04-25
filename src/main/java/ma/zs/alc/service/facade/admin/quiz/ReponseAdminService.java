package ma.zs.alc.service.facade.admin.quiz;

import java.util.List;
import ma.zs.alc.bean.core.quiz.Reponse;
import ma.zs.alc.dao.criteria.core.quiz.ReponseCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface ReponseAdminService extends  IService<Reponse,ReponseCriteria>  {

    List<Reponse> findByQuestionId(Long id);
    int deleteByQuestionId(Long id);
    long countByQuestionLibelle(String libelle);




}
