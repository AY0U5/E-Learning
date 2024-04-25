package ma.zs.alc.bean.core.inscriptionref;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.bean.core.inscription.Etudiant;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "invite_student")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class InviteStudent   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(columnDefinition = "boolean default false")
    private Boolean isAccepted = false;
    @Column(columnDefinition = "boolean default false")
    private Boolean isPaidPack = false;
    @Column(length = 500)
    private String emailInvited;
    private LocalDateTime dateSentInvitation ;
    private LocalDateTime dateAcceptInvitation ;
    private LocalDateTime datePayPack ;

    private Etudiant etudiant ;


    public InviteStudent(){
        super();
    }

    public InviteStudent(Long id){
        this.id = id;
    }

    public InviteStudent(Long id,String code){
        this.id = id;
        this.code = code ;
    }
    public InviteStudent(String code){
        this.code = code ;
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
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etudiant")
    public Etudiant getEtudiant(){
        return this.etudiant;
    }
    public void setEtudiant(Etudiant etudiant){
        this.etudiant = etudiant;
    }
    public Boolean  getIsAccepted(){
        return this.isAccepted;
    }
    public void setIsAccepted(Boolean isAccepted){
        this.isAccepted = isAccepted;
    }
    public Boolean  getIsPaidPack(){
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
    public LocalDateTime getDateSentInvitation(){
        return this.dateSentInvitation;
    }
    public void setDateSentInvitation(LocalDateTime dateSentInvitation){
        this.dateSentInvitation = dateSentInvitation;
    }
    public LocalDateTime getDateAcceptInvitation(){
        return this.dateAcceptInvitation;
    }
    public void setDateAcceptInvitation(LocalDateTime dateAcceptInvitation){
        this.dateAcceptInvitation = dateAcceptInvitation;
    }
    public LocalDateTime getDatePayPack(){
        return this.datePayPack;
    }
    public void setDatePayPack(LocalDateTime datePayPack){
        this.datePayPack = datePayPack;
    }

    @Transient
    public String getLabel() {
        label = code;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InviteStudent inviteStudent = (InviteStudent) o;
        return id != null && id.equals(inviteStudent.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

