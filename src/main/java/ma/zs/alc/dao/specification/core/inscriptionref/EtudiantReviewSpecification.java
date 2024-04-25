package  ma.zs.alc.dao.specification.core.inscriptionref;

import ma.zs.alc.dao.criteria.core.inscriptionref.EtudiantReviewCriteria;
import ma.zs.alc.bean.core.inscriptionref.EtudiantReview;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class EtudiantReviewSpecification extends  AbstractSpecification<EtudiantReviewCriteria, EtudiantReview>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateInt("review", criteria.getReview(), criteria.getReviewMin(), criteria.getReviewMax());
        addPredicate("comment", criteria.getComment(),criteria.getCommentLike());
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

    public EtudiantReviewSpecification(EtudiantReviewCriteria criteria) {
        super(criteria);
    }

    public EtudiantReviewSpecification(EtudiantReviewCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
