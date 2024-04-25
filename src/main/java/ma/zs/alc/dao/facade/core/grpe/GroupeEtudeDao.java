package ma.zs.alc.dao.facade.core.grpe;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.grpe.GroupeEtude;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface GroupeEtudeDao extends AbstractRepository<GroupeEtude,Long>  {


    @Query("SELECT NEW GroupeEtude(item.id,item.libelle) FROM GroupeEtude item")
    List<GroupeEtude> findAllOptimized();

}
