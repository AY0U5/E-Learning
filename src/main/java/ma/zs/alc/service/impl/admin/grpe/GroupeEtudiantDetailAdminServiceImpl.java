package ma.zs.alc.service.impl.admin.grpe;


import ma.zs.alc.bean.core.grpe.GroupeEtudiantDetail;
import ma.zs.alc.dao.criteria.core.grpe.GroupeEtudiantDetailCriteria;
import ma.zs.alc.dao.facade.core.grpe.GroupeEtudiantDetailDao;
import ma.zs.alc.dao.specification.core.grpe.GroupeEtudiantDetailSpecification;
import ma.zs.alc.service.facade.admin.grpe.GroupeEtudiantDetailAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.alc.service.facade.admin.inscription.EtudiantAdminService ;
import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.service.facade.admin.grpe.GroupeEtudiantAdminService ;
import ma.zs.alc.bean.core.grpe.GroupeEtudiant ;

import java.util.List;
@Service
public class GroupeEtudiantDetailAdminServiceImpl extends AbstractServiceImpl<GroupeEtudiantDetail, GroupeEtudiantDetailCriteria, GroupeEtudiantDetailDao> implements GroupeEtudiantDetailAdminService {






    public void findOrSaveAssociatedObject(GroupeEtudiantDetail t){
        if( t != null) {
            t.setGroupeEtudiant(groupeEtudiantService.findOrSave(t.getGroupeEtudiant()));
            t.setEtudiant(etudiantService.findOrSave(t.getEtudiant()));
        }
    }

    public List<GroupeEtudiantDetail> findByGroupeEtudiantId(Long id){
        return dao.findByGroupeEtudiantId(id);
    }
    public int deleteByGroupeEtudiantId(Long id){
        return dao.deleteByGroupeEtudiantId(id);
    }
    public long countByGroupeEtudiantId(Long id){
        return dao.countByGroupeEtudiantId(id);
    }
    public List<GroupeEtudiantDetail> findByEtudiantId(Long id){
        return dao.findByEtudiantId(id);
    }
    public int deleteByEtudiantId(Long id){
        return dao.deleteByEtudiantId(id);
    }
    public long countByEtudiantRef(String ref){
        return dao.countByEtudiantRef(ref);
    }






    public void configure() {
        super.configure(GroupeEtudiantDetail.class, GroupeEtudiantDetailSpecification.class);
    }


    @Autowired
    private EtudiantAdminService etudiantService ;
    @Autowired
    private GroupeEtudiantAdminService groupeEtudiantService ;

    public GroupeEtudiantDetailAdminServiceImpl(GroupeEtudiantDetailDao dao) {
        super(dao);
    }

}
