package ma.zs.alc.service.impl.admin.inscriptionref;


import ma.zs.alc.bean.core.inscriptionref.EtatEtudiantSchedule;
import ma.zs.alc.dao.criteria.core.inscriptionref.EtatEtudiantScheduleCriteria;
import ma.zs.alc.dao.facade.core.inscriptionref.EtatEtudiantScheduleDao;
import ma.zs.alc.dao.specification.core.inscriptionref.EtatEtudiantScheduleSpecification;
import ma.zs.alc.service.facade.admin.inscriptionref.EtatEtudiantScheduleAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EtatEtudiantScheduleAdminServiceImpl extends AbstractServiceImpl<EtatEtudiantSchedule, EtatEtudiantScheduleCriteria, EtatEtudiantScheduleDao> implements EtatEtudiantScheduleAdminService {






    public EtatEtudiantSchedule findByReferenceEntity(EtatEtudiantSchedule t){
        return t==null? null : dao.findByLibelle(t.getLibelle());
    }


    public List<EtatEtudiantSchedule> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(EtatEtudiantSchedule.class, EtatEtudiantScheduleSpecification.class);
    }



    public EtatEtudiantScheduleAdminServiceImpl(EtatEtudiantScheduleDao dao) {
        super(dao);
    }

}
