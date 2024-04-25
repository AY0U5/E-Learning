package  ma.zs.alc.dao.criteria.core.freetrial;



import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class FreeTrialConfigurationCriteria extends  BaseCriteria  {

    private LocalDateTime dateApplicationDebut;
    private LocalDateTime dateApplicationDebutFrom;
    private LocalDateTime dateApplicationDebutTo;
    private LocalDateTime dateApplicationFin;
    private LocalDateTime dateApplicationFinFrom;
    private LocalDateTime dateApplicationFinTo;
    private String nombreStudentMax;
    private String nombreStudentMaxMin;
    private String nombreStudentMaxMax;
    private String nombreStudentMin;
    private String nombreStudentMinMin;
    private String nombreStudentMinMax;



    public FreeTrialConfigurationCriteria(){}

    public LocalDateTime getDateApplicationDebut(){
        return this.dateApplicationDebut;
    }
    public void setDateApplicationDebut(LocalDateTime dateApplicationDebut){
        this.dateApplicationDebut = dateApplicationDebut;
    }
    public LocalDateTime getDateApplicationDebutFrom(){
        return this.dateApplicationDebutFrom;
    }
    public void setDateApplicationDebutFrom(LocalDateTime dateApplicationDebutFrom){
        this.dateApplicationDebutFrom = dateApplicationDebutFrom;
    }
    public LocalDateTime getDateApplicationDebutTo(){
        return this.dateApplicationDebutTo;
    }
    public void setDateApplicationDebutTo(LocalDateTime dateApplicationDebutTo){
        this.dateApplicationDebutTo = dateApplicationDebutTo;
    }
    public LocalDateTime getDateApplicationFin(){
        return this.dateApplicationFin;
    }
    public void setDateApplicationFin(LocalDateTime dateApplicationFin){
        this.dateApplicationFin = dateApplicationFin;
    }
    public LocalDateTime getDateApplicationFinFrom(){
        return this.dateApplicationFinFrom;
    }
    public void setDateApplicationFinFrom(LocalDateTime dateApplicationFinFrom){
        this.dateApplicationFinFrom = dateApplicationFinFrom;
    }
    public LocalDateTime getDateApplicationFinTo(){
        return this.dateApplicationFinTo;
    }
    public void setDateApplicationFinTo(LocalDateTime dateApplicationFinTo){
        this.dateApplicationFinTo = dateApplicationFinTo;
    }
    public String getNombreStudentMax(){
        return this.nombreStudentMax;
    }
    public void setNombreStudentMax(String nombreStudentMax){
        this.nombreStudentMax = nombreStudentMax;
    }   
    public String getNombreStudentMaxMin(){
        return this.nombreStudentMaxMin;
    }
    public void setNombreStudentMaxMin(String nombreStudentMaxMin){
        this.nombreStudentMaxMin = nombreStudentMaxMin;
    }
    public String getNombreStudentMaxMax(){
        return this.nombreStudentMaxMax;
    }
    public void setNombreStudentMaxMax(String nombreStudentMaxMax){
        this.nombreStudentMaxMax = nombreStudentMaxMax;
    }
      
    public String getNombreStudentMin(){
        return this.nombreStudentMin;
    }
    public void setNombreStudentMin(String nombreStudentMin){
        this.nombreStudentMin = nombreStudentMin;
    }   
    public String getNombreStudentMinMin(){
        return this.nombreStudentMinMin;
    }
    public void setNombreStudentMinMin(String nombreStudentMinMin){
        this.nombreStudentMinMin = nombreStudentMinMin;
    }
    public String getNombreStudentMinMax(){
        return this.nombreStudentMinMax;
    }
    public void setNombreStudentMinMax(String nombreStudentMinMax){
        this.nombreStudentMinMax = nombreStudentMinMax;
    }
      

}
