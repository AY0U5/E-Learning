package  ma.zs.alc.dao.criteria.core.salary;


import ma.zs.alc.dao.criteria.core.prof.ProfCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class SalaryCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String mois;
    private String moisMin;
    private String moisMax;
    private String annee;
    private String anneeMin;
    private String anneeMax;
    private String nbrSessionMensuel;
    private String nbrSessionMensuelMin;
    private String nbrSessionMensuelMax;
    private Boolean payer;
    private String totalPayment;
    private String totalPaymentMin;
    private String totalPaymentMax;
    private String totalBonusClassAverage;
    private String totalBonusClassAverageMin;
    private String totalBonusClassAverageMax;
    private String totalBonusWorkload;
    private String totalBonusWorkloadMin;
    private String totalBonusWorkloadMax;

    private ProfCriteria prof ;
    private List<ProfCriteria> profs ;


    public SalaryCriteria(){}

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

    public String getMois(){
        return this.mois;
    }
    public void setMois(String mois){
        this.mois = mois;
    }   
    public String getMoisMin(){
        return this.moisMin;
    }
    public void setMoisMin(String moisMin){
        this.moisMin = moisMin;
    }
    public String getMoisMax(){
        return this.moisMax;
    }
    public void setMoisMax(String moisMax){
        this.moisMax = moisMax;
    }
      
    public String getAnnee(){
        return this.annee;
    }
    public void setAnnee(String annee){
        this.annee = annee;
    }   
    public String getAnneeMin(){
        return this.anneeMin;
    }
    public void setAnneeMin(String anneeMin){
        this.anneeMin = anneeMin;
    }
    public String getAnneeMax(){
        return this.anneeMax;
    }
    public void setAnneeMax(String anneeMax){
        this.anneeMax = anneeMax;
    }
      
    public String getNbrSessionMensuel(){
        return this.nbrSessionMensuel;
    }
    public void setNbrSessionMensuel(String nbrSessionMensuel){
        this.nbrSessionMensuel = nbrSessionMensuel;
    }   
    public String getNbrSessionMensuelMin(){
        return this.nbrSessionMensuelMin;
    }
    public void setNbrSessionMensuelMin(String nbrSessionMensuelMin){
        this.nbrSessionMensuelMin = nbrSessionMensuelMin;
    }
    public String getNbrSessionMensuelMax(){
        return this.nbrSessionMensuelMax;
    }
    public void setNbrSessionMensuelMax(String nbrSessionMensuelMax){
        this.nbrSessionMensuelMax = nbrSessionMensuelMax;
    }
      
    public Boolean getPayer(){
        return this.payer;
    }
    public void setPayer(Boolean payer){
        this.payer = payer;
    }
    public String getTotalPayment(){
        return this.totalPayment;
    }
    public void setTotalPayment(String totalPayment){
        this.totalPayment = totalPayment;
    }   
    public String getTotalPaymentMin(){
        return this.totalPaymentMin;
    }
    public void setTotalPaymentMin(String totalPaymentMin){
        this.totalPaymentMin = totalPaymentMin;
    }
    public String getTotalPaymentMax(){
        return this.totalPaymentMax;
    }
    public void setTotalPaymentMax(String totalPaymentMax){
        this.totalPaymentMax = totalPaymentMax;
    }
      
    public String getTotalBonusClassAverage(){
        return this.totalBonusClassAverage;
    }
    public void setTotalBonusClassAverage(String totalBonusClassAverage){
        this.totalBonusClassAverage = totalBonusClassAverage;
    }   
    public String getTotalBonusClassAverageMin(){
        return this.totalBonusClassAverageMin;
    }
    public void setTotalBonusClassAverageMin(String totalBonusClassAverageMin){
        this.totalBonusClassAverageMin = totalBonusClassAverageMin;
    }
    public String getTotalBonusClassAverageMax(){
        return this.totalBonusClassAverageMax;
    }
    public void setTotalBonusClassAverageMax(String totalBonusClassAverageMax){
        this.totalBonusClassAverageMax = totalBonusClassAverageMax;
    }
      
    public String getTotalBonusWorkload(){
        return this.totalBonusWorkload;
    }
    public void setTotalBonusWorkload(String totalBonusWorkload){
        this.totalBonusWorkload = totalBonusWorkload;
    }   
    public String getTotalBonusWorkloadMin(){
        return this.totalBonusWorkloadMin;
    }
    public void setTotalBonusWorkloadMin(String totalBonusWorkloadMin){
        this.totalBonusWorkloadMin = totalBonusWorkloadMin;
    }
    public String getTotalBonusWorkloadMax(){
        return this.totalBonusWorkloadMax;
    }
    public void setTotalBonusWorkloadMax(String totalBonusWorkloadMax){
        this.totalBonusWorkloadMax = totalBonusWorkloadMax;
    }
      

    public ProfCriteria getProf(){
        return this.prof;
    }

    public void setProf(ProfCriteria prof){
        this.prof = prof;
    }
    public List<ProfCriteria> getProfs(){
        return this.profs;
    }

    public void setProfs(List<ProfCriteria> profs){
        this.profs = profs;
    }
}
