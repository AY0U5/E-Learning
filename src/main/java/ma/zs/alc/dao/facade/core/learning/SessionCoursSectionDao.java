package ma.zs.alc.dao.facade.core.learning;

import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.learning.SessionCoursSection;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface SessionCoursSectionDao extends AbstractRepository<SessionCoursSection,Long>  {

    List<SessionCoursSection> findBySessionCoursId(Long id);
    int deleteBySessionCoursId(Long id);
    long countBySessionCoursReference(String reference);
    List<SessionCoursSection> findBySectionId(Long id);
    int deleteBySectionId(Long id);
    long countBySectionCode(String code);


}
