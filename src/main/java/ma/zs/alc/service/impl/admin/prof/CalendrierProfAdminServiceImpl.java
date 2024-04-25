package ma.zs.alc.service.impl.admin.prof;


import ma.zs.alc.bean.core.prof.CalendrierProf;
import ma.zs.alc.dao.criteria.core.prof.CalendrierProfCriteria;
import ma.zs.alc.dao.facade.core.prof.CalendrierProfDao;
import ma.zs.alc.dao.specification.core.prof.CalendrierProfSpecification;
import ma.zs.alc.service.facade.admin.prof.CalendrierProfAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.alc.service.facade.admin.inscription.EtudiantAdminService ;
import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.service.facade.admin.prof.ProfAdminService ;
import ma.zs.alc.bean.core.prof.Prof ;

import java.util.List;
@Service
public class CalendrierProfAdminServiceImpl extends AbstractServiceImpl<CalendrierProf, CalendrierProfCriteria, CalendrierProfDao> implements CalendrierProfAdminService {






    public CalendrierProf findByReferenceEntity(CalendrierProf t){
        return t==null? null : dao.findByRef(t.getRef());
    }
    public void findOrSaveAssociatedObject(CalendrierProf t){
        if( t != null) {
            t.setProf(profService.findOrSave(t.getProf()));
            t.setEtudiant(etudiantService.findOrSave(t.getEtudiant()));
        }
    }

    public List<CalendrierProf> findByProfId(Long id){
        return dao.findByProfId(id);
    }
    public int deleteByProfId(Long id){
        return dao.deleteByProfId(id);
    }
    public long countByProfRef(String ref){
        return dao.countByProfRef(ref);
    }
    public List<CalendrierProf> findByEtudiantId(Long id){
        return dao.findByEtudiantId(id);
    }
    public int deleteByEtudiantId(Long id){
        return dao.deleteByEtudiantId(id);
    }
    public long countByEtudiantRef(String ref){
        return dao.countByEtudiantRef(ref);
    }

    public List<CalendrierProf> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(CalendrierProf.class, CalendrierProfSpecification.class);
    }


    @Autowired
    private EtudiantAdminService etudiantService ;
    @Autowired
    private ProfAdminService profService ;

    public CalendrierProfAdminServiceImpl(CalendrierProfDao dao) {
        super(dao);
    }

}
