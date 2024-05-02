package ma.zs.alc.service.impl.admin.courseref;


import ma.zs.alc.bean.core.courseref.EtatSection;
import ma.zs.alc.dao.criteria.core.courseref.EtatSectionCriteria;
import ma.zs.alc.dao.facade.core.courseref.EtatSectionDao;
import ma.zs.alc.dao.specification.core.courseref.EtatSectionSpecification;
import ma.zs.alc.service.facade.admin.courseref.EtatSectionAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
@Service
public class EtatSectionAdminServiceImpl extends AbstractServiceImpl<EtatSection, EtatSectionCriteria, EtatSectionDao> implements EtatSectionAdminService {

    @Override
    public EtatSection findByCode(String code) {
        return etatSectionDao.findByCode(code);
    }
    @Override

    public int deleteByCode(String code) {
        return etatSectionDao.deleteByCode(code);
    }
    @Override

    public EtatSection findByLibelle(String lib) {
        return etatSectionDao.findByLibelle(lib);
    }
    @Override
    public int deleteByLibelle(String lib) {
        return etatSectionDao.deleteByLibelle(lib);
    }

    private @Autowired EtatSectionDao etatSectionDao;




    public EtatSection findByReferenceEntity(EtatSection t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<EtatSection> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(EtatSection.class, EtatSectionSpecification.class);
    }



    public EtatSectionAdminServiceImpl(EtatSectionDao dao) {
        super(dao);
    }

}
