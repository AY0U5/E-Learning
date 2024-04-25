package ma.zs.alc.service.facade.admin.learning;

import java.util.List;
import ma.zs.alc.bean.core.learning.SessionCoursSection;
import ma.zs.alc.dao.criteria.core.learning.SessionCoursSectionCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface SessionCoursSectionAdminService extends  IService<SessionCoursSection,SessionCoursSectionCriteria>  {

    List<SessionCoursSection> findBySessionCoursId(Long id);
    int deleteBySessionCoursId(Long id);
    long countBySessionCoursReference(String reference);
    List<SessionCoursSection> findBySectionId(Long id);
    int deleteBySectionId(Long id);
    long countBySectionCode(String code);




}
