package ma.zs.alc.service.impl.admin.courseref;


import ma.zs.alc.bean.core.courseref.EtatCours;
import ma.zs.alc.dao.criteria.core.courseref.EtatCoursCriteria;
import ma.zs.alc.dao.facade.core.courseref.EtatCoursDao;
import ma.zs.alc.dao.specification.core.courseref.EtatCoursSpecification;
import ma.zs.alc.service.facade.admin.courseref.EtatCoursAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EtatCoursAdminServiceImpl extends AbstractServiceImpl<EtatCours, EtatCoursCriteria, EtatCoursDao> implements EtatCoursAdminService {






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
