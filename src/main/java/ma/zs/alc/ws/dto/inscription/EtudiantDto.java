package  ma.zs.alc.ws.dto.inscription;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import ma.zs.alc.zynerator.security.bean.Role;
import java.util.Collection;
import java.util.List;


import ma.zs.alc.ws.dto.course.ParcoursDto;
import ma.zs.alc.ws.dto.quizetudiant.QuizEtudiantDto;
import ma.zs.alc.ws.dto.inscriptionref.EtatEtudiantScheduleDto;
import ma.zs.alc.ws.dto.inscriptionref.InteretEtudiantDto;
import ma.zs.alc.ws.dto.inscriptionref.StatutSocialDto;
import ma.zs.alc.ws.dto.grpe.GroupeEtudiantDto;
import ma.zs.alc.ws.dto.inscriptionref.LangueDto;
import ma.zs.alc.ws.dto.quizetudiant.ReponseEtudiantDto;
import ma.zs.alc.ws.dto.grpe.GroupeEtudeDto;
import ma.zs.alc.ws.dto.quiz.QuizDto;
import ma.zs.alc.ws.dto.inscriptionref.SkillDto;
import ma.zs.alc.ws.dto.inscriptionref.FonctionDto;
import ma.zs.alc.ws.dto.grpe.GroupeEtudiantDetailDto;
import ma.zs.alc.ws.dto.pack.PackStudentDto;
import ma.zs.alc.ws.dto.inscriptionref.TeacherLocalityDto;
import ma.zs.alc.ws.dto.inscriptionref.NiveauEtudeDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class EtudiantDto  extends AuditBaseDto {

    private String ref  ;
    private String groupOption  ;
    private Boolean credentialsNonExpired  ;
    private Boolean enabled  ;
    private Boolean accountNonExpired  ;
    private Boolean accountNonLocked  ;
    private Boolean passwordChanged  ;
    private String username  ;
    private String password  ;

    private TeacherLocalityDto teacherLocality ;
    private EtatEtudiantScheduleDto etatEtudiantSchedule ;
    private ParcoursDto parcours ;
    private GroupeEtudeDto groupeEtude ;
    private PackStudentDto packStudent ;
    private StatutSocialDto statutSocial ;
    private InteretEtudiantDto interetEtudiant ;
    private NiveauEtudeDto niveauEtude ;
    private SkillDto skill ;
    private FonctionDto fonction ;
    private LangueDto langue ;

    private List<QuizEtudiantDto> quizEtudiants ;
    private List<GroupeEtudiantDetailDto> groupeEtudiantDetails ;


    private Collection<Role> roles;
    public EtudiantDto(){
        super();
    }



    @Log
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }

    @Log
    public String getGroupOption(){
        return this.groupOption;
    }
    public void setGroupOption(String groupOption){
        this.groupOption = groupOption;
    }

    @Log
    public Boolean getCredentialsNonExpired(){
        return this.credentialsNonExpired;
    }
    public void setCredentialsNonExpired(Boolean credentialsNonExpired){
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Log
    public Boolean getEnabled(){
        return this.enabled;
    }
    public void setEnabled(Boolean enabled){
        this.enabled = enabled;
    }

    @Log
    public Boolean getAccountNonExpired(){
        return this.accountNonExpired;
    }
    public void setAccountNonExpired(Boolean accountNonExpired){
        this.accountNonExpired = accountNonExpired;
    }

    @Log
    public Boolean getAccountNonLocked(){
        return this.accountNonLocked;
    }
    public void setAccountNonLocked(Boolean accountNonLocked){
        this.accountNonLocked = accountNonLocked;
    }

    @Log
    public Boolean getPasswordChanged(){
        return this.passwordChanged;
    }
    public void setPasswordChanged(Boolean passwordChanged){
        this.passwordChanged = passwordChanged;
    }

    @Log
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    @Log
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }


    public TeacherLocalityDto getTeacherLocality(){
        return this.teacherLocality;
    }

    public void setTeacherLocality(TeacherLocalityDto teacherLocality){
        this.teacherLocality = teacherLocality;
    }
    public EtatEtudiantScheduleDto getEtatEtudiantSchedule(){
        return this.etatEtudiantSchedule;
    }

    public void setEtatEtudiantSchedule(EtatEtudiantScheduleDto etatEtudiantSchedule){
        this.etatEtudiantSchedule = etatEtudiantSchedule;
    }
    public ParcoursDto getParcours(){
        return this.parcours;
    }

    public void setParcours(ParcoursDto parcours){
        this.parcours = parcours;
    }
    public GroupeEtudeDto getGroupeEtude(){
        return this.groupeEtude;
    }

    public void setGroupeEtude(GroupeEtudeDto groupeEtude){
        this.groupeEtude = groupeEtude;
    }
    public PackStudentDto getPackStudent(){
        return this.packStudent;
    }

    public void setPackStudent(PackStudentDto packStudent){
        this.packStudent = packStudent;
    }
    public StatutSocialDto getStatutSocial(){
        return this.statutSocial;
    }

    public void setStatutSocial(StatutSocialDto statutSocial){
        this.statutSocial = statutSocial;
    }
    public InteretEtudiantDto getInteretEtudiant(){
        return this.interetEtudiant;
    }

    public void setInteretEtudiant(InteretEtudiantDto interetEtudiant){
        this.interetEtudiant = interetEtudiant;
    }
    public NiveauEtudeDto getNiveauEtude(){
        return this.niveauEtude;
    }

    public void setNiveauEtude(NiveauEtudeDto niveauEtude){
        this.niveauEtude = niveauEtude;
    }
    public SkillDto getSkill(){
        return this.skill;
    }

    public void setSkill(SkillDto skill){
        this.skill = skill;
    }
    public FonctionDto getFonction(){
        return this.fonction;
    }

    public void setFonction(FonctionDto fonction){
        this.fonction = fonction;
    }
    public LangueDto getLangue(){
        return this.langue;
    }

    public void setLangue(LangueDto langue){
        this.langue = langue;
    }



    public List<QuizEtudiantDto> getQuizEtudiants(){
        return this.quizEtudiants;
    }

    public void setQuizEtudiants(List<QuizEtudiantDto> quizEtudiants){
        this.quizEtudiants = quizEtudiants;
    }
    public List<GroupeEtudiantDetailDto> getGroupeEtudiantDetails(){
        return this.groupeEtudiantDetails;
    }

    public void setGroupeEtudiantDetails(List<GroupeEtudiantDetailDto> groupeEtudiantDetails){
        this.groupeEtudiantDetails = groupeEtudiantDetails;
    }




    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
