package ma.zs.alc.service.facade.admin.paiement;

import java.util.List;
import ma.zs.alc.bean.core.paiement.Paiement;
import ma.zs.alc.dao.criteria.core.paiement.PaiementCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface PaiementAdminService extends  IService<Paiement,PaiementCriteria>  {

    List<Paiement> findByProfId(Long id);
    int deleteByProfId(Long id);
    long countByProfRef(String ref);
    List<Paiement> findByGroupeEtudiantId(Long id);
    int deleteByGroupeEtudiantId(Long id);
    long countByGroupeEtudiantId(Long id);




}
