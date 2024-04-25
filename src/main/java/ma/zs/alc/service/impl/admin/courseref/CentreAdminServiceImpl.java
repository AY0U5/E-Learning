package ma.zs.alc.service.impl.admin.courseref;


import ma.zs.alc.bean.core.courseref.Centre;
import ma.zs.alc.dao.criteria.core.courseref.CentreCriteria;
import ma.zs.alc.dao.facade.core.courseref.CentreDao;
import ma.zs.alc.dao.specification.core.courseref.CentreSpecification;
import ma.zs.alc.service.facade.admin.courseref.CentreAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.alc.service.facade.admin.course.ParcoursAdminService ;
import ma.zs.alc.bean.core.course.Parcours ;

import java.util.List;
@Service
public class CentreAdminServiceImpl extends AbstractServiceImpl<Centre, CentreCriteria, CentreDao> implements CentreAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Centre create(Centre t) {
        Centre saved= super.create(t);
        if (saved != null && t.getParcourss() != null) {
                t.getParcourss().forEach(element-> {
                    element.setCentre(saved);
                    parcoursService.create(element);
            });
        }
        return saved;

    }

    public Centre findWithAssociatedLists(Long id){
        Centre result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setParcourss(parcoursService.findByCentreId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        parcoursService.deleteByCentreId(id);
    }


    public void updateWithAssociatedLists(Centre centre){
    if(centre !=null && centre.getId() != null){
            List<List<Parcours>> resultParcourss= parcoursService.getToBeSavedAndToBeDeleted(parcoursService.findByCentreId(centre.getId()),centre.getParcourss());
            parcoursService.delete(resultParcourss.get(1));
            ListUtil.emptyIfNull(resultParcourss.get(0)).forEach(e -> e.setCentre(centre));
            parcoursService.update(resultParcourss.get(0),true);
        }
    }




    public Centre findByReferenceEntity(Centre t){
        return t==null? null : dao.findByRef(t.getRef());
    }


    public List<Centre> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Centre.class, CentreSpecification.class);
    }


    @Autowired
    private ParcoursAdminService parcoursService ;

    public CentreAdminServiceImpl(CentreDao dao) {
        super(dao);
    }

}
