package ma.zs.alc.dao.facade.core.course;

import ma.zs.alc.bean.core.course.Cours;
import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.course.Parcours;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.course.Parcours;
import java.util.List;


@Repository
public interface ParcoursDao extends AbstractRepository<Parcours,Long>  {

    List<Parcours> findByEtatParcoursId(Long id);
    int deleteByEtatParcoursId(Long id);
    long countByEtatParcoursCode(String code);
    Parcours findByCode(String code);
    int deleteByCode(String code);

    List<Parcours> findByCentreId(Long id);
    int deleteByCentreId(Long id);
    long countByCentreRef(String ref);

    @Query("SELECT NEW Parcours(item.id,item.libelle) FROM Parcours item")
    List<Parcours> findAllOptimized();

    Parcours findByLibelle(String libelle);
    int deleteByLibelle(String libelle);

    List<Parcours> findByCentreRef(String centreRef);

    int deleteByCentreRef(String centreRef);
}
