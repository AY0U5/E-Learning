package ma.zs.alc.dao.facade.core.price;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.price.Price;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PriceDao extends AbstractRepository<Price,Long>  {


    @Query("SELECT NEW Price(item.id,item.lib) FROM Price item")
    List<Price> findAllOptimized();

}
