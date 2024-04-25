package  ma.zs.alc.dao.specification.core.freetrial;

import ma.zs.alc.dao.criteria.core.freetrial.FreeTrialDetailCriteria;
import ma.zs.alc.bean.core.freetrial.FreeTrialDetail;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class FreeTrialDetailSpecification extends  AbstractSpecification<FreeTrialDetailCriteria, FreeTrialDetail>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBool("presence", criteria.getPresence());
        addPredicateBool("whatsUpMessageSent", criteria.getWhatsUpMessageSent());
        addPredicate("dateEnvoiwhatsUpMessage", criteria.getDateEnvoiwhatsUpMessage(), criteria.getDateEnvoiwhatsUpMessageFrom(), criteria.getDateEnvoiwhatsUpMessageTo());
        addPredicateBool("emailMessageSent", criteria.getEmailMessageSent());
        addPredicate("dateEnvoiEmailMessage", criteria.getDateEnvoiEmailMessage(), criteria.getDateEnvoiEmailMessageFrom(), criteria.getDateEnvoiEmailMessageTo());
        addPredicateBool("abonne", criteria.getAbonne());
        addPredicateFk("freeTrial","id", criteria.getFreeTrial()==null?null:criteria.getFreeTrial().getId());
        addPredicateFk("freeTrial","id", criteria.getFreeTrials());
        addPredicateFk("freeTrial","reference", criteria.getFreeTrial()==null?null:criteria.getFreeTrial().getReference());
        addPredicateFk("etudiant","id", criteria.getEtudiant()==null?null:criteria.getEtudiant().getId());
        addPredicateFk("etudiant","id", criteria.getEtudiants());
        addPredicateFk("etudiant","ref", criteria.getEtudiant()==null?null:criteria.getEtudiant().getRef());
    }

    public FreeTrialDetailSpecification(FreeTrialDetailCriteria criteria) {
        super(criteria);
    }

    public FreeTrialDetailSpecification(FreeTrialDetailCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
