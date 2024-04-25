package ma.zs.alc.dao.facade.core.profetudiantcours;

import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.profetudiantcours.EtudiantCours;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EtudiantCoursDao extends AbstractRepository<EtudiantCours,Long>  {

    List<EtudiantCours> findByEtudiantId(Long id);
    int deleteByEtudiantId(Long id);
    long countByEtudiantRef(String ref);
    List<EtudiantCours> findByProfId(Long id);
    int deleteByProfId(Long id);
    long countByProfRef(String ref);
    List<EtudiantCours> findByCoursId(Long id);
    int deleteByCoursId(Long id);
    long countByCoursCode(String code);


}
