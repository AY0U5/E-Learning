package  ma.zs.alc.ws.dto.inscriptionref;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.ws.dto.inscription.EtudiantDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class InviteStudentDto  extends AuditBaseDto {

    private String code  ;
    private Boolean isAccepted  ;
    private Boolean isPaidPack  ;
    private String emailInvited  ;
    private String dateSentInvitation ;
    private String dateAcceptInvitation ;
    private String datePayPack ;

    private EtudiantDto etudiant ;



    public InviteStudentDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public Boolean getIsAccepted(){
        return this.isAccepted;
    }
    public void setIsAccepted(Boolean isAccepted){
        this.isAccepted = isAccepted;
    }

    @Log
    public Boolean getIsPaidPack(){
        return this.isPaidPack;
    }
    public void setIsPaidPack(Boolean isPaidPack){
        this.isPaidPack = isPaidPack;
    }

    @Log
    public String getEmailInvited(){
        return this.emailInvited;
    }
    public void setEmailInvited(String emailInvited){
        this.emailInvited = emailInvited;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateSentInvitation(){
        return this.dateSentInvitation;
    }
    public void setDateSentInvitation(String dateSentInvitation){
        this.dateSentInvitation = dateSentInvitation;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateAcceptInvitation(){
        return this.dateAcceptInvitation;
    }
    public void setDateAcceptInvitation(String dateAcceptInvitation){
        this.dateAcceptInvitation = dateAcceptInvitation;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDatePayPack(){
        return this.datePayPack;
    }
    public void setDatePayPack(String datePayPack){
        this.datePayPack = datePayPack;
    }


    public EtudiantDto getEtudiant(){
        return this.etudiant;
    }

    public void setEtudiant(EtudiantDto etudiant){
        this.etudiant = etudiant;
    }






}
