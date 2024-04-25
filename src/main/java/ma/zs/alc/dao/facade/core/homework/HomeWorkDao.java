package ma.zs.alc.dao.facade.core.homework;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.homework.HomeWork;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface HomeWorkDao extends AbstractRepository<HomeWork,Long>  {

    List<HomeWork> findByCoursId(Long id);
    int deleteByCoursId(Long id);
    long countByCoursCode(String code);
    List<HomeWork> findByTypeHomeWorkId(Long id);
    int deleteByTypeHomeWorkId(Long id);
    long countByTypeHomeWorkCode(String code);

    @Query("SELECT NEW HomeWork(item.id,item.libelle) FROM HomeWork item")
    List<HomeWork> findAllOptimized();

}
