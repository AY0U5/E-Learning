package ma.zs.alc.service.facade.admin.quiz;

import java.util.List;
import ma.zs.alc.bean.core.quiz.Reponse;
import ma.zs.alc.dao.criteria.core.quiz.ReponseCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface ReponseAdminService extends  IService<Reponse,ReponseCriteria>  {

    Reponse saverep(Reponse reponse);

    Reponse findByLib(String lib);

    int deleteByLib(String lib);

    List<Reponse> findByQuestionId(Long id);
    int deleteByQuestionId(Long id);
    long countByQuestionLibelle(String libelle);




}
