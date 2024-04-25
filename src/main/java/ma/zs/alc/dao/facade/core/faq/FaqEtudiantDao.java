package ma.zs.alc.dao.facade.core.faq;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.faq.FaqEtudiant;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface FaqEtudiantDao extends AbstractRepository<FaqEtudiant,Long>  {

    List<FaqEtudiant> findByEtudiantId(Long id);
    int deleteByEtudiantId(Long id);
    long countByEtudiantRef(String ref);
    List<FaqEtudiant> findByAdminId(Long id);
    int deleteByAdminId(Long id);
    long countByAdminId(Long id);
    List<FaqEtudiant> findByFaqTypeId(Long id);
    int deleteByFaqTypeId(Long id);
    long countByFaqTypeId(Long id);

    @Query("SELECT NEW FaqEtudiant(item.id,item.libelle) FROM FaqEtudiant item")
    List<FaqEtudiant> findAllOptimized();

}
