package ma.zs.alc.service.facade.admin.classroom;

import java.util.List;
import ma.zs.alc.bean.core.classroom.ClassRoom;
import ma.zs.alc.dao.criteria.core.classroom.ClassRoomCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface ClassRoomAdminService extends  IService<ClassRoom,ClassRoomCriteria>  {

    List<ClassRoom> findByProfId(Long id);
    int deleteByProfId(Long id);
    long countByProfRef(String ref);




}
