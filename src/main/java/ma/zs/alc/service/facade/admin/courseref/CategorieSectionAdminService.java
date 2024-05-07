package ma.zs.alc.service.facade.admin.courseref;

import java.util.List;
import ma.zs.alc.bean.core.courseref.CategorieSection;
import ma.zs.alc.dao.criteria.core.courseref.CategorieSectionCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface CategorieSectionAdminService extends  IService<CategorieSection,CategorieSectionCriteria>  {

    List<CategorieSection> findBySuperCategorieSectionId(Long id);
    int deleteBySuperCategorieSectionId(Long id);
    long countBySuperCategorieSectionCode(String code);


    CategorieSection findByCode(String code);
}
