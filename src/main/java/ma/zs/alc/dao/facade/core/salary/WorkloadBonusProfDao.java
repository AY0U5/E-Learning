package ma.zs.alc.dao.facade.core.salary;

import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.salary.WorkloadBonusProf;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface WorkloadBonusProfDao extends AbstractRepository<WorkloadBonusProf,Long>  {

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
