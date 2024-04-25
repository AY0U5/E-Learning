package ma.zs.alc.dao.facade.core.prof;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.prof.Prof;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.prof.Prof;
import java.util.List;


@Repository
public interface ProfDao extends AbstractRepository<Prof,Long>  {
    Prof findByRef(String ref);
    int deleteByRef(String ref);

    List<Prof> findByParcoursId(Long id);
    int deleteByParcoursId(Long id);
    long countByParcoursCode(String code);
    List<Prof> findByCategorieProfId(Long id);
    int deleteByCategorieProfId(Long id);
    long countByCategorieProfCode(String code);
    List<Prof> findByTypeTeacherId(Long id);
    int deleteByTypeTeacherId(Long id);
    long countByTypeTeacherCode(String code);
    Prof findByUsername(String username);

    @Query("SELECT NEW Prof(item.id,item.ref) FROM Prof item")
    List<Prof> findAllOptimized();

}
