package ma.zs.alc.bean.core.homework;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.bean.core.homework.HoweWorkQSTReponse;
import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.bean.core.homework.ReponseEtudiantHomeWork;
import ma.zs.alc.bean.core.homework.HomeWorkQuestion;
import ma.zs.alc.bean.core.homework.HomeWork;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "home_work_etudiant")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class HomeWorkEtudiant   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal note = BigDecimal.ZERO;
    @Column(length = 500)
    private String resultat;
    private LocalDateTime dateHomeWork ;

    private Etudiant etudiant ;
    private HomeWork homeWork ;

    private List<ReponseEtudiantHomeWork> reponseEtudiantHomeWorks ;

    public HomeWorkEtudiant(){
        super();
    }

    public HomeWorkEtudiant(Long id){
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
    @JoinColumn(name = "home_work")
    public HomeWork getHomeWork(){
        return this.homeWork;
    }
    public void setHomeWork(HomeWork homeWork){
        this.homeWork = homeWork;
    }
    @OneToMany(mappedBy = "homeWorkEtudiant")

    public List<ReponseEtudiantHomeWork> getReponseEtudiantHomeWorks(){
        return this.reponseEtudiantHomeWorks;
    }
    public void setReponseEtudiantHomeWorks(List<ReponseEtudiantHomeWork> reponseEtudiantHomeWorks){
        this.reponseEtudiantHomeWorks = reponseEtudiantHomeWorks;
    }
    public BigDecimal getNote(){
        return this.note;
    }
    public void setNote(BigDecimal note){
        this.note = note;
    }
    public String getResultat(){
        return this.resultat;
    }
    public void setResultat(String resultat){
        this.resultat = resultat;
    }
    public LocalDateTime getDateHomeWork(){
        return this.dateHomeWork;
    }
    public void setDateHomeWork(LocalDateTime dateHomeWork){
        this.dateHomeWork = dateHomeWork;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeWorkEtudiant homeWorkEtudiant = (HomeWorkEtudiant) o;
        return id != null && id.equals(homeWorkEtudiant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

