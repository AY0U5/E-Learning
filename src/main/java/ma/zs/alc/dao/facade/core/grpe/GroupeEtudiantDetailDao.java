package ma.zs.alc.dao.facade.core.grpe;

import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.grpe.GroupeEtudiantDetail;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface GroupeEtudiantDetailDao extends AbstractRepository<GroupeEtudiantDetail,Long>  {

    List<GroupeEtudiantDetail> findByGroupeEtudiantId(Long id);
    int deleteByGroupeEtudiantId(Long id);
    long countByGroupeEtudiantId(Long id);
    List<GroupeEtudiantDetail> findByEtudiantId(Long id);
    int deleteByEtudiantId(Long id);
    long countByEtudiantRef(String ref);


}
