package ma.zs.alc.dao.facade.core.quizetudiant;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant;
import java.util.List;


@Repository
public interface QuizEtudiantDao extends AbstractRepository<QuizEtudiant,Long>  {
    QuizEtudiant findByRef(String ref);
    int deleteByRef(String ref);

    List<QuizEtudiant> findByEtudiantId(Long id);
    int deleteByEtudiantId(Long id);
    long countByEtudiantRef(String ref);
    List<QuizEtudiant> findByQuizId(Long id);
    int deleteByQuizId(Long id);
    long countByQuizRef(String ref);

    @Query("SELECT NEW QuizEtudiant(item.id,item.ref) FROM QuizEtudiant item")
    List<QuizEtudiant> findAllOptimized();

}
