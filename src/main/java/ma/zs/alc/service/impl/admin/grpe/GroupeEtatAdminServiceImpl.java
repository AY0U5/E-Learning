package ma.zs.alc.service.impl.admin.grpe;


import ma.zs.alc.bean.core.grpe.GroupeEtat;
import ma.zs.alc.dao.criteria.core.grpe.GroupeEtatCriteria;
import ma.zs.alc.dao.facade.core.grpe.GroupeEtatDao;
import ma.zs.alc.dao.specification.core.grpe.GroupeEtatSpecification;
import ma.zs.alc.service.facade.admin.grpe.GroupeEtatAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class GroupeEtatAdminServiceImpl extends AbstractServiceImpl<GroupeEtat, GroupeEtatCriteria, GroupeEtatDao> implements GroupeEtatAdminService {






    public GroupeEtat findByReferenceEntity(GroupeEtat t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<GroupeEtat> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(GroupeEtat.class, GroupeEtatSpecification.class);
    }



    public GroupeEtatAdminServiceImpl(GroupeEtatDao dao) {
        super(dao);
    }

}
