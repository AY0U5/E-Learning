package ma.zs.alc.service.impl.admin.alc;


import ma.zs.alc.bean.core.alc.Admin;
import ma.zs.alc.dao.criteria.core.alc.AdminCriteria;
import ma.zs.alc.dao.facade.core.alc.AdminDao;
import ma.zs.alc.dao.specification.core.alc.AdminSpecification;
import ma.zs.alc.service.facade.admin.alc.AdminAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import ma.zs.alc.zynerator.security.service.facade.UserService;
import ma.zs.alc.zynerator.security.service.facade.RoleService;
import ma.zs.alc.zynerator.security.bean.Role;
import java.util.Collection;
import java.util.List;
@Service
public class AdminAdminServiceImpl extends AbstractServiceImpl<Admin, AdminCriteria, AdminDao> implements AdminAdminService {












    @Override
    public Admin create(Admin t) {
        if (findByUsername(t.getUsername()) != null || t.getPassword() == null) return null;
        t.setPassword(userService.cryptPassword(t.getPassword()));
        t.setEnabled(true);
        t.setAccountNonExpired(true);
        t.setAccountNonLocked(true);
        t.setCredentialsNonExpired(true);
        t.setPasswordChanged(false);
        /*if (t.getRoles() != null) {
            Collection<Role> roles = new ArrayList<Role>();
            for (Role role : t.getRoles()) {
                roles.add(roleService.save(role));
            }
            t.setRoles(roles);
        }*/
        Admin mySaved = super.create(t);

        return mySaved;
     }

    public Admin findByUsername(String username){
    return dao.findByUsername(username);
    }

    public boolean changePassword(String username, String newPassword) {
    return userService.changePassword(username, newPassword);
    }

    public void configure() {
        super.configure(Admin.class, AdminSpecification.class);
    }

    @Autowired
    private UserService userService;


    @Autowired
    private RoleService roleService;


    public AdminAdminServiceImpl(AdminDao dao) {
        super(dao);
    }

}
