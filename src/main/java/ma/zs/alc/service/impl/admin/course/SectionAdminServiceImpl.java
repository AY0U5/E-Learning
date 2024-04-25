package ma.zs.alc.service.impl.admin.course;


import ma.zs.alc.bean.core.course.Section;
import ma.zs.alc.dao.criteria.core.course.SectionCriteria;
import ma.zs.alc.dao.facade.core.course.SectionDao;
import ma.zs.alc.dao.specification.core.course.SectionSpecification;
import ma.zs.alc.service.facade.admin.course.SectionAdminService;
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
import ma.zs.alc.service.facade.admin.course.CoursAdminService ;
import ma.zs.alc.bean.core.course.Cours ;
import ma.zs.alc.service.facade.admin.course.SectionItemAdminService ;
import ma.zs.alc.bean.core.course.SectionItem ;

import java.util.List;
@Service
public class SectionAdminServiceImpl extends AbstractServiceImpl<Section, SectionCriteria, SectionDao> implements SectionAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Section create(Section t) {
        Section saved= super.create(t);
        if (saved != null && t.getSectionItems() != null) {
                t.getSectionItems().forEach(element-> {
                    element.setSection(saved);
                    sectionItemService.create(element);
            });
        }
        return saved;

    }

    public Section findWithAssociatedLists(Long id){
        Section result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setSectionItems(sectionItemService.findBySectionId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        sectionItemService.deleteBySectionId(id);
    }


    public void updateWithAssociatedLists(Section section){
    if(section !=null && section.getId() != null){
            List<List<SectionItem>> resultSectionItems= sectionItemService.getToBeSavedAndToBeDeleted(sectionItemService.findBySectionId(section.getId()),section.getSectionItems());
            sectionItemService.delete(resultSectionItems.get(1));
            ListUtil.emptyIfNull(resultSectionItems.get(0)).forEach(e -> e.setSection(section));
            sectionItemService.update(resultSectionItems.get(0),true);
        }
    }




    public Section findByReferenceEntity(Section t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(Section t){
        if( t != null) {
            t.setCategorieSection(categorieSectionService.findOrSave(t.getCategorieSection()));
            t.setCours(coursService.findOrSave(t.getCours()));
        }
    }

    public List<Section> findByCategorieSectionId(Long id){
        return dao.findByCategorieSectionId(id);
    }
    public int deleteByCategorieSectionId(Long id){
        return dao.deleteByCategorieSectionId(id);
    }
    public long countByCategorieSectionCode(String code){
        return dao.countByCategorieSectionCode(code);
    }
    public List<Section> findByCoursId(Long id){
        return dao.findByCoursId(id);
    }
    public int deleteByCoursId(Long id){
        return dao.deleteByCoursId(id);
    }
    public long countByCoursCode(String code){
        return dao.countByCoursCode(code);
    }

    public List<Section> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Section.class, SectionSpecification.class);
    }


    @Autowired
    private CategorieSectionAdminService categorieSectionService ;
    @Autowired
    private CoursAdminService coursService ;
    @Autowired
    private SectionItemAdminService sectionItemService ;

    public SectionAdminServiceImpl(SectionDao dao) {
        super(dao);
    }

}
