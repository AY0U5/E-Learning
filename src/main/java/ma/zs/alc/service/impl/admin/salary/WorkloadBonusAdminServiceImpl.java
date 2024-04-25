package ma.zs.alc.service.impl.admin.salary;


import ma.zs.alc.bean.core.salary.WorkloadBonus;
import ma.zs.alc.dao.criteria.core.salary.WorkloadBonusCriteria;
import ma.zs.alc.dao.facade.core.salary.WorkloadBonusDao;
import ma.zs.alc.dao.specification.core.salary.WorkloadBonusSpecification;
import ma.zs.alc.service.facade.admin.salary.WorkloadBonusAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class WorkloadBonusAdminServiceImpl extends AbstractServiceImpl<WorkloadBonus, WorkloadBonusCriteria, WorkloadBonusDao> implements WorkloadBonusAdminService {






    public WorkloadBonus findByReferenceEntity(WorkloadBonus t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<WorkloadBonus> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(WorkloadBonus.class, WorkloadBonusSpecification.class);
    }



    public WorkloadBonusAdminServiceImpl(WorkloadBonusDao dao) {
        super(dao);
    }

}
