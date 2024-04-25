package ma.zs.alc.bean.core.homework;

import java.util.Objects;
import java.util.List;





import ma.zs.alc.bean.core.homework.HoweWorkQSTReponse;
import ma.zs.alc.bean.core.quizref.TypeDeQuestion;
import ma.zs.alc.bean.core.homework.HomeWorkEtudiant;
import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.bean.core.homework.ReponseEtudiantHomeWork;
import ma.zs.alc.bean.core.homework.HomeWorkQuestion;
import ma.zs.alc.bean.core.homework.TypeHomeWork;
import ma.zs.alc.bean.core.course.Cours;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "home_work")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class HomeWork   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String urlImage;
    @Column(length = 500)
    private String urlVideo;

    private Cours cours ;
    private TypeHomeWork typeHomeWork ;

    private List<HomeWorkQuestion> homeWorkQuestions ;
    private List<HomeWorkEtudiant> homeWorkEtudiants ;

    public HomeWork(){
        super();
    }

    public HomeWork(Long id){
        this.id = id;
    }

    public HomeWork(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public HomeWork(String libelle){
        this.libelle = libelle ;
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
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getUrlImage(){
        return this.urlImage;
    }
    public void setUrlImage(String urlImage){
        this.urlImage = urlImage;
    }
    public String getUrlVideo(){
        return this.urlVideo;
    }
    public void setUrlVideo(String urlVideo){
        this.urlVideo = urlVideo;
    }
    @OneToMany(mappedBy = "homeWork")

    public List<HomeWorkQuestion> getHomeWorkQuestions(){
        return this.homeWorkQuestions;
    }
    public void setHomeWorkQuestions(List<HomeWorkQuestion> homeWorkQuestions){
        this.homeWorkQuestions = homeWorkQuestions;
    }
    @OneToMany(mappedBy = "homeWork")

    public List<HomeWorkEtudiant> getHomeWorkEtudiants(){
        return this.homeWorkEtudiants;
    }
    public void setHomeWorkEtudiants(List<HomeWorkEtudiant> homeWorkEtudiants){
        this.homeWorkEtudiants = homeWorkEtudiants;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cours")
    public Cours getCours(){
        return this.cours;
    }
    public void setCours(Cours cours){
        this.cours = cours;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_home_work")
    public TypeHomeWork getTypeHomeWork(){
        return this.typeHomeWork;
    }
    public void setTypeHomeWork(TypeHomeWork typeHomeWork){
        this.typeHomeWork = typeHomeWork;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeWork homeWork = (HomeWork) o;
        return id != null && id.equals(homeWork.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

