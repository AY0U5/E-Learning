package ma.zs.alc.service.impl.admin.courseref;


import ma.zs.alc.bean.core.courseref.EtatCours;
import ma.zs.alc.dao.criteria.core.courseref.EtatCoursCriteria;
import ma.zs.alc.dao.facade.core.courseref.EtatCoursDao;
import ma.zs.alc.dao.specification.core.courseref.EtatCoursSpecification;
import ma.zs.alc.service.facade.admin.courseref.EtatCoursAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EtatCoursAdminServiceImpl extends AbstractServiceImpl<EtatCours, EtatCoursCriteria, EtatCoursDao> implements EtatCoursAdminService {

    @Override
    public EtatCours findByCode(String code) {
        return etatCoursDao.findByCode(code);
    }
    @Override

    public int deleteByCode(String code) {
        return etatCoursDao.deleteByCode(code);
    }
    @Override

    public EtatCours findByLibelle(String lib) {
        return etatCoursDao.findByLibelle(lib);
    }
    @Override
    public int deleteByLibelle(String lib) {
        return etatCoursDao.deleteByLibelle(lib);
    }

    private @Autowired EtatCoursDao etatCoursDao;




    public EtatCours findByReferenceEntity(EtatCours t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<EtatCours> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(EtatCours.class, EtatCoursSpecification.class);
    }



    public EtatCoursAdminServiceImpl(EtatCoursDao dao) {
        super(dao);
    }

}
