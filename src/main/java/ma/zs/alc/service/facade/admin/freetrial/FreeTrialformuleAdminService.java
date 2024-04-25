package ma.zs.alc.service.facade.admin.freetrial;

import java.util.List;
import ma.zs.alc.bean.core.freetrial.FreeTrialformule;
import ma.zs.alc.dao.criteria.core.freetrial.FreeTrialformuleCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface FreeTrialformuleAdminService extends  IService<FreeTrialformule,FreeTrialformuleCriteria>  {

    List<FreeTrialformule> findByInscriptionId(Long id);
    int deleteByInscriptionId(Long id);
    long countByInscriptionId(Long id);




}
