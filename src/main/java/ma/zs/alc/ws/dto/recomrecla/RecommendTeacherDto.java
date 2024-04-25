package  ma.zs.alc.ws.dto.recomrecla;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.ws.dto.prof.ProfDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecommendTeacherDto  extends AuditBaseDto {

    private String ref  ;
    private Integer nombrevote  = 0 ;
    private String nom  ;
    private String prenom  ;
    private String commentaire  ;
    private String telephone  ;
    private String login  ;
    private String dateRecommamdation ;

    private ProfDto prof ;



    public RecommendTeacherDto(){
        super();
    }



    @Log
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }

    @Log
    public Integer getNombrevote(){
        return this.nombrevote;
    }
    public void setNombrevote(Integer nombrevote){
        this.nombrevote = nombrevote;
    }

    @Log
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }

    @Log
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    @Log
    public String getCommentaire(){
        return this.commentaire;
    }
    public void setCommentaire(String commentaire){
        this.commentaire = commentaire;
    }

    @Log
    public String getTelephone(){
        return this.telephone;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }

    @Log
    public String getLogin(){
        return this.login;
    }
    public void setLogin(String login){
        this.login = login;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateRecommamdation(){
        return this.dateRecommamdation;
    }
    public void setDateRecommamdation(String dateRecommamdation){
        this.dateRecommamdation = dateRecommamdation;
    }


    public ProfDto getProf(){
        return this.prof;
    }

    public void setProf(ProfDto prof){
        this.prof = prof;
    }






}
