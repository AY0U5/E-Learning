package  ma.zs.alc.dao.criteria.core.paiement;


import ma.zs.alc.dao.criteria.core.grpe.GroupeEtudiantCriteria;
import ma.zs.alc.dao.criteria.core.prof.ProfCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class PaiementCriteria extends  BaseCriteria  {

    private LocalDateTime datePaiement;
    private LocalDateTime datePaiementFrom;
    private LocalDateTime datePaiementTo;

    private ProfCriteria prof ;
    private List<ProfCriteria> profs ;
    private GroupeEtudiantCriteria groupeEtudiant ;
    private List<GroupeEtudiantCriteria> groupeEtudiants ;


    public PaiementCriteria(){}

    public LocalDateTime getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(LocalDateTime datePaiement){
        this.datePaiement = datePaiement;
    }
    public LocalDateTime getDatePaiementFrom(){
        return this.datePaiementFrom;
    }
    public void setDatePaiementFrom(LocalDateTime datePaiementFrom){
        this.datePaiementFrom = datePaiementFrom;
    }
    public LocalDateTime getDatePaiementTo(){
        return this.datePaiementTo;
    }
    public void setDatePaiementTo(LocalDateTime datePaiementTo){
        this.datePaiementTo = datePaiementTo;
    }

    public ProfCriteria getProf(){
        return this.prof;
    }

    public void setProf(ProfCriteria prof){
        this.prof = prof;
    }
    public List<ProfCriteria> getProfs(){
        return this.profs;
    }

    public void setProfs(List<ProfCriteria> profs){
        this.profs = profs;
    }
    public GroupeEtudiantCriteria getGroupeEtudiant(){
        return this.groupeEtudiant;
    }

    public void setGroupeEtudiant(GroupeEtudiantCriteria groupeEtudiant){
        this.groupeEtudiant = groupeEtudiant;
    }
    public List<GroupeEtudiantCriteria> getGroupeEtudiants(){
        return this.groupeEtudiants;
    }

    public void setGroupeEtudiants(List<GroupeEtudiantCriteria> groupeEtudiants){
        this.groupeEtudiants = groupeEtudiants;
    }
}
