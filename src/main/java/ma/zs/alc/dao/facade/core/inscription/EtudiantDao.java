package ma.zs.alc.dao.facade.core.inscription;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.inscription.Etudiant;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.inscription.Etudiant;
import java.util.List;


@Repository
public interface EtudiantDao extends AbstractRepository<Etudiant,Long>  {
    Etudiant findByRef(String ref);
    int deleteByRef(String ref);

    List<Etudiant> findByTeacherLocalityId(Long id);
    int deleteByTeacherLocalityId(Long id);
    long countByTeacherLocalityCode(String code);
    List<Etudiant> findByEtatEtudiantScheduleId(Long id);
    int deleteByEtatEtudiantScheduleId(Long id);
    long countByEtatEtudiantScheduleLibelle(String libelle);
    List<Etudiant> findByParcoursId(Long id);
    int deleteByParcoursId(Long id);
    long countByParcoursCode(String code);
    List<Etudiant> findByGroupeEtudeId(Long id);
    int deleteByGroupeEtudeId(Long id);
    long countByGroupeEtudeId(Long id);
    List<Etudiant> findByPackStudentId(Long id);
    int deleteByPackStudentId(Long id);
    long countByPackStudentCode(String code);
    List<Etudiant> findByStatutSocialId(Long id);
    int deleteByStatutSocialId(Long id);
    long countByStatutSocialCode(String code);
    List<Etudiant> findByInteretEtudiantId(Long id);
    int deleteByInteretEtudiantId(Long id);
    long countByInteretEtudiantCode(String code);
    List<Etudiant> findByNiveauEtudeId(Long id);
    int deleteByNiveauEtudeId(Long id);
    long countByNiveauEtudeCode(String code);
    List<Etudiant> findBySkillId(Long id);
    int deleteBySkillId(Long id);
    long countBySkillCode(String code);
    List<Etudiant> findByFonctionId(Long id);
    int deleteByFonctionId(Long id);
    long countByFonctionCode(String code);
    List<Etudiant> findByLangueId(Long id);
    int deleteByLangueId(Long id);
    long countByLangueLibelle(String libelle);
    Etudiant findByUsername(String username);

    @Query("SELECT NEW Etudiant(item.id,item.ref) FROM Etudiant item")
    List<Etudiant> findAllOptimized();

}
