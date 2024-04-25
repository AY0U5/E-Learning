package ma.zs.alc.dao.facade.core.inscriptionref;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.inscriptionref.EtatEtudiantSchedule;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.inscriptionref.EtatEtudiantSchedule;
import java.util.List;


@Repository
public interface EtatEtudiantScheduleDao extends AbstractRepository<EtatEtudiantSchedule,Long>  {
    EtatEtudiantSchedule findByLibelle(String libelle);
    int deleteByLibelle(String libelle);


    @Query("SELECT NEW EtatEtudiantSchedule(item.id,item.libelle) FROM EtatEtudiantSchedule item")
    List<EtatEtudiantSchedule> findAllOptimized();

}
