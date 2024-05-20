package  ma.zs.alc.dao.specification.core.courseref;

import ma.zs.alc.bean.core.courseref.EtatParcours;
import ma.zs.alc.dao.criteria.core.courseref.EtatCoursCriteria;
import ma.zs.alc.bean.core.courseref.EtatCours;
import ma.zs.alc.dao.criteria.core.courseref.EtatParcoursCriteria;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class EtatParcoursSpecification extends  AbstractSpecification<EtatParcoursCriteria, EtatParcours>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }


    public EtatParcoursSpecification(EtatParcoursCriteria criteria) {
        super(criteria);
    }

    public EtatParcoursSpecification(EtatParcoursCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }


}
