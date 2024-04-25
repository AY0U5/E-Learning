package ma.zs.alc.service.impl.admin.recomrecla;


import ma.zs.alc.bean.core.recomrecla.TypeReclamationEtudiant;
import ma.zs.alc.dao.criteria.core.recomrecla.TypeReclamationEtudiantCriteria;
import ma.zs.alc.dao.facade.core.recomrecla.TypeReclamationEtudiantDao;
import ma.zs.alc.dao.specification.core.recomrecla.TypeReclamationEtudiantSpecification;
import ma.zs.alc.service.facade.admin.recomrecla.TypeReclamationEtudiantAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class TypeReclamationEtudiantAdminServiceImpl extends AbstractServiceImpl<TypeReclamationEtudiant, TypeReclamationEtudiantCriteria, TypeReclamationEtudiantDao> implements TypeReclamationEtudiantAdminService {






    public TypeReclamationEtudiant findByReferenceEntity(TypeReclamationEtudiant t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<TypeReclamationEtudiant> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(TypeReclamationEtudiant.class, TypeReclamationEtudiantSpecification.class);
    }



    public TypeReclamationEtudiantAdminServiceImpl(TypeReclamationEtudiantDao dao) {
        super(dao);
    }

}
