package ma.zs.alc.dao.facade.core.prof;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.prof.TypeTeacher;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.prof.TypeTeacher;
import java.util.List;


@Repository
public interface TypeTeacherDao extends AbstractRepository<TypeTeacher,Long>  {
    TypeTeacher findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW TypeTeacher(item.id,item.libelle) FROM TypeTeacher item")
    List<TypeTeacher> findAllOptimized();

}
