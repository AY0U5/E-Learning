package ma.zs.alc.zynerator.security.service.facade;

import ma.zs.alc.zynerator.security.bean.Role;
import ma.zs.alc.zynerator.security.dao.criteria.core.RoleCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface RoleService extends  IService<Role,RoleCriteria>  {
    Role findByAuthority(String authority);
    int deleteByAuthority(String authority);


    



}
