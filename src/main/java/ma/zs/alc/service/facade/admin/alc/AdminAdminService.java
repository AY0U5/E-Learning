package ma.zs.alc.service.facade.admin.alc;

import java.util.List;
import ma.zs.alc.bean.core.alc.Admin;
import ma.zs.alc.dao.criteria.core.alc.AdminCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface AdminAdminService extends  IService<Admin,AdminCriteria>  {
    Admin findByUsername(String username);
    boolean changePassword(String username, String newPassword);





}
