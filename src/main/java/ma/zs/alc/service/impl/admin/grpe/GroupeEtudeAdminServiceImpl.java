package ma.zs.alc.service.impl.admin.grpe;


import ma.zs.alc.bean.core.grpe.GroupeEtude;
import ma.zs.alc.dao.criteria.core.grpe.GroupeEtudeCriteria;
import ma.zs.alc.dao.facade.core.grpe.GroupeEtudeDao;
import ma.zs.alc.dao.specification.core.grpe.GroupeEtudeSpecification;
import ma.zs.alc.service.facade.admin.grpe.GroupeEtudeAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class GroupeEtudeAdminServiceImpl extends AbstractServiceImpl<GroupeEtude, GroupeEtudeCriteria, GroupeEtudeDao> implements GroupeEtudeAdminService {








    public List<GroupeEtude> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(GroupeEtude.class, GroupeEtudeSpecification.class);
    }



    public GroupeEtudeAdminServiceImpl(GroupeEtudeDao dao) {
        super(dao);
    }

}
