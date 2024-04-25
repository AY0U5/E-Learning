package  ma.zs.alc.dao.criteria.core.freetrial;


import ma.zs.alc.dao.criteria.core.inscription.EtudiantCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class FreeTrialDetailCriteria extends  BaseCriteria  {

    private Boolean presence;
    private Boolean whatsUpMessageSent;
    private LocalDateTime dateEnvoiwhatsUpMessage;
    private LocalDateTime dateEnvoiwhatsUpMessageFrom;
    private LocalDateTime dateEnvoiwhatsUpMessageTo;
    private Boolean emailMessageSent;
    private LocalDateTime dateEnvoiEmailMessage;
    private LocalDateTime dateEnvoiEmailMessageFrom;
    private LocalDateTime dateEnvoiEmailMessageTo;
    private Boolean abonne;

    private FreeTrialCriteria freeTrial ;
    private List<FreeTrialCriteria> freeTrials ;
    private EtudiantCriteria etudiant ;
    private List<EtudiantCriteria> etudiants ;


    public FreeTrialDetailCriteria(){}

    public Boolean getPresence(){
        return this.presence;
    }
    public void setPresence(Boolean presence){
        this.presence = presence;
    }
    public Boolean getWhatsUpMessageSent(){
        return this.whatsUpMessageSent;
    }
    public void setWhatsUpMessageSent(Boolean whatsUpMessageSent){
        this.whatsUpMessageSent = whatsUpMessageSent;
    }
    public LocalDateTime getDateEnvoiwhatsUpMessage(){
        return this.dateEnvoiwhatsUpMessage;
    }
    public void setDateEnvoiwhatsUpMessage(LocalDateTime dateEnvoiwhatsUpMessage){
        this.dateEnvoiwhatsUpMessage = dateEnvoiwhatsUpMessage;
    }
    public LocalDateTime getDateEnvoiwhatsUpMessageFrom(){
        return this.dateEnvoiwhatsUpMessageFrom;
    }
    public void setDateEnvoiwhatsUpMessageFrom(LocalDateTime dateEnvoiwhatsUpMessageFrom){
        this.dateEnvoiwhatsUpMessageFrom = dateEnvoiwhatsUpMessageFrom;
    }
    public LocalDateTime getDateEnvoiwhatsUpMessageTo(){
        return this.dateEnvoiwhatsUpMessageTo;
    }
    public void setDateEnvoiwhatsUpMessageTo(LocalDateTime dateEnvoiwhatsUpMessageTo){
        this.dateEnvoiwhatsUpMessageTo = dateEnvoiwhatsUpMessageTo;
    }
    public Boolean getEmailMessageSent(){
        return this.emailMessageSent;
    }
    public void setEmailMessageSent(Boolean emailMessageSent){
        this.emailMessageSent = emailMessageSent;
    }
    public LocalDateTime getDateEnvoiEmailMessage(){
        return this.dateEnvoiEmailMessage;
    }
    public void setDateEnvoiEmailMessage(LocalDateTime dateEnvoiEmailMessage){
        this.dateEnvoiEmailMessage = dateEnvoiEmailMessage;
    }
    public LocalDateTime getDateEnvoiEmailMessageFrom(){
        return this.dateEnvoiEmailMessageFrom;
    }
    public void setDateEnvoiEmailMessageFrom(LocalDateTime dateEnvoiEmailMessageFrom){
        this.dateEnvoiEmailMessageFrom = dateEnvoiEmailMessageFrom;
    }
    public LocalDateTime getDateEnvoiEmailMessageTo(){
        return this.dateEnvoiEmailMessageTo;
    }
    public void setDateEnvoiEmailMessageTo(LocalDateTime dateEnvoiEmailMessageTo){
        this.dateEnvoiEmailMessageTo = dateEnvoiEmailMessageTo;
    }
    public Boolean getAbonne(){
        return this.abonne;
    }
    public void setAbonne(Boolean abonne){
        this.abonne = abonne;
    }

    public FreeTrialCriteria getFreeTrial(){
        return this.freeTrial;
    }

    public void setFreeTrial(FreeTrialCriteria freeTrial){
        this.freeTrial = freeTrial;
    }
    public List<FreeTrialCriteria> getFreeTrials(){
        return this.freeTrials;
    }

    public void setFreeTrials(List<FreeTrialCriteria> freeTrials){
        this.freeTrials = freeTrials;
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
