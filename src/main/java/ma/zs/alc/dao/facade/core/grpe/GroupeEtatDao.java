package ma.zs.alc.dao.facade.core.grpe;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.grpe.GroupeEtat;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.grpe.GroupeEtat;
import java.util.List;


@Repository
public interface GroupeEtatDao extends AbstractRepository<GroupeEtat,Long>  {
    GroupeEtat findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW GroupeEtat(item.id,item.libelle) FROM GroupeEtat item")
    List<GroupeEtat> findAllOptimized();

}
