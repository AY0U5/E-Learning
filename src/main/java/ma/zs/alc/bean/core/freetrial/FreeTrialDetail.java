package ma.zs.alc.bean.core.freetrial;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.bean.core.freetrial.FreeTrial;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "free_trial_detail")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class FreeTrialDetail   extends AuditBusinessObject     {

    private Long id;

    @Column(columnDefinition = "boolean default false")
    private Boolean presence = false;
    @Column(columnDefinition = "boolean default false")
    private Boolean whatsUpMessageSent = false;
    private LocalDateTime dateEnvoiwhatsUpMessage ;
    @Column(columnDefinition = "boolean default false")
    private Boolean emailMessageSent = false;
    private LocalDateTime dateEnvoiEmailMessage ;
    @Column(columnDefinition = "boolean default false")
    private Boolean abonne = false;

    private FreeTrial freeTrial ;
    private Etudiant etudiant ;


    public FreeTrialDetail(){
        super();
    }

    public FreeTrialDetail(Long id){
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
    @JoinColumn(name = "free_trial")
    public FreeTrial getFreeTrial(){
        return this.freeTrial;
    }
    public void setFreeTrial(FreeTrial freeTrial){
        this.freeTrial = freeTrial;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etudiant")
    public Etudiant getEtudiant(){
        return this.etudiant;
    }
    public void setEtudiant(Etudiant etudiant){
        this.etudiant = etudiant;
    }
    public Boolean  getPresence(){
        return this.presence;
    }
    public void setPresence(Boolean presence){
        this.presence = presence;
    }
    public Boolean  getWhatsUpMessageSent(){
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
    public Boolean  getEmailMessageSent(){
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
    public Boolean  getAbonne(){
        return this.abonne;
    }
    public void setAbonne(Boolean abonne){
        this.abonne = abonne;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FreeTrialDetail freeTrialDetail = (FreeTrialDetail) o;
        return id != null && id.equals(freeTrialDetail.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

