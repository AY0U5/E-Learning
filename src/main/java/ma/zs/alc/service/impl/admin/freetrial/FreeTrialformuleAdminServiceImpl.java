package ma.zs.alc.service.impl.admin.freetrial;


import ma.zs.alc.bean.core.freetrial.FreeTrialformule;
import ma.zs.alc.dao.criteria.core.freetrial.FreeTrialformuleCriteria;
import ma.zs.alc.dao.facade.core.freetrial.FreeTrialformuleDao;
import ma.zs.alc.dao.specification.core.freetrial.FreeTrialformuleSpecification;
import ma.zs.alc.service.facade.admin.freetrial.FreeTrialformuleAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.alc.service.facade.admin.grpe.InscriptionAdminService ;
import ma.zs.alc.bean.core.grpe.Inscription ;

import java.util.List;
@Service
public class FreeTrialformuleAdminServiceImpl extends AbstractServiceImpl<FreeTrialformule, FreeTrialformuleCriteria, FreeTrialformuleDao> implements FreeTrialformuleAdminService {






    public FreeTrialformule findByReferenceEntity(FreeTrialformule t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(FreeTrialformule t){
        if( t != null) {
            t.setInscription(inscriptionService.findOrSave(t.getInscription()));
        }
    }

    public List<FreeTrialformule> findByInscriptionId(Long id){
        return dao.findByInscriptionId(id);
    }
    public int deleteByInscriptionId(Long id){
        return dao.deleteByInscriptionId(id);
    }
    public long countByInscriptionId(Long id){
        return dao.countByInscriptionId(id);
    }

    public List<FreeTrialformule> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(FreeTrialformule.class, FreeTrialformuleSpecification.class);
    }


    @Autowired
    private InscriptionAdminService inscriptionService ;

    public FreeTrialformuleAdminServiceImpl(FreeTrialformuleDao dao) {
        super(dao);
    }

}
