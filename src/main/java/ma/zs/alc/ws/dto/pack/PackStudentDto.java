package  ma.zs.alc.ws.dto.pack;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



import ma.zs.alc.ws.dto.course.ParcoursDto;
import ma.zs.alc.ws.dto.price.PriceDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PackStudentDto  extends AuditBaseDto {

    private Integer nombreCours  = 0 ;
    private Boolean forGroupe  ;
    private String code  ;
    private String libelle  ;
    private String description  ;
    private String preRequisites  ;
    private String whyTakeThisCourse  ;
    private String expectations  ;
    private String imgUrl  ;
    private Integer totalStudents  = 0 ;
    private String rating  ;
    private String oldPrice  ;

    private ParcoursDto parcours ;
    private PriceDto price ;



    public PackStudentDto(){
        super();
    }



    @Log
    public Integer getNombreCours(){
        return this.nombreCours;
    }
    public void setNombreCours(Integer nombreCours){
        this.nombreCours = nombreCours;
    }

    @Log
    public Boolean getForGroupe(){
        return this.forGroupe;
    }
    public void setForGroupe(Boolean forGroupe){
        this.forGroupe = forGroupe;
    }

    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Log
    public String getPreRequisites(){
        return this.preRequisites;
    }
    public void setPreRequisites(String preRequisites){
        this.preRequisites = preRequisites;
    }

    @Log
    public String getWhyTakeThisCourse(){
        return this.whyTakeThisCourse;
    }
    public void setWhyTakeThisCourse(String whyTakeThisCourse){
        this.whyTakeThisCourse = whyTakeThisCourse;
    }

    @Log
    public String getExpectations(){
        return this.expectations;
    }
    public void setExpectations(String expectations){
        this.expectations = expectations;
    }

    @Log
    public String getImgUrl(){
        return this.imgUrl;
    }
    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }

    @Log
    public Integer getTotalStudents(){
        return this.totalStudents;
    }
    public void setTotalStudents(Integer totalStudents){
        this.totalStudents = totalStudents;
    }

    @Log
    public String getRating(){
        return this.rating;
    }
    public void setRating(String rating){
        this.rating = rating;
    }

    @Log
    public String getOldPrice(){
        return this.oldPrice;
    }
    public void setOldPrice(String oldPrice){
        this.oldPrice = oldPrice;
    }


    public ParcoursDto getParcours(){
        return this.parcours;
    }

    public void setParcours(ParcoursDto parcours){
        this.parcours = parcours;
    }
    public PriceDto getPrice(){
        return this.price;
    }

    public void setPrice(PriceDto price){
        this.price = price;
    }






}
