package ma.zs.alc.dao.facade.core.homework;

import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.homework.ReponseEtudiantHomeWork;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ReponseEtudiantHomeWorkDao extends AbstractRepository<ReponseEtudiantHomeWork,Long>  {

    List<ReponseEtudiantHomeWork> findByHoweWorkQSTReponseId(Long id);
    int deleteByHoweWorkQSTReponseId(Long id);
    long countByHoweWorkQSTReponseRef(String ref);
    List<ReponseEtudiantHomeWork> findByHomeWorkEtudiantId(Long id);
    int deleteByHomeWorkEtudiantId(Long id);
    long countByHomeWorkEtudiantId(Long id);
    List<ReponseEtudiantHomeWork> findByHomeWorkQuestionId(Long id);
    int deleteByHomeWorkQuestionId(Long id);
    long countByHomeWorkQuestionRef(String ref);


}
