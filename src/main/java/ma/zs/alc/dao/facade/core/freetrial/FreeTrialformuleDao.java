package ma.zs.alc.dao.facade.core.freetrial;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.freetrial.FreeTrialformule;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.freetrial.FreeTrialformule;
import java.util.List;


@Repository
public interface FreeTrialformuleDao extends AbstractRepository<FreeTrialformule,Long>  {
    FreeTrialformule findByCode(String code);
    int deleteByCode(String code);

    List<FreeTrialformule> findByInscriptionId(Long id);
    int deleteByInscriptionId(Long id);
    long countByInscriptionId(Long id);

    @Query("SELECT NEW FreeTrialformule(item.id,item.code) FROM FreeTrialformule item")
    List<FreeTrialformule> findAllOptimized();

}
