package ma.zs.alc.dao.facade.core.courseref;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.courseref.EtatCours;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.courseref.EtatCours;
import java.util.List;


@Repository
public interface EtatCoursDao extends AbstractRepository<EtatCours,Long>  {
    EtatCours findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW EtatCours(item.id,item.libelle) FROM EtatCours item")
    List<EtatCours> findAllOptimized();

    EtatCours findByLibelle(String lib);

    int deleteByLibelle(String lib);
}
