package ma.zs.alc.service.impl.admin.inscriptionref;


import ma.zs.alc.bean.core.inscriptionref.EtatInscription;
import ma.zs.alc.dao.criteria.core.inscriptionref.EtatInscriptionCriteria;
import ma.zs.alc.dao.facade.core.inscriptionref.EtatInscriptionDao;
import ma.zs.alc.dao.specification.core.inscriptionref.EtatInscriptionSpecification;
import ma.zs.alc.service.facade.admin.inscriptionref.EtatInscriptionAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EtatInscriptionAdminServiceImpl extends AbstractServiceImpl<EtatInscription, EtatInscriptionCriteria, EtatInscriptionDao> implements EtatInscriptionAdminService {






    public EtatInscription findByReferenceEntity(EtatInscription t){
        return t==null? null : dao.findByLibelle(t.getLibelle());
    }


    public List<EtatInscription> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(EtatInscription.class, EtatInscriptionSpecification.class);
    }



    public EtatInscriptionAdminServiceImpl(EtatInscriptionDao dao) {
        super(dao);
    }

}
