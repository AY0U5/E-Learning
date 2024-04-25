package ma.zs.alc.dao.facade.core.inscriptionref;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.inscriptionref.Langue;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.inscriptionref.Langue;
import java.util.List;


@Repository
public interface LangueDao extends AbstractRepository<Langue,Long>  {
    Langue findByLibelle(String libelle);
    int deleteByLibelle(String libelle);


    @Query("SELECT NEW Langue(item.id,item.libelle) FROM Langue item")
    List<Langue> findAllOptimized();

}
