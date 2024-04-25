package ma.zs.alc.dao.facade.core.inscriptionref;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.inscriptionref.EtatInscription;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.inscriptionref.EtatInscription;
import java.util.List;


@Repository
public interface EtatInscriptionDao extends AbstractRepository<EtatInscription,Long>  {
    EtatInscription findByLibelle(String libelle);
    int deleteByLibelle(String libelle);


    @Query("SELECT NEW EtatInscription(item.id,item.libelle) FROM EtatInscription item")
    List<EtatInscription> findAllOptimized();

}
