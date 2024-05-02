package ma.zs.alc.dao.facade.core.courseref;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.courseref.EtatSection;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.courseref.EtatSection;
import java.util.List;


@Repository
public interface EtatSectionDao extends AbstractRepository<EtatSection,Long>  {
    EtatSection findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW EtatSection(item.id,item.libelle) FROM EtatSection item")
    List<EtatSection> findAllOptimized();

    EtatSection findByLibelle(String lib);

    int deleteByLibelle(String lib);
}
