package ma.zs.alc.bean.core.recomrecla;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.bean.core.prof.Prof;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "recommend_teacher")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class RecommendTeacher   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ref;
    private Integer nombrevote = 0;
    @Column(length = 500)
    private String nom;
    @Column(length = 500)
    private String prenom;
    @Column(length = 500)
    private String commentaire;
    @Column(length = 500)
    private String telephone;
    @Column(length = 500)
    private String login;
    private LocalDateTime dateRecommamdation ;

    private Prof prof ;


    public RecommendTeacher(){
        super();
    }

    public RecommendTeacher(Long id){
        this.id = id;
    }

    public RecommendTeacher(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }
    public RecommendTeacher(String ref){
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
    public Integer getNombrevote(){
        return this.nombrevote;
    }
    public void setNombrevote(Integer nombrevote){
        this.nombrevote = nombrevote;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getCommentaire(){
        return this.commentaire;
    }
    public void setCommentaire(String commentaire){
        this.commentaire = commentaire;
    }
    public String getTelephone(){
        return this.telephone;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    public String getLogin(){
        return this.login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public LocalDateTime getDateRecommamdation(){
        return this.dateRecommamdation;
    }
    public void setDateRecommamdation(LocalDateTime dateRecommamdation){
        this.dateRecommamdation = dateRecommamdation;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prof")
    public Prof getProf(){
        return this.prof;
    }
    public void setProf(Prof prof){
        this.prof = prof;
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
        RecommendTeacher recommendTeacher = (RecommendTeacher) o;
        return id != null && id.equals(recommendTeacher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

