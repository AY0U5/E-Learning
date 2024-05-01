package ma.zs.alc.service.impl.admin.courseref;


import ma.zs.alc.bean.core.courseref.CategorieSection;
import ma.zs.alc.dao.criteria.core.courseref.CategorieSectionCriteria;
import ma.zs.alc.dao.facade.core.courseref.CategorieSectionDao;
import ma.zs.alc.dao.specification.core.courseref.CategorieSectionSpecification;
import ma.zs.alc.service.facade.admin.courseref.CategorieSectionAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.alc.service.facade.admin.course.SectionAdminService ;
import ma.zs.alc.bean.core.course.Section ;
import ma.zs.alc.service.facade.admin.courseref.SuperCategorieSectionAdminService ;
import ma.zs.alc.bean.core.courseref.SuperCategorieSection ;

import java.util.List;
@Service
public class CategorieSectionAdminServiceImpl extends AbstractServiceImpl<CategorieSection, CategorieSectionCriteria, CategorieSectionDao> implements CategorieSectionAdminService {



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public CategorieSection create(CategorieSection t) {
        CategorieSection saved= super.create(t);
        if (saved != null && t.getSections() != null) {
                t.getSections().forEach(element-> {
                    element.setCategorieSection(saved);
                    sectionService.create(element);
            });
        }
        return saved;

    }

    public CategorieSection findWithAssociatedLists(Long id){
        CategorieSection result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setSections(sectionService.findByCategorieSectionId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        sectionService.deleteByCategorieSectionId(id);
    }


    public void updateWithAssociatedLists(CategorieSection categorieSection){
    if(categorieSection !=null && categorieSection.getId() != null){
            List<List<Section>> resultSections= sectionService.getToBeSavedAndToBeDeleted(sectionService.findByCategorieSectionId(categorieSection.getId()),categorieSection.getSections());
            sectionService.delete(resultSections.get(1));
            ListUtil.emptyIfNull(resultSections.get(0)).forEach(e -> e.setCategorieSection(categorieSection));
            sectionService.update(resultSections.get(0),true);
        }
    }




    public CategorieSection findByReferenceEntity(CategorieSection t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(CategorieSection t){
        if( t != null) {
            t.setSuperCategorieSection(superCategorieSectionService.findOrSave(t.getSuperCategorieSection()));
        }
    }

    public List<CategorieSection> findBySuperCategorieSectionId(Long id){
        return dao.findBySuperCategorieSectionId(id);
    }
    public int deleteBySuperCategorieSectionId(Long id){
        return dao.deleteBySuperCategorieSectionId(id);
    }
    public long countBySuperCategorieSectionCode(String code){
        return dao.countBySuperCategorieSectionCode(code);
    }

    public List<CategorieSection> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(CategorieSection.class, CategorieSectionSpecification.class);
    }


    @Autowired
    private SectionAdminService sectionService ;
    @Autowired
    private SuperCategorieSectionAdminService superCategorieSectionService ;

    public CategorieSectionAdminServiceImpl(CategorieSectionDao dao) {
        super(dao);
    }

}
