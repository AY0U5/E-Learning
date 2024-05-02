package ma.zs.alc.service.facade.admin.courseref;

import java.util.List;
import ma.zs.alc.bean.core.courseref.EtatSection;
import ma.zs.alc.dao.criteria.core.courseref.EtatSectionCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface EtatSectionAdminService extends  IService<EtatSection,EtatSectionCriteria>  {


    EtatSection findByCode(String code);

    int deleteByCode(String code);

    EtatSection findByLibelle(String lib);

    int deleteByLibelle(String lib);
}
