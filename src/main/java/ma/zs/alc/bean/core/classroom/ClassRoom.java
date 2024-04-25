package ma.zs.alc.bean.core.classroom;

import java.util.Objects;
import java.util.List;





import ma.zs.alc.bean.core.quiz.Quiz;
import ma.zs.alc.bean.core.inscriptionref.EtudiantClassRoom;
import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.bean.core.quiz.QuizClassRoom;
import ma.zs.alc.bean.core.prof.Prof;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "class_room")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ClassRoom   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String description;

    private Prof prof ;

    private List<EtudiantClassRoom> etudiantClassRooms ;
    private List<QuizClassRoom> quizClassRooms ;

    public ClassRoom(){
        super();
    }

    public ClassRoom(Long id){
        this.id = id;
    }

    public ClassRoom(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public ClassRoom(String libelle){
        this.libelle = libelle ;
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
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prof")
    public Prof getProf(){
        return this.prof;
    }
    public void setProf(Prof prof){
        this.prof = prof;
    }
    @OneToMany(mappedBy = "classRoom")

    public List<EtudiantClassRoom> getEtudiantClassRooms(){
        return this.etudiantClassRooms;
    }
    public void setEtudiantClassRooms(List<EtudiantClassRoom> etudiantClassRooms){
        this.etudiantClassRooms = etudiantClassRooms;
    }
    @OneToMany(mappedBy = "classRoom")

    public List<QuizClassRoom> getQuizClassRooms(){
        return this.quizClassRooms;
    }
    public void setQuizClassRooms(List<QuizClassRoom> quizClassRooms){
        this.quizClassRooms = quizClassRooms;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassRoom classRoom = (ClassRoom) o;
        return id != null && id.equals(classRoom.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

