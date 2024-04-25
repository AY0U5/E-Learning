package ma.zs.alc.dao.facade.core.recomrecla;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.recomrecla.ReclamationEtudiant;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.recomrecla.ReclamationEtudiant;
import java.util.List;


@Repository
public interface ReclamationEtudiantDao extends AbstractRepository<ReclamationEtudiant,Long>  {
    ReclamationEtudiant findByReference(String reference);
    int deleteByReference(String reference);

    List<ReclamationEtudiant> findByTypeReclamationEtudiantId(Long id);
    int deleteByTypeReclamationEtudiantId(Long id);
    long countByTypeReclamationEtudiantCode(String code);

    @Query("SELECT NEW ReclamationEtudiant(item.id,item.reference) FROM ReclamationEtudiant item")
    List<ReclamationEtudiant> findAllOptimized();

}
