package ma.zs.alc.bean.core.prof;

import java.util.Objects;
import java.util.List;





import ma.zs.alc.bean.core.course.Parcours;
import ma.zs.alc.bean.core.quiz.Quiz;
import ma.zs.alc.bean.core.inscriptionref.EtudiantClassRoom;
import ma.zs.alc.bean.core.prof.TypeTeacher;
import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.bean.core.recomrecla.RecommendTeacher;
import ma.zs.alc.bean.core.prof.CategorieProf;
import ma.zs.alc.bean.core.quiz.QuizClassRoom;
import ma.zs.alc.bean.core.prof.TrancheHoraireProf;
import ma.zs.alc.bean.core.classroom.ClassRoom;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;



import ma.zs.alc.zynerator.security.bean.User;

@Entity
@Table(name = "prof")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Prof  extends User    {


    public Prof(String username) {
        super(username);
    }
    @Column(length = 500)
    private String ref;
    @Column(length = 500)
    private String about;
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

    private Parcours parcours ;
    private CategorieProf categorieProf ;
    private TypeTeacher typeTeacher ;

    private List<TrancheHoraireProf> trancheHoraireProfs ;
    private List<ClassRoom> classRooms ;
    private List<RecommendTeacher> recommendTeachers ;

    public Prof(){
        super();
    }

    public Prof(Long id){
        this.id = id;
    }

    public Prof(Long id,String ref){
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
    public String getAbout(){
        return this.about;
    }
    public void setAbout(String about){
        this.about = about;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parcours")
    public Parcours getParcours(){
        return this.parcours;
    }
    public void setParcours(Parcours parcours){
        this.parcours = parcours;
    }
    @OneToMany(mappedBy = "prof")

    public List<TrancheHoraireProf> getTrancheHoraireProfs(){
        return this.trancheHoraireProfs;
    }
    public void setTrancheHoraireProfs(List<TrancheHoraireProf> trancheHoraireProfs){
        this.trancheHoraireProfs = trancheHoraireProfs;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_prof")
    public CategorieProf getCategorieProf(){
        return this.categorieProf;
    }
    public void setCategorieProf(CategorieProf categorieProf){
        this.categorieProf = categorieProf;
    }
    @OneToMany(mappedBy = "prof")

    public List<ClassRoom> getClassRooms(){
        return this.classRooms;
    }
    public void setClassRooms(List<ClassRoom> classRooms){
        this.classRooms = classRooms;
    }
    @OneToMany(mappedBy = "prof")

    public List<RecommendTeacher> getRecommendTeachers(){
        return this.recommendTeachers;
    }
    public void setRecommendTeachers(List<RecommendTeacher> recommendTeachers){
        this.recommendTeachers = recommendTeachers;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_teacher")
    public TypeTeacher getTypeTeacher(){
        return this.typeTeacher;
    }
    public void setTypeTeacher(TypeTeacher typeTeacher){
        this.typeTeacher = typeTeacher;
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
        Prof prof = (Prof) o;
        return id != null && id.equals(prof.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

