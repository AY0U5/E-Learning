package ma.zs.alc.service.impl.admin.grpe;


import ma.zs.alc.bean.core.grpe.Inscription;
import ma.zs.alc.dao.criteria.core.grpe.InscriptionCriteria;
import ma.zs.alc.dao.facade.core.grpe.InscriptionDao;
import ma.zs.alc.dao.specification.core.grpe.InscriptionSpecification;
import ma.zs.alc.service.facade.admin.grpe.InscriptionAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.alc.service.facade.admin.course.ParcoursAdminService ;
import ma.zs.alc.bean.core.course.Parcours ;
import ma.zs.alc.service.facade.admin.quiz.QuizAdminService ;
import ma.zs.alc.bean.core.quiz.Quiz ;
import ma.zs.alc.service.facade.admin.inscriptionref.SkillAdminService ;
import ma.zs.alc.bean.core.inscriptionref.Skill ;
import ma.zs.alc.service.facade.admin.inscriptionref.InteretEtudiantAdminService ;
import ma.zs.alc.bean.core.inscriptionref.InteretEtudiant ;
import ma.zs.alc.service.facade.admin.inscriptionref.FonctionAdminService ;
import ma.zs.alc.bean.core.inscriptionref.Fonction ;
import ma.zs.alc.service.facade.admin.inscription.EtudiantAdminService ;
import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.service.facade.admin.inscriptionref.EtatInscriptionAdminService ;
import ma.zs.alc.bean.core.inscriptionref.EtatInscription ;
import ma.zs.alc.service.facade.admin.grpe.GroupeTypeAdminService ;
import ma.zs.alc.bean.core.grpe.GroupeType ;
import ma.zs.alc.service.facade.admin.inscriptionref.StatutSocialAdminService ;
import ma.zs.alc.bean.core.inscriptionref.StatutSocial ;
import ma.zs.alc.service.facade.admin.pack.PackStudentAdminService ;
import ma.zs.alc.bean.core.pack.PackStudent ;
import ma.zs.alc.service.facade.admin.grpe.GroupeEtudeAdminService ;
import ma.zs.alc.bean.core.grpe.GroupeEtude ;
import ma.zs.alc.service.facade.admin.inscriptionref.NiveauEtudeAdminService ;
import ma.zs.alc.bean.core.inscriptionref.NiveauEtude ;

import java.util.List;
@Service
public class InscriptionAdminServiceImpl extends AbstractServiceImpl<Inscription, InscriptionCriteria, InscriptionDao> implements InscriptionAdminService {






    public void findOrSaveAssociatedObject(Inscription t){
        if( t != null) {
            t.setEtudiant(etudiantService.findOrSave(t.getEtudiant()));
            t.setEtatInscription(etatInscriptionService.findOrSave(t.getEtatInscription()));
            t.setParcours(parcoursService.findOrSave(t.getParcours()));
            t.setGroupeEtude(groupeEtudeService.findOrSave(t.getGroupeEtude()));
            t.setGroupeType(groupeTypeService.findOrSave(t.getGroupeType()));
            t.setStatutSocial(statutSocialService.findOrSave(t.getStatutSocial()));
            t.setInteretEtudiant(interetEtudiantService.findOrSave(t.getInteretEtudiant()));
            t.setNiveauEtude(niveauEtudeService.findOrSave(t.getNiveauEtude()));
            t.setFonction(fonctionService.findOrSave(t.getFonction()));
            t.setQuiz(quizService.findOrSave(t.getQuiz()));
            t.setPackStudent(packStudentService.findOrSave(t.getPackStudent()));
            t.setSkill(skillService.findOrSave(t.getSkill()));
        }
    }

