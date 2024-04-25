package ma.zs.alc.dao.facade.core.freetrial;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.freetrial.StatutFreeTrial;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.freetrial.StatutFreeTrial;
import java.util.List;


@Repository
public interface StatutFreeTrialDao extends AbstractRepository<StatutFreeTrial,Long>  {
    StatutFreeTrial findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW StatutFreeTrial(item.id,item.libelle) FROM StatutFreeTrial item")
    List<StatutFreeTrial> findAllOptimized();

}
