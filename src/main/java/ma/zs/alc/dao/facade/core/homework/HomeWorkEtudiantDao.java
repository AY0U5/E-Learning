package ma.zs.alc.dao.facade.core.homework;

import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.homework.HomeWorkEtudiant;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface HomeWorkEtudiantDao extends AbstractRepository<HomeWorkEtudiant,Long>  {

    List<HomeWorkEtudiant> findByEtudiantId(Long id);
    int deleteByEtudiantId(Long id);
    long countByEtudiantRef(String ref);
    List<HomeWorkEtudiant> findByHomeWorkId(Long id);
    int deleteByHomeWorkId(Long id);
    long countByHomeWorkId(Long id);


}
