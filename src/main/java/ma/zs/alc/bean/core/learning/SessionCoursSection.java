package ma.zs.alc.bean.core.learning;

import java.util.Objects;





import ma.zs.alc.bean.core.learning.SessionCours;
import ma.zs.alc.bean.core.course.Section;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "session_cours_section")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class SessionCoursSection   extends AuditBusinessObject     {

    private Long id;


    private SessionCours sessionCours ;
    private Section section ;


    public SessionCoursSection(){
        super();
    }

    public SessionCoursSection(Long id){
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
    @JoinColumn(name = "session_cours")
    public SessionCours getSessionCours(){
        return this.sessionCours;
    }
    public void setSessionCours(SessionCours sessionCours){
        this.sessionCours = sessionCours;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section")
    public Section getSection(){
        return this.section;
    }
    public void setSection(Section section){
        this.section = section;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionCoursSection sessionCoursSection = (SessionCoursSection) o;
        return id != null && id.equals(sessionCoursSection.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

