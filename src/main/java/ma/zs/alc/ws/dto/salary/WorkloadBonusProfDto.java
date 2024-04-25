package  ma.zs.alc.ws.dto.salary;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



import ma.zs.alc.ws.dto.prof.ProfDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkloadBonusProfDto  extends AuditBaseDto {

    private Integer mois  = 0 ;
    private Integer annee  = 0 ;

    private WorkloadBonusDto workloadBonus ;
    private ProfDto prof ;
    private SalaryDto salary ;



    public WorkloadBonusProfDto(){
        super();
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


    public WorkloadBonusDto getWorkloadBonus(){
        return this.workloadBonus;
    }

    public void setWorkloadBonus(WorkloadBonusDto workloadBonus){
        this.workloadBonus = workloadBonus;
    }
    public ProfDto getProf(){
        return this.prof;
    }

    public void setProf(ProfDto prof){
        this.prof = prof;
    }
    public SalaryDto getSalary(){
        return this.salary;
    }

    public void setSalary(SalaryDto salary){
        this.salary = salary;
    }






}
