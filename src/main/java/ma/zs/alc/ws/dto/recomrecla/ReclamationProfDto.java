package  ma.zs.alc.ws.dto.recomrecla;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.ws.dto.alc.AdminDto;
import ma.zs.alc.ws.dto.prof.ProfDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReclamationProfDto  extends AuditBaseDto {

    private String reference  ;
    private String dateReclamation ;
    private String message  ;
    private Boolean traite  ;
    private String dateTraitement ;
    private String dateReponse ;
    private Boolean postView  ;
    private String commentaireTraiteur  ;
    private String objetReclamationProf  ;

    private AdminDto admin ;
    private ProfDto prof ;
    private TypeReclamationProfDto typeReclamationProf ;



    public ReclamationProfDto(){
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
    public String getCommentaireTraiteur(){
        return this.commentaireTraiteur;
    }
    public void setCommentaireTraiteur(String commentaireTraiteur){
        this.commentaireTraiteur = commentaireTraiteur;
    }

    @Log
    public String getObjetReclamationProf(){
        return this.objetReclamationProf;
    }
    public void setObjetReclamationProf(String objetReclamationProf){
        this.objetReclamationProf = objetReclamationProf;
    }


    public AdminDto getAdmin(){
        return this.admin;
    }

    public void setAdmin(AdminDto admin){
        this.admin = admin;
    }
    public ProfDto getProf(){
        return this.prof;
    }

    public void setProf(ProfDto prof){
        this.prof = prof;
    }
    public TypeReclamationProfDto getTypeReclamationProf(){
        return this.typeReclamationProf;
    }

    public void setTypeReclamationProf(TypeReclamationProfDto typeReclamationProf){
        this.typeReclamationProf = typeReclamationProf;
    }






}
