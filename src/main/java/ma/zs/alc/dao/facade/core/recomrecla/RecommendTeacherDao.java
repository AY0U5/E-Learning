package ma.zs.alc.dao.facade.core.recomrecla;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.recomrecla.RecommendTeacher;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.recomrecla.RecommendTeacher;
import java.util.List;


@Repository
public interface RecommendTeacherDao extends AbstractRepository<RecommendTeacher,Long>  {
    RecommendTeacher findByRef(String ref);
    int deleteByRef(String ref);

    List<RecommendTeacher> findByProfId(Long id);
    int deleteByProfId(Long id);
    long countByProfRef(String ref);

    @Query("SELECT NEW RecommendTeacher(item.id,item.ref) FROM RecommendTeacher item")
    List<RecommendTeacher> findAllOptimized();

}
