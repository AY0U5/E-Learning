package  ma.zs.alc.dao.criteria.core.salary;


import ma.zs.alc.dao.criteria.core.prof.ProfCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class WorkloadBonusProfCriteria extends  BaseCriteria  {

    private String mois;
    private String moisMin;
    private String moisMax;
    private String annee;
    private String anneeMin;
    private String anneeMax;

    private WorkloadBonusCriteria workloadBonus ;
    private List<WorkloadBonusCriteria> workloadBonuss ;
    private ProfCriteria prof ;
    private List<ProfCriteria> profs ;
    private SalaryCriteria salary ;
    private List<SalaryCriteria> salarys ;


    public WorkloadBonusProfCriteria(){}

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
      

    public WorkloadBonusCriteria getWorkloadBonus(){
        return this.workloadBonus;
    }

    public void setWorkloadBonus(WorkloadBonusCriteria workloadBonus){
        this.workloadBonus = workloadBonus;
    }
    public List<WorkloadBonusCriteria> getWorkloadBonuss(){
        return this.workloadBonuss;
    }

    public void setWorkloadBonuss(List<WorkloadBonusCriteria> workloadBonuss){
        this.workloadBonuss = workloadBonuss;
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
    public SalaryCriteria getSalary(){
        return this.salary;
    }

    public void setSalary(SalaryCriteria salary){
        this.salary = salary;
    }
    public List<SalaryCriteria> getSalarys(){
        return this.salarys;
    }

    public void setSalarys(List<SalaryCriteria> salarys){
        this.salarys = salarys;
    }
}
