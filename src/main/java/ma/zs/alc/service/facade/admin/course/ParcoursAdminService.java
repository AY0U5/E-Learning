package ma.zs.alc.service.facade.admin.course;

import java.util.List;

import ma.zs.alc.bean.core.course.Cours;
import ma.zs.alc.bean.core.course.Parcours;
import ma.zs.alc.dao.criteria.core.course.ParcoursCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface ParcoursAdminService extends  IService<Parcours,ParcoursCriteria>  {
    List<Cours> findByEtatParcoursId(Long id);
    int deleteByEtatParcoursId(Long id);

    Parcours findByCode(String code);

    int deleteByCode(String code);

    Parcours findByLibelle(String lib);

    int deleteByLibelle(String Lib);

    List<Parcours> findByCentreRef(String CentreRef);

    int deleteByCentreRef(String CentreRef);

    List<Parcours> findByCentreId(Long id);
    int deleteByCentreId(Long id);
    long countByCentreRef(String ref);




}
