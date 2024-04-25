package  ma.zs.alc.dao.specification.core.quiz;

import ma.zs.alc.dao.criteria.core.quiz.ReponseCriteria;
import ma.zs.alc.bean.core.quiz.Reponse;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class ReponseSpecification extends  AbstractSpecification<ReponseCriteria, Reponse>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("lib", criteria.getLib(),criteria.getLibLike());
        addPredicate("etatReponse", criteria.getEtatReponse(),criteria.getEtatReponseLike());
        addPredicateLong("numero", criteria.getNumero(), criteria.getNumeroMin(), criteria.getNumeroMax());
        addPredicateFk("question","id", criteria.getQuestion()==null?null:criteria.getQuestion().getId());
        addPredicateFk("question","id", criteria.getQuestions());
        addPredicateFk("question","libelle", criteria.getQuestion()==null?null:criteria.getQuestion().getLibelle());
    }

    public ReponseSpecification(ReponseCriteria criteria) {
        super(criteria);
    }

    public ReponseSpecification(ReponseCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
