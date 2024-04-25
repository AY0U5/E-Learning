package  ma.zs.alc.ws.dto.freetrial;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.ws.dto.grpe.InscriptionDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class FreeTrialformuleDto  extends AuditBaseDto {

    private String code  ;
    private String dayspeerweek  ;
    private String timeperday  ;
    private String teacherGenderoption  ;
    private String teacherAgeRange  ;
    private String teacherPersonnality  ;
    private Boolean status  ;
    private String dateConfirmation ;

    private InscriptionDto inscription ;



    public FreeTrialformuleDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public String getDayspeerweek(){
        return this.dayspeerweek;
    }
    public void setDayspeerweek(String dayspeerweek){
        this.dayspeerweek = dayspeerweek;
    }

    @Log
    public String getTimeperday(){
        return this.timeperday;
    }
    public void setTimeperday(String timeperday){
        this.timeperday = timeperday;
    }

    @Log
    public String getTeacherGenderoption(){
        return this.teacherGenderoption;
    }
    public void setTeacherGenderoption(String teacherGenderoption){
        this.teacherGenderoption = teacherGenderoption;
    }

    @Log
    public String getTeacherAgeRange(){
        return this.teacherAgeRange;
    }
    public void setTeacherAgeRange(String teacherAgeRange){
        this.teacherAgeRange = teacherAgeRange;
    }

    @Log
    public String getTeacherPersonnality(){
        return this.teacherPersonnality;
    }
    public void setTeacherPersonnality(String teacherPersonnality){
        this.teacherPersonnality = teacherPersonnality;
    }

    @Log
    public Boolean getStatus(){
        return this.status;
    }
    public void setStatus(Boolean status){
        this.status = status;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateConfirmation(){
        return this.dateConfirmation;
    }
    public void setDateConfirmation(String dateConfirmation){
        this.dateConfirmation = dateConfirmation;
    }


    public InscriptionDto getInscription(){
        return this.inscription;
    }

    public void setInscription(InscriptionDto inscription){
        this.inscription = inscription;
    }






}
