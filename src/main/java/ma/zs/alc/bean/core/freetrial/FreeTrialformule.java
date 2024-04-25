package ma.zs.alc.bean.core.freetrial;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.bean.core.grpe.Inscription;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "free_trialformule")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class FreeTrialformule   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String dayspeerweek;
    @Column(length = 500)
    private String timeperday;
    @Column(length = 500)
    private String teacherGenderoption;
    @Column(length = 500)
    private String teacherAgeRange;
    @Column(length = 500)
    private String teacherPersonnality;
    @Column(columnDefinition = "boolean default false")
    private Boolean status = false;
    private LocalDateTime dateConfirmation ;

    private Inscription inscription ;


    public FreeTrialformule(){
        super();
    }

    public FreeTrialformule(Long id){
        this.id = id;
    }

    public FreeTrialformule(Long id,String code){
        this.id = id;
        this.code = code ;
    }
    public FreeTrialformule(String code){
        this.code = code ;
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
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inscription")
    public Inscription getInscription(){
        return this.inscription;
    }
    public void setInscription(Inscription inscription){
        this.inscription = inscription;
    }
    public String getDayspeerweek(){
        return this.dayspeerweek;
    }
    public void setDayspeerweek(String dayspeerweek){
        this.dayspeerweek = dayspeerweek;
    }
    public String getTimeperday(){
        return this.timeperday;
    }
    public void setTimeperday(String timeperday){
        this.timeperday = timeperday;
    }
    public String getTeacherGenderoption(){
        return this.teacherGenderoption;
    }
    public void setTeacherGenderoption(String teacherGenderoption){
        this.teacherGenderoption = teacherGenderoption;
    }
    public String getTeacherAgeRange(){
        return this.teacherAgeRange;
    }
    public void setTeacherAgeRange(String teacherAgeRange){
        this.teacherAgeRange = teacherAgeRange;
    }
    public String getTeacherPersonnality(){
        return this.teacherPersonnality;
    }
    public void setTeacherPersonnality(String teacherPersonnality){
        this.teacherPersonnality = teacherPersonnality;
    }
    public Boolean  getStatus(){
        return this.status;
    }
    public void setStatus(Boolean status){
        this.status = status;
    }
    public LocalDateTime getDateConfirmation(){
        return this.dateConfirmation;
    }
    public void setDateConfirmation(LocalDateTime dateConfirmation){
        this.dateConfirmation = dateConfirmation;
    }

    @Transient
    public String getLabel() {
        label = code;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FreeTrialformule freeTrialformule = (FreeTrialformule) o;
        return id != null && id.equals(freeTrialformule.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

