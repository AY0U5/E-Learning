package  ma.zs.alc.dao.criteria.core.inscriptionref;


import ma.zs.alc.dao.criteria.core.inscription.EtudiantCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ConfirmationTokenCriteria extends  BaseCriteria  {

    private String token;
    private String tokenLike;
    private LocalDateTime expiresAt;
    private LocalDateTime expiresAtFrom;
    private LocalDateTime expiresAtTo;
    private LocalDateTime createdAt;
    private LocalDateTime createdAtFrom;
    private LocalDateTime createdAtTo;
    private LocalDateTime confirmedAt;
    private LocalDateTime confirmedAtFrom;
    private LocalDateTime confirmedAtTo;

    private EtudiantCriteria etudiant ;
    private List<EtudiantCriteria> etudiants ;


    public ConfirmationTokenCriteria(){}

    public String getToken(){
        return this.token;
    }
    public void setToken(String token){
        this.token = token;
    }
    public String getTokenLike(){
        return this.tokenLike;
    }
    public void setTokenLike(String tokenLike){
        this.tokenLike = tokenLike;
    }

    public LocalDateTime getExpiresAt(){
        return this.expiresAt;
    }
    public void setExpiresAt(LocalDateTime expiresAt){
        this.expiresAt = expiresAt;
    }
    public LocalDateTime getExpiresAtFrom(){
        return this.expiresAtFrom;
    }
    public void setExpiresAtFrom(LocalDateTime expiresAtFrom){
        this.expiresAtFrom = expiresAtFrom;
    }
    public LocalDateTime getExpiresAtTo(){
        return this.expiresAtTo;
    }
    public void setExpiresAtTo(LocalDateTime expiresAtTo){
        this.expiresAtTo = expiresAtTo;
    }
    public LocalDateTime getCreatedAt(){
        return this.createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
    public LocalDateTime getCreatedAtFrom(){
        return this.createdAtFrom;
    }
    public void setCreatedAtFrom(LocalDateTime createdAtFrom){
        this.createdAtFrom = createdAtFrom;
    }
    public LocalDateTime getCreatedAtTo(){
        return this.createdAtTo;
    }
    public void setCreatedAtTo(LocalDateTime createdAtTo){
        this.createdAtTo = createdAtTo;
    }
    public LocalDateTime getConfirmedAt(){
        return this.confirmedAt;
    }
    public void setConfirmedAt(LocalDateTime confirmedAt){
        this.confirmedAt = confirmedAt;
    }
    public LocalDateTime getConfirmedAtFrom(){
        return this.confirmedAtFrom;
    }
    public void setConfirmedAtFrom(LocalDateTime confirmedAtFrom){
        this.confirmedAtFrom = confirmedAtFrom;
    }
    public LocalDateTime getConfirmedAtTo(){
        return this.confirmedAtTo;
    }
    public void setConfirmedAtTo(LocalDateTime confirmedAtTo){
        this.confirmedAtTo = confirmedAtTo;
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
