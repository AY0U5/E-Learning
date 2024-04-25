package ma.zs.alc.service.impl.admin.quizref;


import ma.zs.alc.bean.core.quizref.TypeDeQuestion;
import ma.zs.alc.dao.criteria.core.quizref.TypeDeQuestionCriteria;
import ma.zs.alc.dao.facade.core.quizref.TypeDeQuestionDao;
import ma.zs.alc.dao.specification.core.quizref.TypeDeQuestionSpecification;
import ma.zs.alc.service.facade.admin.quizref.TypeDeQuestionAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class TypeDeQuestionAdminServiceImpl extends AbstractServiceImpl<TypeDeQuestion, TypeDeQuestionCriteria, TypeDeQuestionDao> implements TypeDeQuestionAdminService {






    public TypeDeQuestion findByReferenceEntity(TypeDeQuestion t){
        return t==null? null : dao.findByRef(t.getRef());
    }


    public List<TypeDeQuestion> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(TypeDeQuestion.class, TypeDeQuestionSpecification.class);
    }



    public TypeDeQuestionAdminServiceImpl(TypeDeQuestionDao dao) {
        super(dao);
    }

}
