package ma.zs.alc.service.impl.admin.courseref;


import ma.zs.alc.bean.core.courseref.SuperCategorieSection;
import ma.zs.alc.dao.criteria.core.courseref.SuperCategorieSectionCriteria;
import ma.zs.alc.dao.facade.core.courseref.SuperCategorieSectionDao;
import ma.zs.alc.dao.specification.core.courseref.SuperCategorieSectionSpecification;
import ma.zs.alc.service.facade.admin.courseref.SuperCategorieSectionAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.alc.service.facade.admin.courseref.CategorieSectionAdminService ;
import ma.zs.alc.bean.core.courseref.CategorieSection ;

import java.util.List;
@Service
public class SuperCategorieSectionAdminServiceImpl extends AbstractServiceImpl<SuperCategorieSection, SuperCategorieSectionCriteria, SuperCategorieSectionDao> implements SuperCategorieSectionAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public SuperCategorieSection create(SuperCategorieSection t) {
        SuperCategorieSection saved= super.create(t);
        if (saved != null && t.getCategorieSections() != null) {
                t.getCategorieSections().forEach(element-> {
                    element.setSuperCategorieSection(saved);
                    categorieSectionService.create(element);
            });
        }
        return saved;

    }

    public SuperCategorieSection findWithAssociatedLists(Long id){
        SuperCategorieSection result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setCategorieSections(categorieSectionService.findBySuperCategorieSectionId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        categorieSectionService.deleteBySuperCategorieSectionId(id);
    }


    public void updateWithAssociatedLists(SuperCategorieSection superCategorieSection){
    if(superCategorieSection !=null && superCategorieSection.getId() != null){
            List<List<CategorieSection>> resultCategorieSections= categorieSectionService.getToBeSavedAndToBeDeleted(categorieSectionService.findBySuperCategorieSectionId(superCategorieSection.getId()),superCategorieSection.getCategorieSections());
            categorieSectionService.delete(resultCategorieSections.get(1));
            ListUtil.emptyIfNull(resultCategorieSections.get(0)).forEach(e -> e.setSuperCategorieSection(superCategorieSection));
            categorieSectionService.update(resultCategorieSections.get(0),true);
        }
    }




    public SuperCategorieSection findByReferenceEntity(SuperCategorieSection t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<SuperCategorieSection> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(SuperCategorieSection.class, SuperCategorieSectionSpecification.class);
    }


    @Autowired
    private CategorieSectionAdminService categorieSectionService ;

    public SuperCategorieSectionAdminServiceImpl(SuperCategorieSectionDao dao) {
        super(dao);
    }

}
