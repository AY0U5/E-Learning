package  ma.zs.alc.dao.specification.core.salary;

import ma.zs.alc.dao.criteria.core.salary.WorkloadBonusProfCriteria;
import ma.zs.alc.bean.core.salary.WorkloadBonusProf;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class WorkloadBonusProfSpecification extends  AbstractSpecification<WorkloadBonusProfCriteria, WorkloadBonusProf>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateInt("mois", criteria.getMois(), criteria.getMoisMin(), criteria.getMoisMax());
        addPredicateInt("annee", criteria.getAnnee(), criteria.getAnneeMin(), criteria.getAnneeMax());
        addPredicateFk("workloadBonus","id", criteria.getWorkloadBonus()==null?null:criteria.getWorkloadBonus().getId());
        addPredicateFk("workloadBonus","id", criteria.getWorkloadBonuss());
        addPredicateFk("workloadBonus","code", criteria.getWorkloadBonus()==null?null:criteria.getWorkloadBonus().getCode());
        addPredicateFk("prof","id", criteria.getProf()==null?null:criteria.getProf().getId());
        addPredicateFk("prof","id", criteria.getProfs());
        addPredicateFk("prof","ref", criteria.getProf()==null?null:criteria.getProf().getRef());
        addPredicateFk("salary","id", criteria.getSalary()==null?null:criteria.getSalary().getId());
        addPredicateFk("salary","id", criteria.getSalarys());
        addPredicateFk("salary","code", criteria.getSalary()==null?null:criteria.getSalary().getCode());
    }

    public WorkloadBonusProfSpecification(WorkloadBonusProfCriteria criteria) {
        super(criteria);
    }

    public WorkloadBonusProfSpecification(WorkloadBonusProfCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
