package  ma.zs.alc.ws.dto.price;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceDto  extends AuditBaseDto {

    private BigDecimal price  ;
    private BigDecimal oldPrice  ;
    private String lib  ;
    private BigDecimal nreCourse  ;
    private BigDecimal nreHours  ;
    private BigDecimal nreMonth  ;
    private Boolean forGroup  ;




    public PriceDto(){
        super();
    }



    @Log
    public BigDecimal getPrice(){
        return this.price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }

    @Log
    public BigDecimal getOldPrice(){
        return this.oldPrice;
    }
    public void setOldPrice(BigDecimal oldPrice){
        this.oldPrice = oldPrice;
    }

    @Log
    public String getLib(){
        return this.lib;
    }
    public void setLib(String lib){
        this.lib = lib;
    }

    @Log
    public BigDecimal getNreCourse(){
        return this.nreCourse;
    }
    public void setNreCourse(BigDecimal nreCourse){
        this.nreCourse = nreCourse;
    }

    @Log
    public BigDecimal getNreHours(){
        return this.nreHours;
    }
    public void setNreHours(BigDecimal nreHours){
        this.nreHours = nreHours;
    }

    @Log
    public BigDecimal getNreMonth(){
        return this.nreMonth;
    }
    public void setNreMonth(BigDecimal nreMonth){
        this.nreMonth = nreMonth;
    }

    @Log
    public Boolean getForGroup(){
        return this.forGroup;
    }
    public void setForGroup(Boolean forGroup){
        this.forGroup = forGroup;
    }








}
