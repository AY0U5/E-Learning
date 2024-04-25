package ma.zs.alc.service.impl.admin.inscription;


import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.dao.criteria.core.inscription.EtudiantCriteria;
import ma.zs.alc.dao.facade.core.inscription.EtudiantDao;
import ma.zs.alc.dao.specification.core.inscription.EtudiantSpecification;
import ma.zs.alc.service.facade.admin.inscription.EtudiantAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.service.Attribute;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.alc.service.facade.admin.course.ParcoursAdminService ;
import ma.zs.alc.bean.core.course.Parcours ;
import ma.zs.alc.service.facade.admin.quizetudiant.QuizEtudiantAdminService ;
import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant ;
import ma.zs.alc.service.facade.admin.inscriptionref.EtatEtudiantScheduleAdminService ;
import ma.zs.alc.bean.core.inscriptionref.EtatEtudiantSchedule ;
import ma.zs.alc.service.facade.admin.inscriptionref.InteretEtudiantAdminService ;
import ma.zs.alc.bean.core.inscriptionref.InteretEtudiant ;
import ma.zs.alc.service.facade.admin.inscriptionref.StatutSocialAdminService ;
import ma.zs.alc.bean.core.inscriptionref.StatutSocial ;
import ma.zs.alc.service.facade.admin.inscriptionref.LangueAdminService ;
import ma.zs.alc.bean.core.inscriptionref.Langue ;
import ma.zs.alc.service.facade.admin.grpe.GroupeEtudeAdminService ;
import ma.zs.alc.bean.core.grpe.GroupeEtude ;
import ma.zs.alc.service.facade.admin.inscriptionref.SkillAdminService ;
import ma.zs.alc.bean.core.inscriptionref.Skill ;
import ma.zs.alc.service.facade.admin.inscriptionref.FonctionAdminService ;
import ma.zs.alc.bean.core.inscriptionref.Fonction ;
import ma.zs.alc.service.facade.admin.grpe.GroupeEtudiantDetailAdminService ;
import ma.zs.alc.bean.core.grpe.GroupeEtudiantDetail ;
import ma.zs.alc.service.facade.admin.pack.PackStudentAdminService ;
import ma.zs.alc.bean.core.pack.PackStudent ;
import ma.zs.alc.service.facade.admin.inscriptionref.TeacherLocalityAdminService ;
import ma.zs.alc.bean.core.inscriptionref.TeacherLocality ;
import ma.zs.alc.service.facade.admin.inscriptionref.NiveauEtudeAdminService ;
import ma.zs.alc.bean.core.inscriptionref.NiveauEtude ;

