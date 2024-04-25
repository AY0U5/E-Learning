package ma.zs.alc.bean.core.profetudiantcours;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.bean.core.course.Cours;
import ma.zs.alc.bean.core.prof.Prof;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "etudiant_cours")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class EtudiantCours   extends AuditBusinessObject     {

    private Long id;

    @Column(columnDefinition = "boolean default false")
    private Boolean payer = false;
    private LocalDateTime dateFin ;

    private Etudiant etudiant ;
    private Prof prof ;
    private Cours cours ;


    public EtudiantCours(){
        super();
    }

    public EtudiantCours(Long id){
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etudiant")
    public Etudiant getEtudiant(){
        return this.etudiant;
    }
    public void setEtudiant(Etudiant etudiant){
        this.etudiant = etudiant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prof")
    public Prof getProf(){
        return this.prof;
    }
    public void setProf(Prof prof){
        this.prof = prof;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cours")
    public Cours getCours(){
        return this.cours;
    }
    public void setCours(Cours cours){
        this.cours = cours;
    }
    public Boolean  getPayer(){
        return this.payer;
    }
    public void setPayer(Boolean payer){
        this.payer = payer;
    }
    public LocalDateTime getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(LocalDateTime dateFin){
        this.dateFin = dateFin;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtudiantCours etudiantCours = (EtudiantCours) o;
        return id != null && id.equals(etudiantCours.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

