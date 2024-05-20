package ma.zs.alc.service.impl.admin.courseref;


import ma.zs.alc.bean.core.courseref.EtatParcours;
import ma.zs.alc.dao.criteria.core.courseref.EtatParcoursCriteria;
import ma.zs.alc.dao.facade.core.courseref.EtatParcoursDao;
import ma.zs.alc.dao.specification.core.courseref.EtatParcoursSpecification;
import ma.zs.alc.service.facade.admin.courseref.EtatParcoursAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EtatParcoursAdminServiceImpl extends AbstractServiceImpl<EtatParcours, EtatParcoursCriteria, EtatParcoursDao> implements EtatParcoursAdminService {

    @Override
    public EtatParcours findByCode(String code) {
        return etatParcoursDao.findByCode(code);
    }
    @Override

    public int deleteByCode(String code) {
        return etatParcoursDao.deleteByCode(code);
    }
    @Override

    public EtatParcours findByLibelle(String lib) {
        return etatParcoursDao.findByLibelle(lib);
    }
    @Override
    public int deleteByLibelle(String lib) {
        return etatParcoursDao.deleteByLibelle(lib);
    }

    private @Autowired EtatParcoursDao etatParcoursDao;




    public EtatParcours findByReferenceEntity(EtatParcours t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<EtatParcours> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(EtatParcours.class, EtatParcoursSpecification.class);
    }



    public EtatParcoursAdminServiceImpl(EtatParcoursDao dao) {
        super(dao);
    }

}
