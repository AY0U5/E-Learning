package ma.zs.alc.service.facade.admin.inscriptionref;

import java.util.List;
import ma.zs.alc.bean.core.inscriptionref.InviteStudent;
import ma.zs.alc.dao.criteria.core.inscriptionref.InviteStudentCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface InviteStudentAdminService extends  IService<InviteStudent,InviteStudentCriteria>  {

    List<InviteStudent> findByEtudiantId(Long id);
    int deleteByEtudiantId(Long id);
    long countByEtudiantRef(String ref);




}
