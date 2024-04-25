package ma.zs.alc.dao.facade.core.faq;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.faq.Faq;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface FaqDao extends AbstractRepository<Faq,Long>  {

    List<Faq> findByFaqTypeId(Long id);
    int deleteByFaqTypeId(Long id);
    long countByFaqTypeId(Long id);

    @Query("SELECT NEW Faq(item.id,item.libelle) FROM Faq item")
    List<Faq> findAllOptimized();

}
