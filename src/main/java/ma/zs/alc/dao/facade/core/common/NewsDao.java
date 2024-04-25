package ma.zs.alc.dao.facade.core.common;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.common.News;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.common.News;
import java.util.List;


@Repository
public interface NewsDao extends AbstractRepository<News,Long>  {
    News findByRef(String ref);
    int deleteByRef(String ref);


    @Query("SELECT NEW News(item.id,item.ref) FROM News item")
    List<News> findAllOptimized();

}
