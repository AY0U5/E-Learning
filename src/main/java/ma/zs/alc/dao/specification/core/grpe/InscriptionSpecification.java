package  ma.zs.alc.dao.specification.core.grpe;

import ma.zs.alc.dao.criteria.core.grpe.InscriptionCriteria;
import ma.zs.alc.bean.core.grpe.Inscription;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class InscriptionSpecification extends  AbstractSpecification<InscriptionCriteria, Inscription>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateInt("numeroInscription", criteria.getNumeroInscription(), criteria.getNumeroInscriptionMin(), criteria.getNumeroInscriptionMax());
        addPredicateBigDecimal("noteQuizNiveau", criteria.getNoteQuizNiveau(), criteria.getNoteQuizNiveauMin(), criteria.getNoteQuizNiveauMax());
        addPredicateBool("quizFinished", criteria.getQuizFinished());
        addPredicate("dateRegistration", criteria.getDateRegistration(),criteria.getDateRegistrationLike());
        addPredicate("datedebutinscription", criteria.getDatedebutinscription(), criteria.getDatedebutinscriptionFrom(), criteria.getDatedebutinscriptionTo());
        addPredicate("datefininscription", criteria.getDatefininscription(), criteria.getDatefininscriptionFrom(), criteria.getDatefininscriptionTo());
        addPredicate("skype", criteria.getSkype(),criteria.getSkypeLike());
        addPredicateFk("etudiant","id", criteria.getEtudiant()==null?null:criteria.getEtudiant().getId());
        addPredicateFk("etudiant","id", criteria.getEtudiants());
        addPredicateFk("etudiant","ref", criteria.getEtudiant()==null?null:criteria.getEtudiant().getRef());
        addPredicateFk("etatInscription","id", criteria.getEtatInscription()==null?null:criteria.getEtatInscription().getId());
        addPredicateFk("etatInscription","id", criteria.getEtatInscriptions());
        addPredicateFk("etatInscription","libelle", criteria.getEtatInscription()==null?null:criteria.getEtatInscription().getLibelle());
        addPredicateFk("parcours","id", criteria.getParcours()==null?null:criteria.getParcours().getId());
        addPredicateFk("parcours","id", criteria.getParcourss());
        addPredicateFk("parcours","code", criteria.getParcours()==null?null:criteria.getParcours().getCode());
        addPredicateFk("groupeEtude","id", criteria.getGroupeEtude()==null?null:criteria.getGroupeEtude().getId());
        addPredicateFk("groupeEtude","id", criteria.getGroupeEtudes());
        addPredicateFk("groupeType","id", criteria.getGroupeType()==null?null:criteria.getGroupeType().getId());
        addPredicateFk("groupeType","id", criteria.getGroupeTypes());
        addPredicateFk("groupeType","code", criteria.getGroupeType()==null?null:criteria.getGroupeType().getCode());
        addPredicateFk("statutSocial","id", criteria.getStatutSocial()==null?null:criteria.getStatutSocial().getId());
        addPredicateFk("statutSocial","id", criteria.getStatutSocials());
        addPredicateFk("statutSocial","code", criteria.getStatutSocial()==null?null:criteria.getStatutSocial().getCode());
        addPredicateFk("interetEtudiant","id", criteria.getInteretEtudiant()==null?null:criteria.getInteretEtudiant().getId());
        addPredicateFk("interetEtudiant","id", criteria.getInteretEtudiants());
        addPredicateFk("interetEtudiant","code", criteria.getInteretEtudiant()==null?null:criteria.getInteretEtudiant().getCode());
        addPredicateFk("niveauEtude","id", criteria.getNiveauEtude()==null?null:criteria.getNiveauEtude().getId());
        addPredicateFk("niveauEtude","id", criteria.getNiveauEtudes());
        addPredicateFk("niveauEtude","code", criteria.getNiveauEtude()==null?null:criteria.getNiveauEtude().getCode());
        addPredicateFk("fonction","id", criteria.getFonction()==null?null:criteria.getFonction().getId());
        addPredicateFk("fonction","id", criteria.getFonctions());
        addPredicateFk("fonction","code", criteria.getFonction()==null?null:criteria.getFonction().getCode());
        addPredicateFk("quiz","id", criteria.getQuiz()==null?null:criteria.getQuiz().getId());
        addPredicateFk("quiz","id", criteria.getQuizs());
        addPredicateFk("quiz","ref", criteria.getQuiz()==null?null:criteria.getQuiz().getRef());
        addPredicateFk("packStudent","id", criteria.getPackStudent()==null?null:criteria.getPackStudent().getId());
        addPredicateFk("packStudent","id", criteria.getPackStudents());
        addPredicateFk("packStudent","code", criteria.getPackStudent()==null?null:criteria.getPackStudent().getCode());
        addPredicateFk("skill","id", criteria.getSkill()==null?null:criteria.getSkill().getId());
        addPredicateFk("skill","id", criteria.getSkills());
        addPredicateFk("skill","code", criteria.getSkill()==null?null:criteria.getSkill().getCode());
    }

    public InscriptionSpecification(InscriptionCriteria criteria) {
        super(criteria);
    }

    public InscriptionSpecification(InscriptionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
