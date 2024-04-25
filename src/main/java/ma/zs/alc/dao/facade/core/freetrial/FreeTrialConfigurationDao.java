package ma.zs.alc.dao.facade.core.freetrial;

import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.freetrial.FreeTrialConfiguration;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface FreeTrialConfigurationDao extends AbstractRepository<FreeTrialConfiguration,Long>  {



}
