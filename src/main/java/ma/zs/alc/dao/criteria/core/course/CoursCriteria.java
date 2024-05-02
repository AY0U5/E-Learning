package  ma.zs.alc.dao.criteria.core.course;


import ma.zs.alc.dao.criteria.core.courseref.EtatCoursCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class CoursCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String libelle;
    private String libelleLike;
    private String description;
    private String descriptionLike;
    private String image;
    private String imageLike;
    private String nombreSectionFinalise;
    private String nombreSectionFinaliseMin;
    private String nombreSectionFinaliseMax;
    private String nombreSectionEnCours;
    private String nombreSectionEnCoursMin;
    private String nombreSectionEnCoursMax;
    private String nombreLinkEnCours;
    private String nombreLinkEnCoursMin;
    private String nombreLinkEnCoursMax;
    private String nombreLinkFinalise;
    private String nombreLinkFinaliseMin;
    private String nombreLinkFinaliseMax;
    private String numeroOrder;
    private String numeroOrderMin;
    private String numeroOrderMax;

    private String nombreSection;
    private String nombreSectionMin;
    private String nombreSectionMax;


    private EtatCoursCriteria etatCours ;
    private List<EtatCoursCriteria> etatCourss ;
    private ParcoursCriteria parcours ;
    private List<ParcoursCriteria> parcourss ;


    public CoursCriteria(){}

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

    public String getImage(){
        return this.image;
    }
    public void setImage(String image){
        this.image = image;
    }
    public String getImageLike(){
        return this.imageLike;
    }
    public void setImageLike(String imageLike){
        this.imageLike = imageLike;
    }

    public String getNombreSectionFinalise(){
        return this.nombreSectionFinalise;
    }
    public void setNombreSectionFinalise(String nombreSectionFinalise){
        this.nombreSectionFinalise = nombreSectionFinalise;
    }   
    public String getNombreSectionFinaliseMin(){
        return this.nombreSectionFinaliseMin;
    }
    public void setNombreSectionFinaliseMin(String nombreSectionFinaliseMin){
        this.nombreSectionFinaliseMin = nombreSectionFinaliseMin;
    }
    public String getNombreSectionFinaliseMax(){
        return this.nombreSectionFinaliseMax;
    }
    public void setNombreSectionFinaliseMax(String nombreSectionFinaliseMax){
        this.nombreSectionFinaliseMax = nombreSectionFinaliseMax;
    }
      
    public String getNombreSectionEnCours(){
        return this.nombreSectionEnCours;
    }
    public void setNombreSectionEnCours(String nombreSectionEnCours){
        this.nombreSectionEnCours = nombreSectionEnCours;
    }   
    public String getNombreSectionEnCoursMin(){
        return this.nombreSectionEnCoursMin;
    }
    public void setNombreSectionEnCoursMin(String nombreSectionEnCoursMin){
        this.nombreSectionEnCoursMin = nombreSectionEnCoursMin;
    }
    public String getNombreSectionEnCoursMax(){
        return this.nombreSectionEnCoursMax;
    }
    public void setNombreSectionEnCoursMax(String nombreSectionEnCoursMax){
        this.nombreSectionEnCoursMax = nombreSectionEnCoursMax;
    }
      
    public String getNombreLinkEnCours(){
        return this.nombreLinkEnCours;
    }
    public void setNombreLinkEnCours(String nombreLinkEnCours){
        this.nombreLinkEnCours = nombreLinkEnCours;
    }   
    public String getNombreLinkEnCoursMin(){
        return this.nombreLinkEnCoursMin;
    }
    public void setNombreLinkEnCoursMin(String nombreLinkEnCoursMin){
        this.nombreLinkEnCoursMin = nombreLinkEnCoursMin;
    }
    public String getNombreLinkEnCoursMax(){
        return this.nombreLinkEnCoursMax;
    }
    public void setNombreLinkEnCoursMax(String nombreLinkEnCoursMax){
        this.nombreLinkEnCoursMax = nombreLinkEnCoursMax;
    }
      
    public String getNombreLinkFinalise(){
        return this.nombreLinkFinalise;
    }
    public void setNombreLinkFinalise(String nombreLinkFinalise){
        this.nombreLinkFinalise = nombreLinkFinalise;
    }   
    public String getNombreLinkFinaliseMin(){
        return this.nombreLinkFinaliseMin;
    }
    public void setNombreLinkFinaliseMin(String nombreLinkFinaliseMin){
        this.nombreLinkFinaliseMin = nombreLinkFinaliseMin;
    }
    public String getNombreLinkFinaliseMax(){
        return this.nombreLinkFinaliseMax;
    }
    public void setNombreLinkFinaliseMax(String nombreLinkFinaliseMax){
        this.nombreLinkFinaliseMax = nombreLinkFinaliseMax;
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

    public String getNombreSection(){
        return this.nombreSection;
    }
    public void setNombreSection(String nombreSection){
        this.nombreSection = nombreSection;
    }
    public String getNombreSectionMin(){
        return this.nombreSectionMin;
    }
    public void setNombreSectionMin(String nombreSectionMin){
        this.nombreSectionMin = nombreSectionMin;
    }
    public String getNombreSectionMax(){
        return this.nombreSectionMax;
    }
    public void setNombreSectionMax(String nombreSectionMax){
        this.nombreSectionMax = nombreSectionMax;
    }

    public EtatCoursCriteria getEtatCours(){
        return this.etatCours;
    }

    public void setEtatCours(EtatCoursCriteria etatCours){
        this.etatCours = etatCours;
    }
    public List<EtatCoursCriteria> getEtatCourss(){
        return this.etatCourss;
    }

    public void setEtatCourss(List<EtatCoursCriteria> etatCourss){
        this.etatCourss = etatCourss;
    }
    public ParcoursCriteria getParcours(){
        return this.parcours;
    }

    public void setParcours(ParcoursCriteria parcours){
        this.parcours = parcours;
    }
    public List<ParcoursCriteria> getParcourss(){
        return this.parcourss;
    }

    public void setParcourss(List<ParcoursCriteria> parcourss){
        this.parcourss = parcourss;
    }
}
