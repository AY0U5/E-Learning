package  ma.zs.alc.dao.criteria.core.prof;


import ma.zs.alc.dao.criteria.core.grpe.GroupeEtudiantCriteria;
import ma.zs.alc.dao.criteria.core.course.CoursCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ScheduleProfCriteria extends  BaseCriteria  {

    private String subject;
    private String subjectLike;
    private LocalDateTime startTime;
    private LocalDateTime startTimeFrom;
    private LocalDateTime startTimeTo;
    private LocalDateTime endTime;
    private LocalDateTime endTimeFrom;
    private LocalDateTime endTimeTo;
    private String ref;
    private String refLike;
    private String grpName;
    private String grpNameLike;
    private String profName;
    private String profNameLike;
    private String profsId;
    private String profsIdMin;
    private String profsIdMax;

    private GroupeEtudiantCriteria groupeEtudiant ;
    private List<GroupeEtudiantCriteria> groupeEtudiants ;
    private ProfCriteria prof ;
    private List<ProfCriteria> profs ;
    private CoursCriteria cours ;
    private List<CoursCriteria> courss ;


    public ScheduleProfCriteria(){}

    public String getSubject(){
        return this.subject;
    }
    public void setSubject(String subject){
        this.subject = subject;
    }
    public String getSubjectLike(){
        return this.subjectLike;
    }
    public void setSubjectLike(String subjectLike){
        this.subjectLike = subjectLike;
    }

    public LocalDateTime getStartTime(){
        return this.startTime;
    }
    public void setStartTime(LocalDateTime startTime){
        this.startTime = startTime;
    }
    public LocalDateTime getStartTimeFrom(){
        return this.startTimeFrom;
    }
    public void setStartTimeFrom(LocalDateTime startTimeFrom){
        this.startTimeFrom = startTimeFrom;
    }
    public LocalDateTime getStartTimeTo(){
        return this.startTimeTo;
    }
    public void setStartTimeTo(LocalDateTime startTimeTo){
        this.startTimeTo = startTimeTo;
    }
    public LocalDateTime getEndTime(){
        return this.endTime;
    }
    public void setEndTime(LocalDateTime endTime){
        this.endTime = endTime;
    }
    public LocalDateTime getEndTimeFrom(){
        return this.endTimeFrom;
    }
    public void setEndTimeFrom(LocalDateTime endTimeFrom){
        this.endTimeFrom = endTimeFrom;
    }
    public LocalDateTime getEndTimeTo(){
        return this.endTimeTo;
    }
    public void setEndTimeTo(LocalDateTime endTimeTo){
        this.endTimeTo = endTimeTo;
    }
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public String getRefLike(){
        return this.refLike;
    }
    public void setRefLike(String refLike){
        this.refLike = refLike;
    }

    public String getGrpName(){
        return this.grpName;
    }
    public void setGrpName(String grpName){
        this.grpName = grpName;
    }
    public String getGrpNameLike(){
        return this.grpNameLike;
    }
    public void setGrpNameLike(String grpNameLike){
        this.grpNameLike = grpNameLike;
    }

    public String getProfName(){
        return this.profName;
    }
    public void setProfName(String profName){
        this.profName = profName;
    }
    public String getProfNameLike(){
        return this.profNameLike;
    }
    public void setProfNameLike(String profNameLike){
        this.profNameLike = profNameLike;
    }

    public String getProfsId(){
        return this.profsId;
    }
    public void setProfsId(String profsId){
        this.profsId = profsId;
    }   
    public String getProfsIdMin(){
        return this.profsIdMin;
    }
    public void setProfsIdMin(String profsIdMin){
        this.profsIdMin = profsIdMin;
    }
    public String getProfsIdMax(){
        return this.profsIdMax;
    }
    public void setProfsIdMax(String profsIdMax){
        this.profsIdMax = profsIdMax;
    }
      

    public GroupeEtudiantCriteria getGroupeEtudiant(){
        return this.groupeEtudiant;
    }

    public void setGroupeEtudiant(GroupeEtudiantCriteria groupeEtudiant){
        this.groupeEtudiant = groupeEtudiant;
    }
    public List<GroupeEtudiantCriteria> getGroupeEtudiants(){
        return this.groupeEtudiants;
    }

    public void setGroupeEtudiants(List<GroupeEtudiantCriteria> groupeEtudiants){
        this.groupeEtudiants = groupeEtudiants;
    }
    public ProfCriteria getProf(){
        return this.prof;
    }

    public void setProf(ProfCriteria prof){
        this.prof = prof;
    }
    public List<ProfCriteria> getProfs(){
        return this.profs;
    }

    public void setProfs(List<ProfCriteria> profs){
        this.profs = profs;
    }
    public CoursCriteria getCours(){
        return this.cours;
    }

    public void setCours(CoursCriteria cours){
        this.cours = cours;
    }
    public List<CoursCriteria> getCourss(){
        return this.courss;
    }

    public void setCourss(List<CoursCriteria> courss){
        this.courss = courss;
    }
}
