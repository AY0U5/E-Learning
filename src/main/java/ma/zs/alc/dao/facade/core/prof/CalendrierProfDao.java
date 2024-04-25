package ma.zs.alc.dao.facade.core.prof;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.prof.CalendrierProf;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.prof.CalendrierProf;
import java.util.List;


@Repository
public interface CalendrierProfDao extends AbstractRepository<CalendrierProf,Long>  {
    CalendrierProf findByRef(String ref);
    int deleteByRef(String ref);

    List<CalendrierProf> findByProfId(Long id);
    int deleteByProfId(Long id);
    long countByProfRef(String ref);
    List<CalendrierProf> findByEtudiantId(Long id);
    int deleteByEtudiantId(Long id);
    long countByEtudiantRef(String ref);

    @Query("SELECT NEW CalendrierProf(item.id,item.ref) FROM CalendrierProf item")
    List<CalendrierProf> findAllOptimized();

}
