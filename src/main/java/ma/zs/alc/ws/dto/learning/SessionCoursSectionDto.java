package  ma.zs.alc.ws.dto.learning;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



import ma.zs.alc.ws.dto.course.SectionDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SessionCoursSectionDto  extends AuditBaseDto {


    private SessionCoursDto sessionCours ;
    private SectionDto section ;



    public SessionCoursSectionDto(){
        super();
    }




    public SessionCoursDto getSessionCours(){
        return this.sessionCours;
    }

    public void setSessionCours(SessionCoursDto sessionCours){
        this.sessionCours = sessionCours;
    }
    public SectionDto getSection(){
        return this.section;
    }

    public void setSection(SectionDto section){
        this.section = section;
    }






}
