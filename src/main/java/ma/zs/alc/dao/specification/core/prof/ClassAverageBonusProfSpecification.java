package  ma.zs.alc.dao.specification.core.prof;

import ma.zs.alc.dao.criteria.core.prof.ClassAverageBonusProfCriteria;
import ma.zs.alc.bean.core.prof.ClassAverageBonusProf;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class ClassAverageBonusProfSpecification extends  AbstractSpecification<ClassAverageBonusProfCriteria, ClassAverageBonusProf>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateInt("mois", criteria.getMois(), criteria.getMoisMin(), criteria.getMoisMax());
        addPredicateInt("annee", criteria.getAnnee(), criteria.getAnneeMin(), criteria.getAnneeMax());
        addPredicateFk("prof","id", criteria.getProf()==null?null:criteria.getProf().getId());
        addPredicateFk("prof","id", criteria.getProfs());
        addPredicateFk("prof","ref", criteria.getProf()==null?null:criteria.getProf().getRef());
        addPredicateFk("salary","id", criteria.getSalary()==null?null:criteria.getSalary().getId());
        addPredicateFk("salary","id", criteria.getSalarys());
        addPredicateFk("salary","code", criteria.getSalary()==null?null:criteria.getSalary().getCode());
    }

    public ClassAverageBonusProfSpecification(ClassAverageBonusProfCriteria criteria) {
        super(criteria);
    }

    public ClassAverageBonusProfSpecification(ClassAverageBonusProfCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
