package ma.zs.alc.service.impl.admin.common;


import ma.zs.alc.bean.core.common.ClassAverageBonus;
import ma.zs.alc.dao.criteria.core.common.ClassAverageBonusCriteria;
import ma.zs.alc.dao.facade.core.common.ClassAverageBonusDao;
import ma.zs.alc.dao.specification.core.common.ClassAverageBonusSpecification;
import ma.zs.alc.service.facade.admin.common.ClassAverageBonusAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ClassAverageBonusAdminServiceImpl extends AbstractServiceImpl<ClassAverageBonus, ClassAverageBonusCriteria, ClassAverageBonusDao> implements ClassAverageBonusAdminService {






    public ClassAverageBonus findByReferenceEntity(ClassAverageBonus t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<ClassAverageBonus> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(ClassAverageBonus.class, ClassAverageBonusSpecification.class);
    }



    public ClassAverageBonusAdminServiceImpl(ClassAverageBonusDao dao) {
        super(dao);
    }

}
