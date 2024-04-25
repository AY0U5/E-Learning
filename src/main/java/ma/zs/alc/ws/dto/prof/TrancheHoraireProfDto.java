package  ma.zs.alc.ws.dto.prof;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrancheHoraireProfDto  extends AuditBaseDto {

    private String startHour  ;
    private String endHour  ;
    private Integer day  = 0 ;
    private Integer groupIndex  = 0 ;
    private Long profsId  ;

    private ProfDto prof ;



    public TrancheHoraireProfDto(){
        super();
    }



    @Log
    public String getStartHour(){
        return this.startHour;
    }
    public void setStartHour(String startHour){
        this.startHour = startHour;
    }

    @Log
    public String getEndHour(){
        return this.endHour;
    }
    public void setEndHour(String endHour){
        this.endHour = endHour;
    }

    @Log
    public Integer getDay(){
        return this.day;
    }
    public void setDay(Integer day){
        this.day = day;
    }

    @Log
    public Integer getGroupIndex(){
        return this.groupIndex;
    }
    public void setGroupIndex(Integer groupIndex){
        this.groupIndex = groupIndex;
    }

    @Log
    public Long getProfsId(){
        return this.profsId;
    }
    public void setProfsId(Long profsId){
        this.profsId = profsId;
    }


    public ProfDto getProf(){
        return this.prof;
    }

    public void setProf(ProfDto prof){
        this.prof = prof;
    }






}
