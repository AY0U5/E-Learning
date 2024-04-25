package  ma.zs.alc.ws.dto.recomrecla;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReclamationEtudiantDto  extends AuditBaseDto {

    private String reference  ;
    private String dateReclamation ;
    private String message  ;
    private String setFrom  ;
    private String img  ;
    private Boolean traite  ;
    private String dateTraitement ;
    private String dateReponse ;
    private Boolean postView  ;
    private String objetReclamationEtudiant  ;
    private String commentaireTraiteur  ;
    private String username  ;

    private TypeReclamationEtudiantDto typeReclamationEtudiant ;



    public ReclamationEtudiantDto(){
        super();
    }



    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateReclamation(){
        return this.dateReclamation;
    }
    public void setDateReclamation(String dateReclamation){
        this.dateReclamation = dateReclamation;
    }

    @Log
    public String getMessage(){
        return this.message;
    }
    public void setMessage(String message){
        this.message = message;
    }

    @Log
    public String getSetFrom(){
        return this.setFrom;
    }
    public void setSetFrom(String setFrom){
        this.setFrom = setFrom;
    }

    @Log
    public String getImg(){
        return this.img;
    }
    public void setImg(String img){
        this.img = img;
    }

    @Log
    public Boolean getTraite(){
        return this.traite;
    }
    public void setTraite(Boolean traite){
        this.traite = traite;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateTraitement(){
        return this.dateTraitement;
    }
    public void setDateTraitement(String dateTraitement){
        this.dateTraitement = dateTraitement;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateReponse(){
        return this.dateReponse;
    }
    public void setDateReponse(String dateReponse){
        this.dateReponse = dateReponse;
    }

    @Log
    public Boolean getPostView(){
        return this.postView;
    }
    public void setPostView(Boolean postView){
        this.postView = postView;
    }

    @Log
    public String getObjetReclamationEtudiant(){
        return this.objetReclamationEtudiant;
    }
    public void setObjetReclamationEtudiant(String objetReclamationEtudiant){
        this.objetReclamationEtudiant = objetReclamationEtudiant;
    }

    @Log
    public String getCommentaireTraiteur(){
        return this.commentaireTraiteur;
    }
    public void setCommentaireTraiteur(String commentaireTraiteur){
        this.commentaireTraiteur = commentaireTraiteur;
    }

    @Log
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }


    public TypeReclamationEtudiantDto getTypeReclamationEtudiant(){
        return this.typeReclamationEtudiant;
    }

    public void setTypeReclamationEtudiant(TypeReclamationEtudiantDto typeReclamationEtudiant){
        this.typeReclamationEtudiant = typeReclamationEtudiant;
    }






}
