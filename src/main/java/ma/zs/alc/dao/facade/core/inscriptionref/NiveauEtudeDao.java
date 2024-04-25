package ma.zs.alc.dao.facade.core.inscriptionref;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.inscriptionref.NiveauEtude;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.inscriptionref.NiveauEtude;
import java.util.List;


@Repository
public interface NiveauEtudeDao extends AbstractRepository<NiveauEtude,Long>  {
    NiveauEtude findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW NiveauEtude(item.id,item.libelle) FROM NiveauEtude item")
    List<NiveauEtude> findAllOptimized();

}
