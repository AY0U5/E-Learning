package ma.zs.alc.dao.facade.core.pack;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.pack.PackStudent;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.pack.PackStudent;
import java.util.List;


@Repository
public interface PackStudentDao extends AbstractRepository<PackStudent,Long>  {
    PackStudent findByCode(String code);
    int deleteByCode(String code);

    List<PackStudent> findByParcoursId(Long id);
    int deleteByParcoursId(Long id);
    long countByParcoursCode(String code);
    List<PackStudent> findByPriceId(Long id);
    int deleteByPriceId(Long id);
    long countByPriceId(Long id);

    @Query("SELECT NEW PackStudent(item.id,item.libelle) FROM PackStudent item")
    List<PackStudent> findAllOptimized();

}
