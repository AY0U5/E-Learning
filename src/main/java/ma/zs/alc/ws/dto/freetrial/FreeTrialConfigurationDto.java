package  ma.zs.alc.ws.dto.freetrial;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class FreeTrialConfigurationDto  extends AuditBaseDto {

    private String dateApplicationDebut ;
    private String dateApplicationFin ;
    private Integer nombreStudentMax  = 0 ;
    private Integer nombreStudentMin  = 0 ;




    public FreeTrialConfigurationDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateApplicationDebut(){
        return this.dateApplicationDebut;
    }
    public void setDateApplicationDebut(String dateApplicationDebut){
        this.dateApplicationDebut = dateApplicationDebut;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateApplicationFin(){
        return this.dateApplicationFin;
    }
    public void setDateApplicationFin(String dateApplicationFin){
        this.dateApplicationFin = dateApplicationFin;
    }

    @Log
    public Integer getNombreStudentMax(){
        return this.nombreStudentMax;
    }
    public void setNombreStudentMax(Integer nombreStudentMax){
        this.nombreStudentMax = nombreStudentMax;
    }

    @Log
    public Integer getNombreStudentMin(){
        return this.nombreStudentMin;
    }
    public void setNombreStudentMin(Integer nombreStudentMin){
        this.nombreStudentMin = nombreStudentMin;
    }








}
