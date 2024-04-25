package  ma.zs.alc.dao.specification.core.vocab;

import ma.zs.alc.dao.criteria.core.vocab.VocabularyQuizCriteria;
import ma.zs.alc.bean.core.vocab.VocabularyQuiz;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class VocabularyQuizSpecification extends  AbstractSpecification<VocabularyQuizCriteria, VocabularyQuiz>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("dateDebut", criteria.getDateDebut(), criteria.getDateDebutFrom(), criteria.getDateDebutTo());
        addPredicate("dateFin", criteria.getDateFin(), criteria.getDateFinFrom(), criteria.getDateFinTo());
        addPredicateFk("section","id", criteria.getSection()==null?null:criteria.getSection().getId());
        addPredicateFk("section","id", criteria.getSections());
        addPredicateFk("section","code", criteria.getSection()==null?null:criteria.getSection().getCode());
    }

    public VocabularyQuizSpecification(VocabularyQuizCriteria criteria) {
        super(criteria);
    }

    public VocabularyQuizSpecification(VocabularyQuizCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
