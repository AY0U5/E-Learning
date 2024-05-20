package ma.zs.alc.dao.facade.core.courseref;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.courseref.EtatParcours;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.courseref.EtatParcours;
import java.util.List;


@Repository
public interface EtatParcoursDao extends AbstractRepository<EtatParcours,Long>  {
    EtatParcours findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW EtatParcours(item.id,item.libelle) FROM EtatParcours item")
    List<EtatParcours> findAllOptimized();

    EtatParcours findByLibelle(String lib);

    int deleteByLibelle(String lib);
}
