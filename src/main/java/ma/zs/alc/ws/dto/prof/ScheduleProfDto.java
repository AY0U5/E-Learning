package  ma.zs.alc.ws.dto.prof;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.ws.dto.grpe.GroupeEtudiantDto;
import ma.zs.alc.ws.dto.course.CoursDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScheduleProfDto  extends AuditBaseDto {

    private String subject  ;
    private String startTime ;
    private String endTime ;
    private String ref  ;
    private String grpName  ;
    private String profName  ;
    private Long profsId  ;

    private GroupeEtudiantDto groupeEtudiant ;
    private ProfDto prof ;
    private CoursDto cours ;



    public ScheduleProfDto(){
        super();
    }



    @Log
    public String getSubject(){
        return this.subject;
    }
    public void setSubject(String subject){
        this.subject = subject;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getStartTime(){
        return this.startTime;
    }
    public void setStartTime(String startTime){
        this.startTime = startTime;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getEndTime(){
        return this.endTime;
    }
    public void setEndTime(String endTime){
        this.endTime = endTime;
    }

    @Log
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }

    @Log
    public String getGrpName(){
        return this.grpName;
    }
    public void setGrpName(String grpName){
        this.grpName = grpName;
    }

    @Log
    public String getProfName(){
        return this.profName;
    }
    public void setProfName(String profName){
        this.profName = profName;
    }

    @Log
    public Long getProfsId(){
        return this.profsId;
    }
    public void setProfsId(Long profsId){
        this.profsId = profsId;
    }


    public GroupeEtudiantDto getGroupeEtudiant(){
        return this.groupeEtudiant;
    }

    public void setGroupeEtudiant(GroupeEtudiantDto groupeEtudiant){
        this.groupeEtudiant = groupeEtudiant;
    }
    public ProfDto getProf(){
        return this.prof;
    }

    public void setProf(ProfDto prof){
        this.prof = prof;
    }
    public CoursDto getCours(){
        return this.cours;
    }

    public void setCours(CoursDto cours){
        this.cours = cours;
    }






}