    public List<Inscription> findByEtudiantId(Long id){
        return dao.findByEtudiantId(id);
    }
    public int deleteByEtudiantId(Long id){
        return dao.deleteByEtudiantId(id);
    }
    public long countByEtudiantRef(String ref){
        return dao.countByEtudiantRef(ref);
    }
    public List<Inscription> findByEtatInscriptionId(Long id){
        return dao.findByEtatInscriptionId(id);
    }
    public int deleteByEtatInscriptionId(Long id){
        return dao.deleteByEtatInscriptionId(id);
    }
    public long countByEtatInscriptionLibelle(String libelle){
        return dao.countByEtatInscriptionLibelle(libelle);
    }
    public List<Inscription> findByParcoursId(Long id){
        return dao.findByParcoursId(id);
    }
    public int deleteByParcoursId(Long id){
        return dao.deleteByParcoursId(id);
    }
    public long countByParcoursCode(String code){
        return dao.countByParcoursCode(code);
    }
    public List<Inscription> findByGroupeEtudeId(Long id){
        return dao.findByGroupeEtudeId(id);
    }
    public int deleteByGroupeEtudeId(Long id){
        return dao.deleteByGroupeEtudeId(id);
    }
    public long countByGroupeEtudeId(Long id){
        return dao.countByGroupeEtudeId(id);
    }
    public List<Inscription> findByGroupeTypeId(Long id){
        return dao.findByGroupeTypeId(id);
    }
    public int deleteByGroupeTypeId(Long id){
        return dao.deleteByGroupeTypeId(id);
    }
    public long countByGroupeTypeCode(String code){
        return dao.countByGroupeTypeCode(code);
    }
    public List<Inscription> findByStatutSocialId(Long id){
        return dao.findByStatutSocialId(id);
    }
    public int deleteByStatutSocialId(Long id){
        return dao.deleteByStatutSocialId(id);
    }
    public long countByStatutSocialCode(String code){
        return dao.countByStatutSocialCode(code);
    }
    public List<Inscription> findByInteretEtudiantId(Long id){
        return dao.findByInteretEtudiantId(id);
    }
    public int deleteByInteretEtudiantId(Long id){
        return dao.deleteByInteretEtudiantId(id);
    }
    public long countByInteretEtudiantCode(String code){
        return dao.countByInteretEtudiantCode(code);
    }
    public List<Inscription> findByNiveauEtudeId(Long id){
        return dao.findByNiveauEtudeId(id);
    }
    public int deleteByNiveauEtudeId(Long id){
        return dao.deleteByNiveauEtudeId(id);
    }
    public long countByNiveauEtudeCode(String code){
        return dao.countByNiveauEtudeCode(code);
    }
    public List<Inscription> findByFonctionId(Long id){
        return dao.findByFonctionId(id);
    }
    public int deleteByFonctionId(Long id){
        return dao.deleteByFonctionId(id);
    }
    public long countByFonctionCode(String code){
        return dao.countByFonctionCode(code);
    }
    public List<Inscription> findByQuizId(Long id){
        return dao.findByQuizId(id);
    }
    public int deleteByQuizId(Long id){
        return dao.deleteByQuizId(id);
    }
    public long countByQuizRef(String ref){
        return dao.countByQuizRef(ref);
    }
    public List<Inscription> findByPackStudentId(Long id){
        return dao.findByPackStudentId(id);
    }
    public int deleteByPackStudentId(Long id){
        return dao.deleteByPackStudentId(id);
    }
    public long countByPackStudentCode(String code){
        return dao.countByPackStudentCode(code);
    }
    public List<Inscription> findBySkillId(Long id){
        return dao.findBySkillId(id);
    }
    public int deleteBySkillId(Long id){
        return dao.deleteBySkillId(id);
    }
    public long countBySkillCode(String code){
        return dao.countBySkillCode(code);
    }






    public void configure() {
        super.configure(Inscription.class, InscriptionSpecification.class);
    }


    @Autowired
    private ParcoursAdminService parcoursService ;
    @Autowired
    private QuizAdminService quizService ;
    @Autowired
    private SkillAdminService skillService ;
    @Autowired
    private InteretEtudiantAdminService interetEtudiantService ;
    @Autowired
    private FonctionAdminService fonctionService ;
    @Autowired
    private EtudiantAdminService etudiantService ;
    @Autowired
    private EtatInscriptionAdminService etatInscriptionService ;
    @Autowired
    private GroupeTypeAdminService groupeTypeService ;
    @Autowired
    private StatutSocialAdminService statutSocialService ;
    @Autowired
    private PackStudentAdminService packStudentService ;
    @Autowired
    private GroupeEtudeAdminService groupeEtudeService ;
    @Autowired
    private NiveauEtudeAdminService niveauEtudeService ;

    public InscriptionAdminServiceImpl(InscriptionDao dao) {
        super(dao);
    }

}
