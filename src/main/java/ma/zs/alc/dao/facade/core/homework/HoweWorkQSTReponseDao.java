package ma.zs.alc.dao.facade.core.homework;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.homework.HoweWorkQSTReponse;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.homework.HoweWorkQSTReponse;
import java.util.List;


@Repository
public interface HoweWorkQSTReponseDao extends AbstractRepository<HoweWorkQSTReponse,Long>  {
    HoweWorkQSTReponse findByRef(String ref);
    int deleteByRef(String ref);

    List<HoweWorkQSTReponse> findByHomeWorkQuestionId(Long id);
    int deleteByHomeWorkQuestionId(Long id);
    long countByHomeWorkQuestionRef(String ref);

    @Query("SELECT NEW HoweWorkQSTReponse(item.id,item.lib) FROM HoweWorkQSTReponse item")
    List<HoweWorkQSTReponse> findAllOptimized();

}
