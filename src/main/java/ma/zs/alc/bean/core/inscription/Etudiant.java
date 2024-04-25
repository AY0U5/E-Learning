package ma.zs.alc.bean.core.inscription;

import java.util.Objects;
import java.util.List;





import ma.zs.alc.bean.core.course.Parcours;
import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant;
import ma.zs.alc.bean.core.inscriptionref.EtatEtudiantSchedule;
import ma.zs.alc.bean.core.inscriptionref.InteretEtudiant;
import ma.zs.alc.bean.core.inscriptionref.StatutSocial;
import ma.zs.alc.bean.core.grpe.GroupeEtudiant;
import ma.zs.alc.bean.core.inscriptionref.Langue;
import ma.zs.alc.bean.core.quizetudiant.ReponseEtudiant;
import ma.zs.alc.bean.core.grpe.GroupeEtude;
import ma.zs.alc.bean.core.quiz.Quiz;
import ma.zs.alc.bean.core.inscriptionref.Skill;
import ma.zs.alc.bean.core.inscriptionref.Fonction;
import ma.zs.alc.bean.core.grpe.GroupeEtudiantDetail;
import ma.zs.alc.bean.core.pack.PackStudent;
import ma.zs.alc.bean.core.inscriptionref.TeacherLocality;
import ma.zs.alc.bean.core.inscriptionref.NiveauEtude;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;



import ma.zs.alc.zynerator.security.bean.User;

@Entity
@Table(name = "etudiant")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Etudiant  extends User    {


    public Etudiant(String username) {
        super(username);
    }
    @Column(length = 500)
    private String ref;
    @Column(length = 500)
    private String groupOption;
    @Column(columnDefinition = "boolean default false")
    private boolean credentialsNonExpired = false;
    @Column(columnDefinition = "boolean default false")
    private boolean enabled = false;
    @Column(columnDefinition = "boolean default false")
    private boolean accountNonExpired = false;
    @Column(columnDefinition = "boolean default false")
    private boolean accountNonLocked = false;
    @Column(columnDefinition = "boolean default false")
    private boolean passwordChanged = false;
    @Column(length = 500)
    private String username;
    @Column(length = 500)
    private String password;

    private TeacherLocality teacherLocality ;
    private EtatEtudiantSchedule etatEtudiantSchedule ;
    private Parcours parcours ;
    private GroupeEtude groupeEtude ;
    private PackStudent packStudent ;
    private StatutSocial statutSocial ;
    private InteretEtudiant interetEtudiant ;
    private NiveauEtude niveauEtude ;
    private Skill skill ;
    private Fonction fonction ;
    private Langue langue ;

    private List<QuizEtudiant> quizEtudiants ;
    private List<GroupeEtudiantDetail> groupeEtudiantDetails ;

    public Etudiant(){
        super();
    }

    public Etudiant(Long id){
        this.id = id;
    }

    public Etudiant(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_locality")
    public TeacherLocality getTeacherLocality(){
        return this.teacherLocality;
    }
    public void setTeacherLocality(TeacherLocality teacherLocality){
        this.teacherLocality = teacherLocality;
    }
    public String getGroupOption(){
        return this.groupOption;
    }
    public void setGroupOption(String groupOption){
        this.groupOption = groupOption;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etat_etudiant_schedule")
    public EtatEtudiantSchedule getEtatEtudiantSchedule(){
        return this.etatEtudiantSchedule;
    }
    public void setEtatEtudiantSchedule(EtatEtudiantSchedule etatEtudiantSchedule){
        this.etatEtudiantSchedule = etatEtudiantSchedule;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parcours")
    public Parcours getParcours(){
        return this.parcours;
    }
    public void setParcours(Parcours parcours){
        this.parcours = parcours;
    }
    @OneToMany(mappedBy = "etudiant")

    public List<QuizEtudiant> getQuizEtudiants(){
        return this.quizEtudiants;
    }
    public void setQuizEtudiants(List<QuizEtudiant> quizEtudiants){
        this.quizEtudiants = quizEtudiants;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupe_etude")
    public GroupeEtude getGroupeEtude(){
        return this.groupeEtude;
    }
    public void setGroupeEtude(GroupeEtude groupeEtude){
        this.groupeEtude = groupeEtude;
    }
    @OneToMany(mappedBy = "etudiant")

    public List<GroupeEtudiantDetail> getGroupeEtudiantDetails(){
        return this.groupeEtudiantDetails;
    }
    public void setGroupeEtudiantDetails(List<GroupeEtudiantDetail> groupeEtudiantDetails){
        this.groupeEtudiantDetails = groupeEtudiantDetails;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pack_student")
    public PackStudent getPackStudent(){
        return this.packStudent;
    }
    public void setPackStudent(PackStudent packStudent){
        this.packStudent = packStudent;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statut_social")
    public StatutSocial getStatutSocial(){
        return this.statutSocial;
    }
    public void setStatutSocial(StatutSocial statutSocial){
        this.statutSocial = statutSocial;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interet_etudiant")
    public InteretEtudiant getInteretEtudiant(){
        return this.interetEtudiant;
    }
    public void setInteretEtudiant(InteretEtudiant interetEtudiant){
        this.interetEtudiant = interetEtudiant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "niveau_etude")
    public NiveauEtude getNiveauEtude(){
        return this.niveauEtude;
    }
    public void setNiveauEtude(NiveauEtude niveauEtude){
        this.niveauEtude = niveauEtude;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill")
    public Skill getSkill(){
        return this.skill;
    }
    public void setSkill(Skill skill){
        this.skill = skill;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fonction")
    public Fonction getFonction(){
        return this.fonction;
    }
    public void setFonction(Fonction fonction){
        this.fonction = fonction;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "langue")
    public Langue getLangue(){
        return this.langue;
    }
    public void setLangue(Langue langue){
        this.langue = langue;
    }
    public boolean  getCredentialsNonExpired(){
        return this.credentialsNonExpired;
    }
    public void setCredentialsNonExpired(boolean credentialsNonExpired){
        this.credentialsNonExpired = credentialsNonExpired;
    }
    public boolean  getEnabled(){
        return this.enabled;
    }
    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }
    public boolean  getAccountNonExpired(){
        return this.accountNonExpired;
    }
    public void setAccountNonExpired(boolean accountNonExpired){
        this.accountNonExpired = accountNonExpired;
    }
    public boolean  getAccountNonLocked(){
        return this.accountNonLocked;
    }
    public void setAccountNonLocked(boolean accountNonLocked){
        this.accountNonLocked = accountNonLocked;
    }
    public boolean  getPasswordChanged(){
        return this.passwordChanged;
    }
    public void setPasswordChanged(boolean passwordChanged){
        this.passwordChanged = passwordChanged;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    @Transient
    public String getLabel() {
        label = ref;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return id != null && id.equals(etudiant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

