package ma.zs.alc.service.impl.admin.course;


import ma.zs.alc.bean.core.course.Section;
import ma.zs.alc.bean.core.courseref.CategorieSection;
import ma.zs.alc.bean.core.courseref.EtatSection;
import ma.zs.alc.dao.criteria.core.course.SectionCriteria;
import ma.zs.alc.dao.facade.core.course.CoursDao;
import ma.zs.alc.dao.facade.core.course.SectionDao;
import ma.zs.alc.dao.specification.core.course.SectionSpecification;
import ma.zs.alc.service.facade.admin.course.SectionAdminService;
import ma.zs.alc.service.facade.admin.courseref.EtatSectionAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.alc.service.facade.admin.courseref.CategorieSectionAdminService ;
import ma.zs.alc.service.facade.admin.course.CoursAdminService ;
import ma.zs.alc.bean.core.course.Cours ;
import ma.zs.alc.service.facade.admin.course.SectionItemAdminService ;
import ma.zs.alc.bean.core.course.SectionItem ;

@Service
public class SectionAdminServiceImpl extends AbstractServiceImpl<Section, SectionCriteria, SectionDao> implements SectionAdminService {

    private @Autowired SectionDao sectionDao;
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

    @Override
    public Section saveSection(Section section) {
        if (sectionDao.findByCode(section.getCode()) != null) {
            return null;
        }
       /* if (section.getCours().getId() == null){
            return null;
        }*/
        Cours cours = coursService.findById( section.getCours().getId());
        if (cours == null) {
            return null;
        }
//        if (section.getCategorieSection() == null){
//            return null;
//        }

//        section.setCategorieSection(null);
        section.setCours(cours);

        EtatSection etatSection = etatSectionService.findById(1L);
        section.setEtatSection(etatSection);

        Integer nombreSection = cours.getNombreSection() + 1;
        cours.setNombreSection(nombreSection);
        coursService.updateCours(cours);
        sectionDao.save(section);

        return section;
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
            t.setEtatSection(etatSectionService.findOrSave(t.getEtatSection()));
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

    public List<Section> findByEtatSectionId(Long id){
        return dao.findByEtatSectionId(id);
    }
    public int deleteByEtatSectionId(Long id){
        return dao.deleteByEtatSectionId(id);
    }
    public long countByEtatSectionCode(String code){
        return dao.countByEtatSectionCode(code);
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

    private @Autowired EtatSectionAdminService etatSectionService;
    @Autowired
    private CoursAdminService coursService ;
    @Autowired
    private SectionItemAdminService sectionItemService ;

    public SectionAdminServiceImpl(SectionDao dao) {
        super(dao);
    }

}
