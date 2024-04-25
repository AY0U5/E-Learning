package ma.zs.alc.service.impl.admin.recomrecla;


import ma.zs.alc.bean.core.recomrecla.ReclamationEtudiant;
import ma.zs.alc.dao.criteria.core.recomrecla.ReclamationEtudiantCriteria;
import ma.zs.alc.dao.facade.core.recomrecla.ReclamationEtudiantDao;
import ma.zs.alc.dao.specification.core.recomrecla.ReclamationEtudiantSpecification;
import ma.zs.alc.service.facade.admin.recomrecla.ReclamationEtudiantAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.alc.service.facade.admin.recomrecla.TypeReclamationEtudiantAdminService ;
import ma.zs.alc.bean.core.recomrecla.TypeReclamationEtudiant ;

import java.util.List;
@Service
public class ReclamationEtudiantAdminServiceImpl extends AbstractServiceImpl<ReclamationEtudiant, ReclamationEtudiantCriteria, ReclamationEtudiantDao> implements ReclamationEtudiantAdminService {






    public ReclamationEtudiant findByReferenceEntity(ReclamationEtudiant t){
        return t==null? null : dao.findByReference(t.getReference());
    }
    public void findOrSaveAssociatedObject(ReclamationEtudiant t){
        if( t != null) {
            t.setTypeReclamationEtudiant(typeReclamationEtudiantService.findOrSave(t.getTypeReclamationEtudiant()));
        }
    }

    public List<ReclamationEtudiant> findByTypeReclamationEtudiantId(Long id){
        return dao.findByTypeReclamationEtudiantId(id);
    }
    public int deleteByTypeReclamationEtudiantId(Long id){
        return dao.deleteByTypeReclamationEtudiantId(id);
    }
    public long countByTypeReclamationEtudiantCode(String code){
        return dao.countByTypeReclamationEtudiantCode(code);
    }

    public List<ReclamationEtudiant> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(ReclamationEtudiant.class, ReclamationEtudiantSpecification.class);
    }


    @Autowired
    private TypeReclamationEtudiantAdminService typeReclamationEtudiantService ;

    public ReclamationEtudiantAdminServiceImpl(ReclamationEtudiantDao dao) {
        super(dao);
    }

}
