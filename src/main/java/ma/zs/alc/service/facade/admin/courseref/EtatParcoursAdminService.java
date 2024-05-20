package ma.zs.alc.service.facade.admin.courseref;

import ma.zs.alc.bean.core.courseref.EtatParcours;
import ma.zs.alc.dao.criteria.core.courseref.EtatParcoursCriteria;
import ma.zs.alc.zynerator.service.IService;

public interface EtatParcoursAdminService extends IService<EtatParcours, EtatParcoursCriteria> {


    EtatParcours findByCode(String code);

    int deleteByCode(String code);

    EtatParcours findByLibelle(String lib);

    int deleteByLibelle(String lib);
}
