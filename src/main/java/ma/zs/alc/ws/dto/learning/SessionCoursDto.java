package  ma.zs.alc.ws.dto.learning;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.zs.alc.ws.dto.salary.SalaryDto;
import ma.zs.alc.ws.dto.grpe.GroupeEtudiantDto;
import ma.zs.alc.ws.dto.course.SectionDto;
import ma.zs.alc.ws.dto.course.CoursDto;
import ma.zs.alc.ws.dto.prof.ProfDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SessionCoursDto  extends AuditBaseDto {

    private String reference  ;
    private BigDecimal duree  ;
    private BigDecimal totalheure  ;
    private BigDecimal mois  ;
    private BigDecimal annee  ;
    private String dateFin ;
    private String dateDebut ;
    private Boolean payer  ;

    private ProfDto prof ;
    private CoursDto cours ;
    private GroupeEtudiantDto groupeEtudiant ;
    private SalaryDto salary ;

    private List<SessionCoursSectionDto> sessionCoursSections ;


    public SessionCoursDto(){
        super();
    }



    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    public BigDecimal getDuree(){
        return this.duree;
    }
    public void setDuree(BigDecimal duree){
        this.duree = duree;
    }

    @Log
    public BigDecimal getTotalheure(){
        return this.totalheure;
    }
    public void setTotalheure(BigDecimal totalheure){
        this.totalheure = totalheure;
    }

    @Log
    public BigDecimal getMois(){
        return this.mois;
    }
    public void setMois(BigDecimal mois){
        this.mois = mois;
    }

    @Log
    public BigDecimal getAnnee(){
        return this.annee;
    }
    public void setAnnee(BigDecimal annee){
        this.annee = annee;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(String dateFin){
        this.dateFin = dateFin;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(String dateDebut){
        this.dateDebut = dateDebut;
    }

    @Log
    public Boolean getPayer(){
        return this.payer;
    }
    public void setPayer(Boolean payer){
        this.payer = payer;
    }


    public ProfDto getProf(){
        return this.prof;
    }

    public void setProf(ProfDto prof){
        this.prof = prof;
    }
    public CoursDto getCours(){
        return this.cours;
    }

    public void setCours(CoursDto cours){
        this.cours = cours;
    }
    public GroupeEtudiantDto getGroupeEtudiant(){
        return this.groupeEtudiant;
    }

    public void setGroupeEtudiant(GroupeEtudiantDto groupeEtudiant){
        this.groupeEtudiant = groupeEtudiant;
    }
    public SalaryDto getSalary(){
        return this.salary;
    }

    public void setSalary(SalaryDto salary){
        this.salary = salary;
    }



    public List<SessionCoursSectionDto> getSessionCoursSections(){
        return this.sessionCoursSections;
    }

    public void setSessionCoursSections(List<SessionCoursSectionDto> sessionCoursSections){
        this.sessionCoursSections = sessionCoursSections;
    }



}
