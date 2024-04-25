package ma.zs.alc.dao.facade.core.homework;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.homework.TypeHomeWork;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.homework.TypeHomeWork;
import java.util.List;


@Repository
public interface TypeHomeWorkDao extends AbstractRepository<TypeHomeWork,Long>  {
    TypeHomeWork findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW TypeHomeWork(item.id,item.lib) FROM TypeHomeWork item")
    List<TypeHomeWork> findAllOptimized();

}
