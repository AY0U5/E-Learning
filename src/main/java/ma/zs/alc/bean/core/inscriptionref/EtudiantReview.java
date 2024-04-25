package ma.zs.alc.bean.core.inscriptionref;

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
@Table(name = "etudiant_review")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class EtudiantReview   extends AuditBusinessObject     {

    private Long id;

    private Integer review = 0;
    @Column(length = 500)
    private String comment;
    private LocalDateTime dateReview ;

    private Etudiant etudiant ;
    private Prof prof ;
    private Cours cours ;


    public EtudiantReview(){
        super();
    }

    public EtudiantReview(Long id){
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
    public Integer getReview(){
        return this.review;
    }
    public void setReview(Integer review){
        this.review = review;
    }
    public String getComment(){
        return this.comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    public LocalDateTime getDateReview(){
        return this.dateReview;
    }
    public void setDateReview(LocalDateTime dateReview){
        this.dateReview = dateReview;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtudiantReview etudiantReview = (EtudiantReview) o;
        return id != null && id.equals(etudiantReview.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

