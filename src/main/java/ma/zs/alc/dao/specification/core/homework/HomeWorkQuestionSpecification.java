package  ma.zs.alc.dao.specification.core.homework;

import ma.zs.alc.dao.criteria.core.homework.HomeWorkQuestionCriteria;
import ma.zs.alc.bean.core.homework.HomeWorkQuestion;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class HomeWorkQuestionSpecification extends  AbstractSpecification<HomeWorkQuestionCriteria, HomeWorkQuestion>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateInt("numero", criteria.getNumero(), criteria.getNumeroMin(), criteria.getNumeroMax());
        addPredicateBigDecimal("pointReponseJuste", criteria.getPointReponseJuste(), criteria.getPointReponseJusteMin(), criteria.getPointReponseJusteMax());
        addPredicateBigDecimal("pointReponsefausse", criteria.getPointReponsefausse(), criteria.getPointReponsefausseMin(), criteria.getPointReponsefausseMax());
        addPredicateFk("typeDeQuestion","id", criteria.getTypeDeQuestion()==null?null:criteria.getTypeDeQuestion().getId());
        addPredicateFk("typeDeQuestion","id", criteria.getTypeDeQuestions());
        addPredicateFk("typeDeQuestion","ref", criteria.getTypeDeQuestion()==null?null:criteria.getTypeDeQuestion().getRef());
        addPredicateFk("homeWork","id", criteria.getHomeWork()==null?null:criteria.getHomeWork().getId());
        addPredicateFk("homeWork","id", criteria.getHomeWorks());
    }

    public HomeWorkQuestionSpecification(HomeWorkQuestionCriteria criteria) {
        super(criteria);
    }

    public HomeWorkQuestionSpecification(HomeWorkQuestionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
