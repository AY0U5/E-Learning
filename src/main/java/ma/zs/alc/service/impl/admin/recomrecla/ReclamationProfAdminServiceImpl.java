package ma.zs.alc.service.impl.admin.recomrecla;


import ma.zs.alc.bean.core.recomrecla.ReclamationProf;
import ma.zs.alc.dao.criteria.core.recomrecla.ReclamationProfCriteria;
import ma.zs.alc.dao.facade.core.recomrecla.ReclamationProfDao;
import ma.zs.alc.dao.specification.core.recomrecla.ReclamationProfSpecification;
import ma.zs.alc.service.facade.admin.recomrecla.ReclamationProfAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.alc.service.facade.admin.recomrecla.TypeReclamationProfAdminService ;
import ma.zs.alc.bean.core.recomrecla.TypeReclamationProf ;
import ma.zs.alc.service.facade.admin.alc.AdminAdminService ;
import ma.zs.alc.bean.core.alc.Admin ;
import ma.zs.alc.service.facade.admin.prof.ProfAdminService ;
import ma.zs.alc.bean.core.prof.Prof ;

import java.util.List;
@Service
public class ReclamationProfAdminServiceImpl extends AbstractServiceImpl<ReclamationProf, ReclamationProfCriteria, ReclamationProfDao> implements ReclamationProfAdminService {






    public ReclamationProf findByReferenceEntity(ReclamationProf t){
        return t==null? null : dao.findByReference(t.getReference());
    }
    public void findOrSaveAssociatedObject(ReclamationProf t){
        if( t != null) {
            t.setAdmin(adminService.findOrSave(t.getAdmin()));
            t.setProf(profService.findOrSave(t.getProf()));
            t.setTypeReclamationProf(typeReclamationProfService.findOrSave(t.getTypeReclamationProf()));
        }
    }

    public List<ReclamationProf> findByAdminId(Long id){
        return dao.findByAdminId(id);
    }
    public int deleteByAdminId(Long id){
        return dao.deleteByAdminId(id);
    }
    public long countByAdminId(Long id){
        return dao.countByAdminId(id);
    }
    public List<ReclamationProf> findByProfId(Long id){
        return dao.findByProfId(id);
    }
    public int deleteByProfId(Long id){
        return dao.deleteByProfId(id);
    }
    public long countByProfRef(String ref){
        return dao.countByProfRef(ref);
    }
    public List<ReclamationProf> findByTypeReclamationProfId(Long id){
        return dao.findByTypeReclamationProfId(id);
    }
    public int deleteByTypeReclamationProfId(Long id){
        return dao.deleteByTypeReclamationProfId(id);
    }
    public long countByTypeReclamationProfCode(String code){
        return dao.countByTypeReclamationProfCode(code);
    }

    public List<ReclamationProf> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(ReclamationProf.class, ReclamationProfSpecification.class);
    }


    @Autowired
    private TypeReclamationProfAdminService typeReclamationProfService ;
    @Autowired
    private AdminAdminService adminService ;
    @Autowired
    private ProfAdminService profService ;

    public ReclamationProfAdminServiceImpl(ReclamationProfDao dao) {
        super(dao);
    }

}
