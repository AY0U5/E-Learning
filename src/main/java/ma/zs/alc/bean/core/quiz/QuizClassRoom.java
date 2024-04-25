package ma.zs.alc.bean.core.quiz;

import java.util.Objects;





import ma.zs.alc.bean.core.quiz.Quiz;
import ma.zs.alc.bean.core.classroom.ClassRoom;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "quiz_class_room")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class QuizClassRoom   extends AuditBusinessObject     {

    private Long id;


    private ClassRoom classRoom ;
    private Quiz quiz ;


    public QuizClassRoom(){
        super();
    }

    public QuizClassRoom(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_room")
    public ClassRoom getClassRoom(){
        return this.classRoom;
    }
    public void setClassRoom(ClassRoom classRoom){
        this.classRoom = classRoom;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz")
    public Quiz getQuiz(){
        return this.quiz;
    }
    public void setQuiz(Quiz quiz){
        this.quiz = quiz;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizClassRoom quizClassRoom = (QuizClassRoom) o;
        return id != null && id.equals(quizClassRoom.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

