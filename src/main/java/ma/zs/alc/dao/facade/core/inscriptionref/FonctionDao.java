package ma.zs.alc.dao.facade.core.inscriptionref;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.inscriptionref.Fonction;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.inscriptionref.Fonction;
import java.util.List;


@Repository
public interface FonctionDao extends AbstractRepository<Fonction,Long>  {
    Fonction findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Fonction(item.id,item.libelle) FROM Fonction item")
    List<Fonction> findAllOptimized();

}
