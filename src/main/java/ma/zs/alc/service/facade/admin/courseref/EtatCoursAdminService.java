package ma.zs.alc.service.facade.admin.courseref;

import java.util.List;
import ma.zs.alc.bean.core.courseref.EtatCours;
import ma.zs.alc.dao.criteria.core.courseref.EtatCoursCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface EtatCoursAdminService extends  IService<EtatCours,EtatCoursCriteria>  {


    EtatCours findByCode(String code);

    int deleteByCode(String code);

    EtatCours findByLibelle(String lib);

    int deleteByLibelle(String lib);
}
