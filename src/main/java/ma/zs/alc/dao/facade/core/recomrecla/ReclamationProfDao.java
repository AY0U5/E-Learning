package ma.zs.alc.dao.facade.core.recomrecla;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.recomrecla.ReclamationProf;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.recomrecla.ReclamationProf;
import java.util.List;


@Repository
public interface ReclamationProfDao extends AbstractRepository<ReclamationProf,Long>  {
    ReclamationProf findByReference(String reference);
    int deleteByReference(String reference);

    List<ReclamationProf> findByAdminId(Long id);
    int deleteByAdminId(Long id);
    long countByAdminId(Long id);
    List<ReclamationProf> findByProfId(Long id);
    int deleteByProfId(Long id);
    long countByProfRef(String ref);
    List<ReclamationProf> findByTypeReclamationProfId(Long id);
    int deleteByTypeReclamationProfId(Long id);
    long countByTypeReclamationProfCode(String code);

    @Query("SELECT NEW ReclamationProf(item.id,item.reference) FROM ReclamationProf item")
    List<ReclamationProf> findAllOptimized();

}
