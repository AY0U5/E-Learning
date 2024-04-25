package  ma.zs.alc.dao.criteria.core.price;



import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class PriceCriteria extends  BaseCriteria  {

    private String price;
    private String priceMin;
    private String priceMax;
    private String oldPrice;
    private String oldPriceMin;
    private String oldPriceMax;
    private String lib;
    private String libLike;
    private String nreCourse;
    private String nreCourseMin;
    private String nreCourseMax;
    private String nreHours;
    private String nreHoursMin;
    private String nreHoursMax;
    private String nreMonth;
    private String nreMonthMin;
    private String nreMonthMax;
    private Boolean forGroup;



    public PriceCriteria(){}

    public String getPrice(){
        return this.price;
    }
    public void setPrice(String price){
        this.price = price;
    }   
    public String getPriceMin(){
        return this.priceMin;
    }
    public void setPriceMin(String priceMin){
        this.priceMin = priceMin;
    }
    public String getPriceMax(){
        return this.priceMax;
    }
    public void setPriceMax(String priceMax){
        this.priceMax = priceMax;
    }
      
    public String getOldPrice(){
        return this.oldPrice;
    }
    public void setOldPrice(String oldPrice){
        this.oldPrice = oldPrice;
    }   
    public String getOldPriceMin(){
        return this.oldPriceMin;
    }
    public void setOldPriceMin(String oldPriceMin){
        this.oldPriceMin = oldPriceMin;
    }
    public String getOldPriceMax(){
        return this.oldPriceMax;
    }
    public void setOldPriceMax(String oldPriceMax){
        this.oldPriceMax = oldPriceMax;
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

    public String getNreCourse(){
        return this.nreCourse;
    }
    public void setNreCourse(String nreCourse){
        this.nreCourse = nreCourse;
    }   
    public String getNreCourseMin(){
        return this.nreCourseMin;
    }
    public void setNreCourseMin(String nreCourseMin){
        this.nreCourseMin = nreCourseMin;
    }
    public String getNreCourseMax(){
        return this.nreCourseMax;
    }
    public void setNreCourseMax(String nreCourseMax){
        this.nreCourseMax = nreCourseMax;
    }
      
    public String getNreHours(){
        return this.nreHours;
    }
    public void setNreHours(String nreHours){
        this.nreHours = nreHours;
    }   
    public String getNreHoursMin(){
        return this.nreHoursMin;
    }
    public void setNreHoursMin(String nreHoursMin){
        this.nreHoursMin = nreHoursMin;
    }
    public String getNreHoursMax(){
        return this.nreHoursMax;
    }
    public void setNreHoursMax(String nreHoursMax){
        this.nreHoursMax = nreHoursMax;
    }
      
    public String getNreMonth(){
        return this.nreMonth;
    }
    public void setNreMonth(String nreMonth){
        this.nreMonth = nreMonth;
    }   
    public String getNreMonthMin(){
        return this.nreMonthMin;
    }
    public void setNreMonthMin(String nreMonthMin){
        this.nreMonthMin = nreMonthMin;
    }
    public String getNreMonthMax(){
        return this.nreMonthMax;
    }
    public void setNreMonthMax(String nreMonthMax){
        this.nreMonthMax = nreMonthMax;
    }
      
    public Boolean getForGroup(){
        return this.forGroup;
    }
    public void setForGroup(Boolean forGroup){
        this.forGroup = forGroup;
    }

}
