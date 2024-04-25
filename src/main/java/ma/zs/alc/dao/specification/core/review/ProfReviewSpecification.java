package  ma.zs.alc.dao.specification.core.review;

import ma.zs.alc.dao.criteria.core.review.ProfReviewCriteria;
import ma.zs.alc.bean.core.review.ProfReview;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class ProfReviewSpecification extends  AbstractSpecification<ProfReviewCriteria, ProfReview>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateInt("review", criteria.getReview(), criteria.getReviewMin(), criteria.getReviewMax());
        addPredicate("dateReview", criteria.getDateReview(), criteria.getDateReviewFrom(), criteria.getDateReviewTo());
        addPredicateFk("etudiant","id", criteria.getEtudiant()==null?null:criteria.getEtudiant().getId());
        addPredicateFk("etudiant","id", criteria.getEtudiants());
        addPredicateFk("etudiant","ref", criteria.getEtudiant()==null?null:criteria.getEtudiant().getRef());
        addPredicateFk("prof","id", criteria.getProf()==null?null:criteria.getProf().getId());
        addPredicateFk("prof","id", criteria.getProfs());
        addPredicateFk("prof","ref", criteria.getProf()==null?null:criteria.getProf().getRef());
        addPredicateFk("cours","id", criteria.getCours()==null?null:criteria.getCours().getId());
        addPredicateFk("cours","id", criteria.getCourss());
        addPredicateFk("cours","code", criteria.getCours()==null?null:criteria.getCours().getCode());
    }

    public ProfReviewSpecification(ProfReviewCriteria criteria) {
        super(criteria);
    }

    public ProfReviewSpecification(ProfReviewCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
