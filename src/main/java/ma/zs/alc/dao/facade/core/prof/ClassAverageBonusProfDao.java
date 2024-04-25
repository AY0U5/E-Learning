package ma.zs.alc.dao.facade.core.prof;

import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.prof.ClassAverageBonusProf;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ClassAverageBonusProfDao extends AbstractRepository<ClassAverageBonusProf,Long>  {

    List<ClassAverageBonusProf> findByProfId(Long id);
    int deleteByProfId(Long id);
    long countByProfRef(String ref);
    List<ClassAverageBonusProf> findBySalaryId(Long id);
    int deleteBySalaryId(Long id);
    long countBySalaryCode(String code);


}
