package  ma.zs.alc.dao.criteria.core.pack;


import ma.zs.alc.dao.criteria.core.course.ParcoursCriteria;
import ma.zs.alc.dao.criteria.core.price.PriceCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class PackStudentCriteria extends  BaseCriteria  {

    private String nombreCours;
    private String nombreCoursMin;
    private String nombreCoursMax;
    private Boolean forGroupe;
    private String code;
    private String codeLike;
    private String libelle;
    private String libelleLike;
    private String description;
    private String descriptionLike;
    private String preRequisites;
    private String preRequisitesLike;
    private String whyTakeThisCourse;
    private String whyTakeThisCourseLike;
    private String expectations;
    private String expectationsLike;
    private String imgUrl;
    private String imgUrlLike;
    private String totalStudents;
    private String totalStudentsMin;
    private String totalStudentsMax;
    private String rating;
    private String ratingLike;
    private String oldPrice;
    private String oldPriceLike;

    private ParcoursCriteria parcours ;
    private List<ParcoursCriteria> parcourss ;
    private PriceCriteria price ;
    private List<PriceCriteria> prices ;


    public PackStudentCriteria(){}

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
      
    public Boolean getForGroupe(){
        return this.forGroupe;
    }
    public void setForGroupe(Boolean forGroupe){
        this.forGroupe = forGroupe;
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

    public String getPreRequisites(){
        return this.preRequisites;
    }
    public void setPreRequisites(String preRequisites){
        this.preRequisites = preRequisites;
    }
    public String getPreRequisitesLike(){
        return this.preRequisitesLike;
    }
    public void setPreRequisitesLike(String preRequisitesLike){
        this.preRequisitesLike = preRequisitesLike;
    }

    public String getWhyTakeThisCourse(){
        return this.whyTakeThisCourse;
    }
    public void setWhyTakeThisCourse(String whyTakeThisCourse){
        this.whyTakeThisCourse = whyTakeThisCourse;
    }
    public String getWhyTakeThisCourseLike(){
        return this.whyTakeThisCourseLike;
    }
    public void setWhyTakeThisCourseLike(String whyTakeThisCourseLike){
        this.whyTakeThisCourseLike = whyTakeThisCourseLike;
    }

    public String getExpectations(){
        return this.expectations;
    }
    public void setExpectations(String expectations){
        this.expectations = expectations;
    }
    public String getExpectationsLike(){
        return this.expectationsLike;
    }
    public void setExpectationsLike(String expectationsLike){
        this.expectationsLike = expectationsLike;
    }

    public String getImgUrl(){
        return this.imgUrl;
    }
    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }
    public String getImgUrlLike(){
        return this.imgUrlLike;
    }
    public void setImgUrlLike(String imgUrlLike){
        this.imgUrlLike = imgUrlLike;
    }

    public String getTotalStudents(){
        return this.totalStudents;
    }
    public void setTotalStudents(String totalStudents){
        this.totalStudents = totalStudents;
    }   
    public String getTotalStudentsMin(){
        return this.totalStudentsMin;
    }
    public void setTotalStudentsMin(String totalStudentsMin){
        this.totalStudentsMin = totalStudentsMin;
    }
    public String getTotalStudentsMax(){
        return this.totalStudentsMax;
    }
    public void setTotalStudentsMax(String totalStudentsMax){
        this.totalStudentsMax = totalStudentsMax;
    }
      
    public String getRating(){
        return this.rating;
    }
    public void setRating(String rating){
        this.rating = rating;
    }
    public String getRatingLike(){
        return this.ratingLike;
    }
    public void setRatingLike(String ratingLike){
        this.ratingLike = ratingLike;
    }

    public String getOldPrice(){
        return this.oldPrice;
    }
    public void setOldPrice(String oldPrice){
        this.oldPrice = oldPrice;
    }
    public String getOldPriceLike(){
        return this.oldPriceLike;
    }
    public void setOldPriceLike(String oldPriceLike){
        this.oldPriceLike = oldPriceLike;
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
    public PriceCriteria getPrice(){
        return this.price;
    }

    public void setPrice(PriceCriteria price){
        this.price = price;
    }
    public List<PriceCriteria> getPrices(){
        return this.prices;
    }

    public void setPrices(List<PriceCriteria> prices){
        this.prices = prices;
    }
}
