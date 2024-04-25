package ma.zs.alc.service.facade.admin.inscriptionref;

import java.util.List;
import ma.zs.alc.bean.core.inscriptionref.EtudiantClassRoom;
import ma.zs.alc.dao.criteria.core.inscriptionref.EtudiantClassRoomCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface EtudiantClassRoomAdminService extends  IService<EtudiantClassRoom,EtudiantClassRoomCriteria>  {

    List<EtudiantClassRoom> findByClassRoomId(Long id);
    int deleteByClassRoomId(Long id);
    long countByClassRoomId(Long id);
    List<EtudiantClassRoom> findByEtudiantId(Long id);
    int deleteByEtudiantId(Long id);
    long countByEtudiantRef(String ref);




}
