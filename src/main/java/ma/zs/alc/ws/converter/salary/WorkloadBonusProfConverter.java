package  ma.zs.alc.ws.converter.salary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.alc.ws.converter.salary.SalaryConverter;
import ma.zs.alc.ws.converter.salary.WorkloadBonusConverter;
import ma.zs.alc.ws.converter.prof.ProfConverter;

import ma.zs.alc.bean.core.prof.Prof;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.salary.WorkloadBonusProf;
import ma.zs.alc.ws.dto.salary.WorkloadBonusProfDto;

@Component
public class WorkloadBonusProfConverter extends AbstractConverter<WorkloadBonusProf, WorkloadBonusProfDto> {

    @Autowired
    private SalaryConverter salaryConverter ;
    @Autowired
    private WorkloadBonusConverter workloadBonusConverter ;
    @Autowired
    private ProfConverter profConverter ;
    private boolean workloadBonus;
    private boolean prof;
    private boolean salary;

    public  WorkloadBonusProfConverter() {
        super(WorkloadBonusProf.class, WorkloadBonusProfDto.class);
        init(true);
    }

    @Override
    public WorkloadBonusProf toItem(WorkloadBonusProfDto dto) {
        if (dto == null) {
            return null;
        } else {
        WorkloadBonusProf item = new WorkloadBonusProf();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getMois()))
                item.setMois(dto.getMois());
            if(StringUtil.isNotEmpty(dto.getAnnee()))
                item.setAnnee(dto.getAnnee());
            if(this.workloadBonus && dto.getWorkloadBonus()!=null)
                item.setWorkloadBonus(workloadBonusConverter.toItem(dto.getWorkloadBonus())) ;

            if(dto.getProf() != null && dto.getProf().getId() != null){
                item.setProf(new Prof());
                item.getProf().setId(dto.getProf().getId());
                item.getProf().setRef(dto.getProf().getRef());
            }

            if(this.salary && dto.getSalary()!=null)
                item.setSalary(salaryConverter.toItem(dto.getSalary())) ;




        return item;
        }
    }

    @Override
    public WorkloadBonusProfDto toDto(WorkloadBonusProf item) {
        if (item == null) {
            return null;
        } else {
            WorkloadBonusProfDto dto = new WorkloadBonusProfDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getMois()))
                dto.setMois(item.getMois());
            if(StringUtil.isNotEmpty(item.getAnnee()))
                dto.setAnnee(item.getAnnee());
            if(this.workloadBonus && item.getWorkloadBonus()!=null) {
                dto.setWorkloadBonus(workloadBonusConverter.toDto(item.getWorkloadBonus())) ;

            }
            if(this.prof && item.getProf()!=null) {
                dto.setProf(profConverter.toDto(item.getProf())) ;

            }
            if(this.salary && item.getSalary()!=null) {
                dto.setSalary(salaryConverter.toDto(item.getSalary())) ;

            }


        return dto;
        }
    }

    public void copy(WorkloadBonusProfDto dto, WorkloadBonusProf t) {
    super.copy(dto, t);
    if (dto.getWorkloadBonus() != null)
        workloadBonusConverter.copy(dto.getWorkloadBonus(), t.getWorkloadBonus());
    if (dto.getProf() != null)
        profConverter.copy(dto.getProf(), t.getProf());
    if (dto.getSalary() != null)
        salaryConverter.copy(dto.getSalary(), t.getSalary());
    }



    public void initObject(boolean value) {
        this.workloadBonus = value;
        this.prof = value;
        this.salary = value;
    }


    public SalaryConverter getSalaryConverter(){
        return this.salaryConverter;
    }
    public void setSalaryConverter(SalaryConverter salaryConverter ){
        this.salaryConverter = salaryConverter;
    }
    public WorkloadBonusConverter getWorkloadBonusConverter(){
        return this.workloadBonusConverter;
    }
    public void setWorkloadBonusConverter(WorkloadBonusConverter workloadBonusConverter ){
        this.workloadBonusConverter = workloadBonusConverter;
    }
    public ProfConverter getProfConverter(){
        return this.profConverter;
    }
    public void setProfConverter(ProfConverter profConverter ){
        this.profConverter = profConverter;
    }
    public boolean  isWorkloadBonus(){
        return this.workloadBonus;
    }
    public void  setWorkloadBonus(boolean workloadBonus){
        this.workloadBonus = workloadBonus;
    }
    public boolean  isProf(){
        return this.prof;
    }
    public void  setProf(boolean prof){
        this.prof = prof;
    }
    public boolean  isSalary(){
        return this.salary;
    }
    public void  setSalary(boolean salary){
        this.salary = salary;
    }
}
