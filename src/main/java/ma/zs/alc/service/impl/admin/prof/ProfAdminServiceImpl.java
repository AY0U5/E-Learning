package ma.zs.alc.service.impl.admin.prof;


import ma.zs.alc.bean.core.prof.Prof;
import ma.zs.alc.dao.criteria.core.prof.ProfCriteria;
import ma.zs.alc.dao.facade.core.prof.ProfDao;
import ma.zs.alc.dao.specification.core.prof.ProfSpecification;
import ma.zs.alc.service.facade.admin.prof.ProfAdminService;
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
import ma.zs.alc.service.facade.admin.prof.TypeTeacherAdminService ;
import ma.zs.alc.bean.core.prof.TypeTeacher ;
import ma.zs.alc.service.facade.admin.recomrecla.RecommendTeacherAdminService ;
import ma.zs.alc.bean.core.recomrecla.RecommendTeacher ;
import ma.zs.alc.service.facade.admin.prof.CategorieProfAdminService ;
import ma.zs.alc.bean.core.prof.CategorieProf ;
import ma.zs.alc.service.facade.admin.prof.TrancheHoraireProfAdminService ;
import ma.zs.alc.bean.core.prof.TrancheHoraireProf ;
import ma.zs.alc.service.facade.admin.classroom.ClassRoomAdminService ;
import ma.zs.alc.bean.core.classroom.ClassRoom ;

import ma.zs.alc.zynerator.security.service.facade.UserService;
import ma.zs.alc.zynerator.security.service.facade.RoleService;
import ma.zs.alc.zynerator.security.bean.Role;
import java.util.Collection;
import java.util.List;
@Service
public class ProfAdminServiceImpl extends AbstractServiceImpl<Prof, ProfCriteria, ProfDao> implements ProfAdminService {






    public Prof findByReferenceEntity(Prof t){
        return t==null? null : dao.findByRef(t.getRef());
    }
    public void findOrSaveAssociatedObject(Prof t){
        if( t != null) {
            t.setParcours(parcoursService.findOrSave(t.getParcours()));
            t.setCategorieProf(categorieProfService.findOrSave(t.getCategorieProf()));
            t.setTypeTeacher(typeTeacherService.findOrSave(t.getTypeTeacher()));
        }
    }

    public List<Prof> findByParcoursId(Long id){
        return dao.findByParcoursId(id);
    }
    public int deleteByParcoursId(Long id){
        return dao.deleteByParcoursId(id);
    }
    public long countByParcoursCode(String code){
        return dao.countByParcoursCode(code);
    }
    public List<Prof> findByCategorieProfId(Long id){
        return dao.findByCategorieProfId(id);
    }
    public int deleteByCategorieProfId(Long id){
        return dao.deleteByCategorieProfId(id);
    }
    public long countByCategorieProfCode(String code){
        return dao.countByCategorieProfCode(code);
    }
    public List<Prof> findByTypeTeacherId(Long id){
        return dao.findByTypeTeacherId(id);
    }
    public int deleteByTypeTeacherId(Long id){
        return dao.deleteByTypeTeacherId(id);
    }
    public long countByTypeTeacherCode(String code){
        return dao.countByTypeTeacherCode(code);
    }

    public List<Prof> findAllOptimized() {
        return dao.findAllOptimized();
    }




    @Override
    public Prof create(Prof t) {
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
        Prof mySaved = super.create(t);

        if (t.getTrancheHoraireProfs() != null) {
        t.getTrancheHoraireProfs().forEach(element-> {
            element.setProf(mySaved);
            trancheHoraireProfService.create(element);
        });
        }
        if (t.getClassRooms() != null) {
        t.getClassRooms().forEach(element-> {
            element.setProf(mySaved);
            classRoomService.create(element);
        });
        }
        if (t.getRecommendTeachers() != null) {
        t.getRecommendTeachers().forEach(element-> {
            element.setProf(mySaved);
            recommendTeacherService.create(element);
        });
        }
        return mySaved;
     }

    public Prof findByUsername(String username){
    return dao.findByUsername(username);
    }

    public boolean changePassword(String username, String newPassword) {
    return userService.changePassword(username, newPassword);
    }

    public void configure() {
        super.configure(Prof.class, ProfSpecification.class);
    }

    @Autowired
    private UserService userService;


    @Autowired
    private RoleService roleService;

    @Autowired
    private ParcoursAdminService parcoursService ;
    @Autowired
    private TypeTeacherAdminService typeTeacherService ;
    @Autowired
    private RecommendTeacherAdminService recommendTeacherService ;
    @Autowired
    private CategorieProfAdminService categorieProfService ;
    @Autowired
    private TrancheHoraireProfAdminService trancheHoraireProfService ;
    @Autowired
    private ClassRoomAdminService classRoomService ;

    public ProfAdminServiceImpl(ProfDao dao) {
        super(dao);
    }

}
