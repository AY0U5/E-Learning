package ma.zs.alc.dao.facade.core.inscriptionref;

import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.inscriptionref.EtudiantClassRoom;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EtudiantClassRoomDao extends AbstractRepository<EtudiantClassRoom,Long>  {

    List<EtudiantClassRoom> findByClassRoomId(Long id);
    int deleteByClassRoomId(Long id);
    long countByClassRoomId(Long id);
    List<EtudiantClassRoom> findByEtudiantId(Long id);
    int deleteByEtudiantId(Long id);
    long countByEtudiantRef(String ref);


}
