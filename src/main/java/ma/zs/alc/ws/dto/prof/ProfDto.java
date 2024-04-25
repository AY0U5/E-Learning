package  ma.zs.alc.ws.dto.prof;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import ma.zs.alc.zynerator.security.bean.Role;
import java.util.Collection;
import java.util.List;


import ma.zs.alc.ws.dto.course.ParcoursDto;
import ma.zs.alc.ws.dto.quiz.QuizDto;
import ma.zs.alc.ws.dto.inscriptionref.EtudiantClassRoomDto;
import ma.zs.alc.ws.dto.inscription.EtudiantDto;
import ma.zs.alc.ws.dto.recomrecla.RecommendTeacherDto;
import ma.zs.alc.ws.dto.quiz.QuizClassRoomDto;
import ma.zs.alc.ws.dto.classroom.ClassRoomDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfDto  extends AuditBaseDto {

    private String ref  ;
    private String about  ;
    private Boolean credentialsNonExpired  ;
    private Boolean enabled  ;
    private Boolean accountNonExpired  ;
    private Boolean accountNonLocked  ;
    private Boolean passwordChanged  ;
    private String username  ;
    private String password  ;

    private ParcoursDto parcours ;
    private CategorieProfDto categorieProf ;
    private TypeTeacherDto typeTeacher ;

    private List<TrancheHoraireProfDto> trancheHoraireProfs ;
    private List<ClassRoomDto> classRooms ;
    private List<RecommendTeacherDto> recommendTeachers ;


    private Collection<Role> roles;
    public ProfDto(){
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
    public String getAbout(){
        return this.about;
    }
    public void setAbout(String about){
        this.about = about;
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


    public ParcoursDto getParcours(){
        return this.parcours;
    }

    public void setParcours(ParcoursDto parcours){
        this.parcours = parcours;
    }
    public CategorieProfDto getCategorieProf(){
        return this.categorieProf;
    }

    public void setCategorieProf(CategorieProfDto categorieProf){
        this.categorieProf = categorieProf;
    }
    public TypeTeacherDto getTypeTeacher(){
        return this.typeTeacher;
    }

    public void setTypeTeacher(TypeTeacherDto typeTeacher){
        this.typeTeacher = typeTeacher;
    }



    public List<TrancheHoraireProfDto> getTrancheHoraireProfs(){
        return this.trancheHoraireProfs;
    }

    public void setTrancheHoraireProfs(List<TrancheHoraireProfDto> trancheHoraireProfs){
        this.trancheHoraireProfs = trancheHoraireProfs;
    }
    public List<ClassRoomDto> getClassRooms(){
        return this.classRooms;
    }

    public void setClassRooms(List<ClassRoomDto> classRooms){
        this.classRooms = classRooms;
    }
    public List<RecommendTeacherDto> getRecommendTeachers(){
        return this.recommendTeachers;
    }

    public void setRecommendTeachers(List<RecommendTeacherDto> recommendTeachers){
        this.recommendTeachers = recommendTeachers;
    }




    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
