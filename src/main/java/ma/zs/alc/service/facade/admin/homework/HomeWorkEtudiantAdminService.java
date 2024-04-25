package ma.zs.alc.service.facade.admin.homework;

import java.util.List;
import ma.zs.alc.bean.core.homework.HomeWorkEtudiant;
import ma.zs.alc.dao.criteria.core.homework.HomeWorkEtudiantCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface HomeWorkEtudiantAdminService extends  IService<HomeWorkEtudiant,HomeWorkEtudiantCriteria>  {

    List<HomeWorkEtudiant> findByEtudiantId(Long id);
    int deleteByEtudiantId(Long id);
    long countByEtudiantRef(String ref);
    List<HomeWorkEtudiant> findByHomeWorkId(Long id);
    int deleteByHomeWorkId(Long id);
    long countByHomeWorkId(Long id);




}
