package ma.zs.alc.bean.core.recomrecla;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.bean.core.recomrecla.TypeReclamationEtudiant;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "reclamation_etudiant")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ReclamationEtudiant   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime dateReclamation ;
    @Column(length = 500)
    private String message;
    @Column(length = 500)
    private String setFrom;
    @Column(length = 500)
    private String img;
    @Column(columnDefinition = "boolean default false")
    private Boolean traite = false;
    private LocalDateTime dateTraitement ;
    private LocalDateTime dateReponse ;
    @Column(columnDefinition = "boolean default false")
    private Boolean postView = false;
    @Column(length = 500)
    private String objetReclamationEtudiant;
    @Column(length = 500)
    private String commentaireTraiteur;
    @Column(length = 500)
    private String username;

    private TypeReclamationEtudiant typeReclamationEtudiant ;


    public ReclamationEtudiant(){
        super();
    }

    public ReclamationEtudiant(Long id){
        this.id = id;
    }

    public ReclamationEtudiant(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }
    public ReclamationEtudiant(String reference){
        this.reference = reference ;
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
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public LocalDateTime getDateReclamation(){
        return this.dateReclamation;
    }
    public void setDateReclamation(LocalDateTime dateReclamation){
        this.dateReclamation = dateReclamation;
    }
    public String getMessage(){
        return this.message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getSetFrom(){
        return this.setFrom;
    }
    public void setSetFrom(String setFrom){
        this.setFrom = setFrom;
    }
    public String getImg(){
        return this.img;
    }
    public void setImg(String img){
        this.img = img;
    }
    public Boolean  getTraite(){
        return this.traite;
    }
    public void setTraite(Boolean traite){
        this.traite = traite;
    }
    public LocalDateTime getDateTraitement(){
        return this.dateTraitement;
    }
    public void setDateTraitement(LocalDateTime dateTraitement){
        this.dateTraitement = dateTraitement;
    }
    public LocalDateTime getDateReponse(){
        return this.dateReponse;
    }
    public void setDateReponse(LocalDateTime dateReponse){
        this.dateReponse = dateReponse;
    }
    public Boolean  getPostView(){
        return this.postView;
    }
    public void setPostView(Boolean postView){
        this.postView = postView;
    }
    public String getObjetReclamationEtudiant(){
        return this.objetReclamationEtudiant;
    }
    public void setObjetReclamationEtudiant(String objetReclamationEtudiant){
        this.objetReclamationEtudiant = objetReclamationEtudiant;
    }
    public String getCommentaireTraiteur(){
        return this.commentaireTraiteur;
    }
    public void setCommentaireTraiteur(String commentaireTraiteur){
        this.commentaireTraiteur = commentaireTraiteur;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_reclamation_etudiant")
    public TypeReclamationEtudiant getTypeReclamationEtudiant(){
        return this.typeReclamationEtudiant;
    }
    public void setTypeReclamationEtudiant(TypeReclamationEtudiant typeReclamationEtudiant){
        this.typeReclamationEtudiant = typeReclamationEtudiant;
    }

    @Transient
    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReclamationEtudiant reclamationEtudiant = (ReclamationEtudiant) o;
        return id != null && id.equals(reclamationEtudiant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

