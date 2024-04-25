package ma.zs.alc.service.facade.admin.recomrecla;

import java.util.List;
import ma.zs.alc.bean.core.recomrecla.ReclamationProf;
import ma.zs.alc.dao.criteria.core.recomrecla.ReclamationProfCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface ReclamationProfAdminService extends  IService<ReclamationProf,ReclamationProfCriteria>  {

    List<ReclamationProf> findByAdminId(Long id);
    int deleteByAdminId(Long id);
    long countByAdminId(Long id);
    List<ReclamationProf> findByProfId(Long id);
    int deleteByProfId(Long id);
    long countByProfRef(String ref);
    List<ReclamationProf> findByTypeReclamationProfId(Long id);
    int deleteByTypeReclamationProfId(Long id);
    long countByTypeReclamationProfCode(String code);




}
