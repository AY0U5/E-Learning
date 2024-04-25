package ma.zs.alc.service.facade.admin.salary;

import java.util.List;
import ma.zs.alc.bean.core.salary.WorkloadBonusProf;
import ma.zs.alc.dao.criteria.core.salary.WorkloadBonusProfCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface WorkloadBonusProfAdminService extends  IService<WorkloadBonusProf,WorkloadBonusProfCriteria>  {

    List<WorkloadBonusProf> findByWorkloadBonusId(Long id);
    int deleteByWorkloadBonusId(Long id);
    long countByWorkloadBonusCode(String code);
    List<WorkloadBonusProf> findByProfId(Long id);
    int deleteByProfId(Long id);
    long countByProfRef(String ref);
    List<WorkloadBonusProf> findBySalaryId(Long id);
    int deleteBySalaryId(Long id);
    long countBySalaryCode(String code);




}
