package  ma.zs.alc.dao.criteria.core.prof;



import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class TrancheHoraireProfCriteria extends  BaseCriteria  {

    private String startHour;
    private String startHourLike;
    private String endHour;
    private String endHourLike;
    private String day;
    private String dayMin;
    private String dayMax;
    private String groupIndex;
    private String groupIndexMin;
    private String groupIndexMax;
    private String profsId;
    private String profsIdMin;
    private String profsIdMax;

    private ProfCriteria prof ;
    private List<ProfCriteria> profs ;


    public TrancheHoraireProfCriteria(){}

    public String getStartHour(){
        return this.startHour;
    }
    public void setStartHour(String startHour){
        this.startHour = startHour;
    }
    public String getStartHourLike(){
        return this.startHourLike;
    }
    public void setStartHourLike(String startHourLike){
        this.startHourLike = startHourLike;
    }

    public String getEndHour(){
        return this.endHour;
    }
    public void setEndHour(String endHour){
        this.endHour = endHour;
    }
    public String getEndHourLike(){
        return this.endHourLike;
    }
    public void setEndHourLike(String endHourLike){
        this.endHourLike = endHourLike;
    }

    public String getDay(){
        return this.day;
    }
    public void setDay(String day){
        this.day = day;
    }   
    public String getDayMin(){
        return this.dayMin;
    }
    public void setDayMin(String dayMin){
        this.dayMin = dayMin;
    }
    public String getDayMax(){
        return this.dayMax;
    }
    public void setDayMax(String dayMax){
        this.dayMax = dayMax;
    }
      
    public String getGroupIndex(){
        return this.groupIndex;
    }
    public void setGroupIndex(String groupIndex){
        this.groupIndex = groupIndex;
    }   
    public String getGroupIndexMin(){
        return this.groupIndexMin;
    }
    public void setGroupIndexMin(String groupIndexMin){
        this.groupIndexMin = groupIndexMin;
    }
    public String getGroupIndexMax(){
        return this.groupIndexMax;
    }
    public void setGroupIndexMax(String groupIndexMax){
        this.groupIndexMax = groupIndexMax;
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
}
