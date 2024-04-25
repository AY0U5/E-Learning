package ma.zs.alc.dao.facade.core.inscriptionref;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.inscriptionref.StatutSocial;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.inscriptionref.StatutSocial;
import java.util.List;


@Repository
public interface StatutSocialDao extends AbstractRepository<StatutSocial,Long>  {
    StatutSocial findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW StatutSocial(item.id,item.libelle) FROM StatutSocial item")
    List<StatutSocial> findAllOptimized();

}
