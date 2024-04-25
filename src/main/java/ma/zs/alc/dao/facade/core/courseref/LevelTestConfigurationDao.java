package ma.zs.alc.dao.facade.core.courseref;

import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.courseref.LevelTestConfiguration;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface LevelTestConfigurationDao extends AbstractRepository<LevelTestConfiguration,Long>  {

    List<LevelTestConfiguration> findByParcoursId(Long id);
    int deleteByParcoursId(Long id);
    long countByParcoursCode(String code);


}
