package  ma.zs.alc.dao.specification.core.quiz;

import ma.zs.alc.dao.criteria.core.quiz.QuestionCriteria;
import ma.zs.alc.bean.core.quiz.Question;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class QuestionSpecification extends  AbstractSpecification<QuestionCriteria, Question>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("urlImg", criteria.getUrlImg(),criteria.getUrlImgLike());
        addPredicate("urlVideo", criteria.getUrlVideo(),criteria.getUrlVideoLike());
        addPredicateLong("numero", criteria.getNumero(), criteria.getNumeroMin(), criteria.getNumeroMax());
        addPredicateBigDecimal("pointReponseJuste", criteria.getPointReponseJuste(), criteria.getPointReponseJusteMin(), criteria.getPointReponseJusteMax());
        addPredicateBigDecimal("pointReponsefausse", criteria.getPointReponsefausse(), criteria.getPointReponsefausseMin(), criteria.getPointReponsefausseMax());
        addPredicateFk("typeDeQuestion","id", criteria.getTypeDeQuestion()==null?null:criteria.getTypeDeQuestion().getId());
        addPredicateFk("typeDeQuestion","id", criteria.getTypeDeQuestions());
        addPredicateFk("typeDeQuestion","ref", criteria.getTypeDeQuestion()==null?null:criteria.getTypeDeQuestion().getRef());
        addPredicateFk("quiz","id", criteria.getQuiz()==null?null:criteria.getQuiz().getId());
        addPredicateFk("quiz","id", criteria.getQuizs());
        addPredicateFk("quiz","ref", criteria.getQuiz()==null?null:criteria.getQuiz().getRef());
        addPredicateFk("homeWork","id", criteria.getHomeWork()==null?null:criteria.getHomeWork().getId());
        addPredicateFk("homeWork","id", criteria.getHomeWorks());
    }

    public QuestionSpecification(QuestionCriteria criteria) {
        super(criteria);
    }

    public QuestionSpecification(QuestionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
