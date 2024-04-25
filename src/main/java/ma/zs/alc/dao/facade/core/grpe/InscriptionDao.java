package ma.zs.alc.dao.facade.core.grpe;

import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.grpe.Inscription;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface InscriptionDao extends AbstractRepository<Inscription,Long>  {

    List<Inscription> findByEtudiantId(Long id);
    int deleteByEtudiantId(Long id);
    long countByEtudiantRef(String ref);
    List<Inscription> findByEtatInscriptionId(Long id);
    int deleteByEtatInscriptionId(Long id);
    long countByEtatInscriptionLibelle(String libelle);
    List<Inscription> findByParcoursId(Long id);
    int deleteByParcoursId(Long id);
    long countByParcoursCode(String code);
    List<Inscription> findByGroupeEtudeId(Long id);
    int deleteByGroupeEtudeId(Long id);
    long countByGroupeEtudeId(Long id);
    List<Inscription> findByGroupeTypeId(Long id);
    int deleteByGroupeTypeId(Long id);
    long countByGroupeTypeCode(String code);
    List<Inscription> findByStatutSocialId(Long id);
    int deleteByStatutSocialId(Long id);
    long countByStatutSocialCode(String code);
    List<Inscription> findByInteretEtudiantId(Long id);
    int deleteByInteretEtudiantId(Long id);
    long countByInteretEtudiantCode(String code);
    List<Inscription> findByNiveauEtudeId(Long id);
    int deleteByNiveauEtudeId(Long id);
    long countByNiveauEtudeCode(String code);
    List<Inscription> findByFonctionId(Long id);
    int deleteByFonctionId(Long id);
    long countByFonctionCode(String code);
    List<Inscription> findByQuizId(Long id);
    int deleteByQuizId(Long id);
    long countByQuizRef(String ref);
    List<Inscription> findByPackStudentId(Long id);
    int deleteByPackStudentId(Long id);
    long countByPackStudentCode(String code);
    List<Inscription> findBySkillId(Long id);
    int deleteBySkillId(Long id);
    long countBySkillCode(String code);


}
