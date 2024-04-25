package ma.zs.alc.service.impl.admin.grpe;


import ma.zs.alc.bean.core.grpe.GroupeEtudiant;
import ma.zs.alc.dao.criteria.core.grpe.GroupeEtudiantCriteria;
import ma.zs.alc.dao.facade.core.grpe.GroupeEtudiantDao;
import ma.zs.alc.dao.specification.core.grpe.GroupeEtudiantSpecification;
import ma.zs.alc.service.facade.admin.grpe.GroupeEtudiantAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.alc.service.facade.admin.course.ParcoursAdminService ;
import ma.zs.alc.bean.core.course.Parcours ;
import ma.zs.alc.service.facade.admin.grpe.GroupeEtatAdminService ;
import ma.zs.alc.bean.core.grpe.GroupeEtat ;
import ma.zs.alc.service.facade.admin.grpe.GroupeEtudiantDetailAdminService ;
import ma.zs.alc.bean.core.grpe.GroupeEtudiantDetail ;
import ma.zs.alc.service.facade.admin.grpe.GroupeTypeAdminService ;
import ma.zs.alc.bean.core.grpe.GroupeType ;
import ma.zs.alc.service.facade.admin.grpe.GroupeEtudeAdminService ;
import ma.zs.alc.bean.core.grpe.GroupeEtude ;
import ma.zs.alc.service.facade.admin.prof.ProfAdminService ;
import ma.zs.alc.bean.core.prof.Prof ;

import java.util.List;
@Service
public class GroupeEtudiantAdminServiceImpl extends AbstractServiceImpl<GroupeEtudiant, GroupeEtudiantCriteria, GroupeEtudiantDao> implements GroupeEtudiantAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public GroupeEtudiant create(GroupeEtudiant t) {
        GroupeEtudiant saved= super.create(t);
        if (saved != null && t.getGroupeEtudiantDetails() != null) {
                t.getGroupeEtudiantDetails().forEach(element-> {
                    element.setGroupeEtudiant(saved);
                    groupeEtudiantDetailService.create(element);
            });
        }
        return saved;

    }

    public GroupeEtudiant findWithAssociatedLists(Long id){
        GroupeEtudiant result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setGroupeEtudiantDetails(groupeEtudiantDetailService.findByGroupeEtudiantId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        groupeEtudiantDetailService.deleteByGroupeEtudiantId(id);
    }


    public void updateWithAssociatedLists(GroupeEtudiant groupeEtudiant){
    if(groupeEtudiant !=null && groupeEtudiant.getId() != null){
            List<List<GroupeEtudiantDetail>> resultGroupeEtudiantDetails= groupeEtudiantDetailService.getToBeSavedAndToBeDeleted(groupeEtudiantDetailService.findByGroupeEtudiantId(groupeEtudiant.getId()),groupeEtudiant.getGroupeEtudiantDetails());
            groupeEtudiantDetailService.delete(resultGroupeEtudiantDetails.get(1));
            ListUtil.emptyIfNull(resultGroupeEtudiantDetails.get(0)).forEach(e -> e.setGroupeEtudiant(groupeEtudiant));
            groupeEtudiantDetailService.update(resultGroupeEtudiantDetails.get(0),true);
        }
    }




    public void findOrSaveAssociatedObject(GroupeEtudiant t){
        if( t != null) {
            t.setGroupeEtude(groupeEtudeService.findOrSave(t.getGroupeEtude()));
            t.setGroupeType(groupeTypeService.findOrSave(t.getGroupeType()));
            t.setGroupeEtat(groupeEtatService.findOrSave(t.getGroupeEtat()));
            t.setParcours(parcoursService.findOrSave(t.getParcours()));
            t.setProf(profService.findOrSave(t.getProf()));
        }
    }

    public List<GroupeEtudiant> findByGroupeEtudeId(Long id){
        return dao.findByGroupeEtudeId(id);
    }
    public int deleteByGroupeEtudeId(Long id){
        return dao.deleteByGroupeEtudeId(id);
    }
    public long countByGroupeEtudeId(Long id){
        return dao.countByGroupeEtudeId(id);
    }
    public List<GroupeEtudiant> findByGroupeTypeId(Long id){
        return dao.findByGroupeTypeId(id);
    }
    public int deleteByGroupeTypeId(Long id){
        return dao.deleteByGroupeTypeId(id);
    }
    public long countByGroupeTypeCode(String code){
        return dao.countByGroupeTypeCode(code);
    }
    public List<GroupeEtudiant> findByGroupeEtatId(Long id){
        return dao.findByGroupeEtatId(id);
    }
    public int deleteByGroupeEtatId(Long id){
        return dao.deleteByGroupeEtatId(id);
    }
    public long countByGroupeEtatCode(String code){
        return dao.countByGroupeEtatCode(code);
    }
    public List<GroupeEtudiant> findByParcoursId(Long id){
        return dao.findByParcoursId(id);
    }
    public int deleteByParcoursId(Long id){
        return dao.deleteByParcoursId(id);
    }
    public long countByParcoursCode(String code){
        return dao.countByParcoursCode(code);
    }
    public List<GroupeEtudiant> findByProfId(Long id){
        return dao.findByProfId(id);
    }
    public int deleteByProfId(Long id){
        return dao.deleteByProfId(id);
    }
    public long countByProfRef(String ref){
        return dao.countByProfRef(ref);
    }






    public void configure() {
        super.configure(GroupeEtudiant.class, GroupeEtudiantSpecification.class);
    }


    @Autowired
    private ParcoursAdminService parcoursService ;
    @Autowired
    private GroupeEtatAdminService groupeEtatService ;
    @Autowired
    private GroupeEtudiantDetailAdminService groupeEtudiantDetailService ;
    @Autowired
    private GroupeTypeAdminService groupeTypeService ;
    @Autowired
    private GroupeEtudeAdminService groupeEtudeService ;
    @Autowired
    private ProfAdminService profService ;

    public GroupeEtudiantAdminServiceImpl(GroupeEtudiantDao dao) {
        super(dao);
    }

}
