package ma.zs.alc.service.facade.admin.learning;

import java.util.List;
import ma.zs.alc.bean.core.learning.SessionCours;
import ma.zs.alc.dao.criteria.core.learning.SessionCoursCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface SessionCoursAdminService extends  IService<SessionCours,SessionCoursCriteria>  {

    List<SessionCours> findByProfId(Long id);
    int deleteByProfId(Long id);
    long countByProfRef(String ref);
    List<SessionCours> findByCoursId(Long id);
    int deleteByCoursId(Long id);
    long countByCoursCode(String code);
    List<SessionCours> findByGroupeEtudiantId(Long id);
    int deleteByGroupeEtudiantId(Long id);
    long countByGroupeEtudiantId(Long id);
    List<SessionCours> findBySalaryId(Long id);
    int deleteBySalaryId(Long id);
    long countBySalaryCode(String code);




}
