package  ma.zs.alc.dao.criteria.core.prof;


import ma.zs.alc.dao.criteria.core.course.ParcoursCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ProfCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String about;
    private String aboutLike;
    private Boolean credentialsNonExpired;
    private Boolean enabled;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean passwordChanged;
    private String username;
    private String usernameLike;
    private String password;
    private String passwordLike;

    private ParcoursCriteria parcours ;
    private List<ParcoursCriteria> parcourss ;
    private CategorieProfCriteria categorieProf ;
    private List<CategorieProfCriteria> categorieProfs ;
    private TypeTeacherCriteria typeTeacher ;
    private List<TypeTeacherCriteria> typeTeachers ;


    public ProfCriteria(){}

    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public String getRefLike(){
        return this.refLike;
    }
    public void setRefLike(String refLike){
        this.refLike = refLike;
    }

    public String getAbout(){
        return this.about;
    }
    public void setAbout(String about){
        this.about = about;
    }
    public String getAboutLike(){
        return this.aboutLike;
    }
    public void setAboutLike(String aboutLike){
        this.aboutLike = aboutLike;
    }

    public Boolean getCredentialsNonExpired(){
        return this.credentialsNonExpired;
    }
    public void setCredentialsNonExpired(Boolean credentialsNonExpired){
        this.credentialsNonExpired = credentialsNonExpired;
    }
    public Boolean getEnabled(){
        return this.enabled;
    }
    public void setEnabled(Boolean enabled){
        this.enabled = enabled;
    }
    public Boolean getAccountNonExpired(){
        return this.accountNonExpired;
    }
    public void setAccountNonExpired(Boolean accountNonExpired){
        this.accountNonExpired = accountNonExpired;
    }
    public Boolean getAccountNonLocked(){
        return this.accountNonLocked;
    }
    public void setAccountNonLocked(Boolean accountNonLocked){
        this.accountNonLocked = accountNonLocked;
    }
    public Boolean getPasswordChanged(){
        return this.passwordChanged;
    }
    public void setPasswordChanged(Boolean passwordChanged){
        this.passwordChanged = passwordChanged;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsernameLike(){
        return this.usernameLike;
    }
    public void setUsernameLike(String usernameLike){
        this.usernameLike = usernameLike;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPasswordLike(){
        return this.passwordLike;
    }
    public void setPasswordLike(String passwordLike){
        this.passwordLike = passwordLike;
    }


    public ParcoursCriteria getParcours(){
        return this.parcours;
    }

    public void setParcours(ParcoursCriteria parcours){
        this.parcours = parcours;
    }
    public List<ParcoursCriteria> getParcourss(){
        return this.parcourss;
    }

    public void setParcourss(List<ParcoursCriteria> parcourss){
        this.parcourss = parcourss;
    }
    public CategorieProfCriteria getCategorieProf(){
        return this.categorieProf;
    }

    public void setCategorieProf(CategorieProfCriteria categorieProf){
        this.categorieProf = categorieProf;
    }
    public List<CategorieProfCriteria> getCategorieProfs(){
        return this.categorieProfs;
    }

    public void setCategorieProfs(List<CategorieProfCriteria> categorieProfs){
        this.categorieProfs = categorieProfs;
    }
    public TypeTeacherCriteria getTypeTeacher(){
        return this.typeTeacher;
    }

    public void setTypeTeacher(TypeTeacherCriteria typeTeacher){
        this.typeTeacher = typeTeacher;
    }
    public List<TypeTeacherCriteria> getTypeTeachers(){
        return this.typeTeachers;
    }

    public void setTypeTeachers(List<TypeTeacherCriteria> typeTeachers){
        this.typeTeachers = typeTeachers;
    }
}
