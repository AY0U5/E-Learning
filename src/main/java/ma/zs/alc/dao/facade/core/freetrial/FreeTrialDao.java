package ma.zs.alc.dao.facade.core.freetrial;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.freetrial.FreeTrial;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.freetrial.FreeTrial;
import java.util.List;


@Repository
public interface FreeTrialDao extends AbstractRepository<FreeTrial,Long>  {
    FreeTrial findByReference(String reference);
    int deleteByReference(String reference);

    List<FreeTrial> findByProfId(Long id);
    int deleteByProfId(Long id);
    long countByProfRef(String ref);
    List<FreeTrial> findByNiveauEtudeId(Long id);
    int deleteByNiveauEtudeId(Long id);
    long countByNiveauEtudeCode(String code);
    List<FreeTrial> findByFreeTrialStudentWhatsTemplateId(Long id);
    int deleteByFreeTrialStudentWhatsTemplateId(Long id);
    long countByFreeTrialStudentWhatsTemplateId(Long id);
    List<FreeTrial> findByFreeTrialStudentEmailTemplateId(Long id);
    int deleteByFreeTrialStudentEmailTemplateId(Long id);
    long countByFreeTrialStudentEmailTemplateId(Long id);
    List<FreeTrial> findByFreeTrialTeacherEmailTemplateId(Long id);
    int deleteByFreeTrialTeacherEmailTemplateId(Long id);
    long countByFreeTrialTeacherEmailTemplateId(Long id);
    List<FreeTrial> findByFreeTrialTeacherWhatsTemplateId(Long id);
    int deleteByFreeTrialTeacherWhatsTemplateId(Long id);
    long countByFreeTrialTeacherWhatsTemplateId(Long id);
    List<FreeTrial> findByFreeTrialConfigurationId(Long id);
    int deleteByFreeTrialConfigurationId(Long id);
    long countByFreeTrialConfigurationId(Long id);
    List<FreeTrial> findByStatutFreeTrialId(Long id);
    int deleteByStatutFreeTrialId(Long id);
    long countByStatutFreeTrialCode(String code);

    @Query("SELECT NEW FreeTrial(item.id,item.reference) FROM FreeTrial item")
    List<FreeTrial> findAllOptimized();

}
