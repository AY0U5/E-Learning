package ma.zs.alc.service.impl.admin.prof;


import ma.zs.alc.bean.core.prof.TypeTeacher;
import ma.zs.alc.dao.criteria.core.prof.TypeTeacherCriteria;
import ma.zs.alc.dao.facade.core.prof.TypeTeacherDao;
import ma.zs.alc.dao.specification.core.prof.TypeTeacherSpecification;
import ma.zs.alc.service.facade.admin.prof.TypeTeacherAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class TypeTeacherAdminServiceImpl extends AbstractServiceImpl<TypeTeacher, TypeTeacherCriteria, TypeTeacherDao> implements TypeTeacherAdminService {






    public TypeTeacher findByReferenceEntity(TypeTeacher t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<TypeTeacher> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(TypeTeacher.class, TypeTeacherSpecification.class);
    }



    public TypeTeacherAdminServiceImpl(TypeTeacherDao dao) {
        super(dao);
    }

}
