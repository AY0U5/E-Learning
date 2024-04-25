package ma.zs.alc.service.impl.admin.paiement;


import ma.zs.alc.bean.core.paiement.Paiement;
import ma.zs.alc.dao.criteria.core.paiement.PaiementCriteria;
import ma.zs.alc.dao.facade.core.paiement.PaiementDao;
import ma.zs.alc.dao.specification.core.paiement.PaiementSpecification;
import ma.zs.alc.service.facade.admin.paiement.PaiementAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.alc.service.facade.admin.grpe.GroupeEtudiantAdminService ;
import ma.zs.alc.bean.core.grpe.GroupeEtudiant ;
import ma.zs.alc.service.facade.admin.prof.ProfAdminService ;
import ma.zs.alc.bean.core.prof.Prof ;

import java.util.List;
@Service
public class PaiementAdminServiceImpl extends AbstractServiceImpl<Paiement, PaiementCriteria, PaiementDao> implements PaiementAdminService {






    public void findOrSaveAssociatedObject(Paiement t){
        if( t != null) {
            t.setProf(profService.findOrSave(t.getProf()));
            t.setGroupeEtudiant(groupeEtudiantService.findOrSave(t.getGroupeEtudiant()));
        }
    }

    public List<Paiement> findByProfId(Long id){
        return dao.findByProfId(id);
    }
    public int deleteByProfId(Long id){
        return dao.deleteByProfId(id);
    }
    public long countByProfRef(String ref){
        return dao.countByProfRef(ref);
    }
    public List<Paiement> findByGroupeEtudiantId(Long id){
        return dao.findByGroupeEtudiantId(id);
    }
    public int deleteByGroupeEtudiantId(Long id){
        return dao.deleteByGroupeEtudiantId(id);
    }
    public long countByGroupeEtudiantId(Long id){
        return dao.countByGroupeEtudiantId(id);
    }






    public void configure() {
        super.configure(Paiement.class, PaiementSpecification.class);
    }


    @Autowired
    private GroupeEtudiantAdminService groupeEtudiantService ;
    @Autowired
    private ProfAdminService profService ;

    public PaiementAdminServiceImpl(PaiementDao dao) {
        super(dao);
    }

}
