package ma.zs.alc.service.impl.admin.prof;


import ma.zs.alc.bean.core.prof.CategorieProf;
import ma.zs.alc.dao.criteria.core.prof.CategorieProfCriteria;
import ma.zs.alc.dao.facade.core.prof.CategorieProfDao;
import ma.zs.alc.dao.specification.core.prof.CategorieProfSpecification;
import ma.zs.alc.service.facade.admin.prof.CategorieProfAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.alc.service.facade.admin.prof.ProfAdminService ;
import ma.zs.alc.bean.core.prof.Prof ;

import java.util.List;
@Service
public class CategorieProfAdminServiceImpl extends AbstractServiceImpl<CategorieProf, CategorieProfCriteria, CategorieProfDao> implements CategorieProfAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public CategorieProf create(CategorieProf t) {
        CategorieProf saved= super.create(t);
        if (saved != null && t.getProfs() != null) {
                t.getProfs().forEach(element-> {
                    element.setCategorieProf(saved);
                    profService.create(element);
            });
        }
        return saved;

    }

    public CategorieProf findWithAssociatedLists(Long id){
        CategorieProf result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setProfs(profService.findByCategorieProfId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        profService.deleteByCategorieProfId(id);
    }


    public void updateWithAssociatedLists(CategorieProf categorieProf){
    if(categorieProf !=null && categorieProf.getId() != null){
            List<List<Prof>> resultProfs= profService.getToBeSavedAndToBeDeleted(profService.findByCategorieProfId(categorieProf.getId()),categorieProf.getProfs());
            profService.delete(resultProfs.get(1));
            ListUtil.emptyIfNull(resultProfs.get(0)).forEach(e -> e.setCategorieProf(categorieProf));
            profService.update(resultProfs.get(0),true);
        }
    }




    public CategorieProf findByReferenceEntity(CategorieProf t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<CategorieProf> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(CategorieProf.class, CategorieProfSpecification.class);
    }


    @Autowired
    private ProfAdminService profService ;

    public CategorieProfAdminServiceImpl(CategorieProfDao dao) {
        super(dao);
    }

}
