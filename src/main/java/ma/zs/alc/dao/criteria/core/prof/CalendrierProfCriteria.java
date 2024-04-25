package  ma.zs.alc.dao.criteria.core.prof;


import ma.zs.alc.dao.criteria.core.inscription.EtudiantCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class CalendrierProfCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String startTime;
    private String startTimeLike;
    private String endTime;
    private String endTimeLike;
    private LocalDateTime startRecur;
    private LocalDateTime startRecurFrom;
    private LocalDateTime startRecurTo;
    private LocalDateTime endRecur;
    private LocalDateTime endRecurFrom;
    private LocalDateTime endRecurTo;

    private ProfCriteria prof ;
    private List<ProfCriteria> profs ;
    private EtudiantCriteria etudiant ;
    private List<EtudiantCriteria> etudiants ;


    public CalendrierProfCriteria(){}

    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public String getRefLike(){
        return this.refLike;
    }
    public void setRefLike(String refLike){
        this.refLike = refLike;
    }

    public String getStartTime(){
        return this.startTime;
    }
    public void setStartTime(String startTime){
        this.startTime = startTime;
    }
    public String getStartTimeLike(){
        return this.startTimeLike;
    }
    public void setStartTimeLike(String startTimeLike){
        this.startTimeLike = startTimeLike;
    }

    public String getEndTime(){
        return this.endTime;
    }
    public void setEndTime(String endTime){
        this.endTime = endTime;
    }
    public String getEndTimeLike(){
        return this.endTimeLike;
    }
    public void setEndTimeLike(String endTimeLike){
        this.endTimeLike = endTimeLike;
    }

    public LocalDateTime getStartRecur(){
        return this.startRecur;
    }
    public void setStartRecur(LocalDateTime startRecur){
        this.startRecur = startRecur;
    }
    public LocalDateTime getStartRecurFrom(){
        return this.startRecurFrom;
    }
    public void setStartRecurFrom(LocalDateTime startRecurFrom){
        this.startRecurFrom = startRecurFrom;
    }
    public LocalDateTime getStartRecurTo(){
        return this.startRecurTo;
    }
    public void setStartRecurTo(LocalDateTime startRecurTo){
        this.startRecurTo = startRecurTo;
    }
    public LocalDateTime getEndRecur(){
        return this.endRecur;
    }
    public void setEndRecur(LocalDateTime endRecur){
        this.endRecur = endRecur;
    }
    public LocalDateTime getEndRecurFrom(){
        return this.endRecurFrom;
    }
    public void setEndRecurFrom(LocalDateTime endRecurFrom){
        this.endRecurFrom = endRecurFrom;
    }
    public LocalDateTime getEndRecurTo(){
        return this.endRecurTo;
    }
    public void setEndRecurTo(LocalDateTime endRecurTo){
        this.endRecurTo = endRecurTo;
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
