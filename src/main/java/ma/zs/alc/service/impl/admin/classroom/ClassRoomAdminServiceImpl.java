package ma.zs.alc.service.impl.admin.classroom;


import ma.zs.alc.bean.core.classroom.ClassRoom;
import ma.zs.alc.dao.criteria.core.classroom.ClassRoomCriteria;
import ma.zs.alc.dao.facade.core.classroom.ClassRoomDao;
import ma.zs.alc.dao.specification.core.classroom.ClassRoomSpecification;
import ma.zs.alc.service.facade.admin.classroom.ClassRoomAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.alc.service.facade.admin.inscriptionref.EtudiantClassRoomAdminService ;
import ma.zs.alc.bean.core.inscriptionref.EtudiantClassRoom ;
import ma.zs.alc.service.facade.admin.quiz.QuizClassRoomAdminService ;
import ma.zs.alc.bean.core.quiz.QuizClassRoom ;
import ma.zs.alc.service.facade.admin.prof.ProfAdminService ;
import ma.zs.alc.bean.core.prof.Prof ;

import java.util.List;
@Service
public class ClassRoomAdminServiceImpl extends AbstractServiceImpl<ClassRoom, ClassRoomCriteria, ClassRoomDao> implements ClassRoomAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public ClassRoom create(ClassRoom t) {
        ClassRoom saved= super.create(t);
        if (saved != null && t.getEtudiantClassRooms() != null) {
                t.getEtudiantClassRooms().forEach(element-> {
                    element.setClassRoom(saved);
                    etudiantClassRoomService.create(element);
            });
        }
        if (saved != null && t.getQuizClassRooms() != null) {
                t.getQuizClassRooms().forEach(element-> {
                    element.setClassRoom(saved);
                    quizClassRoomService.create(element);
            });
        }
        return saved;

    }

    public ClassRoom findWithAssociatedLists(Long id){
        ClassRoom result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setEtudiantClassRooms(etudiantClassRoomService.findByClassRoomId(id));
            result.setQuizClassRooms(quizClassRoomService.findByClassRoomId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        etudiantClassRoomService.deleteByClassRoomId(id);
        quizClassRoomService.deleteByClassRoomId(id);
    }


    public void updateWithAssociatedLists(ClassRoom classRoom){
    if(classRoom !=null && classRoom.getId() != null){
            List<List<EtudiantClassRoom>> resultEtudiantClassRooms= etudiantClassRoomService.getToBeSavedAndToBeDeleted(etudiantClassRoomService.findByClassRoomId(classRoom.getId()),classRoom.getEtudiantClassRooms());
            etudiantClassRoomService.delete(resultEtudiantClassRooms.get(1));
            ListUtil.emptyIfNull(resultEtudiantClassRooms.get(0)).forEach(e -> e.setClassRoom(classRoom));
            etudiantClassRoomService.update(resultEtudiantClassRooms.get(0),true);
            List<List<QuizClassRoom>> resultQuizClassRooms= quizClassRoomService.getToBeSavedAndToBeDeleted(quizClassRoomService.findByClassRoomId(classRoom.getId()),classRoom.getQuizClassRooms());
            quizClassRoomService.delete(resultQuizClassRooms.get(1));
            ListUtil.emptyIfNull(resultQuizClassRooms.get(0)).forEach(e -> e.setClassRoom(classRoom));
            quizClassRoomService.update(resultQuizClassRooms.get(0),true);
        }
    }




    public void findOrSaveAssociatedObject(ClassRoom t){
        if( t != null) {
            t.setProf(profService.findOrSave(t.getProf()));
        }
    }

    public List<ClassRoom> findByProfId(Long id){
        return dao.findByProfId(id);
    }
    public int deleteByProfId(Long id){
        return dao.deleteByProfId(id);
    }
    public long countByProfRef(String ref){
        return dao.countByProfRef(ref);
    }

    public List<ClassRoom> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(ClassRoom.class, ClassRoomSpecification.class);
    }


    @Autowired
    private EtudiantClassRoomAdminService etudiantClassRoomService ;
    @Autowired
    private QuizClassRoomAdminService quizClassRoomService ;
    @Autowired
    private ProfAdminService profService ;

    public ClassRoomAdminServiceImpl(ClassRoomDao dao) {
        super(dao);
    }

}
