package  ma.zs.alc.ws.dto.salary;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zs.alc.ws.dto.prof.ProfDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalaryDto  extends AuditBaseDto {

    private String code  ;
    private Integer mois  = 0 ;
    private Integer annee  = 0 ;
    private BigDecimal nbrSessionMensuel  ;
    private Boolean payer  ;
    private BigDecimal totalPayment  ;
    private BigDecimal totalBonusClassAverage  ;
    private BigDecimal totalBonusWorkload  ;

    private ProfDto prof ;



    public SalaryDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public Integer getMois(){
        return this.mois;
    }
    public void setMois(Integer mois){
        this.mois = mois;
    }

    @Log
    public Integer getAnnee(){
        return this.annee;
    }
    public void setAnnee(Integer annee){
        this.annee = annee;
    }

    @Log
    public BigDecimal getNbrSessionMensuel(){
        return this.nbrSessionMensuel;
    }
    public void setNbrSessionMensuel(BigDecimal nbrSessionMensuel){
        this.nbrSessionMensuel = nbrSessionMensuel;
    }

    @Log
    public Boolean getPayer(){
        return this.payer;
    }
    public void setPayer(Boolean payer){
        this.payer = payer;
    }

    @Log
    public BigDecimal getTotalPayment(){
        return this.totalPayment;
    }
    public void setTotalPayment(BigDecimal totalPayment){
        this.totalPayment = totalPayment;
    }

    @Log
    public BigDecimal getTotalBonusClassAverage(){
        return this.totalBonusClassAverage;
    }
    public void setTotalBonusClassAverage(BigDecimal totalBonusClassAverage){
        this.totalBonusClassAverage = totalBonusClassAverage;
    }

    @Log
    public BigDecimal getTotalBonusWorkload(){
        return this.totalBonusWorkload;
    }
    public void setTotalBonusWorkload(BigDecimal totalBonusWorkload){
        this.totalBonusWorkload = totalBonusWorkload;
    }


    public ProfDto getProf(){
        return this.prof;
    }

    public void setProf(ProfDto prof){
        this.prof = prof;
    }






}
