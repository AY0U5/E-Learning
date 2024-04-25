package  ma.zs.alc.ws.dto.courseref;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zs.alc.ws.dto.course.ParcoursDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class LevelTestConfigurationDto  extends AuditBaseDto {

    private BigDecimal noteMin  ;
    private BigDecimal noteMax  ;

    private ParcoursDto parcours ;



    public LevelTestConfigurationDto(){
        super();
    }



    @Log
    public BigDecimal getNoteMin(){
        return this.noteMin;
    }
    public void setNoteMin(BigDecimal noteMin){
        this.noteMin = noteMin;
    }

    @Log
    public BigDecimal getNoteMax(){
        return this.noteMax;
    }
    public void setNoteMax(BigDecimal noteMax){
        this.noteMax = noteMax;
    }


    public ParcoursDto getParcours(){
        return this.parcours;
    }

    public void setParcours(ParcoursDto parcours){
        this.parcours = parcours;
    }






}
