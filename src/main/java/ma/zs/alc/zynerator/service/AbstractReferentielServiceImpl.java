package ma.zs.alc.zynerator.service;

import ma.zs.alc.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.zs.alc.zynerator.criteria.BaseCriteria;
import ma.zs.alc.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, CRITERIA extends BaseCriteria, REPO extends AbstractRepository<T, Long>> extends AbstractServiceImpl<T, CRITERIA, REPO> {

    public AbstractReferentielServiceImpl(REPO dao) {
        super(dao);
    }

}
