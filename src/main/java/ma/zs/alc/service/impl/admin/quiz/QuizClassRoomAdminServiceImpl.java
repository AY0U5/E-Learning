package ma.zs.alc.service.impl.admin.quiz;


import ma.zs.alc.bean.core.quiz.QuizClassRoom;
import ma.zs.alc.dao.criteria.core.quiz.QuizClassRoomCriteria;
import ma.zs.alc.dao.facade.core.quiz.QuizClassRoomDao;
import ma.zs.alc.dao.specification.core.quiz.QuizClassRoomSpecification;
import ma.zs.alc.service.facade.admin.quiz.QuizClassRoomAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.alc.service.facade.admin.quiz.QuizAdminService ;
import ma.zs.alc.bean.core.quiz.Quiz ;
import ma.zs.alc.service.facade.admin.classroom.ClassRoomAdminService ;
import ma.zs.alc.bean.core.classroom.ClassRoom ;

import java.util.List;
@Service
public class QuizClassRoomAdminServiceImpl extends AbstractServiceImpl<QuizClassRoom, QuizClassRoomCriteria, QuizClassRoomDao> implements QuizClassRoomAdminService {






    public void findOrSaveAssociatedObject(QuizClassRoom t){
        if( t != null) {
            t.setClassRoom(classRoomService.findOrSave(t.getClassRoom()));
            t.setQuiz(quizService.findOrSave(t.getQuiz()));
        }
    }

    public List<QuizClassRoom> findByClassRoomId(Long id){
        return dao.findByClassRoomId(id);
    }
    public int deleteByClassRoomId(Long id){
        return dao.deleteByClassRoomId(id);
    }
    public long countByClassRoomId(Long id){
        return dao.countByClassRoomId(id);
    }
    public List<QuizClassRoom> findByQuizId(Long id){
        return dao.findByQuizId(id);
    }
    public int deleteByQuizId(Long id){
        return dao.deleteByQuizId(id);
    }
    public long countByQuizRef(String ref){
        return dao.countByQuizRef(ref);
    }






    public void configure() {
        super.configure(QuizClassRoom.class, QuizClassRoomSpecification.class);
    }


    @Autowired
    private QuizAdminService quizService ;
    @Autowired
    private ClassRoomAdminService classRoomService ;

    public QuizClassRoomAdminServiceImpl(QuizClassRoomDao dao) {
        super(dao);
    }

}
