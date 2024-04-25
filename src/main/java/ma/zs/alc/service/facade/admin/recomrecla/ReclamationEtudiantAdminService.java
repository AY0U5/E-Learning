package ma.zs.alc.service.facade.admin.recomrecla;

import java.util.List;
import ma.zs.alc.bean.core.recomrecla.ReclamationEtudiant;
import ma.zs.alc.dao.criteria.core.recomrecla.ReclamationEtudiantCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface ReclamationEtudiantAdminService extends  IService<ReclamationEtudiant,ReclamationEtudiantCriteria>  {

    List<ReclamationEtudiant> findByTypeReclamationEtudiantId(Long id);
    int deleteByTypeReclamationEtudiantId(Long id);
    long countByTypeReclamationEtudiantCode(String code);




}
