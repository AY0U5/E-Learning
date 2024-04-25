package ma.zs.alc.service.facade.admin.prof;

import java.util.List;
import ma.zs.alc.bean.core.prof.CalendrierProf;
import ma.zs.alc.dao.criteria.core.prof.CalendrierProfCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface CalendrierProfAdminService extends  IService<CalendrierProf,CalendrierProfCriteria>  {

    List<CalendrierProf> findByProfId(Long id);
    int deleteByProfId(Long id);
    long countByProfRef(String ref);
    List<CalendrierProf> findByEtudiantId(Long id);
    int deleteByEtudiantId(Long id);
    long countByEtudiantRef(String ref);




}
