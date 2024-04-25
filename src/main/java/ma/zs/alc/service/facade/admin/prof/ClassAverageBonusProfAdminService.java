package ma.zs.alc.service.facade.admin.prof;

import java.util.List;
import ma.zs.alc.bean.core.prof.ClassAverageBonusProf;
import ma.zs.alc.dao.criteria.core.prof.ClassAverageBonusProfCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface ClassAverageBonusProfAdminService extends  IService<ClassAverageBonusProf,ClassAverageBonusProfCriteria>  {

    List<ClassAverageBonusProf> findByProfId(Long id);
    int deleteByProfId(Long id);
    long countByProfRef(String ref);
    List<ClassAverageBonusProf> findBySalaryId(Long id);
    int deleteBySalaryId(Long id);
    long countBySalaryCode(String code);




}
