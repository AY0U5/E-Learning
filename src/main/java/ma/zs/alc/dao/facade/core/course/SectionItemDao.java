package ma.zs.alc.dao.facade.core.course;

import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.course.SectionItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface SectionItemDao extends AbstractRepository<SectionItem,Long>  {

    List<SectionItem> findBySectionId(Long id);
    int deleteBySectionId(Long id);
    long countBySectionCode(String code);


}
