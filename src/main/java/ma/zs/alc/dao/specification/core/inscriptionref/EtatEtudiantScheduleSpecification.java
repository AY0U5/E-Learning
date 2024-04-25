package  ma.zs.alc.dao.specification.core.inscriptionref;

import ma.zs.alc.dao.criteria.core.inscriptionref.EtatEtudiantScheduleCriteria;
import ma.zs.alc.bean.core.inscriptionref.EtatEtudiantSchedule;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class EtatEtudiantScheduleSpecification extends  AbstractSpecification<EtatEtudiantScheduleCriteria, EtatEtudiantSchedule>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("couleur", criteria.getCouleur(),criteria.getCouleurLike());
    }

    public EtatEtudiantScheduleSpecification(EtatEtudiantScheduleCriteria criteria) {
        super(criteria);
    }

    public EtatEtudiantScheduleSpecification(EtatEtudiantScheduleCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
