package ma.zs.alc.bean.core.grpe;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.bean.core.course.Parcours;
import ma.zs.alc.bean.core.grpe.GroupeEtat;
import ma.zs.alc.bean.core.grpe.GroupeEtudiantDetail;
import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.bean.core.grpe.GroupeType;
import ma.zs.alc.bean.core.grpe.GroupeEtude;
import ma.zs.alc.bean.core.prof.Prof;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "groupe_etudiant")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class GroupeEtudiant   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    private LocalDateTime dateDebut ;
    private LocalDateTime dateFin ;
    private Long nombrePlace ;
    private Long nombrePlacevide ;
    private Long nombrePlaceNonVide ;

    private GroupeEtude groupeEtude ;
    private GroupeType groupeType ;
    private GroupeEtat groupeEtat ;
    private Parcours parcours ;
    private Prof prof ;

    private List<GroupeEtudiantDetail> groupeEtudiantDetails ;

    public GroupeEtudiant(){
        super();
    }

    public GroupeEtudiant(Long id){
        this.id = id;
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
    public LocalDateTime getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(LocalDateTime dateDebut){
        this.dateDebut = dateDebut;
    }
    public LocalDateTime getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(LocalDateTime dateFin){
        this.dateFin = dateFin;
    }
    public Long getNombrePlace(){
        return this.nombrePlace;
    }
    public void setNombrePlace(Long nombrePlace){
        this.nombrePlace = nombrePlace;
    }
    public Long getNombrePlacevide(){
        return this.nombrePlacevide;
    }
    public void setNombrePlacevide(Long nombrePlacevide){
        this.nombrePlacevide = nombrePlacevide;
    }
    public Long getNombrePlaceNonVide(){
        return this.nombrePlaceNonVide;
    }
    public void setNombrePlaceNonVide(Long nombrePlaceNonVide){
        this.nombrePlaceNonVide = nombrePlaceNonVide;
    }
    @OneToMany(mappedBy = "groupeEtudiant")

    public List<GroupeEtudiantDetail> getGroupeEtudiantDetails(){
        return this.groupeEtudiantDetails;
    }
    public void setGroupeEtudiantDetails(List<GroupeEtudiantDetail> groupeEtudiantDetails){
        this.groupeEtudiantDetails = groupeEtudiantDetails;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupe_etude")
    public GroupeEtude getGroupeEtude(){
        return this.groupeEtude;
    }
    public void setGroupeEtude(GroupeEtude groupeEtude){
        this.groupeEtude = groupeEtude;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupe_type")
    public GroupeType getGroupeType(){
        return this.groupeType;
    }
    public void setGroupeType(GroupeType groupeType){
        this.groupeType = groupeType;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupe_etat")
    public GroupeEtat getGroupeEtat(){
        return this.groupeEtat;
    }
    public void setGroupeEtat(GroupeEtat groupeEtat){
        this.groupeEtat = groupeEtat;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parcours")
    public Parcours getParcours(){
        return this.parcours;
    }
    public void setParcours(Parcours parcours){
        this.parcours = parcours;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prof")
    public Prof getProf(){
        return this.prof;
    }
    public void setProf(Prof prof){
        this.prof = prof;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupeEtudiant groupeEtudiant = (GroupeEtudiant) o;
        return id != null && id.equals(groupeEtudiant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

