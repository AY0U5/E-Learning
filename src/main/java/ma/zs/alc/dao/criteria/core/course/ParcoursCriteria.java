package  ma.zs.alc.dao.criteria.core.course;


import ma.zs.alc.dao.criteria.core.courseref.CentreCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ParcoursCriteria extends  BaseCriteria  {

    private LocalDateTime datePublication;
    private LocalDateTime datePublicationFrom;
    private LocalDateTime datePublicationTo;
    private LocalDateTime dateCreation;
    private LocalDateTime dateCreationFrom;
    private LocalDateTime dateCreationTo;
    private String description;
    private String descriptionLike;
    private String code;
    private String codeLike;
    private String libelle;
    private String libelleLike;
    private String numeroOrder;
    private String numeroOrderMin;
    private String numeroOrderMax;
    private String nombreCours;
    private String nombreCoursMin;
    private String nombreCoursMax;

    private CentreCriteria centre ;
    private List<CentreCriteria> centres ;


    public ParcoursCriteria(){}

    public LocalDateTime getDatePublication(){
        return this.datePublication;
    }
    public void setDatePublication(LocalDateTime datePublication){
        this.datePublication = datePublication;
    }
    public LocalDateTime getDatePublicationFrom(){
        return this.datePublicationFrom;
    }
    public void setDatePublicationFrom(LocalDateTime datePublicationFrom){
        this.datePublicationFrom = datePublicationFrom;
    }
    public LocalDateTime getDatePublicationTo(){
        return this.datePublicationTo;
    }
    public void setDatePublicationTo(LocalDateTime datePublicationTo){
        this.datePublicationTo = datePublicationTo;
    }
    public LocalDateTime getDateCreation(){
        return this.dateCreation;
    }
    public void setDateCreation(LocalDateTime dateCreation){
        this.dateCreation = dateCreation;
    }
    public LocalDateTime getDateCreationFrom(){
        return this.dateCreationFrom;
    }
    public void setDateCreationFrom(LocalDateTime dateCreationFrom){
        this.dateCreationFrom = dateCreationFrom;
    }
    public LocalDateTime getDateCreationTo(){
        return this.dateCreationTo;
    }
    public void setDateCreationTo(LocalDateTime dateCreationTo){
        this.dateCreationTo = dateCreationTo;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }

    public String getNumeroOrder(){
        return this.numeroOrder;
    }
    public void setNumeroOrder(String numeroOrder){
        this.numeroOrder = numeroOrder;
    }   
    public String getNumeroOrderMin(){
        return this.numeroOrderMin;
    }
    public void setNumeroOrderMin(String numeroOrderMin){
        this.numeroOrderMin = numeroOrderMin;
    }
    public String getNumeroOrderMax(){
        return this.numeroOrderMax;
    }
    public void setNumeroOrderMax(String numeroOrderMax){
        this.numeroOrderMax = numeroOrderMax;
    }
      
    public String getNombreCours(){
        return this.nombreCours;
    }
    public void setNombreCours(String nombreCours){
        this.nombreCours = nombreCours;
    }   
    public String getNombreCoursMin(){
        return this.nombreCoursMin;
    }
    public void setNombreCoursMin(String nombreCoursMin){
        this.nombreCoursMin = nombreCoursMin;
    }
    public String getNombreCoursMax(){
        return this.nombreCoursMax;
    }
    public void setNombreCoursMax(String nombreCoursMax){
        this.nombreCoursMax = nombreCoursMax;
    }
      

    public CentreCriteria getCentre(){
        return this.centre;
    }

    public void setCentre(CentreCriteria centre){
        this.centre = centre;
    }
    public List<CentreCriteria> getCentres(){
        return this.centres;
    }

    public void setCentres(List<CentreCriteria> centres){
        this.centres = centres;
    }
}
