package  ma.zs.alc.dao.criteria.core.learning;


import ma.zs.alc.dao.criteria.core.salary.SalaryCriteria;
import ma.zs.alc.dao.criteria.core.grpe.GroupeEtudiantCriteria;
import ma.zs.alc.dao.criteria.core.course.CoursCriteria;
import ma.zs.alc.dao.criteria.core.prof.ProfCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class SessionCoursCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private String duree;
    private String dureeMin;
    private String dureeMax;
    private String totalheure;
    private String totalheureMin;
    private String totalheureMax;
    private String mois;
    private String moisMin;
    private String moisMax;
    private String annee;
    private String anneeMin;
    private String anneeMax;
    private LocalDateTime dateFin;
    private LocalDateTime dateFinFrom;
    private LocalDateTime dateFinTo;
    private LocalDateTime dateDebut;
    private LocalDateTime dateDebutFrom;
    private LocalDateTime dateDebutTo;
    private Boolean payer;

    private ProfCriteria prof ;
    private List<ProfCriteria> profs ;
    private CoursCriteria cours ;
    private List<CoursCriteria> courss ;
    private GroupeEtudiantCriteria groupeEtudiant ;
    private List<GroupeEtudiantCriteria> groupeEtudiants ;
    private SalaryCriteria salary ;
    private List<SalaryCriteria> salarys ;


    public SessionCoursCriteria(){}

    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getReferenceLike(){
        return this.referenceLike;
    }
    public void setReferenceLike(String referenceLike){
        this.referenceLike = referenceLike;
    }

    public String getDuree(){
        return this.duree;
    }
    public void setDuree(String duree){
        this.duree = duree;
    }   
    public String getDureeMin(){
        return this.dureeMin;
    }
    public void setDureeMin(String dureeMin){
        this.dureeMin = dureeMin;
    }
    public String getDureeMax(){
        return this.dureeMax;
    }
    public void setDureeMax(String dureeMax){
        this.dureeMax = dureeMax;
    }
      
    public String getTotalheure(){
        return this.totalheure;
    }
    public void setTotalheure(String totalheure){
        this.totalheure = totalheure;
    }   
    public String getTotalheureMin(){
        return this.totalheureMin;
    }
    public void setTotalheureMin(String totalheureMin){
        this.totalheureMin = totalheureMin;
    }
    public String getTotalheureMax(){
        return this.totalheureMax;
    }
    public void setTotalheureMax(String totalheureMax){
        this.totalheureMax = totalheureMax;
    }
      
    public String getMois(){
        return this.mois;
    }
    public void setMois(String mois){
        this.mois = mois;
    }   
    public String getMoisMin(){
        return this.moisMin;
    }
    public void setMoisMin(String moisMin){
        this.moisMin = moisMin;
    }
    public String getMoisMax(){
        return this.moisMax;
    }
    public void setMoisMax(String moisMax){
        this.moisMax = moisMax;
    }
      
    public String getAnnee(){
        return this.annee;
    }
    public void setAnnee(String annee){
        this.annee = annee;
    }   
    public String getAnneeMin(){
        return this.anneeMin;
    }
    public void setAnneeMin(String anneeMin){
        this.anneeMin = anneeMin;
    }
    public String getAnneeMax(){
        return this.anneeMax;
    }
    public void setAnneeMax(String anneeMax){
        this.anneeMax = anneeMax;
    }
      
    public LocalDateTime getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(LocalDateTime dateFin){
        this.dateFin = dateFin;
    }
    public LocalDateTime getDateFinFrom(){
        return this.dateFinFrom;
    }
    public void setDateFinFrom(LocalDateTime dateFinFrom){
        this.dateFinFrom = dateFinFrom;
    }
    public LocalDateTime getDateFinTo(){
        return this.dateFinTo;
    }
    public void setDateFinTo(LocalDateTime dateFinTo){
        this.dateFinTo = dateFinTo;
    }
    public LocalDateTime getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(LocalDateTime dateDebut){
        this.dateDebut = dateDebut;
    }
    public LocalDateTime getDateDebutFrom(){
        return this.dateDebutFrom;
    }
    public void setDateDebutFrom(LocalDateTime dateDebutFrom){
        this.dateDebutFrom = dateDebutFrom;
    }
    public LocalDateTime getDateDebutTo(){
        return this.dateDebutTo;
    }
    public void setDateDebutTo(LocalDateTime dateDebutTo){
        this.dateDebutTo = dateDebutTo;
    }
    public Boolean getPayer(){
        return this.payer;
    }
    public void setPayer(Boolean payer){
        this.payer = payer;
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
    public CoursCriteria getCours(){
        return this.cours;
    }

    public void setCours(CoursCriteria cours){
        this.cours = cours;
    }
    public List<CoursCriteria> getCourss(){
        return this.courss;
    }

    public void setCourss(List<CoursCriteria> courss){
        this.courss = courss;
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
    public SalaryCriteria getSalary(){
        return this.salary;
    }

    public void setSalary(SalaryCriteria salary){
        this.salary = salary;
    }
    public List<SalaryCriteria> getSalarys(){
        return this.salarys;
    }

    public void setSalarys(List<SalaryCriteria> salarys){
        this.salarys = salarys;
    }
}
