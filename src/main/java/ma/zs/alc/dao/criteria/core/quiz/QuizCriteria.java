package  ma.zs.alc.dao.criteria.core.quiz;


import ma.zs.alc.dao.criteria.core.course.SectionCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class QuizCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String lib;
    private String libLike;
    private LocalDateTime dateDebut;
    private LocalDateTime dateDebutFrom;
    private LocalDateTime dateDebutTo;
    private LocalDateTime dateFin;
    private LocalDateTime dateFinFrom;
    private LocalDateTime dateFinTo;
    private String numero;
    private String numeroMin;
    private String numeroMax;
    private String seuilReussite;
    private String seuilReussiteMin;
    private String seuilReussiteMax;

    private SectionCriteria section ;
    private List<SectionCriteria> sections ;


    public QuizCriteria(){}

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

    public String getLib(){
        return this.lib;
    }
    public void setLib(String lib){
        this.lib = lib;
    }
    public String getLibLike(){
        return this.libLike;
    }
    public void setLibLike(String libLike){
        this.libLike = libLike;
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
    public String getNumero(){
        return this.numero;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }   
    public String getNumeroMin(){
        return this.numeroMin;
    }
    public void setNumeroMin(String numeroMin){
        this.numeroMin = numeroMin;
    }
    public String getNumeroMax(){
        return this.numeroMax;
    }
    public void setNumeroMax(String numeroMax){
        this.numeroMax = numeroMax;
    }
      
    public String getSeuilReussite(){
        return this.seuilReussite;
    }
    public void setSeuilReussite(String seuilReussite){
        this.seuilReussite = seuilReussite;
    }   
    public String getSeuilReussiteMin(){
        return this.seuilReussiteMin;
    }
    public void setSeuilReussiteMin(String seuilReussiteMin){
        this.seuilReussiteMin = seuilReussiteMin;
    }
    public String getSeuilReussiteMax(){
        return this.seuilReussiteMax;
    }
    public void setSeuilReussiteMax(String seuilReussiteMax){
        this.seuilReussiteMax = seuilReussiteMax;
    }
      

    public SectionCriteria getSection(){
        return this.section;
    }

    public void setSection(SectionCriteria section){
        this.section = section;
    }
    public List<SectionCriteria> getSections(){
        return this.sections;
    }

    public void setSections(List<SectionCriteria> sections){
        this.sections = sections;
    }
}
