package ma.zs.alc.service.impl.admin.inscriptionref;


import ma.zs.alc.bean.core.inscriptionref.Langue;
import ma.zs.alc.dao.criteria.core.inscriptionref.LangueCriteria;
import ma.zs.alc.dao.facade.core.inscriptionref.LangueDao;
import ma.zs.alc.dao.specification.core.inscriptionref.LangueSpecification;
import ma.zs.alc.service.facade.admin.inscriptionref.LangueAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class LangueAdminServiceImpl extends AbstractServiceImpl<Langue, LangueCriteria, LangueDao> implements LangueAdminService {






    public Langue findByReferenceEntity(Langue t){
        return t==null? null : dao.findByLibelle(t.getLibelle());
    }


    public List<Langue> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Langue.class, LangueSpecification.class);
    }



    public LangueAdminServiceImpl(LangueDao dao) {
        super(dao);
    }

}
