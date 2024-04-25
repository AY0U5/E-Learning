package ma.zs.alc.dao.facade.core.classroom;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.classroom.ClassRoom;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ClassRoomDao extends AbstractRepository<ClassRoom,Long>  {

    List<ClassRoom> findByProfId(Long id);
    int deleteByProfId(Long id);
    long countByProfRef(String ref);

    @Query("SELECT NEW ClassRoom(item.id,item.libelle) FROM ClassRoom item")
    List<ClassRoom> findAllOptimized();

}
