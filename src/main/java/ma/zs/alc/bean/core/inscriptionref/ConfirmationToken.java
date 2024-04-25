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
@Table(name = "confirmation_token")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ConfirmationToken   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String token;
    private LocalDateTime expiresAt ;
    private LocalDateTime createdAt ;
    private LocalDateTime confirmedAt ;

    private Etudiant etudiant ;


    public ConfirmationToken(){
        super();
    }

    public ConfirmationToken(Long id){
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
    public String getToken(){
        return this.token;
    }
    public void setToken(String token){
        this.token = token;
    }
    public LocalDateTime getExpiresAt(){
        return this.expiresAt;
    }
    public void setExpiresAt(LocalDateTime expiresAt){
        this.expiresAt = expiresAt;
    }
    public LocalDateTime getCreatedAt(){
        return this.createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
    public LocalDateTime getConfirmedAt(){
        return this.confirmedAt;
    }
    public void setConfirmedAt(LocalDateTime confirmedAt){
        this.confirmedAt = confirmedAt;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etudiant")
    public Etudiant getEtudiant(){
        return this.etudiant;
    }
    public void setEtudiant(Etudiant etudiant){
        this.etudiant = etudiant;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfirmationToken confirmationToken = (ConfirmationToken) o;
        return id != null && id.equals(confirmationToken.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

