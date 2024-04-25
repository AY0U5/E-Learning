package  ma.zs.alc.dao.specification.core.paiement;

import ma.zs.alc.dao.criteria.core.paiement.PaiementCriteria;
import ma.zs.alc.bean.core.paiement.Paiement;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class PaiementSpecification extends  AbstractSpecification<PaiementCriteria, Paiement>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("datePaiement", criteria.getDatePaiement(), criteria.getDatePaiementFrom(), criteria.getDatePaiementTo());
        addPredicateFk("prof","id", criteria.getProf()==null?null:criteria.getProf().getId());
        addPredicateFk("prof","id", criteria.getProfs());
        addPredicateFk("prof","ref", criteria.getProf()==null?null:criteria.getProf().getRef());
        addPredicateFk("groupeEtudiant","id", criteria.getGroupeEtudiant()==null?null:criteria.getGroupeEtudiant().getId());
        addPredicateFk("groupeEtudiant","id", criteria.getGroupeEtudiants());
    }

    public PaiementSpecification(PaiementCriteria criteria) {
        super(criteria);
    }

    public PaiementSpecification(PaiementCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
