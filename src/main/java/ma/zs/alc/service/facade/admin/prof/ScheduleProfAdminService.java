package ma.zs.alc.service.facade.admin.prof;

import java.util.List;
import ma.zs.alc.bean.core.prof.ScheduleProf;
import ma.zs.alc.dao.criteria.core.prof.ScheduleProfCriteria;
import ma.zs.alc.zynerator.service.IService;
import ma.zs.alc.zynerator.dto.ScheduleDto;


import java.time.LocalDateTime;

public interface ScheduleProfAdminService extends  IService<ScheduleProf,ScheduleProfCriteria>  {

    List<ScheduleProf> findByGroupeEtudiantId(Long id);
    int deleteByGroupeEtudiantId(Long id);
    long countByGroupeEtudiantId(Long id);
    List<ScheduleProf> findByProfId(Long id);
    int deleteByProfId(Long id);
    long countByProfRef(String ref);
    List<ScheduleProf> findByCoursId(Long id);
    int deleteByCoursId(Long id);
    long countByCoursCode(String code);


    List<ScheduleDto> findSchedule(LocalDateTime start, LocalDateTime end);


}
