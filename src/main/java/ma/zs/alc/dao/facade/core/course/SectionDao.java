package ma.zs.alc.dao.facade.core.course;

import ma.zs.alc.bean.core.course.Cours;
import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.course.Section;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.course.Section;
import java.util.List;


@Repository
public interface SectionDao extends AbstractRepository<Section,Long>  {

    List<Section> findByEtatSectionId(Long id);
    int deleteByEtatSectionId(Long id);
    long countByEtatSectionCode(String code);
    Section findByCode(String code);
    int deleteByCode(String code);

    List<Section> findByCategorieSectionId(Long id);
    int deleteByCategorieSectionId(Long id);
    long countByCategorieSectionCode(String code);
    List<Section> findByCoursId(Long id);
    int deleteByCoursId(Long id);
    long countByCoursCode(String code);

    @Query("SELECT NEW Section(item.id,item.code) FROM Section item")
    List<Section> findAllOptimized();

}
