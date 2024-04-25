package ma.zs.alc.service.facade.admin.course;

import java.util.List;
import ma.zs.alc.bean.core.course.SectionItem;
import ma.zs.alc.dao.criteria.core.course.SectionItemCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface SectionItemAdminService extends  IService<SectionItem,SectionItemCriteria>  {

    List<SectionItem> findBySectionId(Long id);
    int deleteBySectionId(Long id);
    long countBySectionCode(String code);




}
