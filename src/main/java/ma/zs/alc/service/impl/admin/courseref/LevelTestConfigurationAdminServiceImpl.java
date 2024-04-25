package ma.zs.alc.service.impl.admin.courseref;


import ma.zs.alc.bean.core.courseref.LevelTestConfiguration;
import ma.zs.alc.dao.criteria.core.courseref.LevelTestConfigurationCriteria;
import ma.zs.alc.dao.facade.core.courseref.LevelTestConfigurationDao;
import ma.zs.alc.dao.specification.core.courseref.LevelTestConfigurationSpecification;
import ma.zs.alc.service.facade.admin.courseref.LevelTestConfigurationAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.alc.service.facade.admin.course.ParcoursAdminService ;
import ma.zs.alc.bean.core.course.Parcours ;

import java.util.List;
@Service
public class LevelTestConfigurationAdminServiceImpl extends AbstractServiceImpl<LevelTestConfiguration, LevelTestConfigurationCriteria, LevelTestConfigurationDao> implements LevelTestConfigurationAdminService {






    public void findOrSaveAssociatedObject(LevelTestConfiguration t){
        if( t != null) {
            t.setParcours(parcoursService.findOrSave(t.getParcours()));
        }
    }

    public List<LevelTestConfiguration> findByParcoursId(Long id){
        return dao.findByParcoursId(id);
    }
    public int deleteByParcoursId(Long id){
        return dao.deleteByParcoursId(id);
    }
    public long countByParcoursCode(String code){
        return dao.countByParcoursCode(code);
    }






    public void configure() {
        super.configure(LevelTestConfiguration.class, LevelTestConfigurationSpecification.class);
    }


    @Autowired
    private ParcoursAdminService parcoursService ;

    public LevelTestConfigurationAdminServiceImpl(LevelTestConfigurationDao dao) {
        super(dao);
    }

}
