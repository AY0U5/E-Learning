package ma.zs.alc.service.impl.admin.inscriptionref;


import ma.zs.alc.bean.core.inscriptionref.EtudiantClassRoom;
import ma.zs.alc.dao.criteria.core.inscriptionref.EtudiantClassRoomCriteria;
import ma.zs.alc.dao.facade.core.inscriptionref.EtudiantClassRoomDao;
import ma.zs.alc.dao.specification.core.inscriptionref.EtudiantClassRoomSpecification;
import ma.zs.alc.service.facade.admin.inscriptionref.EtudiantClassRoomAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.alc.service.facade.admin.inscription.EtudiantAdminService ;
import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.service.facade.admin.classroom.ClassRoomAdminService ;
import ma.zs.alc.bean.core.classroom.ClassRoom ;

import java.util.List;
@Service
public class EtudiantClassRoomAdminServiceImpl extends AbstractServiceImpl<EtudiantClassRoom, EtudiantClassRoomCriteria, EtudiantClassRoomDao> implements EtudiantClassRoomAdminService {






    public void findOrSaveAssociatedObject(EtudiantClassRoom t){
        if( t != null) {
            t.setClassRoom(classRoomService.findOrSave(t.getClassRoom()));
            t.setEtudiant(etudiantService.findOrSave(t.getEtudiant()));
        }
    }

    public List<EtudiantClassRoom> findByClassRoomId(Long id){
        return dao.findByClassRoomId(id);
    }
    public int deleteByClassRoomId(Long id){
        return dao.deleteByClassRoomId(id);
    }
    public long countByClassRoomId(Long id){
        return dao.countByClassRoomId(id);
    }
    public List<EtudiantClassRoom> findByEtudiantId(Long id){
        return dao.findByEtudiantId(id);
    }
    public int deleteByEtudiantId(Long id){
        return dao.deleteByEtudiantId(id);
    }
    public long countByEtudiantRef(String ref){
        return dao.countByEtudiantRef(ref);
    }






    public void configure() {
        super.configure(EtudiantClassRoom.class, EtudiantClassRoomSpecification.class);
    }


    @Autowired
    private EtudiantAdminService etudiantService ;
    @Autowired
    private ClassRoomAdminService classRoomService ;

    public EtudiantClassRoomAdminServiceImpl(EtudiantClassRoomDao dao) {
        super(dao);
    }

}
