package ma.zs.alc.service.impl.admin.inscriptionref;


import ma.zs.alc.bean.core.inscriptionref.Skill;
import ma.zs.alc.dao.criteria.core.inscriptionref.SkillCriteria;
import ma.zs.alc.dao.facade.core.inscriptionref.SkillDao;
import ma.zs.alc.dao.specification.core.inscriptionref.SkillSpecification;
import ma.zs.alc.service.facade.admin.inscriptionref.SkillAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class SkillAdminServiceImpl extends AbstractServiceImpl<Skill, SkillCriteria, SkillDao> implements SkillAdminService {






    public Skill findByReferenceEntity(Skill t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<Skill> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Skill.class, SkillSpecification.class);
    }



    public SkillAdminServiceImpl(SkillDao dao) {
        super(dao);
    }

}
