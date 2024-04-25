package  ma.zs.alc.dao.criteria.core.inscriptionref;


import ma.zs.alc.dao.criteria.core.inscription.EtudiantCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class InviteStudentCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private Boolean isAccepted;
    private Boolean isPaidPack;
    private String emailInvited;
    private String emailInvitedLike;
    private LocalDateTime dateSentInvitation;
    private LocalDateTime dateSentInvitationFrom;
    private LocalDateTime dateSentInvitationTo;
    private LocalDateTime dateAcceptInvitation;
    private LocalDateTime dateAcceptInvitationFrom;
    private LocalDateTime dateAcceptInvitationTo;
    private LocalDateTime datePayPack;
    private LocalDateTime datePayPackFrom;
    private LocalDateTime datePayPackTo;

    private EtudiantCriteria etudiant ;
    private List<EtudiantCriteria> etudiants ;


    public InviteStudentCriteria(){}

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public Boolean getIsAccepted(){
        return this.isAccepted;
    }
    public void setIsAccepted(Boolean isAccepted){
        this.isAccepted = isAccepted;
    }
    public Boolean getIsPaidPack(){
        return this.isPaidPack;
    }
    public void setIsPaidPack(Boolean isPaidPack){
        this.isPaidPack = isPaidPack;
    }
    public String getEmailInvited(){
        return this.emailInvited;
    }
    public void setEmailInvited(String emailInvited){
        this.emailInvited = emailInvited;
    }
    public String getEmailInvitedLike(){
        return this.emailInvitedLike;
    }
    public void setEmailInvitedLike(String emailInvitedLike){
        this.emailInvitedLike = emailInvitedLike;
    }

    public LocalDateTime getDateSentInvitation(){
        return this.dateSentInvitation;
    }
    public void setDateSentInvitation(LocalDateTime dateSentInvitation){
        this.dateSentInvitation = dateSentInvitation;
    }
    public LocalDateTime getDateSentInvitationFrom(){
        return this.dateSentInvitationFrom;
    }
    public void setDateSentInvitationFrom(LocalDateTime dateSentInvitationFrom){
        this.dateSentInvitationFrom = dateSentInvitationFrom;
    }
    public LocalDateTime getDateSentInvitationTo(){
        return this.dateSentInvitationTo;
    }
    public void setDateSentInvitationTo(LocalDateTime dateSentInvitationTo){
        this.dateSentInvitationTo = dateSentInvitationTo;
    }
    public LocalDateTime getDateAcceptInvitation(){
        return this.dateAcceptInvitation;
    }
    public void setDateAcceptInvitation(LocalDateTime dateAcceptInvitation){
        this.dateAcceptInvitation = dateAcceptInvitation;
    }
    public LocalDateTime getDateAcceptInvitationFrom(){
        return this.dateAcceptInvitationFrom;
    }
    public void setDateAcceptInvitationFrom(LocalDateTime dateAcceptInvitationFrom){
        this.dateAcceptInvitationFrom = dateAcceptInvitationFrom;
    }
    public LocalDateTime getDateAcceptInvitationTo(){
        return this.dateAcceptInvitationTo;
    }
    public void setDateAcceptInvitationTo(LocalDateTime dateAcceptInvitationTo){
        this.dateAcceptInvitationTo = dateAcceptInvitationTo;
    }
    public LocalDateTime getDatePayPack(){
        return this.datePayPack;
    }
    public void setDatePayPack(LocalDateTime datePayPack){
        this.datePayPack = datePayPack;
    }
    public LocalDateTime getDatePayPackFrom(){
        return this.datePayPackFrom;
    }
    public void setDatePayPackFrom(LocalDateTime datePayPackFrom){
        this.datePayPackFrom = datePayPackFrom;
    }
    public LocalDateTime getDatePayPackTo(){
        return this.datePayPackTo;
    }
    public void setDatePayPackTo(LocalDateTime datePayPackTo){
        this.datePayPackTo = datePayPackTo;
    }

    public EtudiantCriteria getEtudiant(){
        return this.etudiant;
    }

    public void setEtudiant(EtudiantCriteria etudiant){
        this.etudiant = etudiant;
    }
    public List<EtudiantCriteria> getEtudiants(){
        return this.etudiants;
    }

    public void setEtudiants(List<EtudiantCriteria> etudiants){
        this.etudiants = etudiants;
    }
}
