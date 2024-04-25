package ma.zs.alc.bean.core.prof;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.bean.core.grpe.GroupeEtudiant;
import ma.zs.alc.bean.core.course.Cours;
import ma.zs.alc.bean.core.prof.Prof;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "schedule_prof")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ScheduleProf   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String subject;
    private LocalDateTime startTime ;
    private LocalDateTime endTime ;
    @Column(length = 500)
    private String ref;
    @Column(length = 500)
    private String grpName;
    @Column(length = 500)
    private String profName;
    private Long profsId ;

    private GroupeEtudiant groupeEtudiant ;
    private Prof prof ;
    private Cours cours ;


    public ScheduleProf(){
        super();
    }

    public ScheduleProf(Long id){
        this.id = id;
    }

    public ScheduleProf(Long id,String subject){
        this.id = id;
        this.subject = subject ;
    }
    public ScheduleProf(String subject){
        this.subject = subject ;
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
    public String getSubject(){
        return this.subject;
    }
    public void setSubject(String subject){
        this.subject = subject;
    }
    public LocalDateTime getStartTime(){
        return this.startTime;
    }
    public void setStartTime(LocalDateTime startTime){
        this.startTime = startTime;
    }
    public LocalDateTime getEndTime(){
        return this.endTime;
    }
    public void setEndTime(LocalDateTime endTime){
        this.endTime = endTime;
    }
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupe_etudiant")
    public GroupeEtudiant getGroupeEtudiant(){
        return this.groupeEtudiant;
    }
    public void setGroupeEtudiant(GroupeEtudiant groupeEtudiant){
        this.groupeEtudiant = groupeEtudiant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prof")
    public Prof getProf(){
        return this.prof;
    }
    public void setProf(Prof prof){
        this.prof = prof;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cours")
    public Cours getCours(){
        return this.cours;
    }
    public void setCours(Cours cours){
        this.cours = cours;
    }
    public String getGrpName(){
        return this.grpName;
    }
    public void setGrpName(String grpName){
        this.grpName = grpName;
    }
    public String getProfName(){
        return this.profName;
    }
    public void setProfName(String profName){
        this.profName = profName;
    }
    public Long getProfsId(){
        return this.profsId;
    }
    public void setProfsId(Long profsId){
        this.profsId = profsId;
    }

    @Transient
    public String getLabel() {
        label = subject;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleProf scheduleProf = (ScheduleProf) o;
        return id != null && id.equals(scheduleProf.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

