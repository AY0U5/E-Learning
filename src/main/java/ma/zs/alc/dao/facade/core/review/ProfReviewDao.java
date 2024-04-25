package ma.zs.alc.dao.facade.core.review;

import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.review.ProfReview;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProfReviewDao extends AbstractRepository<ProfReview,Long>  {

    List<ProfReview> findByEtudiantId(Long id);
    int deleteByEtudiantId(Long id);
    long countByEtudiantRef(String ref);
    List<ProfReview> findByProfId(Long id);
    int deleteByProfId(Long id);
    long countByProfRef(String ref);
    List<ProfReview> findByCoursId(Long id);
    int deleteByCoursId(Long id);
    long countByCoursCode(String code);


}