import ma.zs.alc.zynerator.security.service.facade.UserService;
import ma.zs.alc.zynerator.security.service.facade.RoleService;
import ma.zs.alc.zynerator.security.bean.Role;
import java.util.Collection;
import java.util.List;
@Service
public class EtudiantAdminServiceImpl extends AbstractServiceImpl<Etudiant, EtudiantCriteria, EtudiantDao> implements EtudiantAdminService {
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("ref"));


    ATTRIBUTES.add(new Attribute("groupOption"));













    ATTRIBUTES.add(new Attribute("credentialsNonExpired","Boolean"));

    ATTRIBUTES.add(new Attribute("enabled","Boolean"));

    ATTRIBUTES.add(new Attribute("accountNonExpired","Boolean"));

    ATTRIBUTES.add(new Attribute("accountNonLocked","Boolean"));

    ATTRIBUTES.add(new Attribute("passwordChanged","Boolean"));

    ATTRIBUTES.add(new Attribute("username"));

    ATTRIBUTES.add(new Attribute("password"));
    }






    public Etudiant findByReferenceEntity(Etudiant t){
        return t==null? null : dao.findByRef(t.getRef());
    }
    public void findOrSaveAssociatedObject(Etudiant t){
        if( t != null) {
            t.setTeacherLocality(teacherLocalityService.findOrSave(t.getTeacherLocality()));
            t.setEtatEtudiantSchedule(etatEtudiantScheduleService.findOrSave(t.getEtatEtudiantSchedule()));
            t.setParcours(parcoursService.findOrSave(t.getParcours()));
            t.setGroupeEtude(groupeEtudeService.findOrSave(t.getGroupeEtude()));
            t.setPackStudent(packStudentService.findOrSave(t.getPackStudent()));
            t.setStatutSocial(statutSocialService.findOrSave(t.getStatutSocial()));
            t.setInteretEtudiant(interetEtudiantService.findOrSave(t.getInteretEtudiant()));
            t.setNiveauEtude(niveauEtudeService.findOrSave(t.getNiveauEtude()));
            t.setSkill(skillService.findOrSave(t.getSkill()));
            t.setFonction(fonctionService.findOrSave(t.getFonction()));
            t.setLangue(langueService.findOrSave(t.getLangue()));
        }
    }

    public List<Etudiant> findByTeacherLocalityId(Long id){
        return dao.findByTeacherLocalityId(id);
    }
    public int deleteByTeacherLocalityId(Long id){
        return dao.deleteByTeacherLocalityId(id);
    }
    public long countByTeacherLocalityCode(String code){
        return dao.countByTeacherLocalityCode(code);
    }
    public List<Etudiant> findByEtatEtudiantScheduleId(Long id){
        return dao.findByEtatEtudiantScheduleId(id);
    }
    public int deleteByEtatEtudiantScheduleId(Long id){
        return dao.deleteByEtatEtudiantScheduleId(id);
    }
    public long countByEtatEtudiantScheduleLibelle(String libelle){
        return dao.countByEtatEtudiantScheduleLibelle(libelle);
    }
    public List<Etudiant> findByParcoursId(Long id){
        return dao.findByParcoursId(id);
    }
    public int deleteByParcoursId(Long id){
        return dao.deleteByParcoursId(id);
    }
    public long countByParcoursCode(String code){
        return dao.countByParcoursCode(code);
    }
    public List<Etudiant> findByGroupeEtudeId(Long id){
        return dao.findByGroupeEtudeId(id);
    }
    public int deleteByGroupeEtudeId(Long id){
        return dao.deleteByGroupeEtudeId(id);
    }
    public long countByGroupeEtudeId(Long id){
        return dao.countByGroupeEtudeId(id);
    }
    public List<Etudiant> findByPackStudentId(Long id){
        return dao.findByPackStudentId(id);
    }
    public int deleteByPackStudentId(Long id){
        return dao.deleteByPackStudentId(id);
    }
    public long countByPackStudentCode(String code){
        return dao.countByPackStudentCode(code);
    }
    public List<Etudiant> findByStatutSocialId(Long id){
        return dao.findByStatutSocialId(id);
    }
    public int deleteByStatutSocialId(Long id){
        return dao.deleteByStatutSocialId(id);
    }
    public long countByStatutSocialCode(String code){
        return dao.countByStatutSocialCode(code);
    }
    public List<Etudiant> findByInteretEtudiantId(Long id){
        return dao.findByInteretEtudiantId(id);
    }
    public int deleteByInteretEtudiantId(Long id){
        return dao.deleteByInteretEtudiantId(id);
    }
    public long countByInteretEtudiantCode(String code){
        return dao.countByInteretEtudiantCode(code);
    }
    public List<Etudiant> findByNiveauEtudeId(Long id){
        return dao.findByNiveauEtudeId(id);
    }
    public int deleteByNiveauEtudeId(Long id){
        return dao.deleteByNiveauEtudeId(id);
    }
    public long countByNiveauEtudeCode(String code){
        return dao.countByNiveauEtudeCode(code);
    }
    public List<Etudiant> findBySkillId(Long id){
        return dao.findBySkillId(id);
    }
    public int deleteBySkillId(Long id){
        return dao.deleteBySkillId(id);
    }
    public long countBySkillCode(String code){
        return dao.countBySkillCode(code);
    }
    public List<Etudiant> findByFonctionId(Long id){
        return dao.findByFonctionId(id);
    }
    public int deleteByFonctionId(Long id){
        return dao.deleteByFonctionId(id);
    }
    public long countByFonctionCode(String code){
        return dao.countByFonctionCode(code);
    }
    public List<Etudiant> findByLangueId(Long id){
        return dao.findByLangueId(id);
    }
    public int deleteByLangueId(Long id){
        return dao.deleteByLangueId(id);
    }
    public long countByLangueLibelle(String libelle){
        return dao.countByLangueLibelle(libelle);
    }

    public List<Etudiant> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }


    @Override
    public Etudiant create(Etudiant t) {
        if (findByUsername(t.getUsername()) != null || t.getPassword() == null) return null;
        t.setPassword(userService.cryptPassword(t.getPassword()));
        t.setEnabled(true);
        t.setAccountNonExpired(true);
        t.setAccountNonLocked(true);
        t.setCredentialsNonExpired(true);
        t.setPasswordChanged(false);
        /*if (t.getRoles() != null) {
            Collection<Role> roles = new ArrayList<Role>();
            for (Role role : t.getRoles()) {
                roles.add(roleService.save(role));
            }
            t.setRoles(roles);
        }*/
        Etudiant mySaved = super.create(t);

        if (t.getQuizEtudiants() != null) {
        t.getQuizEtudiants().forEach(element-> {
            element.setEtudiant(mySaved);
            quizEtudiantService.create(element);
        });
        }
        if (t.getGroupeEtudiantDetails() != null) {
        t.getGroupeEtudiantDetails().forEach(element-> {
            element.setEtudiant(mySaved);
            groupeEtudiantDetailService.create(element);
        });
        }
        return mySaved;
     }

    public Etudiant findByUsername(String username){
    return dao.findByUsername(username);
    }

    public boolean changePassword(String username, String newPassword) {
    return userService.changePassword(username, newPassword);
    }

    public void configure() {
        super.configure(Etudiant.class, EtudiantSpecification.class);
    }

    @Autowired
    private UserService userService;


    @Autowired
    private RoleService roleService;

    @Autowired
    private ParcoursAdminService parcoursService ;
    @Autowired
    private QuizEtudiantAdminService quizEtudiantService ;
    @Autowired
    private EtatEtudiantScheduleAdminService etatEtudiantScheduleService ;
    @Autowired
    private InteretEtudiantAdminService interetEtudiantService ;
    @Autowired
    private StatutSocialAdminService statutSocialService ;
    @Autowired
    private LangueAdminService langueService ;
    @Autowired
    private GroupeEtudeAdminService groupeEtudeService ;
    @Autowired
    private SkillAdminService skillService ;
    @Autowired
    private FonctionAdminService fonctionService ;
    @Autowired
    private GroupeEtudiantDetailAdminService groupeEtudiantDetailService ;
    @Autowired
    private PackStudentAdminService packStudentService ;
    @Autowired
    private TeacherLocalityAdminService teacherLocalityService ;
    @Autowired
    private NiveauEtudeAdminService niveauEtudeService ;

    public EtudiantAdminServiceImpl(EtudiantDao dao) {
        super(dao);
    }

}
