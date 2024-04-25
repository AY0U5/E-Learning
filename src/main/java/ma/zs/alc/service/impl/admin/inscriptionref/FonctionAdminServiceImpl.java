package ma.zs.alc.service.impl.admin.inscriptionref;


import ma.zs.alc.bean.core.inscriptionref.Fonction;
import ma.zs.alc.dao.criteria.core.inscriptionref.FonctionCriteria;
import ma.zs.alc.dao.facade.core.inscriptionref.FonctionDao;
import ma.zs.alc.dao.specification.core.inscriptionref.FonctionSpecification;
import ma.zs.alc.service.facade.admin.inscriptionref.FonctionAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class FonctionAdminServiceImpl extends AbstractServiceImpl<Fonction, FonctionCriteria, FonctionDao> implements FonctionAdminService {






    public Fonction findByReferenceEntity(Fonction t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<Fonction> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Fonction.class, FonctionSpecification.class);
    }



    public FonctionAdminServiceImpl(FonctionDao dao) {
        super(dao);
    }

}
