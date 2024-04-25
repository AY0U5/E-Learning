package ma.zs.alc.dao.facade.core.quizetudiant;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.quizetudiant.ReponseEtudiant;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.quizetudiant.ReponseEtudiant;
import java.util.List;


@Repository
public interface ReponseEtudiantDao extends AbstractRepository<ReponseEtudiant,Long>  {
    ReponseEtudiant findByRef(String ref);
    int deleteByRef(String ref);

    List<ReponseEtudiant> findByReponseId(Long id);
    int deleteByReponseId(Long id);
    long countByReponseRef(String ref);
    List<ReponseEtudiant> findByQuizEtudiantId(Long id);
    int deleteByQuizEtudiantId(Long id);
    long countByQuizEtudiantRef(String ref);
    List<ReponseEtudiant> findByQuestionId(Long id);
    int deleteByQuestionId(Long id);
    long countByQuestionLibelle(String libelle);

    @Query("SELECT NEW ReponseEtudiant(item.id,item.ref) FROM ReponseEtudiant item")
    List<ReponseEtudiant> findAllOptimized();

}
