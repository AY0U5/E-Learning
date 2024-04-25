package ma.zs.alc.bean.core.course;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant;
import ma.zs.alc.bean.core.inscriptionref.EtatEtudiantSchedule;
import ma.zs.alc.bean.core.inscriptionref.InteretEtudiant;
import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.bean.core.inscriptionref.StatutSocial;
import ma.zs.alc.bean.core.inscriptionref.Langue;
import ma.zs.alc.bean.core.grpe.GroupeEtudiant;
import ma.zs.alc.bean.core.courseref.EtatCours;
import ma.zs.alc.bean.core.course.Section;
import ma.zs.alc.bean.core.courseref.Centre;
import ma.zs.alc.bean.core.course.Cours;
import ma.zs.alc.bean.core.grpe.GroupeEtude;
import ma.zs.alc.bean.core.homework.HomeWork;
import ma.zs.alc.bean.core.inscriptionref.Skill;
import ma.zs.alc.bean.core.inscriptionref.Fonction;
import ma.zs.alc.bean.core.pack.PackStudent;
import ma.zs.alc.bean.core.grpe.GroupeEtudiantDetail;
import ma.zs.alc.bean.core.inscriptionref.TeacherLocality;
import ma.zs.alc.bean.core.inscriptionref.NiveauEtude;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "parcours")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Parcours   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime datePublication ;
    private LocalDateTime dateCreation ;
    @Column(length = 500)
    private String description;
    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;
    private Integer numeroOrder = 0;
    private Integer nombreCours = 0;

    private Centre centre ;

    private List<Cours> courss ;
    private List<Etudiant> etudiants ;

    public Parcours(){
        super();
    }

    public Parcours(Long id){
        this.id = id;
    }

    public Parcours(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public Parcours(String libelle){
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
    public LocalDateTime getDatePublication(){
        return this.datePublication;
    }
    public void setDatePublication(LocalDateTime datePublication){
        this.datePublication = datePublication;
    }
    public LocalDateTime getDateCreation(){
        return this.dateCreation;
    }
    public void setDateCreation(LocalDateTime dateCreation){
        this.dateCreation = dateCreation;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public Integer getNumeroOrder(){
        return this.numeroOrder;
    }
    public void setNumeroOrder(Integer numeroOrder){
        this.numeroOrder = numeroOrder;
    }
    public Integer getNombreCours(){
        return this.nombreCours;
    }
    public void setNombreCours(Integer nombreCours){
        this.nombreCours = nombreCours;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "centre")
    public Centre getCentre(){
        return this.centre;
    }
    public void setCentre(Centre centre){
        this.centre = centre;
    }
    @OneToMany(mappedBy = "parcours")

    public List<Cours> getCourss(){
        return this.courss;
    }
    public void setCourss(List<Cours> courss){
        this.courss = courss;
    }
    @OneToMany(mappedBy = "parcours")

    public List<Etudiant> getEtudiants(){
        return this.etudiants;
    }
    public void setEtudiants(List<Etudiant> etudiants){
        this.etudiants = etudiants;
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
        Parcours parcours = (Parcours) o;
        return id != null && id.equals(parcours.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

