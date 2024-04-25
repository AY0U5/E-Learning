package ma.zs.alc.dao.facade.core.recomrecla;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.recomrecla.TypeReclamationProf;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.recomrecla.TypeReclamationProf;
import java.util.List;


@Repository
public interface TypeReclamationProfDao extends AbstractRepository<TypeReclamationProf,Long>  {
    TypeReclamationProf findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW TypeReclamationProf(item.id,item.libelle) FROM TypeReclamationProf item")
    List<TypeReclamationProf> findAllOptimized();

}
