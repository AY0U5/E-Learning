package  ma.zs.alc.dao.specification.core.faq;

import ma.zs.alc.dao.criteria.core.faq.FaqEtudiantCriteria;
import ma.zs.alc.bean.core.faq.FaqEtudiant;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class FaqEtudiantSpecification extends  AbstractSpecification<FaqEtudiantCriteria, FaqEtudiant>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateFk("etudiant","id", criteria.getEtudiant()==null?null:criteria.getEtudiant().getId());
        addPredicateFk("etudiant","id", criteria.getEtudiants());
        addPredicateFk("etudiant","ref", criteria.getEtudiant()==null?null:criteria.getEtudiant().getRef());
        addPredicateFk("admin","id", criteria.getAdmin()==null?null:criteria.getAdmin().getId());
        addPredicateFk("admin","id", criteria.getAdmins());
        addPredicateFk("faqType","id", criteria.getFaqType()==null?null:criteria.getFaqType().getId());
        addPredicateFk("faqType","id", criteria.getFaqTypes());
    }

    public FaqEtudiantSpecification(FaqEtudiantCriteria criteria) {
        super(criteria);
    }

    public FaqEtudiantSpecification(FaqEtudiantCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
