package  ma.zs.alc.dao.specification.core.inscription;

import ma.zs.alc.dao.criteria.core.inscription.DictionaryCriteria;
import ma.zs.alc.bean.core.inscription.Dictionary;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class DictionarySpecification extends  AbstractSpecification<DictionaryCriteria, Dictionary>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("word", criteria.getWord(),criteria.getWordLike());
        addPredicateFk("etudiant","id", criteria.getEtudiant()==null?null:criteria.getEtudiant().getId());
        addPredicateFk("etudiant","id", criteria.getEtudiants());
        addPredicateFk("etudiant","ref", criteria.getEtudiant()==null?null:criteria.getEtudiant().getRef());
    }

    public DictionarySpecification(DictionaryCriteria criteria) {
        super(criteria);
    }

    public DictionarySpecification(DictionaryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
