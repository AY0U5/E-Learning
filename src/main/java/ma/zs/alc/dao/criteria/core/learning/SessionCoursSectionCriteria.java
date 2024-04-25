package  ma.zs.alc.dao.criteria.core.learning;


import ma.zs.alc.dao.criteria.core.course.SectionCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class SessionCoursSectionCriteria extends  BaseCriteria  {


    private SessionCoursCriteria sessionCours ;
    private List<SessionCoursCriteria> sessionCourss ;
    private SectionCriteria section ;
    private List<SectionCriteria> sections ;


    public SessionCoursSectionCriteria(){}


    public SessionCoursCriteria getSessionCours(){
        return this.sessionCours;
    }

    public void setSessionCours(SessionCoursCriteria sessionCours){
        this.sessionCours = sessionCours;
    }
    public List<SessionCoursCriteria> getSessionCourss(){
        return this.sessionCourss;
    }

    public void setSessionCourss(List<SessionCoursCriteria> sessionCourss){
        this.sessionCourss = sessionCourss;
    }
    public SectionCriteria getSection(){
        return this.section;
    }

    public void setSection(SectionCriteria section){
        this.section = section;
    }
    public List<SectionCriteria> getSections(){
        return this.sections;
    }

    public void setSections(List<SectionCriteria> sections){
        this.sections = sections;
    }
}
