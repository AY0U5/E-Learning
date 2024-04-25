package ma.zs.alc.service.facade.admin.course;

import java.util.List;
import ma.zs.alc.bean.core.course.Section;
import ma.zs.alc.dao.criteria.core.course.SectionCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface SectionAdminService extends  IService<Section,SectionCriteria>  {

    List<Section> findByCategorieSectionId(Long id);
    int deleteByCategorieSectionId(Long id);
    long countByCategorieSectionCode(String code);
    List<Section> findByCoursId(Long id);
    int deleteByCoursId(Long id);
    long countByCoursCode(String code);




}
