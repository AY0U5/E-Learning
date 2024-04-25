package  ma.zs.alc.dao.specification.core.quizetudiant;

import ma.zs.alc.dao.criteria.core.quizetudiant.QuizEtudiantCriteria;
import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class QuizEtudiantSpecification extends  AbstractSpecification<QuizEtudiantCriteria, QuizEtudiant>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicateBigDecimal("note", criteria.getNote(), criteria.getNoteMin(), criteria.getNoteMax());
        addPredicate("resultat", criteria.getResultat(),criteria.getResultatLike());
        addPredicateLong("questionCurrent", criteria.getQuestionCurrent(), criteria.getQuestionCurrentMin(), criteria.getQuestionCurrentMax());
        addPredicateFk("etudiant","id", criteria.getEtudiant()==null?null:criteria.getEtudiant().getId());
        addPredicateFk("etudiant","id", criteria.getEtudiants());
        addPredicateFk("etudiant","ref", criteria.getEtudiant()==null?null:criteria.getEtudiant().getRef());
        addPredicateFk("quiz","id", criteria.getQuiz()==null?null:criteria.getQuiz().getId());
        addPredicateFk("quiz","id", criteria.getQuizs());
        addPredicateFk("quiz","ref", criteria.getQuiz()==null?null:criteria.getQuiz().getRef());
    }

    public QuizEtudiantSpecification(QuizEtudiantCriteria criteria) {
        super(criteria);
    }

    public QuizEtudiantSpecification(QuizEtudiantCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
