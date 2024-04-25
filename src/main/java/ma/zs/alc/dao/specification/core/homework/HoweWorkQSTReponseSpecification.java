package  ma.zs.alc.dao.specification.core.homework;

import ma.zs.alc.dao.criteria.core.homework.HoweWorkQSTReponseCriteria;
import ma.zs.alc.bean.core.homework.HoweWorkQSTReponse;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class HoweWorkQSTReponseSpecification extends  AbstractSpecification<HoweWorkQSTReponseCriteria, HoweWorkQSTReponse>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("lib", criteria.getLib(),criteria.getLibLike());
        addPredicate("etatReponse", criteria.getEtatReponse(),criteria.getEtatReponseLike());
        addPredicateInt("numero", criteria.getNumero(), criteria.getNumeroMin(), criteria.getNumeroMax());
        addPredicateFk("homeWorkQuestion","id", criteria.getHomeWorkQuestion()==null?null:criteria.getHomeWorkQuestion().getId());
        addPredicateFk("homeWorkQuestion","id", criteria.getHomeWorkQuestions());
        addPredicateFk("homeWorkQuestion","ref", criteria.getHomeWorkQuestion()==null?null:criteria.getHomeWorkQuestion().getRef());
    }

    public HoweWorkQSTReponseSpecification(HoweWorkQSTReponseCriteria criteria) {
        super(criteria);
    }

    public HoweWorkQSTReponseSpecification(HoweWorkQSTReponseCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
