package ma.zs.alc.dao.facade.core.faq;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.faq.FaqProf;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface FaqProfDao extends AbstractRepository<FaqProf,Long>  {

    List<FaqProf> findByProfId(Long id);
    int deleteByProfId(Long id);
    long countByProfRef(String ref);
    List<FaqProf> findByAdminId(Long id);
    int deleteByAdminId(Long id);
    long countByAdminId(Long id);
    List<FaqProf> findByFaqTypeId(Long id);
    int deleteByFaqTypeId(Long id);
    long countByFaqTypeId(Long id);

    @Query("SELECT NEW FaqProf(item.id,item.libelle) FROM FaqProf item")
    List<FaqProf> findAllOptimized();

}
