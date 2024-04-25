package  ma.zs.alc.dao.specification.core.quizetudiant;

import ma.zs.alc.dao.criteria.core.quizetudiant.ReponseEtudiantCriteria;
import ma.zs.alc.bean.core.quizetudiant.ReponseEtudiant;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class ReponseEtudiantSpecification extends  AbstractSpecification<ReponseEtudiantCriteria, ReponseEtudiant>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("answer", criteria.getAnswer(),criteria.getAnswerLike());
        addPredicateBigDecimal("note", criteria.getNote(), criteria.getNoteMin(), criteria.getNoteMax());
        addPredicateFk("reponse","id", criteria.getReponse()==null?null:criteria.getReponse().getId());
        addPredicateFk("reponse","id", criteria.getReponses());
        addPredicateFk("reponse","ref", criteria.getReponse()==null?null:criteria.getReponse().getRef());
        addPredicateFk("quizEtudiant","id", criteria.getQuizEtudiant()==null?null:criteria.getQuizEtudiant().getId());
        addPredicateFk("quizEtudiant","id", criteria.getQuizEtudiants());
        addPredicateFk("quizEtudiant","ref", criteria.getQuizEtudiant()==null?null:criteria.getQuizEtudiant().getRef());
        addPredicateFk("question","id", criteria.getQuestion()==null?null:criteria.getQuestion().getId());
        addPredicateFk("question","id", criteria.getQuestions());
        addPredicateFk("question","libelle", criteria.getQuestion()==null?null:criteria.getQuestion().getLibelle());
    }

    public ReponseEtudiantSpecification(ReponseEtudiantCriteria criteria) {
        super(criteria);
    }

    public ReponseEtudiantSpecification(ReponseEtudiantCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
